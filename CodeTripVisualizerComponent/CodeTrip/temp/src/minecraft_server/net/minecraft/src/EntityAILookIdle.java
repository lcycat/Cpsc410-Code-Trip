// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, EntityLookHelper

public class EntityAILookIdle extends EntityAIBase
{

    private EntityLiving field_75258_a;
    private double field_75256_b;
    private double field_75257_c;
    private int field_75255_d;

    public EntityAILookIdle(EntityLiving p_i3488_1_)
    {
        field_75255_d = 0;
        field_75258_a = p_i3488_1_;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        return field_75258_a.func_70681_au().nextFloat() < 0.02F;
    }

    public boolean func_75253_b()
    {
        return field_75255_d >= 0;
    }

    public void func_75249_e()
    {
        double d = 6.2831853071795862D * field_75258_a.func_70681_au().nextDouble();
        field_75256_b = Math.cos(d);
        field_75257_c = Math.sin(d);
        field_75255_d = 20 + field_75258_a.func_70681_au().nextInt(20);
    }

    public void func_75246_d()
    {
        field_75255_d--;
        field_75258_a.func_70671_ap().func_75650_a(field_75258_a.field_70165_t + field_75256_b, field_75258_a.field_70163_u + (double)field_75258_a.func_70047_e(), field_75258_a.field_70161_v + field_75257_c, 10F, field_75258_a.func_70646_bf());
    }
}
