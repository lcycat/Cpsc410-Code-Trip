// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IThreadedFileIO, IChunkLoader, ChunkCoordIntPair, AnvilChunkLoaderPending, 
//            RegionFileCache, CompressedStreamTools, NBTTagCompound, Chunk, 
//            MinecraftException, World, ThreadedFileIOBase, NBTTagList, 
//            ExtendedBlockStorage, NibbleArray, Entity, TileEntity, 
//            NextTickListEntry, EntityList

public class AnvilChunkLoader
    implements IThreadedFileIO, IChunkLoader
{

    private List field_75828_a;
    private Set field_75826_b;
    private Object field_75827_c;
    private final File field_75825_d;

    public AnvilChunkLoader(File p_i3779_1_)
    {
        field_75828_a = new ArrayList();
        field_75826_b = new HashSet();
        field_75827_c = new Object();
        field_75825_d = p_i3779_1_;
    }

    public Chunk func_75815_a(World p_75815_1_, int p_75815_2_, int p_75815_3_)
        throws IOException
    {
        NBTTagCompound nbttagcompound;
        nbttagcompound = null;
        ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(p_75815_2_, p_75815_3_);
        synchronized(field_75827_c)
        {
label0:
            {
                if(!field_75826_b.contains(chunkcoordintpair))
                {
                    break label0;
                }
                Iterator iterator = field_75828_a.iterator();
                AnvilChunkLoaderPending anvilchunkloaderpending;
                do
                {
                    if(!iterator.hasNext())
                    {
                        break label0;
                    }
                    anvilchunkloaderpending = (AnvilChunkLoaderPending)iterator.next();
                } while(!anvilchunkloaderpending.field_76548_a.equals(chunkcoordintpair));
                nbttagcompound = anvilchunkloaderpending.field_76547_b;
            }
        }
        break MISSING_BLOCK_LABEL_109;
        exception;
        throw exception;
        if(nbttagcompound == null)
        {
            java.io.DataInputStream datainputstream = RegionFileCache.func_76549_c(field_75825_d, p_75815_2_, p_75815_3_);
            if(datainputstream != null)
            {
                nbttagcompound = CompressedStreamTools.func_74794_a(datainputstream);
            } else
            {
                return null;
            }
        }
        return func_75822_a(p_75815_1_, p_75815_2_, p_75815_3_, nbttagcompound);
    }

    protected Chunk func_75822_a(World p_75822_1_, int p_75822_2_, int p_75822_3_, NBTTagCompound p_75822_4_)
    {
        if(!p_75822_4_.func_74764_b("Level"))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(p_75822_2_).append(",").append(p_75822_3_).append(" is missing level data, skipping").toString());
            return null;
        }
        if(!p_75822_4_.func_74775_l("Level").func_74764_b("Sections"))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(p_75822_2_).append(",").append(p_75822_3_).append(" is missing block data, skipping").toString());
            return null;
        }
        Chunk chunk = func_75823_a(p_75822_1_, p_75822_4_.func_74775_l("Level"));
        if(!chunk.func_76600_a(p_75822_2_, p_75822_3_))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(p_75822_2_).append(",").append(p_75822_3_).append(" is in the wrong location; relocating. (Expected ").append(p_75822_2_).append(", ").append(p_75822_3_).append(", got ").append(chunk.field_76635_g).append(", ").append(chunk.field_76647_h).append(")").toString());
            p_75822_4_.func_74768_a("xPos", p_75822_2_);
            p_75822_4_.func_74768_a("zPos", p_75822_3_);
            chunk = func_75823_a(p_75822_1_, p_75822_4_.func_74775_l("Level"));
        }
        return chunk;
    }

    public void func_75816_a(World p_75816_1_, Chunk p_75816_2_)
        throws MinecraftException, IOException
    {
        p_75816_1_.func_72906_B();
        try
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound.func_74782_a("Level", nbttagcompound1);
            func_75820_a(p_75816_2_, p_75816_1_, nbttagcompound1);
            func_75824_a(p_75816_2_.func_76632_l(), nbttagcompound);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    protected void func_75824_a(ChunkCoordIntPair p_75824_1_, NBTTagCompound p_75824_2_)
    {
        synchronized(field_75827_c)
        {
            if(field_75826_b.contains(p_75824_1_))
            {
                for(int i = 0; i < field_75828_a.size(); i++)
                {
                    if(((AnvilChunkLoaderPending)field_75828_a.get(i)).field_76548_a.equals(p_75824_1_))
                    {
                        field_75828_a.set(i, new AnvilChunkLoaderPending(p_75824_1_, p_75824_2_));
                        return;
                    }
                }

            }
            field_75828_a.add(new AnvilChunkLoaderPending(p_75824_1_, p_75824_2_));
            field_75826_b.add(p_75824_1_);
            ThreadedFileIOBase.field_75741_a.func_75735_a(this);
        }
    }

    public boolean func_75814_c()
    {
        AnvilChunkLoaderPending anvilchunkloaderpending = null;
        synchronized(field_75827_c)
        {
            if(!field_75828_a.isEmpty())
            {
                anvilchunkloaderpending = (AnvilChunkLoaderPending)field_75828_a.remove(0);
                field_75826_b.remove(anvilchunkloaderpending.field_76548_a);
            } else
            {
                return false;
            }
        }
        if(anvilchunkloaderpending != null)
        {
            try
            {
                func_75821_a(anvilchunkloaderpending);
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        return true;
    }

    private void func_75821_a(AnvilChunkLoaderPending p_75821_1_)
        throws IOException
    {
        DataOutputStream dataoutputstream = RegionFileCache.func_76552_d(field_75825_d, p_75821_1_.field_76548_a.field_77276_a, p_75821_1_.field_76548_a.field_77275_b);
        CompressedStreamTools.func_74800_a(p_75821_1_.field_76547_b, dataoutputstream);
        dataoutputstream.close();
    }

    public void func_75819_b(World world, Chunk chunk)
    {
    }

    public void func_75817_a()
    {
    }

    public void func_75818_b()
    {
    }

    private void func_75820_a(Chunk p_75820_1_, World p_75820_2_, NBTTagCompound p_75820_3_)
    {
        p_75820_3_.func_74768_a("xPos", p_75820_1_.field_76635_g);
        p_75820_3_.func_74768_a("zPos", p_75820_1_.field_76647_h);
        p_75820_3_.func_74772_a("LastUpdate", p_75820_2_.func_72820_D());
        p_75820_3_.func_74783_a("HeightMap", p_75820_1_.field_76634_f);
        p_75820_3_.func_74757_a("TerrainPopulated", p_75820_1_.field_76646_k);
        ExtendedBlockStorage aextendedblockstorage[] = p_75820_1_.func_76587_i();
        NBTTagList nbttaglist = new NBTTagList("Sections");
        ExtendedBlockStorage aextendedblockstorage1[] = aextendedblockstorage;
        int i = aextendedblockstorage1.length;
        for(int k = 0; k < i; k++)
        {
            ExtendedBlockStorage extendedblockstorage = aextendedblockstorage1[k];
            if(extendedblockstorage == null)
            {
                continue;
            }
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.func_74774_a("Y", (byte)(extendedblockstorage.func_76662_d() >> 4 & 0xff));
            nbttagcompound.func_74773_a("Blocks", extendedblockstorage.func_76658_g());
            if(extendedblockstorage.func_76660_i() != null)
            {
                nbttagcompound.func_74773_a("Add", extendedblockstorage.func_76660_i().field_76585_a);
            }
            nbttagcompound.func_74773_a("Data", extendedblockstorage.func_76669_j().field_76585_a);
            nbttagcompound.func_74773_a("SkyLight", extendedblockstorage.func_76671_l().field_76585_a);
            nbttagcompound.func_74773_a("BlockLight", extendedblockstorage.func_76661_k().field_76585_a);
            nbttaglist.func_74742_a(nbttagcompound);
        }

        p_75820_3_.func_74782_a("Sections", nbttaglist);
        p_75820_3_.func_74773_a("Biomes", p_75820_1_.func_76605_m());
        p_75820_1_.field_76644_m = false;
        NBTTagList nbttaglist1 = new NBTTagList();
label0:
        for(int j = 0; j < p_75820_1_.field_76645_j.length; j++)
        {
            Iterator iterator = p_75820_1_.field_76645_j[j].iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    continue label0;
                }
                Entity entity = (Entity)iterator.next();
                p_75820_1_.field_76644_m = true;
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                if(entity.func_70039_c(nbttagcompound1))
                {
                    nbttaglist1.func_74742_a(nbttagcompound1);
                }
            } while(true);
        }

        p_75820_3_.func_74782_a("Entities", nbttaglist1);
        NBTTagList nbttaglist2 = new NBTTagList();
        NBTTagCompound nbttagcompound2;
        for(Iterator iterator1 = p_75820_1_.field_76648_i.values().iterator(); iterator1.hasNext(); nbttaglist2.func_74742_a(nbttagcompound2))
        {
            TileEntity tileentity = (TileEntity)iterator1.next();
            nbttagcompound2 = new NBTTagCompound();
            tileentity.func_70310_b(nbttagcompound2);
        }

        p_75820_3_.func_74782_a("TileEntities", nbttaglist2);
        List list = p_75820_2_.func_72920_a(p_75820_1_, false);
        if(list != null)
        {
            long l = p_75820_2_.func_72820_D();
            NBTTagList nbttaglist3 = new NBTTagList();
            NBTTagCompound nbttagcompound3;
            for(Iterator iterator2 = list.iterator(); iterator2.hasNext(); nbttaglist3.func_74742_a(nbttagcompound3))
            {
                NextTickListEntry nextticklistentry = (NextTickListEntry)iterator2.next();
                nbttagcompound3 = new NBTTagCompound();
                nbttagcompound3.func_74768_a("i", nextticklistentry.field_77179_d);
                nbttagcompound3.func_74768_a("x", nextticklistentry.field_77183_a);
                nbttagcompound3.func_74768_a("y", nextticklistentry.field_77181_b);
                nbttagcompound3.func_74768_a("z", nextticklistentry.field_77182_c);
                nbttagcompound3.func_74768_a("t", (int)(nextticklistentry.field_77180_e - l));
            }

            p_75820_3_.func_74782_a("TileTicks", nbttaglist3);
        }
    }

    private Chunk func_75823_a(World p_75823_1_, NBTTagCompound p_75823_2_)
    {
        int i = p_75823_2_.func_74762_e("xPos");
        int j = p_75823_2_.func_74762_e("zPos");
        Chunk chunk = new Chunk(p_75823_1_, i, j);
        chunk.field_76634_f = p_75823_2_.func_74759_k("HeightMap");
        chunk.field_76646_k = p_75823_2_.func_74767_n("TerrainPopulated");
        NBTTagList nbttaglist = p_75823_2_.func_74761_m("Sections");
        byte byte0 = 16;
        ExtendedBlockStorage aextendedblockstorage[] = new ExtendedBlockStorage[byte0];
        for(int k = 0; k < nbttaglist.func_74745_c(); k++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_74743_b(k);
            byte byte1 = nbttagcompound.func_74771_c("Y");
            ExtendedBlockStorage extendedblockstorage = new ExtendedBlockStorage(byte1 << 4);
            extendedblockstorage.func_76664_a(nbttagcompound.func_74770_j("Blocks"));
            if(nbttagcompound.func_74764_b("Add"))
            {
                extendedblockstorage.func_76673_a(new NibbleArray(nbttagcompound.func_74770_j("Add"), 4));
            }
            extendedblockstorage.func_76668_b(new NibbleArray(nbttagcompound.func_74770_j("Data"), 4));
            extendedblockstorage.func_76666_d(new NibbleArray(nbttagcompound.func_74770_j("SkyLight"), 4));
            extendedblockstorage.func_76659_c(new NibbleArray(nbttagcompound.func_74770_j("BlockLight"), 4));
            extendedblockstorage.func_76672_e();
            aextendedblockstorage[byte1] = extendedblockstorage;
        }

        chunk.func_76602_a(aextendedblockstorage);
        if(p_75823_2_.func_74764_b("Biomes"))
        {
            chunk.func_76616_a(p_75823_2_.func_74770_j("Biomes"));
        }
        NBTTagList nbttaglist1 = p_75823_2_.func_74761_m("Entities");
        if(nbttaglist1 != null)
        {
            for(int l = 0; l < nbttaglist1.func_74745_c(); l++)
            {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist1.func_74743_b(l);
                Entity entity = EntityList.func_75615_a(nbttagcompound1, p_75823_1_);
                chunk.field_76644_m = true;
                if(entity != null)
                {
                    chunk.func_76612_a(entity);
                }
            }

        }
        NBTTagList nbttaglist2 = p_75823_2_.func_74761_m("TileEntities");
        if(nbttaglist2 != null)
        {
            for(int i1 = 0; i1 < nbttaglist2.func_74745_c(); i1++)
            {
                NBTTagCompound nbttagcompound2 = (NBTTagCompound)nbttaglist2.func_74743_b(i1);
                TileEntity tileentity = TileEntity.func_70317_c(nbttagcompound2);
                if(tileentity != null)
                {
                    chunk.func_76620_a(tileentity);
                }
            }

        }
        if(p_75823_2_.func_74764_b("TileTicks"))
        {
            NBTTagList nbttaglist3 = p_75823_2_.func_74761_m("TileTicks");
            if(nbttaglist3 != null)
            {
                for(int j1 = 0; j1 < nbttaglist3.func_74745_c(); j1++)
                {
                    NBTTagCompound nbttagcompound3 = (NBTTagCompound)nbttaglist3.func_74743_b(j1);
                    p_75823_1_.func_72892_b(nbttagcompound3.func_74762_e("x"), nbttagcompound3.func_74762_e("y"), nbttagcompound3.func_74762_e("z"), nbttagcompound3.func_74762_e("i"), nbttagcompound3.func_74762_e("t"));
                }

            }
        }
        return chunk;
    }
}
