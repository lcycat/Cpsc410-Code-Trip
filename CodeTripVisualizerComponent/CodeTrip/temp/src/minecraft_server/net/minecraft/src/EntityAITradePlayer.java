// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityVillager, EntityPlayer, Container, 
//            PathNavigate

public class EntityAITradePlayer extends EntityAIBase
{

    private EntityVillager field_75276_a;

    public EntityAITradePlayer(EntityVillager p_i3496_1_)
    {
        field_75276_a = p_i3496_1_;
        func_75248_a(5);
    }

    public boolean func_75250_a()
    {
        if(!field_75276_a.func_70089_S())
        {
            return false;
        }
        if(field_75276_a.func_70090_H())
        {
            return false;
        }
        if(!field_75276_a.field_70122_E)
        {
            return false;
        }
        if(field_75276_a.field_70133_I)
        {
            return false;
        }
        EntityPlayer entityplayer = field_75276_a.func_70931_l_();
        if(entityplayer == null)
        {
            return false;
        }
        if(field_75276_a.func_70068_e(entityplayer) > 16D)
        {
            return false;
        }
        return entityplayer.field_71070_bA instanceof Container;
    }

    public void func_75249_e()
    {
        field_75276_a.func_70661_as().func_75499_g();
    }

    public void func_75251_c()
    {
        field_75276_a.func_70932_a_(null);
    }
}
