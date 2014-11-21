// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumOS extends Enum
{

    public static final EnumOS LINUX;
    public static final EnumOS SOLARIS;
    public static final EnumOS WINDOWS;
    public static final EnumOS MACOS;
    public static final EnumOS UNKNOWN;
    private static final EnumOS $VALUES[]; /* synthetic field */

    public static EnumOS[] values()
    {
        return (EnumOS[])$VALUES.clone();
    }

    public static EnumOS valueOf(String p_valueOf_0_)
    {
        return (EnumOS)Enum.valueOf(net.minecraft.src.EnumOS.class, p_valueOf_0_);
    }

    private EnumOS(String p_i3023_1_, int p_i3023_2_)
    {
        super(p_i3023_1_, p_i3023_2_);
    }

    static 
    {
        LINUX = new EnumOS("LINUX", 0);
        SOLARIS = new EnumOS("SOLARIS", 1);
        WINDOWS = new EnumOS("WINDOWS", 2);
        MACOS = new EnumOS("MACOS", 3);
        UNKNOWN = new EnumOS("UNKNOWN", 4);
        $VALUES = (new EnumOS[] {
            LINUX, SOLARIS, WINDOWS, MACOS, UNKNOWN
        });
    }
}
