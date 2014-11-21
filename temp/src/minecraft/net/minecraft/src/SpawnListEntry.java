// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            WeightedRandomItem

public class SpawnListEntry extends WeightedRandomItem
{

    public Class field_76300_b;
    public int field_76301_c;
    public int field_76299_d;

    public SpawnListEntry(Class p_i3746_1_, int p_i3746_2_, int p_i3746_3_, int p_i3746_4_)
    {
        super(p_i3746_2_);
        field_76300_b = p_i3746_1_;
        field_76301_c = p_i3746_3_;
        field_76299_d = p_i3746_4_;
    }
}
