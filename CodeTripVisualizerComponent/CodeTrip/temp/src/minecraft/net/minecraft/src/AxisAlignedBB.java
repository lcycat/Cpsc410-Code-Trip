// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            AABBPool, Vec3, MovingObjectPosition, AABBLocalPool

public class AxisAlignedBB
{

    private static final ThreadLocal field_72335_g = new AABBLocalPool();
    public double field_72340_a;
    public double field_72338_b;
    public double field_72339_c;
    public double field_72336_d;
    public double field_72337_e;
    public double field_72334_f;

    public static AxisAlignedBB func_72330_a(double p_72330_0_, double p_72330_2_, double p_72330_4_, double p_72330_6_, 
            double p_72330_8_, double p_72330_10_)
    {
        return new AxisAlignedBB(p_72330_0_, p_72330_2_, p_72330_4_, p_72330_6_, p_72330_8_, p_72330_10_);
    }

    public static AABBPool func_72332_a()
    {
        return (AABBPool)field_72335_g.get();
    }

    protected AxisAlignedBB(double p_i4029_1_, double p_i4029_3_, double p_i4029_5_, double p_i4029_7_, double p_i4029_9_, double p_i4029_11_)
    {
        field_72340_a = p_i4029_1_;
        field_72338_b = p_i4029_3_;
        field_72339_c = p_i4029_5_;
        field_72336_d = p_i4029_7_;
        field_72337_e = p_i4029_9_;
        field_72334_f = p_i4029_11_;
    }

    public AxisAlignedBB func_72324_b(double p_72324_1_, double p_72324_3_, double p_72324_5_, double p_72324_7_, double p_72324_9_, double p_72324_11_)
    {
        field_72340_a = p_72324_1_;
        field_72338_b = p_72324_3_;
        field_72339_c = p_72324_5_;
        field_72336_d = p_72324_7_;
        field_72337_e = p_72324_9_;
        field_72334_f = p_72324_11_;
        return this;
    }

    public AxisAlignedBB func_72321_a(double p_72321_1_, double p_72321_3_, double p_72321_5_)
    {
        double d = field_72340_a;
        double d1 = field_72338_b;
        double d2 = field_72339_c;
        double d3 = field_72336_d;
        double d4 = field_72337_e;
        double d5 = field_72334_f;
        if(p_72321_1_ < 0.0D)
        {
            d += p_72321_1_;
        }
        if(p_72321_1_ > 0.0D)
        {
            d3 += p_72321_1_;
        }
        if(p_72321_3_ < 0.0D)
        {
            d1 += p_72321_3_;
        }
        if(p_72321_3_ > 0.0D)
        {
            d4 += p_72321_3_;
        }
        if(p_72321_5_ < 0.0D)
        {
            d2 += p_72321_5_;
        }
        if(p_72321_5_ > 0.0D)
        {
            d5 += p_72321_5_;
        }
        return func_72332_a().func_72299_a(d, d1, d2, d3, d4, d5);
    }

    public AxisAlignedBB func_72314_b(double p_72314_1_, double p_72314_3_, double p_72314_5_)
    {
        double d = field_72340_a - p_72314_1_;
        double d1 = field_72338_b - p_72314_3_;
        double d2 = field_72339_c - p_72314_5_;
        double d3 = field_72336_d + p_72314_1_;
        double d4 = field_72337_e + p_72314_3_;
        double d5 = field_72334_f + p_72314_5_;
        return func_72332_a().func_72299_a(d, d1, d2, d3, d4, d5);
    }

    public AxisAlignedBB func_72325_c(double p_72325_1_, double p_72325_3_, double p_72325_5_)
    {
        return func_72332_a().func_72299_a(field_72340_a + p_72325_1_, field_72338_b + p_72325_3_, field_72339_c + p_72325_5_, field_72336_d + p_72325_1_, field_72337_e + p_72325_3_, field_72334_f + p_72325_5_);
    }

    public double func_72316_a(AxisAlignedBB p_72316_1_, double p_72316_2_)
    {
        if(p_72316_1_.field_72337_e <= field_72338_b || p_72316_1_.field_72338_b >= field_72337_e)
        {
            return p_72316_2_;
        }
        if(p_72316_1_.field_72334_f <= field_72339_c || p_72316_1_.field_72339_c >= field_72334_f)
        {
            return p_72316_2_;
        }
        if(p_72316_2_ > 0.0D && p_72316_1_.field_72336_d <= field_72340_a)
        {
            double d = field_72340_a - p_72316_1_.field_72336_d;
            if(d < p_72316_2_)
            {
                p_72316_2_ = d;
            }
        }
        if(p_72316_2_ < 0.0D && p_72316_1_.field_72340_a >= field_72336_d)
        {
            double d1 = field_72336_d - p_72316_1_.field_72340_a;
            if(d1 > p_72316_2_)
            {
                p_72316_2_ = d1;
            }
        }
        return p_72316_2_;
    }

