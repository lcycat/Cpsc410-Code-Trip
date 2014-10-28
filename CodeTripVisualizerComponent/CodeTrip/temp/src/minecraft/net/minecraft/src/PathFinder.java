// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Path, IntHashMap, PathPoint, Entity, 
//            AxisAlignedBB, MathHelper, IBlockAccess, Block, 
//            Material, PathEntity

public class PathFinder
{

    private IBlockAccess field_75868_a;
    private Path field_75866_b;
    private IntHashMap field_75867_c;
    private PathPoint field_75864_d[];
    private boolean field_75865_e;
    private boolean field_75862_f;
    private boolean field_75863_g;
    private boolean field_75869_h;

    public PathFinder(IBlockAccess p_i3903_1_, boolean p_i3903_2_, boolean p_i3903_3_, boolean p_i3903_4_, boolean p_i3903_5_)
    {
        field_75866_b = new Path();
        field_75867_c = new IntHashMap();
        field_75864_d = new PathPoint[32];
        field_75868_a = p_i3903_1_;
        field_75865_e = p_i3903_2_;
        field_75862_f = p_i3903_3_;
        field_75863_g = p_i3903_4_;
        field_75869_h = p_i3903_5_;
    }

    public PathEntity func_75856_a(Entity p_75856_1_, Entity p_75856_2_, float p_75856_3_)
    {
        return func_75857_a(p_75856_1_, p_75856_2_.field_70165_t, p_75856_2_.field_70121_D.field_72338_b, p_75856_2_.field_70161_v, p_75856_3_);
    }

    public PathEntity func_75859_a(Entity p_75859_1_, int p_75859_2_, int p_75859_3_, int p_75859_4_, float p_75859_5_)
    {
        return func_75857_a(p_75859_1_, (float)p_75859_2_ + 0.5F, (float)p_75859_3_ + 0.5F, (float)p_75859_4_ + 0.5F, p_75859_5_);
    }

