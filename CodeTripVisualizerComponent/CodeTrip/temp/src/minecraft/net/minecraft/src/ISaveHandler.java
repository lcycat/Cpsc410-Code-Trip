// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;

// Referenced classes of package net.minecraft.src:
//            MinecraftException, WorldInfo, WorldProvider, IChunkLoader, 
//            NBTTagCompound, IPlayerFileData

public interface ISaveHandler
{

    public abstract WorldInfo func_75757_d();

    public abstract void func_75762_c()
        throws MinecraftException;

    public abstract IChunkLoader func_75763_a(WorldProvider worldprovider);

    public abstract void func_75755_a(WorldInfo worldinfo, NBTTagCompound nbttagcompound);

    public abstract void func_75761_a(WorldInfo worldinfo);

    public abstract IPlayerFileData func_75756_e();

    public abstract void func_75759_a();

    public abstract File func_75758_b(String s);

    public abstract String func_75760_g();
}
