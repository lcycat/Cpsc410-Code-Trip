// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            WorldServer, DerivedWorldInfo, MinecraftException, ISaveHandler, 
//            WorldSettings, Profiler

public class WorldServerMulti extends WorldServer
{

    public WorldServerMulti(MinecraftServer p_i3388_1_, ISaveHandler p_i3388_2_, String p_i3388_3_, int p_i3388_4_, WorldSettings p_i3388_5_, WorldServer p_i3388_6_, Profiler p_i3388_7_)
    {
        super(p_i3388_1_, p_i3388_2_, p_i3388_3_, p_i3388_4_, p_i3388_5_, p_i3388_7_);
        field_72988_C = p_i3388_6_.field_72988_C;
        field_72986_A = new DerivedWorldInfo(p_i3388_6_.func_72912_H());
    }

    protected void func_73042_a()
        throws MinecraftException
    {
    }
}
