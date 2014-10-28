// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityCow, EntityPlayer, InventoryPlayer, ItemStack, 
//            Item, PlayerCapabilities, ItemShears, World, 
//            EntityItem, Block, EntityAnimal

public class EntityMooshroom extends EntityCow
{

    public EntityMooshroom(World p_i3518_1_)
    {
        super(p_i3518_1_);
        field_70750_az = "/mob/redcow.png";
        func_70105_a(0.9F, 1.3F);
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();
        if(itemstack != null && itemstack.field_77993_c == Item.field_77670_E.field_77779_bT && func_70874_b() >= 0)
        {
            if(itemstack.field_77994_a == 1)
            {
                p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, new ItemStack(Item.field_77671_F));
                return true;
            }
            if(p_70085_1_.field_71071_by.func_70441_a(new ItemStack(Item.field_77671_F)) && !p_70085_1_.field_71075_bZ.field_75098_d)
            {
                p_70085_1_.field_71071_by.func_70298_a(p_70085_1_.field_71071_by.field_70461_c, 1);
                return true;
            }
        }
        if(itemstack != null && itemstack.field_77993_c == Item.field_77745_be.field_77779_bT && func_70874_b() >= 0)
        {
            func_70106_y();
            field_70170_p.func_72869_a("largeexplode", field_70165_t, field_70163_u + (double)(field_70131_O / 2.0F), field_70161_v, 0.0D, 0.0D, 0.0D);
            if(!field_70170_p.field_72995_K)
            {
                EntityCow entitycow = new EntityCow(field_70170_p);
                entitycow.func_70012_b(field_70165_t, field_70163_u, field_70161_v, field_70177_z, field_70125_A);
                entitycow.func_70606_j(func_70630_aN());
                entitycow.field_70761_aq = field_70761_aq;
                field_70170_p.func_72838_d(entitycow);
                for(int i = 0; i < 5; i++)
                {
                    field_70170_p.func_72838_d(new EntityItem(field_70170_p, field_70165_t, field_70163_u + (double)field_70131_O, field_70161_v, new ItemStack(Block.field_72103_ag)));
                }

            }
            return true;
        } else
        {
            return super.func_70085_c(p_70085_1_);
        }
    }

    public EntityAnimal func_70879_a(EntityAnimal p_70879_1_)
    {
        return new EntityMooshroom(field_70170_p);
    }
}
