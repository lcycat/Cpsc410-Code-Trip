// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityTameable, PathNavigate, EntityAISwimming, EntityAITasks, 
//            EntityAITempt, Item, EntityAIAvoidEntity, EntityPlayer, 
//            EntityAIFollowOwner, EntityAIOcelotSit, EntityAILeapAtTarget, EntityAIOcelotAttack, 
//            EntityAIMate, EntityAIWander, EntityAIWatchClosest, EntityAITargetNonTamed, 
//            EntityChicken, DataWatcher, EntityMoveHelper, NBTTagCompound, 
//            DamageSource, Entity, EntityAISit, InventoryPlayer, 
//            World, ItemStack, PlayerCapabilities, MathHelper, 
//            AxisAlignedBB, Block, BlockGrass, BlockLeaves, 
//            EntityAnimal

public class EntityOcelot extends EntityTameable
{

    private EntityAITempt field_70914_e;

    public EntityOcelot(World p_i3519_1_)
    {
        super(p_i3519_1_);
        field_70750_az = "/mob/ozelot.png";
        func_70105_a(0.6F, 0.8F);
        func_70661_as().func_75491_a(true);
        field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(2, field_70911_d);
        field_70714_bg.func_75776_a(3, field_70914_e = new EntityAITempt(this, 0.18F, Item.field_77754_aU.field_77779_bT, true));
        field_70714_bg.func_75776_a(4, new EntityAIAvoidEntity(this, net.minecraft.src.EntityPlayer.class, 16F, 0.23F, 0.4F));
        field_70714_bg.func_75776_a(5, new EntityAIFollowOwner(this, 0.3F, 10F, 5F));
        field_70714_bg.func_75776_a(6, new EntityAIOcelotSit(this, 0.4F));
        field_70714_bg.func_75776_a(7, new EntityAILeapAtTarget(this, 0.3F));
        field_70714_bg.func_75776_a(8, new EntityAIOcelotAttack(this));
        field_70714_bg.func_75776_a(9, new EntityAIMate(this, 0.23F));
        field_70714_bg.func_75776_a(10, new EntityAIWander(this, 0.23F));
        field_70714_bg.func_75776_a(11, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 10F));
        field_70715_bh.func_75776_a(1, new EntityAITargetNonTamed(this, net.minecraft.src.EntityChicken.class, 14F, 750, false));
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(18, Byte.valueOf((byte)0));
    }

    public void func_70629_bd()
    {
        if(func_70605_aq().func_75640_a())
        {
            float f = func_70605_aq().func_75638_b();
            if(f == 0.18F)
            {
                func_70095_a(true);
                func_70031_b(false);
            } else
            if(f == 0.4F)
            {
                func_70095_a(false);
                func_70031_b(true);
            } else
            {
                func_70095_a(false);
                func_70031_b(false);
            }
        } else
        {
            func_70095_a(false);
            func_70031_b(false);
        }
    }

    protected boolean func_70692_ba()
    {
        return !func_70909_n();
    }

    public boolean func_70650_aV()
    {
        return true;
    }

    public int func_70667_aM()
    {
        return 10;
    }

    protected void func_70069_a(float f)
    {
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74768_a("CatType", func_70913_u());
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        func_70912_b(p_70037_1_.func_74762_e("CatType"));
    }

    protected String func_70639_aQ()
    {
        if(func_70909_n())
        {
            if(func_70880_s())
            {
                return "mob.cat.purr";
            }
            if(field_70146_Z.nextInt(4) == 0)
            {
                return "mob.cat.purreow";
            } else
            {
                return "mob.cat.meow";
            }
        } else
        {
            return "";
        }
    }

    protected String func_70621_aR()
    {
        return "mob.cat.hitt";
    }

    protected String func_70673_aS()
    {
        return "mob.cat.hitt";
    }

    protected float func_70599_aP()
    {
        return 0.4F;
    }

    protected int func_70633_aT()
    {
        return Item.field_77770_aF.field_77779_bT;
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        return p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), 3);
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        field_70911_d.func_75270_a(false);
        return super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    protected void func_70628_a(boolean flag, int i)
    {
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();
        if(func_70909_n())
        {
            if(p_70085_1_.field_71092_bJ.equalsIgnoreCase(func_70905_p()) && !field_70170_p.field_72995_K && !func_70877_b(itemstack))
            {
                field_70911_d.func_75270_a(!func_70906_o());
            }
        } else
        if(field_70914_e.func_75277_f() && itemstack != null && itemstack.field_77993_c == Item.field_77754_aU.field_77779_bT && p_70085_1_.func_70068_e(this) < 9D)
        {
            if(!p_70085_1_.field_71075_bZ.field_75098_d)
            {
                itemstack.field_77994_a--;
            }
            if(itemstack.field_77994_a <= 0)
            {
                p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
            }
            if(!field_70170_p.field_72995_K)
            {
                if(field_70146_Z.nextInt(3) == 0)
                {
                    func_70903_f(true);
                    func_70912_b(1 + field_70170_p.field_73012_v.nextInt(3));
                    func_70910_a(p_70085_1_.field_71092_bJ);
                    func_70908_e(true);
                    field_70911_d.func_75270_a(true);
                    field_70170_p.func_72960_a(this, (byte)7);
                } else
                {
                    func_70908_e(false);
                    field_70170_p.func_72960_a(this, (byte)6);
                }
            }
            return true;
        }
        return super.func_70085_c(p_70085_1_);
    }

    public EntityAnimal func_70879_a(EntityAnimal p_70879_1_)
    {
        EntityOcelot entityocelot = new EntityOcelot(field_70170_p);
        if(func_70909_n())
        {
            entityocelot.func_70910_a(func_70905_p());
            entityocelot.func_70903_f(true);
            entityocelot.func_70912_b(func_70913_u());
        }
        return entityocelot;
    }

    public boolean func_70877_b(ItemStack p_70877_1_)
    {
        return p_70877_1_ != null && p_70877_1_.field_77993_c == Item.field_77754_aU.field_77779_bT;
    }

    public boolean func_70878_b(EntityAnimal p_70878_1_)
    {
        if(p_70878_1_ == this)
        {
            return false;
        }
        if(!func_70909_n())
        {
            return false;
        }
        if(!(p_70878_1_ instanceof EntityOcelot))
        {
            return false;
        }
        EntityOcelot entityocelot = (EntityOcelot)p_70878_1_;
        if(!entityocelot.func_70909_n())
        {
            return false;
        } else
        {
            return func_70880_s() && entityocelot.func_70880_s();
        }
    }

    public int func_70913_u()
    {
        return field_70180_af.func_75683_a(18);
    }

    public void func_70912_b(int p_70912_1_)
    {
        field_70180_af.func_75692_b(18, Byte.valueOf((byte)p_70912_1_));
    }

    public boolean func_70601_bi()
    {
        if(field_70170_p.field_73012_v.nextInt(3) == 0)
        {
            return false;
        }
        if(field_70170_p.func_72855_b(field_70121_D) && field_70170_p.func_72945_a(this, field_70121_D).isEmpty() && !field_70170_p.func_72953_d(field_70121_D))
        {
            int i = MathHelper.func_76128_c(field_70165_t);
            int j = MathHelper.func_76128_c(field_70121_D.field_72338_b);
            int k = MathHelper.func_76128_c(field_70161_v);
            if(j < 63)
            {
                return false;
            }
            int l = field_70170_p.func_72798_a(i, j - 1, k);
            if(l == Block.field_71980_u.field_71990_ca || l == Block.field_71952_K.field_71990_ca)
            {
                return true;
            }
        }
        return false;
    }

    public String func_70023_ak()
    {
        if(func_70909_n())
        {
            return "entity.Cat.name";
        } else
        {
            return super.func_70023_ak();
        }
    }
}
