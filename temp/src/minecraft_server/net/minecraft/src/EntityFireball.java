// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, MathHelper, EntityLiving, World, 
//            Vec3, Vec3Pool, MovingObjectPosition, AxisAlignedBB, 
//            DamageSource, NBTTagCompound, NBTTagList, NBTTagDouble

public class EntityFireball extends Entity
{

    private int field_70231_e;
    private int field_70228_f;
    private int field_70229_g;
    private int field_70237_h;
    private boolean field_70238_i;
    public EntityLiving field_70235_a;
    private int field_70236_j;
    private int field_70234_an;
    public double field_70232_b;
    public double field_70233_c;
    public double field_70230_d;

    public EntityFireball(World p_i3571_1_)
    {
        super(p_i3571_1_);
        field_70231_e = -1;
        field_70228_f = -1;
        field_70229_g = -1;
        field_70237_h = 0;
        field_70238_i = false;
        field_70234_an = 0;
        func_70105_a(1.0F, 1.0F);
    }

    protected void func_70088_a()
    {
    }

    public EntityFireball(World p_i3572_1_, double p_i3572_2_, double p_i3572_4_, double p_i3572_6_, 
            double p_i3572_8_, double p_i3572_10_, double p_i3572_12_)
    {
        super(p_i3572_1_);
        field_70231_e = -1;
        field_70228_f = -1;
        field_70229_g = -1;
        field_70237_h = 0;
        field_70238_i = false;
        field_70234_an = 0;
        func_70105_a(1.0F, 1.0F);
        func_70012_b(p_i3572_2_, p_i3572_4_, p_i3572_6_, field_70177_z, field_70125_A);
        func_70107_b(p_i3572_2_, p_i3572_4_, p_i3572_6_);
        double d = MathHelper.func_76133_a(p_i3572_8_ * p_i3572_8_ + p_i3572_10_ * p_i3572_10_ + p_i3572_12_ * p_i3572_12_);
        field_70232_b = (p_i3572_8_ / d) * 0.10000000000000001D;
        field_70233_c = (p_i3572_10_ / d) * 0.10000000000000001D;
        field_70230_d = (p_i3572_12_ / d) * 0.10000000000000001D;
    }

    public EntityFireball(World p_i3573_1_, EntityLiving p_i3573_2_, double p_i3573_3_, double p_i3573_5_, double p_i3573_7_)
    {
        super(p_i3573_1_);
        field_70231_e = -1;
        field_70228_f = -1;
        field_70229_g = -1;
        field_70237_h = 0;
        field_70238_i = false;
        field_70234_an = 0;
        field_70235_a = p_i3573_2_;
        func_70105_a(1.0F, 1.0F);
        func_70012_b(p_i3573_2_.field_70165_t, p_i3573_2_.field_70163_u, p_i3573_2_.field_70161_v, p_i3573_2_.field_70177_z, p_i3573_2_.field_70125_A);
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        field_70129_M = 0.0F;
        field_70159_w = field_70181_x = field_70179_y = 0.0D;
        p_i3573_3_ += field_70146_Z.nextGaussian() * 0.40000000000000002D;
        p_i3573_5_ += field_70146_Z.nextGaussian() * 0.40000000000000002D;
        p_i3573_7_ += field_70146_Z.nextGaussian() * 0.40000000000000002D;
        double d = MathHelper.func_76133_a(p_i3573_3_ * p_i3573_3_ + p_i3573_5_ * p_i3573_5_ + p_i3573_7_ * p_i3573_7_);
        field_70232_b = (p_i3573_3_ / d) * 0.10000000000000001D;
        field_70233_c = (p_i3573_5_ / d) * 0.10000000000000001D;
        field_70230_d = (p_i3573_7_ / d) * 0.10000000000000001D;
    }

