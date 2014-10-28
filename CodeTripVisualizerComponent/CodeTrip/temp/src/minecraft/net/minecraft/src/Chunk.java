// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ExtendedBlockStorage, World, Block, WorldProvider, 
//            Profiler, EnumSkyBlock, BlockContainer, TileEntity, 
//            Entity, MathHelper, ChunkPosition, AxisAlignedBB, 
//            IChunkProvider, Material, ChunkCoordIntPair, NibbleArray, 
//            WorldChunkManager, BiomeGenBase

public class Chunk
{

    public static boolean field_76640_a;
    private ExtendedBlockStorage field_76652_q[];
    private byte field_76651_r[];
    public int field_76638_b[];
    public boolean field_76639_c[];
    public boolean field_76636_d;
    public World field_76637_e;
    public int field_76634_f[];
    public final int field_76635_g;
    public final int field_76647_h;
    private boolean field_76650_s;
    public Map field_76648_i;
    public List field_76645_j[];
    public boolean field_76646_k;
    public boolean field_76643_l;
    public boolean field_76644_m;
    public long field_76641_n;
    public boolean field_76642_o;
    private int field_76649_t;
    boolean field_76653_p;

    public Chunk(World p_i3771_1_, int p_i3771_2_, int p_i3771_3_)
    {
        field_76652_q = new ExtendedBlockStorage[16];
        field_76651_r = new byte[256];
        field_76638_b = new int[256];
        field_76639_c = new boolean[256];
        field_76650_s = false;
        field_76648_i = new HashMap();
        field_76646_k = false;
        field_76643_l = false;
        field_76644_m = false;
        field_76641_n = 0L;
        field_76642_o = false;
        field_76649_t = 4096;
        field_76653_p = false;
        field_76645_j = new List[16];
        field_76637_e = p_i3771_1_;
        field_76635_g = p_i3771_2_;
        field_76647_h = p_i3771_3_;
        field_76634_f = new int[256];
        for(int i = 0; i < field_76645_j.length; i++)
        {
            field_76645_j[i] = new ArrayList();
        }

        Arrays.fill(field_76638_b, -999);
        Arrays.fill(field_76651_r, (byte)-1);
    }

    public Chunk(World p_i3772_1_, byte p_i3772_2_[], int p_i3772_3_, int p_i3772_4_)
    {
        this(p_i3772_1_, p_i3772_3_, p_i3772_4_);
        int i = p_i3772_2_.length / 256;
        for(int j = 0; j < 16; j++)
        {
            for(int k = 0; k < 16; k++)
            {
                for(int l = 0; l < i; l++)
                {
                    int i1 = p_i3772_2_[j << 11 | k << 7 | l] & 0xff;
                    if(i1 == 0)
                    {
                        continue;
                    }
                    int j1 = l >> 4;
                    if(field_76652_q[j1] == null)
                    {
                        field_76652_q[j1] = new ExtendedBlockStorage(j1 << 4);
                    }
                    field_76652_q[j1].func_76655_a(j, l & 0xf, k, i1);
                }

            }

        }

    }

    public boolean func_76600_a(int p_76600_1_, int p_76600_2_)
    {
        return p_76600_1_ == field_76635_g && p_76600_2_ == field_76647_h;
    }

    public int func_76611_b(int p_76611_1_, int p_76611_2_)
    {
        return field_76634_f[p_76611_2_ << 4 | p_76611_1_];
    }

    public int func_76625_h()
    {
        for(int i = field_76652_q.length - 1; i >= 0; i--)
        {
            if(field_76652_q[i] != null)
            {
                return field_76652_q[i].func_76662_d();
            }
        }

        return 0;
    }

    public ExtendedBlockStorage[] func_76587_i()
    {
        return field_76652_q;
    }

    public void func_76590_a()
    {
        int i = func_76625_h();
        for(int j = 0; j < 16; j++)
        {
label0:
            for(int k = 0; k < 16; k++)
            {
                field_76638_b[j + (k << 4)] = -999;
                int l = (i + 16) - 1;
                do
                {
                    if(l <= 0)
                    {
                        continue label0;
                    }
                    int i1 = func_76610_a(j, l - 1, k);
                    if(Block.field_71971_o[i1] != 0)
                    {
                        field_76634_f[k << 4 | j] = l;
                        continue label0;
                    }
                    l--;
                } while(true);
            }

        }

        field_76643_l = true;
    }

