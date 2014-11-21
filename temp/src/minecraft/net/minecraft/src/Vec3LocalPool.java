// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Vec3Pool

final class Vec3LocalPool extends ThreadLocal
{

    Vec3LocalPool()
    {
    }

    protected Vec3Pool func_72342_a()
    {
        return new Vec3Pool(300, 2000);
    }

    protected Object initialValue()
    {
        return func_72342_a();
    }
}
