// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, DataWatcher, World, DamageSource, 
//            EntityPlayer, PlayerCapabilities, Item, AxisAlignedBB, 
//            AABBPool, Material, MathHelper, Block, 
//            NBTTagCompound

public class EntityBoat extends Entity
{

    private boolean field_70279_a;
    private double field_70276_b;
    private int field_70277_c;
    private double field_70274_d;
    private double field_70275_e;
    private double field_70272_f;
    private double field_70273_g;
    private double field_70281_h;
    private double field_70282_i;
    private double field_70280_j;
    private double field_70278_an;

    public EntityBoat(World p_i3534_1_)
    {
        super(p_i3534_1_);
        field_70279_a = true;
        field_70276_b = 0.070000000000000007D;
        field_70156_m = true;
        func_70105_a(1.5F, 0.6F);
        field_70129_M = field_70131_O / 2.0F;
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    protected void func_70088_a()
    {
        field_70180_af.func_75682_a(17, new Integer(0));
        field_70180_af.func_75682_a(18, new Integer(1));
        field_70180_af.func_75682_a(19, new Integer(0));
    }

    public AxisAlignedBB func_70114_g(Entity p_70114_1_)
    {
        return p_70114_1_.field_70121_D;
    }

    public AxisAlignedBB func_70046_E()
    {
        return field_70121_D;
    }

    public boolean func_70104_M()
    {
        return true;
    }

    public EntityBoat(World p_i3535_1_, double p_i3535_2_, double p_i3535_4_, double p_i3535_6_)
    {
        this(p_i3535_1_);
        func_70107_b(p_i3535_2_, p_i3535_4_ + (double)field_70129_M, p_i3535_6_);
        field_70159_w = 0.0D;
        field_70181_x = 0.0D;
        field_70179_y = 0.0D;
        field_70169_q = p_i3535_2_;
        field_70167_r = p_i3535_4_;
        field_70166_s = p_i3535_6_;
    }

    public double func_70042_X()
    {
        return (double)field_70131_O * 0.0D - 0.30000001192092896D;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(field_70170_p.field_72995_K || field_70128_L)
        {
            return true;
        }
        func_70269_c(-func_70267_i());
        func_70265_b(10);
        func_70266_a(func_70271_g() + p_70097_2_ * 10);
        func_70018_K();
        if((p_70097_1_.func_76346_g() instanceof EntityPlayer) && ((EntityPlayer)p_70097_1_.func_76346_g()).field_71075_bZ.field_75098_d)
        {
            func_70266_a(100);
        }
        if(func_70271_g() > 40)
        {
            if(field_70153_n != null)
            {
                field_70153_n.func_70078_a(this);
            }
            func_70054_a(Item.field_77769_aE.field_77779_bT, 1, 0.0F);
            func_70106_y();
        }
        return true;
    }

    public void func_70057_ab()
    {
        func_70269_c(-func_70267_i());
        func_70265_b(10);
        func_70266_a(func_70271_g() * 11);
    }

    public boolean func_70067_L()
    {
        return !field_70128_L;
    }

    public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, 
            float p_70056_8_, int p_70056_9_)
    {
        if(field_70279_a)
        {
            field_70277_c = p_70056_9_ + 5;
        } else
        {
            double d = p_70056_1_ - field_70165_t;
            double d1 = p_70056_3_ - field_70163_u;
            double d2 = p_70056_5_ - field_70161_v;
            double d3 = d * d + d1 * d1 + d2 * d2;
            if(d3 > 1.0D)
            {
                field_70277_c = 3;
            } else
            {
                return;
            }
        }
        field_70274_d = p_70056_1_;
        field_70275_e = p_70056_3_;
        field_70272_f = p_70056_5_;
        field_70273_g = p_70056_7_;
        field_70281_h = p_70056_8_;
        field_70159_w = field_70282_i;
        field_70181_x = field_70280_j;
        field_70179_y = field_70278_an;
    }

