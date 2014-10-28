// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityVillager, AxisAlignedBB, World, 
//            RandomPositionGenerator, PathNavigate, Vec3, EntityLiving

public class EntityAIPlay extends EntityAIBase
{

    private EntityVillager field_75262_a;
    private EntityLiving field_75260_b;
    private float field_75261_c;
    private int field_75259_d;

    public EntityAIPlay(EntityVillager p_i3487_1_, float p_i3487_2_)
    {
        field_75262_a = p_i3487_1_;
        field_75261_c = p_i3487_2_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        if(field_75262_a.func_70874_b() >= 0)
        {
            return false;
        }
        if(field_75262_a.func_70681_au().nextInt(400) != 0)
        {
            return false;
        }
        List list = field_75262_a.field_70170_p.func_72872_a(net.minecraft.src.EntityVillager.class, field_75262_a.field_70121_D.func_72314_b(6D, 3D, 6D));
        double d = 1.7976931348623157E+308D;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityVillager entityvillager = (EntityVillager)iterator.next();
            if(entityvillager != field_75262_a && !entityvillager.func_70945_p() && entityvillager.func_70874_b() < 0)
            {
                double d1 = entityvillager.func_70068_e(field_75262_a);
                if(d1 <= d)
                {
                    d = d1;
                    field_75260_b = entityvillager;
                }
            }
        } while(true);
        if(field_75260_b == null)
        {
            Vec3 vec3 = RandomPositionGenerator.func_75463_a(field_75262_a, 16, 3);
            if(vec3 == null)
            {
                return false;
            }
        }
        return true;
    }

    public boolean func_75253_b()
    {
        return field_75259_d > 0;
    }

    public void func_75249_e()
    {
        if(field_75260_b != null)
        {
            field_75262_a.func_70939_f(true);
        }
        field_75259_d = 1000;
    }

    public void func_75251_c()
    {
        field_75262_a.func_70939_f(false);
        field_75260_b = null;
    }

    public void func_75246_d()
    {
        field_75259_d--;
        if(field_75260_b != null)
        {
            if(field_75262_a.func_70068_e(field_75260_b) > 4D)
            {
                field_75262_a.func_70661_as().func_75497_a(field_75260_b, field_75261_c);
            }
        } else
        if(field_75262_a.func_70661_as().func_75500_f())
        {
            Vec3 vec3 = RandomPositionGenerator.func_75463_a(field_75262_a, 16, 3);
            if(vec3 == null)
            {
                return;
            }
            field_75262_a.func_70661_as().func_75492_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, field_75261_c);
        }
    }
}
