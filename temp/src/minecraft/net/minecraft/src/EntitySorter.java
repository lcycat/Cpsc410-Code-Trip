// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Comparator;

// Referenced classes of package net.minecraft.src:
//            Entity, WorldRenderer

public class EntitySorter
    implements Comparator
{

    private double field_78949_a;
    private double field_78947_b;
    private double field_78948_c;

    public EntitySorter(Entity p_i3189_1_)
    {
        field_78949_a = -p_i3189_1_.field_70165_t;
        field_78947_b = -p_i3189_1_.field_70163_u;
        field_78948_c = -p_i3189_1_.field_70161_v;
    }

    public int func_78946_a(WorldRenderer p_78946_1_, WorldRenderer p_78946_2_)
    {
        double d = (double)p_78946_1_.field_78925_n + field_78949_a;
        double d1 = (double)p_78946_1_.field_78926_o + field_78947_b;
        double d2 = (double)p_78946_1_.field_78940_p + field_78948_c;
        double d3 = (double)p_78946_2_.field_78925_n + field_78949_a;
        double d4 = (double)p_78946_2_.field_78926_o + field_78947_b;
        double d5 = (double)p_78946_2_.field_78940_p + field_78948_c;
        return (int)(((d * d + d1 * d1 + d2 * d2) - (d3 * d3 + d4 * d4 + d5 * d5)) * 1024D);
    }

    public int compare(Object p_compare_1_, Object p_compare_2_)
    {
        return func_78946_a((WorldRenderer)p_compare_1_, (WorldRenderer)p_compare_2_);
    }
}