    public void func_76603_b()
    {
        int i = func_76625_h();
        for(int j = 0; j < 16; j++)
        {
            for(int l = 0; l < 16; l++)
            {
                field_76638_b[j + (l << 4)] = -999;
                int j1 = (i + 16) - 1;
                do
                {
                    if(j1 <= 0)
                    {
                        break;
                    }
                    if(func_76596_b(j, j1 - 1, l) != 0)
                    {
                        field_76634_f[l << 4 | j] = j1;
                        break;
                    }
                    j1--;
                } while(true);
                if(field_76637_e.field_73011_w.field_76576_e)
                {
                    continue;
                }
                j1 = 15;
                int k1 = (i + 16) - 1;
                do
                {
                    j1 -= func_76596_b(j, k1, l);
                    if(j1 > 0)
                    {
                        ExtendedBlockStorage extendedblockstorage = field_76652_q[k1 >> 4];
                        if(extendedblockstorage != null)
                        {
                            extendedblockstorage.func_76657_c(j, k1 & 0xf, l, j1);
                            field_76637_e.func_72902_n((field_76635_g << 4) + j, k1, (field_76647_h << 4) + l);
                        }
                    }
                } while(--k1 > 0 && j1 > 0);
            }

        }

        field_76643_l = true;
        for(int k = 0; k < 16; k++)
        {
            for(int i1 = 0; i1 < 16; i1++)
            {
                func_76595_e(k, i1);
            }

        }

    }

    private void func_76595_e(int p_76595_1_, int p_76595_2_)
    {
        field_76639_c[p_76595_1_ + p_76595_2_ * 16] = true;
        field_76650_s = true;
    }

    private void func_76593_q()
    {
        field_76637_e.field_72984_F.func_76320_a("recheckGaps");
        if(field_76637_e.func_72873_a(field_76635_g * 16 + 8, 0, field_76647_h * 16 + 8, 16))
        {
            for(int i = 0; i < 16; i++)
            {
                for(int j = 0; j < 16; j++)
                {
                    if(!field_76639_c[i + j * 16])
                    {
                        continue;
                    }
                    field_76639_c[i + j * 16] = false;
                    int k = func_76611_b(i, j);
                    int l = field_76635_g * 16 + i;
                    int i1 = field_76647_h * 16 + j;
                    int j1 = field_76637_e.func_72976_f(l - 1, i1);
                    int k1 = field_76637_e.func_72976_f(l + 1, i1);
                    int l1 = field_76637_e.func_72976_f(l, i1 - 1);
                    int i2 = field_76637_e.func_72976_f(l, i1 + 1);
                    if(k1 < j1)
                    {
                        j1 = k1;
                    }
                    if(l1 < j1)
                    {
                        j1 = l1;
                    }
                    if(i2 < j1)
                    {
                        j1 = i2;
                    }
                    func_76599_g(l, i1, j1);
                    func_76599_g(l - 1, i1, k);
                    func_76599_g(l + 1, i1, k);
                    func_76599_g(l, i1 - 1, k);
                    func_76599_g(l, i1 + 1, k);
                }

            }

            field_76650_s = false;
        }
        field_76637_e.field_72984_F.func_76319_b();
    }

    private void func_76599_g(int p_76599_1_, int p_76599_2_, int p_76599_3_)
    {
        int i = field_76637_e.func_72976_f(p_76599_1_, p_76599_2_);
        if(i > p_76599_3_)
        {
            func_76609_d(p_76599_1_, p_76599_2_, p_76599_3_, i + 1);
        } else
        if(i < p_76599_3_)
        {
            func_76609_d(p_76599_1_, p_76599_2_, i, p_76599_3_ + 1);
        }
    }

    private void func_76609_d(int p_76609_1_, int p_76609_2_, int p_76609_3_, int p_76609_4_)
    {
        if(p_76609_4_ > p_76609_3_ && field_76637_e.func_72873_a(p_76609_1_, 0, p_76609_2_, 16))
        {
            for(int i = p_76609_3_; i < p_76609_4_; i++)
            {
                field_76637_e.func_72936_c(EnumSkyBlock.Sky, p_76609_1_, i, p_76609_2_);
            }

            field_76643_l = true;
        }
    }

