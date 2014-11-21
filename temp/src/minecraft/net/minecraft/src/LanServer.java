// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class LanServer
{

    private String field_77492_a;
    private String field_77490_b;
    private long field_77491_c;

    public LanServer(String p_i3119_1_, String p_i3119_2_)
    {
        field_77492_a = p_i3119_1_;
        field_77490_b = p_i3119_2_;
        field_77491_c = Minecraft.func_71386_F();
    }

    public String func_77487_a()
    {
        return field_77492_a;
    }

    public String func_77488_b()
    {
        return field_77490_b;
    }

    public void func_77489_c()
    {
        field_77491_c = Minecraft.func_71386_F();
    }
}
