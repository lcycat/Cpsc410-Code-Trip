package net.minecraft.src;

import java.io.*;
import java.util.ArrayList;

public class MerchantRecipeList extends ArrayList
{
    public MerchantRecipeList()
    {
    }

    public MerchantRecipeList(NBTTagCompound par1NBTTagCompound)
    {
        readRecipiesFromTags(par1NBTTagCompound);
    }

    /**
     * can par1,par2 be used to in crafting recipe par3
     */
    public MerchantRecipe canRecipeBeUsed(ItemStack par1ItemStack, ItemStack par2ItemStack, int par3)
    {
        if (par3 > 0 && par3 < size())
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(par3);

            if (par1ItemStack.itemID == merchantrecipe.getItemToBuy().itemID && (par2ItemStack == null && !merchantrecipe.hasSecondItemToBuy() || merchantrecipe.hasSecondItemToBuy() && par2ItemStack != null && merchantrecipe.getSecondItemToBuy().itemID == par2ItemStack.itemID))
            {
                if (par1ItemStack.stackSize >= merchantrecipe.getItemToBuy().stackSize && (!merchantrecipe.hasSecondItemToBuy() || par2ItemStack.stackSize >= merchantrecipe.getSecondItemToBuy().stackSize))
                {
                    return merchantrecipe;
                }
                else
                {
                    return null;
                }
            }
        }

        for (int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe1 = (MerchantRecipe)get(i);

            if (par1ItemStack.itemID == merchantrecipe1.getItemToBuy().itemID && par1ItemStack.stackSize >= merchantrecipe1.getItemToBuy().stackSize && (!merchantrecipe1.hasSecondItemToBuy() && par2ItemStack == null || merchantrecipe1.hasSecondItemToBuy() && par2ItemStack != null && merchantrecipe1.getSecondItemToBuy().itemID == par2ItemStack.itemID && par2ItemStack.stackSize >= merchantrecipe1.getSecondItemToBuy().stackSize))
            {
                return merchantrecipe1;
            }
        }

        return null;
    }

    /**
     * checks if there is a recipie for the same ingredients already on the list, and replaces it. otherwise, adds it
     */
    public void addToListWithCheck(MerchantRecipe par1MerchantRecipe)
    {
        for (int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(i);

            if (par1MerchantRecipe.hasSameIDsAs(merchantrecipe))
            {
                if (par1MerchantRecipe.hasSameItemsAs(merchantrecipe))
                {
                    set(i, par1MerchantRecipe);
                }

                return;
            }
        }

        add(par1MerchantRecipe);
    }

    public void writeRecipiesToStream(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeByte((byte)(size() & 0xff));

        for (int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(i);
            Packet.writeItemStack(merchantrecipe.getItemToBuy(), par1DataOutputStream);
            Packet.writeItemStack(merchantrecipe.getItemToSell(), par1DataOutputStream);
            ItemStack itemstack = merchantrecipe.getSecondItemToBuy();
            par1DataOutputStream.writeBoolean(itemstack != null);

            if (itemstack != null)
            {
                Packet.writeItemStack(itemstack, par1DataOutputStream);
            }
        }
    }

    public static MerchantRecipeList readRecipiesFromStream(DataInputStream par0DataInputStream) throws IOException
    {
        MerchantRecipeList merchantrecipelist = new MerchantRecipeList();
        int i = par0DataInputStream.readByte() & 0xff;

        for (int j = 0; j < i; j++)
        {
            ItemStack itemstack = Packet.readItemStack(par0DataInputStream);
            ItemStack itemstack1 = Packet.readItemStack(par0DataInputStream);
            ItemStack itemstack2 = null;

            if (par0DataInputStream.readBoolean())
            {
                itemstack2 = Packet.readItemStack(par0DataInputStream);
            }

            merchantrecipelist.add(new MerchantRecipe(itemstack, itemstack2, itemstack1));
        }

        return merchantrecipelist;
    }

    public void readRecipiesFromTags(NBTTagCompound par1NBTTagCompound)
    {
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Recipes");

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            add(new MerchantRecipe(nbttagcompound));
        }
    }

    public NBTTagCompound getRecipiesAsTags()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        NBTTagList nbttaglist = new NBTTagList("Recipes");

        for (int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(i);
            nbttaglist.appendTag(merchantrecipe.writeToTags());
        }

        nbttagcompound.setTag("Recipes", nbttaglist);
        return nbttagcompound;
    }
}
