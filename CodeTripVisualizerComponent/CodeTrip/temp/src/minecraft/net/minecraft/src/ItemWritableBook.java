// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, NBTTagCompound, NBTTagList, 
//            NBTTagString, ItemStack, World

public class ItemWritableBook extends Item
{

    public ItemWritableBook(int p_i3697_1_)
    {
        super(p_i3697_1_);
        func_77625_d(1);
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

    public static boolean func_77829_a(NBTTagCompound p_77829_0_)
    {
        if(p_77829_0_ == null)
        {
            return false;
        }
        if(!p_77829_0_.func_74764_b("pages"))
        {
            return false;
        }
        NBTTagList nbttaglist = (NBTTagList)p_77829_0_.func_74781_a("pages");
        for(int i = 0; i < nbttaglist.func_74745_c(); i++)
        {
            NBTTagString nbttagstring = (NBTTagString)nbttaglist.func_74743_b(i);
            if(nbttagstring.field_74751_a == null)
            {
                return false;
            }
            if(nbttagstring.field_74751_a.length() > 256)
            {
                return false;
            }
        }

        return true;
    }
}
