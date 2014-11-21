// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            AABBPool

final class AABBLocalPool extends ThreadLocal
{

    AABBLocalPool()
    {
    }

    protected AABBPool func_72341_a()
    {
        return new AABBPool(300, 2000);
    }

    protected Object initialValue()
    {
        return func_72341_a();
    }
}
