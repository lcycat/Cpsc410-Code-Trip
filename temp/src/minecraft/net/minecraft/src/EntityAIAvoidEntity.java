// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, EntityPlayer, EntityTameable, 
//            World, AxisAlignedBB, Entity, EntitySenses, 
//            Vec3, Vec3Pool, RandomPositionGenerator, PathNavigate, 
//            PathEntity

public class EntityAIAvoidEntity extends EntityAIBase
{

    private EntityCreature field_75380_a;
    private float field_75378_b;
    private float field_75379_c;
    private Entity field_75376_d;
    private float field_75377_e;
    private PathEntity field_75374_f;
    private PathNavigate field_75375_g;
    private Class field_75381_h;

    public EntityAIAvoidEntity(EntityCreature p_i3458_1_, Class p_i3458_2_, float p_i3458_3_, float p_i3458_4_, float p_i3458_5_)
    {
        field_75380_a = p_i3458_1_;
        field_75381_h = p_i3458_2_;
        field_75377_e = p_i3458_3_;
        field_75378_b = p_i3458_4_;
        field_75379_c = p_i3458_5_;
        field_75375_g = p_i3458_1_.func_70661_as();
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        if(field_75381_h == (net.minecraft.src.EntityPlayer.class))
        {
            if((field_75380_a instanceof EntityTameable) && ((EntityTameable)field_75380_a).func_70909_n())
            {
                return false;
            }
            field_75376_d = field_75380_a.field_70170_p.func_72890_a(field_75380_a, field_75377_e);
            if(field_75376_d == null)
            {
                return false;
            }
        } else
        {
            List list = field_75380_a.field_70170_p.func_72872_a(field_75381_h, field_75380_a.field_70121_D.func_72314_b(field_75377_e, 3D, field_75377_e));
            if(list.isEmpty())
            {
                return false;
            }
            field_75376_d = (Entity)list.get(0);
        }
        if(!field_75380_a.func_70635_at().func_75522_a(field_75376_d))
        {
            return false;
        }
        Vec3 vec3 = RandomPositionGenerator.func_75461_b(field_75380_a, 16, 7, Vec3.func_72437_a().func_72345_a(field_75376_d.field_70165_t, field_75376_d.field_70163_u, field_75376_d.field_70161_v));
        if(vec3 == null)
        {
            return false;
        }
        if(field_75376_d.func_70092_e(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c) < field_75376_d.func_70068_e(field_75380_a))
        {
            return false;
        }
        field_75374_f = field_75375_g.func_75488_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
        if(field_75374_f == null)
        {
            return false;
        }
        return field_75374_f.func_75880_b(vec3);
    }

    public boolean func_75253_b()
    {
        return !field_75375_g.func_75500_f();
    }

    public void func_75249_e()
    {
        field_75375_g.func_75484_a(field_75374_f, field_75378_b);
    }

    public void func_75251_c()
    {
        field_75376_d = null;
    }

    public void func_75246_d()
    {
        if(field_75380_a.func_70068_e(field_75376_d) < 49D)
        {
            field_75380_a.func_70661_as().func_75489_a(field_75379_c);
        } else
        {
            field_75380_a.func_70661_as().func_75489_a(field_75378_b);
        }
    }
}
