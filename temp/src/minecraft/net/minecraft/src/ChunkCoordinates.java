// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class ChunkCoordinates
    implements Comparable
{

    public int field_71574_a;
    public int field_71572_b;
    public int field_71573_c;

    public ChunkCoordinates()
    {
    }

    public ChunkCoordinates(int p_i3251_1_, int p_i3251_2_, int p_i3251_3_)
    {
        field_71574_a = p_i3251_1_;
        field_71572_b = p_i3251_2_;
        field_71573_c = p_i3251_3_;
    }

    public ChunkCoordinates(ChunkCoordinates p_i3252_1_)
    {
        field_71574_a = p_i3252_1_.field_71574_a;
        field_71572_b = p_i3252_1_.field_71572_b;
        field_71573_c = p_i3252_1_.field_71573_c;
    }

    public boolean equals(Object p_equals_1_)
    {
        if(!(p_equals_1_ instanceof ChunkCoordinates))
        {
            return false;
        } else
        {
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)p_equals_1_;
            return field_71574_a == chunkcoordinates.field_71574_a && field_71572_b == chunkcoordinates.field_71572_b && field_71573_c == chunkcoordinates.field_71573_c;
        }
    }

    public int hashCode()
    {
        return field_71574_a + field_71573_c << 8 + field_71572_b << 16;
    }

    public int func_71570_a(ChunkCoordinates p_71570_1_)
    {
        if(field_71572_b == p_71570_1_.field_71572_b)
        {
            if(field_71573_c == p_71570_1_.field_71573_c)
            {
                return field_71574_a - p_71570_1_.field_71574_a;
            } else
            {
                return field_71573_c - p_71570_1_.field_71573_c;
            }
        } else
        {
            return field_71572_b - p_71570_1_.field_71572_b;
        }
    }

    public void func_71571_b(int p_71571_1_, int p_71571_2_, int p_71571_3_)
    {
        field_71574_a = p_71571_1_;
        field_71572_b = p_71571_2_;
        field_71573_c = p_71571_3_;
    }

    public float func_71569_e(int p_71569_1_, int p_71569_2_, int p_71569_3_)
    {
        int i = field_71574_a - p_71569_1_;
        int j = field_71572_b - p_71569_2_;
        int k = field_71573_c - p_71569_3_;
        return (float)(i * i + j * j + k * k);
    }

    public int compareTo(Object p_compareTo_1_)
    {
        return func_71570_a((ChunkCoordinates)p_compareTo_1_);
    }
}
