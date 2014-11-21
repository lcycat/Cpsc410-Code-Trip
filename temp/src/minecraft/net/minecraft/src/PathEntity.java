// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PathPoint, Entity, Vec3, Vec3Pool

public class PathEntity
{

    private final PathPoint field_75884_a[];
    private int field_75882_b;
    private int field_75883_c;

    public PathEntity(PathPoint p_i3902_1_[])
    {
        field_75884_a = p_i3902_1_;
        field_75883_c = p_i3902_1_.length;
    }

    public void func_75875_a()
    {
        field_75882_b++;
    }

    public boolean func_75879_b()
    {
        return field_75882_b >= field_75883_c;
    }

    public PathPoint func_75870_c()
    {
        if(field_75883_c > 0)
        {
            return field_75884_a[field_75883_c - 1];
        } else
        {
            return null;
        }
    }

    public PathPoint func_75877_a(int p_75877_1_)
    {
        return field_75884_a[p_75877_1_];
    }

    public int func_75874_d()
    {
        return field_75883_c;
    }

    public void func_75871_b(int p_75871_1_)
    {
        field_75883_c = p_75871_1_;
    }

    public int func_75873_e()
    {
        return field_75882_b;
    }

    public void func_75872_c(int p_75872_1_)
    {
        field_75882_b = p_75872_1_;
    }

    public Vec3 func_75881_a(Entity p_75881_1_, int p_75881_2_)
    {
        double d = (double)field_75884_a[p_75881_2_].field_75839_a + (double)(int)(p_75881_1_.field_70130_N + 1.0F) * 0.5D;
        double d1 = field_75884_a[p_75881_2_].field_75837_b;
        double d2 = (double)field_75884_a[p_75881_2_].field_75838_c + (double)(int)(p_75881_1_.field_70130_N + 1.0F) * 0.5D;
        return Vec3.func_72437_a().func_72345_a(d, d1, d2);
    }

    public Vec3 func_75878_a(Entity p_75878_1_)
    {
        return func_75881_a(p_75878_1_, field_75882_b);
    }

    public boolean func_75876_a(PathEntity p_75876_1_)
    {
        if(p_75876_1_ == null)
        {
            return false;
        }
        if(p_75876_1_.field_75884_a.length != field_75884_a.length)
        {
            return false;
        }
        for(int i = 0; i < field_75884_a.length; i++)
        {
            if(field_75884_a[i].field_75839_a != p_75876_1_.field_75884_a[i].field_75839_a || field_75884_a[i].field_75837_b != p_75876_1_.field_75884_a[i].field_75837_b || field_75884_a[i].field_75838_c != p_75876_1_.field_75884_a[i].field_75838_c)
            {
                return false;
            }
        }

        return true;
    }

    public boolean func_75880_b(Vec3 p_75880_1_)
    {
        PathPoint pathpoint = func_75870_c();
        if(pathpoint == null)
        {
            return false;
        } else
        {
            return pathpoint.field_75839_a == (int)p_75880_1_.field_72450_a && pathpoint.field_75838_c == (int)p_75880_1_.field_72449_c;
        }
    }
}