    private void func_76615_h(int p_76615_1_, int p_76615_2_, int p_76615_3_)
    {
        int i = field_76634_f[p_76615_3_ << 4 | p_76615_1_] & 0xff;
        int j = i;
        if(p_76615_2_ > i)
        {
            j = p_76615_2_;
        }
        for(; j > 0 && func_76596_b(p_76615_1_, j - 1, p_76615_3_) == 0; j--) { }
        if(j == i)
        {
            return;
        }
        field_76637_e.func_72975_g(p_76615_1_, p_76615_3_, j, i);
        field_76634_f[p_76615_3_ << 4 | p_76615_1_] = j;
        int k = field_76635_g * 16 + p_76615_1_;
        int l = field_76647_h * 16 + p_76615_3_;
        if(!field_76637_e.field_73011_w.field_76576_e)
        {
            if(j < i)
            {
                for(int i1 = j; i1 < i; i1++)
                {
                    ExtendedBlockStorage extendedblockstorage = field_76652_q[i1 >> 4];
                    if(extendedblockstorage != null)
                    {
                        extendedblockstorage.func_76657_c(p_76615_1_, i1 & 0xf, p_76615_3_, 15);
                        field_76637_e.func_72902_n((field_76635_g << 4) + p_76615_1_, i1, (field_76647_h << 4) + p_76615_3_);
                    }
                }

            } else
            {
                for(int j1 = i; j1 < j; j1++)
                {
                    ExtendedBlockStorage extendedblockstorage1 = field_76652_q[j1 >> 4];
                    if(extendedblockstorage1 != null)
                    {
                        extendedblockstorage1.func_76657_c(p_76615_1_, j1 & 0xf, p_76615_3_, 0);
                        field_76637_e.func_72902_n((field_76635_g << 4) + p_76615_1_, j1, (field_76647_h << 4) + p_76615_3_);
                    }
                }

            }
            int k1 = 15;
            do
            {
                if(j <= 0 || k1 <= 0)
                {
                    break;
                }
                j--;
                int i2 = func_76596_b(p_76615_1_, j, p_76615_3_);
                if(i2 == 0)
                {
                    i2 = 1;
                }
                k1 -= i2;
                if(k1 < 0)
                {
                    k1 = 0;
                }
                ExtendedBlockStorage extendedblockstorage2 = field_76652_q[j >> 4];
                if(extendedblockstorage2 != null)
                {
                    extendedblockstorage2.func_76657_c(p_76615_1_, j & 0xf, p_76615_3_, k1);
                }
            } while(true);
        }
        int l1 = field_76634_f[p_76615_3_ << 4 | p_76615_1_];
        int j2 = i;
        int k2 = l1;
        if(k2 < j2)
        {
            int l2 = j2;
            j2 = k2;
            k2 = l2;
        }
        if(!field_76637_e.field_73011_w.field_76576_e)
        {
            func_76609_d(k - 1, l, j2, k2);
            func_76609_d(k + 1, l, j2, k2);
            func_76609_d(k, l - 1, j2, k2);
            func_76609_d(k, l + 1, j2, k2);
            func_76609_d(k, l, j2, k2);
        }
        field_76643_l = true;
    }

    public int func_76596_b(int p_76596_1_, int p_76596_2_, int p_76596_3_)
    {
        return Block.field_71971_o[func_76610_a(p_76596_1_, p_76596_2_, p_76596_3_)];
    }

    public int func_76610_a(int p_76610_1_, int p_76610_2_, int p_76610_3_)
    {
        if(p_76610_2_ >> 4 >= field_76652_q.length)
        {
            return 0;
        }
        ExtendedBlockStorage extendedblockstorage = field_76652_q[p_76610_2_ >> 4];
        if(extendedblockstorage != null)
        {
            return extendedblockstorage.func_76656_a(p_76610_1_, p_76610_2_ & 0xf, p_76610_3_);
        } else
        {
            return 0;
        }
    }

    public int func_76628_c(int p_76628_1_, int p_76628_2_, int p_76628_3_)
    {
        if(p_76628_2_ >> 4 >= field_76652_q.length)
        {
            return 0;
        }
        ExtendedBlockStorage extendedblockstorage = field_76652_q[p_76628_2_ >> 4];
        if(extendedblockstorage != null)
        {
            return extendedblockstorage.func_76665_b(p_76628_1_, p_76628_2_ & 0xf, p_76628_3_);
        } else
        {
            return 0;
        }
    }

    public boolean func_76598_a(int p_76598_1_, int p_76598_2_, int p_76598_3_, int p_76598_4_)
    {
        return func_76592_a(p_76598_1_, p_76598_2_, p_76598_3_, p_76598_4_, 0);
    }

