// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Chunk, IProgressUpdate, EnumCreatureType, World, 
//            ChunkPosition

public interface IChunkProvider
{

    public abstract boolean func_73149_a(int i, int j);

    public abstract Chunk func_73154_d(int i, int j);

    public abstract Chunk func_73158_c(int i, int j);

    public abstract void func_73153_a(IChunkProvider ichunkprovider, int i, int j);

    public abstract boolean func_73151_a(boolean flag, IProgressUpdate iprogressupdate);

    public abstract boolean func_73156_b();

    public abstract boolean func_73157_c();

    public abstract String func_73148_d();

    public abstract List func_73155_a(EnumCreatureType enumcreaturetype, int i, int j, int k);

    public abstract ChunkPosition func_73150_a(World world, String s, int i, int j, int k);

    public abstract int func_73152_e();
}
