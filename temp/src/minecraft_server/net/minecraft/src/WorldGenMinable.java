// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, MathHelper, World, Block

public class WorldGenMinable extends WorldGenerator
{

    private int field_76542_a;
    private int field_76541_b;

    public WorldGenMinable(int p_i3796_1_, int p_i3796_2_)
    {
        field_76542_a = p_i3796_1_;
        field_76541_b = p_i3796_2_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        float f = p_76484_2_.nextFloat() * 3.141593F;
        double d = (float)(p_76484_3_ + 8) + (MathHelper.func_76126_a(f) * (float)field_76541_b) / 8F;
        double d1 = (float)(p_76484_3_ + 8) - (MathHelper.func_76126_a(f) * (float)field_76541_b) / 8F;
        double d2 = (float)(p_76484_5_ + 8) + (MathHelper.func_76134_b(f) * (float)field_76541_b) / 8F;
        double d3 = (float)(p_76484_5_ + 8) - (MathHelper.func_76134_b(f) * (float)field_76541_b) / 8F;
        double d4 = (p_76484_4_ + p_76484_2_.nextInt(3)) - 2;
        double d5 = (p_76484_4_ + p_76484_2_.nextInt(3)) - 2;
        for(int i = 0; i <= field_76541_b; i++)
        {
            double d6 = d + ((d1 - d) * (double)i) / (double)field_76541_b;
            double d7 = d4 + ((d5 - d4) * (double)i) / (double)field_76541_b;
            double d8 = d2 + ((d3 - d2) * (double)i) / (double)field_76541_b;
            double d9 = (p_76484_2_.nextDouble() * (double)field_76541_b) / 16D;
            double d10 = (double)(MathHelper.func_76126_a(((float)i * 3.141593F) / (float)field_76541_b) + 1.0F) * d9 + 1.0D;
            double d11 = (double)(MathHelper.func_76126_a(((float)i * 3.141593F) / (float)field_76541_b) + 1.0F) * d9 + 1.0D;
            int j = MathHelper.func_76128_c(d6 - d10 / 2D);
            int k = MathHelper.func_76128_c(d7 - d11 / 2D);
            int l = MathHelper.func_76128_c(d8 - d10 / 2D);
            int i1 = MathHelper.func_76128_c(d6 + d10 / 2D);
            int j1 = MathHelper.func_76128_c(d7 + d11 / 2D);
            int k1 = MathHelper.func_76128_c(d8 + d10 / 2D);
            for(int l1 = j; l1 <= i1; l1++)
            {
                double d12 = (((double)l1 + 0.5D) - d6) / (d10 / 2D);
                if(d12 * d12 >= 1.0D)
                {
                    continue;
                }
                for(int i2 = k; i2 <= j1; i2++)
                {
                    double d13 = (((double)i2 + 0.5D) - d7) / (d11 / 2D);
                    if(d12 * d12 + d13 * d13 >= 1.0D)
                    {
                        continue;
                    }
                    for(int j2 = l; j2 <= k1; j2++)
                    {
                        double d14 = (((double)j2 + 0.5D) - d8) / (d10 / 2D);
                        if(d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && p_76484_1_.func_72798_a(l1, i2, j2) == Block.field_71981_t.field_71990_ca)
                        {
                            p_76484_1_.func_72822_b(l1, i2, j2, field_76542_a);
                        }
                    }

                }

            }

        }

        return true;
    }
}
