// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, IBlockAccess, Material

public class BlockLeavesBase extends Block
{

    protected boolean field_72131_c;

    protected BlockLeavesBase(int p_i4014_1_, int p_i4014_2_, Material p_i4014_3_, boolean p_i4014_4_)
    {
        super(p_i4014_1_, p_i4014_2_, p_i4014_3_);
        field_72131_c = p_i4014_4_;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        int i = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_);
        if(!field_72131_c && i == field_71990_ca)
        {
            return false;
        } else
        {
            return super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_);
        }
    }
}
