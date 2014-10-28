// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, BlockHalfSlab, BlockLeaves, 
//            BlockTallGrass, World, WorldProviderEnd, IBlockAccess, 
//            WorldProvider, BlockPortal, AxisAlignedBB

public class BlockFire extends Block
{

    private int field_72258_a[];
    private int field_72257_b[];

    protected BlockFire(int p_i3949_1_, int p_i3949_2_)
    {
        super(p_i3949_1_, p_i3949_2_, Material.field_76250_n);
        field_72258_a = new int[256];
        field_72257_b = new int[256];
        func_71907_b(true);
    }

    public void func_71928_r_()
    {
        func_72253_a(Block.field_71988_x.field_71990_ca, 5, 20);
        func_72253_a(Block.field_72090_bN.field_71990_ca, 5, 20);
        func_72253_a(Block.field_72092_bO.field_71990_ca, 5, 20);
        func_72253_a(Block.field_72031_aZ.field_71990_ca, 5, 20);
        func_72253_a(Block.field_72063_at.field_71990_ca, 5, 20);
        func_72253_a(Block.field_72072_bX.field_71990_ca, 5, 20);
        func_72253_a(Block.field_72074_bW.field_71990_ca, 5, 20);
        func_72253_a(Block.field_72070_bY.field_71990_ca, 5, 20);
        func_72253_a(Block.field_71951_J.field_71990_ca, 5, 5);
        func_72253_a(Block.field_71952_K.field_71990_ca, 30, 60);
        func_72253_a(Block.field_72093_an.field_71990_ca, 30, 20);
        func_72253_a(Block.field_72091_am.field_71990_ca, 15, 100);
        func_72253_a(Block.field_71962_X.field_71990_ca, 60, 100);
        func_72253_a(Block.field_72101_ab.field_71990_ca, 30, 60);
        func_72253_a(Block.field_71998_bu.field_71990_ca, 15, 100);
    }