    public double func_72323_b(AxisAlignedBB p_72323_1_, double p_72323_2_)
    {
        if(p_72323_1_.field_72336_d <= field_72340_a || p_72323_1_.field_72340_a >= field_72336_d)
        {
            return p_72323_2_;
        }
        if(p_72323_1_.field_72334_f <= field_72339_c || p_72323_1_.field_72339_c >= field_72334_f)
        {
            return p_72323_2_;
        }
        if(p_72323_2_ > 0.0D && p_72323_1_.field_72337_e <= field_72338_b)
        {
            double d = field_72338_b - p_72323_1_.field_72337_e;
            if(d < p_72323_2_)
            {
                p_72323_2_ = d;
            }
        }
        if(p_72323_2_ < 0.0D && p_72323_1_.field_72338_b >= field_72337_e)
        {
            double d1 = field_72337_e - p_72323_1_.field_72338_b;
            if(d1 > p_72323_2_)
            {
                p_72323_2_ = d1;
            }
        }
        return p_72323_2_;
    }

    public double func_72322_c(AxisAlignedBB p_72322_1_, double p_72322_2_)
    {
        if(p_72322_1_.field_72336_d <= field_72340_a || p_72322_1_.field_72340_a >= field_72336_d)
        {
            return p_72322_2_;
        }
        if(p_72322_1_.field_72337_e <= field_72338_b || p_72322_1_.field_72338_b >= field_72337_e)
        {
            return p_72322_2_;
        }
        if(p_72322_2_ > 0.0D && p_72322_1_.field_72334_f <= field_72339_c)
        {
            double d = field_72339_c - p_72322_1_.field_72334_f;
            if(d < p_72322_2_)
            {
                p_72322_2_ = d;
            }
        }
        if(p_72322_2_ < 0.0D && p_72322_1_.field_72339_c >= field_72334_f)
        {
            double d1 = field_72334_f - p_72322_1_.field_72339_c;
            if(d1 > p_72322_2_)
            {
                p_72322_2_ = d1;
            }
        }
        return p_72322_2_;
    }

    public boolean func_72326_a(AxisAlignedBB p_72326_1_)
    {
        if(p_72326_1_.field_72336_d <= field_72340_a || p_72326_1_.field_72340_a >= field_72336_d)
        {
            return false;
        }
        if(p_72326_1_.field_72337_e <= field_72338_b || p_72326_1_.field_72338_b >= field_72337_e)
        {
            return false;
        }
        return p_72326_1_.field_72334_f > field_72339_c && p_72326_1_.field_72339_c < field_72334_f;
    }

    public AxisAlignedBB func_72317_d(double p_72317_1_, double p_72317_3_, double p_72317_5_)
    {
        field_72340_a += p_72317_1_;
        field_72338_b += p_72317_3_;
        field_72339_c += p_72317_5_;
        field_72336_d += p_72317_1_;
        field_72337_e += p_72317_3_;
        field_72334_f += p_72317_5_;
        return this;
    }

    public boolean func_72318_a(Vec3 p_72318_1_)
    {
        if(p_72318_1_.field_72450_a <= field_72340_a || p_72318_1_.field_72450_a >= field_72336_d)
        {
            return false;
        }
        if(p_72318_1_.field_72448_b <= field_72338_b || p_72318_1_.field_72448_b >= field_72337_e)
        {
            return false;
        }
        return p_72318_1_.field_72449_c > field_72339_c && p_72318_1_.field_72449_c < field_72334_f;
    }

    public double func_72320_b()
    {
        double d = field_72336_d - field_72340_a;
        double d1 = field_72337_e - field_72338_b;
        double d2 = field_72334_f - field_72339_c;
        return (d + d1 + d2) / 3D;
    }

    public AxisAlignedBB func_72331_e(double p_72331_1_, double p_72331_3_, double p_72331_5_)
    {
        double d = field_72340_a + p_72331_1_;
        double d1 = field_72338_b + p_72331_3_;
        double d2 = field_72339_c + p_72331_5_;
        double d3 = field_72336_d - p_72331_1_;
        double d4 = field_72337_e - p_72331_3_;
        double d5 = field_72334_f - p_72331_5_;
        return func_72332_a().func_72299_a(d, d1, d2, d3, d4, d5);
    }

    public AxisAlignedBB func_72329_c()
    {
        return func_72332_a().func_72299_a(field_72340_a, field_72338_b, field_72339_c, field_72336_d, field_72337_e, field_72334_f);
    }

