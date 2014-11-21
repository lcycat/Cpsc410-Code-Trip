// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ChunkPosition

public class ChunkCoordIntPair
{

    public final int field_77276_a;
    public final int field_77275_b;

    public ChunkCoordIntPair(int p_i3726_1_, int p_i3726_2_)
    {
        field_77276_a = p_i3726_1_;
        field_77275_b = p_i3726_2_;
    }

    public static long func_77272_a(int p_77272_0_, int p_77272_1_)
    {
        return (long)p_77272_0_ & 0xffffffffL | ((long)p_77272_1_ & 0xffffffffL) << 32;
    }

    public int hashCode()
    {
        long l = func_77272_a(field_77276_a, field_77275_b);
        int i = (int)l;
        int j = (int)(l >> 32);
        return i ^ j;
    }

    public boolean equals(Object p_equals_1_)
    {
        ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)p_equals_1_;
        return chunkcoordintpair.field_77276_a == field_77276_a && chunkcoordintpair.field_77275_b == field_77275_b;
    }

    public int func_77273_a()
    {
        return (field_77276_a << 4) + 8;
    }

    public int func_77274_b()
    {
        return (field_77275_b << 4) + 8;
    }

    public ChunkPosition func_77271_a(int p_77271_1_)
    {
        return new ChunkPosition(func_77273_a(), p_77271_1_, func_77274_b());
    }

    public String toString()
    {
        return (new StringBuilder()).append("[").append(field_77276_a).append(", ").append(field_77275_b).append("]").toString();
    }
}
