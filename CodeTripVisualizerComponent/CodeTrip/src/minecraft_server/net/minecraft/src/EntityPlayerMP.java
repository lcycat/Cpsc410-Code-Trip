package net.minecraft.src;

import java.io.*;
import java.util.*;
import net.minecraft.server.MinecraftServer;

public class EntityPlayerMP extends EntityPlayer implements ICrafting
{
    private StringTranslate field_71148_cg;

    /** The NetServerHandler for this particular player. */
    public NetServerHandler playerNetServerHandler;

    /** Reference to the MinecraftServer object. */
    public MinecraftServer mcServer;

    /** The ItemInWorldManager belonging to this player */
    public ItemInWorldManager theItemInWorldManager;

    /** player X position as seen by PlayerManager */
    public double managedPosX;

    /** player Z position as seen by PlayerManager */
    public double managedPosZ;

    /** LinkedList that holds loaded chunks */
    public final List loadedChunks = new LinkedList();
    public final List field_71130_g = new LinkedList();

    /** amount of health the client was last set to */
    private int lastHealth;
    private int field_71146_ci;
    private boolean field_71147_cj;

    /** Amount of experience the client was last set to */
    private int lastExperience;

    /** how many ticks of invulnerability(spawn protection) this player has */
    private int ticksOfInvuln;
    private int field_71142_cm;
    private int field_71143_cn;
    private boolean field_71140_co;
    private ItemStack playerInventory[] =
    {
        null, null, null, null, null
    };

    /**
     * The currently in use window ID. Incremented every time a window is opened.
     */
    private int currentWindowId;

    /**
     * set to true when player is moving quantity of items from one inventory to another(crafting) but item in either
     * slot is not changed
     */
    public boolean isChangingQuantityOnly;
    public int ping;

    /**
     * Set when a player beats the ender dragon, used to determine whether a Packet9Respawn is valid.
     */
    public boolean gameOver;

    public EntityPlayerMP(MinecraftServer par1MinecraftServer, World par2World, String par3Str, ItemInWorldManager par4ItemInWorldManager)
    {
        super(par2World);
        field_71148_cg = new StringTranslate("en_US");
        lastHealth = 0xfa0a1f01;
        field_71146_ci = 0xfa0a1f01;
        field_71147_cj = true;
        lastExperience = 0xfa0a1f01;
        ticksOfInvuln = 60;
        field_71142_cm = 0;
        field_71143_cn = 0;
        field_71140_co = true;
        currentWindowId = 0;
        gameOver = false;
        par4ItemInWorldManager.thisPlayerMP = this;
        theItemInWorldManager = par4ItemInWorldManager;
        field_71142_cm = par1MinecraftServer.func_71203_ab().getViewDistance();
        ChunkCoordinates chunkcoordinates = par2World.getSpawnPoint();
        int i = chunkcoordinates.posX;
        int j = chunkcoordinates.posZ;
        int k = chunkcoordinates.posY;

        if (!par2World.provider.hasNoSky && par2World.getWorldInfo().getGameType() != EnumGameType.ADVENTURE)
        {
            i += rand.nextInt(20) - 10;
            k = par2World.getTopSolidOrLiquidBlock(i, j);
            j += rand.nextInt(20) - 10;
        }

        setLocationAndAngles((double)i + 0.5D, k, (double)j + 0.5D, 0.0F, 0.0F);
        mcServer = par1MinecraftServer;
        stepHeight = 0.0F;
        username = par3Str;
        yOffset = 0.0F;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);

        if (par1NBTTagCompound.hasKey("playerGameType"))
        {
            theItemInWorldManager.setGameType(EnumGameType.getByID(par1NBTTagCompound.getInteger("playerGameType")));
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("playerGameType", theItemInWorldManager.getGameType().getID());
    }

    /**
     * Removes the specified number of experience levels.
     */
    public void removeExperience(int par1)
    {
        super.removeExperience(par1);
        lastExperience = -1;
    }

