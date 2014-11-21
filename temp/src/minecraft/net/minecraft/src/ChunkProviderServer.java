// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, LongHashMap, EmptyChunk, ChunkCoordIntPair, 
//            WorldServer, WorldProvider, ChunkCoordinates, Chunk, 
//            IChunkLoader, MinecraftException, ModLoader, IProgressUpdate, 
//            EnumCreatureType, World, ChunkPosition

public class ChunkProviderServer
    implements IChunkProvider
{

    private Set field_73248_b;
    private Chunk field_73249_c;
    private IChunkProvider field_73246_d;
    private IChunkLoader field_73247_e;
    public boolean field_73250_a;
    private LongHashMap field_73244_f;
    private List field_73245_g;
    private WorldServer field_73251_h;

    public ChunkProviderServer(WorldServer p_i3393_1_, IChunkLoader p_i3393_2_, IChunkProvider p_i3393_3_)
    {
        field_73248_b = new HashSet();
        field_73250_a = true;
        field_73244_f = new LongHashMap();
        field_73245_g = new ArrayList();
        field_73249_c = new EmptyChunk(p_i3393_1_, 0, 0);
        field_73251_h = p_i3393_1_;
        field_73247_e = p_i3393_2_;
        field_73246_d = p_i3393_3_;
    }

    public boolean func_73149_a(int p_73149_1_, int p_73149_2_)
    {
        return field_73244_f.func_76161_b(ChunkCoordIntPair.func_77272_a(p_73149_1_, p_73149_2_));
    }

    public void func_73241_b(int p_73241_1_, int p_73241_2_)
    {
        if(field_73251_h.field_73011_w.func_76567_e())
        {
            ChunkCoordinates chunkcoordinates = field_73251_h.func_72861_E();
            int i = (p_73241_1_ * 16 + 8) - chunkcoordinates.field_71574_a;
            int j = (p_73241_2_ * 16 + 8) - chunkcoordinates.field_71573_c;
            char c = '\200';
            if(i < -c || i > c || j < -c || j > c)
            {
                field_73248_b.add(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_73241_1_, p_73241_2_)));
            }
        } else
        {
            field_73248_b.add(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_73241_1_, p_73241_2_)));
        }
    }

    public void func_73240_a()
    {
        Chunk chunk;
        for(Iterator iterator = field_73245_g.iterator(); iterator.hasNext(); func_73241_b(chunk.field_76635_g, chunk.field_76647_h))
        {
            chunk = (Chunk)iterator.next();
        }

    }

    public Chunk func_73158_c(int p_73158_1_, int p_73158_2_)
    {
        long l = ChunkCoordIntPair.func_77272_a(p_73158_1_, p_73158_2_);
        field_73248_b.remove(Long.valueOf(l));
        Chunk chunk = (Chunk)field_73244_f.func_76164_a(l);
        if(chunk == null)
        {
            chunk = func_73239_e(p_73158_1_, p_73158_2_);
            if(chunk == null)
            {
                if(field_73246_d == null)
                {
                    chunk = field_73249_c;
                } else
                {
                    chunk = field_73246_d.func_73154_d(p_73158_1_, p_73158_2_);
                }
            }
            field_73244_f.func_76163_a(l, chunk);
            field_73245_g.add(chunk);
            if(chunk != null)
            {
                chunk.func_76631_c();
            }
            chunk.func_76624_a(this, this, p_73158_1_, p_73158_2_);
        }
        return chunk;
    }

    public Chunk func_73154_d(int p_73154_1_, int p_73154_2_)
    {
        Chunk chunk = (Chunk)field_73244_f.func_76164_a(ChunkCoordIntPair.func_77272_a(p_73154_1_, p_73154_2_));
        if(chunk == null)
        {
            if(field_73251_h.field_72987_B || field_73250_a)
            {
                return func_73158_c(p_73154_1_, p_73154_2_);
            } else
            {
                return field_73249_c;
            }
        } else
        {
            return chunk;
        }
    }

    private Chunk func_73239_e(int p_73239_1_, int p_73239_2_)
    {
        if(field_73247_e == null)
        {
            return null;
        }
        try
        {
            Chunk chunk = field_73247_e.func_75815_a(field_73251_h, p_73239_1_, p_73239_2_);
            if(chunk != null)
            {
                chunk.field_76641_n = field_73251_h.func_72820_D();
            }
            return chunk;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    private void func_73243_a(Chunk p_73243_1_)
    {
        if(field_73247_e == null)
        {
            return;
        }
        try
        {
            field_73247_e.func_75819_b(field_73251_h, p_73243_1_);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_73242_b(Chunk p_73242_1_)
    {
        if(field_73247_e == null)
        {
            return;
        }
        try
        {
            p_73242_1_.field_76641_n = field_73251_h.func_72820_D();
            field_73247_e.func_75816_a(field_73251_h, p_73242_1_);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        catch(MinecraftException minecraftexception)
        {
            minecraftexception.printStackTrace();
        }
    }

    public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_)
    {
        Chunk chunk = func_73154_d(p_73153_2_, p_73153_3_);
        if(!chunk.field_76646_k)
        {
            chunk.field_76646_k = true;
            if(field_73246_d != null)
            {
                field_73246_d.func_73153_a(p_73153_1_, p_73153_2_, p_73153_3_);
                ModLoader.populateChunk(field_73246_d, p_73153_2_, p_73153_3_, field_73251_h);
                chunk.func_76630_e();
            }
        }
    }

    public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_)
    {
        int i = 0;
        for(Iterator iterator = field_73245_g.iterator(); iterator.hasNext();)
        {
            Chunk chunk = (Chunk)iterator.next();
            if(p_73151_1_)
            {
                func_73243_a(chunk);
            }
            if(chunk.func_76601_a(p_73151_1_))
            {
                func_73242_b(chunk);
                chunk.field_76643_l = false;
                if(++i == 24 && !p_73151_1_)
                {
                    return false;
                }
            }
        }

        if(p_73151_1_)
        {
            if(field_73247_e == null)
            {
                return true;
            }
            field_73247_e.func_75818_b();
        }
        return true;
    }

    public boolean func_73156_b()
    {
        if(!field_73251_h.field_73058_d)
        {
            for(int i = 0; i < 100; i++)
            {
                if(!field_73248_b.isEmpty())
                {
                    Long long1 = (Long)field_73248_b.iterator().next();
                    Chunk chunk = (Chunk)field_73244_f.func_76164_a(long1.longValue());
                    chunk.func_76623_d();
                    func_73242_b(chunk);
                    func_73243_a(chunk);
                    field_73248_b.remove(long1);
                    field_73244_f.func_76159_d(long1.longValue());
                    field_73245_g.remove(chunk);
                }
            }

            if(field_73247_e != null)
            {
                field_73247_e.func_75817_a();
            }
        }
        return field_73246_d.func_73156_b();
    }

    public boolean func_73157_c()
    {
        return !field_73251_h.field_73058_d;
    }

    public String func_73148_d()
    {
        return (new StringBuilder()).append("ServerChunkCache: ").append(field_73244_f.func_76162_a()).append(" Drop: ").append(field_73248_b.size()).toString();
    }

    public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_)
    {
        return field_73246_d.func_73155_a(p_73155_1_, p_73155_2_, p_73155_3_, p_73155_4_);
    }

    public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_)
    {
        return field_73246_d.func_73150_a(p_73150_1_, p_73150_2_, p_73150_3_, p_73150_4_, p_73150_5_);
    }

    public int func_73152_e()
    {
        return field_73244_f.func_76162_a();
    }
}
