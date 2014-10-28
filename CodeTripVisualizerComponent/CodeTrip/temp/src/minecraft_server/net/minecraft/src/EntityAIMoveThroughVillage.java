// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityCreature, World, MathHelper, 
//            VillageCollection, PathNavigate, VillageDoorInfo, Vec3, 
//            Vec3Pool, RandomPositionGenerator, Village, PathEntity

public class EntityAIMoveThroughVillage extends EntityAIBase
{

    private EntityCreature field_75420_a;
    private float field_75418_b;
    private PathEntity field_75419_c;
    private VillageDoorInfo field_75416_d;
    private boolean field_75417_e;
    private List field_75415_f;

    public EntityAIMoveThroughVillage(EntityCreature p_i3479_1_, float p_i3479_2_, boolean p_i3479_3_)
    {
        field_75415_f = new ArrayList();
        field_75420_a = p_i3479_1_;
        field_75418_b = p_i3479_2_;
        field_75417_e = p_i3479_3_;
        func_75248_a(1);
    }

    public boolean func_75250_a()
    {
        func_75414_f();
        if(field_75417_e && field_75420_a.field_70170_p.func_72935_r())
        {
            return false;
        }
        Village village = field_75420_a.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(field_75420_a.field_70165_t), MathHelper.func_76128_c(field_75420_a.field_70163_u), MathHelper.func_76128_c(field_75420_a.field_70161_v), 0);
        if(village == null)
        {
            return false;
        }
        field_75416_d = func_75412_a(village);
        if(field_75416_d == null)
        {
            return false;
        }
        boolean flag = field_75420_a.func_70661_as().func_75507_c();
        field_75420_a.func_70661_as().func_75498_b(false);
        field_75419_c = field_75420_a.func_70661_as().func_75488_a(field_75416_d.field_75481_a, field_75416_d.field_75479_b, field_75416_d.field_75480_c);
        field_75420_a.func_70661_as().func_75498_b(flag);
        if(field_75419_c != null)
        {
            return true;
        }
        Vec3 vec3 = RandomPositionGenerator.func_75464_a(field_75420_a, 10, 7, Vec3.func_72437_a().func_72345_a(field_75416_d.field_75481_a, field_75416_d.field_75479_b, field_75416_d.field_75480_c));
        if(vec3 == null)
        {
            return false;
        } else
        {
            field_75420_a.func_70661_as().func_75498_b(false);
            field_75419_c = field_75420_a.func_70661_as().func_75488_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
            field_75420_a.func_70661_as().func_75498_b(flag);
            return field_75419_c != null;
        }
    }

    public boolean func_75253_b()
    {
        if(field_75420_a.func_70661_as().func_75500_f())
        {
            return false;
        } else
        {
            float f = field_75420_a.field_70130_N + 4F;
            return field_75420_a.func_70092_e(field_75416_d.field_75481_a, field_75416_d.field_75479_b, field_75416_d.field_75480_c) > (double)(f * f);
        }
    }

    public void func_75249_e()
    {
        field_75420_a.func_70661_as().func_75484_a(field_75419_c, field_75418_b);
    }

    public void func_75251_c()
    {
        if(field_75420_a.func_70661_as().func_75500_f() || field_75420_a.func_70092_e(field_75416_d.field_75481_a, field_75416_d.field_75479_b, field_75416_d.field_75480_c) < 16D)
        {
            field_75415_f.add(field_75416_d);
        }
    }

    private VillageDoorInfo func_75412_a(Village p_75412_1_)
    {
        VillageDoorInfo villagedoorinfo = null;
        int i = 0x7fffffff;
        List list = p_75412_1_.func_75558_f();
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            VillageDoorInfo villagedoorinfo1 = (VillageDoorInfo)iterator.next();
            int j = villagedoorinfo1.func_75474_b(MathHelper.func_76128_c(field_75420_a.field_70165_t), MathHelper.func_76128_c(field_75420_a.field_70163_u), MathHelper.func_76128_c(field_75420_a.field_70161_v));
            if(j < i && !func_75413_a(villagedoorinfo1))
            {
                villagedoorinfo = villagedoorinfo1;
                i = j;
            }
        } while(true);
        return villagedoorinfo;
    }

    private boolean func_75413_a(VillageDoorInfo p_75413_1_)
    {
        for(Iterator iterator = field_75415_f.iterator(); iterator.hasNext();)
        {
            VillageDoorInfo villagedoorinfo = (VillageDoorInfo)iterator.next();
            if(p_75413_1_.field_75481_a == villagedoorinfo.field_75481_a && p_75413_1_.field_75479_b == villagedoorinfo.field_75479_b && p_75413_1_.field_75480_c == villagedoorinfo.field_75480_c)
            {
                return true;
            }
        }

        return false;
    }

    private void func_75414_f()
    {
        if(field_75415_f.size() > 15)
        {
            field_75415_f.remove(0);
        }
    }
}
