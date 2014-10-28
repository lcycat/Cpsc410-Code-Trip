// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAITarget, EntityTameable, EntityLiving

public class EntityAIOwnerHurtByTarget extends EntityAITarget
{

    EntityTameable field_75316_a;
    EntityLiving field_75315_b;

    public EntityAIOwnerHurtByTarget(EntityTameable p_i3503_1_)
    {
        super(p_i3503_1_, 32F, false);
        field_75316_a = p_i3503_1_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        if(!field_75316_a.func_70909_n())
        {
            return false;
        }
        EntityLiving entityliving = field_75316_a.func_70902_q();
        if(entityliving == null)
        {
            return false;
        } else
        {
            field_75315_b = entityliving.func_70643_av();
            return func_75296_a(field_75315_b, false);
        }
    }

    public void func_75249_e()
    {
        field_75299_d.func_70624_b(field_75315_b);
        super.func_75249_e();
    }
}
