// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            AxisAlignedBB

public class BlockLadder extends Block
{

    protected BlockLadder(int p_i3960_1_, int p_i3960_2_)
    {
        super(p_i3960_1_, p_i3960_2_, Material.field_76265_p);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        int i = p_71872_1_.func_72805_g(p_71872_2_, p_71872_3_, p_71872_4_);
        float f = 0.125F;
        if(i == 2)
        {
            func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(i == 3)
        {
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(i == 4)
        {
            func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(i == 5)
        {
            func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.func_71872_e(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
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
        return 8;
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        if(p_71930_1_.func_72809_s(p_71930_2_ - 1, p_71930_3_, p_71930_4_))
        {
            return true;
        }
        if(p_71930_1_.func_72809_s(p_71930_2_ + 1, p_71930_3_, p_71930_4_))
        {
            return true;
        }
        if(p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ - 1))
        {
            return true;
        }
        return p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ + 1);
    }

    public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, 
            float p_71909_8_)
    {
        int i = p_71909_1_.func_72805_g(p_71909_2_, p_71909_3_, p_71909_4_);
        if((i == 0 || p_71909_5_ == 2) && p_71909_1_.func_72809_s(p_71909_2_, p_71909_3_, p_71909_4_ + 1))
        {
            i = 2;
        }
        if((i == 0 || p_71909_5_ == 3) && p_71909_1_.func_72809_s(p_71909_2_, p_71909_3_, p_71909_4_ - 1))
        {
            i = 3;
        }
        if((i == 0 || p_71909_5_ == 4) && p_71909_1_.func_72809_s(p_71909_2_ + 1, p_71909_3_, p_71909_4_))
        {
            i = 4;
        }
        if((i == 0 || p_71909_5_ == 5) && p_71909_1_.func_72809_s(p_71909_2_ - 1, p_71909_3_, p_71909_4_))
        {
            i = 5;
        }
        p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, i);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
        boolean flag = false;
        if(i == 2 && p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ + 1))
        {
            flag = true;
        }
        if(i == 3 && p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ - 1))
        {
            flag = true;
        }
        if(i == 4 && p_71863_1_.func_72809_s(p_71863_2_ + 1, p_71863_3_, p_71863_4_))
        {
            flag = true;
        }
        if(i == 5 && p_71863_1_.func_72809_s(p_71863_2_ - 1, p_71863_3_, p_71863_4_))
        {
            flag = true;
        }
        if(!flag)
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i, 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
        super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 1;
    }
}
