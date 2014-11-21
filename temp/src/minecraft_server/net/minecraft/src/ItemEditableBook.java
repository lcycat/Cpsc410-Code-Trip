// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, ItemWritableBook, NBTTagCompound, EntityPlayer, 
//            ItemStack, World

public class ItemEditableBook extends Item
{

    public ItemEditableBook(int p_i3698_1_)
    {
        super(p_i3698_1_);
        func_77625_d(1);
    }

    public static boolean func_77828_a(NBTTagCompound p_77828_0_)
    {
        if(!ItemWritableBook.func_77829_a(p_77828_0_))
        {
            return false;
        }
        if(!p_77828_0_.func_74764_b("title"))
        {
            return false;
        }
        String s = p_77828_0_.func_74779_i("title");
        if(s == null || s.length() > 16)
        {
            return false;
        }
        return p_77828_0_.func_74764_b("author");
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        p_77659_3_.func_71048_c(p_77659_1_);
        return p_77659_1_;
    }

    public boolean func_77651_p()
    {
        return true;
    }
}
