// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material, World, WorldProvider, 
//            ItemMonsterPlacer, IBlockAccess, Block, BlockFire, 
//            Entity, AxisAlignedBB

public class BlockPortal extends BlockBreakable
{

    public BlockPortal(int p_i3979_1_, int p_i3979_2_)
    {
        super(p_i3979_1_, p_i3979_2_, Material.field_76237_B, false);
        func_71907_b(true);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
        if(p_71847_1_.field_73011_w.func_76569_d() && p_71847_5_.nextInt(2000) < p_71847_1_.field_73013_u)
        {
            int i;
            for(i = p_71847_3_; !p_71847_1_.func_72797_t(p_71847_2_, i, p_71847_4_) && i > 0; i--) { }
            if(i > 0 && !p_71847_1_.func_72809_s(p_71847_2_, i + 1, p_71847_4_))
            {
                ItemMonsterPlacer.func_77840_a(p_71847_1_, 57, (double)p_71847_2_ + 0.5D, (double)i + 1.1000000000000001D, (double)p_71847_4_ + 0.5D);
            }
        }
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        if(p_71902_1_.func_72798_a(p_71902_2_ - 1, p_71902_3_, p_71902_4_) == field_71990_ca || p_71902_1_.func_72798_a(p_71902_2_ + 1, p_71902_3_, p_71902_4_) == field_71990_ca)
        {
            float f = 0.5F;
            float f2 = 0.125F;
            func_71905_a(0.5F - f, 0.0F, 0.5F - f2, 0.5F + f, 1.0F, 0.5F + f2);
        } else
        {
            float f1 = 0.125F;
            float f3 = 0.5F;
            func_71905_a(0.5F - f1, 0.0F, 0.5F - f3, 0.5F + f1, 1.0F, 0.5F + f3);
        }
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_72246_i_(World p_72246_1_, int p_72246_2_, int p_72246_3_, int p_72246_4_)
    {
        int i = 0;
        int j = 0;
        if(p_72246_1_.func_72798_a(p_72246_2_ - 1, p_72246_3_, p_72246_4_) == Block.field_72089_ap.field_71990_ca || p_72246_1_.func_72798_a(p_72246_2_ + 1, p_72246_3_, p_72246_4_) == Block.field_72089_ap.field_71990_ca)
        {
            i = 1;
        }
        if(p_72246_1_.func_72798_a(p_72246_2_, p_72246_3_, p_72246_4_ - 1) == Block.field_72089_ap.field_71990_ca || p_72246_1_.func_72798_a(p_72246_2_, p_72246_3_, p_72246_4_ + 1) == Block.field_72089_ap.field_71990_ca)
        {
            j = 1;
        }
        if(i == j)
        {
            return false;
        }
        if(p_72246_1_.func_72798_a(p_72246_2_ - i, p_72246_3_, p_72246_4_ - j) == 0)
        {
            p_72246_2_ -= i;
            p_72246_4_ -= j;
        }
        for(int k = -1; k <= 2; k++)
        {
            for(int i1 = -1; i1 <= 3; i1++)
            {
                boolean flag = k == -1 || k == 2 || i1 == -1 || i1 == 3;
                if((k == -1 || k == 2) && (i1 == -1 || i1 == 3))
                {
                    continue;
                }
                int k1 = p_72246_1_.func_72798_a(p_72246_2_ + i * k, p_72246_3_ + i1, p_72246_4_ + j * k);
                if(flag)
                {
                    if(k1 != Block.field_72089_ap.field_71990_ca)
                    {
                        return false;
                    }
                    continue;
                }
                if(k1 != 0 && k1 != Block.field_72067_ar.field_71990_ca)
                {
                    return false;
                }
            }

        }

        p_72246_1_.field_73014_t = true;
        for(int l = 0; l < 2; l++)
        {
            for(int j1 = 0; j1 < 3; j1++)
            {
                p_72246_1_.func_72859_e(p_72246_2_ + i * l, p_72246_3_ + j1, p_72246_4_ + j * l, Block.field_72015_be.field_71990_ca);
            }

        }

        p_72246_1_.field_73014_t = false;
        return true;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        int i = 0;
        int j = 1;
        if(p_71863_1_.func_72798_a(p_71863_2_ - 1, p_71863_3_, p_71863_4_) == field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + 1, p_71863_3_, p_71863_4_) == field_71990_ca)
        {
            i = 1;
            j = 0;
        }
        int k;
        for(k = p_71863_3_; p_71863_1_.func_72798_a(p_71863_2_, k - 1, p_71863_4_) == field_71990_ca; k--) { }
        if(p_71863_1_.func_72798_a(p_71863_2_, k - 1, p_71863_4_) != Block.field_72089_ap.field_71990_ca)
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            return;
        }
        int l;
        for(l = 1; l < 4 && p_71863_1_.func_72798_a(p_71863_2_, k + l, p_71863_4_) == field_71990_ca; l++) { }
        if(l != 3 || p_71863_1_.func_72798_a(p_71863_2_, k + l, p_71863_4_) != Block.field_72089_ap.field_71990_ca)
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            return;
        }
        boolean flag = p_71863_1_.func_72798_a(p_71863_2_ - 1, p_71863_3_, p_71863_4_) == field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + 1, p_71863_3_, p_71863_4_) == field_71990_ca;
        boolean flag1 = p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_, p_71863_4_ - 1) == field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_, p_71863_4_ + 1) == field_71990_ca;
        if(flag && flag1)
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
            return;
        }
        if((p_71863_1_.func_72798_a(p_71863_2_ + i, p_71863_3_, p_71863_4_ + j) != Block.field_72089_ap.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ - i, p_71863_3_, p_71863_4_ - j) != field_71990_ca) && (p_71863_1_.func_72798_a(p_71863_2_ - i, p_71863_3_, p_71863_4_ - j) != Block.field_72089_ap.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + i, p_71863_3_, p_71863_4_ + j) != field_71990_ca))
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
    }

    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        if(p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_) == field_71990_ca)
        {
            return false;
        }
        boolean flag = p_71877_1_.func_72798_a(p_71877_2_ - 1, p_71877_3_, p_71877_4_) == field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_ - 2, p_71877_3_, p_71877_4_) != field_71990_ca;
        boolean flag1 = p_71877_1_.func_72798_a(p_71877_2_ + 1, p_71877_3_, p_71877_4_) == field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_ + 2, p_71877_3_, p_71877_4_) != field_71990_ca;
        boolean flag2 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ - 1) == field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ - 2) != field_71990_ca;
        boolean flag3 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ + 1) == field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ + 2) != field_71990_ca;
        boolean flag4 = flag || flag1;
        boolean flag5 = flag2 || flag3;
        if(flag4 && p_71877_5_ == 4)
        {
            return true;
        }
        if(flag4 && p_71877_5_ == 5)
        {
            return true;
        }
        if(flag5 && p_71877_5_ == 2)
        {
            return true;
        }
        return flag5 && p_71877_5_ == 3;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public int func_71856_s_()
    {
        return 1;
    }

    public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_)
    {
        if(p_71869_5_.field_70154_o == null && p_71869_5_.field_70153_n == null)
        {
            p_71869_5_.func_70063_aa();
        }
    }

    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if(p_71862_5_.nextInt(100) == 0)
        {
            p_71862_1_.func_72980_b((double)p_71862_2_ + 0.5D, (double)p_71862_3_ + 0.5D, (double)p_71862_4_ + 0.5D, "portal.portal", 0.5F, p_71862_5_.nextFloat() * 0.4F + 0.8F);
        }
        for(int i = 0; i < 4; i++)
        {
            double d = (float)p_71862_2_ + p_71862_5_.nextFloat();
            double d1 = (float)p_71862_3_ + p_71862_5_.nextFloat();
            double d2 = (float)p_71862_4_ + p_71862_5_.nextFloat();
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int j = p_71862_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;
            if(p_71862_1_.func_72798_a(p_71862_2_ - 1, p_71862_3_, p_71862_4_) == field_71990_ca || p_71862_1_.func_72798_a(p_71862_2_ + 1, p_71862_3_, p_71862_4_) == field_71990_ca)
            {
                d2 = (double)p_71862_4_ + 0.5D + 0.25D * (double)j;
                d5 = p_71862_5_.nextFloat() * 2.0F * (float)j;
            } else
            {
                d = (double)p_71862_2_ + 0.5D + 0.25D * (double)j;
                d3 = p_71862_5_.nextFloat() * 2.0F * (float)j;
            }
            p_71862_1_.func_72869_a("portal", d, d1, d2, d3, d4, d5);
        }

    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int i)
    {
        return 0;
    }
}
