// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, PathNavigate, MathHelper, 
//            EntityLookHelper, EntitySenses, AxisAlignedBB, World, 
//            PathEntity

public class EntityAIAttackOnCollide extends EntityAIBase
{

    World field_75443_a;
    EntityLiving field_75441_b;
    EntityLiving field_75442_c;
    int field_75439_d;
    float field_75440_e;
    boolean field_75437_f;
    PathEntity field_75438_g;
    Class field_75444_h;
    private int field_75445_i;

    public EntityAIAttackOnCollide(EntityLiving p_i3476_1_, Class p_i3476_2_, float p_i3476_3_, boolean p_i3476_4_)
    {
        this(p_i3476_1_, p_i3476_3_, p_i3476_4_);
        field_75444_h = p_i3476_2_;
    }

    public EntityAIAttackOnCollide(EntityLiving p_i3477_1_, float p_i3477_2_, boolean p_i3477_3_)
    {
        field_75439_d = 0;
        field_75441_b = p_i3477_1_;
        field_75443_a = p_i3477_1_.field_70170_p;
        field_75440_e = p_i3477_2_;
        field_75437_f = p_i3477_3_;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        EntityLiving entityliving = field_75441_b.func_70638_az();
        if(entityliving == null)
        {
            return false;
        }
        if(field_75444_h != null && !field_75444_h.isAssignableFrom(entityliving.getClass()))
        {
            return false;
        } else
        {
            field_75442_c = entityliving;
            field_75438_g = field_75441_b.func_70661_as().func_75494_a(field_75442_c);
            return field_75438_g != null;
        }
    }

    public boolean func_75253_b()
    {
        EntityLiving entityliving = field_75441_b.func_70638_az();
        if(entityliving == null)
        {
            return false;
        }
        if(!field_75442_c.func_70089_S())
        {
            return false;
        }
        if(!field_75437_f)
        {
            return !field_75441_b.func_70661_as().func_75500_f();
        }
        return field_75441_b.func_70649_d(MathHelper.func_76128_c(field_75442_c.field_70165_t), MathHelper.func_76128_c(field_75442_c.field_70163_u), MathHelper.func_76128_c(field_75442_c.field_70161_v));
    }

    public void func_75249_e()
    {
        field_75441_b.func_70661_as().func_75484_a(field_75438_g, field_75440_e);
        field_75445_i = 0;
    }

    public void func_75251_c()
    {
        field_75442_c = null;
        field_75441_b.func_70661_as().func_75499_g();
    }

    public void func_75246_d()
    {
        field_75441_b.func_70671_ap().func_75651_a(field_75442_c, 30F, 30F);
        if((field_75437_f || field_75441_b.func_70635_at().func_75522_a(field_75442_c)) && --field_75445_i <= 0)
        {
            field_75445_i = 4 + field_75441_b.func_70681_au().nextInt(7);
            field_75441_b.func_70661_as().func_75497_a(field_75442_c, field_75440_e);
        }
        field_75439_d = Math.max(field_75439_d - 1, 0);
        double d = field_75441_b.field_70130_N * 2.0F * (field_75441_b.field_70130_N * 2.0F);
        if(field_75441_b.func_70092_e(field_75442_c.field_70165_t, field_75442_c.field_70121_D.field_72338_b, field_75442_c.field_70161_v) > d)
        {
            return;
        }
        if(field_75439_d > 0)
        {
            return;
        } else
        {
            field_75439_d = 20;
            field_75441_b.func_70652_k(field_75442_c);
            return;
        }
    }
}
