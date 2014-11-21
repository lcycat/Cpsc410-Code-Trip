package net.minecraft.src;

public class ItemInWorldManager
{
    /** The world object that this object is connected to. */
    public World theWorld;
    public EntityPlayerMP field_73090_b;
    private EnumGameType gameType;

    /**
     * set to true on first call of destroyBlockInWorldPartially, false before any further calls
     */
    private boolean isPartiallyDestroyedBlockWhole;
    private int field_73089_e;
    private int partiallyDestroyedBlockX;
    private int partiallyDestroyedBlockY;
    private int partiallyDestroyedBlockZ;
    private int field_73100_i;
    private boolean field_73097_j;
    private int posX;
    private int posY;
    private int posZ;
    private int field_73093_n;
    private int durabilityRemainingOnBlock;

    public ItemInWorldManager(World par1World)
    {
        gameType = EnumGameType.NOT_SET;
        durabilityRemainingOnBlock = -1;
        theWorld = par1World;
    }

    public void setGameType(EnumGameType par1EnumGameType)
    {
        gameType = par1EnumGameType;
        par1EnumGameType.configurePlayerCapabilities(field_73090_b.capabilities);
        field_73090_b.sendPlayerAbilities();
    }

    public EnumGameType getGameType()
    {
        return gameType;
    }

    public boolean isCreative()
    {
        return gameType.isCreative();
    }

    /**
     * if the gameType is currently NOT_SET then change it to par1
     */
    public void initializeGameType(EnumGameType par1EnumGameType)
    {
        if (gameType == EnumGameType.NOT_SET)
        {
            gameType = par1EnumGameType;
        }

        setGameType(gameType);
    }

    public void func_73075_a()
    {
        field_73100_i++;

        if (field_73097_j)
        {
            int i = field_73100_i - field_73093_n;
            int k = theWorld.getBlockId(posX, posY, posZ);

            if (k == 0)
            {
                field_73097_j = false;
            }
            else
            {
                Block block1 = Block.blocksList[k];
                float f = block1.getPlayerRelativeBlockHardness(field_73090_b, field_73090_b.worldObj, posX, posY, posZ) * (float)(i + 1);
                int i1 = (int)(f * 10F);

                if (i1 != durabilityRemainingOnBlock)
                {
                    theWorld.destroyBlockInWorldPartially(field_73090_b.entityId, posX, posY, posZ, i1);
                    durabilityRemainingOnBlock = i1;
                }

                if (f >= 1.0F)
                {
                    field_73097_j = false;
                    tryHarvestBlock(posX, posY, posZ);
                }
            }
        }
        else if (isPartiallyDestroyedBlockWhole)
        {
            int j = theWorld.getBlockId(partiallyDestroyedBlockX, partiallyDestroyedBlockY, partiallyDestroyedBlockZ);
            Block block = Block.blocksList[j];

            if (block == null)
            {
                theWorld.destroyBlockInWorldPartially(field_73090_b.entityId, partiallyDestroyedBlockX, partiallyDestroyedBlockY, partiallyDestroyedBlockZ, -1);
                durabilityRemainingOnBlock = -1;
                isPartiallyDestroyedBlockWhole = false;
            }
            else
            {
                int l = field_73100_i - field_73089_e;
                float f1 = block.getPlayerRelativeBlockHardness(field_73090_b, field_73090_b.worldObj, partiallyDestroyedBlockX, partiallyDestroyedBlockY, partiallyDestroyedBlockZ) * (float)(l + 1);
                int j1 = (int)(f1 * 10F);

                if (j1 != durabilityRemainingOnBlock)
                {
                    theWorld.destroyBlockInWorldPartially(field_73090_b.entityId, partiallyDestroyedBlockX, partiallyDestroyedBlockY, partiallyDestroyedBlockZ, j1);
                    durabilityRemainingOnBlock = j1;
                }
            }
        }
    }

    /**
     * if not creative, it calls destroyBlockInWorldPartially untill the block is broken first. par4 is the specific
     * side. tryHarvestBlock can also be the result of this call
     */
    public void onBlockClicked(int par1, int par2, int par3, int par4)
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

        theWorld.extinguishFire(field_73090_b, par1, par2, par3, par4);
        field_73089_e = field_73100_i;
        float f = 1.0F;
        int i = theWorld.getBlockId(par1, par2, par3);

