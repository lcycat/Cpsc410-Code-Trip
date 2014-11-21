// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, IBlockAccess, 
//            Vec3, Vec3Pool, AxisAlignedBB, Entity

public abstract class BlockFluid extends Block
{

    protected BlockFluid(int p_i3964_1_, Material p_i3964_2_)
    {
        super(p_i3964_1_, (p_i3964_2_ != Material.field_76256_h ? 12 : 14) * 16 + 13, p_i3964_2_);
        float f = 0.0F;
        float f1 = 0.0F;
        func_71905_a(0.0F + f1, 0.0F + f, 0.0F + f1, 1.0F + f1, 1.0F + f, 1.0F + f1);
        func_71907_b(true);
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        return field_72018_cp != Material.field_76256_h;
    }

    public static float func_72199_d(int p_72199_0_)
    {
        if(p_72199_0_ >= 8)
        {
            p_72199_0_ = 0;
        }
        return (float)(p_72199_0_ + 1) / 9F;
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 0 || p_71851_1_ == 1)
        {
            return field_72059_bZ;
        } else
        {
            return field_72059_bZ + 1;
        }
    }

    protected int func_72198_f_(World p_72198_1_, int p_72198_2_, int p_72198_3_, int p_72198_4_)
    {
        if(p_72198_1_.func_72803_f(p_72198_2_, p_72198_3_, p_72198_4_) == field_72018_cp)
        {
            return p_72198_1_.func_72805_g(p_72198_2_, p_72198_3_, p_72198_4_);
        } else
        {
            return -1;
        }
    }

    protected int func_72203_d(IBlockAccess p_72203_1_, int p_72203_2_, int p_72203_3_, int p_72203_4_)
    {
        if(p_72203_1_.func_72803_f(p_72203_2_, p_72203_3_, p_72203_4_) != field_72018_cp)
        {
            return -1;
        }
        int i = p_72203_1_.func_72805_g(p_72203_2_, p_72203_3_, p_72203_4_);
        if(i >= 8)
        {
            i = 0;
        }
        return i;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71913_a(int p_71913_1_, boolean p_71913_2_)
    {
        return p_71913_2_ && p_71913_1_ == 0;
    }

    public boolean func_71924_d(IBlockAccess p_71924_1_, int p_71924_2_, int p_71924_3_, int p_71924_4_, int p_71924_5_)
    {
        Material material = p_71924_1_.func_72803_f(p_71924_2_, p_71924_3_, p_71924_4_);
        if(material == field_72018_cp)
        {
            return false;
        }
        if(p_71924_5_ == 1)
        {
            return true;
        }
        if(material == Material.field_76260_u)
        {
            return false;
        } else
        {
            return super.func_71924_d(p_71924_1_, p_71924_2_, p_71924_3_, p_71924_4_, p_71924_5_);
        }
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public int func_71857_b()
    {
        return 4;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return 0;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    private Vec3 func_72202_i(IBlockAccess p_72202_1_, int p_72202_2_, int p_72202_3_, int p_72202_4_)
    {
        Vec3 vec3 = Vec3.func_72437_a().func_72345_a(0.0D, 0.0D, 0.0D);
        int i = func_72203_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_);
        for(int j = 0; j < 4; j++)
        {
            int k = p_72202_2_;
            int l = p_72202_3_;
            int i1 = p_72202_4_;
            if(j == 0)
            {
                k--;
            }
            if(j == 1)
            {
                i1--;
            }
            if(j == 2)
            {
                k++;
            }
            if(j == 3)
            {
                i1++;
            }
            int j1 = func_72203_d(p_72202_1_, k, l, i1);
            if(j1 < 0)
            {
                if(p_72202_1_.func_72803_f(k, l, i1).func_76230_c())
                {
                    continue;
                }
                j1 = func_72203_d(p_72202_1_, k, l - 1, i1);
                if(j1 >= 0)
                {
                    int k1 = j1 - (i - 8);
                    vec3 = vec3.func_72441_c((k - p_72202_2_) * k1, (l - p_72202_3_) * k1, (i1 - p_72202_4_) * k1);
                }
                continue;
            }
            if(j1 >= 0)
            {
                int l1 = j1 - i;
                vec3 = vec3.func_72441_c((k - p_72202_2_) * l1, (l - p_72202_3_) * l1, (i1 - p_72202_4_) * l1);
            }
        }

        if(p_72202_1_.func_72805_g(p_72202_2_, p_72202_3_, p_72202_4_) >= 8)
        {
            boolean flag = false;
            if(flag || func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_ - 1, 2))
            {
                flag = true;
            }
            if(flag || func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_ + 1, 3))
            {
                flag = true;
            }
            if(flag || func_71924_d(p_72202_1_, p_72202_2_ - 1, p_72202_3_, p_72202_4_, 4))
            {
                flag = true;
            }
            if(flag || func_71924_d(p_72202_1_, p_72202_2_ + 1, p_72202_3_, p_72202_4_, 5))
            {
                flag = true;
            }
            if(flag || func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_ + 1, p_72202_4_ - 1, 2))
            {
                flag = true;
            }
            if(flag || func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_ + 1, p_72202_4_ + 1, 3))
            {
                flag = true;
            }
            if(flag || func_71924_d(p_72202_1_, p_72202_2_ - 1, p_72202_3_ + 1, p_72202_4_, 4))
            {
                flag = true;
            }
            if(flag || func_71924_d(p_72202_1_, p_72202_2_ + 1, p_72202_3_ + 1, p_72202_4_, 5))
            {
                flag = true;
            }
            if(flag)
            {
                vec3 = vec3.func_72432_b().func_72441_c(0.0D, -6D, 0.0D);
            }
        }
        vec3 = vec3.func_72432_b();
        return vec3;
    }

    public void func_71901_a(World p_71901_1_, int p_71901_2_, int p_71901_3_, int p_71901_4_, Entity p_71901_5_, Vec3 p_71901_6_)
    {
        Vec3 vec3 = func_72202_i(p_71901_1_, p_71901_2_, p_71901_3_, p_71901_4_);
        p_71901_6_.field_72450_a += vec3.field_72450_a;
        p_71901_6_.field_72448_b += vec3.field_72448_b;
        p_71901_6_.field_72449_c += vec3.field_72449_c;
    }

    public int func_71859_p_()
    {
        if(field_72018_cp == Material.field_76244_g)
        {
            return 5;
        }
        return field_72018_cp != Material.field_76256_h ? 0 : 30;
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        func_72200_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        func_72200_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
    }

    private void func_72200_l(World p_72200_1_, int p_72200_2_, int p_72200_3_, int p_72200_4_)
    {
        if(p_72200_1_.func_72798_a(p_72200_2_, p_72200_3_, p_72200_4_) != field_71990_ca)
        {
            return;
        }
        if(field_72018_cp == Material.field_76256_h)
        {
            boolean flag = false;
            if(flag || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_, p_72200_4_ - 1) == Material.field_76244_g)
            {
                flag = true;
            }
            if(flag || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_, p_72200_4_ + 1) == Material.field_76244_g)
            {
                flag = true;
            }
            if(flag || p_72200_1_.func_72803_f(p_72200_2_ - 1, p_72200_3_, p_72200_4_) == Material.field_76244_g)
            {
                flag = true;
            }
            if(flag || p_72200_1_.func_72803_f(p_72200_2_ + 1, p_72200_3_, p_72200_4_) == Material.field_76244_g)
            {
                flag = true;
            }
            if(flag || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_ + 1, p_72200_4_) == Material.field_76244_g)
            {
                flag = true;
            }
            if(flag)
            {
                int i = p_72200_1_.func_72805_g(p_72200_2_, p_72200_3_, p_72200_4_);
                if(i == 0)
                {
                    p_72200_1_.func_72859_e(p_72200_2_, p_72200_3_, p_72200_4_, Block.field_72089_ap.field_71990_ca);
                } else
                if(i <= 4)
                {
                    p_72200_1_.func_72859_e(p_72200_2_, p_72200_3_, p_72200_4_, Block.field_71978_w.field_71990_ca);
                }
                func_72201_j(p_72200_1_, p_72200_2_, p_72200_3_, p_72200_4_);
            }
        }
    }

    protected void func_72201_j(World p_72201_1_, int p_72201_2_, int p_72201_3_, int p_72201_4_)
    {
        p_72201_1_.func_72908_a((float)p_72201_2_ + 0.5F, (float)p_72201_3_ + 0.5F, (float)p_72201_4_ + 0.5F, "random.fizz", 0.5F, 2.6F + (p_72201_1_.field_73012_v.nextFloat() - p_72201_1_.field_73012_v.nextFloat()) * 0.8F);
        for(int i = 0; i < 8; i++)
        {
            p_72201_1_.func_72869_a("largesmoke", (double)p_72201_2_ + Math.random(), (double)p_72201_3_ + 1.2D, (double)p_72201_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
        }

    }
}
