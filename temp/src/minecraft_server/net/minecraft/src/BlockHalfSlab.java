// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, IBlockAccess, World, Material, 
//            AxisAlignedBB, Entity

public abstract class BlockHalfSlab extends Block
{

    private final boolean field_72242_a;

    public BlockHalfSlab(int p_i3954_1_, boolean p_i3954_2_, Material p_i3954_3_)
    {
        super(p_i3954_1_, 6, p_i3954_3_);
        field_72242_a = p_i3954_2_;
        if(p_i3954_2_)
        {
            field_71970_n[p_i3954_1_] = true;
        } else
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }
        func_71868_h(255);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        if(field_72242_a)
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        {
            boolean flag = (p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) & 8) != 0;
            if(flag)
            {
                func_71905_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else
            {
                func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            }
        }
    }

    public void func_71919_f()
    {
        if(field_72242_a)
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        func_71902_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
    }

    public int func_71851_a(int p_71851_1_)
    {
        return func_71858_a(p_71851_1_, 0);
    }

    public boolean func_71926_d()
    {
        return field_72242_a;
    }

    public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, 
            float p_71909_8_)
    {
        if(field_72242_a)
        {
            return;
        }
        if(p_71909_5_ == 0 || p_71909_5_ != 1 && (double)p_71909_7_ > 0.5D)
        {
            int i = p_71909_1_.func_72805_g(p_71909_2_, p_71909_3_, p_71909_4_) & 7;
            p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, i | 8);
        }
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return !field_72242_a ? 1 : 2;
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_ & 7;
    }

    public boolean func_71886_c()
    {
        return field_72242_a;
    }

    public abstract String func_72240_d(int i);
}
