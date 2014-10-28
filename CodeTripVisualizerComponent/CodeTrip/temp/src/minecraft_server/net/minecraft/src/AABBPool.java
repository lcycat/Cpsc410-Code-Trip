// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            AxisAlignedBB

public class AABBPool
{

    private final int field_72306_a;
    private final int field_72304_b;
    private final List field_72305_c = new ArrayList();
    private int field_72302_d;
    private int field_72303_e;
    private int field_72301_f;

    public AABBPool(int p_i4030_1_, int p_i4030_2_)
    {
        field_72302_d = 0;
        field_72303_e = 0;
        field_72301_f = 0;
        field_72306_a = p_i4030_1_;
        field_72304_b = p_i4030_2_;
    }

    public AxisAlignedBB func_72299_a(double p_72299_1_, double p_72299_3_, double p_72299_5_, double p_72299_7_, double p_72299_9_, double p_72299_11_)
    {
        AxisAlignedBB axisalignedbb;
        if(field_72302_d >= field_72305_c.size())
        {
            axisalignedbb = new AxisAlignedBB(p_72299_1_, p_72299_3_, p_72299_5_, p_72299_7_, p_72299_9_, p_72299_11_);
            field_72305_c.add(axisalignedbb);
        } else
        {
            axisalignedbb = (AxisAlignedBB)field_72305_c.get(field_72302_d);
            axisalignedbb.func_72324_b(p_72299_1_, p_72299_3_, p_72299_5_, p_72299_7_, p_72299_9_, p_72299_11_);
        }
        field_72302_d++;
        return axisalignedbb;
    }

    public void func_72298_a()
    {
        if(field_72302_d > field_72303_e)
        {
            field_72303_e = field_72302_d;
        }
        if(field_72301_f++ == field_72306_a)
        {
            for(int i = Math.max(field_72303_e, field_72305_c.size() - field_72304_b); field_72305_c.size() > i; field_72305_c.remove(i)) { }
            field_72303_e = 0;
            field_72301_f = 0;
        }
        field_72302_d = 0;
    }
}
