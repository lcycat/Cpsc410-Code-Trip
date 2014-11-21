// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemColored, MovingObjectPosition, EnumMovingObjectType, World, 
//            EntityPlayer, Material, Block, PlayerCapabilities, 
//            ItemStack

public class ItemLilyPad extends ItemColored
{

    public ItemLilyPad(int p_i3694_1_)
    {
        super(p_i3694_1_, false);
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
            if(p_77659_2_.func_72803_f(i, j, k) == Material.field_76244_g && p_77659_2_.func_72805_g(i, j, k) == 0 && p_77659_2_.func_72799_c(i, j + 1, k))
            {
                p_77659_2_.func_72859_e(i, j + 1, k, Block.field_71991_bz.field_71990_ca);
                if(!p_77659_3_.field_71075_bZ.field_75098_d)
                {
                    p_77659_1_.field_77994_a--;
                }
            }
        }
        return p_77659_1_;
    }
}
