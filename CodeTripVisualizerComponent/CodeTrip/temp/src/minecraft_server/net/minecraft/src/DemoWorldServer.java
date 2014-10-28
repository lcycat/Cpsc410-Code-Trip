// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            WorldServer, WorldSettings, EnumGameType, WorldType, 
//            ISaveHandler, Profiler

public class DemoWorldServer extends WorldServer
{

    private static final long field_73072_L;
    public static final WorldSettings field_73071_a;

    public DemoWorldServer(MinecraftServer p_i3386_1_, ISaveHandler p_i3386_2_, String p_i3386_3_, int p_i3386_4_, Profiler p_i3386_5_)
    {
        super(p_i3386_1_, p_i3386_2_, p_i3386_3_, p_i3386_4_, field_73071_a, p_i3386_5_);
    }

    static 
    {
        field_73072_L = "North Carolina".hashCode();
        field_73071_a = (new WorldSettings(field_73072_L, EnumGameType.SURVIVAL, true, false, WorldType.field_77137_b)).func_77159_a();
    }
}
