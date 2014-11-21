// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityAITarget, EntityLiving, AxisAlignedBB, AABBPool, 
//            World

public class EntityAIHurtByTarget extends EntityAITarget
{

    boolean field_75312_a;
    EntityLiving field_75311_b;

    public EntityAIHurtByTarget(EntityLiving p_i3498_1_, boolean p_i3498_2_)
    {
        super(p_i3498_1_, 16F, false);
        field_75312_a = p_i3498_2_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        return func_75296_a(field_75299_d.func_70643_av(), true);
    }

    public boolean func_75253_b()
    {
        return field_75299_d.func_70643_av() != null && field_75299_d.func_70643_av() != field_75311_b;
    }

    public void func_75249_e()
    {
        field_75299_d.func_70624_b(field_75299_d.func_70643_av());
        field_75311_b = field_75299_d.func_70643_av();
        if(field_75312_a)
        {
            List list = field_75299_d.field_70170_p.func_72872_a(field_75299_d.getClass(), AxisAlignedBB.func_72332_a().func_72299_a(field_75299_d.field_70165_t, field_75299_d.field_70163_u, field_75299_d.field_70161_v, field_75299_d.field_70165_t + 1.0D, field_75299_d.field_70163_u + 1.0D, field_75299_d.field_70161_v + 1.0D).func_72314_b(field_75300_e, 4D, field_75300_e));
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                EntityLiving entityliving = (EntityLiving)iterator.next();
                if(field_75299_d != entityliving && entityliving.func_70638_az() == null)
                {
                    entityliving.func_70624_b(field_75299_d.func_70643_av());
                }
            } while(true);
        }
        super.func_75249_e();
    }
}
