// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, RandomPositionGenerator, Vec3, 
//            PathNavigate

public class EntityAIWander extends EntityAIBase
{

    private EntityCreature field_75457_a;
    private double field_75455_b;
    private double field_75456_c;
    private double field_75453_d;
    private float field_75454_e;

    public EntityAIWander(EntityCreature p_i3489_1_, float p_i3489_2_)
    {
        field_75457_a = p_i3489_1_;
        field_75454_e = p_i3489_2_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        if(field_75457_a.func_70654_ax() >= 100)
        {
            return false;
        }
        if(field_75457_a.func_70681_au().nextInt(120) != 0)
        {
            return false;
        }
        Vec3 vec3 = RandomPositionGenerator.func_75463_a(field_75457_a, 10, 7);
        if(vec3 == null)
        {
            return false;
        } else
        {
            field_75455_b = vec3.field_72450_a;
            field_75456_c = vec3.field_72448_b;
            field_75453_d = vec3.field_72449_c;
            return true;
        }
    }

    public boolean func_75253_b()
    {
        return !field_75457_a.func_70661_as().func_75500_f();
    }

    public void func_75249_e()
    {
        field_75457_a.func_70661_as().func_75492_a(field_75455_b, field_75456_c, field_75453_d, field_75454_e);
    }
}
