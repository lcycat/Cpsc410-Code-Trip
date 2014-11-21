// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, PathNavigate, EntityLookHelper, 
//            AxisAlignedBB, World

public class EntityAIOcelotAttack extends EntityAIBase
{

    World field_75411_a;
    EntityLiving field_75409_b;
    EntityLiving field_75410_c;
    int field_75408_d;

    public EntityAIOcelotAttack(EntityLiving p_i3485_1_)
    {
        field_75408_d = 0;
        field_75409_b = p_i3485_1_;
        field_75411_a = p_i3485_1_.field_70170_p;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        EntityLiving entityliving = field_75409_b.func_70638_az();
        if(entityliving == null)
        {
            return false;
        } else
        {
            field_75410_c = entityliving;
            return true;
        }
    }

    public boolean func_75253_b()
    {
        if(!field_75410_c.func_70089_S())
        {
            return false;
        }
        if(field_75409_b.func_70068_e(field_75410_c) > 225D)
        {
            return false;
        } else
        {
            return !field_75409_b.func_70661_as().func_75500_f() || func_75250_a();
        }
    }

    public void func_75251_c()
    {
        field_75410_c = null;
        field_75409_b.func_70661_as().func_75499_g();
    }

    public void func_75246_d()
    {
        field_75409_b.func_70671_ap().func_75651_a(field_75410_c, 30F, 30F);
        double d = field_75409_b.field_70130_N * 2.0F * (field_75409_b.field_70130_N * 2.0F);
        double d1 = field_75409_b.func_70092_e(field_75410_c.field_70165_t, field_75410_c.field_70121_D.field_72338_b, field_75410_c.field_70161_v);
        float f = 0.23F;
        if(d1 > d && d1 < 16D)
        {
            f = 0.4F;
        } else
        if(d1 < 225D)
        {
            f = 0.18F;
        }
        field_75409_b.func_70661_as().func_75497_a(field_75410_c, f);
        field_75408_d = Math.max(field_75408_d - 1, 0);
        if(d1 > d)
        {
            return;
        }
        if(field_75408_d > 0)
        {
            return;
        } else
        {
            field_75408_d = 20;
            field_75409_b.func_70652_k(field_75410_c);
            return;
        }
    }
}
