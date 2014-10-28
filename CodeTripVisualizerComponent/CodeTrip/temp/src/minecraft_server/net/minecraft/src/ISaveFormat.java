// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ISaveHandler, IProgressUpdate

public interface ISaveFormat
{

    public abstract ISaveHandler func_75804_a(String s, boolean flag);

    public abstract void func_75800_d();

    public abstract void func_75802_e(String s);

    public abstract boolean func_75801_b(String s);

    public abstract boolean func_75805_a(String s, IProgressUpdate iprogressupdate);
}