        if (i > 0)
        {
            Block.blocksList[i].onBlockClicked(theWorld, par1, par2, par3, field_73090_b);
            f = Block.blocksList[i].getPlayerRelativeBlockHardness(field_73090_b, field_73090_b.worldObj, par1, par2, par3);
        }

        if (i > 0 && f >= 1.0F)
        {
            tryHarvestBlock(par1, par2, par3);
        }
        else
        {
            isPartiallyDestroyedBlockWhole = true;
            partiallyDestroyedBlockX = par1;
            partiallyDestroyedBlockY = par2;
            partiallyDestroyedBlockZ = par3;
            int j = (int)(f * 10F);
            theWorld.destroyBlockInWorldPartially(field_73090_b.entityId, par1, par2, par3, j);
            durabilityRemainingOnBlock = j;
        }
    }

    public void uncheckedTryHarvestBlock(int par1, int par2, int par3)
    {
        if (par1 == partiallyDestroyedBlockX && par2 == partiallyDestroyedBlockY && par3 == partiallyDestroyedBlockZ)
        {
            int i = field_73100_i - field_73089_e;
            int j = theWorld.getBlockId(par1, par2, par3);

            if (j != 0)
            {
                Block block = Block.blocksList[j];
                float f = block.getPlayerRelativeBlockHardness(field_73090_b, field_73090_b.worldObj, par1, par2, par3) * (float)(i + 1);

                if (f >= 0.7F)
                {
                    isPartiallyDestroyedBlockWhole = false;
                    theWorld.destroyBlockInWorldPartially(field_73090_b.entityId, par1, par2, par3, -1);
                    tryHarvestBlock(par1, par2, par3);
                }
                else if (!field_73097_j)
                {
                    isPartiallyDestroyedBlockWhole = false;
                    field_73097_j = true;
                    posX = par1;
                    posY = par2;
                    posZ = par3;
                    field_73093_n = field_73089_e;
                }
            }
        }
    }

    /**
     * note: this ignores the pars passed in and continues to destroy the onClickedBlock
     */
    public void destroyBlockInWorldPartially(int par1, int par2, int par3)
    {
        isPartiallyDestroyedBlockWhole = false;
        theWorld.destroyBlockInWorldPartially(field_73090_b.entityId, partiallyDestroyedBlockX, partiallyDestroyedBlockY, partiallyDestroyedBlockZ, -1);
    }

    /**
     * Removes a block and triggers the appropriate  events
     */
    private boolean removeBlock(int par1, int par2, int par3)
    {
        Block block = Block.blocksList[theWorld.getBlockId(par1, par2, par3)];
        int i = theWorld.getBlockMetadata(par1, par2, par3);

        if (block != null)
        {
            block.onBlockHarvested(theWorld, par1, par2, par3, i, field_73090_b);
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
        theWorld.playAuxSFXAtEntity(field_73090_b, 2001, par1, par2, par3, i + (theWorld.getBlockMetadata(par1, par2, par3) << 12));
        boolean flag = removeBlock(par1, par2, par3);

        if (isCreative())
        {
            field_73090_b.serverForThisPlayer.sendPacketToPlayer(new Packet53BlockChange(par1, par2, par3, theWorld));
        }
        else
        {
            ItemStack itemstack = field_73090_b.getCurrentEquippedItem();
            boolean flag1 = field_73090_b.canHarvestBlock(Block.blocksList[i]);

            if (itemstack != null)
            {
                itemstack.func_77941_a(theWorld, i, par1, par2, par3, field_73090_b);

                if (itemstack.stackSize == 0)
                {
                    field_73090_b.destroyCurrentEquippedItem();
                }
            }

            if (flag && flag1)
            {
                Block.blocksList[i].harvestBlock(theWorld, field_73090_b, par1, par2, par3, j);
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
            boolean flag = par3ItemStack.tryPlaceItemIntoWorld(par1EntityPlayer, par2World, par4, par5, par6, par7, par8, par9, par10);
            par3ItemStack.setItemDamage(j);
            par3ItemStack.stackSize = k;
            return flag;
        }
        else
        {
            return par3ItemStack.tryPlaceItemIntoWorld(par1EntityPlayer, par2World, par4, par5, par6, par7, par8, par9, par10);
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
