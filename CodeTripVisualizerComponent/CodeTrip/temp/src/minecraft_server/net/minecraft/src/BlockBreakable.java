// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

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
}
