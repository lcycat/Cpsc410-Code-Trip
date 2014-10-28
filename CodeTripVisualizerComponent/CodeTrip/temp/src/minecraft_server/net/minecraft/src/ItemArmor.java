// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EnumArmorMaterial, CreativeTabs

public class ItemArmor extends Item
{

    private static final int field_77882_bY[] = {
        11, 16, 15, 13
    };
    public final int field_77881_a;
    public final int field_77879_b;
    public final int field_77880_c;
    private final EnumArmorMaterial field_77878_bZ;

    public ItemArmor(int p_i3619_1_, EnumArmorMaterial p_i3619_2_, int p_i3619_3_, int p_i3619_4_)
    {
        super(p_i3619_1_);
        field_77878_bZ = p_i3619_2_;
        field_77881_a = p_i3619_4_;
        field_77880_c = p_i3619_3_;
        field_77879_b = p_i3619_2_.func_78044_b(p_i3619_4_);
        func_77656_e(p_i3619_2_.func_78046_a(p_i3619_4_));
        field_77777_bU = 1;
        func_77637_a(CreativeTabs.field_78037_j);
    }

    public int func_77619_b()
    {
        return field_77878_bZ.func_78045_a();
    }

    static int[] func_77877_c()
    {
        return field_77882_bY;
    }

}
