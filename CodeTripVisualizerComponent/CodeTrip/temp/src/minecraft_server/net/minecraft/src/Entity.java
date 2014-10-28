// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            AxisAlignedBB, DataWatcher, EnumEntitySize, World, 
//            Profiler, MathHelper, DamageSource, EntityPlayer, 
//            Block, StepSound, Material, EntityLiving, 
//            BlockFluid, NBTTagCompound, NBTTagList, NBTTagDouble, 
//            NBTTagFloat, EntityList, ItemStack, EntityItem, 
//            StatCollector, WorldInfo, Vec3, EntityLightningBolt

public abstract class Entity
{

    private static int field_70152_a = 0;
    public int field_70157_k;
    public double field_70155_l;
    public boolean field_70156_m;
    public Entity field_70153_n;
    public Entity field_70154_o;
    public World field_70170_p;
    public double field_70169_q;
    public double field_70167_r;
    public double field_70166_s;
    public double field_70165_t;
    public double field_70163_u;
    public double field_70161_v;
    public double field_70159_w;
    public double field_70181_x;
    public double field_70179_y;
    public float field_70177_z;
    public float field_70125_A;
    public float field_70126_B;
    public float field_70127_C;
    public final AxisAlignedBB field_70121_D = AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    public boolean field_70122_E;
    public boolean field_70123_F;
    public boolean field_70124_G;
    public boolean field_70132_H;
    public boolean field_70133_I;
    protected boolean field_70134_J;
    public boolean field_70135_K;
    public boolean field_70128_L;
    public float field_70129_M;
    public float field_70130_N;
    public float field_70131_O;
    public float field_70141_P;
    public float field_70140_Q;
    public float field_70143_R;
    private int field_70150_b;
    public double field_70142_S;
    public double field_70137_T;
    public double field_70136_U;
    public float field_70139_V;
    public float field_70138_W;
    public boolean field_70145_X;
    public float field_70144_Y;
    protected Random field_70146_Z;
    public int field_70173_aa;
    public int field_70174_ab;
    private int field_70151_c;
    protected boolean field_70171_ac;
    public int field_70172_ad;
    private boolean field_70148_d;
    protected boolean field_70178_ae;
    protected DataWatcher field_70180_af;
    private double field_70149_e;
    private double field_70147_f;
    public boolean field_70175_ag;
    public int field_70176_ah;
    public int field_70162_ai;
    public int field_70164_aj;
    public boolean field_70158_ak;
    public boolean field_70160_al;
    public EnumEntitySize field_70168_am;

    public Entity(World p_i3438_1_)
    {
        field_70157_k = field_70152_a++;
        field_70155_l = 1.0D;
        field_70156_m = false;
        field_70122_E = false;
        field_70132_H = false;
        field_70133_I = false;
        field_70135_K = true;
        field_70128_L = false;
        field_70129_M = 0.0F;
        field_70130_N = 0.6F;
        field_70131_O = 1.8F;
        field_70141_P = 0.0F;
        field_70140_Q = 0.0F;
        field_70143_R = 0.0F;
        field_70150_b = 1;
        field_70139_V = 0.0F;
        field_70138_W = 0.0F;
        field_70145_X = false;
        field_70144_Y = 0.0F;
        field_70146_Z = new Random();
        field_70173_aa = 0;
        field_70174_ab = 1;
        field_70151_c = 0;
        field_70171_ac = false;
        field_70172_ad = 0;
        field_70148_d = true;
        field_70178_ae = false;
        field_70180_af = new DataWatcher();
        field_70175_ag = false;
        field_70168_am = EnumEntitySize.SIZE_2;
        field_70170_p = p_i3438_1_;
        func_70107_b(0.0D, 0.0D, 0.0D);
        field_70180_af.func_75682_a(0, Byte.valueOf((byte)0));
        field_70180_af.func_75682_a(1, Short.valueOf((short)300));
        func_70088_a();
    }

    protected abstract void func_70088_a();

    public DataWatcher func_70096_w()
    {
        return field_70180_af;
    }