    public void func_71116_b()
    {
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * returns the inventory of this entity (only used in EntityPlayerMP it seems)
     */
    public ItemStack[] getInventory()
    {
        return playerInventory;
    }

    /**
     * sets the players height back to normal after doing things like sleeping and dieing
     */
    protected void resetHeight()
    {
        yOffset = 0.0F;
    }

    public float getEyeHeight()
    {
        return 1.62F;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        theItemInWorldManager.updateBlockRemoving();
        ticksOfInvuln--;
        craftingInventory.updateCraftingResults();

        for (int i = 0; i < 5; i++)
        {
            ItemStack itemstack = getEquipmentInSlot(i);

            if (itemstack != playerInventory[i])
            {
                func_71121_q().getEntityTracker().sendPacketToTrackedPlayers(this, new Packet5PlayerInventory(entityId, i, itemstack));
                playerInventory[i] = itemstack;
            }
        }

        if (!loadedChunks.isEmpty())
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = loadedChunks.iterator();
            ArrayList arraylist1 = new ArrayList();

            do
            {
                if (!iterator.hasNext() || arraylist.size() >= 5)
                {
                    break;
                }

                ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
                iterator.remove();

                if (chunkcoordintpair != null && worldObj.blockExists(chunkcoordintpair.chunkXPos << 4, 0, chunkcoordintpair.chunkZPos << 4))
                {
                    arraylist.add(worldObj.getChunkFromChunkCoords(chunkcoordintpair.chunkXPos, chunkcoordintpair.chunkZPos));
                    arraylist1.addAll(((WorldServer)worldObj).getTileEntityList(chunkcoordintpair.chunkXPos * 16, 0, chunkcoordintpair.chunkZPos * 16, chunkcoordintpair.chunkXPos * 16 + 16, 256, chunkcoordintpair.chunkZPos * 16 + 16));
                }
            }
            while (true);

            if (!arraylist.isEmpty())
            {
                playerNetServerHandler.sendPacket(new Packet56MapChunks(arraylist));
                TileEntity tileentity;

                for (Iterator iterator2 = arraylist1.iterator(); iterator2.hasNext(); getTileEntityInfo(tileentity))
                {
                    tileentity = (TileEntity)iterator2.next();
                }
            }
        }

        if (!field_71130_g.isEmpty())
        {
            int j = Math.min(field_71130_g.size(), 127);
            int ai[] = new int[j];
            Iterator iterator1 = field_71130_g.iterator();

            for (int k = 0; iterator1.hasNext() && k < j; iterator1.remove())
            {
                ai[k++] = ((Integer)iterator1.next()).intValue();
            }

            playerNetServerHandler.sendPacket(new Packet29DestroyEntity(ai));
        }
    }

    public void func_71127_g()
    {
        super.onUpdate();

        for (int i = 0; i < inventory.getSizeInventory(); i++)
        {
            ItemStack itemstack = inventory.getStackInSlot(i);

            if (itemstack == null || !Item.itemsList[itemstack.itemID].func_77643_m_() || playerNetServerHandler.getNumChunkDataPackets() > 2)
            {
                continue;
            }

            Packet packet = ((ItemMapBase)Item.itemsList[itemstack.itemID]).getUpdatePacket(itemstack, worldObj, this);

            if (packet != null)
            {
                playerNetServerHandler.sendPacket(packet);
            }
        }

        if (inPortal)
        {
            if (mcServer.func_71255_r())
            {
                if (craftingInventory != inventorySlots)
                {
                    closeScreen();
                }

                if (ridingEntity != null)
                {
                    mountEntity(ridingEntity);
                }
                else
                {
                    timeInPortal += 0.0125F;

                    if (timeInPortal >= 1.0F)
                    {
                        timeInPortal = 1.0F;
                        timeUntilPortal = 10;
                        byte byte0 = 0;

                        if (dimension == -1)
                        {
                            byte0 = 0;
                        }
                        else
                        {
                            byte0 = -1;
                        }

                        mcServer.func_71203_ab().sendPlayerToOtherDimension(this, byte0);
                        lastExperience = -1;
                        lastHealth = -1;
                        field_71146_ci = -1;
                        triggerAchievement(AchievementList.portal);
                    }
                }

                inPortal = false;
            }
        }
        else
        {
            if (timeInPortal > 0.0F)
            {
                timeInPortal -= 0.05F;
            }

            if (timeInPortal < 0.0F)
            {
                timeInPortal = 0.0F;
            }
        }

        if (timeUntilPortal > 0)
        {
            timeUntilPortal--;
        }

        if (getHealth() != lastHealth || field_71146_ci != foodStats.getFoodLevel() || (foodStats.getSaturationLevel() == 0.0F) != field_71147_cj)
        {
            playerNetServerHandler.sendPacket(new Packet8UpdateHealth(getHealth(), foodStats.getFoodLevel(), foodStats.getSaturationLevel()));
            lastHealth = getHealth();
            field_71146_ci = foodStats.getFoodLevel();
            field_71147_cj = foodStats.getSaturationLevel() == 0.0F;
        }

        if (experienceTotal != lastExperience)
        {
            lastExperience = experienceTotal;
            playerNetServerHandler.sendPacket(new Packet43Experience(experience, experienceTotal, experienceLevel));
        }
    }

