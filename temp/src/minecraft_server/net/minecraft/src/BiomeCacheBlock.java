// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, BiomeCache, WorldChunkManager

public class BiomeCacheBlock
{

    public float field_76892_a[];
    public float field_76890_b[];
    public BiomeGenBase field_76891_c[];
    public int field_76888_d;
    public int field_76889_e;
    public long field_76886_f;
    final BiomeCache field_76887_g; /* synthetic field */

    public BiomeCacheBlock(BiomeCache p_i3748_1_, int p_i3748_2_, int p_i3748_3_)
    {
        field_76887_g = p_i3748_1_;
        super();
        field_76892_a = new float[256];
        field_76890_b = new float[256];
        field_76891_c = new BiomeGenBase[256];
        field_76888_d = p_i3748_2_;
        field_76889_e = p_i3748_3_;
        BiomeCache.func_76836_a(p_i3748_1_).func_76934_b(field_76892_a, p_i3748_2_ << 4, p_i3748_3_ << 4, 16, 16);
        BiomeCache.func_76836_a(p_i3748_1_).func_76936_a(field_76890_b, p_i3748_2_ << 4, p_i3748_3_ << 4, 16, 16);
        BiomeCache.func_76836_a(p_i3748_1_).func_76931_a(field_76891_c, p_i3748_2_ << 4, p_i3748_3_ << 4, 16, 16, false);
    }

    public BiomeGenBase func_76885_a(int p_76885_1_, int p_76885_2_)
    {
        return field_76891_c[p_76885_1_ & 0xf | (p_76885_2_ & 0xf) << 4];
    }
}
