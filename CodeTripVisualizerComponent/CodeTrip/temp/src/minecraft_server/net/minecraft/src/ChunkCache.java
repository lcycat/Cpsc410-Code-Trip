// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IBlockAccess, World, Chunk, Material, 
//            Block, TileEntity

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
}
