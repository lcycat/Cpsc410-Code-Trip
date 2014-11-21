// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            CommandBase, EntityPlayer, World, ICommandSender

public class CommandShowSeed extends CommandBase
{

    public CommandShowSeed()
    {
    }

    public String func_71517_b()
    {
        return "seed";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        EntityPlayer entityplayer = func_71521_c(p_71515_1_);
        p_71515_1_.func_70006_a((new StringBuilder()).append("Seed: ").append(entityplayer.field_70170_p.func_72905_C()).toString());
    }
}
