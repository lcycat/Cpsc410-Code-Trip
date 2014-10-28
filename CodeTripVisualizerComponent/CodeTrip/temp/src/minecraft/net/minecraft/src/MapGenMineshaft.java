// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, StructureMineshaftStart, StructureStart

public class MapGenMineshaft extends MapGenStructure
{

    public MapGenMineshaft()
    {
    }

    protected boolean func_75047_a(int p_75047_1_, int p_75047_2_)
    {
        return field_75038_b.nextInt(100) == 0 && field_75038_b.nextInt(80) < Math.max(Math.abs(p_75047_1_), Math.abs(p_75047_2_));
    }

    protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_)
    {
        return new StructureMineshaftStart(field_75039_c, field_75038_b, p_75049_1_, p_75049_2_);
    }
}
