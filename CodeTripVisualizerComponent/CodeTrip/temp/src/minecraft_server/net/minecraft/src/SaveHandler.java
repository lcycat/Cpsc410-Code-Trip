// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.logging.Logger;

// Referenced classes of package net.minecraft.src:
//            ISaveHandler, IPlayerFileData, MinecraftException, CompressedStreamTools, 
//            NBTTagCompound, WorldInfo, EntityPlayer, WorldProvider, 
//            IChunkLoader

public class SaveHandler
    implements ISaveHandler, IPlayerFileData
{

    private static final Logger field_75772_a = Logger.getLogger("Minecraft");
    private final File field_75770_b;
    private final File field_75771_c;
    private final File field_75768_d;
    private final long field_75769_e = System.currentTimeMillis();
    private final String field_75767_f;

    public SaveHandler(File p_i3912_1_, String p_i3912_2_, boolean p_i3912_3_)
    {
        field_75770_b = new File(p_i3912_1_, p_i3912_2_);
        field_75770_b.mkdirs();
        field_75771_c = new File(field_75770_b, "players");
        field_75768_d = new File(field_75770_b, "data");
        field_75768_d.mkdirs();
        field_75767_f = p_i3912_2_;
        if(p_i3912_3_)
        {
            field_75771_c.mkdirs();
        }
        func_75766_h();
    }

    private void func_75766_h()
    {
        try
        {
            File file = new File(field_75770_b, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));
            try
            {
                dataoutputstream.writeLong(field_75769_e);
            }
            finally
            {
                dataoutputstream.close();
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }

    protected File func_75765_b()
    {
        return field_75770_b;
    }

    public void func_75762_c()
        throws MinecraftException
    {
        try
        {
            File file = new File(field_75770_b, "session.lock");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            try
            {
                if(datainputstream.readLong() != field_75769_e)
                {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
            finally
            {
                datainputstream.close();
            }
        }
        catch(IOException ioexception)
        {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    public IChunkLoader func_75763_a(WorldProvider p_75763_1_)
    {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }

    public WorldInfo func_75757_d()
    {
        File file = new File(field_75770_b, "level.dat");
        if(file.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
                NBTTagCompound nbttagcompound2 = nbttagcompound.func_74775_l("Data");
                return new WorldInfo(nbttagcompound2);
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        file = new File(field_75770_b, "level.dat_old");
        if(file.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound1 = CompressedStreamTools.func_74796_a(new FileInputStream(file));
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

    public void func_75755_a(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_)
    {
        NBTTagCompound nbttagcompound = p_75755_1_.func_76082_a(p_75755_2_);
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.func_74782_a("Data", nbttagcompound);
        try
        {
            File file = new File(field_75770_b, "level.dat_new");
            File file1 = new File(field_75770_b, "level.dat_old");
            File file2 = new File(field_75770_b, "level.dat");
            CompressedStreamTools.func_74799_a(nbttagcompound1, new FileOutputStream(file));
            if(file1.exists())
            {
                file1.delete();
            }
            file2.renameTo(file1);
            if(file2.exists())
            {
                file2.delete();
            }
            file.renameTo(file2);
            if(file.exists())
            {
                file.delete();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_75761_a(WorldInfo p_75761_1_)
    {
        NBTTagCompound nbttagcompound = p_75761_1_.func_76066_a();
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.func_74782_a("Data", nbttagcompound);
        try
        {
            File file = new File(field_75770_b, "level.dat_new");
            File file1 = new File(field_75770_b, "level.dat_old");
            File file2 = new File(field_75770_b, "level.dat");
            CompressedStreamTools.func_74799_a(nbttagcompound1, new FileOutputStream(file));
            if(file1.exists())
            {
                file1.delete();
            }
            file2.renameTo(file1);
            if(file2.exists())
            {
                file2.delete();
            }
            file.renameTo(file2);
            if(file.exists())
            {
                file.delete();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_75753_a(EntityPlayer p_75753_1_)
    {
        try
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            p_75753_1_.func_70109_d(nbttagcompound);
            File file = new File(field_75771_c, (new StringBuilder()).append(p_75753_1_.field_71092_bJ).append(".dat.tmp").toString());
            File file1 = new File(field_75771_c, (new StringBuilder()).append(p_75753_1_.field_71092_bJ).append(".dat").toString());
            CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
            if(file1.exists())
            {
                file1.delete();
            }
            file.renameTo(file1);
        }
        catch(Exception exception)
        {
            field_75772_a.warning((new StringBuilder()).append("Failed to save player data for ").append(p_75753_1_.field_71092_bJ).toString());
        }
    }

    public void func_75752_b(EntityPlayer p_75752_1_)
    {
        NBTTagCompound nbttagcompound = func_75764_a(p_75752_1_.field_71092_bJ);
        if(nbttagcompound != null)
        {
            p_75752_1_.func_70020_e(nbttagcompound);
        }
    }

    public NBTTagCompound func_75764_a(String p_75764_1_)
    {
        try
        {
            File file = new File(field_75771_c, (new StringBuilder()).append(p_75764_1_).append(".dat").toString());
            if(file.exists())
            {
                return CompressedStreamTools.func_74796_a(new FileInputStream(file));
            }
        }
        catch(Exception exception)
        {
            field_75772_a.warning((new StringBuilder()).append("Failed to load player data for ").append(p_75764_1_).toString());
        }
        return null;
    }

    public IPlayerFileData func_75756_e()
    {
        return this;
    }

    public String[] func_75754_f()
    {
        String as[] = field_75771_c.list();
        for(int i = 0; i < as.length; i++)
        {
            if(as[i].endsWith(".dat"))
            {
                as[i] = as[i].substring(0, as[i].length() - 4);
            }
        }

        return as;
    }

    public void func_75759_a()
    {
    }

    public File func_75758_b(String p_75758_1_)
    {
        return new File(field_75768_d, (new StringBuilder()).append(p_75758_1_).append(".dat").toString());
    }

    public String func_75760_g()
    {
        return field_75767_f;
    }

}
