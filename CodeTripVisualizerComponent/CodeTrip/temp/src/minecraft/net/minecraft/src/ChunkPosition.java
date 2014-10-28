// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Vec3, MathHelper

public class ChunkPosition
{

    public final int field_76930_a;
    public final int field_76928_b;
    public final int field_76929_c;

    public ChunkPosition(int p_i3743_1_, int p_i3743_2_, int p_i3743_3_)
    {
        field_76930_a = p_i3743_1_;
        field_76928_b = p_i3743_2_;
        field_76929_c = p_i3743_3_;
    }

    public ChunkPosition(Vec3 p_i3744_1_)
    {
        this(MathHelper.func_76128_c(p_i3744_1_.field_72450_a), MathHelper.func_76128_c(p_i3744_1_.field_72448_b), MathHelper.func_76128_c(p_i3744_1_.field_72449_c));
    }

    public boolean equals(Object p_equals_1_)
    {
        if(p_equals_1_ instanceof ChunkPosition)
        {
            ChunkPosition chunkposition = (ChunkPosition)p_equals_1_;
            return chunkposition.field_76930_a == field_76930_a && chunkposition.field_76928_b == field_76928_b && chunkposition.field_76929_c == field_76929_c;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return field_76930_a * 0x88f9fa + field_76928_b * 0xef88b + field_76929_c;
    }
}
