// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeDecorator, WorldGenSpikes, Block, World, 
//            WorldGenerator, EntityDragon, BiomeGenBase

public class BiomeEndDecorator extends BiomeDecorator
{

    protected WorldGenerator field_76835_L;

    public BiomeEndDecorator(BiomeGenBase p_i3767_1_)
    {
        super(p_i3767_1_);
        field_76835_L = new WorldGenSpikes(Block.field_72082_bJ.field_71990_ca);
    }

    protected void func_76794_a()
    {
        func_76797_b();
        if(field_76813_b.nextInt(5) == 0)
        {
            int i = field_76814_c + field_76813_b.nextInt(16) + 8;
            int j = field_76811_d + field_76813_b.nextInt(16) + 8;
            int k = field_76815_a.func_72825_h(i, j);
            if(k <= 0);
            field_76835_L.func_76484_a(field_76815_a, field_76813_b, i, k, j);
        }
        if(field_76814_c == 0 && field_76811_d == 0)
        {
            EntityDragon entitydragon = new EntityDragon(field_76815_a);
            entitydragon.func_70012_b(0.0D, 128D, 0.0D, field_76813_b.nextFloat() * 360F, 0.0F);
            field_76815_a.func_72838_d(entitydragon);
        }
    }
}
