// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            CrashReport

public class ReportedException extends RuntimeException
{

    private final CrashReport field_71576_a;

    public ReportedException(CrashReport p_i3253_1_)
    {
        field_71576_a = p_i3253_1_;
    }

    public CrashReport func_71575_a()
    {
        return field_71576_a;
    }

    public Throwable getCause()
    {
        return field_71576_a.func_71505_b();
    }

    public String getMessage()
    {
        return field_71576_a.func_71501_a();
    }
}