    public boolean func_76592_a(int p_76592_1_, int p_76592_2_, int p_76592_3_, int p_76592_4_, int p_76592_5_)
    {
        int i = p_76592_3_ << 4 | p_76592_1_;
        if(p_76592_2_ >= field_76638_b[i] - 1)
        {
            field_76638_b[i] = -999;
        }
        int j = field_76634_f[i];
        int k = func_76610_a(p_76592_1_, p_76592_2_, p_76592_3_);
        int l = func_76628_c(p_76592_1_, p_76592_2_, p_76592_3_);
        if(k == p_76592_4_ && l == p_76592_5_)
        {
            return false;
        }
        ExtendedBlockStorage extendedblockstorage = field_76652_q[p_76592_2_ >> 4];
        boolean flag = false;
        if(extendedblockstorage == null)
        {
            if(p_76592_4_ == 0)
            {
                return false;
            }
            extendedblockstorage = field_76652_q[p_76592_2_ >> 4] = new ExtendedBlockStorage((p_76592_2_ >> 4) << 4);
            flag = p_76592_2_ >= j;
        }
        int i1 = field_76635_g * 16 + p_76592_1_;
        int j1 = field_76647_h * 16 + p_76592_3_;
        if(k != 0 && !field_76637_e.field_72995_K)
        {
            Block.field_71973_m[k].func_71927_h(field_76637_e, i1, p_76592_2_, j1, l);
        }
        extendedblockstorage.func_76655_a(p_76592_1_, p_76592_2_ & 0xf, p_76592_3_, p_76592_4_);
        if(k != 0)
        {
            if(!field_76637_e.field_72995_K)
            {
                Block.field_71973_m[k].func_71852_a(field_76637_e, i1, p_76592_2_, j1, k, l);
            } else
            if((Block.field_71973_m[k] instanceof BlockContainer) && k != p_76592_4_)
            {
                field_76637_e.func_72932_q(i1, p_76592_2_, j1);
            }
        }
        if(extendedblockstorage.func_76656_a(p_76592_1_, p_76592_2_ & 0xf, p_76592_3_) != p_76592_4_)
        {
            return false;
        }
        extendedblockstorage.func_76654_b(p_76592_1_, p_76592_2_ & 0xf, p_76592_3_, p_76592_5_);
        if(flag)
        {
            func_76603_b();
        } else
        {
            if(Block.field_71971_o[p_76592_4_ & 0xfff] > 0)
            {
                if(p_76592_2_ >= j)
                {
                    func_76615_h(p_76592_1_, p_76592_2_ + 1, p_76592_3_);
                }
            } else
            if(p_76592_2_ == j - 1)
            {
                func_76615_h(p_76592_1_, p_76592_2_, p_76592_3_);
            }
            func_76595_e(p_76592_1_, p_76592_3_);
        }
        if(p_76592_4_ != 0)
        {
            if(!field_76637_e.field_72995_K)
            {
                Block.field_71973_m[p_76592_4_].func_71861_g(field_76637_e, i1, p_76592_2_, j1);
            }
            if(Block.field_71973_m[p_76592_4_] instanceof BlockContainer)
            {
                TileEntity tileentity = func_76597_e(p_76592_1_, p_76592_2_, p_76592_3_);
                if(tileentity == null)
                {
                    tileentity = ((BlockContainer)Block.field_71973_m[p_76592_4_]).func_72274_a(field_76637_e);
                    field_76637_e.func_72837_a(i1, p_76592_2_, j1, tileentity);
                }
                if(tileentity != null)
                {
                    tileentity.func_70321_h();
                }
            }
        } else
        if(k > 0 && (Block.field_71973_m[k] instanceof BlockContainer))
        {
            TileEntity tileentity1 = func_76597_e(p_76592_1_, p_76592_2_, p_76592_3_);
            if(tileentity1 != null)
            {
                tileentity1.func_70321_h();
            }
        }
        field_76643_l = true;
        return true;
    }

    public boolean func_76589_b(int p_76589_1_, int p_76589_2_, int p_76589_3_, int p_76589_4_)
    {
        ExtendedBlockStorage extendedblockstorage = field_76652_q[p_76589_2_ >> 4];
        if(extendedblockstorage == null)
        {
            return false;
        }
        int i = extendedblockstorage.func_76665_b(p_76589_1_, p_76589_2_ & 0xf, p_76589_3_);
        if(i == p_76589_4_)
        {
            return false;
        }
        field_76643_l = true;
        extendedblockstorage.func_76654_b(p_76589_1_, p_76589_2_ & 0xf, p_76589_3_, p_76589_4_);
        int j = extendedblockstorage.func_76656_a(p_76589_1_, p_76589_2_ & 0xf, p_76589_3_);
        if(j > 0 && (Block.field_71973_m[j] instanceof BlockContainer))
        {
            TileEntity tileentity = func_76597_e(p_76589_1_, p_76589_2_, p_76589_3_);
            if(tileentity != null)
            {
                tileentity.func_70321_h();
                tileentity.field_70325_p = p_76589_4_;
            }
        }
        return true;
    }

    public int func_76614_a(EnumSkyBlock p_76614_1_, int p_76614_2_, int p_76614_3_, int p_76614_4_)
    {
        ExtendedBlockStorage extendedblockstorage = field_76652_q[p_76614_3_ >> 4];
        if(extendedblockstorage == null)
        {
            if(func_76619_d(p_76614_2_, p_76614_3_, p_76614_4_))
            {
                return p_76614_1_.field_77198_c;
            } else
            {
                return 0;
            }
        }
        if(p_76614_1_ == EnumSkyBlock.Sky)
        {
            return extendedblockstorage.func_76670_c(p_76614_2_, p_76614_3_ & 0xf, p_76614_4_);
        }
        if(p_76614_1_ == EnumSkyBlock.Block)
        {
            return extendedblockstorage.func_76674_d(p_76614_2_, p_76614_3_ & 0xf, p_76614_4_);
        } else
        {
            return p_76614_1_.field_77198_c;
        }
    }

