package net.minecraft.src;

public class ItemInWorldManager
{
    /** The world object that this object is connected to. */
    public World theWorld;

    /** The EntityPlayerMP object that this object is connected to. */
    public EntityPlayerMP thisPlayerMP;
    private EnumGameType gameType;
    private boolean field_73088_d;
    private int initialDamage;
    private int curBlockX;
    private int curBlockY;
    private int curBlockZ;
    private int curblockDamage;
    private boolean field_73097_j;
    private int field_73098_k;
    private int field_73095_l;
    private int field_73096_m;
    private int field_73093_n;
    private int field_73094_o;

    public ItemInWorldManager(World par1World)
    {
        gameType = EnumGameType.NOT_SET;
        field_73094_o = -1;
        theWorld = par1World;
    }

    public void setGameType(EnumGameType par1EnumGameType)
    {
        gameType = par1EnumGameType;
        par1EnumGameType.configurePlayerCapabilities(thisPlayerMP.capabilities);
        thisPlayerMP.sendPlayerAbilities();
    }

    public EnumGameType getGameType()
    {
        return gameType;
    }

    /**
     * Get if we are in creative game mode.
     */
    public boolean isCreative()
    {
        return gameType.isCreative();
    }

    public void func_73077_b(EnumGameType par1EnumGameType)
    {
        if (gameType == EnumGameType.NOT_SET)
        {
            gameType = par1EnumGameType;
        }

        setGameType(gameType);
    }

    public void updateBlockRemoving()
    {
        curblockDamage++;

        if (field_73097_j)
        {
            int i = curblockDamage - field_73093_n;
            int k = theWorld.getBlockId(field_73098_k, field_73095_l, field_73096_m);

            if (k == 0)
            {
                field_73097_j = false;
            }
            else
            {
                Block block1 = Block.blocksList[k];
                float f = block1.getPlayerRelativeBlockHardness(thisPlayerMP, thisPlayerMP.worldObj, field_73098_k, field_73095_l, field_73096_m) * (float)(i + 1);
                int i1 = (int)(f * 10F);

                if (i1 != field_73094_o)
                {
                    theWorld.destroyBlockInWorldPartially(thisPlayerMP.entityId, field_73098_k, field_73095_l, field_73096_m, i1);
                    field_73094_o = i1;
                }

                if (f >= 1.0F)
                {
                    field_73097_j = false;
                    tryHarvestBlock(field_73098_k, field_73095_l, field_73096_m);
                }
            }
        }
        else if (field_73088_d)
        {
            int j = theWorld.getBlockId(curBlockX, curBlockY, curBlockZ);
            Block block = Block.blocksList[j];

            if (block == null)
            {
                theWorld.destroyBlockInWorldPartially(thisPlayerMP.entityId, curBlockX, curBlockY, curBlockZ, -1);
                field_73094_o = -1;
                field_73088_d = false;
            }
            else
            {
                int l = curblockDamage - initialDamage;
                float f1 = block.getPlayerRelativeBlockHardness(thisPlayerMP, thisPlayerMP.worldObj, curBlockX, curBlockY, curBlockZ) * (float)(l + 1);
                int j1 = (int)(f1 * 10F);

                if (j1 != field_73094_o)
                {
                    theWorld.destroyBlockInWorldPartially(thisPlayerMP.entityId, curBlockX, curBlockY, curBlockZ, j1);
                    field_73094_o = j1;
                }
            }
        }
    }

    public void blockClicked(int par1, int par2, int par3, int par4)
    {
        if (gameType.isAdventure())
        {
            return;
        }

        if (isCreative())
        {
            if (!theWorld.extinguishFire(null, par1, par2, par3, par4))
            {
                tryHarvestBlock(par1, par2, par3);
            }

            return;
        }

        theWorld.extinguishFire(thisPlayerMP, par1, par2, par3, par4);
        initialDamage = curblockDamage;
        float f = 1.0F;
        int i = theWorld.getBlockId(par1, par2, par3);

        if (i > 0)
        {
            Block.blocksList[i].onBlockClicked(theWorld, par1, par2, par3, thisPlayerMP);
            f = Block.blocksList[i].getPlayerRelativeBlockHardness(thisPlayerMP, thisPlayerMP.worldObj, par1, par2, par3);
        }

        if (i > 0 && f >= 1.0F)
        {
            tryHarvestBlock(par1, par2, par3);
        }
        else
        {
            field_73088_d = true;
            curBlockX = par1;
            curBlockY = par2;
            curBlockZ = par3;
            int j = (int)(f * 10F);
            theWorld.destroyBlockInWorldPartially(thisPlayerMP.entityId, par1, par2, par3, j);
            field_73094_o = j;
        }
    }

