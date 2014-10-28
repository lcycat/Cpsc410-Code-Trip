// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            SaveFormatOld, RegionFileCache, AnvilSaveHandler, WorldInfo, 
//            IProgressUpdate, WorldType, WorldChunkManagerHell, BiomeGenBase, 
//            WorldChunkManager, ISaveHandler, RegionFile, CompressedStreamTools, 
//            NBTTagCompound, ChunkLoader, AnvilSaveConverterFileFilter

public class AnvilSaveConverter extends SaveFormatOld
{

    public AnvilSaveConverter(File p_i3910_1_)
    {
        super(p_i3910_1_);
    }

    protected int func_75812_c()
    {
        return 19133;
    }

    public void func_75800_d()
    {
        RegionFileCache.func_76551_a();
    }

    public ISaveHandler func_75804_a(String p_75804_1_, boolean p_75804_2_)
    {
        return new AnvilSaveHandler(field_75808_a, p_75804_1_, p_75804_2_);
    }

    public boolean func_75801_b(String p_75801_1_)
    {
        WorldInfo worldinfo = func_75803_c(p_75801_1_);
        return worldinfo != null && worldinfo.func_76088_k() != func_75812_c();
    }

    public boolean func_75805_a(String p_75805_1_, IProgressUpdate p_75805_2_)
    {
        p_75805_2_.func_73718_a(0);
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        File file = new File(field_75808_a, p_75805_1_);
        File file1 = new File(file, "DIM-1");
        File file2 = new File(file, "DIM1");
        System.out.println("Scanning folders...");
        func_75810_a(file, arraylist);
        if(file1.exists())
        {
            func_75810_a(file1, arraylist1);
        }
        if(file2.exists())
        {
            func_75810_a(file2, arraylist2);
        }
        int i = arraylist.size() + arraylist1.size() + arraylist2.size();
        System.out.println((new StringBuilder()).append("Total conversion count is ").append(i).toString());
        WorldInfo worldinfo = func_75803_c(p_75805_1_);
        Object obj = null;
        if(worldinfo.func_76067_t() == WorldType.field_77138_c)
        {
            obj = new WorldChunkManagerHell(BiomeGenBase.field_76772_c, 0.5F, 0.5F);
        } else
        {
            obj = new WorldChunkManager(worldinfo.func_76063_b(), worldinfo.func_76067_t());
        }
        func_75813_a(new File(file, "region"), arraylist, ((WorldChunkManager) (obj)), 0, i, p_75805_2_);
        func_75813_a(new File(file1, "region"), arraylist1, new WorldChunkManagerHell(BiomeGenBase.field_76778_j, 1.0F, 0.0F), arraylist.size(), i, p_75805_2_);
        func_75813_a(new File(file2, "region"), arraylist2, new WorldChunkManagerHell(BiomeGenBase.field_76779_k, 0.5F, 0.0F), arraylist.size() + arraylist1.size(), i, p_75805_2_);
        worldinfo.func_76078_e(19133);
        if(worldinfo.func_76067_t() == WorldType.field_77136_e)
        {
            worldinfo.func_76085_a(WorldType.field_77137_b);
        }
        func_75809_f(p_75805_1_);
        ISaveHandler isavehandler = func_75804_a(p_75805_1_, false);
        isavehandler.func_75761_a(worldinfo);
        return true;
    }

    private void func_75809_f(String p_75809_1_)
    {
        File file = new File(field_75808_a, p_75809_1_);
        if(!file.exists())
        {
            System.out.println("Warning: Unable to create level.dat_mcr backup");
            return;
        }
        File file1 = new File(file, "level.dat");
        if(!file1.exists())
        {
            System.out.println("Warning: Unable to create level.dat_mcr backup");
            return;
        }
        File file2 = new File(file, "level.dat_mcr");
        if(!file1.renameTo(file2))
        {
            System.out.println("Warning: Unable to create level.dat_mcr backup");
        }
    }

    private void func_75813_a(File p_75813_1_, Iterable p_75813_2_, WorldChunkManager p_75813_3_, int p_75813_4_, int p_75813_5_, IProgressUpdate p_75813_6_)
    {
        int i;
        for(Iterator iterator = p_75813_2_.iterator(); iterator.hasNext(); p_75813_6_.func_73718_a(i))
        {
            File file = (File)iterator.next();
            func_75811_a(p_75813_1_, file, p_75813_3_, p_75813_4_, p_75813_5_, p_75813_6_);
            p_75813_4_++;
            i = (int)Math.round((100D * (double)p_75813_4_) / (double)p_75813_5_);
        }

    }

    private void func_75811_a(File p_75811_1_, File p_75811_2_, WorldChunkManager p_75811_3_, int p_75811_4_, int p_75811_5_, IProgressUpdate p_75811_6_)
    {
        try
        {
            String s = p_75811_2_.getName();
            RegionFile regionfile = new RegionFile(p_75811_2_);
            RegionFile regionfile1 = new RegionFile(new File(p_75811_1_, (new StringBuilder()).append(s.substring(0, s.length() - ".mcr".length())).append(".mca").toString()));
            for(int i = 0; i < 32; i++)
            {
                for(int j = 0; j < 32; j++)
                {
                    if(!regionfile.func_76709_c(i, j) || regionfile1.func_76709_c(i, j))
                    {
                        continue;
                    }
                    DataInputStream datainputstream = regionfile.func_76704_a(i, j);
                    if(datainputstream == null)
                    {
                        System.out.println("Failed to fetch input stream");
                    } else
                    {
                        NBTTagCompound nbttagcompound = CompressedStreamTools.func_74794_a(datainputstream);
                        datainputstream.close();
                        NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("Level");
                        AnvilConverterData anvilconverterdata = ChunkLoader.func_76691_a(nbttagcompound1);
                        NBTTagCompound nbttagcompound2 = new NBTTagCompound();
                        NBTTagCompound nbttagcompound3 = new NBTTagCompound();
                        nbttagcompound2.func_74782_a("Level", nbttagcompound3);
                        ChunkLoader.func_76690_a(anvilconverterdata, nbttagcompound3, p_75811_3_);
                        DataOutputStream dataoutputstream = regionfile1.func_76710_b(i, j);
                        CompressedStreamTools.func_74800_a(nbttagcompound2, dataoutputstream);
                        dataoutputstream.close();
                    }
                }

                int k = (int)Math.round((100D * (double)(p_75811_4_ * 1024)) / (double)(p_75811_5_ * 1024));
                int l = (int)Math.round((100D * (double)((i + 1) * 32 + p_75811_4_ * 1024)) / (double)(p_75811_5_ * 1024));
                if(l > k)
                {
                    p_75811_6_.func_73718_a(l);
                }
            }

            regionfile.func_76708_c();
            regionfile1.func_76708_c();
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private void func_75810_a(File p_75810_1_, Collection p_75810_2_)
    {
        File file = new File(p_75810_1_, "region");
        File afile[] = file.listFiles(new AnvilSaveConverterFileFilter(this));
        if(afile != null)
        {
            Collections.addAll(p_75810_2_, afile);
        }
    }
}
