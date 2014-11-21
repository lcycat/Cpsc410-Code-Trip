// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityAnimal, EntityLookHelper, PathNavigate, 
//            AxisAlignedBB, World

public class EntityAIMate extends EntityAIBase
{

    private EntityAnimal field_75390_d;
    World field_75394_a;
    private EntityAnimal field_75391_e;
    int field_75392_b;
    float field_75393_c;

    public EntityAIMate(EntityAnimal p_i3461_1_, float p_i3461_2_)
    {
        field_75392_b = 0;
        field_75390_d = p_i3461_1_;
        field_75394_a = p_i3461_1_.field_70170_p;
        field_75393_c = p_i3461_2_;
        func_75248_a(3);
    }

    public boolean func_75250_a()
    {
        if(!field_75390_d.func_70880_s())
        {
            return false;
        } else
        {
            field_75391_e = func_75389_f();
            return field_75391_e != null;
        }
    }

    public boolean func_75253_b()
    {
        return field_75391_e.func_70089_S() && field_75391_e.func_70880_s() && field_75392_b < 60;
    }

    public void func_75251_c()
    {
        field_75391_e = null;
        field_75392_b = 0;
    }

    public void func_75246_d()
    {
        field_75390_d.func_70671_ap().func_75651_a(field_75391_e, 10F, field_75390_d.func_70646_bf());
        field_75390_d.func_70661_as().func_75497_a(field_75391_e, field_75393_c);
        field_75392_b++;
        if(field_75392_b == 60)
        {
            func_75388_i();
        }
    }

    private EntityAnimal func_75389_f()
    {
        float f = 8F;
        List list = field_75394_a.func_72872_a(field_75390_d.getClass(), field_75390_d.field_70121_D.func_72314_b(f, f, f));
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            EntityAnimal entityanimal = (EntityAnimal)iterator.next();
            if(field_75390_d.func_70878_b(entityanimal))
            {
                return entityanimal;
            }
        }

        return null;
    }

    private void func_75388_i()
    {
        EntityAnimal entityanimal = field_75390_d.func_70879_a(field_75391_e);
        if(entityanimal == null)
        {
            return;
        }
        field_75390_d.func_70873_a(6000);
        field_75391_e.func_70873_a(6000);
        field_75390_d.func_70875_t();
        field_75391_e.func_70875_t();
        entityanimal.func_70873_a(-24000);
        entityanimal.func_70012_b(field_75390_d.field_70165_t, field_75390_d.field_70163_u, field_75390_d.field_70161_v, 0.0F, 0.0F);
        field_75394_a.func_72838_d(entityanimal);
        Random random = field_75390_d.func_70681_au();
        for(int i = 0; i < 7; i++)
        {
            double d = random.nextGaussian() * 0.02D;
            double d1 = random.nextGaussian() * 0.02D;
            double d2 = random.nextGaussian() * 0.02D;
            field_75394_a.func_72869_a("heart", (field_75390_d.field_70165_t + (double)(random.nextFloat() * field_75390_d.field_70130_N * 2.0F)) - (double)field_75390_d.field_70130_N, field_75390_d.field_70163_u + 0.5D + (double)(random.nextFloat() * field_75390_d.field_70131_O), (field_75390_d.field_70161_v + (double)(random.nextFloat() * field_75390_d.field_70130_N * 2.0F)) - (double)field_75390_d.field_70130_N, d, d1, d2);
        }

    }
}
