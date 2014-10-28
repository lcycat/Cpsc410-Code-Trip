// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package net.minecraft.src:
//            MerchantRecipe, ItemStack, Packet, NBTTagCompound, 
//            NBTTagList

public class MerchantRecipeList extends ArrayList
{

    public MerchantRecipeList()
    {
    }

    public MerchantRecipeList(NBTTagCompound p_i3725_1_)
    {
        func_77201_a(p_i3725_1_);
    }

    public MerchantRecipe func_77203_a(ItemStack p_77203_1_, ItemStack p_77203_2_, int p_77203_3_)
    {
        if(p_77203_3_ > 0 && p_77203_3_ < size())
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(p_77203_3_);
            if(p_77203_1_.field_77993_c == merchantrecipe.func_77394_a().field_77993_c && (p_77203_2_ == null && !merchantrecipe.func_77398_c() || merchantrecipe.func_77398_c() && p_77203_2_ != null && merchantrecipe.func_77396_b().field_77993_c == p_77203_2_.field_77993_c))
            {
                if(p_77203_1_.field_77994_a >= merchantrecipe.func_77394_a().field_77994_a && (!merchantrecipe.func_77398_c() || p_77203_2_.field_77994_a >= merchantrecipe.func_77396_b().field_77994_a))
                {
                    return merchantrecipe;
                } else
                {
                    return null;
                }
            }
        }
        for(int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe1 = (MerchantRecipe)get(i);
            if(p_77203_1_.field_77993_c == merchantrecipe1.func_77394_a().field_77993_c && p_77203_1_.field_77994_a >= merchantrecipe1.func_77394_a().field_77994_a && (!merchantrecipe1.func_77398_c() && p_77203_2_ == null || merchantrecipe1.func_77398_c() && p_77203_2_ != null && merchantrecipe1.func_77396_b().field_77993_c == p_77203_2_.field_77993_c && p_77203_2_.field_77994_a >= merchantrecipe1.func_77396_b().field_77994_a))
            {
                return merchantrecipe1;
            }
        }

        return null;
    }

    public void func_77205_a(MerchantRecipe p_77205_1_)
    {
        for(int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(i);
            if(p_77205_1_.func_77393_a(merchantrecipe))
            {
                if(p_77205_1_.func_77391_b(merchantrecipe))
                {
                    set(i, p_77205_1_);
                }
                return;
            }
        }

        add(p_77205_1_);
    }

    public void func_77200_a(DataOutputStream p_77200_1_)
        throws IOException
    {
        p_77200_1_.writeByte((byte)(size() & 0xff));
        for(int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(i);
            Packet.func_73270_a(merchantrecipe.func_77394_a(), p_77200_1_);
            Packet.func_73270_a(merchantrecipe.func_77397_d(), p_77200_1_);
            ItemStack itemstack = merchantrecipe.func_77396_b();
            p_77200_1_.writeBoolean(itemstack != null);
            if(itemstack != null)
            {
                Packet.func_73270_a(itemstack, p_77200_1_);
            }
        }

    }

    public void func_77201_a(NBTTagCompound p_77201_1_)
    {
        NBTTagList nbttaglist = p_77201_1_.func_74761_m("Recipes");
        for(int i = 0; i < nbttaglist.func_74745_c(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_74743_b(i);
            add(new MerchantRecipe(nbttagcompound));
        }

    }

    public NBTTagCompound func_77202_a()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        NBTTagList nbttaglist = new NBTTagList("Recipes");
        for(int i = 0; i < size(); i++)
        {
            MerchantRecipe merchantrecipe = (MerchantRecipe)get(i);
            nbttaglist.func_74742_a(merchantrecipe.func_77395_g());
        }

        nbttagcompound.func_74782_a("Recipes", nbttaglist);
        return nbttagcompound;
    }
}
