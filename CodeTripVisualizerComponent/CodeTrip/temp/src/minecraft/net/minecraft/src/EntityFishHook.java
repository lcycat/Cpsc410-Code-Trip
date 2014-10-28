// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, EntityPlayer, MathHelper, AxisAlignedBB, 
//            World, ItemStack, Item, Vec3, 
//            Vec3Pool, MovingObjectPosition, DamageSource, AABBPool, 
//            Material, NBTTagCompound, EntityItem, StatList

public class EntityFishHook extends Entity
{

    private int field_70202_d;
    private int field_70203_e;
    private int field_70200_f;
    private int field_70201_g;
    private boolean field_70214_h;
    public int field_70206_a;
    public EntityPlayer field_70204_b;
    private int field_70216_i;
    private int field_70211_j;
    private int field_70219_an;
    public Entity field_70205_c;
    private int field_70217_ao;
    private double field_70218_ap;
    private double field_70210_aq;
    private double field_70209_ar;
    private double field_70208_as;
    private double field_70207_at;
    private double field_70215_au;
    private double field_70213_av;
    private double field_70212_aw;

    public EntityFishHook(World p_i3574_1_)
    {
        super(p_i3574_1_);
        field_70202_d = -1;
        field_70203_e = -1;
        field_70200_f = -1;
        field_70201_g = 0;
        field_70214_h = false;
        field_70206_a = 0;
        field_70211_j = 0;
        field_70219_an = 0;
        field_70205_c = null;
        func_70105_a(0.25F, 0.25F);
        field_70158_ak = true;
    }

    public EntityFishHook(World p_i3575_1_, double p_i3575_2_, double p_i3575_4_, double p_i3575_6_, 
            EntityPlayer p_i3575_8_)
    {
        this(p_i3575_1_);
        func_70107_b(p_i3575_2_, p_i3575_4_, p_i3575_6_);
        field_70158_ak = true;
        field_70204_b = p_i3575_8_;
        p_i3575_8_.field_71104_cf = this;
    }

    public EntityFishHook(World p_i3576_1_, EntityPlayer p_i3576_2_)
    {
        super(p_i3576_1_);
        field_70202_d = -1;
        field_70203_e = -1;
        field_70200_f = -1;
        field_70201_g = 0;
        field_70214_h = false;
        field_70206_a = 0;
        field_70211_j = 0;
        field_70219_an = 0;
        field_70205_c = null;
        field_70158_ak = true;
        field_70204_b = p_i3576_2_;
        field_70204_b.field_71104_cf = this;
        func_70105_a(0.25F, 0.25F);
        func_70012_b(p_i3576_2_.field_70165_t, (p_i3576_2_.field_70163_u + 1.6200000000000001D) - (double)p_i3576_2_.field_70129_M, p_i3576_2_.field_70161_v, p_i3576_2_.field_70177_z, p_i3576_2_.field_70125_A);
        field_70165_t -= MathHelper.func_76134_b((field_70177_z / 180F) * 3.141593F) * 0.16F;
        field_70163_u -= 0.10000000149011612D;
        field_70161_v -= MathHelper.func_76126_a((field_70177_z / 180F) * 3.141593F) * 0.16F;
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        field_70129_M = 0.0F;
        float f = 0.4F;
        field_70159_w = -MathHelper.func_76126_a((field_70177_z / 180F) * 3.141593F) * MathHelper.func_76134_b((field_70125_A / 180F) * 3.141593F) * f;
        field_70179_y = MathHelper.func_76134_b((field_70177_z / 180F) * 3.141593F) * MathHelper.func_76134_b((field_70125_A / 180F) * 3.141593F) * f;
        field_70181_x = -MathHelper.func_76126_a((field_70125_A / 180F) * 3.141593F) * f;
        func_70199_c(field_70159_w, field_70181_x, field_70179_y, 1.5F, 1.0F);
    }

    protected void func_70088_a()
    {
    }

    public boolean func_70112_a(double p_70112_1_)
    {
        double d = field_70121_D.func_72320_b() * 4D;
        d *= 64D;
        return p_70112_1_ < d * d;
    }

