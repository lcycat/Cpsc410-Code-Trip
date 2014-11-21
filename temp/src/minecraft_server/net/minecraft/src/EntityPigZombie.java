// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityZombie, World, NBTTagCompound, DamageSource, 
//            EntityPlayer, AxisAlignedBB, Entity, Item, 
//            ItemStack, EnchantmentHelper

public class EntityPigZombie extends EntityZombie
{

    private int field_70837_d;
    private int field_70838_e;
    private static final ItemStack field_70836_g;

    public EntityPigZombie(World p_i3553_1_)
    {
        super(p_i3553_1_);
        field_70837_d = 0;
        field_70838_e = 0;
        field_70750_az = "/mob/pigzombie.png";
        field_70697_bw = 0.5F;
        field_70815_f = 5;
        field_70178_ae = true;
    }

    protected boolean func_70650_aV()
    {
        return false;
    }

    public void func_70071_h_()
    {
        field_70697_bw = field_70789_a == null ? 0.5F : 0.95F;
        if(field_70838_e > 0 && --field_70838_e == 0)
        {
            field_70170_p.func_72956_a(this, "mob.zombiepig.zpigangry", func_70599_aP() * 2.0F, ((field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }
        super.func_70071_h_();
    }

    public boolean func_70601_bi()
    {
        return field_70170_p.field_73013_u > 0 && field_70170_p.func_72855_b(field_70121_D) && field_70170_p.func_72945_a(this, field_70121_D).isEmpty() && !field_70170_p.func_72953_d(field_70121_D);
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74777_a("Anger", (short)field_70837_d);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        field_70837_d = p_70037_1_.func_74765_d("Anger");
    }

    protected Entity func_70782_k()
    {
        if(field_70837_d == 0)
        {
            return null;
        } else
        {
            return super.func_70782_k();
        }
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        Entity entity = p_70097_1_.func_76346_g();
        if(entity instanceof EntityPlayer)
        {
            List list = field_70170_p.func_72839_b(this, field_70121_D.func_72314_b(32D, 32D, 32D));
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                Entity entity1 = (Entity)iterator.next();
                if(entity1 instanceof EntityPigZombie)
                {
                    EntityPigZombie entitypigzombie = (EntityPigZombie)entity1;
                    entitypigzombie.func_70835_c(entity);
                }
            } while(true);
            func_70835_c(entity);
        }
        return super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    private void func_70835_c(Entity p_70835_1_)
    {
        field_70789_a = p_70835_1_;
        field_70837_d = 400 + field_70146_Z.nextInt(400);
        field_70838_e = field_70146_Z.nextInt(40);
    }

    protected String func_70639_aQ()
    {
        return "mob.zombiepig.zpig";
    }

    protected String func_70621_aR()
    {
        return "mob.zombiepig.zpighurt";
    }

    protected String func_70673_aS()
    {
        return "mob.zombiepig.zpigdeath";
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(2 + p_70628_2_);
        for(int j = 0; j < i; j++)
        {
            func_70025_b(Item.field_77737_bm.field_77779_bT, 1);
        }

        i = field_70146_Z.nextInt(2 + p_70628_2_);
        for(int k = 0; k < i; k++)
        {
            func_70025_b(Item.field_77733_bq.field_77779_bT, 1);
        }

    }

    protected void func_70600_l(int p_70600_1_)
    {
        if(p_70600_1_ > 0)
        {
            ItemStack itemstack = new ItemStack(Item.field_77672_G);
            EnchantmentHelper.func_77504_a(field_70146_Z, itemstack, 5);
            func_70099_a(itemstack, 0.0F);
        } else
        {
            int i = field_70146_Z.nextInt(3);
            if(i == 0)
            {
                func_70025_b(Item.field_77717_p.field_77779_bT, 1);
            } else
            if(i == 1)
            {
                func_70025_b(Item.field_77672_G.field_77779_bT, 1);
            } else
            if(i == 2)
            {
                func_70025_b(Item.field_77796_al.field_77779_bT, 1);
            }
        }
    }

    protected int func_70633_aT()
    {
        return Item.field_77737_bm.field_77779_bT;
    }

    static 
    {
        field_70836_g = new ItemStack(Item.field_77672_G, 1);
    }
}
