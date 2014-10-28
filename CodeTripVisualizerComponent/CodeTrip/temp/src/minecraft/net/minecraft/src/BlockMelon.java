// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, Item

public class BlockMelon extends Block
{

    protected BlockMelon(int p_i3968_1_)
    {
        super(p_i3968_1_, Material.field_76266_z);
        field_72059_bZ = 136;
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return p_71858_1_ != 1 && p_71858_1_ != 0 ? 136 : 137;
    }

    public int func_71851_a(int p_71851_1_)
    {
        return p_71851_1_ != 1 && p_71851_1_ != 0 ? 136 : 137;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77738_bf.field_77779_bT;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 3 + p_71925_1_.nextInt(5);
    }

    public int func_71910_a(int p_71910_1_, Random p_71910_2_)
    {
        int i = func_71925_a(p_71910_2_) + p_71910_2_.nextInt(1 + p_71910_1_);
        if(i > 9)
        {
            i = 9;
        }
        return i;
    }
}
