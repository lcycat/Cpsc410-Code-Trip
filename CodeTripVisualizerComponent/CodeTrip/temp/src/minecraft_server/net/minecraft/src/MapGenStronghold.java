// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, BiomeGenBase, ChunkCoordIntPair, World, 
//            WorldChunkManager, ChunkPosition, StructureStrongholdStart, ComponentStrongholdStairs2, 
//            StructureStart

public class MapGenStronghold extends MapGenStructure
{

    private BiomeGenBase field_75058_e[];
    private boolean field_75056_f;
    private ChunkCoordIntPair field_75057_g[];

    public MapGenStronghold()
    {
        field_75058_e = (new BiomeGenBase[] {
            BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76768_g, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76783_v, 
            BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x
        });
        field_75057_g = new ChunkCoordIntPair[3];
    }

    protected boolean func_75047_a(int p_75047_1_, int p_75047_2_)
    {
        if(!field_75056_f)
        {
            Random random = new Random();
            random.setSeed(field_75039_c.func_72905_C());
            double d = random.nextDouble() * 3.1415926535897931D * 2D;
            for(int k = 0; k < field_75057_g.length; k++)
            {
                double d1 = (1.25D + random.nextDouble()) * 32D;
                int l = (int)Math.round(Math.cos(d) * d1);
                int i1 = (int)Math.round(Math.sin(d) * d1);
                ArrayList arraylist = new ArrayList();
                Collections.addAll(arraylist, field_75058_e);
                ChunkPosition chunkposition = field_75039_c.func_72959_q().func_76941_a((l << 4) + 8, (i1 << 4) + 8, 112, arraylist, random);
                if(chunkposition != null)
                {
                    l = chunkposition.field_76930_a >> 4;
                    i1 = chunkposition.field_76929_c >> 4;
                } else
                {
                    System.out.println((new StringBuilder()).append("Placed stronghold in INVALID biome at (").append(l).append(", ").append(i1).append(")").toString());
                }
                field_75057_g[k] = new ChunkCoordIntPair(l, i1);
                d += 6.2831853071795862D / (double)field_75057_g.length;
            }

            field_75056_f = true;
        }
        ChunkCoordIntPair achunkcoordintpair[] = field_75057_g;
        int i = achunkcoordintpair.length;
        for(int j = 0; j < i; j++)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[j];
            if(p_75047_1_ == chunkcoordintpair.field_77276_a && p_75047_2_ == chunkcoordintpair.field_77275_b)
            {
                System.out.println((new StringBuilder()).append(p_75047_1_).append(", ").append(p_75047_2_).toString());
                return true;
            }
        }

        return false;
    }

    protected List func_75052_o_()
    {
        ArrayList arraylist = new ArrayList();
        ChunkCoordIntPair achunkcoordintpair[] = field_75057_g;
        int i = achunkcoordintpair.length;
        for(int j = 0; j < i; j++)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[j];
            if(chunkcoordintpair != null)
            {
                arraylist.add(chunkcoordintpair.func_77271_a(64));
            }
        }

        return arraylist;
    }

    protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_)
    {
        StructureStrongholdStart structurestrongholdstart;
        for(structurestrongholdstart = new StructureStrongholdStart(field_75039_c, field_75038_b, p_75049_1_, p_75049_2_); structurestrongholdstart.func_75073_b().isEmpty() || ((ComponentStrongholdStairs2)structurestrongholdstart.func_75073_b().get(0)).field_75025_b == null; structurestrongholdstart = new StructureStrongholdStart(field_75039_c, field_75038_b, p_75049_1_, p_75049_2_)) { }
        return structurestrongholdstart;
    }
}
