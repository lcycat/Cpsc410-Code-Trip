// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class StepSound
{

    public final String field_72681_a;
    public final float field_72679_b;
    public final float field_72680_c;

    public StepSound(String p_i4008_1_, float p_i4008_2_, float p_i4008_3_)
    {
        field_72681_a = p_i4008_1_;
        field_72679_b = p_i4008_2_;
        field_72680_c = p_i4008_3_;
    }

    public float func_72677_b()
    {
        return field_72679_b;
    }

    public float func_72678_c()
    {
        return field_72680_c;
    }

    public String func_72676_a()
    {
        return (new StringBuilder()).append("step.").append(field_72681_a).toString();
    }

    public String func_72675_d()
    {
        return (new StringBuilder()).append("step.").append(field_72681_a).toString();
    }
}