    public void func_76633_a(EnumSkyBlock p_76633_1_, int p_76633_2_, int p_76633_3_, int p_76633_4_, int p_76633_5_)
    {
        ExtendedBlockStorage extendedblockstorage = field_76652_q[p_76633_3_ >> 4];
        if(extendedblockstorage == null)
        {
            extendedblockstorage = field_76652_q[p_76633_3_ >> 4] = new ExtendedBlockStorage((p_76633_3_ >> 4) << 4);
            func_76603_b();
        }
        field_76643_l = true;
        if(p_76633_1_ == EnumSkyBlock.Sky)
        {
            if(!field_76637_e.field_73011_w.field_76576_e)
            {
                extendedblockstorage.func_76657_c(p_76633_2_, p_76633_3_ & 0xf, p_76633_4_, p_76633_5_);
            }
        } else
        if(p_76633_1_ == EnumSkyBlock.Block)
        {
            extendedblockstorage.func_76677_d(p_76633_2_, p_76633_3_ & 0xf, p_76633_4_, p_76633_5_);
        }
    }

    public int func_76629_c(int p_76629_1_, int p_76629_2_, int p_76629_3_, int p_76629_4_)
    {
        ExtendedBlockStorage extendedblockstorage = field_76652_q[p_76629_2_ >> 4];
        if(extendedblockstorage == null)
        {
            if(!field_76637_e.field_73011_w.field_76576_e && p_76629_4_ < EnumSkyBlock.Sky.field_77198_c)
            {
                return EnumSkyBlock.Sky.field_77198_c - p_76629_4_;
            } else
            {
                return 0;
            }
        }
        int i = field_76637_e.field_73011_w.field_76576_e ? 0 : extendedblockstorage.func_76670_c(p_76629_1_, p_76629_2_ & 0xf, p_76629_3_);
        if(i > 0)
        {
            field_76640_a = true;
        }
        i -= p_76629_4_;
        int j = extendedblockstorage.func_76674_d(p_76629_1_, p_76629_2_ & 0xf, p_76629_3_);
        if(j > i)
        {
            i = j;
        }
        return i;
    }

    public void func_76612_a(Entity p_76612_1_)
    {
        field_76644_m = true;
        int i = MathHelper.func_76128_c(p_76612_1_.field_70165_t / 16D);
        int j = MathHelper.func_76128_c(p_76612_1_.field_70161_v / 16D);
        if(i != field_76635_g || j != field_76647_h)
        {
            System.out.println((new StringBuilder()).append("Wrong location! ").append(p_76612_1_).toString());
            Thread.dumpStack();
        }
        int k = MathHelper.func_76128_c(p_76612_1_.field_70163_u / 16D);
        if(k < 0)
        {
            k = 0;
        }
        if(k >= field_76645_j.length)
        {
            k = field_76645_j.length - 1;
        }
        p_76612_1_.field_70175_ag = true;
        p_76612_1_.field_70176_ah = field_76635_g;
        p_76612_1_.field_70162_ai = k;
        p_76612_1_.field_70164_aj = field_76647_h;
        field_76645_j[k].add(p_76612_1_);
    }

    public void func_76622_b(Entity p_76622_1_)
    {
        func_76608_a(p_76622_1_, p_76622_1_.field_70162_ai);
    }

    public void func_76608_a(Entity p_76608_1_, int p_76608_2_)
    {
        if(p_76608_2_ < 0)
        {
            p_76608_2_ = 0;
        }
        if(p_76608_2_ >= field_76645_j.length)
        {
            p_76608_2_ = field_76645_j.length - 1;
        }
        field_76645_j[p_76608_2_].remove(p_76608_1_);
    }

    public boolean func_76619_d(int p_76619_1_, int p_76619_2_, int p_76619_3_)
    {
        return p_76619_2_ >= field_76634_f[p_76619_3_ << 4 | p_76619_1_];
    }

    public TileEntity func_76597_e(int p_76597_1_, int p_76597_2_, int p_76597_3_)
    {
        ChunkPosition chunkposition = new ChunkPosition(p_76597_1_, p_76597_2_, p_76597_3_);
        TileEntity tileentity = (TileEntity)field_76648_i.get(chunkposition);
        if(tileentity == null)
        {
            int i = func_76610_a(p_76597_1_, p_76597_2_, p_76597_3_);
            if(i <= 0 || !Block.field_71973_m[i].func_71887_s())
            {
                return null;
            }
            if(tileentity == null)
            {
                tileentity = ((BlockContainer)Block.field_71973_m[i]).func_72274_a(field_76637_e);
                field_76637_e.func_72837_a(field_76635_g * 16 + p_76597_1_, p_76597_2_, field_76647_h * 16 + p_76597_3_, tileentity);
            }
            tileentity = (TileEntity)field_76648_i.get(chunkposition);
        }
        if(tileentity != null && tileentity.func_70320_p())
        {
            field_76648_i.remove(chunkposition);
            return null;
        } else
        {
            return tileentity;
        }
    }

    public void func_76620_a(TileEntity p_76620_1_)
    {
        int i = p_76620_1_.field_70329_l - field_76635_g * 16;
        int j = p_76620_1_.field_70330_m;
        int k = p_76620_1_.field_70327_n - field_76647_h * 16;
        func_76604_a(i, j, k, p_76620_1_);
        if(field_76636_d)
        {
            field_76637_e.field_73009_h.add(p_76620_1_);
        }
    }

