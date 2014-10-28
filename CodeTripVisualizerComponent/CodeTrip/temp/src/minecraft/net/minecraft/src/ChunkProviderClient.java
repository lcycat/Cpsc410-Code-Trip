// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, LongHashMap, EmptyChunk, Chunk, 
//            ChunkCoordIntPair, World, IProgressUpdate, EnumCreatureType, 
//            ChunkPosition

public class ChunkProviderClient
    implements IChunkProvider
{

    private Chunk field_73238_a;
    private LongHashMap field_73236_b;
    private List field_73237_c;
    private World field_73235_d;

    public ChunkProviderClient(World p_i3112_1_)
    {
        field_73236_b = new LongHashMap();
        field_73237_c = new ArrayList();
        field_73238_a = new EmptyChunk(p_i3112_1_, 0, 0);
        field_73235_d = p_i3112_1_;
    }

    public boolean func_73149_a(int p_73149_1_, int p_73149_2_)
    {
        return true;
    }

    public void func_73234_b(int p_73234_1_, int p_73234_2_)
    {
        Chunk chunk = func_73154_d(p_73234_1_, p_73234_2_);
        if(!chunk.func_76621_g())
        {
            chunk.func_76623_d();
        }
        field_73236_b.func_76159_d(ChunkCoordIntPair.func_77272_a(p_73234_1_, p_73234_2_));
        field_73237_c.remove(chunk);
    }

    public Chunk func_73158_c(int p_73158_1_, int p_73158_2_)
    {
        Chunk chunk = new Chunk(field_73235_d, p_73158_1_, p_73158_2_);
        field_73236_b.func_76163_a(ChunkCoordIntPair.func_77272_a(p_73158_1_, p_73158_2_), chunk);
        chunk.field_76636_d = true;
        return chunk;
    }

    public Chunk func_73154_d(int p_73154_1_, int p_73154_2_)
    {
        Chunk chunk = (Chunk)field_73236_b.func_76164_a(ChunkCoordIntPair.func_77272_a(p_73154_1_, p_73154_2_));
        if(chunk == null)
        {
            return field_73238_a;
        } else
        {
            return chunk;
        }
    }

    public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_)
    {
        return true;
    }

    public boolean func_73156_b()
    {
        return false;
    }

    public boolean func_73157_c()
    {
        return false;
    }

    public void func_73153_a(IChunkProvider ichunkprovider, int i, int j)
    {
    }

    public String func_73148_d()
    {
        return (new StringBuilder()).append("MultiplayerChunkCache: ").append(field_73236_b.func_76162_a()).toString();
    }

    public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int i)
    {
        return null;
    }

    public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int i, int j)
    {
        return null;
    }

    public int func_73152_e()
    {
        return field_73237_c.size();
    }
}
