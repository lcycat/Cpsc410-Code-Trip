// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            CommandBase, DamageSource, EntityPlayer, ICommandSender

public class CommandKill extends CommandBase
{

    public CommandKill()
    {
    }

    public String func_71517_b()
    {
        return "kill";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        EntityPlayer entityplayer = func_71521_c(p_71515_1_);
        entityplayer.func_70097_a(DamageSource.field_76380_i, 1000);
        p_71515_1_.func_70006_a("Ouch. That look like it hurt.");
    }
}
