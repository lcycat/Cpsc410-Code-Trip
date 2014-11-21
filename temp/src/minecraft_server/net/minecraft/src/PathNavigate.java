// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Vec3, MathHelper, World, PathEntity, 
//            EntityLiving, EntityMoveHelper, PathPoint, Vec3Pool, 
//            AxisAlignedBB, Block, Material

public class PathNavigate
{

    private EntityLiving field_75515_a;
    private World field_75513_b;
    private PathEntity field_75514_c;
    private float field_75511_d;
    private float field_75512_e;
    private boolean field_75509_f;
    private int field_75510_g;
    private int field_75520_h;
    private Vec3 field_75521_i;
    private boolean field_75518_j;
    private boolean field_75519_k;
    private boolean field_75516_l;
    private boolean field_75517_m;

    public PathNavigate(EntityLiving p_i3507_1_, World p_i3507_2_, float p_i3507_3_)
    {
        field_75509_f = false;
        field_75521_i = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
        field_75518_j = true;
        field_75519_k = false;
        field_75516_l = false;
        field_75517_m = false;
        field_75515_a = p_i3507_1_;
        field_75513_b = p_i3507_2_;
        field_75512_e = p_i3507_3_;
    }

    public void func_75491_a(boolean p_75491_1_)
    {
        field_75516_l = p_75491_1_;
    }

    public boolean func_75486_a()
    {
        return field_75516_l;
    }

    public void func_75498_b(boolean p_75498_1_)
    {
        field_75519_k = p_75498_1_;
    }

    public void func_75490_c(boolean p_75490_1_)
    {
        field_75518_j = p_75490_1_;
    }

    public boolean func_75507_c()
    {
        return field_75519_k;
    }

    public void func_75504_d(boolean p_75504_1_)
    {
        field_75509_f = p_75504_1_;
    }

    public void func_75489_a(float p_75489_1_)
    {
        field_75511_d = p_75489_1_;
    }

    public void func_75495_e(boolean p_75495_1_)
    {
        field_75517_m = p_75495_1_;
    }

    public PathEntity func_75488_a(double p_75488_1_, double p_75488_3_, double p_75488_5_)
    {
        if(!func_75485_k())
        {
            return null;
        } else
        {
            return field_75513_b.func_72844_a(field_75515_a, MathHelper.func_76128_c(p_75488_1_), (int)p_75488_3_, MathHelper.func_76128_c(p_75488_5_), field_75512_e, field_75518_j, field_75519_k, field_75516_l, field_75517_m);
        }
    }

    public boolean func_75492_a(double p_75492_1_, double p_75492_3_, double p_75492_5_, float p_75492_7_)
    {
        PathEntity pathentity = func_75488_a(MathHelper.func_76128_c(p_75492_1_), (int)p_75492_3_, MathHelper.func_76128_c(p_75492_5_));
        return func_75484_a(pathentity, p_75492_7_);
    }

    public PathEntity func_75494_a(EntityLiving p_75494_1_)
    {
        if(!func_75485_k())
        {
            return null;
        } else
        {
            return field_75513_b.func_72865_a(field_75515_a, p_75494_1_, field_75512_e, field_75518_j, field_75519_k, field_75516_l, field_75517_m);
        }
    }

    public boolean func_75497_a(EntityLiving p_75497_1_, float p_75497_2_)
    {
        PathEntity pathentity = func_75494_a(p_75497_1_);
        if(pathentity != null)
        {
            return func_75484_a(pathentity, p_75497_2_);
        } else
        {
            return false;
        }
    }

    public boolean func_75484_a(PathEntity p_75484_1_, float p_75484_2_)
    {
        if(p_75484_1_ == null)
        {
            field_75514_c = null;
            return false;
        }
        if(!p_75484_1_.func_75876_a(field_75514_c))
        {
            field_75514_c = p_75484_1_;
        }
        if(field_75509_f)
        {
            func_75487_m();
        }
        if(field_75514_c.func_75874_d() == 0)
        {
            return false;
        } else
        {
            field_75511_d = p_75484_2_;
            Vec3 vec3 = func_75502_i();
            field_75520_h = field_75510_g;
            field_75521_i.field_72450_a = vec3.field_72450_a;
            field_75521_i.field_72448_b = vec3.field_72448_b;
            field_75521_i.field_72449_c = vec3.field_72449_c;
            return true;
        }
    }

    public PathEntity func_75505_d()
    {
        return field_75514_c;
    }

