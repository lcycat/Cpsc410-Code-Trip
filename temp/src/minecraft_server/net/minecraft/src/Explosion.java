// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            World, MathHelper, Block, ChunkPosition, 
//            AxisAlignedBB, AABBPool, Vec3, Vec3Pool, 
//            Entity, DamageSource, EntityPlayer, BlockFire

public class Explosion
{

    public boolean field_77286_a;
    private int field_77289_h;
    private Random field_77290_i;
    private World field_77287_j;
    public double field_77284_b;
    public double field_77285_c;
    public double field_77282_d;
    public Entity field_77283_e;
    public float field_77280_f;
    public List field_77281_g;
    private Map field_77288_k;

    public Explosion(World p_i3727_1_, Entity p_i3727_2_, double p_i3727_3_, double p_i3727_5_, double p_i3727_7_, float p_i3727_9_)
    {
        field_77286_a = false;
        field_77289_h = 16;
        field_77290_i = new Random();
        field_77281_g = new ArrayList();
        field_77288_k = new HashMap();
        field_77287_j = p_i3727_1_;
        field_77283_e = p_i3727_2_;
        field_77280_f = p_i3727_9_;
        field_77284_b = p_i3727_3_;
        field_77285_c = p_i3727_5_;
        field_77282_d = p_i3727_7_;
    }

    public void func_77278_a()
    {
        float f = field_77280_f;
        HashSet hashset = new HashSet();
        for(int i = 0; i < field_77289_h; i++)
        {
            for(int k = 0; k < field_77289_h; k++)
            {
label0:
                for(int i1 = 0; i1 < field_77289_h; i1++)
                {
                    if(i != 0 && i != field_77289_h - 1 && k != 0 && k != field_77289_h - 1 && i1 != 0 && i1 != field_77289_h - 1)
                    {
                        continue;
                    }
                    double d = ((float)i / ((float)field_77289_h - 1.0F)) * 2.0F - 1.0F;
                    double d1 = ((float)k / ((float)field_77289_h - 1.0F)) * 2.0F - 1.0F;
                    double d2 = ((float)i1 / ((float)field_77289_h - 1.0F)) * 2.0F - 1.0F;
                    double d3 = Math.sqrt(d * d + d1 * d1 + d2 * d2);
                    d /= d3;
                    d1 /= d3;
                    d2 /= d3;
                    float f1 = field_77280_f * (0.7F + field_77287_j.field_73012_v.nextFloat() * 0.6F);
                    double d5 = field_77284_b;
                    double d7 = field_77285_c;
                    double d9 = field_77282_d;
                    float f2 = 0.3F;
                    do
                    {
                        if(f1 <= 0.0F)
                        {
                            continue label0;
                        }
                        int k2 = MathHelper.func_76128_c(d5);
                        int l2 = MathHelper.func_76128_c(d7);
                        int i3 = MathHelper.func_76128_c(d9);
                        int j3 = field_77287_j.func_72798_a(k2, l2, i3);
                        if(j3 > 0)
                        {
                            f1 -= (Block.field_71973_m[j3].func_71904_a(field_77283_e) + 0.3F) * f2;
                        }
                        if(f1 > 0.0F)
                        {
                            hashset.add(new ChunkPosition(k2, l2, i3));
                        }
                        d5 += d * (double)f2;
                        d7 += d1 * (double)f2;
                        d9 += d2 * (double)f2;
                        f1 -= f2 * 0.75F;
                    } while(true);
                }

            }

        }

        field_77281_g.addAll(hashset);
        field_77280_f *= 2.0F;
        int j = MathHelper.func_76128_c(field_77284_b - (double)field_77280_f - 1.0D);
        int l = MathHelper.func_76128_c(field_77284_b + (double)field_77280_f + 1.0D);
        int j1 = MathHelper.func_76128_c(field_77285_c - (double)field_77280_f - 1.0D);
        int k1 = MathHelper.func_76128_c(field_77285_c + (double)field_77280_f + 1.0D);
        int l1 = MathHelper.func_76128_c(field_77282_d - (double)field_77280_f - 1.0D);
        int i2 = MathHelper.func_76128_c(field_77282_d + (double)field_77280_f + 1.0D);
        List list = field_77287_j.func_72839_b(field_77283_e, AxisAlignedBB.func_72332_a().func_72299_a(j, j1, l1, l, k1, i2));
        Vec3 vec3 = Vec3.func_72437_a().func_72345_a(field_77284_b, field_77285_c, field_77282_d);
        for(int j2 = 0; j2 < list.size(); j2++)
        {
            Entity entity = (Entity)list.get(j2);
            double d4 = entity.func_70011_f(field_77284_b, field_77285_c, field_77282_d) / (double)field_77280_f;
            if(d4 > 1.0D)
            {
                continue;
            }
            double d6 = entity.field_70165_t - field_77284_b;
            double d8 = (entity.field_70163_u + (double)entity.func_70047_e()) - field_77285_c;
            double d10 = entity.field_70161_v - field_77282_d;
            double d11 = MathHelper.func_76133_a(d6 * d6 + d8 * d8 + d10 * d10);
            if(d11 == 0.0D)
            {
                continue;
            }
            d6 /= d11;
            d8 /= d11;
            d10 /= d11;
            double d12 = field_77287_j.func_72842_a(vec3, entity.field_70121_D);
            double d13 = (1.0D - d4) * d12;
            entity.func_70097_a(DamageSource.field_76378_k, (int)(((d13 * d13 + d13) / 2D) * 8D * (double)field_77280_f + 1.0D));
            entity.field_70159_w += d6 * d13;
            entity.field_70181_x += d8 * d13;
            entity.field_70179_y += d10 * d13;
            if(entity instanceof EntityPlayer)
            {
                field_77288_k.put((EntityPlayer)entity, Vec3.func_72437_a().func_72345_a(d6 * d13, d8 * d13, d10 * d13));
            }
        }

        field_77280_f = f;
    }

