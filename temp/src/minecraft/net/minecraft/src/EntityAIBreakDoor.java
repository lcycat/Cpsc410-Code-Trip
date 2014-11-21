// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIDoorInteract, EntityLiving, BlockDoor, World

public class EntityAIBreakDoor extends EntityAIDoorInteract
{

    private int field_75359_i;
    private int field_75358_j;

    public EntityAIBreakDoor(EntityLiving p_i3460_1_)
    {
        super(p_i3460_1_);
        field_75358_j = -1;
    }

    public boolean func_75250_a()
    {
        if(!super.func_75250_a())
        {
            return false;
        } else
        {
            return !field_75353_e.func_72233_a_(field_75356_a.field_70170_p, field_75354_b, field_75355_c, field_75352_d);
        }
    }

    public void func_75249_e()
    {
        super.func_75249_e();
        field_75359_i = 0;
    }

    public boolean func_75253_b()
    {
        double d = field_75356_a.func_70092_e(field_75354_b, field_75355_c, field_75352_d);
        return field_75359_i <= 240 && !field_75353_e.func_72233_a_(field_75356_a.field_70170_p, field_75354_b, field_75355_c, field_75352_d) && d < 4D;
    }

    public void func_75251_c()
    {
        super.func_75251_c();
        field_75356_a.field_70170_p.func_72888_f(field_75356_a.field_70157_k, field_75354_b, field_75355_c, field_75352_d, -1);
    }

    public void func_75246_d()
    {
        super.func_75246_d();
        if(field_75356_a.func_70681_au().nextInt(20) == 0)
        {
            field_75356_a.field_70170_p.func_72926_e(1010, field_75354_b, field_75355_c, field_75352_d, 0);
        }
        field_75359_i++;
        int i = (int)(((float)field_75359_i / 240F) * 10F);
        if(i != field_75358_j)
        {
            field_75356_a.field_70170_p.func_72888_f(field_75356_a.field_70157_k, field_75354_b, field_75355_c, field_75352_d, i);
            field_75358_j = i;
        }
        if(field_75359_i == 240 && field_75356_a.field_70170_p.field_73013_u == 3)
        {
            field_75356_a.field_70170_p.func_72859_e(field_75354_b, field_75355_c, field_75352_d, 0);
            field_75356_a.field_70170_p.func_72926_e(1012, field_75354_b, field_75355_c, field_75352_d, 0);
            field_75356_a.field_70170_p.func_72926_e(2001, field_75354_b, field_75355_c, field_75352_d, field_75353_e.field_71990_ca);
        }
    }
}