    /**
     * 0: Tool in Hand; 1-4: Armor
     */
    public ItemStack getEquipmentInSlot(int par1)
    {
        if (par1 == 0)
        {
            return inventory.getCurrentItem();
        }
        else
        {
            return inventory.armorInventory[par1 - 1];
        }
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        mcServer.func_71203_ab().sendPacketToAllPlayers(new Packet3Chat(par1DamageSource.getDeathMessage(this)));
        inventory.dropAllItems();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        if (ticksOfInvuln > 0)
        {
            return false;
        }

        if (!mcServer.func_71219_W() && (par1DamageSource instanceof EntityDamageSource))
        {
            Entity entity = par1DamageSource.getEntity();

            if (entity instanceof EntityPlayer)
            {
                return false;
            }

            if (entity instanceof EntityArrow)
            {
                EntityArrow entityarrow = (EntityArrow)entity;

                if (entityarrow.shootingEntity instanceof EntityPlayer)
                {
                    return false;
                }
            }
        }

        return super.attackEntityFrom(par1DamageSource, par2);
    }

    /**
     * returns if pvp is enabled or not
     */
    protected boolean isPVPEnabled()
    {
        return mcServer.func_71219_W();
    }

    public void travelToTheEnd(int par1)
    {
        if (dimension == 1 && par1 == 1)
        {
            triggerAchievement(AchievementList.theEnd2);
            worldObj.setEntityDead(this);
            gameOver = true;
            playerNetServerHandler.sendPacket(new Packet70GameEvent(4, 0));
        }
        else
        {
            triggerAchievement(AchievementList.theEnd);
            ChunkCoordinates chunkcoordinates = mcServer.getWorldManager(par1).func_73054_j();

            if (chunkcoordinates != null)
            {
                playerNetServerHandler.teleportTo(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, 0.0F, 0.0F);
            }

            mcServer.func_71203_ab().sendPlayerToOtherDimension(this, 1);
            lastExperience = -1;
            lastHealth = -1;
            field_71146_ci = -1;
        }
    }

    /**
     * gets description packets from all TileEntity's that override func_20070
     */
    private void getTileEntityInfo(TileEntity par1TileEntity)
    {
        if (par1TileEntity != null)
        {
            Packet packet = par1TileEntity.getDescriptionPacket();

            if (packet != null)
            {
                playerNetServerHandler.sendPacket(packet);
            }
        }
    }

    /**
     * Called whenever an item is picked up from walking over it. Args: pickedUpEntity, stackSize
     */
    public void onItemPickup(Entity par1Entity, int par2)
    {
        if (!par1Entity.isDead)
        {
            EntityTracker entitytracker = func_71121_q().getEntityTracker();

            if (par1Entity instanceof EntityItem)
            {
                entitytracker.sendPacketToTrackedPlayers(par1Entity, new Packet22Collect(par1Entity.entityId, entityId));
            }

            if (par1Entity instanceof EntityArrow)
            {
                entitytracker.sendPacketToTrackedPlayers(par1Entity, new Packet22Collect(par1Entity.entityId, entityId));
            }

            if (par1Entity instanceof EntityXPOrb)
            {
                entitytracker.sendPacketToTrackedPlayers(par1Entity, new Packet22Collect(par1Entity.entityId, entityId));
            }
        }

        super.onItemPickup(par1Entity, par2);
        craftingInventory.updateCraftingResults();
    }

    /**
     * Swings the item the player is holding.
     */
    public void swingItem()
    {
        if (!isSwinging)
        {
            swingProgressInt = -1;
            isSwinging = true;
            func_71121_q().getEntityTracker().sendPacketToTrackedPlayers(this, new Packet18Animation(this, 1));
        }
    }

