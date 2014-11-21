// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Vec3, EntityCreature, MathHelper, ChunkCoordinates, 
//            Vec3Pool

public class RandomPositionGenerator
{

    private static Vec3 field_75465_a = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);

    public static Vec3 func_75463_a(EntityCreature p_75463_0_, int p_75463_1_, int p_75463_2_)
    {
        return func_75462_c(p_75463_0_, p_75463_1_, p_75463_2_, null);
    }

    public static Vec3 func_75464_a(EntityCreature p_75464_0_, int p_75464_1_, int p_75464_2_, Vec3 p_75464_3_)
    {
        field_75465_a.field_72450_a = p_75464_3_.field_72450_a - p_75464_0_.field_70165_t;
        field_75465_a.field_72448_b = p_75464_3_.field_72448_b - p_75464_0_.field_70163_u;
        field_75465_a.field_72449_c = p_75464_3_.field_72449_c - p_75464_0_.field_70161_v;
        return func_75462_c(p_75464_0_, p_75464_1_, p_75464_2_, field_75465_a);
    }

    public static Vec3 func_75461_b(EntityCreature p_75461_0_, int p_75461_1_, int p_75461_2_, Vec3 p_75461_3_)
    {
        field_75465_a.field_72450_a = p_75461_0_.field_70165_t - p_75461_3_.field_72450_a;
        field_75465_a.field_72448_b = p_75461_0_.field_70163_u - p_75461_3_.field_72448_b;
        field_75465_a.field_72449_c = p_75461_0_.field_70161_v - p_75461_3_.field_72449_c;
        return func_75462_c(p_75461_0_, p_75461_1_, p_75461_2_, field_75465_a);
    }

    private static Vec3 func_75462_c(EntityCreature p_75462_0_, int p_75462_1_, int p_75462_2_, Vec3 p_75462_3_)
    {
        Random random = p_75462_0_.func_70681_au();
        boolean flag = false;
        int i = 0;
        int j = 0;
        int k = 0;
        float f = -99999F;
        boolean flag1;
        if(p_75462_0_.func_70622_aF())
        {
            double d = p_75462_0_.func_70602_aC().func_71569_e(MathHelper.func_76128_c(p_75462_0_.field_70165_t), MathHelper.func_76128_c(p_75462_0_.field_70163_u), MathHelper.func_76128_c(p_75462_0_.field_70161_v)) + 4F;
            double d1 = p_75462_0_.func_70640_aD() + (float)p_75462_1_;
            flag1 = d < d1 * d1;
        } else
        {
            flag1 = false;
        }
        for(int l = 0; l < 10; l++)
        {
            int i1 = random.nextInt(2 * p_75462_1_) - p_75462_1_;
            int j1 = random.nextInt(2 * p_75462_2_) - p_75462_2_;
            int k1 = random.nextInt(2 * p_75462_1_) - p_75462_1_;
            if(p_75462_3_ != null && (double)i1 * p_75462_3_.field_72450_a + (double)k1 * p_75462_3_.field_72449_c < 0.0D)
            {
                continue;
            }
            i1 += MathHelper.func_76128_c(p_75462_0_.field_70165_t);
            j1 += MathHelper.func_76128_c(p_75462_0_.field_70163_u);
            k1 += MathHelper.func_76128_c(p_75462_0_.field_70161_v);
            if(flag1 && !p_75462_0_.func_70649_d(i1, j1, k1))
            {
                continue;
            }
            float f1 = p_75462_0_.func_70783_a(i1, j1, k1);
            if(f1 > f)
            {
                f = f1;
                i = i1;
                j = j1;
                k = k1;
                flag = true;
            }
        }

        if(flag)
        {
            return Vec3.func_72437_a().func_72345_a(i, j, k);
        } else
        {
            return null;
        }
    }

}