    public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_)
    {
        field_70282_i = field_70159_w = p_70016_1_;
        field_70280_j = field_70181_x = p_70016_3_;
        field_70278_an = field_70179_y = p_70016_5_;
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(func_70268_h() > 0)
        {
            func_70265_b(func_70268_h() - 1);
        }
        if(func_70271_g() > 0)
        {
            func_70266_a(func_70271_g() - 1);
        }
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        int i = 5;
        double d = 0.0D;
        for(int j = 0; j < i; j++)
        {
            double d2 = (field_70121_D.field_72338_b + ((field_70121_D.field_72337_e - field_70121_D.field_72338_b) * (double)(j + 0)) / (double)i) - 0.125D;
            double d8 = (field_70121_D.field_72338_b + ((field_70121_D.field_72337_e - field_70121_D.field_72338_b) * (double)(j + 1)) / (double)i) - 0.125D;
            AxisAlignedBB axisalignedbb = AxisAlignedBB.func_72332_a().func_72299_a(field_70121_D.field_72340_a, d2, field_70121_D.field_72339_c, field_70121_D.field_72336_d, d8, field_70121_D.field_72334_f);
            if(field_70170_p.func_72830_b(axisalignedbb, Material.field_76244_g))
            {
                d += 1.0D / (double)i;
            }
        }

        double d1 = Math.sqrt(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
        if(d1 > 0.26249999999999996D)
        {
            double d3 = Math.cos(((double)field_70177_z * 3.1415926535897931D) / 180D);
            double d9 = Math.sin(((double)field_70177_z * 3.1415926535897931D) / 180D);
            for(int i1 = 0; (double)i1 < 1.0D + d1 * 60D; i1++)
            {
                double d17 = field_70146_Z.nextFloat() * 2.0F - 1.0F;
                double d20 = (double)(field_70146_Z.nextInt(2) * 2 - 1) * 0.69999999999999996D;
                if(field_70146_Z.nextBoolean())
                {
                    double d22 = (field_70165_t - d3 * d17 * 0.80000000000000004D) + d9 * d20;
                    double d24 = field_70161_v - d9 * d17 * 0.80000000000000004D - d3 * d20;
                    field_70170_p.func_72869_a("splash", d22, field_70163_u - 0.125D, d24, field_70159_w, field_70181_x, field_70179_y);
                } else
                {
                    double d23 = field_70165_t + d3 + d9 * d17 * 0.69999999999999996D;
                    double d25 = (field_70161_v + d9) - d3 * d17 * 0.69999999999999996D;
                    field_70170_p.func_72869_a("splash", d23, field_70163_u - 0.125D, d25, field_70159_w, field_70181_x, field_70179_y);
                }
            }

        }
        if(field_70170_p.field_72995_K && field_70279_a)
        {
            if(field_70277_c > 0)
            {
                double d4 = field_70165_t + (field_70274_d - field_70165_t) / (double)field_70277_c;
                double d10 = field_70163_u + (field_70275_e - field_70163_u) / (double)field_70277_c;
                double d14 = field_70161_v + (field_70272_f - field_70161_v) / (double)field_70277_c;
                double d18 = MathHelper.func_76138_g(field_70273_g - (double)field_70177_z);
                field_70177_z += d18 / (double)field_70277_c;
                field_70125_A += (field_70281_h - (double)field_70125_A) / (double)field_70277_c;
                field_70277_c--;
                func_70107_b(d4, d10, d14);
                func_70101_b(field_70177_z, field_70125_A);
            } else
            {
                double d5 = field_70165_t + field_70159_w;
                double d11 = field_70163_u + field_70181_x;
                double d15 = field_70161_v + field_70179_y;
                func_70107_b(d5, d11, d15);
                if(field_70122_E)
                {
                    field_70159_w *= 0.5D;
                    field_70181_x *= 0.5D;
                    field_70179_y *= 0.5D;
                }
                field_70159_w *= 0.99000000953674316D;
                field_70181_x *= 0.94999998807907104D;
                field_70179_y *= 0.99000000953674316D;
            }
            return;
        }
        if(d < 1.0D)
        {
            double d6 = d * 2D - 1.0D;
            field_70181_x += 0.039999999105930328D * d6;
        } else
        {
            if(field_70181_x < 0.0D)
            {
                field_70181_x /= 2D;
            }
            field_70181_x += 0.0070000002160668373D;
        }
        if(field_70153_n != null)
        {
            field_70159_w += field_70153_n.field_70159_w * field_70276_b;
            field_70179_y += field_70153_n.field_70179_y * field_70276_b;
        }
        double d7 = Math.sqrt(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
        if(d7 > 0.34999999999999998D)
        {
            double d12 = 0.34999999999999998D / d7;
            field_70159_w *= d12;
            field_70179_y *= d12;
            d7 = 0.34999999999999998D;
        }
        if(d7 > d1 && field_70276_b < 0.34999999999999998D)
        {
            field_70276_b += (0.34999999999999998D - field_70276_b) / 35D;
            if(field_70276_b > 0.34999999999999998D)
            {
                field_70276_b = 0.34999999999999998D;
            }
        } else
        {
            field_70276_b -= (field_70276_b - 0.070000000000000007D) / 35D;
            if(field_70276_b < 0.070000000000000007D)
            {
                field_70276_b = 0.070000000000000007D;
            }
        }
        if(field_70122_E)
        {
            field_70159_w *= 0.5D;
            field_70181_x *= 0.5D;
            field_70179_y *= 0.5D;
        }
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        if(field_70123_F && d1 > 0.20000000000000001D)
        {
            if(!field_70170_p.field_72995_K)
            {
                func_70106_y();
                for(int k = 0; k < 3; k++)
                {
                    func_70054_a(Block.field_71988_x.field_71990_ca, 1, 0.0F);
                }

                for(int l = 0; l < 2; l++)
                {
                    func_70054_a(Item.field_77669_D.field_77779_bT, 1, 0.0F);
                }

            }
        } else
        {
            field_70159_w *= 0.99000000953674316D;
            field_70181_x *= 0.94999998807907104D;
            field_70179_y *= 0.99000000953674316D;
        }
        field_70125_A = 0.0F;
        double d13 = field_70177_z;
        double d16 = field_70169_q - field_70165_t;
        double d19 = field_70166_s - field_70161_v;
        if(d16 * d16 + d19 * d19 > 0.001D)
        {
            d13 = (float)((Math.atan2(d19, d16) * 180D) / 3.1415926535897931D);
        }
        double d21 = MathHelper.func_76138_g(d13 - (double)field_70177_z);
        if(d21 > 20D)
        {
            d21 = 20D;
        }
        if(d21 < -20D)
        {
            d21 = -20D;
        }
        field_70177_z += d21;
        func_70101_b(field_70177_z, field_70125_A);
        if(field_70170_p.field_72995_K)
        {
            return;
        }
        List list = field_70170_p.func_72839_b(this, field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if(list != null && !list.isEmpty())
        {
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                Entity entity = (Entity)iterator.next();
                if(entity != field_70153_n && entity.func_70104_M() && (entity instanceof EntityBoat))
                {
                    entity.func_70108_f(this);
                }
            } while(true);
        }
        for(int j1 = 0; j1 < 4; j1++)
        {
            int k1 = MathHelper.func_76128_c(field_70165_t + ((double)(j1 % 2) - 0.5D) * 0.80000000000000004D);
            int l1 = MathHelper.func_76128_c(field_70161_v + ((double)(j1 / 2) - 0.5D) * 0.80000000000000004D);
            for(int i2 = 0; i2 < 2; i2++)
            {
                int j2 = MathHelper.func_76128_c(field_70163_u) + i2;
                int k2 = field_70170_p.func_72798_a(k1, j2, l1);
                int l2 = field_70170_p.func_72805_g(k1, j2, l1);
                if(k2 == Block.field_72037_aS.field_71990_ca)
                {
                    field_70170_p.func_72859_e(k1, j2, l1, 0);
                    continue;
                }
                if(k2 == Block.field_71991_bz.field_71990_ca)
                {
                    Block.field_71991_bz.func_71914_a(field_70170_p, k1, j2, l1, l2, 0.3F, 0);
                    field_70170_p.func_72859_e(k1, j2, l1, 0);
                }
            }

        }

        if(field_70153_n != null && field_70153_n.field_70128_L)
        {
            field_70153_n = null;
        }
    }

    public void func_70043_V()
    {
        if(field_70153_n == null)
        {
            return;
        } else
        {
            double d = Math.cos(((double)field_70177_z * 3.1415926535897931D) / 180D) * 0.40000000000000002D;
            double d1 = Math.sin(((double)field_70177_z * 3.1415926535897931D) / 180D) * 0.40000000000000002D;
            field_70153_n.func_70107_b(field_70165_t + d, field_70163_u + func_70042_X() + field_70153_n.func_70033_W(), field_70161_v + d1);
            return;
        }
    }

    protected void func_70014_b(NBTTagCompound nbttagcompound)
    {
    }

    protected void func_70037_a(NBTTagCompound nbttagcompound)
    {
    }

    public float func_70053_R()
    {
        return 0.0F;
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        if(field_70153_n != null && (field_70153_n instanceof EntityPlayer) && field_70153_n != p_70085_1_)
        {
            return true;
        }
        if(!field_70170_p.field_72995_K)
        {
            p_70085_1_.func_70078_a(this);
        }
        return true;
    }

    public void func_70266_a(int p_70266_1_)
    {
        field_70180_af.func_75692_b(19, Integer.valueOf(p_70266_1_));
    }

    public int func_70271_g()
    {
        return field_70180_af.func_75679_c(19);
    }

    public void func_70265_b(int p_70265_1_)
    {
        field_70180_af.func_75692_b(17, Integer.valueOf(p_70265_1_));
    }

    public int func_70268_h()
    {
        return field_70180_af.func_75679_c(17);
    }

    public void func_70269_c(int p_70269_1_)
    {
        field_70180_af.func_75692_b(18, Integer.valueOf(p_70269_1_));
    }

    public int func_70267_i()
    {
        return field_70180_af.func_75679_c(18);
    }

    public void func_70270_d(boolean p_70270_1_)
    {
        field_70279_a = p_70270_1_;
    }
}
