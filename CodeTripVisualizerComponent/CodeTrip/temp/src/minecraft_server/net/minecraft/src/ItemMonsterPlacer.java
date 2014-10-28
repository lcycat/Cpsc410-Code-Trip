// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.HashMap;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, World, Facing, 
//            Block, ItemStack, EntityPlayer, PlayerCapabilities, 
//            EntityList, Entity, EntityVillager, EntityLiving

public class ItemMonsterPlacer extends Item
{

    public ItemMonsterPlacer(int p_i3671_1_)
    {
        super(p_i3671_1_);
        func_77627_a(true);
        func_77637_a(CreativeTabs.field_78026_f);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(p_77648_3_.field_72995_K)
        {
            return true;
        }
        int i = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
        p_77648_4_ += Facing.field_71586_b[p_77648_7_];
        p_77648_5_ += Facing.field_71587_c[p_77648_7_];
        p_77648_6_ += Facing.field_71585_d[p_77648_7_];
        double d = 0.0D;
        if(p_77648_7_ == 1 && i == Block.field_72031_aZ.field_71990_ca || i == Block.field_72098_bB.field_71990_ca)
        {
            d = 0.5D;
        }
        if(func_77840_a(p_77648_3_, p_77648_1_.func_77960_j(), (double)p_77648_4_ + 0.5D, (double)p_77648_5_ + d, (double)p_77648_6_ + 0.5D) && !p_77648_2_.field_71075_bZ.field_75098_d)
        {
            p_77648_1_.field_77994_a--;
        }
        return true;
    }

    public static boolean func_77840_a(World p_77840_0_, int p_77840_1_, double p_77840_2_, double p_77840_4_, double p_77840_6_)
    {
        if(!EntityList.field_75627_a.containsKey(Integer.valueOf(p_77840_1_)))
        {
            return false;
        }
        Entity entity = EntityList.func_75616_a(p_77840_1_, p_77840_0_);
        if(entity != null)
        {
            entity.func_70012_b(p_77840_2_, p_77840_4_, p_77840_6_, p_77840_0_.field_73012_v.nextFloat() * 360F, 0.0F);
            if(entity instanceof EntityVillager)
            {
                EntityVillager entityvillager = (EntityVillager)entity;
                entityvillager.func_70938_b(entityvillager.func_70681_au().nextInt(5));
                p_77840_0_.func_72838_d(entityvillager);
                return true;
            }
            p_77840_0_.func_72838_d(entity);
            ((EntityLiving)entity).func_70642_aH();
        }
        return entity != null;
    }
}