    /**
     * puts player to sleep on specified bed if possible
     */
    public EnumStatus sleepInBedAt(int par1, int par2, int par3)
    {
        EnumStatus enumstatus = super.sleepInBedAt(par1, par2, par3);

        if (enumstatus == EnumStatus.OK)
        {
            Packet17Sleep packet17sleep = new Packet17Sleep(this, 0, par1, par2, par3);
            func_71121_q().getEntityTracker().sendPacketToTrackedPlayers(this, packet17sleep);
            playerNetServerHandler.teleportTo(posX, posY, posZ, rotationYaw, rotationPitch);
            playerNetServerHandler.sendPacket(packet17sleep);
        }

        return enumstatus;
    }

    /**
     * Wake up the player if they're sleeping.
     */
    public void wakeUpPlayer(boolean par1, boolean par2, boolean par3)
    {
        if (isPlayerSleeping())
        {
            func_71121_q().getEntityTracker().sendPacketToTrackedPlayersAndTrackedEntity(this, new Packet18Animation(this, 3));
        }

        super.wakeUpPlayer(par1, par2, par3);

        if (playerNetServerHandler != null)
        {
            playerNetServerHandler.teleportTo(posX, posY, posZ, rotationYaw, rotationPitch);
        }
    }

    /**
     * Called when a player mounts an entity. e.g. mounts a pig, mounts a boat.
     */
    public void mountEntity(Entity par1Entity)
    {
        super.mountEntity(par1Entity);
        playerNetServerHandler.sendPacket(new Packet39AttachEntity(this, ridingEntity));
        playerNetServerHandler.teleportTo(posX, posY, posZ, rotationYaw, rotationPitch);
    }

    /**
     * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
     * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
     */
    protected void updateFallState(double d, boolean flag)
    {
    }

    /**
     * process player falling based on movement packet
     */
    public void handleFalling(double par1, boolean par3)
    {
        super.updateFallState(par1, par3);
    }

    /**
     * get the next window id to use
     */
    private void getNextWindowId()
    {
        currentWindowId = currentWindowId % 100 + 1;
    }

