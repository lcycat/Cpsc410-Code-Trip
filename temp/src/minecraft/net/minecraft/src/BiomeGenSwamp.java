// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, BiomeDecorator, ColorizerGrass, ColorizerFoliage, 
//            WorldGenerator

public class BiomeGenSwamp extends BiomeGenBase
{

    protected BiomeGenSwamp(int p_i3764_1_)
    {
        super(p_i3764_1_);
        field_76760_I.field_76832_z = 2;
        field_76760_I.field_76802_A = -999;
        field_76760_I.field_76804_C = 1;
        field_76760_I.field_76798_D = 8;
        field_76760_I.field_76799_E = 10;
        field_76760_I.field_76806_I = 1;
        field_76760_I.field_76833_y = 4;
        field_76759_H = 0xe0ffae;
    }

    public WorldGenerator func_76740_a(Random p_76740_1_)
    {
        return field_76763_Q;
    }

    public int func_76737_k()
    {
        double d = func_76743_j();
        double d1 = func_76727_i();
        return ((ColorizerGrass.func_77480_a(d, d1) & 0xfefefe) + 0x4e0e4e) / 2;
    }

    public int func_76726_l()
    {
        double d = func_76743_j();
        double d1 = func_76727_i();
        return ((ColorizerFoliage.func_77470_a(d, d1) & 0xfefefe) + 0x4e0e4e) / 2;
    }
}
