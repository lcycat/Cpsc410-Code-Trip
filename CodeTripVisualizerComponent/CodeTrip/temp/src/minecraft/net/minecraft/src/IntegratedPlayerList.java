// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            ServerConfigurationManager, EntityPlayerMP, IntegratedServer, NBTTagCompound

public class IntegratedPlayerList extends ServerConfigurationManager
{

    private NBTTagCompound field_72416_e;

    public IntegratedPlayerList(IntegratedServer p_i3125_1_)
    {
        super(p_i3125_1_);
        field_72416_e = null;
        field_72402_d = 10;
    }

    protected void func_72391_b(EntityPlayerMP p_72391_1_)
    {
        if(p_72391_1_.func_70005_c_().equals(func_72415_s().func_71214_G()))
        {
            field_72416_e = new NBTTagCompound();
            p_72391_1_.func_70109_d(field_72416_e);
        }
        super.func_72391_b(p_72391_1_);
    }

    public IntegratedServer func_72415_s()
    {
        return (IntegratedServer)super.func_72365_p();
    }

    public NBTTagCompound func_72378_q()
    {
        return field_72416_e;
    }

    public MinecraftServer func_72365_p()
    {
        return func_72415_s();
    }
}
