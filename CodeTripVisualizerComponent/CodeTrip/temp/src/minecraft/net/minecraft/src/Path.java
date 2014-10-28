// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PathPoint

public class Path
{

    private PathPoint field_75852_a[];
    private int field_75851_b;

    public Path()
    {
        field_75852_a = new PathPoint[1024];
        field_75851_b = 0;
    }

    public PathPoint func_75849_a(PathPoint p_75849_1_)
    {
        if(p_75849_1_.field_75835_d >= 0)
        {
            throw new IllegalStateException("OW KNOWS!");
        }
        if(field_75851_b == field_75852_a.length)
        {
            PathPoint apathpoint[] = new PathPoint[field_75851_b << 1];
            System.arraycopy(field_75852_a, 0, apathpoint, 0, field_75851_b);
            field_75852_a = apathpoint;
        }
        field_75852_a[field_75851_b] = p_75849_1_;
        p_75849_1_.field_75835_d = field_75851_b;
        func_75847_a(field_75851_b++);
        return p_75849_1_;
    }

    public void func_75848_a()
    {
        field_75851_b = 0;
    }

    public PathPoint func_75844_c()
    {
        PathPoint pathpoint = field_75852_a[0];
        field_75852_a[0] = field_75852_a[--field_75851_b];
        field_75852_a[field_75851_b] = null;
        if(field_75851_b > 0)
        {
            func_75846_b(0);
        }
        pathpoint.field_75835_d = -1;
        return pathpoint;
    }

    public void func_75850_a(PathPoint p_75850_1_, float p_75850_2_)
    {
        float f = p_75850_1_.field_75834_g;
        p_75850_1_.field_75834_g = p_75850_2_;
        if(p_75850_2_ < f)
        {
            func_75847_a(p_75850_1_.field_75835_d);
        } else
        {
            func_75846_b(p_75850_1_.field_75835_d);
        }
    }

    private void func_75847_a(int p_75847_1_)
    {
        PathPoint pathpoint = field_75852_a[p_75847_1_];
        float f = pathpoint.field_75834_g;
        do
        {
            if(p_75847_1_ <= 0)
            {
                break;
            }
            int i = p_75847_1_ - 1 >> 1;
            PathPoint pathpoint1 = field_75852_a[i];
            if(f >= pathpoint1.field_75834_g)
            {
                break;
            }
            field_75852_a[p_75847_1_] = pathpoint1;
            pathpoint1.field_75835_d = p_75847_1_;
            p_75847_1_ = i;
        } while(true);
        field_75852_a[p_75847_1_] = pathpoint;
        pathpoint.field_75835_d = p_75847_1_;
    }

    private void func_75846_b(int p_75846_1_)
    {
        PathPoint pathpoint = field_75852_a[p_75846_1_];
        float f = pathpoint.field_75834_g;
        do
        {
            int i = 1 + (p_75846_1_ << 1);
            int j = i + 1;
            if(i >= field_75851_b)
            {
                break;
            }
            PathPoint pathpoint1 = field_75852_a[i];
            float f1 = pathpoint1.field_75834_g;
            PathPoint pathpoint2;
            float f2;
            if(j >= field_75851_b)
            {
                pathpoint2 = null;
                f2 = (1.0F / 0.0F);
            } else
            {
                pathpoint2 = field_75852_a[j];
                f2 = pathpoint2.field_75834_g;
            }
            if(f1 < f2)
            {
                if(f1 >= f)
                {
                    break;
                }
                field_75852_a[p_75846_1_] = pathpoint1;
                pathpoint1.field_75835_d = p_75846_1_;
                p_75846_1_ = i;
                continue;
            }
            if(f2 >= f)
            {
                break;
            }
            field_75852_a[p_75846_1_] = pathpoint2;
            pathpoint2.field_75835_d = p_75846_1_;
            p_75846_1_ = j;
        } while(true);
        field_75852_a[p_75846_1_] = pathpoint;
        pathpoint.field_75835_d = p_75846_1_;
    }

    public boolean func_75845_e()
    {
        return field_75851_b == 0;
    }
}
