// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIDoorInteract, EntityLiving, BlockDoor

public class EntityAIOpenDoor extends EntityAIDoorInteract
{

    boolean field_75361_i;
    int field_75360_j;

    public EntityAIOpenDoor(EntityLiving p_i3484_1_, boolean p_i3484_2_)
    {
        super(p_i3484_1_);
        field_75356_a = p_i3484_1_;
        field_75361_i = p_i3484_2_;
    }

    public boolean func_75253_b()
    {
        return field_75361_i && field_75360_j > 0 && super.func_75253_b();
    }

    public void func_75249_e()
    {
        field_75360_j = 20;
        field_75353_e.func_72231_a(field_75356_a.field_70170_p, field_75354_b, field_75355_c, field_75352_d, true);
    }

    public void func_75251_c()
    {
        if(field_75361_i)
        {
            field_75353_e.func_72231_a(field_75356_a.field_70170_p, field_75354_b, field_75355_c, field_75352_d, false);
        }
    }

    public void func_75246_d()
    {
        field_75360_j--;
        super.func_75246_d();
    }
}