    public MovingObjectPosition func_72327_a(Vec3 p_72327_1_, Vec3 p_72327_2_)
    {
        Vec3 vec3 = p_72327_1_.func_72429_b(p_72327_2_, field_72340_a);
        Vec3 vec3_1 = p_72327_1_.func_72429_b(p_72327_2_, field_72336_d);
        Vec3 vec3_2 = p_72327_1_.func_72435_c(p_72327_2_, field_72338_b);
        Vec3 vec3_3 = p_72327_1_.func_72435_c(p_72327_2_, field_72337_e);
        Vec3 vec3_4 = p_72327_1_.func_72434_d(p_72327_2_, field_72339_c);
        Vec3 vec3_5 = p_72327_1_.func_72434_d(p_72327_2_, field_72334_f);
        if(!func_72333_b(vec3))
        {
            vec3 = null;
        }
        if(!func_72333_b(vec3_1))
        {
            vec3_1 = null;
        }
        if(!func_72315_c(vec3_2))
        {
            vec3_2 = null;
        }
        if(!func_72315_c(vec3_3))
        {
            vec3_3 = null;
        }
        if(!func_72319_d(vec3_4))
        {
            vec3_4 = null;
        }
        if(!func_72319_d(vec3_5))
        {
            vec3_5 = null;
        }
        Vec3 vec3_6 = null;
        if(vec3 != null && (vec3_6 == null || p_72327_1_.func_72436_e(vec3) < p_72327_1_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3;
        }
        if(vec3_1 != null && (vec3_6 == null || p_72327_1_.func_72436_e(vec3_1) < p_72327_1_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_1;
        }
        if(vec3_2 != null && (vec3_6 == null || p_72327_1_.func_72436_e(vec3_2) < p_72327_1_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_2;
        }
        if(vec3_3 != null && (vec3_6 == null || p_72327_1_.func_72436_e(vec3_3) < p_72327_1_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_3;
        }
        if(vec3_4 != null && (vec3_6 == null || p_72327_1_.func_72436_e(vec3_4) < p_72327_1_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_4;
        }
        if(vec3_5 != null && (vec3_6 == null || p_72327_1_.func_72436_e(vec3_5) < p_72327_1_.func_72436_e(vec3_6)))
        {
            vec3_6 = vec3_5;
        }
        if(vec3_6 == null)
        {
            return null;
        }
        byte byte0 = -1;
        if(vec3_6 == vec3)
        {
            byte0 = 4;
        }
        if(vec3_6 == vec3_1)
        {
            byte0 = 5;
        }
        if(vec3_6 == vec3_2)
        {
            byte0 = 0;
        }
        if(vec3_6 == vec3_3)
        {
            byte0 = 1;
        }
        if(vec3_6 == vec3_4)
        {
            byte0 = 2;
        }
        if(vec3_6 == vec3_5)
        {
            byte0 = 3;
        }
        return new MovingObjectPosition(0, 0, 0, byte0, vec3_6);
    }

    private boolean func_72333_b(Vec3 p_72333_1_)
    {
        if(p_72333_1_ == null)
        {
            return false;
        } else
        {
            return p_72333_1_.field_72448_b >= field_72338_b && p_72333_1_.field_72448_b <= field_72337_e && p_72333_1_.field_72449_c >= field_72339_c && p_72333_1_.field_72449_c <= field_72334_f;
        }
    }

    private boolean func_72315_c(Vec3 p_72315_1_)
    {
        if(p_72315_1_ == null)
        {
            return false;
        } else
        {
            return p_72315_1_.field_72450_a >= field_72340_a && p_72315_1_.field_72450_a <= field_72336_d && p_72315_1_.field_72449_c >= field_72339_c && p_72315_1_.field_72449_c <= field_72334_f;
        }
    }

    private boolean func_72319_d(Vec3 p_72319_1_)
    {
        if(p_72319_1_ == null)
        {
            return false;
        } else
        {
            return p_72319_1_.field_72450_a >= field_72340_a && p_72319_1_.field_72450_a <= field_72336_d && p_72319_1_.field_72448_b >= field_72338_b && p_72319_1_.field_72448_b <= field_72337_e;
        }
    }

    public void func_72328_c(AxisAlignedBB p_72328_1_)
    {
        field_72340_a = p_72328_1_.field_72340_a;
        field_72338_b = p_72328_1_.field_72338_b;
        field_72339_c = p_72328_1_.field_72339_c;
        field_72336_d = p_72328_1_.field_72336_d;
        field_72337_e = p_72328_1_.field_72337_e;
        field_72334_f = p_72328_1_.field_72334_f;
    }

    public String toString()
    {
        return (new StringBuilder()).append("box[").append(field_72340_a).append(", ").append(field_72338_b).append(", ").append(field_72339_c).append(" -> ").append(field_72336_d).append(", ").append(field_72337_e).append(", ").append(field_72334_f).append("]").toString();
    }

}
