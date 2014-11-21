// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, EntityEnderCrystal, 
//            Entity

public class WorldGenSpikes extends WorldGenerator
{

    private int field_76538_a;

    public WorldGenSpikes(int p_i3798_1_)
    {
        field_76538_a = p_i3798_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if(!p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_) || p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) != field_76538_a)
        {
            return false;
        }
        int i = p_76484_2_.nextInt(32) + 6;
        int j = p_76484_2_.nextInt(4) + 1;
        for(int k = p_76484_3_ - j; k <= p_76484_3_ + j; k++)
        {
            for(int i1 = p_76484_5_ - j; i1 <= p_76484_5_ + j; i1++)
            {
                int k1 = k - p_76484_3_;
                int i2 = i1 - p_76484_5_;
                if(k1 * k1 + i2 * i2 <= j * j + 1 && p_76484_1_.func_72798_a(k, p_76484_4_ - 1, i1) != field_76538_a)
                {
                    return false;
                }
            }

        }

        for(int l = p_76484_4_; l < p_76484_4_ + i && l < 128; l++)
        {
            for(int j1 = p_76484_3_ - j; j1 <= p_76484_3_ + j; j1++)
            {
                for(int l1 = p_76484_5_ - j; l1 <= p_76484_5_ + j; l1++)
                {
                    int j2 = j1 - p_76484_3_;
                    int k2 = l1 - p_76484_5_;
                    if(j2 * j2 + k2 * k2 <= j * j + 1)
                    {
                        p_76484_1_.func_72859_e(j1, l, l1, Block.field_72089_ap.field_71990_ca);
                    }
                }

            }

        }

        EntityEnderCrystal entityendercrystal = new EntityEnderCrystal(p_76484_1_);
        entityendercrystal.func_70012_b((float)p_76484_3_ + 0.5F, p_76484_4_ + i, (float)p_76484_5_ + 0.5F, p_76484_2_.nextFloat() * 360F, 0.0F);
        p_76484_1_.func_72838_d(entityendercrystal);
        p_76484_1_.func_72859_e(p_76484_3_, p_76484_4_ + i, p_76484_5_, Block.field_71986_z.field_71990_ca);
        return true;
    }
}
