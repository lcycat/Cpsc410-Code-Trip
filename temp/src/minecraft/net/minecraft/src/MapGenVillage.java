// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, World, WorldChunkManager, StructureVillageStart, 
//            BiomeGenBase, StructureStart

public class MapGenVillage extends MapGenStructure
{

    public static List field_75055_e;
    private final int field_75054_f;

    public MapGenVillage(int p_i3859_1_)
    {
        field_75054_f = p_i3859_1_;
    }

    protected boolean func_75047_a(int p_75047_1_, int p_75047_2_)
    {
        byte byte0 = 32;
        byte byte1 = 8;
        int i = p_75047_1_;
        int j = p_75047_2_;
        if(p_75047_1_ < 0)
        {
            p_75047_1_ -= byte0 - 1;
        }
        if(p_75047_2_ < 0)
        {
            p_75047_2_ -= byte0 - 1;
        }
        int k = p_75047_1_ / byte0;
        int l = p_75047_2_ / byte0;
        Random random = field_75039_c.func_72843_D(k, l, 0x9e7f70);
        k *= byte0;
        l *= byte0;
        k += random.nextInt(byte0 - byte1);
        l += random.nextInt(byte0 - byte1);
        p_75047_1_ = i;
        p_75047_2_ = j;
        if(p_75047_1_ == k && p_75047_2_ == l)
        {
            boolean flag = field_75039_c.func_72959_q().func_76940_a(p_75047_1_ * 16 + 8, p_75047_2_ * 16 + 8, 0, field_75055_e);
            if(flag)
            {
                return true;
            }
        }
        return false;
    }

    protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_)
    {
        return new StructureVillageStart(field_75039_c, field_75038_b, p_75049_1_, p_75049_2_, field_75054_f);
    }

    static 
    {
        field_75055_e = Arrays.asList(new BiomeGenBase[] {
            BiomeGenBase.field_76772_c, BiomeGenBase.field_76769_d
        });
    }
}
