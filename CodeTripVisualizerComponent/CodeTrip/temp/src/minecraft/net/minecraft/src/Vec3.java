// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Vec3Pool, MathHelper, Vec3LocalPool

public class Vec3
{

    private static final ThreadLocal field_72447_d = new Vec3LocalPool();
    public double field_72450_a;
    public double field_72448_b;
    public double field_72449_c;

    public static Vec3 func_72443_a(double p_72443_0_, double p_72443_2_, double p_72443_4_)
    {
        return new Vec3(p_72443_0_, p_72443_2_, p_72443_4_);
    }

    public static Vec3Pool func_72437_a()
    {
        return (Vec3Pool)field_72447_d.get();
    }

    protected Vec3(double p_i4034_1_, double p_i4034_3_, double p_i4034_5_)
    {
        if(p_i4034_1_ == -0D)
        {
            p_i4034_1_ = 0.0D;
        }
        if(p_i4034_3_ == -0D)
        {
            p_i4034_3_ = 0.0D;
        }
        if(p_i4034_5_ == -0D)
        {
            p_i4034_5_ = 0.0D;
        }
        field_72450_a = p_i4034_1_;
        field_72448_b = p_i4034_3_;
        field_72449_c = p_i4034_5_;
    }

    protected Vec3 func_72439_b(double p_72439_1_, double p_72439_3_, double p_72439_5_)
    {
        field_72450_a = p_72439_1_;
        field_72448_b = p_72439_3_;
        field_72449_c = p_72439_5_;
        return this;
    }

    public Vec3 func_72444_a(Vec3 p_72444_1_)
    {
        return func_72437_a().func_72345_a(p_72444_1_.field_72450_a - field_72450_a, p_72444_1_.field_72448_b - field_72448_b, p_72444_1_.field_72449_c - field_72449_c);
    }

    public Vec3 func_72432_b()
    {
        double d = MathHelper.func_76133_a(field_72450_a * field_72450_a + field_72448_b * field_72448_b + field_72449_c * field_72449_c);
        if(d < 0.0001D)
        {
            return func_72437_a().func_72345_a(0.0D, 0.0D, 0.0D);
        } else
        {
            return func_72437_a().func_72345_a(field_72450_a / d, field_72448_b / d, field_72449_c / d);
        }
    }

    public double func_72430_b(Vec3 p_72430_1_)
    {
        return field_72450_a * p_72430_1_.field_72450_a + field_72448_b * p_72430_1_.field_72448_b + field_72449_c * p_72430_1_.field_72449_c;
    }

    public Vec3 func_72431_c(Vec3 p_72431_1_)
    {
        return func_72437_a().func_72345_a(field_72448_b * p_72431_1_.field_72449_c - field_72449_c * p_72431_1_.field_72448_b, field_72449_c * p_72431_1_.field_72450_a - field_72450_a * p_72431_1_.field_72449_c, field_72450_a * p_72431_1_.field_72448_b - field_72448_b * p_72431_1_.field_72450_a);
    }

    public Vec3 func_72441_c(double p_72441_1_, double p_72441_3_, double p_72441_5_)
    {
        return func_72437_a().func_72345_a(field_72450_a + p_72441_1_, field_72448_b + p_72441_3_, field_72449_c + p_72441_5_);
    }

    public double func_72438_d(Vec3 p_72438_1_)
    {
        double d = p_72438_1_.field_72450_a - field_72450_a;
        double d1 = p_72438_1_.field_72448_b - field_72448_b;
        double d2 = p_72438_1_.field_72449_c - field_72449_c;
        return (double)MathHelper.func_76133_a(d * d + d1 * d1 + d2 * d2);
    }

    public double func_72436_e(Vec3 p_72436_1_)
    {
        double d = p_72436_1_.field_72450_a - field_72450_a;
        double d1 = p_72436_1_.field_72448_b - field_72448_b;
        double d2 = p_72436_1_.field_72449_c - field_72449_c;
        return d * d + d1 * d1 + d2 * d2;
    }

