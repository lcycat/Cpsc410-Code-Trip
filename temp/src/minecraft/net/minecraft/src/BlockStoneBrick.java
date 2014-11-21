// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, ItemStack

public class BlockStoneBrick extends Block
{

    public static final String field_72188_a[] = {
        "default", "mossy", "cracked", "chiseled"
    };

    public BlockStoneBrick(int p_i3994_1_)
    {
        super(p_i3994_1_, 54, Material.field_76246_e);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        switch(p_71858_2_)
        {
        default:
            return 54;

        case 1: // '\001'
            return 100;

        case 2: // '\002'
            return 101;

        case 3: // '\003'
            return 213;
        }
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_;
    }

    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        for(int i = 0; i < 4; i++)
        {
            p_71879_3_.add(new ItemStack(p_71879_1_, 1, i));
        }

    }

}
