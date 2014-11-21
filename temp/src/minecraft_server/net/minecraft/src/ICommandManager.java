// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            ICommandSender

public interface ICommandManager
{

    public abstract void func_71556_a(ICommandSender icommandsender, String s);

    public abstract List func_71558_b(ICommandSender icommandsender, String s);

    public abstract List func_71557_a(ICommandSender icommandsender);

    public abstract Map func_71555_a();
}
