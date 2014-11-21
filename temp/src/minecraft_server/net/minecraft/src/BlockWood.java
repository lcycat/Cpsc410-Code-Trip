// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs

public class BlockWood extends Block
{

    public static final String field_72152_a[] = {
        "oak", "spruce", "birch", "jungle"
    };

    public BlockWood(int p_i4023_1_)
    {
        super(p_i4023_1_, 4, Material.field_76245_d);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        switch(p_71858_2_)
        {
        default:
            return 4;

        case 1: // '\001'
            return 198;

        case 2: // '\002'
            return 214;

        case 3: // '\003'
            return 199;
        }
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_;
    }

}