    private void func_72253_a(int p_72253_1_, int p_72253_2_, int p_72253_3_)
    {
        field_72258_a[p_72253_1_] = p_72253_2_;
        field_72257_b[p_72253_1_] = p_72253_3_;
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 3;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public int func_71859_p_()
    {
        return 30;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        boolean flag = p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == Block.field_72012_bb.field_71990_ca;
        if((p_71847_1_.field_73011_w instanceof WorldProviderEnd) && p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == Block.field_71986_z.field_71990_ca)
        {
            flag = true;
        }
        if(!func_71930_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_))
        {
            p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
        }
        if(!flag && p_71847_1_.func_72896_J() && (p_71847_1_.func_72951_B(p_71847_2_, p_71847_3_, p_71847_4_) || p_71847_1_.func_72951_B(p_71847_2_ - 1, p_71847_3_, p_71847_4_) || p_71847_1_.func_72951_B(p_71847_2_ + 1, p_71847_3_, p_71847_4_) || p_71847_1_.func_72951_B(p_71847_2_, p_71847_3_, p_71847_4_ - 1) || p_71847_1_.func_72951_B(p_71847_2_, p_71847_3_, p_71847_4_ + 1)))
        {
            p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
            return;
        }
        int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
        if(i < 15)
        {
            p_71847_1_.func_72881_d(p_71847_2_, p_71847_3_, p_71847_4_, i + p_71847_5_.nextInt(3) / 2);
        }
        p_71847_1_.func_72836_a(p_71847_2_, p_71847_3_, p_71847_4_, field_71990_ca, func_71859_p_() + p_71847_5_.nextInt(10));
        if(!flag && !func_72251_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_))
        {
            if(!p_71847_1_.func_72797_t(p_71847_2_, p_71847_3_ - 1, p_71847_4_) || i > 3)
            {
                p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
            }
            return;
        }
        if(!flag && !func_72256_d(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_) && i == 15 && p_71847_5_.nextInt(4) == 0)
        {
            p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
            return;
        }
        boolean flag1 = p_71847_1_.func_72958_C(p_71847_2_, p_71847_3_, p_71847_4_);
        byte byte0 = 0;
        if(flag1)
        {
            byte0 = -50;
        }
        func_72255_a(p_71847_1_, p_71847_2_ + 1, p_71847_3_, p_71847_4_, 300 + byte0, p_71847_5_, i);
        func_72255_a(p_71847_1_, p_71847_2_ - 1, p_71847_3_, p_71847_4_, 300 + byte0, p_71847_5_, i);
        func_72255_a(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_, 250 + byte0, p_71847_5_, i);
        func_72255_a(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_, 250 + byte0, p_71847_5_, i);
        func_72255_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ - 1, 300 + byte0, p_71847_5_, i);
        func_72255_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ + 1, 300 + byte0, p_71847_5_, i);
        for(int j = p_71847_2_ - 1; j <= p_71847_2_ + 1; j++)
        {
            for(int k = p_71847_4_ - 1; k <= p_71847_4_ + 1; k++)
            {
                for(int l = p_71847_3_ - 1; l <= p_71847_3_ + 4; l++)
                {
                    if(j == p_71847_2_ && l == p_71847_3_ && k == p_71847_4_)
                    {
                        continue;
                    }
                    int i1 = 100;
                    if(l > p_71847_3_ + 1)
                    {
                        i1 += (l - (p_71847_3_ + 1)) * 100;
                    }
                    int j1 = func_72254_n(p_71847_1_, j, l, k);
                    if(j1 <= 0)
                    {
                        continue;
                    }
                    int k1 = (j1 + 40) / (i + 30);
                    if(flag1)
                    {
                        k1 /= 2;
                    }
                    if(k1 <= 0 || p_71847_5_.nextInt(i1) > k1 || p_71847_1_.func_72896_J() && p_71847_1_.func_72951_B(j, l, k) || p_71847_1_.func_72951_B(j - 1, l, p_71847_4_) || p_71847_1_.func_72951_B(j + 1, l, k) || p_71847_1_.func_72951_B(j, l, k - 1) || p_71847_1_.func_72951_B(j, l, k + 1))
                    {
                        continue;
                    }
                    int l1 = i + p_71847_5_.nextInt(5) / 4;
                    if(l1 > 15)
                    {
                        l1 = 15;
                    }
                    p_71847_1_.func_72832_d(j, l, k, field_71990_ca, l1);
                }

            }

        }

    }

    private void func_72255_a(World p_72255_1_, int p_72255_2_, int p_72255_3_, int p_72255_4_, int p_72255_5_, Random p_72255_6_, int p_72255_7_)
    {
        int i = field_72257_b[p_72255_1_.func_72798_a(p_72255_2_, p_72255_3_, p_72255_4_)];
        if(p_72255_6_.nextInt(p_72255_5_) < i)
        {
            boolean flag = p_72255_1_.func_72798_a(p_72255_2_, p_72255_3_, p_72255_4_) == Block.field_72091_am.field_71990_ca;
            if(p_72255_6_.nextInt(p_72255_7_ + 10) < 5 && !p_72255_1_.func_72951_B(p_72255_2_, p_72255_3_, p_72255_4_))
            {
                int j = p_72255_7_ + p_72255_6_.nextInt(5) / 4;
                if(j > 15)
                {
                    j = 15;
                }
                p_72255_1_.func_72832_d(p_72255_2_, p_72255_3_, p_72255_4_, field_71990_ca, j);
            } else
            {
                p_72255_1_.func_72859_e(p_72255_2_, p_72255_3_, p_72255_4_, 0);
            }
            if(flag)
            {
                Block.field_72091_am.func_71898_d(p_72255_1_, p_72255_2_, p_72255_3_, p_72255_4_, 1);
            }
        }
    }

    private boolean func_72251_l(World p_72251_1_, int p_72251_2_, int p_72251_3_, int p_72251_4_)
    {
        if(func_72256_d(p_72251_1_, p_72251_2_ + 1, p_72251_3_, p_72251_4_))
        {
            return true;
        }
        if(func_72256_d(p_72251_1_, p_72251_2_ - 1, p_72251_3_, p_72251_4_))
        {
            return true;
        }
        if(func_72256_d(p_72251_1_, p_72251_2_, p_72251_3_ - 1, p_72251_4_))
        {
            return true;
        }
        if(func_72256_d(p_72251_1_, p_72251_2_, p_72251_3_ + 1, p_72251_4_))
        {
            return true;
        }
        if(func_72256_d(p_72251_1_, p_72251_2_, p_72251_3_, p_72251_4_ - 1))
        {
            return true;
        }
        return func_72256_d(p_72251_1_, p_72251_2_, p_72251_3_, p_72251_4_ + 1);
    }

    private int func_72254_n(World p_72254_1_, int p_72254_2_, int p_72254_3_, int p_72254_4_)
    {
        int i = 0;
        if(!p_72254_1_.func_72799_c(p_72254_2_, p_72254_3_, p_72254_4_))
        {
            return 0;
        } else
        {
            i = func_72252_e(p_72254_1_, p_72254_2_ + 1, p_72254_3_, p_72254_4_, i);
            i = func_72252_e(p_72254_1_, p_72254_2_ - 1, p_72254_3_, p_72254_4_, i);
            i = func_72252_e(p_72254_1_, p_72254_2_, p_72254_3_ - 1, p_72254_4_, i);
            i = func_72252_e(p_72254_1_, p_72254_2_, p_72254_3_ + 1, p_72254_4_, i);
            i = func_72252_e(p_72254_1_, p_72254_2_, p_72254_3_, p_72254_4_ - 1, i);
            i = func_72252_e(p_72254_1_, p_72254_2_, p_72254_3_, p_72254_4_ + 1, i);
            return i;
        }
    }

    public boolean func_71935_l()
    {
        return false;
    }

    public boolean func_72256_d(IBlockAccess p_72256_1_, int p_72256_2_, int p_72256_3_, int p_72256_4_)
    {
        return field_72258_a[p_72256_1_.func_72798_a(p_72256_2_, p_72256_3_, p_72256_4_)] > 0;
    }

    public int func_72252_e(World p_72252_1_, int p_72252_2_, int p_72252_3_, int p_72252_4_, int p_72252_5_)
    {
        int i = field_72258_a[p_72252_1_.func_72798_a(p_72252_2_, p_72252_3_, p_72252_4_)];
        if(i > p_72252_5_)
        {
            return i;
        } else
        {
            return p_72252_5_;
        }
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_) || func_72251_l(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_) && !func_72251_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        if(p_71861_1_.field_73011_w.field_76574_g <= 0 && p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_) == Block.field_72089_ap.field_71990_ca && Block.field_72015_be.func_72246_i_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_))
        {
            return;
        }
        if(!p_71861_1_.func_72797_t(p_71861_2_, p_71861_3_ - 1, p_71861_4_) && !func_72251_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_))
        {
            p_71861_1_.func_72859_e(p_71861_2_, p_71861_3_, p_71861_4_, 0);
            return;
        } else
        {
            p_71861_1_.func_72836_a(p_71861_2_, p_71861_3_, p_71861_4_, field_71990_ca, func_71859_p_() + p_71861_1_.field_73012_v.nextInt(10));
            return;
        }
    }

    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if(p_71862_5_.nextInt(24) == 0)
        {
            p_71862_1_.func_72980_b((float)p_71862_2_ + 0.5F, (float)p_71862_3_ + 0.5F, (float)p_71862_4_ + 0.5F, "fire.fire", 1.0F + p_71862_5_.nextFloat(), p_71862_5_.nextFloat() * 0.7F + 0.3F);
        }
        if(p_71862_1_.func_72797_t(p_71862_2_, p_71862_3_ - 1, p_71862_4_) || Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_, p_71862_3_ - 1, p_71862_4_))
        {
            for(int i = 0; i < 3; i++)
            {
                float f = (float)p_71862_2_ + p_71862_5_.nextFloat();
                float f6 = (float)p_71862_3_ + p_71862_5_.nextFloat() * 0.5F + 0.5F;
                float f12 = (float)p_71862_4_ + p_71862_5_.nextFloat();
                p_71862_1_.func_72869_a("largesmoke", f, f6, f12, 0.0D, 0.0D, 0.0D);
            }

        } else
        {
            if(Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_ - 1, p_71862_3_, p_71862_4_))
            {
                for(int j = 0; j < 2; j++)
                {
                    float f1 = (float)p_71862_2_ + p_71862_5_.nextFloat() * 0.1F;
                    float f7 = (float)p_71862_3_ + p_71862_5_.nextFloat();
                    float f13 = (float)p_71862_4_ + p_71862_5_.nextFloat();
                    p_71862_1_.func_72869_a("largesmoke", f1, f7, f13, 0.0D, 0.0D, 0.0D);
                }

            }
            if(Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_ + 1, p_71862_3_, p_71862_4_))
            {
                for(int k = 0; k < 2; k++)
                {
                    float f2 = (float)(p_71862_2_ + 1) - p_71862_5_.nextFloat() * 0.1F;
                    float f8 = (float)p_71862_3_ + p_71862_5_.nextFloat();
                    float f14 = (float)p_71862_4_ + p_71862_5_.nextFloat();
                    p_71862_1_.func_72869_a("largesmoke", f2, f8, f14, 0.0D, 0.0D, 0.0D);
                }

            }
            if(Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_ - 1))
            {
                for(int l = 0; l < 2; l++)
                {
                    float f3 = (float)p_71862_2_ + p_71862_5_.nextFloat();
                    float f9 = (float)p_71862_3_ + p_71862_5_.nextFloat();
                    float f15 = (float)p_71862_4_ + p_71862_5_.nextFloat() * 0.1F;
                    p_71862_1_.func_72869_a("largesmoke", f3, f9, f15, 0.0D, 0.0D, 0.0D);
                }

            }
            if(Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_ + 1))
            {
                for(int i1 = 0; i1 < 2; i1++)
                {
                    float f4 = (float)p_71862_2_ + p_71862_5_.nextFloat();
                    float f10 = (float)p_71862_3_ + p_71862_5_.nextFloat();
                    float f16 = (float)(p_71862_4_ + 1) - p_71862_5_.nextFloat() * 0.1F;
                    p_71862_1_.func_72869_a("largesmoke", f4, f10, f16, 0.0D, 0.0D, 0.0D);
                }

            }
            if(Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_, p_71862_3_ + 1, p_71862_4_))
            {
                for(int j1 = 0; j1 < 2; j1++)
                {
                    float f5 = (float)p_71862_2_ + p_71862_5_.nextFloat();
                    float f11 = (float)(p_71862_3_ + 1) - p_71862_5_.nextFloat() * 0.1F;
                    float f17 = (float)p_71862_4_ + p_71862_5_.nextFloat();
                    p_71862_1_.func_72869_a("largesmoke", f5, f11, f17, 0.0D, 0.0D, 0.0D);
                }

            }
        }
    }
}
