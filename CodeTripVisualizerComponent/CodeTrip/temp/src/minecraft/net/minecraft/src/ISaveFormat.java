// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            ISaveHandler, WorldInfo, IProgressUpdate

public interface ISaveFormat
{

    public abstract ISaveHandler func_75804_a(String s, boolean flag);

    public abstract List func_75799_b();

    public abstract void func_75800_d();

    public abstract WorldInfo func_75803_c(String s);

    public abstract void func_75802_e(String s);

    public abstract void func_75806_a(String s, String s1);

    public abstract boolean func_75801_b(String s);

    public abstract boolean func_75805_a(String s, IProgressUpdate iprogressupdate);
}
