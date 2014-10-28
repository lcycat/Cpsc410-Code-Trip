// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, SpawnListEntry, EntityBlaze, EntityPigZombie, 
//            EntityMagmaCube, World, StructureNetherBridgeStart, StructureStart

public class MapGenNetherBridge extends MapGenStructure
{

    private List field_75060_e;

    public MapGenNetherBridge()
    {
        field_75060_e = new ArrayList();
        field_75060_e.add(new SpawnListEntry(net.minecraft.src.EntityBlaze.class, 10, 2, 3));
        field_75060_e.add(new SpawnListEntry(net.minecraft.src.EntityPigZombie.class, 10, 4, 4));
        field_75060_e.add(new SpawnListEntry(net.minecraft.src.EntityMagmaCube.class, 3, 4, 4));
    }

    public List func_75059_a()
    {
        return field_75060_e;
    }

    protected boolean func_75047_a(int p_75047_1_, int p_75047_2_)
    {
        int i = p_75047_1_ >> 4;
        int j = p_75047_2_ >> 4;
        field_75038_b.setSeed((long)(i ^ j << 4) ^ field_75039_c.func_72905_C());
        field_75038_b.nextInt();
        if(field_75038_b.nextInt(3) != 0)
        {
            return false;
        }
        if(p_75047_1_ != (i << 4) + 4 + field_75038_b.nextInt(8))
        {
            return false;
        }
        return p_75047_2_ == (j << 4) + 4 + field_75038_b.nextInt(8);
    }

    protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_)
    {
        return new StructureNetherBridgeStart(field_75039_c, field_75038_b, p_75049_1_, p_75049_2_);
    }
}