    public double func_72445_d(double p_72445_1_, double p_72445_3_, double p_72445_5_)
    {
        double d = p_72445_1_ - field_72450_a;
        double d1 = p_72445_3_ - field_72448_b;
        double d2 = p_72445_5_ - field_72449_c;
        return d * d + d1 * d1 + d2 * d2;
    }

    public double func_72433_c()
    {
        return (double)MathHelper.func_76133_a(field_72450_a * field_72450_a + field_72448_b * field_72448_b + field_72449_c * field_72449_c);
    }

    public Vec3 func_72429_b(Vec3 p_72429_1_, double p_72429_2_)
    {
        double d = p_72429_1_.field_72450_a - field_72450_a;
        double d1 = p_72429_1_.field_72448_b - field_72448_b;
        double d2 = p_72429_1_.field_72449_c - field_72449_c;
        if(d * d < 1.0000000116860974E-007D)
        {
            return null;
        }
        double d3 = (p_72429_2_ - field_72450_a) / d;
        if(d3 < 0.0D || d3 > 1.0D)
        {
            return null;
        } else
        {
            return func_72437_a().func_72345_a(field_72450_a + d * d3, field_72448_b + d1 * d3, field_72449_c + d2 * d3);
        }
    }

    public Vec3 func_72435_c(Vec3 p_72435_1_, double p_72435_2_)
    {
        double d = p_72435_1_.field_72450_a - field_72450_a;
        double d1 = p_72435_1_.field_72448_b - field_72448_b;
        double d2 = p_72435_1_.field_72449_c - field_72449_c;
        if(d1 * d1 < 1.0000000116860974E-007D)
        {
            return null;
        }
        double d3 = (p_72435_2_ - field_72448_b) / d1;
        if(d3 < 0.0D || d3 > 1.0D)
        {
            return null;
        } else
        {
            return func_72437_a().func_72345_a(field_72450_a + d * d3, field_72448_b + d1 * d3, field_72449_c + d2 * d3);
        }
    }

    public Vec3 func_72434_d(Vec3 p_72434_1_, double p_72434_2_)
    {
        double d = p_72434_1_.field_72450_a - field_72450_a;
        double d1 = p_72434_1_.field_72448_b - field_72448_b;
        double d2 = p_72434_1_.field_72449_c - field_72449_c;
        if(d2 * d2 < 1.0000000116860974E-007D)
        {
            return null;
        }
        double d3 = (p_72434_2_ - field_72449_c) / d2;
        if(d3 < 0.0D || d3 > 1.0D)
        {
            return null;
        } else
        {
            return func_72437_a().func_72345_a(field_72450_a + d * d3, field_72448_b + d1 * d3, field_72449_c + d2 * d3);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("(").append(field_72450_a).append(", ").append(field_72448_b).append(", ").append(field_72449_c).append(")").toString();
    }

    public void func_72440_a(float p_72440_1_)
    {
        float f = MathHelper.func_76134_b(p_72440_1_);
        float f1 = MathHelper.func_76126_a(p_72440_1_);
        double d = field_72450_a;
        double d1 = field_72448_b * (double)f + field_72449_c * (double)f1;
        double d2 = field_72449_c * (double)f - field_72448_b * (double)f1;
        field_72450_a = d;
        field_72448_b = d1;
        field_72449_c = d2;
    }

    public void func_72442_b(float p_72442_1_)
    {
        float f = MathHelper.func_76134_b(p_72442_1_);
        float f1 = MathHelper.func_76126_a(p_72442_1_);
        double d = field_72450_a * (double)f + field_72449_c * (double)f1;
        double d1 = field_72448_b;
        double d2 = field_72449_c * (double)f - field_72450_a * (double)f1;
        field_72450_a = d;
        field_72448_b = d1;
        field_72449_c = d2;
    }

    public void func_72446_c(float p_72446_1_)
    {
        float f = MathHelper.func_76134_b(p_72446_1_);
        float f1 = MathHelper.func_76126_a(p_72446_1_);
        double d = field_72450_a * (double)f + field_72448_b * (double)f1;
        double d1 = field_72448_b * (double)f - field_72450_a * (double)f1;
        double d2 = field_72449_c;
        field_72450_a = d;
        field_72448_b = d1;
        field_72449_c = d2;
    }

}
