// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, BiomeDecorator, Block, BlockMycelium, 
//            SpawnListEntry, EntityMooshroom

public class BiomeGenMushroomIsland extends BiomeGenBase
{

    public BiomeGenMushroomIsland(int p_i3760_1_)
    {
        super(p_i3760_1_);
        field_76760_I.field_76832_z = -100;
        field_76760_I.field_76802_A = -100;
        field_76760_I.field_76803_B = -100;
        field_76760_I.field_76798_D = 1;
        field_76760_I.field_76807_J = 1;
        field_76752_A = (byte)Block.field_71994_by.field_71990_ca;
        field_76761_J.clear();
        field_76762_K.clear();
        field_76755_L.clear();
        field_76762_K.add(new SpawnListEntry(net.minecraft.src.EntityMooshroom.class, 8, 4, 8));
    }
}
