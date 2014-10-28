// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class BlockEventData
{

    private int field_76927_a;
    private int field_76925_b;
    private int field_76926_c;
    private int field_76923_d;
    private int field_76924_e;
    private int field_76922_f;

    public BlockEventData(int p_i3742_1_, int p_i3742_2_, int p_i3742_3_, int p_i3742_4_, int p_i3742_5_, int p_i3742_6_)
    {
        field_76927_a = p_i3742_1_;
        field_76925_b = p_i3742_2_;
        field_76926_c = p_i3742_3_;
        field_76924_e = p_i3742_5_;
        field_76922_f = p_i3742_6_;
        field_76923_d = p_i3742_4_;
    }

    public int func_76919_a()
    {
        return field_76927_a;
    }

    public int func_76921_b()
    {
        return field_76925_b;
    }

    public int func_76920_c()
    {
        return field_76926_c;
    }

    public int func_76918_d()
    {
        return field_76924_e;
    }

    public int func_76917_e()
    {
        return field_76922_f;
    }

    public int func_76916_f()
    {
        return field_76923_d;
    }

    public boolean equals(Object p_equals_1_)
    {
        if(p_equals_1_ instanceof BlockEventData)
        {
            BlockEventData blockeventdata = (BlockEventData)p_equals_1_;
            return field_76927_a == blockeventdata.field_76927_a && field_76925_b == blockeventdata.field_76925_b && field_76926_c == blockeventdata.field_76926_c && field_76924_e == blockeventdata.field_76924_e && field_76922_f == blockeventdata.field_76922_f && field_76923_d == blockeventdata.field_76923_d;
        } else
        {
            return false;
        }
    }
}