    public void func_77279_a(boolean p_77279_1_)
    {
        field_77287_j.func_72908_a(field_77284_b, field_77285_c, field_77282_d, "random.explode", 4F, (1.0F + (field_77287_j.field_73012_v.nextFloat() - field_77287_j.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
        field_77287_j.func_72869_a("hugeexplosion", field_77284_b, field_77285_c, field_77282_d, 0.0D, 0.0D, 0.0D);
        Iterator iterator = field_77281_g.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            ChunkPosition chunkposition = (ChunkPosition)iterator.next();
            int i = chunkposition.field_76930_a;
            int k = chunkposition.field_76928_b;
            int i1 = chunkposition.field_76929_c;
            int k1 = field_77287_j.func_72798_a(i, k, i1);
            if(p_77279_1_)
            {
                double d = (float)i + field_77287_j.field_73012_v.nextFloat();
                double d1 = (float)k + field_77287_j.field_73012_v.nextFloat();
                double d2 = (float)i1 + field_77287_j.field_73012_v.nextFloat();
                double d3 = d - field_77284_b;
                double d4 = d1 - field_77285_c;
                double d5 = d2 - field_77282_d;
                double d6 = MathHelper.func_76133_a(d3 * d3 + d4 * d4 + d5 * d5);
                d3 /= d6;
                d4 /= d6;
                d5 /= d6;
                double d7 = 0.5D / (d6 / (double)field_77280_f + 0.10000000000000001D);
                d7 *= field_77287_j.field_73012_v.nextFloat() * field_77287_j.field_73012_v.nextFloat() + 0.3F;
                d3 *= d7;
                d4 *= d7;
                d5 *= d7;
                field_77287_j.func_72869_a("explode", (d + field_77284_b * 1.0D) / 2D, (d1 + field_77285_c * 1.0D) / 2D, (d2 + field_77282_d * 1.0D) / 2D, d3, d4, d5);
                field_77287_j.func_72869_a("smoke", d, d1, d2, d3, d4, d5);
            }
            if(k1 > 0)
            {
                Block.field_71973_m[k1].func_71914_a(field_77287_j, i, k, i1, field_77287_j.func_72805_g(i, k, i1), 0.3F, 0);
                if(field_77287_j.func_72930_a(i, k, i1, 0, 0, field_77287_j.field_72995_K))
                {
                    field_77287_j.func_72898_h(i, k, i1, 0);
                }
                Block.field_71973_m[k1].func_71867_k(field_77287_j, i, k, i1);
            }
        } while(true);
        if(field_77286_a)
        {
            Iterator iterator1 = field_77281_g.iterator();
            do
            {
                if(!iterator1.hasNext())
                {
                    break;
                }
                ChunkPosition chunkposition1 = (ChunkPosition)iterator1.next();
                int j = chunkposition1.field_76930_a;
                int l = chunkposition1.field_76928_b;
                int j1 = chunkposition1.field_76929_c;
                int l1 = field_77287_j.func_72798_a(j, l, j1);
                int i2 = field_77287_j.func_72798_a(j, l - 1, j1);
                if(l1 == 0 && Block.field_71970_n[i2] && field_77290_i.nextInt(3) == 0)
                {
                    field_77287_j.func_72859_e(j, l, j1, Block.field_72067_ar.field_71990_ca);
                }
            } while(true);
        }
    }

    public Map func_77277_b()
    {
        return field_77288_k;
    }
}
