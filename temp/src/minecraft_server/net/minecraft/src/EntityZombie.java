// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, PathNavigate, EntityAISwimming, EntityAITasks, 
//            EntityAIBreakDoor, EntityAIAttackOnCollide, EntityPlayer, EntityVillager, 
//            EntityAIMoveTwardsRestriction, EntityAIMoveThroughVillage, EntityAIWander, EntityAIWatchClosest, 
//            EntityAILookIdle, EntityAIHurtByTarget, EntityAINearestAttackableTarget, World, 
//            MathHelper, Item, EnumCreatureAttribute

public class EntityZombie extends EntityMob
{

    public EntityZombie(World p_i3558_1_)
    {
        super(p_i3558_1_);
        field_70750_az = "/mob/zombie.png";
        field_70697_bw = 0.23F;
        field_70815_f = 4;
        func_70661_as().func_75498_b(true);
        field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(1, new EntityAIBreakDoor(this));
        field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, net.minecraft.src.EntityPlayer.class, field_70697_bw, false));
        field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, net.minecraft.src.EntityVillager.class, field_70697_bw, true));
        field_70714_bg.func_75776_a(4, new EntityAIMoveTwardsRestriction(this, field_70697_bw));
        field_70714_bg.func_75776_a(5, new EntityAIMoveThroughVillage(this, field_70697_bw, false));
        field_70714_bg.func_75776_a(6, new EntityAIWander(this, field_70697_bw));
        field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
        field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
        field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false));
        field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityPlayer.class, 16F, 0, true));
        field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityVillager.class, 16F, 0, false));
    }

    public int func_70667_aM()
    {
        return 20;
    }

    public int func_70658_aO()
    {
        return 2;
    }

    protected boolean func_70650_aV()
    {
        return true;
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

    protected String func_70639_aQ()
    {
        return "mob.zombie";
    }

    protected String func_70621_aR()
    {
        return "mob.zombiehurt";
    }

    protected String func_70673_aS()
    {
        return "mob.zombiedeath";
    }

    protected int func_70633_aT()
    {
        return Item.field_77737_bm.field_77779_bT;
    }

    public EnumCreatureAttribute func_70668_bt()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected void func_70600_l(int p_70600_1_)
    {
        switch(field_70146_Z.nextInt(4))
        {
        case 0: // '\0'
            func_70025_b(Item.field_77716_q.field_77779_bT, 1);
            break;

        case 1: // '\001'
            func_70025_b(Item.field_77812_ad.field_77779_bT, 1);
            break;

        case 2: // '\002'
            func_70025_b(Item.field_77703_o.field_77779_bT, 1);
            break;

        case 3: // '\003'
            func_70025_b(Item.field_77695_f.field_77779_bT, 1);
            break;
        }
    }
}