    public void func_70199_c(double p_70199_1_, double p_70199_3_, double p_70199_5_, float p_70199_7_, 
            float p_70199_8_)
    {
        float f = MathHelper.func_76133_a(p_70199_1_ * p_70199_1_ + p_70199_3_ * p_70199_3_ + p_70199_5_ * p_70199_5_);
        p_70199_1_ /= f;
        p_70199_3_ /= f;
        p_70199_5_ /= f;
        p_70199_1_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70199_8_;
        p_70199_3_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70199_8_;
        p_70199_5_ += field_70146_Z.nextGaussian() * 0.0074999998323619366D * (double)p_70199_8_;
        p_70199_1_ *= p_70199_7_;
        p_70199_3_ *= p_70199_7_;
        p_70199_5_ *= p_70199_7_;
        field_70159_w = p_70199_1_;
        field_70181_x = p_70199_3_;
        field_70179_y = p_70199_5_;
        float f1 = MathHelper.func_76133_a(p_70199_1_ * p_70199_1_ + p_70199_5_ * p_70199_5_);
        field_70126_B = field_70177_z = (float)((Math.atan2(p_70199_1_, p_70199_5_) * 180D) / 3.1415927410125732D);
        field_70127_C = field_70125_A = (float)((Math.atan2(p_70199_3_, f1) * 180D) / 3.1415927410125732D);
        field_70216_i = 0;
    }

