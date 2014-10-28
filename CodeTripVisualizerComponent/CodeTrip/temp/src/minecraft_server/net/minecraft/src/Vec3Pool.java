// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Vec3

public class Vec3Pool
{

    private final int field_72351_a;
    private final int field_72349_b;
    private final List field_72350_c = new ArrayList();
    private int field_72347_d;
    private int field_72348_e;
    private int field_72346_f;

    public Vec3Pool(int p_i4035_1_, int p_i4035_2_)
    {
        field_72347_d = 0;
        field_72348_e = 0;
        field_72346_f = 0;
        field_72351_a = p_i4035_1_;
        field_72349_b = p_i4035_2_;
    }

    public Vec3 func_72345_a(double p_72345_1_, double p_72345_3_, double p_72345_5_)
    {
        Vec3 vec3;
        if(field_72347_d >= field_72350_c.size())
        {
            vec3 = new Vec3(p_72345_1_, p_72345_3_, p_72345_5_);
            field_72350_c.add(vec3);
        } else
        {
            vec3 = (Vec3)field_72350_c.get(field_72347_d);
            vec3.func_72439_b(p_72345_1_, p_72345_3_, p_72345_5_);
        }
        field_72347_d++;
        return vec3;
    }

    public void func_72343_a()
    {
        if(field_72347_d > field_72348_e)
        {
            field_72348_e = field_72347_d;
        }
        if(field_72346_f++ == field_72351_a)
        {
            for(int i = Math.max(field_72348_e, field_72350_c.size() - field_72349_b); field_72350_c.size() > i; field_72350_c.remove(i)) { }
            field_72348_e = 0;
            field_72346_f = 0;
        }
        field_72347_d = 0;
    }
}