    public void func_70071_h_()
    {
        if(!field_70170_p.field_72995_K && (field_70235_a != null && field_70235_a.field_70128_L || !field_70170_p.func_72899_e((int)field_70165_t, (int)field_70163_u, (int)field_70161_v)))
        {
            func_70106_y();
            return;
        }
        super.func_70071_h_();
        func_70015_d(1);
        if(field_70238_i)
        {
            int i = field_70170_p.func_72798_a(field_70231_e, field_70228_f, field_70229_g);
            if(i == field_70237_h)
            {
                field_70236_j++;
                if(field_70236_j == 600)
                {
                    func_70106_y();
                }
                return;
            }
            field_70238_i = false;
            field_70159_w *= field_70146_Z.nextFloat() * 0.2F;
            field_70181_x *= field_70146_Z.nextFloat() * 0.2F;
            field_70179_y *= field_70146_Z.nextFloat() * 0.2F;
            field_70236_j = 0;
            field_70234_an = 0;
        } else
        {
            field_70234_an++;
        }
        Vec3 vec3 = Vec3.func_72437_a().func_72345_a(field_70165_t, field_70163_u, field_70161_v);
        Vec3 vec3_1 = Vec3.func_72437_a().func_72345_a(field_70165_t + field_70159_w, field_70163_u + field_70181_x, field_70161_v + field_70179_y);
        MovingObjectPosition movingobjectposition = field_70170_p.func_72933_a(vec3, vec3_1);
        vec3 = Vec3.func_72437_a().func_72345_a(field_70165_t, field_70163_u, field_70161_v);
        vec3_1 = Vec3.func_72437_a().func_72345_a(field_70165_t + field_70159_w, field_70163_u + field_70181_x, field_70161_v + field_70179_y);
        if(movingobjectposition != null)
        {
            vec3_1 = Vec3.func_72437_a().func_72345_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
        }
        Entity entity = null;
        List list = field_70170_p.func_72839_b(this, field_70121_D.func_72321_a(field_70159_w, field_70181_x, field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
        double d = 0.0D;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity1 = (Entity)iterator.next();
            if(entity1.func_70067_L() && (!entity1.func_70028_i(field_70235_a) || field_70234_an >= 25))
            {
                float f2 = 0.3F;
                AxisAlignedBB axisalignedbb = entity1.field_70121_D.func_72314_b(f2, f2, f2);
                MovingObjectPosition movingobjectposition1 = axisalignedbb.func_72327_a(vec3, vec3_1);
                if(movingobjectposition1 != null)
                {
                    double d1 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
                    if(d1 < d || d == 0.0D)
                    {
                        entity = entity1;
                        d = d1;
                    }
                }
            }
        } while(true);
        if(entity != null)
        {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if(movingobjectposition != null)
        {
            func_70227_a(movingobjectposition);
        }
        field_70165_t += field_70159_w;
        field_70163_u += field_70181_x;
        field_70161_v += field_70179_y;
        float f = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
        field_70177_z = (float)((Math.atan2(field_70159_w, field_70179_y) * 180D) / 3.1415927410125732D);
        for(field_70125_A = (float)((Math.atan2(field_70181_x, f) * 180D) / 3.1415927410125732D); field_70125_A - field_70127_C < -180F; field_70127_C -= 360F) { }
        for(; field_70125_A - field_70127_C >= 180F; field_70127_C += 360F) { }
        for(; field_70177_z - field_70126_B < -180F; field_70126_B -= 360F) { }
        for(; field_70177_z - field_70126_B >= 180F; field_70126_B += 360F) { }
        field_70125_A = field_70127_C + (field_70125_A - field_70127_C) * 0.2F;
        field_70177_z = field_70126_B + (field_70177_z - field_70126_B) * 0.2F;
        float f1 = 0.95F;
        if(func_70090_H())
        {
            for(int j = 0; j < 4; j++)
            {
                float f3 = 0.25F;
                field_70170_p.func_72869_a("bubble", field_70165_t - field_70159_w * (double)f3, field_70163_u - field_70181_x * (double)f3, field_70161_v - field_70179_y * (double)f3, field_70159_w, field_70181_x, field_70179_y);
            }

            f1 = 0.8F;
        }
        field_70159_w += field_70232_b;
        field_70181_x += field_70233_c;
        field_70179_y += field_70230_d;
        field_70159_w *= f1;
        field_70181_x *= f1;
        field_70179_y *= f1;
        field_70170_p.func_72869_a("smoke", field_70165_t, field_70163_u + 0.5D, field_70161_v, 0.0D, 0.0D, 0.0D);
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
    }

    protected void func_70227_a(MovingObjectPosition p_70227_1_)
    {
        if(!field_70170_p.field_72995_K)
        {
            if(p_70227_1_.field_72308_g != null)
            {
                p_70227_1_.field_72308_g.func_70097_a(DamageSource.func_76362_a(this, field_70235_a), 6);
            }
            field_70170_p.func_72885_a(null, field_70165_t, field_70163_u, field_70161_v, 1.0F, true);
            func_70106_y();
        }
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74777_a("xTile", (short)field_70231_e);
        p_70014_1_.func_74777_a("yTile", (short)field_70228_f);
        p_70014_1_.func_74777_a("zTile", (short)field_70229_g);
        p_70014_1_.func_74774_a("inTile", (byte)field_70237_h);
        p_70014_1_.func_74774_a("inGround", (byte)(field_70238_i ? 1 : 0));
        p_70014_1_.func_74782_a("direction", func_70087_a(new double[] {
            field_70159_w, field_70181_x, field_70179_y
        }));
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70231_e = p_70037_1_.func_74765_d("xTile");
        field_70228_f = p_70037_1_.func_74765_d("yTile");
        field_70229_g = p_70037_1_.func_74765_d("zTile");
        field_70237_h = p_70037_1_.func_74771_c("inTile") & 0xff;
        field_70238_i = p_70037_1_.func_74771_c("inGround") == 1;
        if(p_70037_1_.func_74764_b("direction"))
        {
            NBTTagList nbttaglist = p_70037_1_.func_74761_m("direction");
            field_70159_w = ((NBTTagDouble)nbttaglist.func_74743_b(0)).field_74755_a;
            field_70181_x = ((NBTTagDouble)nbttaglist.func_74743_b(1)).field_74755_a;
            field_70179_y = ((NBTTagDouble)nbttaglist.func_74743_b(2)).field_74755_a;
        } else
        {
            func_70106_y();
        }
    }

    public boolean func_70067_L()
    {
        return true;
    }

    public float func_70111_Y()
    {
        return 1.0F;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        func_70018_K();
        if(p_70097_1_.func_76346_g() != null)
        {
            Vec3 vec3 = p_70097_1_.func_76346_g().func_70040_Z();
            if(vec3 != null)
            {
                field_70159_w = vec3.field_72450_a;
                field_70181_x = vec3.field_72448_b;
                field_70179_y = vec3.field_72449_c;
                field_70232_b = field_70159_w * 0.10000000000000001D;
                field_70233_c = field_70181_x * 0.10000000000000001D;
                field_70230_d = field_70179_y * 0.10000000000000001D;
            }
            if(p_70097_1_.func_76346_g() instanceof EntityLiving)
            {
                field_70235_a = (EntityLiving)p_70097_1_.func_76346_g();
            }
            return true;
        } else
        {
            return false;
        }
    }

    public float func_70013_c(float p_70013_1_)
    {
        return 1.0F;
    }
}