    public void func_76604_a(int p_76604_1_, int p_76604_2_, int p_76604_3_, TileEntity p_76604_4_)
    {
        ChunkPosition chunkposition = new ChunkPosition(p_76604_1_, p_76604_2_, p_76604_3_);
        p_76604_4_.func_70308_a(field_76637_e);
        p_76604_4_.field_70329_l = field_76635_g * 16 + p_76604_1_;
        p_76604_4_.field_70330_m = p_76604_2_;
        p_76604_4_.field_70327_n = field_76647_h * 16 + p_76604_3_;
        if(func_76610_a(p_76604_1_, p_76604_2_, p_76604_3_) == 0 || !(Block.field_71973_m[func_76610_a(p_76604_1_, p_76604_2_, p_76604_3_)] instanceof BlockContainer))
        {
            return;
        } else
        {
            p_76604_4_.func_70312_q();
            field_76648_i.put(chunkposition, p_76604_4_);
            return;
        }
    }

    public void func_76627_f(int p_76627_1_, int p_76627_2_, int p_76627_3_)
    {
        ChunkPosition chunkposition = new ChunkPosition(p_76627_1_, p_76627_2_, p_76627_3_);
        if(field_76636_d)
        {
            TileEntity tileentity = (TileEntity)field_76648_i.remove(chunkposition);
            if(tileentity != null)
            {
                tileentity.func_70313_j();
            }
        }
    }

    public void func_76631_c()
    {
        field_76636_d = true;
        field_76637_e.func_72852_a(field_76648_i.values());
        List alist[] = field_76645_j;
        int i = alist.length;
        for(int j = 0; j < i; j++)
        {
            List list = alist[j];
            field_76637_e.func_72868_a(list);
        }

    }

    public void func_76623_d()
    {
        field_76636_d = false;
        TileEntity tileentity;
        for(Iterator iterator = field_76648_i.values().iterator(); iterator.hasNext(); field_76637_e.func_72928_a(tileentity))
        {
            tileentity = (TileEntity)iterator.next();
        }

        List alist[] = field_76645_j;
        int i = alist.length;
        for(int j = 0; j < i; j++)
        {
            List list = alist[j];
            field_76637_e.func_72828_b(list);
        }

    }

    public void func_76630_e()
    {
        field_76643_l = true;
    }

