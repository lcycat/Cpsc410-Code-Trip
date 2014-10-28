// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class ChatLine
{

    private final int field_74543_a;
    private final String field_74541_b;
    private final int field_74542_c;

    public ChatLine(int p_i3021_1_, String p_i3021_2_, int p_i3021_3_)
    {
        field_74541_b = p_i3021_2_;
        field_74543_a = p_i3021_1_;
        field_74542_c = p_i3021_3_;
    }

    public String func_74538_a()
    {
        return field_74541_b;
    }

    public int func_74540_b()
    {
        return field_74543_a;
    }

    public int func_74539_c()
    {
        return field_74542_c;
    }
}
