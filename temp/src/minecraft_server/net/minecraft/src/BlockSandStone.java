// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs

public class BlockSandStone extends Block
{

    public static final String field_72189_a[] = {
        "default", "chiseled", "smooth"
    };

    public BlockSandStone(int p_i3990_1_)
    {
        super(p_i3990_1_, 192, Material.field_76246_e);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_1_ == 1 || p_71858_1_ == 0 && (p_71858_2_ == 1 || p_71858_2_ == 2))
        {
            return 176;
        }
        if(p_71858_1_ == 0)
        {
            return 208;
        }
        if(p_71858_2_ == 1)
        {
            return 229;
        }
        return p_71858_2_ != 2 ? 192 : 230;
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ - 16;
        }
        if(p_71851_1_ == 0)
        {
            return field_72059_bZ + 16;
        } else
        {
            return field_72059_bZ;
        }
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_;
    }

}