    public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, 
            float p_70056_8_, int p_70056_9_)
    {
        field_70218_ap = p_70056_1_;
        field_70210_aq = p_70056_3_;
        field_70209_ar = p_70056_5_;
        field_70208_as = p_70056_7_;
        field_70207_at = p_70056_8_;
        field_70217_ao = p_70056_9_;
        field_70159_w = field_70215_au;
        field_70181_x = field_70213_av;
        field_70179_y = field_70212_aw;
    }

    public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_)
    {
        field_70215_au = field_70159_w = p_70016_1_;
        field_70213_av = field_70181_x = p_70016_3_;
        field_70212_aw = field_70179_y = p_70016_5_;
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(field_70217_ao > 0)
        {
            double d = field_70165_t + (field_70218_ap - field_70165_t) / (double)field_70217_ao;
            double d1 = field_70163_u + (field_70210_aq - field_70163_u) / (double)field_70217_ao;
            double d2 = field_70161_v + (field_70209_ar - field_70161_v) / (double)field_70217_ao;
            double d4 = MathHelper.func_76138_g(field_70208_as - (double)field_70177_z);
            field_70177_z += d4 / (double)field_70217_ao;
            field_70125_A += (field_70207_at - (double)field_70125_A) / (double)field_70217_ao;
            field_70217_ao--;
            func_70107_b(d, d1, d2);
            func_70101_b(field_70177_z, field_70125_A);
            return;
        }
        if(!field_70170_p.field_72995_K)
        {
            ItemStack itemstack = field_70204_b.func_71045_bC();
            if(field_70204_b.field_70128_L || !field_70204_b.func_70089_S() || itemstack == null || itemstack.func_77973_b() != Item.field_77749_aR || func_70068_e(field_70204_b) > 1024D)
            {
                func_70106_y();
                field_70204_b.field_71104_cf = null;
                return;
            }
            if(field_70205_c != null)
            {
                if(field_70205_c.field_70128_L)
                {
                    field_70205_c = null;
                } else
                {
                    field_70165_t = field_70205_c.field_70165_t;
                    field_70163_u = field_70205_c.field_70121_D.field_72338_b + (double)field_70205_c.field_70131_O * 0.80000000000000004D;
                    field_70161_v = field_70205_c.field_70161_v;
                    return;
                }
            }
        }
        if(field_70206_a > 0)
        {
            field_70206_a--;
        }
        if(field_70214_h)
        {
            int i = field_70170_p.func_72798_a(field_70202_d, field_70203_e, field_70200_f);
            if(i == field_70201_g)
            {
                field_70216_i++;
                if(field_70216_i == 1200)
                {
                    func_70106_y();
                }
                return;
            }
            field_70214_h = false;
            field_70159_w *= field_70146_Z.nextFloat() * 0.2F;
            field_70181_x *= field_70146_Z.nextFloat() * 0.2F;
            field_70179_y *= field_70146_Z.nextFloat() * 0.2F;
            field_70216_i = 0;
            field_70211_j = 0;
        } else
        {
            field_70211_j++;
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
        double d3 = 0.0D;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity1 = (Entity)iterator.next();
            if(entity1.func_70067_L() && (entity1 != field_70204_b || field_70211_j >= 5))
            {
                float f2 = 0.3F;
                AxisAlignedBB axisalignedbb = entity1.field_70121_D.func_72314_b(f2, f2, f2);
                MovingObjectPosition movingobjectposition1 = axisalignedbb.func_72327_a(vec3, vec3_1);
                if(movingobjectposition1 != null)
                {
                    double d6 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
                    if(d6 < d3 || d3 == 0.0D)
                    {
                        entity = entity1;
                        d3 = d6;
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
            if(movingobjectposition.field_72308_g != null)
            {
                if(movingobjectposition.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, field_70204_b), 0))
                {
                    field_70205_c = movingobjectposition.field_72308_g;
                }
            } else
            {
                field_70214_h = true;
            }
        }
        if(field_70214_h)
        {
            return;
        }
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        float f = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
        field_70177_z = (float)((Math.atan2(field_70159_w, field_70179_y) * 180D) / 3.1415927410125732D);
        for(field_70125_A = (float)((Math.atan2(field_70181_x, f) * 180D) / 3.1415927410125732D); field_70125_A - field_70127_C < -180F; field_70127_C -= 360F) { }
        for(; field_70125_A - field_70127_C >= 180F; field_70127_C += 360F) { }
        for(; field_70177_z - field_70126_B < -180F; field_70126_B -= 360F) { }
        for(; field_70177_z - field_70126_B >= 180F; field_70126_B += 360F) { }
        field_70125_A = field_70127_C + (field_70125_A - field_70127_C) * 0.2F;
        field_70177_z = field_70126_B + (field_70177_z - field_70126_B) * 0.2F;
        float f1 = 0.92F;
        if(field_70122_E || field_70123_F)
        {
            f1 = 0.5F;
        }
        int j = 5;
        double d5 = 0.0D;
        for(int k = 0; k < j; k++)
        {
            double d8 = ((field_70121_D.field_72338_b + ((field_70121_D.field_72337_e - field_70121_D.field_72338_b) * (double)(k + 0)) / (double)j) - 0.125D) + 0.125D;
            double d9 = ((field_70121_D.field_72338_b + ((field_70121_D.field_72337_e - field_70121_D.field_72338_b) * (double)(k + 1)) / (double)j) - 0.125D) + 0.125D;
            AxisAlignedBB axisalignedbb1 = AxisAlignedBB.func_72332_a().func_72299_a(field_70121_D.field_72340_a, d8, field_70121_D.field_72339_c, field_70121_D.field_72336_d, d9, field_70121_D.field_72334_f);
            if(field_70170_p.func_72830_b(axisalignedbb1, Material.field_76244_g))
            {
                d5 += 1.0D / (double)j;
            }
        }

        if(d5 > 0.0D)
        {
            if(field_70219_an > 0)
            {
                field_70219_an--;
            } else
            {
                char c = '\u01F4';
                if(field_70170_p.func_72951_B(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u) + 1, MathHelper.func_76128_c(field_70161_v)))
                {
                    c = '\u012C';
                }
                if(field_70146_Z.nextInt(c) == 0)
                {
                    field_70219_an = field_70146_Z.nextInt(30) + 10;
                    field_70181_x -= 0.20000000298023224D;
                    field_70170_p.func_72956_a(this, "random.splash", 0.25F, 1.0F + (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.4F);
                    float f3 = MathHelper.func_76128_c(field_70121_D.field_72338_b);
                    for(int l = 0; (float)l < 1.0F + field_70130_N * 20F; l++)
                    {
                        float f4 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N;
                        float f6 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N;
                        field_70170_p.func_72869_a("bubble", field_70165_t + (double)f4, f3 + 1.0F, field_70161_v + (double)f6, field_70159_w, field_70181_x - (double)(field_70146_Z.nextFloat() * 0.2F), field_70179_y);
                    }

                    for(int i1 = 0; (float)i1 < 1.0F + field_70130_N * 20F; i1++)
                    {
                        float f5 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N;
                        float f7 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N;
                        field_70170_p.func_72869_a("splash", field_70165_t + (double)f5, f3 + 1.0F, field_70161_v + (double)f7, field_70159_w, field_70181_x, field_70179_y);
                    }

                }
            }
        }
        if(field_70219_an > 0)
        {
            field_70181_x -= (double)(field_70146_Z.nextFloat() * field_70146_Z.nextFloat() * field_70146_Z.nextFloat()) * 0.20000000000000001D;
        }
        double d7 = d5 * 2D - 1.0D;
        field_70181_x += 0.039999999105930328D * d7;
        if(d5 > 0.0D)
        {
            f1 = (float)((double)f1 * 0.90000000000000002D);
            field_70181_x *= 0.80000000000000004D;
        }
        field_70159_w *= f1;
        field_70181_x *= f1;
        field_70179_y *= f1;
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74777_a("xTile", (short)field_70202_d);
        p_70014_1_.func_74777_a("yTile", (short)field_70203_e);
        p_70014_1_.func_74777_a("zTile", (short)field_70200_f);
        p_70014_1_.func_74774_a("inTile", (byte)field_70201_g);
        p_70014_1_.func_74774_a("shake", (byte)field_70206_a);
        p_70014_1_.func_74774_a("inGround", (byte)(field_70214_h ? 1 : 0));
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70202_d = p_70037_1_.func_74765_d("xTile");
        field_70203_e = p_70037_1_.func_74765_d("yTile");
        field_70200_f = p_70037_1_.func_74765_d("zTile");
        field_70201_g = p_70037_1_.func_74771_c("inTile") & 0xff;
        field_70206_a = p_70037_1_.func_74771_c("shake") & 0xff;
        field_70214_h = p_70037_1_.func_74771_c("inGround") == 1;
    }

    public float func_70053_R()
    {
        return 0.0F;
    }

    public int func_70198_d()
    {
        if(field_70170_p.field_72995_K)
        {
            return 0;
        }
        byte byte0 = 0;
        if(field_70205_c != null)
        {
            double d = field_70204_b.field_70165_t - field_70165_t;
            double d2 = field_70204_b.field_70163_u - field_70163_u;
            double d4 = field_70204_b.field_70161_v - field_70161_v;
            double d6 = MathHelper.func_76133_a(d * d + d2 * d2 + d4 * d4);
            double d8 = 0.10000000000000001D;
            field_70205_c.field_70159_w += d * d8;
            field_70205_c.field_70181_x += d2 * d8 + (double)MathHelper.func_76133_a(d6) * 0.080000000000000002D;
            field_70205_c.field_70179_y += d4 * d8;
            byte0 = 3;
        } else
        if(field_70219_an > 0)
        {
            EntityItem entityitem = new EntityItem(field_70170_p, field_70165_t, field_70163_u, field_70161_v, new ItemStack(Item.field_77754_aU));
            double d1 = field_70204_b.field_70165_t - field_70165_t;
            double d3 = field_70204_b.field_70163_u - field_70163_u;
            double d5 = field_70204_b.field_70161_v - field_70161_v;
            double d7 = MathHelper.func_76133_a(d1 * d1 + d3 * d3 + d5 * d5);
            double d9 = 0.10000000000000001D;
            entityitem.field_70159_w = d1 * d9;
            entityitem.field_70181_x = d3 * d9 + (double)MathHelper.func_76133_a(d7) * 0.080000000000000002D;
            entityitem.field_70179_y = d5 * d9;
            field_70170_p.func_72838_d(entityitem);
            field_70204_b.func_71064_a(StatList.field_75933_B, 1);
            byte0 = 1;
        }
        if(field_70214_h)
        {
            byte0 = 2;
        }
        func_70106_y();
        field_70204_b.field_71104_cf = null;
        return byte0;
    }

    public void func_70106_y()
    {
        super.func_70106_y();
        if(field_70204_b != null)
        {
            field_70204_b.field_71104_cf = null;
        }
    }
}
