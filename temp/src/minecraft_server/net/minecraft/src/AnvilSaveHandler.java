// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;

// Referenced classes of package net.minecraft.src:
//            SaveHandler, WorldProviderHell, AnvilChunkLoader, WorldProviderEnd, 
//            WorldInfo, ThreadedFileIOBase, RegionFileCache, WorldProvider, 
//            IChunkLoader, NBTTagCompound

public class AnvilSaveHandler extends SaveHandler
{

    public AnvilSaveHandler(File p_i3908_1_, String p_i3908_2_, boolean p_i3908_3_)
    {
        super(p_i3908_1_, p_i3908_2_, p_i3908_3_);
    }

    public IChunkLoader func_75763_a(WorldProvider p_75763_1_)
    {
        File file = func_75765_b();
        if(p_75763_1_ instanceof WorldProviderHell)
        {
            File file1 = new File(file, "DIM-1");
            file1.mkdirs();
            return new AnvilChunkLoader(file1);
        }
        if(p_75763_1_ instanceof WorldProviderEnd)
        {
            File file2 = new File(file, "DIM1");
            file2.mkdirs();
            return new AnvilChunkLoader(file2);
        } else
        {
            return new AnvilChunkLoader(file);
        }
    }

    public void func_75755_a(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_)
    {
        p_75755_1_.func_76078_e(19133);
        super.func_75755_a(p_75755_1_, p_75755_2_);
    }

    public void func_75759_a()
    {
        try
        {
            ThreadedFileIOBase.field_75741_a.func_75734_a();
        }
        catch(InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        RegionFileCache.func_76551_a();
    }
}
