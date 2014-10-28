// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityAnimal, AxisAlignedBB, World, 
//            PathNavigate

public class EntityAIFollowParent extends EntityAIBase
{

    EntityAnimal field_75348_a;
    EntityAnimal field_75346_b;
    float field_75347_c;
    private int field_75345_d;

    public EntityAIFollowParent(EntityAnimal p_i3467_1_, float p_i3467_2_)
    {
        field_75348_a = p_i3467_1_;
        field_75347_c = p_i3467_2_;
    }

    public boolean func_75250_a()
    {
        if(field_75348_a.func_70874_b() >= 0)
        {
            return false;
        }
        List list = field_75348_a.field_70170_p.func_72872_a(field_75348_a.getClass(), field_75348_a.field_70121_D.func_72314_b(8D, 4D, 8D));
        EntityAnimal entityanimal = null;
        double d = 1.7976931348623157E+308D;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityAnimal entityanimal1 = (EntityAnimal)iterator.next();
            if(entityanimal1.func_70874_b() >= 0)
            {
                double d1 = field_75348_a.func_70068_e(entityanimal1);
                if(d1 <= d)
                {
                    d = d1;
                    entityanimal = entityanimal1;
                }
            }
        } while(true);
        if(entityanimal == null)
        {
            return false;
        }
        if(d < 9D)
        {
            return false;
        } else
        {
            field_75346_b = entityanimal;
            return true;
        }
    }

    public boolean func_75253_b()
    {
        if(!field_75346_b.func_70089_S())
        {
            return false;
        }
        double d = field_75348_a.func_70068_e(field_75346_b);
        return d >= 9D && d <= 256D;
    }

    public void func_75249_e()
    {
        field_75345_d = 0;
    }

    public void func_75251_c()
    {
        field_75346_b = null;
    }

    public void func_75246_d()
    {
        if(--field_75345_d > 0)
        {
            return;
        } else
        {
            field_75345_d = 10;
            field_75348_a.func_70661_as().func_75497_a(field_75346_b, field_75347_c);
            return;
        }
    }
}
