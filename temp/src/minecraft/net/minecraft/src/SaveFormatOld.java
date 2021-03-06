// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            ISaveFormat, SaveFormatComparator, WorldInfo, CompressedStreamTools, 
//            NBTTagCompound, SaveHandler, ISaveHandler, IProgressUpdate

public class SaveFormatOld
    implements ISaveFormat
{

    protected final File field_75808_a;

    public SaveFormatOld(File p_i3913_1_)
    {
        if(!p_i3913_1_.exists())
        {
            p_i3913_1_.mkdirs();
        }
        field_75808_a = p_i3913_1_;
    }

    public List func_75799_b()
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < 5; i++)
        {
            String s = (new StringBuilder()).append("World").append(i + 1).toString();
            WorldInfo worldinfo = func_75803_c(s);
            if(worldinfo != null)
            {
                arraylist.add(new SaveFormatComparator(s, "", worldinfo.func_76057_l(), worldinfo.func_76092_g(), worldinfo.func_76077_q(), false, worldinfo.func_76093_s(), worldinfo.func_76086_u()));
            }
        }

        return arraylist;
    }

    public void func_75800_d()
    {
    }

    public WorldInfo func_75803_c(String p_75803_1_)
    {
        File file = new File(field_75808_a, p_75803_1_);
        if(!file.exists())
        {
            return null;
        }
        File file1 = new File(file, "level.dat");
        if(file1.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file1));
                NBTTagCompound nbttagcompound2 = nbttagcompound.func_74775_l("Data");
                return new WorldInfo(nbttagcompound2);
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        file1 = new File(file, "level.dat_old");
        if(file1.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound1 = CompressedStreamTools.func_74796_a(new FileInputStream(file1));
                NBTTagCompound nbttagcompound3 = nbttagcompound1.func_74775_l("Data");
                return new WorldInfo(nbttagcompound3);
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
        }
        return null;
    }

    public void func_75806_a(String p_75806_1_, String p_75806_2_)
    {
        File file = new File(field_75808_a, p_75806_1_);
        if(!file.exists())
        {
            return;
        }
        File file1 = new File(file, "level.dat");
        if(file1.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file1));
                NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("Data");
                nbttagcompound1.func_74778_a("LevelName", p_75806_2_);
                CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file1));
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    public void func_75802_e(String p_75802_1_)
    {
        File file = new File(field_75808_a, p_75802_1_);
        if(!file.exists())
        {
            return;
        } else
        {
            func_75807_a(file.listFiles());
            file.delete();
            return;
        }
    }

    protected static void func_75807_a(File p_75807_0_[])
    {
        File afile[] = p_75807_0_;
        int i = afile.length;
        for(int j = 0; j < i; j++)
        {
            File file = afile[j];
            if(file.isDirectory())
            {
                System.out.println((new StringBuilder()).append("Deleting ").append(file).toString());
                func_75807_a(file.listFiles());
            }
            file.delete();
        }

    }

    public ISaveHandler func_75804_a(String p_75804_1_, boolean p_75804_2_)
    {
        return new SaveHandler(field_75808_a, p_75804_1_, p_75804_2_);
    }

    public boolean func_75801_b(String p_75801_1_)
    {
        return false;
    }

    public boolean func_75805_a(String p_75805_1_, IProgressUpdate p_75805_2_)
    {
        return false;
    }
}
