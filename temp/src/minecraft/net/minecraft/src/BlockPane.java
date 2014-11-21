// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, CreativeTabs, IBlockAccess, World, 
//            ItemStack, Material, AxisAlignedBB, Entity

public class BlockPane extends Block
{

    private int field_72164_a;
    private final boolean field_72163_b;

    protected BlockPane(int p_i4005_1_, int p_i4005_2_, int p_i4005_3_, Material p_i4005_4_, boolean p_i4005_5_)
    {
        super(p_i4005_1_, p_i4005_2_, p_i4005_4_);
        field_72164_a = p_i4005_3_;
        field_72163_b = p_i4005_5_;
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        if(!field_72163_b)
        {
            return 0;
        } else
        {
            return super.func_71885_a(p_71885_1_, p_71885_2_, p_71885_3_);
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

    public int func_71857_b()
    {
        return 18;
    }

    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        int i = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_);
        if(i == field_71990_ca)
        {
            return false;
        } else
        {
            return super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_);
        }
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        boolean flag = func_72161_e(p_71871_1_.func_72798_a(p_71871_2_, p_71871_3_, p_71871_4_ - 1));
        boolean flag1 = func_72161_e(p_71871_1_.func_72798_a(p_71871_2_, p_71871_3_, p_71871_4_ + 1));
        boolean flag2 = func_72161_e(p_71871_1_.func_72798_a(p_71871_2_ - 1, p_71871_3_, p_71871_4_));
        boolean flag3 = func_72161_e(p_71871_1_.func_72798_a(p_71871_2_ + 1, p_71871_3_, p_71871_4_));
        if(flag2 && flag3 || !flag2 && !flag3 && !flag && !flag1)
        {
            func_71905_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        } else
        if(flag2 && !flag3)
        {
            func_71905_a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        } else
        if(!flag2 && flag3)
        {
            func_71905_a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        }
        if(flag && flag1 || !flag2 && !flag3 && !flag && !flag1)
        {
            func_71905_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        } else
        if(flag && !flag1)
        {
            func_71905_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        } else
        if(!flag && flag1)
        {
            func_71905_a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        }
    }

    public void func_71919_f()
    {
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        boolean flag = func_72161_e(p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_, p_71902_4_ - 1));
        boolean flag1 = func_72161_e(p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_, p_71902_4_ + 1));
        boolean flag2 = func_72161_e(p_71902_1_.func_72798_a(p_71902_2_ - 1, p_71902_3_, p_71902_4_));
        boolean flag3 = func_72161_e(p_71902_1_.func_72798_a(p_71902_2_ + 1, p_71902_3_, p_71902_4_));
        if(flag2 && flag3 || !flag2 && !flag3 && !flag && !flag1)
        {
            f = 0.0F;
            f1 = 1.0F;
        } else
        if(flag2 && !flag3)
        {
            f = 0.0F;
        } else
        if(!flag2 && flag3)
        {
            f1 = 1.0F;
        }
        if(flag && flag1 || !flag2 && !flag3 && !flag && !flag1)
        {
            f2 = 0.0F;
            f3 = 1.0F;
        } else
        if(flag && !flag1)
        {
            f2 = 0.0F;
        } else
        if(!flag && flag1)
        {
            f3 = 1.0F;
        }
        func_71905_a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public int func_72162_n()
    {
        return field_72164_a;
    }

    public final boolean func_72161_e(int p_72161_1_)
    {
        return Block.field_71970_n[p_72161_1_] || p_72161_1_ == field_71990_ca || p_72161_1_ == Block.field_71946_M.field_71990_ca;
    }

    protected boolean func_71906_q_()
    {
        return true;
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        return new ItemStack(field_71990_ca, 1, p_71880_1_);
    }
}
