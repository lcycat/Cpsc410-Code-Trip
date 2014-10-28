// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

public abstract class StructurePieceBlockSelector
{

    protected int field_75066_a;
    protected int field_75065_b;

    protected StructurePieceBlockSelector()
    {
    }

    public abstract void func_75062_a(Random random, int i, int j, int k, boolean flag);

    public int func_75063_a()
    {
        return field_75066_a;
    }

    public int func_75064_b()
    {
        return field_75065_b;
    }
}
