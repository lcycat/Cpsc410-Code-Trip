// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs

public class BlockOreStorage extends Block
{

    public BlockOreStorage(int p_i3969_1_, int p_i3969_2_)
    {
        super(p_i3969_1_, Material.field_76243_f);
        field_72059_bZ = p_i3969_2_;
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71851_a(int p_71851_1_)
    {
        return field_72059_bZ;
    }
}
