// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityLiving, World, Profiler, Entity, 
//            AxisAlignedBB, MathHelper, PathEntity, Vec3

public abstract class EntityCreature extends EntityLiving
{

    private PathEntity field_70786_d;
    protected Entity field_70789_a;
    protected boolean field_70787_b;
    protected int field_70788_c;

    public EntityCreature(World p_i3450_1_)
    {
        super(p_i3450_1_);
        field_70787_b = false;
        field_70788_c = 0;
    }

    protected boolean func_70780_i()
    {
        return false;
    }

    protected void func_70626_be()
    {
        field_70170_p.field_72984_F.func_76320_a("ai");
        if(field_70788_c > 0)
        {
            field_70788_c--;
        }
        field_70787_b = func_70780_i();
        float f = 16F;
        if(field_70789_a == null)
        {
            field_70789_a = func_70782_k();
            if(field_70789_a != null)
            {
                field_70786_d = field_70170_p.func_72865_a(this, field_70789_a, f, true, false, false, true);
            }
        } else
        if(field_70789_a.func_70089_S())
        {
            float f1 = field_70789_a.func_70032_d(this);
            if(func_70685_l(field_70789_a))
            {
                func_70785_a(field_70789_a, f1);
            }
        } else
        {
            field_70789_a = null;
        }
        field_70170_p.field_72984_F.func_76319_b();
        if(!field_70787_b && field_70789_a != null && (field_70786_d == null || field_70146_Z.nextInt(20) == 0))
        {
            field_70786_d = field_70170_p.func_72865_a(this, field_70789_a, f, true, false, false, true);
        } else
        if(!field_70787_b && (field_70786_d == null && field_70146_Z.nextInt(180) == 0 || field_70146_Z.nextInt(120) == 0 || field_70788_c > 0) && field_70708_bq < 100)
        {
            func_70779_j();
        }
        int i = MathHelper.func_76128_c(field_70121_D.field_72338_b + 0.5D);
        boolean flag = func_70090_H();
        boolean flag1 = func_70058_J();
        field_70125_A = 0.0F;
        if(field_70786_d == null || field_70146_Z.nextInt(100) == 0)
        {
            super.func_70626_be();
            field_70786_d = null;
            return;
        }
        field_70170_p.field_72984_F.func_76320_a("followpath");
        Vec3 vec3 = field_70786_d.func_75878_a(this);
        for(double d = field_70130_N * 2.0F; vec3 != null && vec3.func_72445_d(field_70165_t, vec3.field_72448_b, field_70161_v) < d * d;)
        {
            field_70786_d.func_75875_a();
            if(field_70786_d.func_75879_b())
            {
                vec3 = null;
                field_70786_d = null;
            } else
            {
                vec3 = field_70786_d.func_75878_a(this);
            }
        }

        field_70703_bu = false;
        if(vec3 != null)
        {
            double d1 = vec3.field_72450_a - field_70165_t;
            double d2 = vec3.field_72449_c - field_70161_v;
            double d3 = vec3.field_72448_b - (double)i;
            float f2 = (float)((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            float f3 = MathHelper.func_76142_g(f2 - field_70177_z);
            field_70701_bs = field_70697_bw;
            if(f3 > 30F)
            {
                f3 = 30F;
            }
            if(f3 < -30F)
            {
                f3 = -30F;
            }
            field_70177_z += f3;
            if(field_70787_b && field_70789_a != null)
            {
                double d4 = field_70789_a.field_70165_t - field_70165_t;
                double d5 = field_70789_a.field_70161_v - field_70161_v;
                float f5 = field_70177_z;
                field_70177_z = (float)((Math.atan2(d5, d4) * 180D) / 3.1415927410125732D) - 90F;
                float f4 = (((f5 - field_70177_z) + 90F) * 3.141593F) / 180F;
                field_70702_br = -MathHelper.func_76126_a(f4) * field_70701_bs * 1.0F;
                field_70701_bs = MathHelper.func_76134_b(f4) * field_70701_bs * 1.0F;
            }
            if(d3 > 0.0D)
            {
                field_70703_bu = true;
            }
        }
        if(field_70789_a != null)
        {
            func_70625_a(field_70789_a, 30F, 30F);
        }
        if(field_70123_F && !func_70781_l())
        {
            field_70703_bu = true;
        }
        if(field_70146_Z.nextFloat() < 0.8F && (flag || flag1))
        {
            field_70703_bu = true;
        }
        field_70170_p.field_72984_F.func_76319_b();
    }

    protected void func_70779_j()
    {
        field_70170_p.field_72984_F.func_76320_a("stroll");
        boolean flag = false;
        int i = -1;
        int j = -1;
        int k = -1;
        float f = -99999F;
        for(int l = 0; l < 10; l++)
        {
            int i1 = MathHelper.func_76128_c((field_70165_t + (double)field_70146_Z.nextInt(13)) - 6D);
            int j1 = MathHelper.func_76128_c((field_70163_u + (double)field_70146_Z.nextInt(7)) - 3D);
            int k1 = MathHelper.func_76128_c((field_70161_v + (double)field_70146_Z.nextInt(13)) - 6D);
            float f1 = func_70783_a(i1, j1, k1);
            if(f1 > f)
            {
                f = f1;
                i = i1;
                j = j1;
                k = k1;
                flag = true;
            }
        }

        if(flag)
        {
            field_70786_d = field_70170_p.func_72844_a(this, i, j, k, 10F, true, false, false, true);
        }
        field_70170_p.field_72984_F.func_76319_b();
    }

    protected void func_70785_a(Entity entity, float f)
    {
    }

    public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_)
    {
        return 0.0F;
    }

    protected Entity func_70782_k()
    {
        return null;
    }

    public boolean func_70601_bi()
    {
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76128_c(field_70121_D.field_72338_b);
        int k = MathHelper.func_76128_c(field_70161_v);
        return super.func_70601_bi() && func_70783_a(i, j, k) >= 0.0F;
    }

    public boolean func_70781_l()
    {
        return field_70786_d != null;
    }

    public void func_70778_a(PathEntity p_70778_1_)
    {
        field_70786_d = p_70778_1_;
    }

    public Entity func_70777_m()
    {
        return field_70789_a;
    }

    public void func_70784_b(Entity p_70784_1_)
    {
        field_70789_a = p_70784_1_;
    }

    protected float func_70616_bs()
    {
        if(func_70650_aV())
        {
            return 1.0F;
        }
        float f = super.func_70616_bs();
        if(field_70788_c > 0)
        {
            f *= 2.0F;
        }
        return f;
    }
}
