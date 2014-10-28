// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, SpawnListEntry, EntityEnderman, Block, 
//            BiomeEndDecorator

public class BiomeGenEnd extends BiomeGenBase
{

    public BiomeGenEnd(int p_i3766_1_)
    {
        super(p_i3766_1_);
        field_76761_J.clear();
        field_76762_K.clear();
        field_76755_L.clear();
        field_76761_J.add(new SpawnListEntry(net.minecraft.src.EntityEnderman.class, 10, 4, 4));
        field_76752_A = (byte)Block.field_71979_v.field_71990_ca;
        field_76753_B = (byte)Block.field_71979_v.field_71990_ca;
        field_76760_I = new BiomeEndDecorator(this);
    }

    public int func_76731_a(float p_76731_1_)
    {
        return 0;
    }
}
