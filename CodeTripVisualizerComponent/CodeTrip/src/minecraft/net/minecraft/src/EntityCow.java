package net.minecraft.src;

import java.util.Random;

public class EntityCow extends EntityAnimal
{
    public EntityCow(World par1World)
    {
        super(par1World);
        texture = "/mob/cow.png";
        setSize(0.9F, 1.3F);
        getNavigator().setAvoidsWater(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        tasks.addTask(2, new EntityAIMate(this, 0.2F));
        tasks.addTask(3, new EntityAITempt(this, 0.25F, Item.wheat.shiftedIndex, false));
        tasks.addTask(4, new EntityAIFollowParent(this, 0.25F));
        tasks.addTask(5, new EntityAIWander(this, 0.2F));
        tasks.addTask(6, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 6F));
        tasks.addTask(7, new EntityAILookIdle(this));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    public int getMaxHealth()
    {
        return 10;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.cow";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.cowhurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.cowhurt";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.leather.shiftedIndex;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        int i = rand.nextInt(3) + rand.nextInt(1 + par2);

        for (int j = 0; j < i; j++)
        {
            dropItem(Item.leather.shiftedIndex, 1);
        }

        i = rand.nextInt(3) + 1 + rand.nextInt(1 + par2);

        for (int k = 0; k < i; k++)
        {
            if (isBurning())
            {
                dropItem(Item.beefCooked.shiftedIndex, 1);
            }
            else
            {
                dropItem(Item.beefRaw.shiftedIndex, 1);
            }
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

        if (itemstack != null && itemstack.itemID == Item.bucketEmpty.shiftedIndex)
        {
            if (--itemstack.stackSize <= 0)
            {
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(Item.bucketMilk));
            }
            else if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketMilk)))
            {
                par1EntityPlayer.dropPlayerItem(new ItemStack(Item.bucketMilk.shiftedIndex, 1, 0));
            }

            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
    }

    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return new EntityCow(worldObj);
    }
}