    public boolean equals(Object p_equals_1_)
    {
        if(p_equals_1_ instanceof Entity)
        {
            return ((Entity)p_equals_1_).field_70157_k == field_70157_k;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return field_70157_k;
    }

    public void func_70106_y()
    {
        field_70128_L = true;
    }

    protected void func_70105_a(float p_70105_1_, float p_70105_2_)
    {
        field_70130_N = p_70105_1_;
        field_70131_O = p_70105_2_;
        float f = p_70105_1_ % 2.0F;
        if((double)f < 0.375D)
        {
            field_70168_am = EnumEntitySize.SIZE_1;
        } else
        if((double)f < 0.75D)
        {
            field_70168_am = EnumEntitySize.SIZE_2;
        } else
        if((double)f < 1.0D)
        {
            field_70168_am = EnumEntitySize.SIZE_3;
        } else
        if((double)f < 1.375D)
        {
            field_70168_am = EnumEntitySize.SIZE_4;
        } else
        if((double)f < 1.75D)
        {
            field_70168_am = EnumEntitySize.SIZE_5;
        } else
        {
            field_70168_am = EnumEntitySize.SIZE_6;
        }
    }

    protected void func_70101_b(float p_70101_1_, float p_70101_2_)
    {
        field_70177_z = p_70101_1_ % 360F;
        field_70125_A = p_70101_2_ % 360F;
    }

    public void func_70107_b(double p_70107_1_, double p_70107_3_, double p_70107_5_)
    {
        field_70165_t = p_70107_1_;
        field_70163_u = p_70107_3_;
        field_70161_v = p_70107_5_;
        float f = field_70130_N / 2.0F;
        float f1 = field_70131_O;
        field_70121_D.func_72324_b(p_70107_1_ - (double)f, (p_70107_3_ - (double)field_70129_M) + (double)field_70139_V, p_70107_5_ - (double)f, p_70107_1_ + (double)f, (p_70107_3_ - (double)field_70129_M) + (double)field_70139_V + (double)f1, p_70107_5_ + (double)f);
    }

    public void func_70071_h_()
    {
        func_70030_z();
    }

    public void func_70030_z()
    {
        field_70170_p.field_72984_F.func_76320_a("entityBaseTick");
        if(field_70154_o != null && field_70154_o.field_70128_L)
        {
            field_70154_o = null;
        }
        field_70173_aa++;
        field_70141_P = field_70140_Q;
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70127_C = field_70125_A;
        field_70126_B = field_70177_z;
        if(func_70051_ag() && !func_70090_H())
        {
            int i = MathHelper.func_76128_c(field_70165_t);
            int j = MathHelper.func_76128_c(field_70163_u - 0.20000000298023224D - (double)field_70129_M);
            int k = MathHelper.func_76128_c(field_70161_v);
            int j1 = field_70170_p.func_72798_a(i, j, k);
            if(j1 > 0)
            {
                field_70170_p.func_72869_a((new StringBuilder()).append("tilecrack_").append(j1).toString(), field_70165_t + ((double)field_70146_Z.nextFloat() - 0.5D) * (double)field_70130_N, field_70121_D.field_72338_b + 0.10000000000000001D, field_70161_v + ((double)field_70146_Z.nextFloat() - 0.5D) * (double)field_70130_N, -field_70159_w * 4D, 1.5D, -field_70179_y * 4D);
            }
        }
        if(func_70072_I())
        {
            if(!field_70171_ac && !field_70148_d)
            {
                float f = MathHelper.func_76133_a(field_70159_w * field_70159_w * 0.20000000298023224D + field_70181_x * field_70181_x + field_70179_y * field_70179_y * 0.20000000298023224D) * 0.2F;
                if(f > 1.0F)
                {
                    f = 1.0F;
                }
                field_70170_p.func_72956_a(this, "random.splash", f, 1.0F + (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.4F);
                float f1 = MathHelper.func_76128_c(field_70121_D.field_72338_b);
                for(int l = 0; (float)l < 1.0F + field_70130_N * 20F; l++)
                {
                    float f2 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N;
                    float f4 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N;
                    field_70170_p.func_72869_a("bubble", field_70165_t + (double)f2, f1 + 1.0F, field_70161_v + (double)f4, field_70159_w, field_70181_x - (double)(field_70146_Z.nextFloat() * 0.2F), field_70179_y);
                }

                for(int i1 = 0; (float)i1 < 1.0F + field_70130_N * 20F; i1++)
                {
                    float f3 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N;
                    float f5 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N;
                    field_70170_p.func_72869_a("splash", field_70165_t + (double)f3, f1 + 1.0F, field_70161_v + (double)f5, field_70159_w, field_70181_x, field_70179_y);
                }

            }
            field_70143_R = 0.0F;
            field_70171_ac = true;
            field_70151_c = 0;
        } else
        {
            field_70171_ac = false;
        }
        if(field_70170_p.field_72995_K)
        {
            field_70151_c = 0;
        } else
        if(field_70151_c > 0)
        {
            if(field_70178_ae)
            {
                field_70151_c -= 4;
                if(field_70151_c < 0)
                {
                    field_70151_c = 0;
                }
            } else
            {
                if(field_70151_c % 20 == 0)
                {
                    func_70097_a(DamageSource.field_76370_b, 1);
                }
                field_70151_c--;
            }
        }
        if(func_70058_J())
        {
            func_70044_A();
            field_70143_R *= 0.5F;
        }
        if(field_70163_u < -64D)
        {
            func_70076_C();
        }
        if(!field_70170_p.field_72995_K)
        {
            func_70052_a(0, field_70151_c > 0);
            func_70052_a(2, field_70154_o != null);
        }
        field_70148_d = false;
        field_70170_p.field_72984_F.func_76319_b();
    }

    protected void func_70044_A()
    {
        if(!field_70178_ae)
        {
            func_70097_a(DamageSource.field_76371_c, 4);
            func_70015_d(15);
        }
    }

    public void func_70015_d(int p_70015_1_)
    {
        int i = p_70015_1_ * 20;
        if(field_70151_c < i)
        {
            field_70151_c = i;
        }
    }

    public void func_70066_B()
    {
        field_70151_c = 0;
    }

    protected void func_70076_C()
    {
        func_70106_y();
    }

    public boolean func_70038_c(double p_70038_1_, double p_70038_3_, double p_70038_5_)
    {
        AxisAlignedBB axisalignedbb = field_70121_D.func_72325_c(p_70038_1_, p_70038_3_, p_70038_5_);
        List list = field_70170_p.func_72945_a(this, axisalignedbb);
        if(!list.isEmpty())
        {
            return false;
        }
        return !field_70170_p.func_72953_d(axisalignedbb);
    }

    public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_)
    {
        if(field_70145_X)
        {
            field_70121_D.func_72317_d(p_70091_1_, p_70091_3_, p_70091_5_);
            field_70165_t = (field_70121_D.field_72340_a + field_70121_D.field_72336_d) / 2D;
            field_70163_u = (field_70121_D.field_72338_b + (double)field_70129_M) - (double)field_70139_V;
            field_70161_v = (field_70121_D.field_72339_c + field_70121_D.field_72334_f) / 2D;
            return;
        }
        field_70170_p.field_72984_F.func_76320_a("move");
        field_70139_V *= 0.4F;
        double d = field_70165_t;
        double d1 = field_70161_v;
        if(field_70134_J)
        {
            field_70134_J = false;
            p_70091_1_ *= 0.25D;
            p_70091_3_ *= 0.05000000074505806D;
            p_70091_5_ *= 0.25D;
            field_70159_w = 0.0D;
            field_70181_x = 0.0D;
            field_70179_y = 0.0D;
        }
        double d2 = p_70091_1_;
        double d3 = p_70091_3_;
        double d4 = p_70091_5_;
        AxisAlignedBB axisalignedbb = field_70121_D.func_72329_c();
        boolean flag = field_70122_E && func_70093_af() && (this instanceof EntityPlayer);
        if(flag)
        {
            double d5 = 0.050000000000000003D;
            for(; p_70091_1_ != 0.0D && field_70170_p.func_72945_a(this, field_70121_D.func_72325_c(p_70091_1_, -1D, 0.0D)).isEmpty(); d2 = p_70091_1_)
            {
                if(p_70091_1_ < d5 && p_70091_1_ >= -d5)
                {
                    p_70091_1_ = 0.0D;
                    continue;
                }
                if(p_70091_1_ > 0.0D)
                {
                    p_70091_1_ -= d5;
                } else
                {
                    p_70091_1_ += d5;
                }
            }

            for(; p_70091_5_ != 0.0D && field_70170_p.func_72945_a(this, field_70121_D.func_72325_c(0.0D, -1D, p_70091_5_)).isEmpty(); d4 = p_70091_5_)
            {
                if(p_70091_5_ < d5 && p_70091_5_ >= -d5)
                {
                    p_70091_5_ = 0.0D;
                    continue;
                }
                if(p_70091_5_ > 0.0D)
                {
                    p_70091_5_ -= d5;
                } else
                {
                    p_70091_5_ += d5;
                }
            }

            while(p_70091_1_ != 0.0D && p_70091_5_ != 0.0D && field_70170_p.func_72945_a(this, field_70121_D.func_72325_c(p_70091_1_, -1D, p_70091_5_)).isEmpty()) 
            {
                if(p_70091_1_ < d5 && p_70091_1_ >= -d5)
                {
                    p_70091_1_ = 0.0D;
                } else
                if(p_70091_1_ > 0.0D)
                {
                    p_70091_1_ -= d5;
                } else
                {
                    p_70091_1_ += d5;
                }
                if(p_70091_5_ < d5 && p_70091_5_ >= -d5)
                {
                    p_70091_5_ = 0.0D;
                } else
                if(p_70091_5_ > 0.0D)
                {
                    p_70091_5_ -= d5;
                } else
                {
                    p_70091_5_ += d5;
                }
                d2 = p_70091_1_;
                d4 = p_70091_5_;
            }
        }
        List list = field_70170_p.func_72945_a(this, field_70121_D.func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            AxisAlignedBB axisalignedbb1 = (AxisAlignedBB)iterator.next();
            p_70091_3_ = axisalignedbb1.func_72323_b(field_70121_D, p_70091_3_);
        }

        field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
        if(!field_70135_K && d3 != p_70091_3_)
        {
            p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
        }
        boolean flag1 = field_70122_E || d3 != p_70091_3_ && d3 < 0.0D;
        for(Iterator iterator1 = list.iterator(); iterator1.hasNext();)
        {
            AxisAlignedBB axisalignedbb2 = (AxisAlignedBB)iterator1.next();
            p_70091_1_ = axisalignedbb2.func_72316_a(field_70121_D, p_70091_1_);
        }

        field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
        if(!field_70135_K && d2 != p_70091_1_)
        {
            p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
        }
        for(Iterator iterator2 = list.iterator(); iterator2.hasNext();)
        {
            AxisAlignedBB axisalignedbb3 = (AxisAlignedBB)iterator2.next();
            p_70091_5_ = axisalignedbb3.func_72322_c(field_70121_D, p_70091_5_);
        }

        field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
        if(!field_70135_K && d4 != p_70091_5_)
        {
            p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
        }
        if(field_70138_W > 0.0F && flag1 && (flag || field_70139_V < 0.05F) && (d2 != p_70091_1_ || d4 != p_70091_5_))
        {
            double d6 = p_70091_1_;
            double d8 = p_70091_3_;
            double d10 = p_70091_5_;
            p_70091_1_ = d2;
            p_70091_3_ = field_70138_W;
            p_70091_5_ = d4;
            AxisAlignedBB axisalignedbb4 = field_70121_D.func_72329_c();
            field_70121_D.func_72328_c(axisalignedbb);
            List list1 = field_70170_p.func_72945_a(this, field_70121_D.func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));
            for(Iterator iterator3 = list1.iterator(); iterator3.hasNext();)
            {
                AxisAlignedBB axisalignedbb5 = (AxisAlignedBB)iterator3.next();
                p_70091_3_ = axisalignedbb5.func_72323_b(field_70121_D, p_70091_3_);
            }

            field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
            if(!field_70135_K && d3 != p_70091_3_)
            {
                p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
            }
            for(Iterator iterator4 = list1.iterator(); iterator4.hasNext();)
            {
                AxisAlignedBB axisalignedbb6 = (AxisAlignedBB)iterator4.next();
                p_70091_1_ = axisalignedbb6.func_72316_a(field_70121_D, p_70091_1_);
            }

            field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
            if(!field_70135_K && d2 != p_70091_1_)
            {
                p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
            }
            for(Iterator iterator5 = list1.iterator(); iterator5.hasNext();)
            {
                AxisAlignedBB axisalignedbb7 = (AxisAlignedBB)iterator5.next();
                p_70091_5_ = axisalignedbb7.func_72322_c(field_70121_D, p_70091_5_);
            }

            field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
            if(!field_70135_K && d4 != p_70091_5_)
            {
                p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
            }
            if(!field_70135_K && d3 != p_70091_3_)
            {
                p_70091_1_ = p_70091_3_ = p_70091_5_ = 0.0D;
            } else
            {
                p_70091_3_ = -field_70138_W;
                for(Iterator iterator6 = list1.iterator(); iterator6.hasNext();)
                {
                    AxisAlignedBB axisalignedbb8 = (AxisAlignedBB)iterator6.next();
                    p_70091_3_ = axisalignedbb8.func_72323_b(field_70121_D, p_70091_3_);
                }

                field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
            }
            if(d6 * d6 + d10 * d10 >= p_70091_1_ * p_70091_1_ + p_70091_5_ * p_70091_5_)
            {
                p_70091_1_ = d6;
                p_70091_3_ = d8;
                p_70091_5_ = d10;
                field_70121_D.func_72328_c(axisalignedbb4);
            } else
            {
                double d11 = field_70121_D.field_72338_b - (double)(int)field_70121_D.field_72338_b;
                if(d11 > 0.0D)
                {
                    field_70139_V += d11 + 0.01D;
                }
            }
        }
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("rest");
        field_70165_t = (field_70121_D.field_72340_a + field_70121_D.field_72336_d) / 2D;
        field_70163_u = (field_70121_D.field_72338_b + (double)field_70129_M) - (double)field_70139_V;
        field_70161_v = (field_70121_D.field_72339_c + field_70121_D.field_72334_f) / 2D;
        field_70123_F = d2 != p_70091_1_ || d4 != p_70091_5_;
        field_70124_G = d3 != p_70091_3_;
        field_70122_E = d3 != p_70091_3_ && d3 < 0.0D;
        field_70132_H = field_70123_F || field_70124_G;
        func_70064_a(p_70091_3_, field_70122_E);
        if(d2 != p_70091_1_)
        {
            field_70159_w = 0.0D;
        }
        if(d3 != p_70091_3_)
        {
            field_70181_x = 0.0D;
        }
        if(d4 != p_70091_5_)
        {
            field_70179_y = 0.0D;
        }
        double d7 = field_70165_t - d;
        double d9 = field_70161_v - d1;
        if(func_70041_e_() && !flag && field_70154_o == null)
        {
            field_70140_Q += (double)MathHelper.func_76133_a(d7 * d7 + d9 * d9) * 0.59999999999999998D;
            int i = MathHelper.func_76128_c(field_70165_t);
            int j = MathHelper.func_76128_c(field_70163_u - 0.20000000298023224D - (double)field_70129_M);
            int k = MathHelper.func_76128_c(field_70161_v);
            int l = field_70170_p.func_72798_a(i, j, k);
            if(l == 0 && field_70170_p.func_72798_a(i, j - 1, k) == Block.field_72031_aZ.field_71990_ca)
            {
                l = field_70170_p.func_72798_a(i, j - 1, k);
            }
            if(field_70140_Q > (float)field_70150_b && l > 0)
            {
                field_70150_b = (int)field_70140_Q + 1;
                func_70036_a(i, j, k, l);
                Block.field_71973_m[l].func_71891_b(field_70170_p, i, j, k, this);
            }
        }
        func_70017_D();
        boolean flag2 = func_70026_G();
        if(field_70170_p.func_72978_e(field_70121_D.func_72331_e(0.001D, 0.001D, 0.001D)))
        {
            func_70081_e(1);
            if(!flag2)
            {
                field_70151_c++;
                if(field_70151_c == 0)
                {
                    func_70015_d(8);
                }
            }
        } else
        if(field_70151_c <= 0)
        {
            field_70151_c = -field_70174_ab;
        }
        if(flag2 && field_70151_c > 0)
        {
            field_70170_p.func_72956_a(this, "random.fizz", 0.7F, 1.6F + (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.4F);
            field_70151_c = -field_70174_ab;
        }
        field_70170_p.field_72984_F.func_76319_b();
    }

    protected void func_70017_D()
    {
        int i = MathHelper.func_76128_c(field_70121_D.field_72340_a + 0.001D);
        int j = MathHelper.func_76128_c(field_70121_D.field_72338_b + 0.001D);
        int k = MathHelper.func_76128_c(field_70121_D.field_72339_c + 0.001D);
        int l = MathHelper.func_76128_c(field_70121_D.field_72336_d - 0.001D);
        int i1 = MathHelper.func_76128_c(field_70121_D.field_72337_e - 0.001D);
        int j1 = MathHelper.func_76128_c(field_70121_D.field_72334_f - 0.001D);
        if(field_70170_p.func_72904_c(i, j, k, l, i1, j1))
        {
            for(int k1 = i; k1 <= l; k1++)
            {
                for(int l1 = j; l1 <= i1; l1++)
                {
                    for(int i2 = k; i2 <= j1; i2++)
                    {
                        int j2 = field_70170_p.func_72798_a(k1, l1, i2);
                        if(j2 > 0)
                        {
                            Block.field_71973_m[j2].func_71869_a(field_70170_p, k1, l1, i2, this);
                        }
                    }

                }

            }

        }
    }

    protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_)
    {
        StepSound stepsound = Block.field_71973_m[p_70036_4_].field_72020_cn;
        if(field_70170_p.func_72798_a(p_70036_1_, p_70036_2_ + 1, p_70036_3_) == Block.field_72037_aS.field_71990_ca)
        {
            stepsound = Block.field_72037_aS.field_72020_cn;
            field_70170_p.func_72956_a(this, stepsound.func_72675_d(), stepsound.func_72677_b() * 0.15F, stepsound.func_72678_c());
        } else
        if(!Block.field_71973_m[p_70036_4_].field_72018_cp.func_76224_d())
        {
            field_70170_p.func_72956_a(this, stepsound.func_72675_d(), stepsound.func_72677_b() * 0.15F, stepsound.func_72678_c());
        }
    }

