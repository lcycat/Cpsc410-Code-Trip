// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFluid, World, Material, WorldProvider, 
//            Block, IBlockAccess

public class BlockFlowing extends BlockFluid
{

    int field_72214_a;
    boolean field_72212_b[];
    int field_72213_c[];

    protected BlockFlowing(int p_i3965_1_, Material p_i3965_2_)
    {
        super(p_i3965_1_, p_i3965_2_);
        field_72214_a = 0;
        field_72212_b = new boolean[4];
        field_72213_c = new int[4];
    }

    private void func_72205_l(World p_72205_1_, int p_72205_2_, int p_72205_3_, int p_72205_4_)
    {
        int i = p_72205_1_.func_72805_g(p_72205_2_, p_72205_3_, p_72205_4_);
        p_72205_1_.func_72961_c(p_72205_2_, p_72205_3_, p_72205_4_, field_71990_ca + 1, i);
        p_72205_1_.func_72909_d(p_72205_2_, p_72205_3_, p_72205_4_, p_72205_2_, p_72205_3_, p_72205_4_);
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        return field_72018_cp != Material.field_76256_h;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        int i = func_72198_f_(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
        byte byte0 = 1;
        if(field_72018_cp == Material.field_76256_h && !p_71847_1_.field_73011_w.field_76575_d)
        {
            byte0 = 2;
        }
        boolean flag = true;
        if(i > 0)
        {
            int j = -100;
            field_72214_a = 0;
            j = func_72211_e(p_71847_1_, p_71847_2_ - 1, p_71847_3_, p_71847_4_, j);
            j = func_72211_e(p_71847_1_, p_71847_2_ + 1, p_71847_3_, p_71847_4_, j);
            j = func_72211_e(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ - 1, j);
            j = func_72211_e(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ + 1, j);
            int k = j + byte0;
            if(k >= 8 || j < 0)
            {
                k = -1;
            }
            if(func_72198_f_(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 0)
            {
                int i1 = func_72198_f_(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_);
                if(i1 >= 8)
                {
                    k = i1;
                } else
                {
                    k = i1 + 8;
                }
            }
            if(field_72214_a >= 2 && field_72018_cp == Material.field_76244_g)
            {
                if(p_71847_1_.func_72803_f(p_71847_2_, p_71847_3_ - 1, p_71847_4_).func_76220_a())
                {
                    k = 0;
                } else
                if(p_71847_1_.func_72803_f(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == field_72018_cp && p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_) == 0)
                {
                    k = 0;
                }
            }
            if(field_72018_cp == Material.field_76256_h && i < 8 && k < 8 && k > i && p_71847_5_.nextInt(4) != 0)
            {
                k = i;
                flag = false;
            }
            if(k == i)
            {
                if(flag)
                {
                    func_72205_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
                }
            } else
            {
                i = k;
                if(i < 0)
                {
                    p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, 0);
                } else
                {
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, i);
                    p_71847_1_.func_72836_a(p_71847_2_, p_71847_3_, p_71847_4_, field_71990_ca, func_71859_p_());
                    p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_, p_71847_4_, field_71990_ca);
                }
            }
        } else
        {
            func_72205_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
        }
        if(func_72207_p(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_))
        {
            if(field_72018_cp == Material.field_76256_h && p_71847_1_.func_72803_f(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == Material.field_76244_g)
            {
                p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_ - 1, p_71847_4_, Block.field_71981_t.field_71990_ca);
                func_72201_j(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_);
                return;
            }
            if(i >= 8)
            {
                func_72210_i(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_, i);
            } else
            {
                func_72210_i(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_, i + 8);
            }
        } else
        if(i >= 0 && (i == 0 || func_72208_o(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_)))
        {
            boolean aflag[] = func_72206_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
            int l = i + byte0;
            if(i >= 8)
            {
                l = 1;
            }
            if(l >= 8)
            {
                return;
            }
            if(aflag[0])
            {
                func_72210_i(p_71847_1_, p_71847_2_ - 1, p_71847_3_, p_71847_4_, l);
            }
            if(aflag[1])
            {
                func_72210_i(p_71847_1_, p_71847_2_ + 1, p_71847_3_, p_71847_4_, l);
            }
            if(aflag[2])
            {
                func_72210_i(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ - 1, l);
            }
            if(aflag[3])
            {
                func_72210_i(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ + 1, l);
            }
        }
    }

    private void func_72210_i(World p_72210_1_, int p_72210_2_, int p_72210_3_, int p_72210_4_, int p_72210_5_)
    {
        if(func_72207_p(p_72210_1_, p_72210_2_, p_72210_3_, p_72210_4_))
        {
            int i = p_72210_1_.func_72798_a(p_72210_2_, p_72210_3_, p_72210_4_);
            if(i > 0)
            {
                if(field_72018_cp == Material.field_76256_h)
                {
                    func_72201_j(p_72210_1_, p_72210_2_, p_72210_3_, p_72210_4_);
                } else
                {
                    Block.field_71973_m[i].func_71897_c(p_72210_1_, p_72210_2_, p_72210_3_, p_72210_4_, p_72210_1_.func_72805_g(p_72210_2_, p_72210_3_, p_72210_4_), 0);
                }
            }
            p_72210_1_.func_72832_d(p_72210_2_, p_72210_3_, p_72210_4_, field_71990_ca, p_72210_5_);
        }
    }

    private int func_72209_d(World p_72209_1_, int p_72209_2_, int p_72209_3_, int p_72209_4_, int p_72209_5_, int p_72209_6_)
    {
        int i = 1000;
        for(int j = 0; j < 4; j++)
        {
            if(j == 0 && p_72209_6_ == 1 || j == 1 && p_72209_6_ == 0 || j == 2 && p_72209_6_ == 3 || j == 3 && p_72209_6_ == 2)
            {
                continue;
            }
            int k = p_72209_2_;
            int l = p_72209_3_;
            int i1 = p_72209_4_;
            if(j == 0)
            {
                k--;
            }
            if(j == 1)
            {
                k++;
            }
            if(j == 2)
            {
                i1--;
            }
            if(j == 3)
            {
                i1++;
            }
            if(func_72208_o(p_72209_1_, k, l, i1) || p_72209_1_.func_72803_f(k, l, i1) == field_72018_cp && p_72209_1_.func_72805_g(k, l, i1) == 0)
            {
                continue;
            }
            if(func_72208_o(p_72209_1_, k, l - 1, i1))
            {
                if(p_72209_5_ >= 4)
                {
                    continue;
                }
                int j1 = func_72209_d(p_72209_1_, k, l, i1, p_72209_5_ + 1, j);
                if(j1 < i)
                {
                    i = j1;
                }
            } else
            {
                return p_72209_5_;
            }
        }

        return i;
    }

    private boolean[] func_72206_n(World p_72206_1_, int p_72206_2_, int p_72206_3_, int p_72206_4_)
    {
        for(int i = 0; i < 4; i++)
        {
            field_72213_c[i] = 1000;
            int k = p_72206_2_;
            int j1 = p_72206_3_;
            int k1 = p_72206_4_;
            if(i == 0)
            {
                k--;
            }
            if(i == 1)
            {
                k++;
            }
            if(i == 2)
            {
                k1--;
            }
            if(i == 3)
            {
                k1++;
            }
            if(func_72208_o(p_72206_1_, k, j1, k1) || p_72206_1_.func_72803_f(k, j1, k1) == field_72018_cp && p_72206_1_.func_72805_g(k, j1, k1) == 0)
            {
                continue;
            }
            if(func_72208_o(p_72206_1_, k, j1 - 1, k1))
            {
                field_72213_c[i] = func_72209_d(p_72206_1_, k, j1, k1, 1, i);
            } else
            {
                field_72213_c[i] = 0;
            }
        }

        int j = field_72213_c[0];
        for(int l = 1; l < 4; l++)
        {
            if(field_72213_c[l] < j)
            {
                j = field_72213_c[l];
            }
        }

        for(int i1 = 0; i1 < 4; i1++)
        {
            field_72212_b[i1] = field_72213_c[i1] == j;
        }

        return field_72212_b;
    }

    private boolean func_72208_o(World p_72208_1_, int p_72208_2_, int p_72208_3_, int p_72208_4_)
    {
        int i = p_72208_1_.func_72798_a(p_72208_2_, p_72208_3_, p_72208_4_);
        if(i == Block.field_72054_aE.field_71990_ca || i == Block.field_72045_aL.field_71990_ca || i == Block.field_72053_aD.field_71990_ca || i == Block.field_72055_aF.field_71990_ca || i == Block.field_72040_aX.field_71990_ca)
        {
            return true;
        }
        if(i == 0)
        {
            return false;
        }
        Material material = Block.field_71973_m[i].field_72018_cp;
        if(material == Material.field_76237_B)
        {
            return true;
        }
        return material.func_76230_c();
    }

    protected int func_72211_e(World p_72211_1_, int p_72211_2_, int p_72211_3_, int p_72211_4_, int p_72211_5_)
    {
        int i = func_72198_f_(p_72211_1_, p_72211_2_, p_72211_3_, p_72211_4_);
        if(i < 0)
        {
            return p_72211_5_;
        }
        if(i == 0)
        {
            field_72214_a++;
        }
        if(i >= 8)
        {
            i = 0;
        }
        return p_72211_5_ >= 0 && i >= p_72211_5_ ? p_72211_5_ : i;
    }

    private boolean func_72207_p(World p_72207_1_, int p_72207_2_, int p_72207_3_, int p_72207_4_)
    {
        Material material = p_72207_1_.func_72803_f(p_72207_2_, p_72207_3_, p_72207_4_);
        if(material == field_72018_cp)
        {
            return false;
        }
        if(material == Material.field_76256_h)
        {
            return false;
        } else
        {
            return !func_72208_o(p_72207_1_, p_72207_2_, p_72207_3_, p_72207_4_);
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        if(p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_, p_71861_4_) == field_71990_ca)
        {
            p_71861_1_.func_72836_a(p_71861_2_, p_71861_3_, p_71861_4_, field_71990_ca, func_71859_p_());
        }
    }
}
