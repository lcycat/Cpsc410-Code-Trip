// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, PathNavigate, EntityAISwimming, EntityAITasks, 
//            EntityAIPanic, EntityAIMate, EntityAITempt, Item, 
//            EntityAIFollowParent, EntityAIWander, EntityAIWatchClosest, EntityPlayer, 
//            EntityAILookIdle, DataWatcher, NBTTagCompound, World, 
//            EntityPigZombie, AchievementList, EntityLightningBolt

public class EntityPig extends EntityAnimal
{

    public EntityPig(World p_i3520_1_)
    {
        super(p_i3520_1_);
        field_70750_az = "/mob/pig.png";
        func_70105_a(0.9F, 0.9F);
        func_70661_as().func_75491_a(true);
        float f = 0.25F;
        field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
        field_70714_bg.func_75776_a(2, new EntityAIMate(this, f));
        field_70714_bg.func_75776_a(3, new EntityAITempt(this, 0.25F, Item.field_77685_T.field_77779_bT, false));
        field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 0.28F));
        field_70714_bg.func_75776_a(5, new EntityAIWander(this, f));
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

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74757_a("Saddle", func_70901_n());
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        func_70900_e(p_70037_1_.func_74767_n("Saddle"));
    }

    protected String func_70639_aQ()
    {
        return "mob.pig";
    }

    protected String func_70621_aR()
    {
        return "mob.pig";
    }

    protected String func_70673_aS()
    {
        return "mob.pigdeath";
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        if(!super.func_70085_c(p_70085_1_))
        {
            if(func_70901_n() && !field_70170_p.field_72995_K && (field_70153_n == null || field_70153_n == p_70085_1_))
            {
                p_70085_1_.func_70078_a(this);
                return true;
            } else
            {
                return false;
            }
        } else
        {
            return true;
        }
    }

    protected int func_70633_aT()
    {
        if(func_70027_ad())
        {
            return Item.field_77782_ar.field_77779_bT;
        } else
        {
            return Item.field_77784_aq.field_77779_bT;
        }
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(3) + 1 + field_70146_Z.nextInt(1 + p_70628_2_);
        for(int j = 0; j < i; j++)
        {
            if(func_70027_ad())
            {
                func_70025_b(Item.field_77782_ar.field_77779_bT, 1);
            } else
            {
                func_70025_b(Item.field_77784_aq.field_77779_bT, 1);
            }
        }

    }

    public boolean func_70901_n()
    {
        return (field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void func_70900_e(boolean p_70900_1_)
    {
        if(p_70900_1_)
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)1));
        } else
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)0));
        }
    }

    public void func_70077_a(EntityLightningBolt p_70077_1_)
    {
        if(field_70170_p.field_72995_K)
        {
            return;
        } else
        {
            EntityPigZombie entitypigzombie = new EntityPigZombie(field_70170_p);
            entitypigzombie.func_70012_b(field_70165_t, field_70163_u, field_70161_v, field_70177_z, field_70125_A);
            field_70170_p.func_72838_d(entitypigzombie);
            func_70106_y();
            return;
        }
    }

    protected void func_70069_a(float p_70069_1_)
    {
        super.func_70069_a(p_70069_1_);
        if(p_70069_1_ > 5F && (field_70153_n instanceof EntityPlayer))
        {
            ((EntityPlayer)field_70153_n).func_71029_a(AchievementList.field_76021_u);
        }
    }

    public EntityAnimal func_70879_a(EntityAnimal p_70879_1_)
    {
        return new EntityPig(field_70170_p);
    }
}
