// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

public abstract class BlockDirectional extends Block
{

    protected BlockDirectional(int p_i3935_1_, int p_i3935_2_, Material p_i3935_3_)
    {
        super(p_i3935_1_, p_i3935_2_, p_i3935_3_);
    }

    protected BlockDirectional(int p_i3936_1_, Material p_i3936_2_)
    {
        super(p_i3936_1_, p_i3936_2_);
    }

    public static int func_72217_d(int p_72217_0_)
    {
        return p_72217_0_ & 3;
    }
}
