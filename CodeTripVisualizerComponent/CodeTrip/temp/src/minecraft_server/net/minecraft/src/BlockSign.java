// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, IBlockAccess, TileEntity, 
//            Item, World, AxisAlignedBB

public class BlockSign extends BlockContainer
{

    private Class field_72279_a;
    private boolean field_72278_b;

    protected BlockSign(int p_i3993_1_, Class p_i3993_2_, boolean p_i3993_3_)
    {
        super(p_i3993_1_, Material.field_76245_d);
        field_72278_b = p_i3993_3_;
        field_72059_bZ = 4;
        field_72279_a = p_i3993_2_;
        float f = 0.25F;
        float f1 = 1.0F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        if(field_72278_b)
        {
            return;
        }
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        float f = 0.28125F;
        float f1 = 0.78125F;
        float f2 = 0.0F;
        float f3 = 1.0F;
        float f4 = 0.125F;
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if(i == 2)
        {
            func_71905_a(f2, f, 1.0F - f4, f3, f1, 1.0F);
        }
        if(i == 3)
        {
            func_71905_a(f2, f, 0.0F, f3, f1, f4);
        }
        if(i == 4)
        {
            func_71905_a(1.0F - f4, f, f2, 1.0F, f1, f3);
        }
        if(i == 5)
        {
            func_71905_a(0.0F, f, f2, f4, f1, f3);
        }
    }

    public int func_71857_b()
    {
        return -1;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int i)
    {
        return true;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        try
        {
            return (TileEntity)field_72279_a.newInstance();
        }
        catch(Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77792_au.field_77779_bT;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        boolean flag = false;
        if(field_72278_b)
        {
            if(!p_71863_1_.func_72803_f(p_71863_2_, p_71863_3_ - 1, p_71863_4_).func_76220_a())
            {
                flag = true;
            }
        } else
        {
            int i = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
            flag = true;
            if(i == 2 && p_71863_1_.func_72803_f(p_71863_2_, p_71863_3_, p_71863_4_ + 1).func_76220_a())
            {
                flag = false;
            }
            if(i == 3 && p_71863_1_.func_72803_f(p_71863_2_, p_71863_3_, p_71863_4_ - 1).func_76220_a())
            {
                flag = false;
            }
            if(i == 4 && p_71863_1_.func_72803_f(p_71863_2_ + 1, p_71863_3_, p_71863_4_).func_76220_a())
            {
                flag = false;
            }
            if(i == 5 && p_71863_1_.func_72803_f(p_71863_2_ - 1, p_71863_3_, p_71863_4_).func_76220_a())
            {
                flag = false;
            }
        }
        if(flag)
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
        super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
    }
}