    public void func_76588_a(Entity p_76588_1_, AxisAlignedBB p_76588_2_, List p_76588_3_)
    {
        int i = MathHelper.func_76128_c((p_76588_2_.field_72338_b - 2D) / 16D);
        int j = MathHelper.func_76128_c((p_76588_2_.field_72337_e + 2D) / 16D);
        if(i < 0)
        {
            i = 0;
        }
        if(j >= field_76645_j.length)
        {
            j = field_76645_j.length - 1;
        }
label0:
        for(int k = i; k <= j; k++)
        {
            List list = field_76645_j[k];
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    continue label0;
                }
                Entity entity = (Entity)iterator.next();
                if(entity != p_76588_1_ && entity.field_70121_D.func_72326_a(p_76588_2_))
                {
                    p_76588_3_.add(entity);
                    Entity aentity[] = entity.func_70021_al();
                    if(aentity != null)
                    {
                        int l = 0;
                        while(l < aentity.length) 
                        {
                            Entity entity1 = aentity[l];
                            if(entity1 != p_76588_1_ && entity1.field_70121_D.func_72326_a(p_76588_2_))
                            {
                                p_76588_3_.add(entity1);
                            }
                            l++;
                        }
                    }
                }
            } while(true);
        }

    }

    public void func_76618_a(Class p_76618_1_, AxisAlignedBB p_76618_2_, List p_76618_3_)
    {
        int i = MathHelper.func_76128_c((p_76618_2_.field_72338_b - 2D) / 16D);
        int j = MathHelper.func_76128_c((p_76618_2_.field_72337_e + 2D) / 16D);
        if(i < 0)
        {
            i = 0;
        } else
        if(i >= field_76645_j.length)
        {
            i = field_76645_j.length - 1;
        }
        if(j >= field_76645_j.length)
        {
            j = field_76645_j.length - 1;
        } else
        if(j < 0)
        {
            j = 0;
        }
label0:
        for(int k = i; k <= j; k++)
        {
            List list = field_76645_j[k];
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    continue label0;
                }
                Entity entity = (Entity)iterator.next();
                if(p_76618_1_.isAssignableFrom(entity.getClass()) && entity.field_70121_D.func_72326_a(p_76618_2_))
                {
                    p_76618_3_.add(entity);
                }
            } while(true);
        }

    }

    public boolean func_76601_a(boolean p_76601_1_)
    {
        if(p_76601_1_)
        {
            if(field_76644_m && field_76637_e.func_72820_D() != field_76641_n)
            {
                return true;
            }
        } else
        if(field_76644_m && field_76637_e.func_72820_D() >= field_76641_n + 600L)
        {
            return true;
        }
        return field_76643_l;
    }

    public Random func_76617_a(long p_76617_1_)
    {
        return new Random(field_76637_e.func_72905_C() + (long)(field_76635_g * field_76635_g * 0x4c1906) + (long)(field_76635_g * 0x5ac0db) + (long)(field_76647_h * field_76647_h) * 0x4307a7L + (long)(field_76647_h * 0x5f24f) ^ p_76617_1_);
    }

    public boolean func_76621_g()
    {
        return false;
    }

    public void func_76624_a(IChunkProvider p_76624_1_, IChunkProvider p_76624_2_, int p_76624_3_, int p_76624_4_)
    {
        if(!field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_))
        {
            p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_, p_76624_4_);
        }
        if(p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_) && !p_76624_1_.func_73154_d(p_76624_3_ - 1, p_76624_4_).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ + 1))
        {
            p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_ - 1, p_76624_4_);
        }
        if(p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ - 1) && !p_76624_1_.func_73154_d(p_76624_3_, p_76624_4_ - 1).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_))
        {
            p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_, p_76624_4_ - 1);
        }
        if(p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ - 1) && !p_76624_1_.func_73154_d(p_76624_3_ - 1, p_76624_4_ - 1).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_))
        {
            p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_ - 1, p_76624_4_ - 1);
        }
    }

    public int func_76626_d(int p_76626_1_, int p_76626_2_)
    {
        int i = p_76626_1_ | p_76626_2_ << 4;
        int j = field_76638_b[i];
        if(j == -999)
        {
            int k = func_76625_h() + 15;
            for(j = -1; k > 0 && j == -1;)
            {
                int l = func_76610_a(p_76626_1_, k, p_76626_2_);
                Material material = l == 0 ? Material.field_76249_a : Block.field_71973_m[l].field_72018_cp;
                if(!material.func_76230_c() && !material.func_76224_d())
                {
                    k--;
                } else
                {
                    j = k + 1;
                }
            }

            field_76638_b[i] = j;
        }
        return j;
    }

    public void func_76586_k()
    {
        if(field_76650_s && !field_76637_e.field_73011_w.field_76576_e)
        {
            func_76593_q();
        }
    }

    public ChunkCoordIntPair func_76632_l()
    {
        return new ChunkCoordIntPair(field_76635_g, field_76647_h);
    }

    public boolean func_76606_c(int p_76606_1_, int p_76606_2_)
    {
        if(p_76606_1_ < 0)
        {
            p_76606_1_ = 0;
        }
        if(p_76606_2_ >= 256)
        {
            p_76606_2_ = 255;
        }
        for(int i = p_76606_1_; i <= p_76606_2_; i += 16)
        {
            ExtendedBlockStorage extendedblockstorage = field_76652_q[i >> 4];
            if(extendedblockstorage != null && !extendedblockstorage.func_76663_a())
            {
                return false;
            }
        }

        return true;
    }

    public void func_76602_a(ExtendedBlockStorage p_76602_1_[])
    {
        field_76652_q = p_76602_1_;
    }

    public void func_76607_a(byte p_76607_1_[], int p_76607_2_, int p_76607_3_, boolean p_76607_4_)
    {
        int i = 0;
        for(int j = 0; j < field_76652_q.length; j++)
        {
            if((p_76607_2_ & 1 << j) != 0)
            {
                if(field_76652_q[j] == null)
                {
                    field_76652_q[j] = new ExtendedBlockStorage(j << 4);
                }
                byte abyte0[] = field_76652_q[j].func_76658_g();
                System.arraycopy(p_76607_1_, i, abyte0, 0, abyte0.length);
                i += abyte0.length;
                continue;
            }
            if(p_76607_4_ && field_76652_q[j] != null)
            {
                field_76652_q[j] = null;
            }
        }

        for(int k = 0; k < field_76652_q.length; k++)
        {
            if((p_76607_2_ & 1 << k) != 0 && field_76652_q[k] != null)
            {
                NibbleArray nibblearray = field_76652_q[k].func_76669_j();
                System.arraycopy(p_76607_1_, i, nibblearray.field_76585_a, 0, nibblearray.field_76585_a.length);
                i += nibblearray.field_76585_a.length;
            }
        }

        for(int l = 0; l < field_76652_q.length; l++)
        {
            if((p_76607_2_ & 1 << l) != 0 && field_76652_q[l] != null)
            {
                NibbleArray nibblearray1 = field_76652_q[l].func_76661_k();
                System.arraycopy(p_76607_1_, i, nibblearray1.field_76585_a, 0, nibblearray1.field_76585_a.length);
                i += nibblearray1.field_76585_a.length;
            }
        }

        for(int i1 = 0; i1 < field_76652_q.length; i1++)
        {
            if((p_76607_2_ & 1 << i1) != 0 && field_76652_q[i1] != null)
            {
                NibbleArray nibblearray2 = field_76652_q[i1].func_76671_l();
                System.arraycopy(p_76607_1_, i, nibblearray2.field_76585_a, 0, nibblearray2.field_76585_a.length);
                i += nibblearray2.field_76585_a.length;
            }
        }

        for(int j1 = 0; j1 < field_76652_q.length; j1++)
        {
            if((p_76607_3_ & 1 << j1) != 0)
            {
                if(field_76652_q[j1] == null)
                {
                    i += 2048;
                    continue;
                }
                NibbleArray nibblearray3 = field_76652_q[j1].func_76660_i();
                if(nibblearray3 == null)
                {
                    nibblearray3 = field_76652_q[j1].func_76667_m();
                }
                System.arraycopy(p_76607_1_, i, nibblearray3.field_76585_a, 0, nibblearray3.field_76585_a.length);
                i += nibblearray3.field_76585_a.length;
                continue;
            }
            if(p_76607_4_ && field_76652_q[j1] != null && field_76652_q[j1].func_76660_i() != null)
            {
                field_76652_q[j1].func_76676_h();
            }
        }

        if(p_76607_4_)
        {
            System.arraycopy(p_76607_1_, i, field_76651_r, 0, field_76651_r.length);
            i += field_76651_r.length;
        }
        for(int k1 = 0; k1 < field_76652_q.length; k1++)
        {
            if(field_76652_q[k1] != null && (p_76607_2_ & 1 << k1) != 0)
            {
                field_76652_q[k1].func_76672_e();
            }
        }

        func_76590_a();
        TileEntity tileentity;
        for(Iterator iterator = field_76648_i.values().iterator(); iterator.hasNext(); tileentity.func_70321_h())
        {
            tileentity = (TileEntity)iterator.next();
        }

    }

    public BiomeGenBase func_76591_a(int p_76591_1_, int p_76591_2_, WorldChunkManager p_76591_3_)
    {
        int i = field_76651_r[p_76591_2_ << 4 | p_76591_1_] & 0xff;
        if(i == 255)
        {
            BiomeGenBase biomegenbase = p_76591_3_.func_76935_a((field_76635_g << 4) + p_76591_1_, (field_76647_h << 4) + p_76591_2_);
            i = biomegenbase.field_76756_M;
            field_76651_r[p_76591_2_ << 4 | p_76591_1_] = (byte)(i & 0xff);
        }
        if(BiomeGenBase.field_76773_a[i] == null)
        {
            return BiomeGenBase.field_76772_c;
        } else
        {
            return BiomeGenBase.field_76773_a[i];
        }
    }

    public byte[] func_76605_m()
    {
        return field_76651_r;
    }

    public void func_76616_a(byte p_76616_1_[])
    {
        field_76651_r = p_76616_1_;
    }

    public void func_76613_n()
    {
        field_76649_t = 0;
    }

    public void func_76594_o()
    {
        for(int i = 0; i < 8; i++)
        {
            if(field_76649_t >= 4096)
            {
                return;
            }
            int j = field_76649_t % 16;
            int k = (field_76649_t / 16) % 16;
            int l = field_76649_t / 256;
            field_76649_t++;
            int i1 = (field_76635_g << 4) + k;
            int j1 = (field_76647_h << 4) + l;
            for(int k1 = 0; k1 < 16; k1++)
            {
                int l1 = (j << 4) + k1;
                if((field_76652_q[j] != null || k1 != 0 && k1 != 15 && k != 0 && k != 15 && l != 0 && l != 15) && (field_76652_q[j] == null || field_76652_q[j].func_76656_a(k, k1, l) != 0))
                {
                    continue;
                }
                if(Block.field_71984_q[field_76637_e.func_72798_a(i1, l1 - 1, j1)] > 0)
                {
                    field_76637_e.func_72969_x(i1, l1 - 1, j1);
                }
                if(Block.field_71984_q[field_76637_e.func_72798_a(i1, l1 + 1, j1)] > 0)
                {
                    field_76637_e.func_72969_x(i1, l1 + 1, j1);
                }
                if(Block.field_71984_q[field_76637_e.func_72798_a(i1 - 1, l1, j1)] > 0)
                {
                    field_76637_e.func_72969_x(i1 - 1, l1, j1);
                }
                if(Block.field_71984_q[field_76637_e.func_72798_a(i1 + 1, l1, j1)] > 0)
                {
                    field_76637_e.func_72969_x(i1 + 1, l1, j1);
                }
                if(Block.field_71984_q[field_76637_e.func_72798_a(i1, l1, j1 - 1)] > 0)
                {
                    field_76637_e.func_72969_x(i1, l1, j1 - 1);
                }
                if(Block.field_71984_q[field_76637_e.func_72798_a(i1, l1, j1 + 1)] > 0)
                {
                    field_76637_e.func_72969_x(i1, l1, j1 + 1);
                }
                field_76637_e.func_72969_x(i1, l1, j1);
            }

        }

    }
}
