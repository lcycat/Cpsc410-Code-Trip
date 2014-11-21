// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs

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

}
