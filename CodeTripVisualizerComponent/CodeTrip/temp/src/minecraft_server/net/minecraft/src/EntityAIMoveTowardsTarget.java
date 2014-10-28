// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, EntityLiving, Vec3, 
//            Vec3Pool, RandomPositionGenerator, PathNavigate

public class EntityAIMoveTowardsTarget extends EntityAIBase
{

    private EntityCreature field_75431_a;
    private EntityLiving field_75429_b;
    private double field_75430_c;
    private double field_75427_d;
    private double field_75428_e;
    private float field_75425_f;
    private float field_75426_g;

    public EntityAIMoveTowardsTarget(EntityCreature p_i3481_1_, float p_i3481_2_, float p_i3481_3_)
    {
        field_75431_a = p_i3481_1_;
        field_75425_f = p_i3481_2_;
        field_75426_g = p_i3481_3_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        field_75429_b = field_75431_a.func_70638_az();
        if(field_75429_b == null)
        {
            return false;
        }
        if(field_75429_b.func_70068_e(field_75431_a) > (double)(field_75426_g * field_75426_g))
        {
            return false;
        }
        Vec3 vec3 = RandomPositionGenerator.func_75464_a(field_75431_a, 16, 7, Vec3.func_72437_a().func_72345_a(field_75429_b.field_70165_t, field_75429_b.field_70163_u, field_75429_b.field_70161_v));
        if(vec3 == null)
        {
            return false;
        } else
        {
            field_75430_c = vec3.field_72450_a;
            field_75427_d = vec3.field_72448_b;
            field_75428_e = vec3.field_72449_c;
            return true;
        }
    }

    public boolean func_75253_b()
    {
        return !field_75431_a.func_70661_as().func_75500_f() && field_75429_b.func_70089_S() && field_75429_b.func_70068_e(field_75431_a) < (double)(field_75426_g * field_75426_g);
    }

    public void func_75251_c()
    {
        field_75429_b = null;
    }

    public void func_75249_e()
    {
        field_75431_a.func_70661_as().func_75492_a(field_75430_c, field_75427_d, field_75428_e, field_75425_f);
    }
}