    public void blockRemoving(int par1, int par2, int par3)
    {
        if (par1 == curBlockX && par2 == curBlockY && par3 == curBlockZ)
        {
            int i = curblockDamage - initialDamage;
            int j = theWorld.getBlockId(par1, par2, par3);

            if (j != 0)
            {
                Block block = Block.blocksList[j];
                float f = block.getPlayerRelativeBlockHardness(thisPlayerMP, thisPlayerMP.worldObj, par1, par2, par3) * (float)(i + 1);

                if (f >= 0.7F)
                {
                    field_73088_d = false;
                    theWorld.destroyBlockInWorldPartially(thisPlayerMP.entityId, par1, par2, par3, -1);
                    tryHarvestBlock(par1, par2, par3);
                }
                else if (!field_73097_j)
                {
                    field_73088_d = false;
                    field_73097_j = true;
                    field_73098_k = par1;
                    field_73095_l = par2;
                    field_73096_m = par3;
                    field_73093_n = initialDamage;
                }
            }
        }
    }

    public void func_73073_c(int par1, int par2, int par3)
    {
        field_73088_d = false;
        theWorld.destroyBlockInWorldPartially(thisPlayerMP.entityId, curBlockX, curBlockY, curBlockZ, -1);
    }

    /**
     * Removes a block and triggers the appropriate events
     */
    private boolean removeBlock(int par1, int par2, int par3)
    {
        Block block = Block.blocksList[theWorld.getBlockId(par1, par2, par3)];
        int i = theWorld.getBlockMetadata(par1, par2, par3);

        if (block != null)
        {
            block.onBlockHarvested(theWorld, par1, par2, par3, i, thisPlayerMP);
        }

        boolean flag = theWorld.setBlockWithNotify(par1, par2, par3, 0);

        if (block != null && flag)
        {
            block.onBlockDestroyedByPlayer(theWorld, par1, par2, par3, i);
        }

        return flag;
    }

    /**
     * Attempts to harvest a block at the given coordinate
     */
    public boolean tryHarvestBlock(int par1, int par2, int par3)
    {
        if (gameType.isAdventure())
        {
            return false;
        }

        int i = theWorld.getBlockId(par1, par2, par3);
        int j = theWorld.getBlockMetadata(par1, par2, par3);
        theWorld.playAuxSFXAtEntity(thisPlayerMP, 2001, par1, par2, par3, i + (theWorld.getBlockMetadata(par1, par2, par3) << 12));
        boolean flag = removeBlock(par1, par2, par3);

        if (isCreative())
        {
            thisPlayerMP.playerNetServerHandler.sendPacket(new Packet53BlockChange(par1, par2, par3, theWorld));
        }
        else
        {
            ItemStack itemstack = thisPlayerMP.getCurrentEquippedItem();
            boolean flag1 = thisPlayerMP.canHarvestBlock(Block.blocksList[i]);

            if (itemstack != null)
            {
                itemstack.func_77941_a(theWorld, i, par1, par2, par3, thisPlayerMP);

                if (itemstack.stackSize == 0)
                {
                    thisPlayerMP.destroyCurrentEquippedItem();
                }
            }

            if (flag && flag1)
            {
                Block.blocksList[i].harvestBlock(theWorld, thisPlayerMP, par1, par2, par3, j);
            }
        }

        return flag;
    }

    /**
     * Attempts to right-click use an item by the given EntityPlayer in the given World
     */
    public boolean tryUseItem(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack)
    {
        int i = par3ItemStack.stackSize;
        int j = par3ItemStack.getItemDamage();
        ItemStack itemstack = par3ItemStack.useItemRightClick(par2World, par1EntityPlayer);

        if (itemstack != par3ItemStack || itemstack != null && itemstack.stackSize != i || itemstack != null && itemstack.getMaxItemUseDuration() > 0)
        {
            par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem] = itemstack;

            if (isCreative())
            {
                itemstack.stackSize = i;
                itemstack.setItemDamage(j);
            }

            if (itemstack.stackSize == 0)
            {
                par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem] = null;
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Activate the clicked on block, otherwise use the held item. Args: player, world, itemStack, x, y, z, side,
     * xOffset, yOffset, zOffset
     */
    public boolean activateBlockOrUseItem(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int i = par2World.getBlockId(par4, par5, par6);

        if (i > 0 && Block.blocksList[i].onBlockActivated(par2World, par4, par5, par6, par1EntityPlayer, par7, par8, par9, par10))
        {
            return true;
        }

        if (par3ItemStack == null)
        {
            return false;
        }

        if (isCreative())
        {
            int j = par3ItemStack.getItemDamage();
            int k = par3ItemStack.stackSize;
            boolean flag = par3ItemStack.func_77943_a(par1EntityPlayer, par2World, par4, par5, par6, par7, par8, par9, par10);
            par3ItemStack.setItemDamage(j);
            par3ItemStack.stackSize = k;
            return flag;
        }
        else
        {
            return par3ItemStack.func_77943_a(par1EntityPlayer, par2World, par4, par5, par6, par7, par8, par9, par10);
        }
    }

    /**
     * Sets the world instance.
     */
    public void setWorld(WorldServer par1WorldServer)
    {
        theWorld = par1WorldServer;
    }
}
