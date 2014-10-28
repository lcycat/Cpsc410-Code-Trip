// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityVillager, World, EntityIronGolem, 
//            AxisAlignedBB, PathNavigate, EntityLookHelper

public class EntityAIFollowGolem extends EntityAIBase
{

    private EntityVillager field_75294_a;
    private EntityIronGolem field_75292_b;
    private int field_75293_c;
    private boolean field_75291_d;

    public EntityAIFollowGolem(EntityVillager p_i3494_1_)
    {
        field_75291_d = false;
        field_75294_a = p_i3494_1_;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        if(field_75294_a.func_70874_b() >= 0)
        {
            return false;
        }
        if(!field_75294_a.field_70170_p.func_72935_r())
        {
            return false;
        }
        List list = field_75294_a.field_70170_p.func_72872_a(net.minecraft.src.EntityIronGolem.class, field_75294_a.field_70121_D.func_72314_b(6D, 2D, 6D));
        if(list.isEmpty())
        {
            return false;
        }
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityIronGolem entityirongolem = (EntityIronGolem)iterator.next();
            if(entityirongolem.func_70853_p() <= 0)
            {
                continue;
            }
            field_75292_b = entityirongolem;
            break;
        } while(true);
        return field_75292_b != null;
    }

    public boolean func_75253_b()
    {
        return field_75292_b.func_70853_p() > 0;
    }

    public void func_75249_e()
    {
        field_75293_c = field_75294_a.func_70681_au().nextInt(320);
        field_75291_d = false;
        field_75292_b.func_70661_as().func_75499_g();
    }

    public void func_75251_c()
    {
        field_75292_b = null;
        field_75294_a.func_70661_as().func_75499_g();
    }

    public void func_75246_d()
    {
        field_75294_a.func_70671_ap().func_75651_a(field_75292_b, 30F, 30F);
        if(field_75292_b.func_70853_p() == field_75293_c)
        {
            field_75294_a.func_70661_as().func_75497_a(field_75292_b, 0.15F);
            field_75291_d = true;
        }
        if(field_75291_d && field_75294_a.func_70068_e(field_75292_b) < 4D)
        {
            field_75292_b.func_70851_e(false);
            field_75294_a.func_70661_as().func_75499_g();
        }
    }
}
