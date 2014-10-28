// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            BaseMod, ModLoaderMp, Packet230ModLoader, GuiScreen

public abstract class BaseModMp extends BaseMod
{

    public BaseModMp()
    {
    }

    public final int getId()
    {
        return toString().hashCode();
    }

    public void modsLoaded()
    {
        ModLoaderMp.initialize();
        super.modsLoaded();
    }

    public void handlePacket(Packet230ModLoader packet230modloader)
    {
    }

    public void handleTileEntityPacket(int i, int j, int k, int l, int ai[], float af[], String as[])
    {
    }

    public GuiScreen handleGUI(int i)
    {
        return null;
    }
}
