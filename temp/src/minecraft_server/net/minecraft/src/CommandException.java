// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class CommandException extends RuntimeException
{

    private Object field_74845_a[];

    public CommandException(String p_i3254_1_, Object p_i3254_2_[])
    {
        super(p_i3254_1_);
        field_74845_a = p_i3254_2_;
    }

    public Object[] func_74844_a()
    {
        return field_74845_a;
    }
}
