package net.minecraft.src;

public class CommandKill extends CommandBase
{
    public CommandKill()
    {
    }

    public String getCommandName()
    {
        return "kill";
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        EntityPlayer entityplayer = getCommandSenderAsPlayer(par1ICommandSender);
        entityplayer.attackEntityFrom(DamageSource.outOfWorld, 1000);
        par1ICommandSender.func_70006_a("Ouch. That look like it hurt.");
    }
}
