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
    private int field_70961_j;
    private boolean field_70959_by;
    private int field_70956_bz;

    /** Recipes for buying things from Villagers. */
    private MerchantRecipe sellingRecipeList;

    /** Selling list of Villagers items. */
    private static final Map villagersSellingList;

    /** Selling list of Blacksmith items. */
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

        if (!isTrading() && field_70961_j > 0)
        {
            field_70961_j--;

            if (field_70961_j <= 0)
            {
                if (field_70959_by)
                {
                    func_70950_c(1);
                    field_70959_by = false;
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
                par1EntityPlayer.func_71030_a(this);
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
        par1NBTTagCompound.setInteger("Riches", field_70956_bz);

        if (buyingList != null)
        {
            par1NBTTagCompound.setCompoundTag("Offers", buyingList.func_77202_a());
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        setProfession(par1NBTTagCompound.getInteger("Profession"));
        field_70956_bz = par1NBTTagCompound.getInteger("Riches");

        if (par1NBTTagCompound.hasKey("Offers"))
        {
            NBTTagCompound nbttagcompound = par1NBTTagCompound.getCompoundTag("Offers");
            buyingList = new MerchantRecipeList(nbttagcompound);
        }
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

    public void func_70933_a(MerchantRecipe par1MerchantRecipe)
    {
        par1MerchantRecipe.func_77399_f();

        if (par1MerchantRecipe.func_77393_a((MerchantRecipe)buyingList.get(buyingList.size() - 1)))
        {
            field_70961_j = 60;
            field_70959_by = true;
        }
        else if (buyingList.size() > 1)
        {
            int i = rand.nextInt(6) + rand.nextInt(6) + 3;

            if (i <= par1MerchantRecipe.func_77392_e())
            {
                field_70961_j = 20;
                sellingRecipeList = par1MerchantRecipe;
            }
        }

        if (par1MerchantRecipe.getItemToBuy().itemID == Item.emerald.shiftedIndex)
        {
            field_70956_bz += par1MerchantRecipe.getItemToBuy().stackSize;
        }
    }

    public MerchantRecipeList func_70934_b(EntityPlayer par1EntityPlayer)
    {
        if (buyingList == null)
        {
            func_70950_c(1);
        }

        return buyingList;
    }

    private void func_70950_c(int par1)
    {
        MerchantRecipeList merchantrecipelist = new MerchantRecipeList();
        label0:

        switch (getProfession())
        {
            default:
                break;

            case 0:
                func_70948_a(merchantrecipelist, Item.wheat.shiftedIndex, rand, 0.9F);
                func_70948_a(merchantrecipelist, Block.cloth.blockID, rand, 0.5F);
                func_70948_a(merchantrecipelist, Item.chickenRaw.shiftedIndex, rand, 0.5F);
                func_70948_a(merchantrecipelist, Item.fishCooked.shiftedIndex, rand, 0.4F);
                addMerchantItem(merchantrecipelist, Item.bread.shiftedIndex, rand, 0.9F);
                addMerchantItem(merchantrecipelist, Item.melon.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.appleRed.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.cookie.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.shears.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.flintAndSteel.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.chickenCooked.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.arrow.shiftedIndex, rand, 0.5F);

                if (rand.nextFloat() < 0.5F)
                {
                    merchantrecipelist.add(new MerchantRecipe(new ItemStack(Block.gravel, 10), new ItemStack(Item.emerald), new ItemStack(Item.flint.shiftedIndex, 2 + rand.nextInt(2), 0)));
                }

                break;

            case 1:
                func_70948_a(merchantrecipelist, Item.paper.shiftedIndex, rand, 0.8F);
                func_70948_a(merchantrecipelist, Item.book.shiftedIndex, rand, 0.8F);
                func_70948_a(merchantrecipelist, Item.field_77823_bG.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Block.bookShelf.blockID, rand, 0.8F);
                addMerchantItem(merchantrecipelist, Block.glass.blockID, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.compass.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.pocketSundial.shiftedIndex, rand, 0.2F);
                break;

            case 2:
                addMerchantItem(merchantrecipelist, Item.eyeOfEnder.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.expBottle.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.redstone.shiftedIndex, rand, 0.4F);
                addMerchantItem(merchantrecipelist, Block.glowStone.blockID, rand, 0.3F);
                int ai[] =
                {
                    Item.swordSteel.shiftedIndex, Item.swordDiamond.shiftedIndex, Item.plateSteel.shiftedIndex, Item.plateDiamond.shiftedIndex, Item.axeSteel.shiftedIndex, Item.axeDiamond.shiftedIndex, Item.pickaxeSteel.shiftedIndex, Item.pickaxeDiamond.shiftedIndex
                };
                int ai1[] = ai;
                int j = ai.length;
                int k = 0;

                do
                {
                    if (k >= j)
                    {
                        break label0;
                    }

                    int l = ai1[k];

                    if (rand.nextFloat() < 0.1F)
                    {
                        merchantrecipelist.add(new MerchantRecipe(new ItemStack(l, 1, 0), new ItemStack(Item.emerald, 2 + rand.nextInt(3), 0), EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(l, 1, 0), 5 + rand.nextInt(15))));
                    }

                    k++;
                }
                while (true);

            case 3:
                func_70948_a(merchantrecipelist, Item.coal.shiftedIndex, rand, 0.7F);
                func_70948_a(merchantrecipelist, Item.ingotIron.shiftedIndex, rand, 0.5F);
                func_70948_a(merchantrecipelist, Item.ingotGold.shiftedIndex, rand, 0.5F);
                func_70948_a(merchantrecipelist, Item.diamond.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.swordSteel.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.swordDiamond.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.axeSteel.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.axeDiamond.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.pickaxeSteel.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.pickaxeDiamond.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.shovelSteel.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.shovelDiamond.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.hoeSteel.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.hoeDiamond.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.bootsSteel.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.bootsDiamond.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.helmetSteel.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.helmetDiamond.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.plateSteel.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.plateDiamond.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.legsSteel.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.legsDiamond.shiftedIndex, rand, 0.2F);
                addMerchantItem(merchantrecipelist, Item.bootsChain.shiftedIndex, rand, 0.1F);
                addMerchantItem(merchantrecipelist, Item.helmetChain.shiftedIndex, rand, 0.1F);
                addMerchantItem(merchantrecipelist, Item.plateChain.shiftedIndex, rand, 0.1F);
                addMerchantItem(merchantrecipelist, Item.legsChain.shiftedIndex, rand, 0.1F);
                break;

            case 4:
                func_70948_a(merchantrecipelist, Item.coal.shiftedIndex, rand, 0.7F);
                func_70948_a(merchantrecipelist, Item.porkRaw.shiftedIndex, rand, 0.5F);
                func_70948_a(merchantrecipelist, Item.beefRaw.shiftedIndex, rand, 0.5F);
                addMerchantItem(merchantrecipelist, Item.saddle.shiftedIndex, rand, 0.1F);
                addMerchantItem(merchantrecipelist, Item.plateLeather.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.bootsLeather.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.helmetLeather.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.legsLeather.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.porkCooked.shiftedIndex, rand, 0.3F);
                addMerchantItem(merchantrecipelist, Item.beefCooked.shiftedIndex, rand, 0.3F);
                break;
        }

        addModTrades(merchantrecipelist);

        if (merchantrecipelist.isEmpty())
        {
            func_70948_a(merchantrecipelist, Item.ingotGold.shiftedIndex, rand, 1.0F);
        }

        Collections.shuffle(merchantrecipelist);

        if (buyingList == null)
        {
            buyingList = new MerchantRecipeList();
        }

        for (int i = 0; i < par1 && i < merchantrecipelist.size(); i++)
        {
            buyingList.func_77205_a((MerchantRecipe)merchantrecipelist.get(i));
        }
    }

    private void addModTrades(MerchantRecipeList merchantrecipelist)
    {
        List list = ModLoader.getTrades(getProfession());

        if (list != null)
        {
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                TradeEntry tradeentry = (TradeEntry)iterator.next();

                if (tradeentry.buying)
                {
                    func_70948_a(merchantrecipelist, tradeentry.id, rand, tradeentry.chance);
                }
                else
                {
                    addMerchantItem(merchantrecipelist, tradeentry.id, rand, tradeentry.chance);
                }
            }
        }
    }

    private static void func_70948_a(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            par0MerchantRecipeList.add(new MerchantRecipe(func_70951_a(par1, par2Random), Item.emerald));
        }
    }

    private static ItemStack func_70951_a(int par0, Random par1Random)
    {
        return new ItemStack(par0, func_70944_b(par0, par1Random), 0);
    }

    private static int func_70944_b(int par0, Random par1Random)
    {
        Tuple tuple = (Tuple)villagersSellingList.get(Integer.valueOf(par0));
        return tuple != null ? ((Integer)tuple.getFirst()).intValue() < ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()) : ((Integer)tuple.getFirst()).intValue() : 1;
    }

    private static void addMerchantItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            int i = func_70943_c(par1, par2Random);
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

    private static int func_70943_c(int par0, Random par1Random)
    {
        Tuple tuple = (Tuple)blacksmithSellingList.get(Integer.valueOf(par0));
        return tuple != null ? ((Integer)tuple.getFirst()).intValue() < ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()) : ((Integer)tuple.getFirst()).intValue() : 1;
    }

    static
    {
        villagersSellingList = new HashMap();
        blacksmithSellingList = new HashMap();
        villagersSellingList.put(Integer.valueOf(Item.coal.shiftedIndex), new Tuple(Integer.valueOf(16), Integer.valueOf(24)));
        villagersSellingList.put(Integer.valueOf(Item.ingotIron.shiftedIndex), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        villagersSellingList.put(Integer.valueOf(Item.ingotGold.shiftedIndex), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        villagersSellingList.put(Integer.valueOf(Item.diamond.shiftedIndex), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        villagersSellingList.put(Integer.valueOf(Item.paper.shiftedIndex), new Tuple(Integer.valueOf(19), Integer.valueOf(30)));
        villagersSellingList.put(Integer.valueOf(Item.book.shiftedIndex), new Tuple(Integer.valueOf(12), Integer.valueOf(15)));
        villagersSellingList.put(Integer.valueOf(Item.field_77823_bG.shiftedIndex), new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
        villagersSellingList.put(Integer.valueOf(Item.enderPearl.shiftedIndex), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        villagersSellingList.put(Integer.valueOf(Item.eyeOfEnder.shiftedIndex), new Tuple(Integer.valueOf(2), Integer.valueOf(3)));
        villagersSellingList.put(Integer.valueOf(Item.porkRaw.shiftedIndex), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagersSellingList.put(Integer.valueOf(Item.beefRaw.shiftedIndex), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagersSellingList.put(Integer.valueOf(Item.chickenRaw.shiftedIndex), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagersSellingList.put(Integer.valueOf(Item.fishCooked.shiftedIndex), new Tuple(Integer.valueOf(9), Integer.valueOf(13)));
        villagersSellingList.put(Integer.valueOf(Item.seeds.shiftedIndex), new Tuple(Integer.valueOf(34), Integer.valueOf(48)));
        villagersSellingList.put(Integer.valueOf(Item.melonSeeds.shiftedIndex), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
        villagersSellingList.put(Integer.valueOf(Item.pumpkinSeeds.shiftedIndex), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
        villagersSellingList.put(Integer.valueOf(Item.wheat.shiftedIndex), new Tuple(Integer.valueOf(18), Integer.valueOf(22)));
        villagersSellingList.put(Integer.valueOf(Block.cloth.blockID), new Tuple(Integer.valueOf(14), Integer.valueOf(22)));
        villagersSellingList.put(Integer.valueOf(Item.rottenFlesh.shiftedIndex), new Tuple(Integer.valueOf(36), Integer.valueOf(64)));
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
                    villagersSellingList.put(Integer.valueOf(tradeentry.id), new Tuple(Integer.valueOf(tradeentry.min), Integer.valueOf(tradeentry.max)));
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
