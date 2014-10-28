// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, World, MathHelper, 
//            AxisAlignedBB, Vec3, PathNavigate, Vec3Pool

public class EntityAIFleeSun extends EntityAIBase
{

    private EntityCreature field_75372_a;
    private double field_75370_b;
    private double field_75371_c;
    private double field_75368_d;
    private float field_75369_e;
    private World field_75367_f;

    public EntityAIFleeSun(EntityCreature p_i3464_1_, float p_i3464_2_)
    {
        field_75372_a = p_i3464_1_;
        field_75369_e = p_i3464_2_;
        field_75367_f = p_i3464_1_.field_70170_p;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        if(!field_75367_f.func_72935_r())
        {
            return false;
        }
        if(!field_75372_a.func_70027_ad())
        {
            return false;
        }
        if(!field_75367_f.func_72937_j(MathHelper.func_76128_c(field_75372_a.field_70165_t), (int)field_75372_a.field_70121_D.field_72338_b, MathHelper.func_76128_c(field_75372_a.field_70161_v)))
        {
            return false;
        }
        Vec3 vec3 = func_75366_f();
        if(vec3 == null)
        {
            return false;
        } else
        {
            field_75370_b = vec3.field_72450_a;
            field_75371_c = vec3.field_72448_b;
            field_75368_d = vec3.field_72449_c;
            return true;
        }
    }

    public boolean func_75253_b()
    {
        return !field_75372_a.func_70661_as().func_75500_f();
    }

    public void func_75249_e()
    {
        field_75372_a.func_70661_as().func_75492_a(field_75370_b, field_75371_c, field_75368_d, field_75369_e);
    }

    private Vec3 func_75366_f()
    {
        Random random = field_75372_a.func_70681_au();
        for(int i = 0; i < 10; i++)
        {
            int j = MathHelper.func_76128_c((field_75372_a.field_70165_t + (double)random.nextInt(20)) - 10D);
            int k = MathHelper.func_76128_c((field_75372_a.field_70121_D.field_72338_b + (double)random.nextInt(6)) - 3D);
            int l = MathHelper.func_76128_c((field_75372_a.field_70161_v + (double)random.nextInt(20)) - 10D);
            if(!field_75367_f.func_72937_j(j, k, l) && field_75372_a.func_70783_a(j, k, l) < 0.0F)
            {
                return Vec3.func_72437_a().func_72345_a(j, k, l);
            }
        }

        return null;
    }
}
