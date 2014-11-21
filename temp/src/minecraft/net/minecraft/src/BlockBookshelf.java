// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, Item

public class BlockBookshelf extends Block
{

    public BlockBookshelf(int p_i3920_1_, int p_i3920_2_)
    {
        super(p_i3920_1_, p_i3920_2_, Material.field_76245_d);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ <= 1)
        {
            return 4;
        } else
        {
            return field_72059_bZ;
        }
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 3;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77760_aL.field_77779_bT;
    }
}
