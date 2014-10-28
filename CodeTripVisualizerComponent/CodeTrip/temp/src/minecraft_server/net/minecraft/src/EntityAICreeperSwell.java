// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreeper, PathNavigate, EntitySenses, 
//            EntityLiving

public class EntityAICreeperSwell extends EntityAIBase
{

    EntityCreeper field_75269_a;
    EntityLiving field_75268_b;

    public EntityAICreeperSwell(EntityCreeper p_i3493_1_)
    {
        field_75269_a = p_i3493_1_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        EntityLiving entityliving = field_75269_a.func_70638_az();
        return field_75269_a.func_70832_p() > 0 || entityliving != null && field_75269_a.func_70068_e(entityliving) < 9D;
    }

    public void func_75249_e()
    {
        field_75269_a.func_70661_as().func_75499_g();
        field_75268_b = field_75269_a.func_70638_az();
    }

    public void func_75251_c()
    {
        field_75268_b = null;
    }

    public void func_75246_d()
    {
        if(field_75268_b == null)
        {
            field_75269_a.func_70829_a(-1);
            return;
        }
        if(field_75269_a.func_70068_e(field_75268_b) > 49D)
        {
            field_75269_a.func_70829_a(-1);
            return;
        }
        if(!field_75269_a.func_70635_at().func_75522_a(field_75268_b))
        {
            field_75269_a.func_70829_a(-1);
            return;
        } else
        {
            field_75269_a.func_70829_a(1);
            return;
        }
    }
}
