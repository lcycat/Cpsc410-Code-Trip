// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockSand, Item

public class BlockGravel extends BlockSand
{

    public BlockGravel(int p_i3953_1_, int p_i3953_2_)
    {
        super(p_i3953_1_, p_i3953_2_);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        if(p_71885_2_.nextInt(10 - p_71885_3_ * 3) == 0)
        {
            return Item.field_77804_ap.field_77779_bT;
        } else
        {
            return field_71990_ca;
        }
    }
}
