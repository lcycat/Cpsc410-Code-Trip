// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Item, ItemWritableBook, NBTTagCompound, ItemStack, 
//            NBTTagString, StatCollector, EntityPlayer, World

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

    public String func_77628_j(ItemStack p_77628_1_)
    {
        if(p_77628_1_.func_77942_o())
        {
            NBTTagCompound nbttagcompound = p_77628_1_.func_77978_p();
            NBTTagString nbttagstring = (NBTTagString)nbttagcompound.func_74781_a("title");
            if(nbttagstring != null)
            {
                return nbttagstring.toString();
            }
        }
        return super.func_77628_j(p_77628_1_);
    }

    public void func_77624_a(ItemStack p_77624_1_, List p_77624_2_)
    {
        if(p_77624_1_.func_77942_o())
        {
            NBTTagCompound nbttagcompound = p_77624_1_.func_77978_p();
            NBTTagString nbttagstring = (NBTTagString)nbttagcompound.func_74781_a("author");
            if(nbttagstring != null)
            {
                p_77624_2_.add((new StringBuilder()).append("\2477").append(String.format(StatCollector.func_74837_a("book.byAuthor", new Object[] {
                    nbttagstring.field_74751_a
                }), new Object[0])).toString());
            }
        }
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

    public boolean func_77636_d(ItemStack p_77636_1_)
    {
        return true;
    }
}
