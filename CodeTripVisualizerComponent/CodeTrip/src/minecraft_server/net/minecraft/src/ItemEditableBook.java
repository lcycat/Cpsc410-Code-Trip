package net.minecraft.src;

public class ItemEditableBook extends Item
{
    public ItemEditableBook(int par1)
    {
        super(par1);
        setMaxStackSize(1);
    }

    public static boolean validBookTagContents(NBTTagCompound par0NBTTagCompound)
    {
        if (!ItemWritableBook.validBookTagPages(par0NBTTagCompound))
        {
            return false;
        }

        if (!par0NBTTagCompound.hasKey("title"))
        {
            return false;
        }

        String s = par0NBTTagCompound.getString("title");

        if (s == null || s.length() > 16)
        {
            return false;
        }

        return par0NBTTagCompound.hasKey("author");
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.displayGUIBook(par1ItemStack);
        return par1ItemStack;
    }

    /**
     * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
     */
    public boolean getShareTag()
    {
        return true;
    }
}
