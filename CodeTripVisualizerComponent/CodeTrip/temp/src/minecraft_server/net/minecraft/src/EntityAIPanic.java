// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, RandomPositionGenerator, Vec3, 
//            PathNavigate

public class EntityAIPanic extends EntityAIBase
{

    private EntityCreature field_75267_a;
    private float field_75265_b;
    private double field_75266_c;
    private double field_75263_d;
    private double field_75264_e;

    public EntityAIPanic(EntityCreature p_i3486_1_, float p_i3486_2_)
    {
        field_75267_a = p_i3486_1_;
        field_75265_b = p_i3486_2_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        if(field_75267_a.func_70643_av() == null)
        {
            return false;
        }
        Vec3 vec3 = RandomPositionGenerator.func_75463_a(field_75267_a, 5, 4);
        if(vec3 == null)
        {
            return false;
        } else
        {
            field_75266_c = vec3.field_72450_a;
            field_75263_d = vec3.field_72448_b;
            field_75264_e = vec3.field_72449_c;
            return true;
        }
    }

    public void func_75249_e()
    {
        field_75267_a.func_70661_as().func_75492_a(field_75266_c, field_75263_d, field_75264_e, field_75265_b);
    }

    public boolean func_75253_b()
    {
        return !field_75267_a.func_70661_as().func_75500_f();
    }
}
