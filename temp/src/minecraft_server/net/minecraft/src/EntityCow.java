// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, PathNavigate, EntityAISwimming, EntityAITasks, 
//            EntityAIPanic, EntityAIMate, EntityAITempt, Item, 
//            EntityAIFollowParent, EntityAIWander, EntityAIWatchClosest, EntityPlayer, 
//            EntityAILookIdle, InventoryPlayer, ItemStack, World

public class EntityCow extends EntityAnimal
{

    public EntityCow(World p_i3516_1_)
    {
        super(p_i3516_1_);
        field_70750_az = "/mob/cow.png";
        func_70105_a(0.9F, 1.3F);
        func_70661_as().func_75491_a(true);
        field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
        field_70714_bg.func_75776_a(2, new EntityAIMate(this, 0.2F));
        field_70714_bg.func_75776_a(3, new EntityAITempt(this, 0.25F, Item.field_77685_T.field_77779_bT, false));
        field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 0.25F));
        field_70714_bg.func_75776_a(5, new EntityAIWander(this, 0.2F));
        field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 6F));
        field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
    }

    public boolean func_70650_aV()
    {
        return true;
    }

    public int func_70667_aM()
    {
        return 10;
    }

    protected String func_70639_aQ()
    {
        return "mob.cow";
    }

    protected String func_70621_aR()
    {
        return "mob.cowhurt";
    }

    protected String func_70673_aS()
    {
        return "mob.cowhurt";
    }

    protected float func_70599_aP()
    {
        return 0.4F;
    }

    protected int func_70633_aT()
    {
        return Item.field_77770_aF.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(3) + field_70146_Z.nextInt(1 + p_70628_2_);
        for(int j = 0; j < i; j++)
        {
            func_70025_b(Item.field_77770_aF.field_77779_bT, 1);
        }

        i = field_70146_Z.nextInt(3) + 1 + field_70146_Z.nextInt(1 + p_70628_2_);
        for(int k = 0; k < i; k++)
        {
            if(func_70027_ad())
            {
                func_70025_b(Item.field_77734_bj.field_77779_bT, 1);
            } else
            {
                func_70025_b(Item.field_77741_bi.field_77779_bT, 1);
            }
        }

    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();
        if(itemstack != null && itemstack.field_77993_c == Item.field_77788_aw.field_77779_bT)
        {
            if(--itemstack.field_77994_a <= 0)
            {
                p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, new ItemStack(Item.field_77771_aG));
            } else
            if(!p_70085_1_.field_71071_by.func_70441_a(new ItemStack(Item.field_77771_aG)))
            {
                p_70085_1_.func_71021_b(new ItemStack(Item.field_77771_aG.field_77779_bT, 1, 0));
            }
            return true;
        } else
        {
            return super.func_70085_c(p_70085_1_);
        }
    }

    public EntityAnimal func_70879_a(EntityAnimal p_70879_1_)
    {
        return new EntityCow(field_70170_p);
    }
}
