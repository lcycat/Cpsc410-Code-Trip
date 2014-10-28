// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, Item

public class BlockClay extends Block
{

    public BlockClay(int p_i3929_1_, int p_i3929_2_)
    {
        super(p_i3929_1_, p_i3929_2_, Material.field_76267_y);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77757_aI.field_77779_bT;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 4;
    }
}
