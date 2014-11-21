// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.net.SocketAddress;

// Referenced classes of package net.minecraft.src:
//            NetHandler, Packet

public interface NetworkManager
{

    public abstract void func_74425_a(NetHandler nethandler);

    public abstract void func_74429_a(Packet packet);

    public abstract void func_74427_a();

    public abstract void func_74428_b();

    public abstract SocketAddress func_74430_c();

    public abstract void func_74423_d();

    public abstract int func_74426_e();

    public abstract void func_74424_a(String s, Object aobj[]);

    public abstract void func_74431_f();
}
