// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, EntityAISwimming, EntityAITasks, EntityAICreeperSwell, 
//            EntityAIAvoidEntity, EntityOcelot, EntityAIAttackOnCollide, EntityAIWander, 
//            EntityAIWatchClosest, EntityPlayer, EntityAILookIdle, EntityAINearestAttackableTarget, 
//            EntityAIHurtByTarget, DataWatcher, NBTTagCompound, World, 
//            DamageSource, EntitySkeleton, Item, Entity, 
//            EntityLightningBolt

public class EntityCreeper extends EntityMob
{

    int field_70833_d;
    int field_70834_e;

    public EntityCreeper(World p_i3547_1_)
    {
        super(p_i3547_1_);
        field_70750_az = "/mob/creeper.png";
        field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(2, new EntityAICreeperSwell(this));
        field_70714_bg.func_75776_a(3, new EntityAIAvoidEntity(this, net.minecraft.src.EntityOcelot.class, 6F, 0.25F, 0.3F));
        field_70714_bg.func_75776_a(4, new EntityAIAttackOnCollide(this, 0.25F, false));
        field_70714_bg.func_75776_a(5, new EntityAIWander(this, 0.2F));
        field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
        field_70714_bg.func_75776_a(6, new EntityAILookIdle(this));
        field_70715_bh.func_75776_a(1, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityPlayer.class, 16F, 0, true));
        field_70715_bh.func_75776_a(2, new EntityAIHurtByTarget(this, false));
    }

    public boolean func_70650_aV()
    {
        return true;
    }

    public int func_70667_aM()
    {
        return 20;
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, Byte.valueOf((byte)-1));
        field_70180_af.func_75682_a(17, Byte.valueOf((byte)0));
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        if(field_70180_af.func_75683_a(17) == 1)
        {
            p_70014_1_.func_74757_a("powered", true);
        }
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        field_70180_af.func_75692_b(17, Byte.valueOf((byte)(p_70037_1_.func_74767_n("powered") ? 1 : 0)));
    }

    public void func_70071_h_()
    {
        if(func_70089_S())
        {
            field_70834_e = field_70833_d;
            int i = func_70832_p();
            if(i > 0 && field_70833_d == 0)
            {
                field_70170_p.func_72956_a(this, "random.fuse", 1.0F, 0.5F);
            }
            field_70833_d += i;
            if(field_70833_d < 0)
            {
                field_70833_d = 0;
            }
            if(field_70833_d >= 30)
            {
                field_70833_d = 30;
                if(!field_70170_p.field_72995_K)
                {
                    if(func_70830_n())
                    {
                        field_70170_p.func_72876_a(this, field_70165_t, field_70163_u, field_70161_v, 6F);
                    } else
                    {
                        field_70170_p.func_72876_a(this, field_70165_t, field_70163_u, field_70161_v, 3F);
                    }
                    func_70106_y();
                }
            }
        }
        super.func_70071_h_();
    }

    protected String func_70621_aR()
    {
        return "mob.creeper";
    }

    protected String func_70673_aS()
    {
        return "mob.creeperdeath";
    }

    public void func_70645_a(DamageSource p_70645_1_)
    {
        super.func_70645_a(p_70645_1_);
        if(p_70645_1_.func_76346_g() instanceof EntitySkeleton)
        {
            func_70025_b(Item.field_77819_bI.field_77779_bT + field_70146_Z.nextInt(10), 1);
        }
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        return true;
    }

    public boolean func_70830_n()
    {
        return field_70180_af.func_75683_a(17) == 1;
    }

    protected int func_70633_aT()
    {
        return Item.field_77677_M.field_77779_bT;
    }

    public int func_70832_p()
    {
        return field_70180_af.func_75683_a(16);
    }

    public void func_70829_a(int p_70829_1_)
    {
        field_70180_af.func_75692_b(16, Byte.valueOf((byte)p_70829_1_));
    }

    public void func_70077_a(EntityLightningBolt p_70077_1_)
    {
        super.func_70077_a(p_70077_1_);
        field_70180_af.func_75692_b(17, Byte.valueOf((byte)1));
    }
}
