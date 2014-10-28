// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, IBlockAccess, Material

public class BlockBreakable extends Block
{

    private boolean field_72245_a;

    protected BlockBreakable(int p_i3955_1_, int p_i3955_2_, Material p_i3955_3_, boolean p_i3955_4_)
    {
        super(p_i3955_1_, p_i3955_2_, p_i3955_3_);
        field_72245_a = p_i3955_4_;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        int i = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_);
        if(!field_72245_a && i == field_71990_ca)
        {
            return false;
        } else
        {
            return super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_);
        }
    }
}
