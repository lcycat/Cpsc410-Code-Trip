package net.minecraft.src;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MerchantRecipeList extends ArrayList
{
    public MerchantRecipeList()
    {
    }

    public MerchantRecipeList(NBTTagCompound par1NBTTagCompound)
    {
        func_77201_a(par1NBTTagCompound);
    }

    public MerchantRecipe func_77203_a(ItemStack par1ItemStack, ItemStack par2ItemStack, int par3)
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

    public void func_77205_a(MerchantRecipe par1MerchantRecipe)
    {
        for (int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(i);

            if (par1MerchantRecipe.func_77393_a(merchantrecipe))
            {
                if (par1MerchantRecipe.func_77391_b(merchantrecipe))
                {
                    set(i, par1MerchantRecipe);
                }

                return;
            }
        }

        add(par1MerchantRecipe);
    }

    public void func_77200_a(DataOutputStream par1DataOutputStream) throws IOException
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

    public void func_77201_a(NBTTagCompound par1NBTTagCompound)
    {
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Recipes");

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            add(new MerchantRecipe(nbttagcompound));
        }
    }

    public NBTTagCompound func_77202_a()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        NBTTagList nbttaglist = new NBTTagList("Recipes");

        for (int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(i);
            nbttaglist.appendTag(merchantrecipe.func_77395_g());
        }

        nbttagcompound.setTag("Recipes", nbttaglist);
        return nbttagcompound;
    }
}
