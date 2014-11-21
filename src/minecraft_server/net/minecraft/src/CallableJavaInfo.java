package net.minecraft.src;

import java.util.concurrent.Callable;

class CallableJavaInfo implements Callable
{
    final CrashReport field_71490_a;

    CallableJavaInfo(CrashReport par1CrashReport)
    {
        field_71490_a = par1CrashReport;
    }

    public String func_71489_a()
    {
        return (new StringBuilder()).append(System.getProperty("java.version")).append(", ").append(System.getProperty("java.vendor")).toString();
    }

    public Object call()
    {
        return func_71489_a();
    }
}
