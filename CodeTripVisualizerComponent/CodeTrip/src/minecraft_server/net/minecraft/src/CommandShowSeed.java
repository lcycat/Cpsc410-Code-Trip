package net.minecraft.src;

public class CommandShowSeed extends CommandBase
{
    public CommandShowSeed()
    {
    }

    public String getCommandName()
    {
        return "seed";
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        EntityPlayer entityplayer = getCommandSenderAsPlayer(par1ICommandSender);
        par1ICommandSender.func_70006_a((new StringBuilder()).append("Seed: ").append(entityplayer.worldObj.getSeed()).toString());
    }
}
