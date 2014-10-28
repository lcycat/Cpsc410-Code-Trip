// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityLiving, World, Profiler, Entity

public class EntitySenses
{

    EntityLiving field_75526_a;
    List field_75524_b;
    List field_75525_c;

    public EntitySenses(EntityLiving p_i3508_1_)
    {
        field_75524_b = new ArrayList();
        field_75525_c = new ArrayList();
        field_75526_a = p_i3508_1_;
    }

    public void func_75523_a()
    {
        field_75524_b.clear();
        field_75525_c.clear();
    }

    public boolean func_75522_a(Entity p_75522_1_)
    {
        if(field_75524_b.contains(p_75522_1_))
        {
            return true;
        }
        if(field_75525_c.contains(p_75522_1_))
        {
            return false;
        }
        field_75526_a.field_70170_p.field_72984_F.func_76320_a("canSee");
        boolean flag = field_75526_a.func_70685_l(p_75522_1_);
        field_75526_a.field_70170_p.field_72984_F.func_76319_b();
        if(flag)
        {
            field_75524_b.add(p_75522_1_);
        } else
        {
            field_75525_c.add(p_75522_1_);
        }
        return flag;
    }
}
