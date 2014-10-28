// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EnumOS

public class EnumOSHelper
{

    public static final int field_74533_a[]; /* synthetic field */

    static 
    {
        field_74533_a = new int[EnumOS.values().length];
        try
        {
            field_74533_a[EnumOS.LINUX.ordinal()] = 1;
        }
        catch(NoSuchFieldError nosuchfielderror) { }
        try
        {
            field_74533_a[EnumOS.SOLARIS.ordinal()] = 2;
        }
        catch(NoSuchFieldError nosuchfielderror1) { }
        try
        {
            field_74533_a[EnumOS.WINDOWS.ordinal()] = 3;
        }
        catch(NoSuchFieldError nosuchfielderror2) { }
        try
        {
            field_74533_a[EnumOS.MACOS.ordinal()] = 4;
        }
        catch(NoSuchFieldError nosuchfielderror3) { }
    }
}
