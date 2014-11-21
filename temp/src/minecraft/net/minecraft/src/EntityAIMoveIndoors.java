// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, World, WorldProvider, 
//            MathHelper, VillageCollection, Village, PathNavigate, 
//            VillageDoorInfo, Vec3, Vec3Pool, RandomPositionGenerator

public class EntityAIMoveIndoors extends EntityAIBase
{

    private EntityCreature field_75424_a;
    private VillageDoorInfo field_75422_b;
    private int field_75423_c;
    private int field_75421_d;

    public EntityAIMoveIndoors(EntityCreature p_i3478_1_)
    {
        field_75423_c = -1;
        field_75421_d = -1;
        field_75424_a = p_i3478_1_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        if(field_75424_a.field_70170_p.func_72935_r() && !field_75424_a.field_70170_p.func_72896_J() || field_75424_a.field_70170_p.field_73011_w.field_76576_e)
        {
            return false;
        }
        if(field_75424_a.func_70681_au().nextInt(50) != 0)
        {
            return false;
        }
        if(field_75423_c != -1 && field_75424_a.func_70092_e(field_75423_c, field_75424_a.field_70163_u, field_75421_d) < 4D)
        {
            return false;
        }
        Village village = field_75424_a.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(field_75424_a.field_70165_t), MathHelper.func_76128_c(field_75424_a.field_70163_u), MathHelper.func_76128_c(field_75424_a.field_70161_v), 14);
        if(village == null)
        {
            return false;
        } else
        {
            field_75422_b = village.func_75569_c(MathHelper.func_76128_c(field_75424_a.field_70165_t), MathHelper.func_76128_c(field_75424_a.field_70163_u), MathHelper.func_76128_c(field_75424_a.field_70161_v));
            return field_75422_b != null;
        }
    }

    public boolean func_75253_b()
    {
        return !field_75424_a.func_70661_as().func_75500_f();
    }

    public void func_75249_e()
    {
        field_75423_c = -1;
        if(field_75424_a.func_70092_e(field_75422_b.func_75471_a(), field_75422_b.field_75479_b, field_75422_b.func_75472_c()) > 256D)
        {
            Vec3 vec3 = RandomPositionGenerator.func_75464_a(field_75424_a, 14, 3, Vec3.func_72437_a().func_72345_a((double)field_75422_b.func_75471_a() + 0.5D, field_75422_b.func_75473_b(), (double)field_75422_b.func_75472_c() + 0.5D));
            if(vec3 != null)
            {
                field_75424_a.func_70661_as().func_75492_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, 0.3F);
            }
        } else
        {
            field_75424_a.func_70661_as().func_75492_a((double)field_75422_b.func_75471_a() + 0.5D, field_75422_b.func_75473_b(), (double)field_75422_b.func_75472_c() + 0.5D, 0.3F);
        }
    }

    public void func_75251_c()
    {
        field_75423_c = field_75422_b.func_75471_a();
        field_75421_d = field_75422_b.func_75472_c();
        field_75422_b = null;
    }
}
