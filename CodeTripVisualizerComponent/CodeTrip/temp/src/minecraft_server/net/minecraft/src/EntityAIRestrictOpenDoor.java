// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, World, MathHelper, 
//            VillageCollection, Village, VillageDoorInfo, PathNavigate

public class EntityAIRestrictOpenDoor extends EntityAIBase
{

    private EntityCreature field_75275_a;
    private VillageDoorInfo field_75274_b;

    public EntityAIRestrictOpenDoor(EntityCreature p_i3490_1_)
    {
        field_75275_a = p_i3490_1_;
    }

    public boolean func_75250_a()
    {
        if(field_75275_a.field_70170_p.func_72935_r())
        {
            return false;
        }
        Village village = field_75275_a.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(field_75275_a.field_70165_t), MathHelper.func_76128_c(field_75275_a.field_70163_u), MathHelper.func_76128_c(field_75275_a.field_70161_v), 16);
        if(village == null)
        {
            return false;
        }
        field_75274_b = village.func_75564_b(MathHelper.func_76128_c(field_75275_a.field_70165_t), MathHelper.func_76128_c(field_75275_a.field_70163_u), MathHelper.func_76128_c(field_75275_a.field_70161_v));
        if(field_75274_b == null)
        {
            return false;
        } else
        {
            return (double)field_75274_b.func_75469_c(MathHelper.func_76128_c(field_75275_a.field_70165_t), MathHelper.func_76128_c(field_75275_a.field_70163_u), MathHelper.func_76128_c(field_75275_a.field_70161_v)) < 2.25D;
        }
    }

    public boolean func_75253_b()
    {
        if(field_75275_a.field_70170_p.func_72935_r())
        {
            return false;
        } else
        {
            return !field_75274_b.field_75476_g && field_75274_b.func_75467_a(MathHelper.func_76128_c(field_75275_a.field_70165_t), MathHelper.func_76128_c(field_75275_a.field_70161_v));
        }
    }

    public void func_75249_e()
    {
        field_75275_a.func_70661_as().func_75498_b(false);
        field_75275_a.func_70661_as().func_75490_c(false);
    }

    public void func_75251_c()
    {
        field_75275_a.func_70661_as().func_75498_b(true);
        field_75275_a.func_70661_as().func_75490_c(true);
        field_75274_b = null;
    }

    public void func_75246_d()
    {
        field_75274_b.func_75470_e();
    }
}
