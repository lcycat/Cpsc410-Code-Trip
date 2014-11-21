// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, MovingObjectPosition, EnumMovingObjectType, 
//            World, EntityPlayer, Material, ItemStack, 
//            InventoryPlayer, ItemPotion

public class ItemGlassBottle extends Item
{

    public ItemGlassBottle(int p_i3622_1_)
    {
        super(p_i3622_1_);
        func_77637_a(CreativeTabs.field_78038_k);
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        MovingObjectPosition movingobjectposition = func_77621_a(p_77659_2_, p_77659_3_, true);
        if(movingobjectposition == null)
        {
            return p_77659_1_;
        }
        if(movingobjectposition.field_72313_a == EnumMovingObjectType.TILE)
        {
            int i = movingobjectposition.field_72311_b;
            int j = movingobjectposition.field_72312_c;
            int k = movingobjectposition.field_72309_d;
            if(!p_77659_2_.func_72962_a(p_77659_3_, i, j, k))
            {
                return p_77659_1_;
            }
            if(!p_77659_3_.func_71031_e(i, j, k))
            {
                return p_77659_1_;
            }
            if(p_77659_2_.func_72803_f(i, j, k) == Material.field_76244_g)
            {
                p_77659_1_.field_77994_a--;
                if(p_77659_1_.field_77994_a <= 0)
                {
                    return new ItemStack(Item.field_77726_bs);
                }
                if(!p_77659_3_.field_71071_by.func_70441_a(new ItemStack(Item.field_77726_bs)))
                {
                    p_77659_3_.func_71021_b(new ItemStack(Item.field_77726_bs.field_77779_bT, 1, 0));
                }
            }
        }
        return p_77659_1_;
    }
}
