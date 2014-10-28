// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class WatchableObject
{

    private final int field_75678_a;
    private final int field_75676_b;
    private Object field_75677_c;
    private boolean field_75675_d;

    public WatchableObject(int p_i3451_1_, int p_i3451_2_, Object p_i3451_3_)
    {
        field_75676_b = p_i3451_2_;
        field_75677_c = p_i3451_3_;
        field_75678_a = p_i3451_1_;
        field_75675_d = true;
    }

    public int func_75672_a()
    {
        return field_75676_b;
    }

    public void func_75673_a(Object p_75673_1_)
    {
        field_75677_c = p_75673_1_;
    }

    public Object func_75669_b()
    {
        return field_75677_c;
    }

    public int func_75674_c()
    {
        return field_75678_a;
    }

    public boolean func_75670_d()
    {
        return field_75675_d;
    }

    public void func_75671_a(boolean p_75671_1_)
    {
        field_75675_d = p_75671_1_;
    }
}
