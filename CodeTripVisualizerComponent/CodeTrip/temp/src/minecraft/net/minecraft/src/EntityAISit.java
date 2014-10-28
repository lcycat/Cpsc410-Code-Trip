// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityTameable, EntityLiving, PathNavigate

public class EntityAISit extends EntityAIBase
{

    private EntityTameable field_75272_a;
    private boolean field_75271_b;

    public EntityAISit(EntityTameable p_i3492_1_)
    {
        field_75271_b = false;
        field_75272_a = p_i3492_1_;
        func_75248_a(5);
    }

    public boolean func_75250_a()
    {
        if(!field_75272_a.func_70909_n())
        {
            return false;
        }
        if(field_75272_a.func_70090_H())
        {
            return false;
        }
        if(!field_75272_a.field_70122_E)
        {
            return false;
        }
        EntityLiving entityliving = field_75272_a.func_70902_q();
        if(entityliving == null)
        {
            return true;
        }
        if(field_75272_a.func_70068_e(entityliving) < 144D && entityliving.func_70643_av() != null)
        {
            return false;
        } else
        {
            return field_75271_b;
        }
    }

    public void func_75249_e()
    {
        field_75272_a.func_70661_as().func_75499_g();
        field_75272_a.func_70904_g(true);
    }

    public void func_75251_c()
    {
        field_75272_a.func_70904_g(false);
    }

    public void func_75270_a(boolean p_75270_1_)
    {
        field_75271_b = p_75270_1_;
    }
}
