// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, EntityPig, ItemStack, 
//            EntityLiving

public class ItemSaddle extends Item
{

    public ItemSaddle(int p_i3679_1_)
    {
        super(p_i3679_1_);
        field_77777_bU = 1;
        func_77637_a(CreativeTabs.field_78029_e);
    }

    public boolean func_77646_a(ItemStack p_77646_1_, EntityLiving p_77646_2_)
    {
        if(p_77646_2_ instanceof EntityPig)
        {
            EntityPig entitypig = (EntityPig)p_77646_2_;
            if(!entitypig.func_70901_n() && !entitypig.func_70631_g_())
            {
                entitypig.func_70900_e(true);
                p_77646_1_.field_77994_a--;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean func_77644_a(ItemStack p_77644_1_, EntityLiving p_77644_2_, EntityLiving p_77644_3_)
    {
        func_77646_a(p_77644_1_, p_77644_2_);
        return true;
    }
}