    private PathEntity func_75857_a(Entity p_75857_1_, double p_75857_2_, double p_75857_4_, double p_75857_6_, 
            float p_75857_8_)
    {
        field_75866_b.func_75848_a();
        field_75867_c.func_76046_c();
        boolean flag = field_75863_g;
        int i = MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72338_b + 0.5D);
        if(field_75869_h && p_75857_1_.func_70090_H())
        {
            i = (int)p_75857_1_.field_70121_D.field_72338_b;
            for(int j = field_75868_a.func_72798_a(MathHelper.func_76128_c(p_75857_1_.field_70165_t), i, MathHelper.func_76128_c(p_75857_1_.field_70161_v)); j == Block.field_71942_A.field_71990_ca || j == Block.field_71943_B.field_71990_ca; j = field_75868_a.func_72798_a(MathHelper.func_76128_c(p_75857_1_.field_70165_t), i, MathHelper.func_76128_c(p_75857_1_.field_70161_v)))
            {
                i++;
            }

            flag = field_75863_g;
            field_75863_g = false;
        } else
        {
            i = MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72338_b + 0.5D);
        }
        PathPoint pathpoint = func_75854_a(MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72340_a), i, MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72339_c));
        PathPoint pathpoint1 = func_75854_a(MathHelper.func_76128_c(p_75857_2_ - (double)(p_75857_1_.field_70130_N / 2.0F)), MathHelper.func_76128_c(p_75857_4_), MathHelper.func_76128_c(p_75857_6_ - (double)(p_75857_1_.field_70130_N / 2.0F)));
        PathPoint pathpoint2 = new PathPoint(MathHelper.func_76141_d(p_75857_1_.field_70130_N + 1.0F), MathHelper.func_76141_d(p_75857_1_.field_70131_O + 1.0F), MathHelper.func_76141_d(p_75857_1_.field_70130_N + 1.0F));
        PathEntity pathentity = func_75861_a(p_75857_1_, pathpoint, pathpoint1, pathpoint2, p_75857_8_);
        field_75863_g = flag;
        return pathentity;
    }

    private PathEntity func_75861_a(Entity p_75861_1_, PathPoint p_75861_2_, PathPoint p_75861_3_, PathPoint p_75861_4_, float p_75861_5_)
    {
        p_75861_2_.field_75836_e = 0.0F;
        p_75861_2_.field_75833_f = p_75861_2_.func_75832_b(p_75861_3_);
        p_75861_2_.field_75834_g = p_75861_2_.field_75833_f;
        field_75866_b.func_75848_a();
        field_75866_b.func_75849_a(p_75861_2_);
        PathPoint pathpoint = p_75861_2_;
        while(!field_75866_b.func_75845_e()) 
        {
            PathPoint pathpoint1 = field_75866_b.func_75844_c();
            if(pathpoint1.equals(p_75861_3_))
            {
                return func_75853_a(p_75861_2_, p_75861_3_);
            }
            if(pathpoint1.func_75832_b(p_75861_3_) < pathpoint.func_75832_b(p_75861_3_))
            {
                pathpoint = pathpoint1;
            }
            pathpoint1.field_75842_i = true;
            int i = func_75860_b(p_75861_1_, pathpoint1, p_75861_4_, p_75861_3_, p_75861_5_);
            int j = 0;
            while(j < i) 
            {
                PathPoint pathpoint2 = field_75864_d[j];
                float f = pathpoint1.field_75836_e + pathpoint1.func_75832_b(pathpoint2);
                if(!pathpoint2.func_75831_a() || f < pathpoint2.field_75836_e)
                {
                    pathpoint2.field_75841_h = pathpoint1;
                    pathpoint2.field_75836_e = f;
                    pathpoint2.field_75833_f = pathpoint2.func_75832_b(p_75861_3_);
                    if(pathpoint2.func_75831_a())
                    {
                        field_75866_b.func_75850_a(pathpoint2, pathpoint2.field_75836_e + pathpoint2.field_75833_f);
                    } else
                    {
                        pathpoint2.field_75834_g = pathpoint2.field_75836_e + pathpoint2.field_75833_f;
                        field_75866_b.func_75849_a(pathpoint2);
                    }
                }
                j++;
            }
        }
        if(pathpoint == p_75861_2_)
        {
            return null;
        } else
        {
            return func_75853_a(p_75861_2_, pathpoint);
        }
    }

    private int func_75860_b(Entity p_75860_1_, PathPoint p_75860_2_, PathPoint p_75860_3_, PathPoint p_75860_4_, float p_75860_5_)
    {
        int i = 0;
        int j = 0;
        if(func_75855_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b + 1, p_75860_2_.field_75838_c, p_75860_3_) == 1)
        {
            j = 1;
        }
        PathPoint pathpoint = func_75858_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c + 1, p_75860_3_, j);
        PathPoint pathpoint1 = func_75858_a(p_75860_1_, p_75860_2_.field_75839_a - 1, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c, p_75860_3_, j);
        PathPoint pathpoint2 = func_75858_a(p_75860_1_, p_75860_2_.field_75839_a + 1, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c, p_75860_3_, j);
        PathPoint pathpoint3 = func_75858_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c - 1, p_75860_3_, j);
        if(pathpoint != null && !pathpoint.field_75842_i && pathpoint.func_75829_a(p_75860_4_) < p_75860_5_)
        {
            field_75864_d[i++] = pathpoint;
        }
        if(pathpoint1 != null && !pathpoint1.field_75842_i && pathpoint1.func_75829_a(p_75860_4_) < p_75860_5_)
        {
            field_75864_d[i++] = pathpoint1;
        }
        if(pathpoint2 != null && !pathpoint2.field_75842_i && pathpoint2.func_75829_a(p_75860_4_) < p_75860_5_)
        {
            field_75864_d[i++] = pathpoint2;
        }
        if(pathpoint3 != null && !pathpoint3.field_75842_i && pathpoint3.func_75829_a(p_75860_4_) < p_75860_5_)
        {
            field_75864_d[i++] = pathpoint3;
        }
        return i;
    }

    private PathPoint func_75858_a(Entity p_75858_1_, int p_75858_2_, int p_75858_3_, int p_75858_4_, PathPoint p_75858_5_, int p_75858_6_)
    {
        PathPoint pathpoint = null;
        int i = func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_, p_75858_4_, p_75858_5_);
        if(i == 2)
        {
            return func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_);
        }
        if(i == 1)
        {
            pathpoint = func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_);
        }
        if(pathpoint == null && p_75858_6_ > 0 && i != -3 && i != -4 && func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_ + p_75858_6_, p_75858_4_, p_75858_5_) == 1)
        {
            pathpoint = func_75854_a(p_75858_2_, p_75858_3_ + p_75858_6_, p_75858_4_);
            p_75858_3_ += p_75858_6_;
        }
        if(pathpoint != null)
        {
            int j = 0;
            int k = 0;
            do
            {
                if(p_75858_3_ <= 0)
                {
                    break;
                }
                k = func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_ - 1, p_75858_4_, p_75858_5_);
                if(field_75863_g && k == -1)
                {
                    return null;
                }
                if(k != 1)
                {
                    break;
                }
                if(++j >= 4)
                {
                    return null;
                }
                if(--p_75858_3_ > 0)
                {
                    pathpoint = func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_);
                }
            } while(true);
            if(k == -2)
            {
                return null;
            }
        }
        return pathpoint;
    }

    private final PathPoint func_75854_a(int p_75854_1_, int p_75854_2_, int p_75854_3_)
    {
        int i = PathPoint.func_75830_a(p_75854_1_, p_75854_2_, p_75854_3_);
        PathPoint pathpoint = (PathPoint)field_75867_c.func_76041_a(i);
        if(pathpoint == null)
        {
            pathpoint = new PathPoint(p_75854_1_, p_75854_2_, p_75854_3_);
            field_75867_c.func_76038_a(i, pathpoint);
        }
        return pathpoint;
    }

    private int func_75855_a(Entity p_75855_1_, int p_75855_2_, int p_75855_3_, int p_75855_4_, PathPoint p_75855_5_)
    {
        boolean flag = false;
        for(int i = p_75855_2_; i < p_75855_2_ + p_75855_5_.field_75839_a; i++)
        {
            for(int j = p_75855_3_; j < p_75855_3_ + p_75855_5_.field_75837_b; j++)
            {
                for(int k = p_75855_4_; k < p_75855_4_ + p_75855_5_.field_75838_c; k++)
                {
                    int l = field_75868_a.func_72798_a(i, j, k);
                    if(l <= 0)
                    {
                        continue;
                    }
                    if(l == Block.field_72005_bk.field_71990_ca)
                    {
                        flag = true;
                    } else
                    if(l == Block.field_71942_A.field_71990_ca || l == Block.field_71943_B.field_71990_ca)
                    {
                        if(field_75863_g)
                        {
                            return -1;
                        }
                        flag = true;
                    } else
                    if(!field_75865_e && l == Block.field_72054_aE.field_71990_ca)
                    {
                        return 0;
                    }
                    Block block = Block.field_71973_m[l];
                    if(block.func_71918_c(field_75868_a, i, j, k) || field_75862_f && l == Block.field_72054_aE.field_71990_ca)
                    {
                        continue;
                    }
                    if(l == Block.field_72031_aZ.field_71990_ca || l == Block.field_71993_bv.field_71990_ca)
                    {
                        return -3;
                    }
                    if(l == Block.field_72005_bk.field_71990_ca)
                    {
                        return -4;
                    }
                    Material material = block.field_72018_cp;
                    if(material == Material.field_76256_h)
                    {
                        if(!p_75855_1_.func_70058_J())
                        {
                            return -2;
                        }
                    } else
                    {
                        return 0;
                    }
                }

            }

        }

        return flag ? 2 : 1;
    }

    private PathEntity func_75853_a(PathPoint p_75853_1_, PathPoint p_75853_2_)
    {
        int i = 1;
        for(PathPoint pathpoint = p_75853_2_; pathpoint.field_75841_h != null; pathpoint = pathpoint.field_75841_h)
        {
            i++;
        }

        PathPoint apathpoint[] = new PathPoint[i];
        PathPoint pathpoint1 = p_75853_2_;
        for(apathpoint[--i] = pathpoint1; pathpoint1.field_75841_h != null; apathpoint[--i] = pathpoint1)
        {
            pathpoint1 = pathpoint1.field_75841_h;
        }

        return new PathEntity(apathpoint);
    }
}
