package net.minecraft.src;

public class DemoWorldManager extends ItemInWorldManager
{
    private boolean field_73105_c;
    private boolean demoTimeExpired;
    private int field_73104_e;
    private int field_73102_f;

    public DemoWorldManager(World par1World)
    {
        super(par1World);
        field_73105_c = false;
        demoTimeExpired = false;
        field_73104_e = 0;
        field_73102_f = 0;
    }

    public void updateBlockRemoving()
    {
        super.updateBlockRemoving();
        field_73102_f++;
        long l = theWorld.getWorldTime();
        long l1 = l / 24000L + 1L;

        if (!field_73105_c && field_73102_f > 20)
        {
            field_73105_c = true;
            thisPlayerMP.playerNetServerHandler.sendPacket(new Packet70GameEvent(5, 0));
        }

        demoTimeExpired = l > 0x1d6b4L;

        if (demoTimeExpired)
        {
            field_73104_e++;
        }

        if (l % 24000L == 500L)
        {
            if (l1 <= 6L)
            {
                thisPlayerMP.func_70006_a(thisPlayerMP.translateString((new StringBuilder()).append("demo.day.").append(l1).toString(), new Object[0]));
            }
        }
        else if (l1 == 1L)
        {
            if (l == 100L)
            {
                thisPlayerMP.playerNetServerHandler.sendPacket(new Packet70GameEvent(5, 101));
            }
            else if (l == 175L)
            {
                thisPlayerMP.playerNetServerHandler.sendPacket(new Packet70GameEvent(5, 102));
            }
            else if (l == 250L)
            {
                thisPlayerMP.playerNetServerHandler.sendPacket(new Packet70GameEvent(5, 103));
            }
        }
        else if (l1 == 5L && l % 24000L == 22000L)
        {
            thisPlayerMP.func_70006_a(thisPlayerMP.translateString("demo.day.warning", new Object[0]));
        }
    }

    /**
     * Sends a message to the player reminding them that this is the demo version
     */
    private void sendDemoReminder()
    {
        if (field_73104_e > 100)
        {
            thisPlayerMP.func_70006_a(thisPlayerMP.translateString("demo.reminder", new Object[0]));
            field_73104_e = 0;
        }
    }

    public void blockClicked(int par1, int par2, int par3, int par4)
    {
        if (demoTimeExpired)
        {
            sendDemoReminder();
            return;
        }
        else
        {
            super.blockClicked(par1, par2, par3, par4);
            return;
        }
    }

    public void blockRemoving(int par1, int par2, int par3)
    {
        if (demoTimeExpired)
        {
            return;
        }
        else
        {
            super.blockRemoving(par1, par2, par3);
            return;
        }
    }

    /**
     * Attempts to harvest a block at the given coordinate
     */
    public boolean tryHarvestBlock(int par1, int par2, int par3)
    {
        if (demoTimeExpired)
        {
            return false;
        }
        else
        {
            return super.tryHarvestBlock(par1, par2, par3);
        }
    }

    /**
     * Attempts to right-click use an item by the given EntityPlayer in the given World
     */
    public boolean tryUseItem(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack)
    {
        if (demoTimeExpired)
        {
            sendDemoReminder();
            return false;
        }
        else
        {
            return super.tryUseItem(par1EntityPlayer, par2World, par3ItemStack);
        }
    }

    /**
     * Activate the clicked on block, otherwise use the held item. Args: player, world, itemStack, x, y, z, side,
     * xOffset, yOffset, zOffset
     */
    public boolean activateBlockOrUseItem(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (demoTimeExpired)
        {
            sendDemoReminder();
            return false;
        }
        else
        {
            return super.activateBlockOrUseItem(par1EntityPlayer, par2World, par3ItemStack, par4, par5, par6, par7, par8, par9, par10);
        }
    }
}