    public void func_75501_e()
    {
        field_75510_g++;
        if(func_75500_f())
        {
            return;
        }
        if(func_75485_k())
        {
            func_75508_h();
        }
        if(func_75500_f())
        {
            return;
        }
        Vec3 vec3 = field_75514_c.func_75878_a(field_75515_a);
        if(vec3 == null)
        {
            return;
        } else
        {
            field_75515_a.func_70605_aq().func_75642_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, field_75511_d);
            return;
        }
    }

    private void func_75508_h()
    {
        Vec3 vec3 = func_75502_i();
        int i = field_75514_c.func_75874_d();
        float f = field_75514_c.func_75873_e();
        do
        {
            if(f >= field_75514_c.func_75874_d())
            {
                break;
            }
            if(field_75514_c.func_75877_a(f).field_75837_b != (int)vec3.field_72448_b)
            {
                i = f;
                break;
            }
            f++;
        } while(true);
        f = field_75515_a.field_70130_N * field_75515_a.field_70130_N;
        for(int j = field_75514_c.func_75873_e(); j < i; j++)
        {
            if(vec3.func_72436_e(field_75514_c.func_75881_a(field_75515_a, j)) < (double)f)
            {
                field_75514_c.func_75872_c(j + 1);
            }
        }

        int k = MathHelper.func_76123_f(field_75515_a.field_70130_N);
        int l = (int)field_75515_a.field_70131_O + 1;
        int i1 = k;
        int j1 = i - 1;
        do
        {
            if(j1 < field_75514_c.func_75873_e())
            {
                break;
            }
            if(func_75493_a(vec3, field_75514_c.func_75881_a(field_75515_a, j1), k, l, i1))
            {
                field_75514_c.func_75872_c(j1);
                break;
            }
            j1--;
        } while(true);
        if(field_75510_g - field_75520_h > 100)
        {
            if(vec3.func_72436_e(field_75521_i) < 2.25D)
            {
                func_75499_g();
            }
            field_75520_h = field_75510_g;
            field_75521_i.field_72450_a = vec3.field_72450_a;
            field_75521_i.field_72448_b = vec3.field_72448_b;
            field_75521_i.field_72449_c = vec3.field_72449_c;
        }
    }

    public boolean func_75500_f()
    {
        return field_75514_c == null || field_75514_c.func_75879_b();
    }

    public void func_75499_g()
    {
        field_75514_c = null;
    }

    private Vec3 func_75502_i()
    {
        return Vec3.func_72437_a().func_72345_a(field_75515_a.field_70165_t, func_75503_j(), field_75515_a.field_70161_v);
    }

    private int func_75503_j()
    {
        if(!field_75515_a.func_70090_H() || !field_75517_m)
        {
            return (int)(field_75515_a.field_70121_D.field_72338_b + 0.5D);
        }
        int i = (int)field_75515_a.field_70121_D.field_72338_b;
        int j = field_75513_b.func_72798_a(MathHelper.func_76128_c(field_75515_a.field_70165_t), i, MathHelper.func_76128_c(field_75515_a.field_70161_v));
        int k = 0;
        while(j == Block.field_71942_A.field_71990_ca || j == Block.field_71943_B.field_71990_ca) 
        {
            i++;
            j = field_75513_b.func_72798_a(MathHelper.func_76128_c(field_75515_a.field_70165_t), i, MathHelper.func_76128_c(field_75515_a.field_70161_v));
            if(++k > 16)
            {
                return (int)field_75515_a.field_70121_D.field_72338_b;
            }
        }
        return i;
    }

    private boolean func_75485_k()
    {
        return field_75515_a.field_70122_E || field_75517_m && func_75506_l();
    }

    private boolean func_75506_l()
    {
        return field_75515_a.func_70090_H() || field_75515_a.func_70058_J();
    }

    private void func_75487_m()
    {
        if(field_75513_b.func_72937_j(MathHelper.func_76128_c(field_75515_a.field_70165_t), (int)(field_75515_a.field_70121_D.field_72338_b + 0.5D), MathHelper.func_76128_c(field_75515_a.field_70161_v)))
        {
            return;
        }
        for(int i = 0; i < field_75514_c.func_75874_d(); i++)
        {
            PathPoint pathpoint = field_75514_c.func_75877_a(i);
            if(field_75513_b.func_72937_j(pathpoint.field_75839_a, pathpoint.field_75837_b, pathpoint.field_75838_c))
            {
                field_75514_c.func_75871_b(i - 1);
                return;
            }
        }

    }

    private boolean func_75493_a(Vec3 p_75493_1_, Vec3 p_75493_2_, int p_75493_3_, int p_75493_4_, int p_75493_5_)
    {
        int i = MathHelper.func_76128_c(p_75493_1_.field_72450_a);
        int j = MathHelper.func_76128_c(p_75493_1_.field_72449_c);
        double d = p_75493_2_.field_72450_a - p_75493_1_.field_72450_a;
        double d1 = p_75493_2_.field_72449_c - p_75493_1_.field_72449_c;
        double d2 = d * d + d1 * d1;
        if(d2 < 1E-008D)
        {
            return false;
        }
        double d3 = 1.0D / Math.sqrt(d2);
        d *= d3;
        d1 *= d3;
        p_75493_3_ += 2;
        p_75493_5_ += 2;
        if(!func_75483_a(i, (int)p_75493_1_.field_72448_b, j, p_75493_3_, p_75493_4_, p_75493_5_, p_75493_1_, d, d1))
        {
            return false;
        }
        p_75493_3_ -= 2;
        p_75493_5_ -= 2;
        double d4 = 1.0D / Math.abs(d);
        double d5 = 1.0D / Math.abs(d1);
        double d6 = (double)(i * 1) - p_75493_1_.field_72450_a;
        double d7 = (double)(j * 1) - p_75493_1_.field_72449_c;
        if(d >= 0.0D)
        {
            d6++;
        }
        if(d1 >= 0.0D)
        {
            d7++;
        }
        d6 /= d;
        d7 /= d1;
        byte byte0 = ((byte)(d >= 0.0D ? 1 : -1));
        byte byte1 = ((byte)(d1 >= 0.0D ? 1 : -1));
        int k = MathHelper.func_76128_c(p_75493_2_.field_72450_a);
        int l = MathHelper.func_76128_c(p_75493_2_.field_72449_c);
        int i1 = k - i;
        for(int j1 = l - j; i1 * byte0 > 0 || j1 * byte1 > 0;)
        {
            if(d6 < d7)
            {
                d6 += d4;
                i += byte0;
                i1 = k - i;
            } else
            {
                d7 += d5;
                j += byte1;
                j1 = l - j;
            }
            if(!func_75483_a(i, (int)p_75493_1_.field_72448_b, j, p_75493_3_, p_75493_4_, p_75493_5_, p_75493_1_, d, d1))
            {
                return false;
            }
        }

        return true;
    }

    private boolean func_75483_a(int p_75483_1_, int p_75483_2_, int p_75483_3_, int p_75483_4_, int p_75483_5_, int p_75483_6_, Vec3 p_75483_7_, 
            double p_75483_8_, double p_75483_10_)
    {
        int i = p_75483_1_ - p_75483_4_ / 2;
        int j = p_75483_3_ - p_75483_6_ / 2;
        if(!func_75496_b(i, p_75483_2_, j, p_75483_4_, p_75483_5_, p_75483_6_, p_75483_7_, p_75483_8_, p_75483_10_))
        {
            return false;
        }
        for(int k = i; k < i + p_75483_4_; k++)
        {
            for(int l = j; l < j + p_75483_6_; l++)
            {
                double d = ((double)k + 0.5D) - p_75483_7_.field_72450_a;
                double d1 = ((double)l + 0.5D) - p_75483_7_.field_72449_c;
                if(d * p_75483_8_ + d1 * p_75483_10_ < 0.0D)
                {
                    continue;
                }
                int i1 = field_75513_b.func_72798_a(k, p_75483_2_ - 1, l);
                if(i1 <= 0)
                {
                    return false;
                }
                Material material = Block.field_71973_m[i1].field_72018_cp;
                if(material == Material.field_76244_g && !field_75515_a.func_70090_H())
                {
                    return false;
                }
                if(material == Material.field_76256_h)
                {
                    return false;
                }
            }

        }

        return true;
    }

    private boolean func_75496_b(int p_75496_1_, int p_75496_2_, int p_75496_3_, int p_75496_4_, int p_75496_5_, int p_75496_6_, Vec3 p_75496_7_, 
            double p_75496_8_, double p_75496_10_)
    {
        for(int i = p_75496_1_; i < p_75496_1_ + p_75496_4_; i++)
        {
            for(int j = p_75496_2_; j < p_75496_2_ + p_75496_5_; j++)
            {
                for(int k = p_75496_3_; k < p_75496_3_ + p_75496_6_; k++)
                {
                    double d = ((double)i + 0.5D) - p_75496_7_.field_72450_a;
                    double d1 = ((double)k + 0.5D) - p_75496_7_.field_72449_c;
                    if(d * p_75496_8_ + d1 * p_75496_10_ < 0.0D)
                    {
                        continue;
                    }
                    int l = field_75513_b.func_72798_a(i, j, k);
                    if(l > 0 && !Block.field_71973_m[l].func_71918_c(field_75513_b, i, j, k))
                    {
                        return false;
                    }
                }

            }

        }

        return true;
    }
}