    protected boolean func_70041_e_()
    {
        return true;
    }

    protected void func_70064_a(double p_70064_1_, boolean p_70064_3_)
    {
        if(p_70064_3_)
        {
            if(field_70143_R > 0.0F)
            {
                if(this instanceof EntityLiving)
                {
                    int i = MathHelper.func_76128_c(field_70165_t);
                    int j = MathHelper.func_76128_c(field_70163_u - 0.20000000298023224D - (double)field_70129_M);
                    int k = MathHelper.func_76128_c(field_70161_v);
                    int l = field_70170_p.func_72798_a(i, j, k);
                    if(l == 0 && field_70170_p.func_72798_a(i, j - 1, k) == Block.field_72031_aZ.field_71990_ca)
                    {
                        l = field_70170_p.func_72798_a(i, j - 1, k);
                    }
                    if(l > 0)
                    {
                        Block.field_71973_m[l].func_71866_a(field_70170_p, i, j, k, this, field_70143_R);
                    }
                }
                func_70069_a(field_70143_R);
                field_70143_R = 0.0F;
            }
        } else
        if(p_70064_1_ < 0.0D)
        {
            field_70143_R -= p_70064_1_;
        }
    }

    public AxisAlignedBB func_70046_E()
    {
        return null;
    }

    protected void func_70081_e(int p_70081_1_)
    {
        if(!field_70178_ae)
        {
            func_70097_a(DamageSource.field_76372_a, p_70081_1_);
        }
    }

