// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, EntityLiving, MathHelper, World, 
//            Vec3, Vec3Pool, MovingObjectPosition, AxisAlignedBB, 
//            NBTTagCompound

public abstract class EntityThrowable extends Entity
{

    private int field_70189_d;
    private int field_70190_e;
    private int field_70187_f;
    private int field_70188_g;
    protected boolean field_70193_a;
    public int field_70191_b;
    protected EntityLiving field_70192_c;
    private int field_70194_h;
    private int field_70195_i;

    public EntityThrowable(World p_i3583_1_)
    {
        super(p_i3583_1_);
        field_70189_d = -1;
        field_70190_e = -1;
        field_70187_f = -1;
        field_70188_g = 0;
        field_70193_a = false;
        field_70191_b = 0;
        field_70195_i = 0;
        func_70105_a(0.25F, 0.25F);
    }

    protected void func_70088_a()
    {
    }

    public EntityThrowable(World p_i3584_1_, EntityLiving p_i3584_2_)
    {
        super(p_i3584_1_);
        field_70189_d = -1;
        field_70190_e = -1;
        field_70187_f = -1;
        field_70188_g = 0;
        field_70193_a = false;
        field_70191_b = 0;
        field_70195_i = 0;
        field_70192_c = p_i3584_2_;
        func_70105_a(0.25F, 0.25F);
        func_70012_b(p_i3584_2_.field_70165_t, p_i3584_2_.field_70163_u + (double)p_i3584_2_.func_70047_e(), p_i3584_2_.field_70161_v, p_i3584_2_.field_70177_z, p_i3584_2_.field_70125_A);
        field_70165_t -= MathHelper.func_76134_b((field_70177_z / 180F) * 3.141593F) * 0.16F;
        field_70163_u -= 0.10000000149011612D;
        field_70161_v -= MathHelper.func_76126_a((field_70177_z / 180F) * 3.141593F) * 0.16F;
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        field_70129_M = 0.0F;
        float f = 0.4F;
        field_70159_w = -MathHelper.func_76126_a((field_70177_z / 180F) * 3.141593F) * MathHelper.func_76134_b((field_70125_A / 180F) * 3.141593F) * f;
        field_70179_y = MathHelper.func_76134_b((field_70177_z / 180F) * 3.141593F) * MathHelper.func_76134_b((field_70125_A / 180F) * 3.141593F) * f;
        field_70181_x = -MathHelper.func_76126_a(((field_70125_A + func_70183_g()) / 180F) * 3.141593F) * f;
        func_70186_c(field_70159_w, field_70181_x, field_70179_y, func_70182_d(), 1.0F);
    }

    public EntityThrowable(World p_i3585_1_, double p_i3585_2_, double p_i3585_4_, double p_i3585_6_)
    {
        super(p_i3585_1_);
        field_70189_d = -1;
        field_70190_e = -1;
        field_70187_f = -1;
        field_70188_g = 0;
        field_70193_a = false;
        field_70191_b = 0;
        field_70195_i = 0;
        field_70194_h = 0;
        func_70105_a(0.25F, 0.25F);
        func_70107_b(p_i3585_2_, p_i3585_4_, p_i3585_6_);
        field_70129_M = 0.0F;
    }

    protected float func_70182_d()
    {
        return 1.5F;
    }

    protected float func_70183_g()
    {
        return 0.0F;
    }

    public void func_70186_c(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, 
            float p_70186_8_)
    {
        float f = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
        p_70186_1_ /= f;
        p_70186_3_ /= f;
        p_70186_5_ /= f;
        p_70186_1_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70186_8_;
        p_70186_3_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70186_8_;
        p_70186_5_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70186_8_;
        p_70186_1_ *= p_70186_7_;
        p_70186_3_ *= p_70186_7_;
        p_70186_5_ *= p_70186_7_;
        field_70159_w = p_70186_1_;
        field_70181_x = p_70186_3_;
        field_70179_y = p_70186_5_;
        float f1 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
        field_70126_B = field_70177_z = (float)((Math.atan2(p_70186_1_, p_70186_5_) * 180D) / 3.1415927410125732D);
        field_70127_C = field_70125_A = (float)((Math.atan2(p_70186_3_, f1) * 180D) / 3.1415927410125732D);
        field_70194_h = 0;
    }

    public void func_70071_h_()
    {
        field_70142_S = field_70165_t;
        field_70137_T = field_70163_u;
        field_70136_U = field_70161_v;
        super.func_70071_h_();
        if(field_70191_b > 0)
        {
            field_70191_b--;
        }
        if(field_70193_a)
        {
            int i = field_70170_p.func_72798_a(field_70189_d, field_70190_e, field_70187_f);
            if(i == field_70188_g)
            {
                field_70194_h++;
                if(field_70194_h == 1200)
                {
                    func_70106_y();
                }
                return;
            }
            field_70193_a = false;
            field_70159_w *= field_70146_Z.nextFloat() * 0.2F;
            field_70181_x *= field_70146_Z.nextFloat() * 0.2F;
            field_70179_y *= field_70146_Z.nextFloat() * 0.2F;
            field_70194_h = 0;
            field_70195_i = 0;
        } else
        {
            field_70195_i++;
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
        if(!field_70170_p.field_72995_K)
        {
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
                if(entity1.func_70067_L() && (entity1 != field_70192_c || field_70195_i >= 5))
                {
                    float f4 = 0.3F;
                    AxisAlignedBB axisalignedbb = entity1.field_70121_D.func_72314_b(f4, f4, f4);
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
        }
        if(movingobjectposition != null)
        {
            func_70184_a(movingobjectposition);
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
        float f1 = 0.99F;
        float f2 = func_70185_h();
        if(func_70090_H())
        {
            for(int j = 0; j < 4; j++)
            {
                float f3 = 0.25F;
                field_70170_p.func_72869_a("bubble", field_70165_t - field_70159_w * (double)f3, field_70163_u - field_70181_x * (double)f3, field_70161_v - field_70179_y * (double)f3, field_70159_w, field_70181_x, field_70179_y);
            }

            f1 = 0.8F;
        }
        field_70159_w *= f1;
        field_70181_x *= f1;
        field_70179_y *= f1;
        field_70181_x -= f2;
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
    }

    protected float func_70185_h()
    {
        return 0.03F;
    }

    protected abstract void func_70184_a(MovingObjectPosition movingobjectposition);

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74777_a("xTile", (short)field_70189_d);
        p_70014_1_.func_74777_a("yTile", (short)field_70190_e);
        p_70014_1_.func_74777_a("zTile", (short)field_70187_f);
        p_70014_1_.func_74774_a("inTile", (byte)field_70188_g);
        p_70014_1_.func_74774_a("shake", (byte)field_70191_b);
        p_70014_1_.func_74774_a("inGround", (byte)(field_70193_a ? 1 : 0));
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70189_d = p_70037_1_.func_74765_d("xTile");
        field_70190_e = p_70037_1_.func_74765_d("yTile");
        field_70187_f = p_70037_1_.func_74765_d("zTile");
        field_70188_g = p_70037_1_.func_74771_c("inTile") & 0xff;
        field_70191_b = p_70037_1_.func_74771_c("shake") & 0xff;
        field_70193_a = p_70037_1_.func_74771_c("inGround") == 1;
    }
}