    /**
     * Displays the crafting GUI for a workbench.
     */
    public void displayWorkbenchGUI(int par1, int par2, int par3)
    {
        getNextWindowId();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 1, "Crafting", 9));
        craftingInventory = new ContainerWorkbench(inventory, worldObj, par1, par2, par3);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    public void displayGUIEnchantment(int par1, int par2, int par3)
    {
        getNextWindowId();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 4, "Enchanting", 9));
        craftingInventory = new ContainerEnchantment(inventory, worldObj, par1, par2, par3);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * Displays the GUI for interacting with a chest inventory. Args: chestInventory
     */
    public void displayGUIChest(IInventory par1IInventory)
    {
        if (craftingInventory != inventorySlots)
        {
            closeScreen();
        }

        getNextWindowId();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 0, par1IInventory.getInvName(), par1IInventory.getSizeInventory()));
        craftingInventory = new ContainerChest(inventory, par1IInventory);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * Displays the furnace GUI for the passed in furnace entity. Args: tileEntityFurnace
     */
    public void displayGUIFurnace(TileEntityFurnace par1TileEntityFurnace)
    {
        getNextWindowId();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 2, par1TileEntityFurnace.getInvName(), par1TileEntityFurnace.getSizeInventory()));
        craftingInventory = new ContainerFurnace(inventory, par1TileEntityFurnace);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * Displays the dipsenser GUI for the passed in dispenser entity. Args: TileEntityDispenser
     */
    public void displayGUIDispenser(TileEntityDispenser par1TileEntityDispenser)
    {
        getNextWindowId();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 3, par1TileEntityDispenser.getInvName(), par1TileEntityDispenser.getSizeInventory()));
        craftingInventory = new ContainerDispenser(inventory, par1TileEntityDispenser);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * Displays the GUI for interacting with a brewing stand.
     */
    public void displayGUIBrewingStand(TileEntityBrewingStand par1TileEntityBrewingStand)
    {
        getNextWindowId();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 5, par1TileEntityBrewingStand.getInvName(), par1TileEntityBrewingStand.getSizeInventory()));
        craftingInventory = new ContainerBrewingStand(inventory, par1TileEntityBrewingStand);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    public void func_71030_a(IMerchant par1IMerchant)
    {
        getNextWindowId();
        craftingInventory = new ContainerMerchant(inventory, par1IMerchant, worldObj);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
        InventoryMerchant inventorymerchant = ((ContainerMerchant)craftingInventory).func_75174_d();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 6, inventorymerchant.getInvName(), inventorymerchant.getSizeInventory()));
        MerchantRecipeList merchantrecipelist = par1IMerchant.func_70934_b(this);

        if (merchantrecipelist != null)
        {
            try
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
                dataoutputstream.writeInt(currentWindowId);
                merchantrecipelist.func_77200_a(dataoutputstream);
                playerNetServerHandler.sendPacket(new Packet250CustomPayload("MC|TrList", bytearrayoutputstream.toByteArray()));
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
    }

    /**
     * inform the player of a change in a single slot
     */
    public void updateCraftingInventorySlot(Container par1Container, int par2, ItemStack par3ItemStack)
    {
        if (par1Container.getSlot(par2) instanceof SlotCrafting)
        {
            return;
        }

        if (isChangingQuantityOnly)
        {
            return;
        }
        else
        {
            playerNetServerHandler.sendPacket(new Packet103SetSlot(par1Container.windowId, par2, par3ItemStack));
            return;
        }
    }

    public void func_71120_a(Container par1Container)
    {
        updateCraftingInventory(par1Container, par1Container.func_75138_a());
    }

    /**
     * update the crafting window inventory with the items in the list
     */
    public void updateCraftingInventory(Container par1Container, List par2List)
    {
        playerNetServerHandler.sendPacket(new Packet104WindowItems(par1Container.windowId, par2List));
        playerNetServerHandler.sendPacket(new Packet103SetSlot(-1, -1, inventory.getItemStack()));
    }

    /**
     * send information about the crafting inventory to the client(currently only for furnace times)
     */
    public void updateCraftingInventoryInfo(Container par1Container, int par2, int par3)
    {
        playerNetServerHandler.sendPacket(new Packet105UpdateProgressbar(par1Container.windowId, par2, par3));
    }

    /**
     * set current crafting inventory back to the 2x2 square
     */
    public void closeScreen()
    {
        playerNetServerHandler.sendPacket(new Packet101CloseWindow(craftingInventory.windowId));
        closeCraftingGui();
    }

    /**
     * updates item held by mouse, This method always returns before doing anything...
     */
    public void updateHeldItem()
    {
        if (isChangingQuantityOnly)
        {
            return;
        }
        else
        {
            playerNetServerHandler.sendPacket(new Packet103SetSlot(-1, -1, inventory.getItemStack()));
            return;
        }
    }

    /**
     * close the current crafting gui
     */
    public void closeCraftingGui()
    {
        craftingInventory.onCraftGuiClosed(this);
        craftingInventory = inventorySlots;
    }

    /**
     * Adds a value to a statistic field.
     */
    public void addStat(StatBase par1StatBase, int par2)
    {
        if (par1StatBase == null)
        {
            return;
        }

        if (!par1StatBase.isIndependent)
        {
            for (; par2 > 100; par2 -= 100)
            {
                playerNetServerHandler.sendPacket(new Packet200Statistic(par1StatBase.statId, 100));
            }

            playerNetServerHandler.sendPacket(new Packet200Statistic(par1StatBase.statId, par2));
        }
    }

    public void func_71123_m()
    {
        if (ridingEntity != null)
        {
            mountEntity(ridingEntity);
        }

        if (riddenByEntity != null)
        {
            riddenByEntity.mountEntity(this);
        }

        if (sleeping)
        {
            wakeUpPlayer(true, false, false);
        }
    }

    public void func_71118_n()
    {
        lastHealth = 0xfa0a1f01;
    }

    /**
     * Add a chat message to the player
     */
    public void addChatMessage(String par1Str)
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        String s = stringtranslate.translateKey(par1Str);
        playerNetServerHandler.sendPacket(new Packet3Chat(s));
    }

    /**
     * Used for when item use count runs out, ie: eating completed
     */
    protected void onItemUseFinish()
    {
        playerNetServerHandler.sendPacket(new Packet38EntityStatus(entityId, (byte)9));
        super.onItemUseFinish();
    }

    /**
     * sets the itemInUse when the use item button is clicked. Args: itemstack, int maxItemUseDuration
     */
    public void setItemInUse(ItemStack par1ItemStack, int par2)
    {
        super.setItemInUse(par1ItemStack, par2);

        if (par1ItemStack != null && par1ItemStack.getItem() != null && par1ItemStack.getItem().getItemUseAction(par1ItemStack) == EnumAction.eat)
        {
            func_71121_q().getEntityTracker().sendPacketToTrackedPlayersAndTrackedEntity(this, new Packet18Animation(this, 5));
        }
    }

    protected void onNewPotionEffect(PotionEffect par1PotionEffect)
    {
        super.onNewPotionEffect(par1PotionEffect);
        playerNetServerHandler.sendPacket(new Packet41EntityEffect(entityId, par1PotionEffect));
    }

    protected void onChangedPotionEffect(PotionEffect par1PotionEffect)
    {
        super.onChangedPotionEffect(par1PotionEffect);
        playerNetServerHandler.sendPacket(new Packet41EntityEffect(entityId, par1PotionEffect));
    }

    protected void onFinishedPotionEffect(PotionEffect par1PotionEffect)
    {
        super.onFinishedPotionEffect(par1PotionEffect);
        playerNetServerHandler.sendPacket(new Packet42RemoveEntityEffect(entityId, par1PotionEffect));
    }

    /**
     * Sets the position of the entity and updates the 'last' variables
     */
    public void setPositionAndUpdate(double par1, double par3, double par5)
    {
        playerNetServerHandler.teleportTo(par1, par3, par5, rotationYaw, rotationPitch);
    }

    /**
     * Called when the player performs a critical hit on the Entity. Args: entity that was hit critically
     */
    public void onCriticalHit(Entity par1Entity)
    {
        func_71121_q().getEntityTracker().sendPacketToTrackedPlayersAndTrackedEntity(this, new Packet18Animation(par1Entity, 6));
    }

    public void onEnchantmentCritical(Entity par1Entity)
    {
        func_71121_q().getEntityTracker().sendPacketToTrackedPlayersAndTrackedEntity(this, new Packet18Animation(par1Entity, 7));
    }

    /**
     * Sends the player's abilities to the server (if there is one).
     */
    public void sendPlayerAbilities()
    {
        if (playerNetServerHandler == null)
        {
            return;
        }
        else
        {
            playerNetServerHandler.sendPacket(new Packet202PlayerAbilities(capabilities));
            return;
        }
    }

    public WorldServer func_71121_q()
    {
        return (WorldServer)worldObj;
    }

    /**
     * Sets the player's game type
     */
    public void setGameType(EnumGameType par1EnumGameType)
    {
        theItemInWorldManager.setGameType(par1EnumGameType);
        playerNetServerHandler.sendPacket(new Packet70GameEvent(3, par1EnumGameType.getID()));
    }

    public void func_70006_a(String par1Str)
    {
        playerNetServerHandler.sendPacket(new Packet3Chat(par1Str));
    }

    /**
     * Returns true if the command sender is allowed to use the given command.
     */
    public boolean canCommandSenderUseCommand(String par1Str)
    {
        if ("seed".equals(par1Str) && !mcServer.func_71262_S())
        {
            return true;
        }
        else
        {
            return mcServer.func_71203_ab().isOp(username);
        }
    }

    public String func_71114_r()
    {
        String s = playerNetServerHandler.netManager.getRemoteAddress().toString();
        s = s.substring(s.indexOf("/") + 1);
        s = s.substring(0, s.indexOf(":"));
        return s;
    }

    public void func_71125_a(Packet204ClientInfo par1Packet204ClientInfo)
    {
        if (field_71148_cg.func_74806_b().containsKey(par1Packet204ClientInfo.func_73459_d()))
        {
            field_71148_cg.setLanguage(par1Packet204ClientInfo.func_73459_d());
        }

        int i = 256 >> par1Packet204ClientInfo.func_73461_f();

        if (i > 3 && i < 15)
        {
            field_71142_cm = i;
        }

        field_71143_cn = par1Packet204ClientInfo.func_73463_g();
        field_71140_co = par1Packet204ClientInfo.func_73460_h();

        if (mcServer.func_71264_H() && mcServer.getServerOwner().equals(username))
        {
            mcServer.func_71226_c(par1Packet204ClientInfo.func_73462_i());
        }
    }

    public StringTranslate func_71025_t()
    {
        return field_71148_cg;
    }

    public int func_71126_v()
    {
        return field_71143_cn;
    }

    public void func_71115_a(String par1Str, int par2)
    {
        String s = (new StringBuilder()).append(par1Str).append("\0").append(par2).toString();
        playerNetServerHandler.sendPacket(new Packet250CustomPayload("MC|TPack", s.getBytes()));
    }
}
