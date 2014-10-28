package net.minecraft.src;

import java.util.*;

public class EntityVillager extends EntityAgeable implements INpc, IMerchant
{
    private int randomTickDivider;
    private boolean isMating;
    private boolean isPlaying;
    Village villageObj;

    /** This villager's current customer. */
    private EntityPlayer buyingPlayer;

    /** Initialises the MerchantRecipeList.java */
    private MerchantRecipeList buyingList;
    private int timeUntilReset;

    /** addDefaultEquipmentAndRecipies is called if this is true */
    private boolean needsInitilization;
    private int wealth;

    /** Recipes for buying things from Villagers. */
    private MerchantRecipe sellingRecipeList;

    /**
     * a villagers recipe list is intialized off this list ; the 2 params are min/max amount they will trade for 1
     * emerald
     */
    private static final Map villagerStockList;

    /**
     * Selling list of Blacksmith items. negative numbers mean 1 emerald for n items, positive numbers are n emeralds
     * for 1 item
     */
    private static final Map blacksmithSellingList;

    public EntityVillager(World par1World)
    {
        this(par1World, 0);
    }

    public EntityVillager(World par1World, int par2)
    {
        super(par1World);
        randomTickDivider = 0;
        isMating = false;
        isPlaying = false;
        villageObj = null;
        setProfession(par2);
        texture = "/mob/villager/villager.png";
        moveSpeed = 0.5F;
        getNavigator().setBreakDoors(true);
        getNavigator().setAvoidsWater(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAvoidEntity(this, net.minecraft.src.EntityZombie.class, 8F, 0.3F, 0.35F));
        tasks.addTask(1, new EntityAITradePlayer(this));
        tasks.addTask(1, new EntityAILookAtTradePlayer(this));
        tasks.addTask(2, new EntityAIMoveIndoors(this));
        tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        tasks.addTask(4, new EntityAIOpenDoor(this, true));
        tasks.addTask(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
        tasks.addTask(6, new EntityAIVillagerMate(this));
        tasks.addTask(7, new EntityAIFollowGolem(this));
        tasks.addTask(8, new EntityAIPlay(this, 0.32F));
        tasks.addTask(9, new EntityAIWatchClosest2(this, net.minecraft.src.EntityPlayer.class, 3F, 1.0F));
        tasks.addTask(9, new EntityAIWatchClosest2(this, net.minecraft.src.EntityVillager.class, 5F, 0.02F));
        tasks.addTask(9, new EntityAIWander(this, 0.3F));
        tasks.addTask(10, new EntityAIWatchClosest(this, net.minecraft.src.EntityLiving.class, 8F));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        if (--randomTickDivider <= 0)
        {
            worldObj.villageCollectionObj.addVillagerPosition(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ));
            randomTickDivider = 70 + rand.nextInt(50);
            villageObj = worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ), 32);