    public final boolean func_70045_F()
    {
        return field_70178_ae;
    }

    protected void func_70069_a(float p_70069_1_)
    {
        if(field_70153_n != null)
        {
            field_70153_n.func_70069_a(p_70069_1_);
        }
    }

    public boolean func_70026_G()
    {
        return field_70171_ac || field_70170_p.func_72951_B(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v));
    }

    public boolean func_70090_H()
    {
        return field_70171_ac;
    }

    public boolean func_70072_I()
    {
        return field_70170_p.func_72918_a(field_70121_D.func_72314_b(0.0D, -0.40000000596046448D, 0.0D).func_72331_e(0.001D, 0.001D, 0.001D), Material.field_76244_g, this);
    }

    public boolean func_70055_a(Material p_70055_1_)
    {
        double d = field_70163_u + (double)func_70047_e();
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76141_d(MathHelper.func_76128_c(d));
        int k = MathHelper.func_76128_c(field_70161_v);
        int l = field_70170_p.func_72798_a(i, j, k);
        if(l != 0 && Block.field_71973_m[l].field_72018_cp == p_70055_1_)
        {
            float f = BlockFluid.func_72199_d(field_70170_p.func_72805_g(i, j, k)) - 0.1111111F;
            float f1 = (float)(j + 1) - f;
            return d < (double)f1;
        } else
        {
            return false;
        }
    }

    public float func_70047_e()
    {
        return 0.0F;
    }

    public boolean func_70058_J()
    {
        return field_70170_p.func_72875_a(field_70121_D.func_72314_b(-0.10000000149011612D, -0.40000000596046448D, -0.10000000149011612D), Material.field_76256_h);
    }

    public void func_70060_a(float p_70060_1_, float p_70060_2_, float p_70060_3_)
    {
        float f = p_70060_1_ * p_70060_1_ + p_70060_2_ * p_70060_2_;
        if(f < 0.0001F)
        {
            return;
        }
        f = MathHelper.func_76129_c(f);
        if(f < 1.0F)
        {
            f = 1.0F;
        }
        f = p_70060_3_ / f;
        p_70060_1_ *= f;
        p_70060_2_ *= f;
        float f1 = MathHelper.func_76126_a((field_70177_z * 3.141593F) / 180F);
        float f2 = MathHelper.func_76134_b((field_70177_z * 3.141593F) / 180F);
        field_70159_w += p_70060_1_ * f2 - p_70060_2_ * f1;
        field_70179_y += p_70060_2_ * f2 + p_70060_1_ * f1;
    }

    public float func_70013_c(float p_70013_1_)
    {
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76128_c(field_70161_v);
        if(field_70170_p.func_72899_e(i, 0, j))
        {
            double d = (field_70121_D.field_72337_e - field_70121_D.field_72338_b) * 0.66000000000000003D;
            int k = MathHelper.func_76128_c((field_70163_u - (double)field_70129_M) + d);
            return field_70170_p.func_72801_o(i, k, j);
        } else
        {
            return 0.0F;
        }
    }

    public void func_70029_a(World p_70029_1_)
    {
        field_70170_p = p_70029_1_;
    }

    public void func_70080_a(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, 
            float p_70080_8_)
    {
        field_70169_q = field_70165_t = p_70080_1_;
        field_70167_r = field_70163_u = p_70080_3_;
        field_70166_s = field_70161_v = p_70080_5_;
        field_70126_B = field_70177_z = p_70080_7_;
        field_70127_C = field_70125_A = p_70080_8_;
        field_70139_V = 0.0F;
        double d = field_70126_B - p_70080_7_;
        if(d < -180D)
        {
            field_70126_B += 360F;
        }
        if(d >= 180D)
        {
            field_70126_B -= 360F;
        }
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        func_70101_b(p_70080_7_, p_70080_8_);
    }

    public void func_70012_b(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, 
            float p_70012_8_)
    {
        field_70142_S = field_70169_q = field_70165_t = p_70012_1_;
        field_70137_T = field_70167_r = field_70163_u = p_70012_3_ + (double)field_70129_M;
        field_70136_U = field_70166_s = field_70161_v = p_70012_5_;
        field_70177_z = p_70012_7_;
        field_70125_A = p_70012_8_;
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
    }

    public float func_70032_d(Entity p_70032_1_)
    {
        float f = (float)(field_70165_t - p_70032_1_.field_70165_t);
        float f1 = (float)(field_70163_u - p_70032_1_.field_70163_u);
        float f2 = (float)(field_70161_v - p_70032_1_.field_70161_v);
        return MathHelper.func_76129_c(f * f + f1 * f1 + f2 * f2);
    }

    public double func_70092_e(double p_70092_1_, double p_70092_3_, double p_70092_5_)
    {
        double d = field_70165_t - p_70092_1_;
        double d1 = field_70163_u - p_70092_3_;
        double d2 = field_70161_v - p_70092_5_;
        return d * d + d1 * d1 + d2 * d2;
    }

    public double func_70011_f(double p_70011_1_, double p_70011_3_, double p_70011_5_)
    {
        double d = field_70165_t - p_70011_1_;
        double d1 = field_70163_u - p_70011_3_;
        double d2 = field_70161_v - p_70011_5_;
        return (double)MathHelper.func_76133_a(d * d + d1 * d1 + d2 * d2);
    }

    public double func_70068_e(Entity p_70068_1_)
    {
        double d = field_70165_t - p_70068_1_.field_70165_t;
        double d1 = field_70163_u - p_70068_1_.field_70163_u;
        double d2 = field_70161_v - p_70068_1_.field_70161_v;
        return d * d + d1 * d1 + d2 * d2;
    }

    public void func_70100_b_(EntityPlayer entityplayer)
    {
    }

    public void func_70108_f(Entity p_70108_1_)
    {
        if(p_70108_1_.field_70153_n == this || p_70108_1_.field_70154_o == this)
        {
            return;
        }
        double d = p_70108_1_.field_70165_t - field_70165_t;
        double d1 = p_70108_1_.field_70161_v - field_70161_v;
        double d2 = MathHelper.func_76132_a(d, d1);
        if(d2 >= 0.0099999997764825821D)
        {
            d2 = MathHelper.func_76133_a(d2);
            d /= d2;
            d1 /= d2;
            double d3 = 1.0D / d2;
            if(d3 > 1.0D)
            {
                d3 = 1.0D;
            }
            d *= d3;
            d1 *= d3;
            d *= 0.05000000074505806D;
            d1 *= 0.05000000074505806D;
            d *= 1.0F - field_70144_Y;
            d1 *= 1.0F - field_70144_Y;
            func_70024_g(-d, 0.0D, -d1);
            p_70108_1_.func_70024_g(d, 0.0D, d1);
        }
    }

    public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_)
    {
        field_70159_w += p_70024_1_;
        field_70181_x += p_70024_3_;
        field_70179_y += p_70024_5_;
        field_70160_al = true;
    }

    protected void func_70018_K()
    {
        field_70133_I = true;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        func_70018_K();
        return false;
    }

    public boolean func_70067_L()
    {
        return false;
    }

    public boolean func_70104_M()
    {
        return false;
    }

    public void func_70084_c(Entity entity, int i)
    {
    }

    public boolean func_70039_c(NBTTagCompound p_70039_1_)
    {
        String s = func_70022_Q();
        if(field_70128_L || s == null)
        {
            return false;
        } else
        {
            p_70039_1_.func_74778_a("id", s);
            func_70109_d(p_70039_1_);
            return true;
        }
    }

    public void func_70109_d(NBTTagCompound p_70109_1_)
    {
        p_70109_1_.func_74782_a("Pos", func_70087_a(new double[] {
            field_70165_t, field_70163_u + (double)field_70139_V, field_70161_v
        }));
        p_70109_1_.func_74782_a("Motion", func_70087_a(new double[] {
            field_70159_w, field_70181_x, field_70179_y
        }));
        p_70109_1_.func_74782_a("Rotation", func_70049_a(new float[] {
            field_70177_z, field_70125_A
        }));
        p_70109_1_.func_74776_a("FallDistance", field_70143_R);
        p_70109_1_.func_74777_a("Fire", (short)field_70151_c);
        p_70109_1_.func_74777_a("Air", (short)func_70086_ai());
        p_70109_1_.func_74757_a("OnGround", field_70122_E);
        func_70014_b(p_70109_1_);
    }

    public void func_70020_e(NBTTagCompound p_70020_1_)
    {
        NBTTagList nbttaglist = p_70020_1_.func_74761_m("Pos");
        NBTTagList nbttaglist1 = p_70020_1_.func_74761_m("Motion");
        NBTTagList nbttaglist2 = p_70020_1_.func_74761_m("Rotation");
        field_70159_w = ((NBTTagDouble)nbttaglist1.func_74743_b(0)).field_74755_a;
        field_70181_x = ((NBTTagDouble)nbttaglist1.func_74743_b(1)).field_74755_a;
        field_70179_y = ((NBTTagDouble)nbttaglist1.func_74743_b(2)).field_74755_a;
        if(Math.abs(field_70159_w) > 10D)
        {
            field_70159_w = 0.0D;
        }
        if(Math.abs(field_70181_x) > 10D)
        {
            field_70181_x = 0.0D;
        }
        if(Math.abs(field_70179_y) > 10D)
        {
            field_70179_y = 0.0D;
        }
        field_70169_q = field_70142_S = field_70165_t = ((NBTTagDouble)nbttaglist.func_74743_b(0)).field_74755_a;
        field_70167_r = field_70137_T = field_70163_u = ((NBTTagDouble)nbttaglist.func_74743_b(1)).field_74755_a;
        field_70166_s = field_70136_U = field_70161_v = ((NBTTagDouble)nbttaglist.func_74743_b(2)).field_74755_a;
        field_70126_B = field_70177_z = ((NBTTagFloat)nbttaglist2.func_74743_b(0)).field_74750_a;
        field_70127_C = field_70125_A = ((NBTTagFloat)nbttaglist2.func_74743_b(1)).field_74750_a;
        field_70143_R = p_70020_1_.func_74760_g("FallDistance");
        field_70151_c = p_70020_1_.func_74765_d("Fire");
        func_70050_g(p_70020_1_.func_74765_d("Air"));
        field_70122_E = p_70020_1_.func_74767_n("OnGround");
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        func_70101_b(field_70177_z, field_70125_A);
        func_70037_a(p_70020_1_);
    }

    protected final String func_70022_Q()
    {
        return EntityList.func_75621_b(this);
    }

    protected abstract void func_70037_a(NBTTagCompound nbttagcompound);

    protected abstract void func_70014_b(NBTTagCompound nbttagcompound);

    protected NBTTagList func_70087_a(double p_70087_1_[])
    {
        NBTTagList nbttaglist = new NBTTagList();
        double ad[] = p_70087_1_;
        int i = ad.length;
        for(int j = 0; j < i; j++)
        {
            double d = ad[j];
            nbttaglist.func_74742_a(new NBTTagDouble(null, d));
        }

        return nbttaglist;
    }

    protected NBTTagList func_70049_a(float p_70049_1_[])
    {
        NBTTagList nbttaglist = new NBTTagList();
        float af[] = p_70049_1_;
        int i = af.length;
        for(int j = 0; j < i; j++)
        {
            float f = af[j];
            nbttaglist.func_74742_a(new NBTTagFloat(null, f));
        }

        return nbttaglist;
    }

    public EntityItem func_70025_b(int p_70025_1_, int p_70025_2_)
    {
        return func_70054_a(p_70025_1_, p_70025_2_, 0.0F);
    }

    public EntityItem func_70054_a(int p_70054_1_, int p_70054_2_, float p_70054_3_)
    {
        return func_70099_a(new ItemStack(p_70054_1_, p_70054_2_, 0), p_70054_3_);
    }

    public EntityItem func_70099_a(ItemStack p_70099_1_, float p_70099_2_)
    {
        EntityItem entityitem = new EntityItem(field_70170_p, field_70165_t, field_70163_u + (double)p_70099_2_, field_70161_v, p_70099_1_);
        entityitem.field_70293_c = 10;
        field_70170_p.func_72838_d(entityitem);
        return entityitem;
    }

    public boolean func_70089_S()
    {
        return !field_70128_L;
    }

    public boolean func_70094_T()
    {
        for(int i = 0; i < 8; i++)
        {
            float f = ((float)((i >> 0) % 2) - 0.5F) * field_70130_N * 0.8F;
            float f1 = ((float)((i >> 1) % 2) - 0.5F) * 0.1F;
            float f2 = ((float)((i >> 2) % 2) - 0.5F) * field_70130_N * 0.8F;
            int j = MathHelper.func_76128_c(field_70165_t + (double)f);
            int k = MathHelper.func_76128_c(field_70163_u + (double)func_70047_e() + (double)f1);
            int l = MathHelper.func_76128_c(field_70161_v + (double)f2);
            if(field_70170_p.func_72809_s(j, k, l))
            {
                return true;
            }
        }

        return false;
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        return false;
    }

    public AxisAlignedBB func_70114_g(Entity p_70114_1_)
    {
        return null;
    }

    public void func_70098_U()
    {
        if(field_70154_o.field_70128_L)
        {
            field_70154_o = null;
            return;
        }
        field_70159_w = 0.0D;
        field_70181_x = 0.0D;
        field_70179_y = 0.0D;
        func_70071_h_();
        if(field_70154_o == null)
        {
            return;
        }
        field_70154_o.func_70043_V();
        field_70147_f += field_70154_o.field_70177_z - field_70154_o.field_70126_B;
        field_70149_e += field_70154_o.field_70125_A - field_70154_o.field_70127_C;
        for(; field_70147_f >= 180D; field_70147_f -= 360D) { }
        for(; field_70147_f < -180D; field_70147_f += 360D) { }
        for(; field_70149_e >= 180D; field_70149_e -= 360D) { }
        for(; field_70149_e < -180D; field_70149_e += 360D) { }
        double d = field_70147_f * 0.5D;
        double d1 = field_70149_e * 0.5D;
        float f = 10F;
        if(d > (double)f)
        {
            d = f;
        }
        if(d < (double)(-f))
        {
            d = -f;
        }
        if(d1 > (double)f)
        {
            d1 = f;
        }
        if(d1 < (double)(-f))
        {
            d1 = -f;
        }
        field_70147_f -= d;
        field_70149_e -= d1;
        field_70177_z += d;
        field_70125_A += d1;
    }

    public void func_70043_V()
    {
        if(!(field_70153_n instanceof EntityPlayer) || !((EntityPlayer)field_70153_n).func_71066_bF())
        {
            field_70153_n.field_70142_S = field_70153_n.field_70165_t;
            field_70153_n.field_70137_T = field_70153_n.field_70163_u;
            field_70153_n.field_70136_U = field_70153_n.field_70161_v;
        }
        field_70153_n.func_70107_b(field_70165_t, field_70163_u + func_70042_X() + field_70153_n.func_70033_W(), field_70161_v);
    }

    public double func_70033_W()
    {
        return (double)field_70129_M;
    }

    public double func_70042_X()
    {
        return (double)field_70131_O * 0.75D;
    }

    public void func_70078_a(Entity p_70078_1_)
    {
        field_70149_e = 0.0D;
        field_70147_f = 0.0D;
        if(p_70078_1_ == null)
        {
            if(field_70154_o != null)
            {
                func_70012_b(field_70154_o.field_70165_t, field_70154_o.field_70121_D.field_72338_b + (double)field_70154_o.field_70131_O, field_70154_o.field_70161_v, field_70177_z, field_70125_A);
                field_70154_o.field_70153_n = null;
            }
            field_70154_o = null;
            return;
        }
        if(field_70154_o == p_70078_1_)
        {
            func_70061_h(p_70078_1_);
            field_70154_o.field_70153_n = null;
            field_70154_o = null;
            return;
        }
        if(field_70154_o != null)
        {
            field_70154_o.field_70153_n = null;
        }
        if(p_70078_1_.field_70153_n != null)
        {
            p_70078_1_.field_70153_n.field_70154_o = null;
        }
        field_70154_o = p_70078_1_;
        p_70078_1_.field_70153_n = this;
    }

    public void func_70061_h(Entity p_70061_1_)
    {
        double d = p_70061_1_.field_70165_t;
        double d1 = p_70061_1_.field_70121_D.field_72338_b + (double)p_70061_1_.field_70131_O;
        double d2 = p_70061_1_.field_70161_v;
        for(double d3 = -1.5D; d3 < 2D; d3 += 1.5D)
        {
            for(double d4 = -1.5D; d4 < 2D; d4 += 1.5D)
            {
                if(d3 == 0.0D && d4 == 0.0D)
                {
                    continue;
                }
                int i = (int)(field_70165_t + d3);
                int j = (int)(field_70161_v + d4);
                AxisAlignedBB axisalignedbb = field_70121_D.func_72325_c(d3, 1.0D, d4);
                if(!field_70170_p.func_72840_a(axisalignedbb).isEmpty())
                {
                    continue;
                }
                if(field_70170_p.func_72797_t(i, (int)field_70163_u, j))
                {
                    func_70012_b(field_70165_t + d3, field_70163_u + 1.0D, field_70161_v + d4, field_70177_z, field_70125_A);
                    return;
                }
                if(field_70170_p.func_72797_t(i, (int)field_70163_u - 1, j) || field_70170_p.func_72803_f(i, (int)field_70163_u - 1, j) == Material.field_76244_g)
                {
                    d = field_70165_t + d3;
                    d1 = field_70163_u + 1.0D;
                    d2 = field_70161_v + d4;
                }
            }

        }

        func_70012_b(d, d1, d2, field_70177_z, field_70125_A);
    }

    public float func_70111_Y()
    {
        return 0.1F;
    }

    public Vec3 func_70040_Z()
    {
        return null;
    }

    public void func_70063_aa()
    {
    }

    public ItemStack[] func_70035_c()
    {
        return null;
    }

    public boolean func_70027_ad()
    {
        return field_70151_c > 0 || func_70083_f(0);
    }

    public boolean func_70093_af()
    {
        return func_70083_f(1);
    }

    public void func_70095_a(boolean p_70095_1_)
    {
        func_70052_a(1, p_70095_1_);
    }

    public boolean func_70051_ag()
    {
        return func_70083_f(3);
    }

    public void func_70031_b(boolean p_70031_1_)
    {
        func_70052_a(3, p_70031_1_);
    }

    public void func_70019_c(boolean p_70019_1_)
    {
        func_70052_a(4, p_70019_1_);
    }

    protected boolean func_70083_f(int p_70083_1_)
    {
        return (field_70180_af.func_75683_a(0) & 1 << p_70083_1_) != 0;
    }

    protected void func_70052_a(int p_70052_1_, boolean p_70052_2_)
    {
        byte byte0 = field_70180_af.func_75683_a(0);
        if(p_70052_2_)
        {
            field_70180_af.func_75692_b(0, Byte.valueOf((byte)(byte0 | 1 << p_70052_1_)));
        } else
        {
            field_70180_af.func_75692_b(0, Byte.valueOf((byte)(byte0 & ~(1 << p_70052_1_))));
        }
    }

    public int func_70086_ai()
    {
        return field_70180_af.func_75693_b(1);
    }

    public void func_70050_g(int p_70050_1_)
    {
        field_70180_af.func_75692_b(1, Short.valueOf((short)p_70050_1_));
    }

    public void func_70077_a(EntityLightningBolt p_70077_1_)
    {
        func_70081_e(5);
        field_70151_c++;
        if(field_70151_c == 0)
        {
            func_70015_d(8);
        }
    }

    public void func_70074_a(EntityLiving entityliving)
    {
    }

    protected boolean func_70048_i(double p_70048_1_, double p_70048_3_, double p_70048_5_)
    {
        int i = MathHelper.func_76128_c(p_70048_1_);
        int j = MathHelper.func_76128_c(p_70048_3_);
        int k = MathHelper.func_76128_c(p_70048_5_);
        double d = p_70048_1_ - (double)i;
        double d1 = p_70048_3_ - (double)j;
        double d2 = p_70048_5_ - (double)k;
        if(field_70170_p.func_72809_s(i, j, k))
        {
            boolean flag = !field_70170_p.func_72809_s(i - 1, j, k);
            boolean flag1 = !field_70170_p.func_72809_s(i + 1, j, k);
            boolean flag2 = !field_70170_p.func_72809_s(i, j - 1, k);
            boolean flag3 = !field_70170_p.func_72809_s(i, j + 1, k);
            boolean flag4 = !field_70170_p.func_72809_s(i, j, k - 1);
            boolean flag5 = !field_70170_p.func_72809_s(i, j, k + 1);
            byte byte0 = -1;
            double d3 = 9999D;
            if(flag && d < d3)
            {
                d3 = d;
                byte0 = 0;
            }
            if(flag1 && 1.0D - d < d3)
            {
                d3 = 1.0D - d;
                byte0 = 1;
            }
            if(flag2 && d1 < d3)
            {
                d3 = d1;
                byte0 = 2;
            }
            if(flag3 && 1.0D - d1 < d3)
            {
                d3 = 1.0D - d1;
                byte0 = 3;
            }
            if(flag4 && d2 < d3)
            {
                d3 = d2;
                byte0 = 4;
            }
            if(flag5 && 1.0D - d2 < d3)
            {
                double d4 = 1.0D - d2;
                byte0 = 5;
            }
            float f = field_70146_Z.nextFloat() * 0.2F + 0.1F;
            if(byte0 == 0)
            {
                field_70159_w = -f;
            }
            if(byte0 == 1)
            {
                field_70159_w = f;
            }
            if(byte0 == 2)
            {
                field_70181_x = -f;
            }
            if(byte0 == 3)
            {
                field_70181_x = f;
            }
            if(byte0 == 4)
            {
                field_70179_y = -f;
            }
            if(byte0 == 5)
            {
                field_70179_y = f;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void func_70110_aj()
    {
        field_70134_J = true;
        field_70143_R = 0.0F;
    }

    public String func_70023_ak()
    {
        String s = EntityList.func_75621_b(this);
        if(s == null)
        {
            s = "generic";
        }
        return StatCollector.func_74838_a((new StringBuilder()).append("entity.").append(s).append(".name").toString());
    }

    public Entity[] func_70021_al()
    {
        return null;
    }

    public boolean func_70028_i(Entity p_70028_1_)
    {
        return this == p_70028_1_;
    }

    public float func_70079_am()
    {
        return 0.0F;
    }

    public boolean func_70075_an()
    {
        return true;
    }

    public String toString()
    {
        return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", new Object[] {
            getClass().getSimpleName(), func_70023_ak(), Integer.valueOf(field_70157_k), field_70170_p != null ? field_70170_p.func_72912_H().func_76065_j() : "~NULL~", Double.valueOf(field_70165_t), Double.valueOf(field_70163_u), Double.valueOf(field_70161_v)
        });
    }

}
