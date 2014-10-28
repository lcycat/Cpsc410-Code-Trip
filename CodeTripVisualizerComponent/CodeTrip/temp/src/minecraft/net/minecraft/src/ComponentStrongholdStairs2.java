// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStrongholdStairs, ComponentStrongholdPortalRoom, StructureStrongholdPieceWeight, ChunkPosition

public class ComponentStrongholdStairs2 extends ComponentStrongholdStairs
{

    public StructureStrongholdPieceWeight field_75027_a;
    public ComponentStrongholdPortalRoom field_75025_b;
    public ArrayList field_75026_c;

    public ComponentStrongholdStairs2(int p_i3852_1_, Random p_i3852_2_, int p_i3852_3_, int p_i3852_4_)
    {
        super(0, p_i3852_2_, p_i3852_3_, p_i3852_4_);
        field_75026_c = new ArrayList();
    }

    public ChunkPosition func_74868_a()
    {
        if(field_75025_b != null)
        {
            return field_75025_b.func_74868_a();
        } else
        {
            return super.func_74868_a();
        }
    }
}
