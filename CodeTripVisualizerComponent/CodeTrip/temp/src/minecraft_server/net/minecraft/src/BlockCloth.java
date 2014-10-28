// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs

public class BlockCloth extends Block
{

    public BlockCloth()
    {
        super(35, 64, Material.field_76253_m);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_2_ == 0)
        {
            return field_72059_bZ;
        } else
        {
            p_71858_2_ = ~(p_71858_2_ & 0xf);
            return 113 + ((p_71858_2_ & 8) >> 3) + (p_71858_2_ & 7) * 16;
        }
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_;
    }

    public static int func_72238_e_(int p_72238_0_)
    {
        return ~p_72238_0_ & 0xf;
    }

    public static int func_72239_d(int p_72239_0_)
    {
        return ~p_72239_0_ & 0xf;
    }
}
