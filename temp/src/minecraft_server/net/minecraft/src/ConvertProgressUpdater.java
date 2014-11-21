// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            IProgressUpdate

public class ConvertProgressUpdater
    implements IProgressUpdate
{

    private long field_74266_b;
    final MinecraftServer field_74267_a; /* synthetic field */

    public ConvertProgressUpdater(MinecraftServer p_i3370_1_)
    {
        field_74267_a = p_i3370_1_;
        super();
        field_74266_b = System.currentTimeMillis();
    }

    public void func_73720_a(String s)
    {
    }

    public void func_73718_a(int p_73718_1_)
    {
        if(System.currentTimeMillis() - field_74266_b >= 1000L)
        {
            field_74266_b = System.currentTimeMillis();
            MinecraftServer.field_71306_a.info((new StringBuilder()).append("Converting... ").append(p_73718_1_).append("%").toString());
        }
    }

    public void func_73719_c(String s)
    {
    }
}