            if (villageObj == null)
            {
                detachHome();
            }
            else
            {
                ChunkCoordinates chunkcoordinates = villageObj.getCenter();
                setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, villageObj.getVillageRadius());
            }
        }

        if (!isTrading() && timeUntilReset > 0)
        {
            timeUntilReset--;

            if (timeUntilReset <= 0)
            {
                if (needsInitilization)
                {
                    addDefaultEquipmentAndRecipies(1);
                    needsInitilization = false;
                }

                if (sellingRecipeList != null)
                {
                    buyingList.remove(sellingRecipeList);
                    sellingRecipeList = null;
                }

                addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
            }
        }

        super.updateAITick();
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if (isEntityAlive() && !isTrading() && !isChild())
        {
            if (!worldObj.isRemote)
            {
                setCustomer(par1EntityPlayer);
                par1EntityPlayer.displayGUIMerchant(this);
            }

            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, Integer.valueOf(0));
    }

    public int getMaxHealth()
    {
        return 20;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Profession", getProfession());
        par1NBTTagCompound.setInteger("Riches", wealth);

        if (buyingList != null)
        {
            par1NBTTagCompound.setCompoundTag("Offers", buyingList.getRecipiesAsTags());
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        setProfession(par1NBTTagCompound.getInteger("Profession"));
        wealth = par1NBTTagCompound.getInteger("Riches");

        if (par1NBTTagCompound.hasKey("Offers"))
        {
            NBTTagCompound nbttagcompound = par1NBTTagCompound.getCompoundTag("Offers");
            buyingList = new MerchantRecipeList(nbttagcompound);
        }
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        switch (getProfession())
        {
            case 0:
                return "/mob/villager/farmer.png";

            case 1:
                return "/mob/villager/librarian.png";

            case 2:
                return "/mob/villager/priest.png";

            case 3:
                return "/mob/villager/smith.png";

            case 4:
                return "/mob/villager/butcher.png";
        }

        return super.getTexture();
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.villager.default";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }

    public void setProfession(int par1)
    {
        dataWatcher.updateObject(16, Integer.valueOf(par1));
    }

    public int getProfession()
    {
        return dataWatcher.getWatchableObjectInt(16);
    }

    public boolean isMating()
    {
        return isMating;
    }

    public void setMating(boolean par1)
    {
        isMating = par1;
    }

    public void setPlaying(boolean par1)
    {
        isPlaying = par1;
    }

    public boolean isPlaying()
    {
        return isPlaying;
    }

    public void setRevengeTarget(EntityLiving par1EntityLiving)
    {
        super.setRevengeTarget(par1EntityLiving);

        if (villageObj != null && par1EntityLiving != null)
        {
            villageObj.addOrRenewAgressor(par1EntityLiving);
        }
    }

    public void setCustomer(EntityPlayer par1EntityPlayer)
    {
        buyingPlayer = par1EntityPlayer;
    }

    public EntityPlayer getCustomer()
    {
        return buyingPlayer;
    }

    public boolean isTrading()
    {
        return buyingPlayer != null;
    }

    public void useRecipe(MerchantRecipe par1MerchantRecipe)
    {
        par1MerchantRecipe.incrementToolUses();

        if (par1MerchantRecipe.hasSameIDsAs((MerchantRecipe)buyingList.get(buyingList.size() - 1)))
        {
            timeUntilReset = 60;
            needsInitilization = true;
        }
        else if (buyingList.size() > 1)
        {
            int i = rand.nextInt(6) + rand.nextInt(6) + 3;

            if (i <= par1MerchantRecipe.getToolUses())
            {
                timeUntilReset = 20;
                sellingRecipeList = par1MerchantRecipe;
            }
        }

        if (par1MerchantRecipe.getItemToBuy().itemID == Item.emerald.shiftedIndex)
        {
            wealth += par1MerchantRecipe.getItemToBuy().stackSize;
        }
    }

    public MerchantRecipeList getRecipes(EntityPlayer par1EntityPlayer)
    {
        if (buyingList == null)
        {
            addDefaultEquipmentAndRecipies(1);
        }

        return buyingList;
    }

    /**
     * based on the villagers profession add items, equipment, and recipies adds par1 random items to the list of things
     * that the villager wants to buy. (at most 1 of each wanted type is added)
     */
    private void addDefaultEquipmentAndRecipies(int par1)
    {
        MerchantRecipeList merchantrecipelist = new MerchantRecipeList();

        switch (getProfession())
        {
            default:
                break;

            case 0:
                addMerchantItem(merchantrecipelist, Item.wheat.shiftedIndex, rand, 0.9F);
                addMerchantItem(merchantrecipelist, Block.cloth.blockID, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.chickenRaw.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.fishCooked.shiftedIndex, rand, 0.4F);
                addBlacksmithItem(merchantrecipelist, Item.bread.shiftedIndex, rand, 0.9F);
                addBlacksmithItem(merchantrecipelist, Item.melon.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.appleRed.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.cookie.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.shears.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.flintAndSteel.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.chickenCooked.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.arrow.shiftedIndex, rand, 0.5F);

                if (rand.nextFloat() < 0.5F)
                {
                    merchantrecipelist.add(new MerchantRecipe(new ItemStack(Block.gravel, 10), new ItemStack(Item.emerald), new ItemStack(Item.flint.shiftedIndex, 2 + rand.nextInt(2), 0)));
                }

                break;

            case 4:
                addMerchantItem(merchantrecipelist, Item.coal.shiftedIndex, rand, 0.7F);
                addMerchantItem(merchantrecipelist, Item.porkRaw.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.beefRaw.shiftedIndex, rand, 0.5F);
                addBlacksmithItem(merchantrecipelist, Item.saddle.shiftedIndex, rand, 0.1F);
                addBlacksmithItem(merchantrecipelist, Item.plateLeather.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.bootsLeather.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.helmetLeather.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.legsLeather.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.porkCooked.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.beefCooked.shiftedIndex, rand, 0.3F);
                break;

            case 3:
                addMerchantItem(merchantrecipelist, Item.coal.shiftedIndex, rand, 0.7F);
                addMerchantItem(merchantrecipelist, Item.ingotIron.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.ingotGold.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.diamond.shiftedIndex, rand, 0.5F);
                addBlacksmithItem(merchantrecipelist, Item.swordSteel.shiftedIndex, rand, 0.5F);
                addBlacksmithItem(merchantrecipelist, Item.swordDiamond.shiftedIndex, rand, 0.5F);
                addBlacksmithItem(merchantrecipelist, Item.axeSteel.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.axeDiamond.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.pickaxeSteel.shiftedIndex, rand, 0.5F);
                addBlacksmithItem(merchantrecipelist, Item.pickaxeDiamond.shiftedIndex, rand, 0.5F);
                addBlacksmithItem(merchantrecipelist, Item.shovelSteel.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.shovelDiamond.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.hoeSteel.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.hoeDiamond.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.bootsSteel.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.bootsDiamond.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.helmetSteel.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.helmetDiamond.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.plateSteel.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.plateDiamond.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.legsSteel.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.legsDiamond.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.bootsChain.shiftedIndex, rand, 0.1F);
                addBlacksmithItem(merchantrecipelist, Item.helmetChain.shiftedIndex, rand, 0.1F);
                addBlacksmithItem(merchantrecipelist, Item.plateChain.shiftedIndex, rand, 0.1F);
                addBlacksmithItem(merchantrecipelist, Item.legsChain.shiftedIndex, rand, 0.1F);
                break;

            case 1:
                addMerchantItem(merchantrecipelist, Item.paper.shiftedIndex, rand, 0.8F);
                addMerchantItem(merchantrecipelist, Item.book.shiftedIndex, rand, 0.8F);
                addMerchantItem(merchantrecipelist, Item.writtenBook.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Block.bookShelf.blockID, rand, 0.8F);
                addBlacksmithItem(merchantrecipelist, Block.glass.blockID, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.compass.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.pocketSundial.shiftedIndex, rand, 0.2F);
                break;

            case 2:
                addBlacksmithItem(merchantrecipelist, Item.eyeOfEnder.shiftedIndex, rand, 0.3F);
                addBlacksmithItem(merchantrecipelist, Item.expBottle.shiftedIndex, rand, 0.2F);
                addBlacksmithItem(merchantrecipelist, Item.redstone.shiftedIndex, rand, 0.4F);
                addBlacksmithItem(merchantrecipelist, Block.glowStone.blockID, rand, 0.3F);
                int ai[] =
                {
                    Item.swordSteel.shiftedIndex, Item.swordDiamond.shiftedIndex, Item.plateSteel.shiftedIndex, Item.plateDiamond.shiftedIndex, Item.axeSteel.shiftedIndex, Item.axeDiamond.shiftedIndex, Item.pickaxeSteel.shiftedIndex, Item.pickaxeDiamond.shiftedIndex
                };
                int ai1[] = ai;
                int j = ai1.length;

                for (int k = 0; k < j; k++)
                {
                    int l = ai1[k];

                    if (rand.nextFloat() < 0.1F)
                    {
                        merchantrecipelist.add(new MerchantRecipe(new ItemStack(l, 1, 0), new ItemStack(Item.emerald, 2 + rand.nextInt(3), 0), EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(l, 1, 0), 5 + rand.nextInt(15))));
                    }
                }

                break;
        }

        addModTrades(merchantrecipelist);

        if (merchantrecipelist.isEmpty())
        {
            addMerchantItem(merchantrecipelist, Item.ingotGold.shiftedIndex, rand, 1.0F);
        }

        Collections.shuffle(merchantrecipelist);

        if (buyingList == null)
        {
            buyingList = new MerchantRecipeList();
        }

        for (int i = 0; i < par1 && i < merchantrecipelist.size(); i++)
        {
            buyingList.addToListWithCheck((MerchantRecipe)merchantrecipelist.get(i));
        }
    }

    private void addModTrades(MerchantRecipeList merchantrecipelist)
    {
        List list = ModLoader.getTrades(getProfession());

        if (list == null)
        {
            return;
        }

        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            TradeEntry tradeentry = (TradeEntry)iterator.next();

            if (tradeentry.buying)
            {
                addMerchantItem(merchantrecipelist, tradeentry.id, rand, tradeentry.chance);
            }
            else
            {
                addBlacksmithItem(merchantrecipelist, tradeentry.id, rand, tradeentry.chance);
            }
        }
    }

    public void setRecipes(MerchantRecipeList merchantrecipelist)
    {
    }

    /**
     * each recipie takes a random stack from villagerStockList and offers it for 1 emerald
     */
    private static void addMerchantItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            par0MerchantRecipeList.add(new MerchantRecipe(getRandomSizedStack(par1, par2Random), Item.emerald));
        }
    }

    private static ItemStack getRandomSizedStack(int par0, Random par1Random)
    {
        return new ItemStack(par0, getRandomCountForItem(par0, par1Random), 0);
    }

    /**
     * default to 1, and villagerStockList contains a min/max amount for each index
     */
    private static int getRandomCountForItem(int par0, Random par1Random)
    {
        Tuple tuple = (Tuple)villagerStockList.get(Integer.valueOf(par0));

        if (tuple == null)
        {
            return 1;
        }

        if (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue())
        {
            return ((Integer)tuple.getFirst()).intValue();
        }
        else
        {
            return ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue());
        }
    }

    private static void addBlacksmithItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            int i = getRandomCountForBlacksmithItem(par1, par2Random);
            ItemStack itemstack;
            ItemStack itemstack1;

            if (i < 0)
            {
                itemstack = new ItemStack(Item.emerald.shiftedIndex, 1, 0);
                itemstack1 = new ItemStack(par1, -i, 0);
            }
            else
            {
                itemstack = new ItemStack(Item.emerald.shiftedIndex, i, 0);
                itemstack1 = new ItemStack(par1, 1, 0);
            }

            par0MerchantRecipeList.add(new MerchantRecipe(itemstack, itemstack1));
        }
    }

    private static int getRandomCountForBlacksmithItem(int par0, Random par1Random)
    {
        Tuple tuple = (Tuple)blacksmithSellingList.get(Integer.valueOf(par0));

        if (tuple == null)
        {
            return 1;
        }

        if (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue())
        {
            return ((Integer)tuple.getFirst()).intValue();
        }
        else
        {
            return ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue());
        }
    }

    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 12)
        {
            generateRandomParticles("heart");
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    /**
     * par1 is the particleName
     */
    private void generateRandomParticles(String par1Str)
    {
        for (int i = 0; i < 5; i++)
        {
            double d = rand.nextGaussian() * 0.02D;
            double d1 = rand.nextGaussian() * 0.02D;
            double d2 = rand.nextGaussian() * 0.02D;
            worldObj.spawnParticle(par1Str, (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + 1.0D + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
        }
    }

    static
    {
        villagerStockList = new HashMap();
        blacksmithSellingList = new HashMap();
        villagerStockList.put(Integer.valueOf(Item.coal.shiftedIndex), new Tuple(Integer.valueOf(16), Integer.valueOf(24)));
        villagerStockList.put(Integer.valueOf(Item.ingotIron.shiftedIndex), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        villagerStockList.put(Integer.valueOf(Item.ingotGold.shiftedIndex), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        villagerStockList.put(Integer.valueOf(Item.diamond.shiftedIndex), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        villagerStockList.put(Integer.valueOf(Item.paper.shiftedIndex), new Tuple(Integer.valueOf(19), Integer.valueOf(30)));
        villagerStockList.put(Integer.valueOf(Item.book.shiftedIndex), new Tuple(Integer.valueOf(12), Integer.valueOf(15)));
        villagerStockList.put(Integer.valueOf(Item.writtenBook.shiftedIndex), new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
        villagerStockList.put(Integer.valueOf(Item.enderPearl.shiftedIndex), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        villagerStockList.put(Integer.valueOf(Item.eyeOfEnder.shiftedIndex), new Tuple(Integer.valueOf(2), Integer.valueOf(3)));
        villagerStockList.put(Integer.valueOf(Item.porkRaw.shiftedIndex), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagerStockList.put(Integer.valueOf(Item.beefRaw.shiftedIndex), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagerStockList.put(Integer.valueOf(Item.chickenRaw.shiftedIndex), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagerStockList.put(Integer.valueOf(Item.fishCooked.shiftedIndex), new Tuple(Integer.valueOf(9), Integer.valueOf(13)));
        villagerStockList.put(Integer.valueOf(Item.seeds.shiftedIndex), new Tuple(Integer.valueOf(34), Integer.valueOf(48)));
        villagerStockList.put(Integer.valueOf(Item.melonSeeds.shiftedIndex), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
        villagerStockList.put(Integer.valueOf(Item.pumpkinSeeds.shiftedIndex), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
        villagerStockList.put(Integer.valueOf(Item.wheat.shiftedIndex), new Tuple(Integer.valueOf(18), Integer.valueOf(22)));
        villagerStockList.put(Integer.valueOf(Block.cloth.blockID), new Tuple(Integer.valueOf(14), Integer.valueOf(22)));
        villagerStockList.put(Integer.valueOf(Item.rottenFlesh.shiftedIndex), new Tuple(Integer.valueOf(36), Integer.valueOf(64)));
        blacksmithSellingList.put(Integer.valueOf(Item.flintAndSteel.shiftedIndex), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.shears.shiftedIndex), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.swordSteel.shiftedIndex), new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
        blacksmithSellingList.put(Integer.valueOf(Item.swordDiamond.shiftedIndex), new Tuple(Integer.valueOf(12), Integer.valueOf(14)));
        blacksmithSellingList.put(Integer.valueOf(Item.axeSteel.shiftedIndex), new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.axeDiamond.shiftedIndex), new Tuple(Integer.valueOf(9), Integer.valueOf(12)));
        blacksmithSellingList.put(Integer.valueOf(Item.pickaxeSteel.shiftedIndex), new Tuple(Integer.valueOf(7), Integer.valueOf(9)));
        blacksmithSellingList.put(Integer.valueOf(Item.pickaxeDiamond.shiftedIndex), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        blacksmithSellingList.put(Integer.valueOf(Item.shovelSteel.shiftedIndex), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        blacksmithSellingList.put(Integer.valueOf(Item.shovelDiamond.shiftedIndex), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.hoeSteel.shiftedIndex), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        blacksmithSellingList.put(Integer.valueOf(Item.hoeDiamond.shiftedIndex), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.bootsSteel.shiftedIndex), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        blacksmithSellingList.put(Integer.valueOf(Item.bootsDiamond.shiftedIndex), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.helmetSteel.shiftedIndex), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        blacksmithSellingList.put(Integer.valueOf(Item.helmetDiamond.shiftedIndex), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.plateSteel.shiftedIndex), new Tuple(Integer.valueOf(10), Integer.valueOf(14)));
        blacksmithSellingList.put(Integer.valueOf(Item.plateDiamond.shiftedIndex), new Tuple(Integer.valueOf(16), Integer.valueOf(19)));
        blacksmithSellingList.put(Integer.valueOf(Item.legsSteel.shiftedIndex), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        blacksmithSellingList.put(Integer.valueOf(Item.legsDiamond.shiftedIndex), new Tuple(Integer.valueOf(11), Integer.valueOf(14)));
        blacksmithSellingList.put(Integer.valueOf(Item.bootsChain.shiftedIndex), new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
        blacksmithSellingList.put(Integer.valueOf(Item.helmetChain.shiftedIndex), new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
        blacksmithSellingList.put(Integer.valueOf(Item.plateChain.shiftedIndex), new Tuple(Integer.valueOf(11), Integer.valueOf(15)));
        blacksmithSellingList.put(Integer.valueOf(Item.legsChain.shiftedIndex), new Tuple(Integer.valueOf(9), Integer.valueOf(11)));
        blacksmithSellingList.put(Integer.valueOf(Item.bread.shiftedIndex), new Tuple(Integer.valueOf(-4), Integer.valueOf(-2)));
        blacksmithSellingList.put(Integer.valueOf(Item.melon.shiftedIndex), new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
        blacksmithSellingList.put(Integer.valueOf(Item.appleRed.shiftedIndex), new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
        blacksmithSellingList.put(Integer.valueOf(Item.cookie.shiftedIndex), new Tuple(Integer.valueOf(-10), Integer.valueOf(-7)));
        blacksmithSellingList.put(Integer.valueOf(Block.glass.blockID), new Tuple(Integer.valueOf(-5), Integer.valueOf(-3)));
        blacksmithSellingList.put(Integer.valueOf(Block.bookShelf.blockID), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.plateLeather.shiftedIndex), new Tuple(Integer.valueOf(4), Integer.valueOf(5)));
        blacksmithSellingList.put(Integer.valueOf(Item.bootsLeather.shiftedIndex), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.helmetLeather.shiftedIndex), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.legsLeather.shiftedIndex), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.saddle.shiftedIndex), new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.expBottle.shiftedIndex), new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
        blacksmithSellingList.put(Integer.valueOf(Item.redstone.shiftedIndex), new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
        blacksmithSellingList.put(Integer.valueOf(Item.compass.shiftedIndex), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        blacksmithSellingList.put(Integer.valueOf(Item.pocketSundial.shiftedIndex), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        blacksmithSellingList.put(Integer.valueOf(Block.glowStone.blockID), new Tuple(Integer.valueOf(-3), Integer.valueOf(-1)));
        blacksmithSellingList.put(Integer.valueOf(Item.porkCooked.shiftedIndex), new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
        blacksmithSellingList.put(Integer.valueOf(Item.beefCooked.shiftedIndex), new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
        blacksmithSellingList.put(Integer.valueOf(Item.chickenCooked.shiftedIndex), new Tuple(Integer.valueOf(-8), Integer.valueOf(-6)));
        blacksmithSellingList.put(Integer.valueOf(Item.eyeOfEnder.shiftedIndex), new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
        blacksmithSellingList.put(Integer.valueOf(Item.arrow.shiftedIndex), new Tuple(Integer.valueOf(-5), Integer.valueOf(-19)));
        List list = ModLoader.getTrades(-1);
        Iterator iterator = list.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            TradeEntry tradeentry = (TradeEntry)iterator.next();

            if (tradeentry.buying)
            {
                if (tradeentry.min > 0 && tradeentry.max > 0)
                {
                    villagerStockList.put(Integer.valueOf(tradeentry.id), new Tuple(Integer.valueOf(tradeentry.min), Integer.valueOf(tradeentry.max)));
                }
            }
            else if (tradeentry.min > 0 && tradeentry.max > 0)
            {
                blacksmithSellingList.put(Integer.valueOf(tradeentry.id), new Tuple(Integer.valueOf(tradeentry.min), Integer.valueOf(tradeentry.max)));
            }
        }
        while (true);
    }
}
