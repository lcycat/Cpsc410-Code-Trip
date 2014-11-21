// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IBlockAccess, World, Chunk, WorldProvider, 
//            EnumSkyBlock, Block, BlockHalfSlab, Material, 
//            BlockStairs, TileEntity, BiomeGenBase

public class ChunkCache
    implements IBlockAccess
{

    private int field_72818_a;
    private int field_72816_b;
    private Chunk field_72817_c[][];
    private boolean field_72814_d;
    private World field_72815_e;

    public ChunkCache(World p_i3740_1_, int p_i3740_2_, int p_i3740_3_, int p_i3740_4_, int p_i3740_5_, int p_i3740_6_, int p_i3740_7_)
    {
        field_72815_e = p_i3740_1_;
        field_72818_a = p_i3740_2_ >> 4;
        field_72816_b = p_i3740_4_ >> 4;
        int i = p_i3740_5_ >> 4;
        int j = p_i3740_7_ >> 4;
        field_72817_c = new Chunk[(i - field_72818_a) + 1][(j - field_72816_b) + 1];
        field_72814_d = true;
        for(int k = field_72818_a; k <= i; k++)
        {
            for(int l = field_72816_b; l <= j; l++)
            {
                Chunk chunk = p_i3740_1_.func_72964_e(k, l);
                if(chunk == null)
                {
                    continue;
                }
                field_72817_c[k - field_72818_a][l - field_72816_b] = chunk;
                if(!chunk.func_76606_c(p_i3740_3_, p_i3740_6_))
                {
                    field_72814_d = false;
                }
            }

        }

    }

    public boolean func_72806_N()
    {
        return field_72814_d;
    }

    public int func_72798_a(int p_72798_1_, int p_72798_2_, int p_72798_3_)
    {
        if(p_72798_2_ < 0)
        {
            return 0;
        }
        if(p_72798_2_ >= 256)
        {
            return 0;
        }
        int i = (p_72798_1_ >> 4) - field_72818_a;
        int j = (p_72798_3_ >> 4) - field_72816_b;
        if(i < 0 || i >= field_72817_c.length || j < 0 || j >= field_72817_c[i].length)
        {
            return 0;
        }
        Chunk chunk = field_72817_c[i][j];
        if(chunk == null)
        {
            return 0;
        } else
        {
            return chunk.func_76610_a(p_72798_1_ & 0xf, p_72798_2_, p_72798_3_ & 0xf);
        }
    }

    public TileEntity func_72796_p(int p_72796_1_, int p_72796_2_, int p_72796_3_)
    {
        int i = (p_72796_1_ >> 4) - field_72818_a;
        int j = (p_72796_3_ >> 4) - field_72816_b;
        return field_72817_c[i][j].func_76597_e(p_72796_1_ & 0xf, p_72796_2_, p_72796_3_ & 0xf);
    }

    public float func_72808_j(int p_72808_1_, int p_72808_2_, int p_72808_3_, int p_72808_4_)
    {
        int i = func_72811_b(p_72808_1_, p_72808_2_, p_72808_3_);
        if(i < p_72808_4_)
        {
            i = p_72808_4_;
        }
        return field_72815_e.field_73011_w.field_76573_f[i];
    }

    public int func_72802_i(int p_72802_1_, int p_72802_2_, int p_72802_3_, int p_72802_4_)
    {
        int i = func_72810_a(EnumSkyBlock.Sky, p_72802_1_, p_72802_2_, p_72802_3_);
        int j = func_72810_a(EnumSkyBlock.Block, p_72802_1_, p_72802_2_, p_72802_3_);
        if(j < p_72802_4_)
        {
            j = p_72802_4_;
        }
        return i << 20 | j << 4;
    }

    public float func_72801_o(int p_72801_1_, int p_72801_2_, int p_72801_3_)
    {
        return field_72815_e.field_73011_w.field_76573_f[func_72811_b(p_72801_1_, p_72801_2_, p_72801_3_)];
    }

    public int func_72811_b(int p_72811_1_, int p_72811_2_, int p_72811_3_)
    {
        return func_72813_a(p_72811_1_, p_72811_2_, p_72811_3_, true);
    }

    public int func_72813_a(int p_72813_1_, int p_72813_2_, int p_72813_3_, boolean p_72813_4_)
    {
        if(p_72813_1_ < 0xfe363c80 || p_72813_3_ < 0xfe363c80 || p_72813_1_ >= 0x1c9c380 || p_72813_3_ > 0x1c9c380)
        {
            return 15;
        }
        if(p_72813_4_)
        {
            int i = func_72798_a(p_72813_1_, p_72813_2_, p_72813_3_);
            if(i == Block.field_72079_ak.field_71990_ca || i == Block.field_72092_bO.field_71990_ca || i == Block.field_72050_aA.field_71990_ca || i == Block.field_72063_at.field_71990_ca || i == Block.field_72057_aH.field_71990_ca)
            {
                int l = func_72813_a(p_72813_1_, p_72813_2_ + 1, p_72813_3_, false);
                int j1 = func_72813_a(p_72813_1_ + 1, p_72813_2_, p_72813_3_, false);
                int k1 = func_72813_a(p_72813_1_ - 1, p_72813_2_, p_72813_3_, false);
                int l1 = func_72813_a(p_72813_1_, p_72813_2_, p_72813_3_ + 1, false);
                int i2 = func_72813_a(p_72813_1_, p_72813_2_, p_72813_3_ - 1, false);
                if(j1 > l)
                {
                    l = j1;
                }
                if(k1 > l)
                {
                    l = k1;
                }
                if(l1 > l)
                {
                    l = l1;
                }
                if(i2 > l)
                {
                    l = i2;
                }
                return l;
            }
        }
        if(p_72813_2_ < 0)
        {
            return 0;
        }
        if(p_72813_2_ >= 256)
        {
            int j = 15 - field_72815_e.field_73008_k;
            if(j < 0)
            {
                j = 0;
            }
            return j;
        } else
        {
            int k = (p_72813_1_ >> 4) - field_72818_a;
            int i1 = (p_72813_3_ >> 4) - field_72816_b;
            return field_72817_c[k][i1].func_76629_c(p_72813_1_ & 0xf, p_72813_2_, p_72813_3_ & 0xf, field_72815_e.field_73008_k);
        }
    }

    public int func_72805_g(int p_72805_1_, int p_72805_2_, int p_72805_3_)
    {
        if(p_72805_2_ < 0)
        {
            return 0;
        }
        if(p_72805_2_ >= 256)
        {
            return 0;
        } else
        {
            int i = (p_72805_1_ >> 4) - field_72818_a;
            int j = (p_72805_3_ >> 4) - field_72816_b;
            return field_72817_c[i][j].func_76628_c(p_72805_1_ & 0xf, p_72805_2_, p_72805_3_ & 0xf);
        }
    }

    public Material func_72803_f(int p_72803_1_, int p_72803_2_, int p_72803_3_)
    {
        int i = func_72798_a(p_72803_1_, p_72803_2_, p_72803_3_);
        if(i == 0)
        {
            return Material.field_76249_a;
        } else
        {
            return Block.field_71973_m[i].field_72018_cp;
        }
    }

    public BiomeGenBase func_72807_a(int p_72807_1_, int p_72807_2_)
    {
        return field_72815_e.func_72807_a(p_72807_1_, p_72807_2_);
    }

    public boolean func_72804_r(int p_72804_1_, int p_72804_2_, int p_72804_3_)
    {
        Block block = Block.field_71973_m[func_72798_a(p_72804_1_, p_72804_2_, p_72804_3_)];
        if(block == null)
        {
            return false;
        } else
        {
            return block.func_71926_d();
        }
    }

    public boolean func_72809_s(int p_72809_1_, int p_72809_2_, int p_72809_3_)
    {
        Block block = Block.field_71973_m[func_72798_a(p_72809_1_, p_72809_2_, p_72809_3_)];
        if(block == null)
        {
            return false;
        } else
        {
            return block.field_72018_cp.func_76230_c() && block.func_71886_c();
        }
    }

    public boolean func_72797_t(int p_72797_1_, int p_72797_2_, int p_72797_3_)
    {
        Block block = Block.field_71973_m[func_72798_a(p_72797_1_, p_72797_2_, p_72797_3_)];
        if(block == null)
        {
            return false;
        }
        if(block.field_72018_cp.func_76218_k() && block.func_71886_c())
        {
            return true;
        }
        if(block instanceof BlockStairs)
        {
            return (func_72805_g(p_72797_1_, p_72797_2_, p_72797_3_) & 4) == 4;
        }
        if(block instanceof BlockHalfSlab)
        {
            return (func_72805_g(p_72797_1_, p_72797_2_, p_72797_3_) & 8) == 8;
        } else
        {
            return false;
        }
    }

    public boolean func_72799_c(int p_72799_1_, int p_72799_2_, int p_72799_3_)
    {
        Block block = Block.field_71973_m[func_72798_a(p_72799_1_, p_72799_2_, p_72799_3_)];
        return block == null;
    }

    public int func_72810_a(EnumSkyBlock p_72810_1_, int p_72810_2_, int p_72810_3_, int p_72810_4_)
    {
        if(p_72810_3_ < 0)
        {
            p_72810_3_ = 0;
        }
        if(p_72810_3_ >= 256)
        {
            p_72810_3_ = 255;
        }
        if(p_72810_3_ < 0 || p_72810_3_ >= 256 || p_72810_2_ < 0xfe363c80 || p_72810_4_ < 0xfe363c80 || p_72810_2_ >= 0x1c9c380 || p_72810_4_ > 0x1c9c380)
        {
            return p_72810_1_.field_77198_c;
        }
        if(Block.field_71982_s[func_72798_a(p_72810_2_, p_72810_3_, p_72810_4_)])
        {
            int i = func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_ + 1, p_72810_4_);
            int k = func_72812_b(p_72810_1_, p_72810_2_ + 1, p_72810_3_, p_72810_4_);
            int i1 = func_72812_b(p_72810_1_, p_72810_2_ - 1, p_72810_3_, p_72810_4_);
            int j1 = func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_, p_72810_4_ + 1);
            int k1 = func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_, p_72810_4_ - 1);
            if(k > i)
            {
                i = k;
            }
            if(i1 > i)
            {
                i = i1;
            }
            if(j1 > i)
            {
                i = j1;
            }
            if(k1 > i)
            {
                i = k1;
            }
            return i;
        } else
        {
            int j = (p_72810_2_ >> 4) - field_72818_a;
            int l = (p_72810_4_ >> 4) - field_72816_b;
            return field_72817_c[j][l].func_76614_a(p_72810_1_, p_72810_2_ & 0xf, p_72810_3_, p_72810_4_ & 0xf);
        }
    }

    public int func_72812_b(EnumSkyBlock p_72812_1_, int p_72812_2_, int p_72812_3_, int p_72812_4_)
    {
        if(p_72812_3_ < 0)
        {
            p_72812_3_ = 0;
        }
        if(p_72812_3_ >= 256)
        {
            p_72812_3_ = 255;
        }
        if(p_72812_3_ < 0 || p_72812_3_ >= 256 || p_72812_2_ < 0xfe363c80 || p_72812_4_ < 0xfe363c80 || p_72812_2_ >= 0x1c9c380 || p_72812_4_ > 0x1c9c380)
        {
            return p_72812_1_.field_77198_c;
        } else
        {
            int i = (p_72812_2_ >> 4) - field_72818_a;
            int j = (p_72812_4_ >> 4) - field_72816_b;
            return field_72817_c[i][j].func_76614_a(p_72812_1_, p_72812_2_ & 0xf, p_72812_3_, p_72812_4_ & 0xf);
        }
    }

    public int func_72800_K()
    {
        return 256;
    }
}
