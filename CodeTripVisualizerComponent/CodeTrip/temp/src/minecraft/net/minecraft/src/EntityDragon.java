// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityDragonBase, EntityDragonPart, DataWatcher, MathHelper, 
//            World, Entity, AxisAlignedBB, Vec3, 
//            Vec3Pool, EntityEnderCrystal, DamageSource, EntityLiving, 
//            Block, EntityPlayer, EntityXPOrb, BlockEndPortal

public class EntityDragon extends EntityDragonBase
{

    public double field_70980_b;
    public double field_70981_c;
    public double field_70978_d;
    public double field_70979_e[][];
    public int field_70976_f;
    public EntityDragonPart field_70977_g[];
    public EntityDragonPart field_70986_h;
    public EntityDragonPart field_70987_i;
    public EntityDragonPart field_70985_j;
    public EntityDragonPart field_70984_by;
    public EntityDragonPart field_70982_bz;
    public EntityDragonPart field_70983_bA;
    public EntityDragonPart field_70990_bB;
    public float field_70991_bC;
    public float field_70988_bD;
    public boolean field_70989_bE;
    public boolean field_70994_bF;
    private Entity field_70993_bI;
    public int field_70995_bG;
    public EntityEnderCrystal field_70992_bH;

    public EntityDragon(World p_i3531_1_)
    {
        super(p_i3531_1_);
        field_70979_e = new double[64][3];
        field_70976_f = -1;
        field_70991_bC = 0.0F;
        field_70988_bD = 0.0F;
        field_70989_bE = false;
        field_70994_bF = false;
        field_70995_bG = 0;
        field_70992_bH = null;
        field_70977_g = (new EntityDragonPart[] {
            field_70986_h = new EntityDragonPart(this, "head", 6F, 6F), field_70987_i = new EntityDragonPart(this, "body", 8F, 8F), field_70985_j = new EntityDragonPart(this, "tail", 4F, 4F), field_70984_by = new EntityDragonPart(this, "tail", 4F, 4F), field_70982_bz = new EntityDragonPart(this, "tail", 4F, 4F), field_70983_bA = new EntityDragonPart(this, "wing", 4F, 4F), field_70990_bB = new EntityDragonPart(this, "wing", 4F, 4F)
        });
        field_70966_a = 200;
        func_70606_j(field_70966_a);
        field_70750_az = "/mob/enderdragon/ender.png";
        func_70105_a(16F, 8F);
        field_70145_X = true;
        field_70178_ae = true;
        field_70981_c = 100D;
        field_70158_ak = true;
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, new Integer(field_70966_a));
    }

    public double[] func_70974_a(int p_70974_1_, float p_70974_2_)
    {
        if(field_70734_aK <= 0)
        {
            p_70974_2_ = 0.0F;
        }
        p_70974_2_ = 1.0F - p_70974_2_;
        int i = field_70976_f - p_70974_1_ * 1 & 0x3f;
        int j = field_70976_f - p_70974_1_ * 1 - 1 & 0x3f;
        double ad[] = new double[3];
        double d = field_70979_e[i][0];
        double d1 = MathHelper.func_76138_g(field_70979_e[j][0] - d);
        ad[0] = d + d1 * (double)p_70974_2_;
        d = field_70979_e[i][1];
        d1 = field_70979_e[j][1] - d;
        ad[1] = d + d1 * (double)p_70974_2_;
        ad[2] = field_70979_e[i][2] + (field_70979_e[j][2] - field_70979_e[i][2]) * (double)p_70974_2_;
        return ad;
    }

    public void func_70636_d()
    {
        field_70991_bC = field_70988_bD;
        if(!field_70170_p.field_72995_K)
        {
            field_70180_af.func_75692_b(16, Integer.valueOf(field_70734_aK));
        }
        if(field_70734_aK <= 0)
        {
            float f = (field_70146_Z.nextFloat() - 0.5F) * 8F;
            float f2 = (field_70146_Z.nextFloat() - 0.5F) * 4F;
            float f4 = (field_70146_Z.nextFloat() - 0.5F) * 8F;
            field_70170_p.func_72869_a("largeexplode", field_70165_t + (double)f, field_70163_u + 2D + (double)f2, field_70161_v + (double)f4, 0.0D, 0.0D, 0.0D);
            return;
        }
        func_70969_j();
        float f1 = 0.2F / (MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y) * 10F + 1.0F);
        f1 *= (float)Math.pow(2D, field_70181_x);
        if(field_70994_bF)
        {
            field_70988_bD += f1 * 0.5F;
        } else
        {
            field_70988_bD += f1;
        }
        field_70177_z = MathHelper.func_76142_g(field_70177_z);
        if(field_70976_f < 0)
        {
            for(int i = 0; i < field_70979_e.length; i++)
            {
                field_70979_e[i][0] = field_70177_z;
                field_70979_e[i][1] = field_70163_u;
            }

        }
        if(++field_70976_f == field_70979_e.length)
        {
            field_70976_f = 0;
        }
        field_70979_e[field_70976_f][0] = field_70177_z;
        field_70979_e[field_70976_f][1] = field_70163_u;
        if(field_70170_p.field_72995_K)
        {
            if(field_70716_bi > 0)
            {
                double d = field_70165_t + (field_70709_bj - field_70165_t) / (double)field_70716_bi;
                double d2 = field_70163_u + (field_70710_bk - field_70163_u) / (double)field_70716_bi;
                double d4 = field_70161_v + (field_70711_bl - field_70161_v) / (double)field_70716_bi;
                double d6 = MathHelper.func_76138_g(field_70712_bm - (double)field_70177_z);
                field_70177_z += d6 / (double)field_70716_bi;
                field_70125_A += (field_70705_bn - (double)field_70125_A) / (double)field_70716_bi;
                field_70716_bi--;
                func_70107_b(d, d2, d4);
                func_70101_b(field_70177_z, field_70125_A);
            }
        } else
        {
            double d1 = field_70980_b - field_70165_t;
            double d3 = field_70981_c - field_70163_u;
            double d5 = field_70978_d - field_70161_v;
            double d7 = d1 * d1 + d3 * d3 + d5 * d5;
            if(field_70993_bI != null)
            {
                field_70980_b = field_70993_bI.field_70165_t;
                field_70978_d = field_70993_bI.field_70161_v;
                double d8 = field_70980_b - field_70165_t;
                double d10 = field_70978_d - field_70161_v;
                double d12 = Math.sqrt(d8 * d8 + d10 * d10);
                double d13 = (0.40000000596046448D + d12 / 80D) - 1.0D;
                if(d13 > 10D)
                {
                    d13 = 10D;
                }
                field_70981_c = field_70993_bI.field_70121_D.field_72338_b + d13;
            } else
            {
                field_70980_b += field_70146_Z.nextGaussian() * 2D;
                field_70978_d += field_70146_Z.nextGaussian() * 2D;
            }
            if(field_70989_bE || d7 < 100D || d7 > 22500D || field_70123_F || field_70124_G)
            {
                func_70967_k();
            }
            d3 /= MathHelper.func_76133_a(d1 * d1 + d5 * d5);
            float f10 = 0.6F;
            if(d3 < (double)(-f10))
            {
                d3 = -f10;
            }
            if(d3 > (double)f10)
            {
                d3 = f10;
            }
            field_70181_x += d3 * 0.10000000149011612D;
            field_70177_z = MathHelper.func_76142_g(field_70177_z);
            double d9 = 180D - (Math.atan2(d1, d5) * 180D) / 3.1415927410125732D;
            double d11 = MathHelper.func_76138_g(d9 - (double)field_70177_z);
            if(d11 > 50D)
            {
                d11 = 50D;
            }
            if(d11 < -50D)
            {
                d11 = -50D;
            }
            Vec3 vec3 = Vec3.func_72437_a().func_72345_a(field_70980_b - field_70165_t, field_70981_c - field_70163_u, field_70978_d - field_70161_v).func_72432_b();
            Vec3 vec3_1 = Vec3.func_72437_a().func_72345_a(MathHelper.func_76126_a((field_70177_z * 3.141593F) / 180F), field_70181_x, -MathHelper.func_76134_b((field_70177_z * 3.141593F) / 180F)).func_72432_b();
            float f18 = (float)(vec3_1.func_72430_b(vec3) + 0.5D) / 1.5F;
            if(f18 < 0.0F)
            {
                f18 = 0.0F;
            }
            field_70704_bt *= 0.8F;
            float f19 = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y) * 1.0F + 1.0F;
            double d14 = Math.sqrt(field_70159_w * field_70159_w + field_70179_y * field_70179_y) * 1.0D + 1.0D;
            if(d14 > 40D)
            {
                d14 = 40D;
            }
            field_70704_bt += d11 * (0.69999998807907104D / d14 / (double)f19);
            field_70177_z += field_70704_bt * 0.1F;
            float f20 = (float)(2D / (d14 + 1.0D));
            float f21 = 0.06F;
            func_70060_a(0.0F, -1F, f21 * (f18 * f20 + (1.0F - f20)));
            if(field_70994_bF)
            {
                func_70091_d(field_70159_w * 0.80000001192092896D, field_70181_x * 0.80000001192092896D, field_70179_y * 0.80000001192092896D);
            } else
            {
                func_70091_d(field_70159_w, field_70181_x, field_70179_y);
            }
            Vec3 vec3_2 = Vec3.func_72437_a().func_72345_a(field_70159_w, field_70181_x, field_70179_y).func_72432_b();
            float f22 = (float)(vec3_2.func_72430_b(vec3_1) + 1.0D) / 2.0F;
            f22 = 0.8F + 0.15F * f22;
            field_70159_w *= f22;
            field_70179_y *= f22;
            field_70181_x *= 0.9100000262260437D;
        }
        field_70761_aq = field_70177_z;
        field_70986_h.field_70130_N = field_70986_h.field_70131_O = 3F;
        field_70985_j.field_70130_N = field_70985_j.field_70131_O = 2.0F;
        field_70984_by.field_70130_N = field_70984_by.field_70131_O = 2.0F;
        field_70982_bz.field_70130_N = field_70982_bz.field_70131_O = 2.0F;
        field_70987_i.field_70131_O = 3F;
        field_70987_i.field_70130_N = 5F;
        field_70983_bA.field_70131_O = 2.0F;
        field_70983_bA.field_70130_N = 4F;
        field_70990_bB.field_70131_O = 3F;
        field_70990_bB.field_70130_N = 4F;
        float f3 = (((float)(func_70974_a(5, 1.0F)[1] - func_70974_a(10, 1.0F)[1]) * 10F) / 180F) * 3.141593F;
        float f5 = MathHelper.func_76134_b(f3);
        float f6 = -MathHelper.func_76126_a(f3);
        float f7 = (field_70177_z * 3.141593F) / 180F;
        float f8 = MathHelper.func_76126_a(f7);
        float f9 = MathHelper.func_76134_b(f7);
        field_70987_i.func_70071_h_();
        field_70987_i.func_70012_b(field_70165_t + (double)(f8 * 0.5F), field_70163_u, field_70161_v - (double)(f9 * 0.5F), 0.0F, 0.0F);
        field_70983_bA.func_70071_h_();
        field_70983_bA.func_70012_b(field_70165_t + (double)(f9 * 4.5F), field_70163_u + 2D, field_70161_v + (double)(f8 * 4.5F), 0.0F, 0.0F);
        field_70990_bB.func_70071_h_();
        field_70990_bB.func_70012_b(field_70165_t - (double)(f9 * 4.5F), field_70163_u + 2D, field_70161_v - (double)(f8 * 4.5F), 0.0F, 0.0F);
        if(!field_70170_p.field_72995_K && field_70737_aN == 0)
        {
            func_70970_a(field_70170_p.func_72839_b(this, field_70983_bA.field_70121_D.func_72314_b(4D, 2D, 4D).func_72317_d(0.0D, -2D, 0.0D)));
            func_70970_a(field_70170_p.func_72839_b(this, field_70990_bB.field_70121_D.func_72314_b(4D, 2D, 4D).func_72317_d(0.0D, -2D, 0.0D)));
            func_70971_b(field_70170_p.func_72839_b(this, field_70986_h.field_70121_D.func_72314_b(1.0D, 1.0D, 1.0D)));
        }
        double ad[] = func_70974_a(5, 1.0F);
        double ad1[] = func_70974_a(0, 1.0F);
        float f11 = MathHelper.func_76126_a((field_70177_z * 3.141593F) / 180F - field_70704_bt * 0.01F);
        float f12 = MathHelper.func_76134_b((field_70177_z * 3.141593F) / 180F - field_70704_bt * 0.01F);
        field_70986_h.func_70071_h_();
        field_70986_h.func_70012_b(field_70165_t + (double)(f11 * 5.5F * f5), field_70163_u + (ad1[1] - ad[1]) * 1.0D + (double)(f6 * 5.5F), field_70161_v - (double)(f12 * 5.5F * f5), 0.0F, 0.0F);
        for(int j = 0; j < 3; j++)
        {
            EntityDragonPart entitydragonpart = null;
            if(j == 0)
            {
                entitydragonpart = field_70985_j;
            }
            if(j == 1)
            {
                entitydragonpart = field_70984_by;
            }
            if(j == 2)
            {
                entitydragonpart = field_70982_bz;
            }
            double ad2[] = func_70974_a(12 + j * 2, 1.0F);
            float f13 = (field_70177_z * 3.141593F) / 180F + ((func_70973_b(ad2[0] - ad[0]) * 3.141593F) / 180F) * 1.0F;
            float f14 = MathHelper.func_76126_a(f13);
            float f15 = MathHelper.func_76134_b(f13);
            float f16 = 1.5F;
            float f17 = (float)(j + 1) * 2.0F;
            entitydragonpart.func_70071_h_();
            entitydragonpart.func_70012_b(field_70165_t - (double)((f8 * f16 + f14 * f17) * f5), ((field_70163_u + (ad2[1] - ad[1]) * 1.0D) - (double)((f17 + f16) * f6)) + 1.5D, field_70161_v + (double)((f9 * f16 + f15 * f17) * f5), 0.0F, 0.0F);
        }

        if(!field_70170_p.field_72995_K)
        {
            field_70994_bF = func_70972_a(field_70986_h.field_70121_D) | func_70972_a(field_70987_i.field_70121_D);
        }
    }

    private void func_70969_j()
    {
        if(field_70992_bH != null)
        {
            if(field_70992_bH.field_70128_L)
            {
                if(!field_70170_p.field_72995_K)
                {
                    func_70965_a(field_70986_h, DamageSource.field_76378_k, 10);
                }
                field_70992_bH = null;
            } else
            if(field_70173_aa % 10 == 0 && field_70734_aK < field_70966_a)
            {
                field_70734_aK++;
            }
        }
        if(field_70146_Z.nextInt(10) == 0)
        {
            float f = 32F;
            List list = field_70170_p.func_72872_a(net.minecraft.src.EntityEnderCrystal.class, field_70121_D.func_72314_b(f, f, f));
            EntityEnderCrystal entityendercrystal = null;
            double d = 1.7976931348623157E+308D;
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                EntityEnderCrystal entityendercrystal1 = (EntityEnderCrystal)iterator.next();
                double d1 = entityendercrystal1.func_70068_e(this);
                if(d1 < d)
                {
                    d = d1;
                    entityendercrystal = entityendercrystal1;
                }
            } while(true);
            field_70992_bH = entityendercrystal;
        }
    }

    private void func_70970_a(List p_70970_1_)
    {
        double d = (field_70987_i.field_70121_D.field_72340_a + field_70987_i.field_70121_D.field_72336_d) / 2D;
        double d1 = (field_70987_i.field_70121_D.field_72339_c + field_70987_i.field_70121_D.field_72334_f) / 2D;
        Iterator iterator = p_70970_1_.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity = (Entity)iterator.next();
            if(entity instanceof EntityLiving)
            {
                double d2 = entity.field_70165_t - d;
                double d3 = entity.field_70161_v - d1;
                double d4 = d2 * d2 + d3 * d3;
                entity.func_70024_g((d2 / d4) * 4D, 0.20000000298023224D, (d3 / d4) * 4D);
            }
        } while(true);
    }

    private void func_70971_b(List p_70971_1_)
    {
        Iterator iterator = p_70971_1_.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity = (Entity)iterator.next();
            if(entity instanceof EntityLiving)
            {
                entity.func_70097_a(DamageSource.func_76358_a(this), 10);
            }
        } while(true);
    }

    private void func_70967_k()
    {
        field_70989_bE = false;
        if(field_70146_Z.nextInt(2) == 0 && !field_70170_p.field_73010_i.isEmpty())
        {
            field_70993_bI = (Entity)field_70170_p.field_73010_i.get(field_70146_Z.nextInt(field_70170_p.field_73010_i.size()));
        } else
        {
            boolean flag = false;
            do
            {
                field_70980_b = 0.0D;
                field_70981_c = 70F + field_70146_Z.nextFloat() * 50F;
                field_70978_d = 0.0D;
                field_70980_b += field_70146_Z.nextFloat() * 120F - 60F;
                field_70978_d += field_70146_Z.nextFloat() * 120F - 60F;
                double d = field_70165_t - field_70980_b;
                double d1 = field_70163_u - field_70981_c;
                double d2 = field_70161_v - field_70978_d;
                flag = d * d + d1 * d1 + d2 * d2 > 100D;
            } while(!flag);
            field_70993_bI = null;
        }
    }

    private float func_70973_b(double p_70973_1_)
    {
        return (float)MathHelper.func_76138_g(p_70973_1_);
    }

    private boolean func_70972_a(AxisAlignedBB p_70972_1_)
    {
        int i = MathHelper.func_76128_c(p_70972_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_70972_1_.field_72338_b);
        int k = MathHelper.func_76128_c(p_70972_1_.field_72339_c);
        int l = MathHelper.func_76128_c(p_70972_1_.field_72336_d);
        int i1 = MathHelper.func_76128_c(p_70972_1_.field_72337_e);
        int j1 = MathHelper.func_76128_c(p_70972_1_.field_72334_f);
        boolean flag = false;
        boolean flag1 = false;
        for(int k1 = i; k1 <= l; k1++)
        {
            for(int l1 = j; l1 <= i1; l1++)
            {
                for(int i2 = k; i2 <= j1; i2++)
                {
                    int j2 = field_70170_p.func_72798_a(k1, l1, i2);
                    if(j2 == 0)
                    {
                        continue;
                    }
                    if(j2 == Block.field_72089_ap.field_71990_ca || j2 == Block.field_72082_bJ.field_71990_ca || j2 == Block.field_71986_z.field_71990_ca)
                    {
                        flag = true;
                    } else
                    {
                        flag1 = true;
                        field_70170_p.func_72859_e(k1, l1, i2, 0);
                    }
                }

            }

        }

        if(flag1)
        {
            double d = p_70972_1_.field_72340_a + (p_70972_1_.field_72336_d - p_70972_1_.field_72340_a) * (double)field_70146_Z.nextFloat();
            double d1 = p_70972_1_.field_72338_b + (p_70972_1_.field_72337_e - p_70972_1_.field_72338_b) * (double)field_70146_Z.nextFloat();
            double d2 = p_70972_1_.field_72339_c + (p_70972_1_.field_72334_f - p_70972_1_.field_72339_c) * (double)field_70146_Z.nextFloat();
            field_70170_p.func_72869_a("largeexplode", d, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        return flag;
    }

    public boolean func_70965_a(EntityDragonPart p_70965_1_, DamageSource p_70965_2_, int p_70965_3_)
    {
        if(p_70965_1_ != field_70986_h)
        {
            p_70965_3_ = p_70965_3_ / 4 + 1;
        }
        float f = (field_70177_z * 3.141593F) / 180F;
        float f1 = MathHelper.func_76126_a(f);
        float f2 = MathHelper.func_76134_b(f);
        field_70980_b = field_70165_t + (double)(f1 * 5F) + (double)((field_70146_Z.nextFloat() - 0.5F) * 2.0F);
        field_70981_c = field_70163_u + (double)(field_70146_Z.nextFloat() * 3F) + 1.0D;
        field_70978_d = (field_70161_v - (double)(f2 * 5F)) + (double)((field_70146_Z.nextFloat() - 0.5F) * 2.0F);
        field_70993_bI = null;
        if((p_70965_2_.func_76346_g() instanceof EntityPlayer) || p_70965_2_ == DamageSource.field_76378_k)
        {
            func_70964_e(p_70965_2_, p_70965_3_);
        }
        return true;
    }

    protected void func_70609_aI()
    {
        field_70995_bG++;
        if(field_70995_bG >= 180 && field_70995_bG <= 200)
        {
            float f = (field_70146_Z.nextFloat() - 0.5F) * 8F;
            float f1 = (field_70146_Z.nextFloat() - 0.5F) * 4F;
            float f2 = (field_70146_Z.nextFloat() - 0.5F) * 8F;
            field_70170_p.func_72869_a("hugeexplosion", field_70165_t + (double)f, field_70163_u + 2D + (double)f1, field_70161_v + (double)f2, 0.0D, 0.0D, 0.0D);
        }
        if(!field_70170_p.field_72995_K && field_70995_bG > 150 && field_70995_bG % 5 == 0)
        {
            for(int i = 1000; i > 0;)
            {
                int k = EntityXPOrb.func_70527_a(i);
                i -= k;
                field_70170_p.func_72838_d(new EntityXPOrb(field_70170_p, field_70165_t, field_70163_u, field_70161_v, k));
            }

        }
        func_70091_d(0.0D, 0.10000000149011612D, 0.0D);
        field_70761_aq = field_70177_z += 20F;
        if(field_70995_bG == 200 && !field_70170_p.field_72995_K)
        {
            for(int j = 2000; j > 0;)
            {
                int l = EntityXPOrb.func_70527_a(j);
                j -= l;
                field_70170_p.func_72838_d(new EntityXPOrb(field_70170_p, field_70165_t, field_70163_u, field_70161_v, l));
            }

            func_70975_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70161_v));
            func_70106_y();
        }
    }

    private void func_70975_a(int p_70975_1_, int p_70975_2_)
    {
        byte byte0 = 64;
        BlockEndPortal.field_72275_a = true;
        int i = 4;
        for(int j = byte0 - 1; j <= byte0 + 32; j++)
        {
            for(int k = p_70975_1_ - i; k <= p_70975_1_ + i; k++)
            {
                for(int l = p_70975_2_ - i; l <= p_70975_2_ + i; l++)
                {
                    double d = k - p_70975_1_;
                    double d1 = l - p_70975_2_;
                    double d2 = d * d + d1 * d1;
                    if(d2 > ((double)i - 0.5D) * ((double)i - 0.5D))
                    {
                        continue;
                    }
                    if(j < byte0)
                    {
                        if(d2 <= ((double)(i - 1) - 0.5D) * ((double)(i - 1) - 0.5D))
                        {
                            field_70170_p.func_72859_e(k, j, l, Block.field_71986_z.field_71990_ca);
                        }
                        continue;
                    }
                    if(j > byte0)
                    {
                        field_70170_p.func_72859_e(k, j, l, 0);
                        continue;
                    }
                    if(d2 > ((double)(i - 1) - 0.5D) * ((double)(i - 1) - 0.5D))
                    {
                        field_70170_p.func_72859_e(k, j, l, Block.field_71986_z.field_71990_ca);
                    } else
                    {
                        field_70170_p.func_72859_e(k, j, l, Block.field_72102_bH.field_71990_ca);
                    }
                }

            }

        }

        field_70170_p.func_72859_e(p_70975_1_, byte0 + 0, p_70975_2_, Block.field_71986_z.field_71990_ca);
        field_70170_p.func_72859_e(p_70975_1_, byte0 + 1, p_70975_2_, Block.field_71986_z.field_71990_ca);
        field_70170_p.func_72859_e(p_70975_1_, byte0 + 2, p_70975_2_, Block.field_71986_z.field_71990_ca);
        field_70170_p.func_72859_e(p_70975_1_ - 1, byte0 + 2, p_70975_2_, Block.field_72069_aq.field_71990_ca);
        field_70170_p.func_72859_e(p_70975_1_ + 1, byte0 + 2, p_70975_2_, Block.field_72069_aq.field_71990_ca);
        field_70170_p.func_72859_e(p_70975_1_, byte0 + 2, p_70975_2_ - 1, Block.field_72069_aq.field_71990_ca);
        field_70170_p.func_72859_e(p_70975_1_, byte0 + 2, p_70975_2_ + 1, Block.field_72069_aq.field_71990_ca);
        field_70170_p.func_72859_e(p_70975_1_, byte0 + 3, p_70975_2_, Block.field_71986_z.field_71990_ca);
        field_70170_p.func_72859_e(p_70975_1_, byte0 + 4, p_70975_2_, Block.field_72084_bK.field_71990_ca);
        BlockEndPortal.field_72275_a = false;
    }

    protected void func_70623_bb()
    {
    }

    public Entity[] func_70021_al()
    {
        return field_70977_g;
    }

    public boolean func_70067_L()
    {
        return false;
    }

    public int func_70968_i()
    {
        return field_70180_af.func_75679_c(16);
    }
}
