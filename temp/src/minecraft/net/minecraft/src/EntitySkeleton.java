// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, EntityAISwimming, EntityAITasks, EntityAIRestrictSun, 
//            EntityAIFleeSun, EntityAIArrowAttack, EntityAIWander, EntityAIWatchClosest, 
//            EntityPlayer, EntityAILookIdle, EntityAIHurtByTarget, EntityAINearestAttackableTarget, 
//            EnumCreatureAttribute, World, MathHelper, DamageSource, 
//            EntityArrow, AchievementList, Item, ItemStack, 
//            EnchantmentHelper

public class EntitySkeleton extends EntityMob
{

    private static final ItemStack field_70842_d;

    public EntitySkeleton(World p_i3555_1_)
    {
        super(p_i3555_1_);
        field_70750_az = "/mob/skeleton.png";
        field_70697_bw = 0.25F;
        field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(2, new EntityAIRestrictSun(this));
        field_70714_bg.func_75776_a(3, new EntityAIFleeSun(this, field_70697_bw));
        field_70714_bg.func_75776_a(4, new EntityAIArrowAttack(this, field_70697_bw, 1, 60));
        field_70714_bg.func_75776_a(5, new EntityAIWander(this, field_70697_bw));
        field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
        field_70714_bg.func_75776_a(6, new EntityAILookIdle(this));
        field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false));
        field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityPlayer.class, 16F, 0, true));
    }

    public boolean func_70650_aV()
    {
        return true;
    }

    public int func_70667_aM()
    {
        return 20;
    }

    protected String func_70639_aQ()
    {
        return "mob.skeleton";
    }

    protected String func_70621_aR()
    {
        return "mob.skeletonhurt";
    }

    protected String func_70673_aS()
    {
        return "mob.skeletonhurt";
    }

    public ItemStack func_70694_bm()
    {
        return field_70842_d;
    }

    public EnumCreatureAttribute func_70668_bt()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    public void func_70636_d()
    {
        if(field_70170_p.func_72935_r() && !field_70170_p.field_72995_K)
        {
            float f = func_70013_c(1.0F);
            if(f > 0.5F && field_70170_p.func_72937_j(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v)) && field_70146_Z.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                func_70015_d(8);
            }
        }
        super.func_70636_d();
    }

    public void func_70645_a(DamageSource p_70645_1_)
    {
        super.func_70645_a(p_70645_1_);
        if((p_70645_1_.func_76364_f() instanceof EntityArrow) && (p_70645_1_.func_76346_g() instanceof EntityPlayer))
        {
            EntityPlayer entityplayer = (EntityPlayer)p_70645_1_.func_76346_g();
            double d = entityplayer.field_70165_t - field_70165_t;
            double d1 = entityplayer.field_70161_v - field_70161_v;
            if(d * d + d1 * d1 >= 2500D)
            {
                entityplayer.func_71029_a(AchievementList.field_76020_v);
            }
        }
    }

    protected int func_70633_aT()
    {
        return Item.field_77704_l.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(3 + p_70628_2_);
        for(int j = 0; j < i; j++)
        {
            func_70025_b(Item.field_77704_l.field_77779_bT, 1);
        }

        i = field_70146_Z.nextInt(3 + p_70628_2_);
        for(int k = 0; k < i; k++)
        {
            func_70025_b(Item.field_77755_aX.field_77779_bT, 1);
        }

    }

    protected void func_70600_l(int p_70600_1_)
    {
        if(p_70600_1_ > 0)
        {
            ItemStack itemstack = new ItemStack(Item.field_77707_k);
            EnchantmentHelper.func_77504_a(field_70146_Z, itemstack, 5);
            func_70099_a(itemstack, 0.0F);
        } else
        {
            func_70025_b(Item.field_77707_k.field_77779_bT, 1);
        }
    }

    static 
    {
        field_70842_d = new ItemStack(Item.field_77707_k, 1);
    }
}
