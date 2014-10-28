// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;

// Referenced classes of package net.minecraft.src:
//            MinecraftException, World, Chunk

public interface IChunkLoader
{

    public abstract Chunk func_75815_a(World world, int i, int j)
        throws IOException;

    public abstract void func_75816_a(World world, Chunk chunk)
        throws MinecraftException, IOException;

    public abstract void func_75819_b(World world, Chunk chunk);

    public abstract void func_75817_a();

    public abstract void func_75818_b();
}
