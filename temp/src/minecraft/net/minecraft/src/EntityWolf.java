// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityTameable, PathNavigate, EntityAISwimming, EntityAITasks, 
//            EntityAILeapAtTarget, EntityAIAttackOnCollide, EntityAIFollowOwner, EntityAIMate, 
//            EntityAIWander, EntityAIBeg, EntityAIWatchClosest, EntityPlayer, 
//            EntityAILookIdle, EntityAIOwnerHurtByTarget, EntityAIOwnerHurtTarget, EntityAIHurtByTarget, 
//            EntityAITargetNonTamed, EntitySheep, DataWatcher, NBTTagCompound, 
//            World, AxisAlignedBB, MathHelper, DamageSource, 
//            EntityAISit, EntityArrow, Entity, InventoryPlayer, 
//            Item, ItemStack, ItemFood, PlayerCapabilities, 
//            EntityLiving, EntityAnimal

public class EntityWolf extends EntityTameable
{

    private float field_70926_e;
    private float field_70924_f;
    private boolean field_70925_g;
    private boolean field_70928_h;
    private float field_70929_i;
    private float field_70927_j;

    public EntityWolf(World p_i3526_1_)
    {
        super(p_i3526_1_);
        field_70750_az = "/mob/wolf.png";
        func_70105_a(0.6F, 0.8F);
        field_70697_bw = 0.3F;
        func_70661_as().func_75491_a(true);
        field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(2, field_70911_d);
        field_70714_bg.func_75776_a(3, new EntityAILeapAtTarget(this, 0.4F));
        field_70714_bg.func_75776_a(4, new EntityAIAttackOnCollide(this, field_70697_bw, true));
        field_70714_bg.func_75776_a(5, new EntityAIFollowOwner(this, field_70697_bw, 10F, 2.0F));
        field_70714_bg.func_75776_a(6, new EntityAIMate(this, field_70697_bw));
        field_70714_bg.func_75776_a(7, new EntityAIWander(this, field_70697_bw));
        field_70714_bg.func_75776_a(8, new EntityAIBeg(this, 8F));
        field_70714_bg.func_75776_a(9, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
        field_70714_bg.func_75776_a(9, new EntityAILookIdle(this));
        field_70715_bh.func_75776_a(1, new EntityAIOwnerHurtByTarget(this));
        field_70715_bh.func_75776_a(2, new EntityAIOwnerHurtTarget(this));
        field_70715_bh.func_75776_a(3, new EntityAIHurtByTarget(this, true));
        field_70715_bh.func_75776_a(4, new EntityAITargetNonTamed(this, net.minecraft.src.EntitySheep.class, 16F, 200, false));
    }

    public boolean func_70650_aV()
    {
        return true;
    }

    public void func_70624_b(EntityLiving p_70624_1_)
    {
        super.func_70624_b(p_70624_1_);
        if(p_70624_1_ instanceof EntityPlayer)
        {
            func_70916_h(true);
        }
    }

    protected void func_70629_bd()
    {
        field_70180_af.func_75692_b(18, Integer.valueOf(func_70630_aN()));
    }

    public int func_70667_aM()
    {
        return !func_70909_n() ? 8 : 20;
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(18, new Integer(func_70630_aN()));
        field_70180_af.func_75682_a(19, new Byte((byte)0));
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    public String func_70073_O()
    {
        if(func_70909_n())
        {
            return "/mob/wolf_tame.png";
        }
        if(func_70919_bu())
        {
            return "/mob/wolf_angry.png";
        } else
        {
            return super.func_70073_O();
        }
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74757_a("Angry", func_70919_bu());
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        func_70916_h(p_70037_1_.func_74767_n("Angry"));
    }

    protected boolean func_70692_ba()
    {
        return func_70919_bu();
    }

    protected String func_70639_aQ()
    {
        if(func_70919_bu())
        {
            return "mob.wolf.growl";
        }
        if(field_70146_Z.nextInt(3) == 0)
        {
            if(func_70909_n() && field_70180_af.func_75679_c(18) < 10)
            {
                return "mob.wolf.whine";
            } else
            {
                return "mob.wolf.panting";
            }
        } else
        {
            return "mob.wolf.bark";
        }
    }

    protected String func_70621_aR()
    {
        return "mob.wolf.hurt";
    }

    protected String func_70673_aS()
    {
        return "mob.wolf.death";
    }

    protected float func_70599_aP()
    {
        return 0.4F;
    }

    protected int func_70633_aT()
    {
        return -1;
    }

    public void func_70636_d()
    {
        super.func_70636_d();
        if(!field_70170_p.field_72995_K && field_70925_g && !field_70928_h && !func_70781_l() && field_70122_E)
        {
            field_70928_h = true;
            field_70929_i = 0.0F;
            field_70927_j = 0.0F;
            field_70170_p.func_72960_a(this, (byte)8);
        }
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        field_70924_f = field_70926_e;
        if(func_70922_bv())
        {
            field_70926_e += (1.0F - field_70926_e) * 0.4F;
        } else
        {
            field_70926_e += (0.0F - field_70926_e) * 0.4F;
        }
        if(func_70922_bv())
        {
            field_70700_bx = 10;
        }
        if(func_70026_G())
        {
            field_70925_g = true;
            field_70928_h = false;
            field_70929_i = 0.0F;
            field_70927_j = 0.0F;
        } else
        if((field_70925_g || field_70928_h) && field_70928_h)
        {
            if(field_70929_i == 0.0F)
            {
                field_70170_p.func_72956_a(this, "mob.wolf.shake", func_70599_aP(), (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.0F);
            }
            field_70927_j = field_70929_i;
            field_70929_i += 0.05F;
            if(field_70927_j >= 2.0F)
            {
                field_70925_g = false;
                field_70928_h = false;
                field_70927_j = 0.0F;
                field_70929_i = 0.0F;
            }
            if(field_70929_i > 0.4F)
            {
                float f = (float)field_70121_D.field_72338_b;
                int i = (int)(MathHelper.func_76126_a((field_70929_i - 0.4F) * 3.141593F) * 7F);
                for(int j = 0; j < i; j++)
                {
                    float f1 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N * 0.5F;
                    float f2 = (field_70146_Z.nextFloat() * 2.0F - 1.0F) * field_70130_N * 0.5F;
                    field_70170_p.func_72869_a("splash", field_70165_t + (double)f1, f + 0.8F, field_70161_v + (double)f2, field_70159_w, field_70181_x, field_70179_y);
                }

            }
        }
    }

    public boolean func_70921_u()
    {
        return field_70925_g;
    }

    public float func_70915_j(float p_70915_1_)
    {
        return 0.75F + ((field_70927_j + (field_70929_i - field_70927_j) * p_70915_1_) / 2.0F) * 0.25F;
    }

    public float func_70923_f(float p_70923_1_, float p_70923_2_)
    {
        float f = (field_70927_j + (field_70929_i - field_70927_j) * p_70923_1_ + p_70923_2_) / 1.8F;
        if(f < 0.0F)
        {
            f = 0.0F;
        } else
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        return MathHelper.func_76126_a(f * 3.141593F) * MathHelper.func_76126_a(f * 3.141593F * 11F) * 0.15F * 3.141593F;
    }

    public float func_70917_k(float p_70917_1_)
    {
        return (field_70924_f + (field_70926_e - field_70924_f) * p_70917_1_) * 0.15F * 3.141593F;
    }

    public float func_70047_e()
    {
        return field_70131_O * 0.8F;
    }

    public int func_70646_bf()
    {
        if(func_70906_o())
        {
            return 20;
        } else
        {
            return super.func_70646_bf();
        }
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        Entity entity = p_70097_1_.func_76346_g();
        field_70911_d.func_75270_a(false);
        if(entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
        {
            p_70097_2_ = (p_70097_2_ + 1) / 2;
        }
        return super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        byte byte0 = ((byte)(func_70909_n() ? 4 : 2));
        return p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), byte0);
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();
        if(func_70909_n())
        {
            if(itemstack != null && (Item.field_77698_e[itemstack.field_77993_c] instanceof ItemFood))
            {
                ItemFood itemfood = (ItemFood)Item.field_77698_e[itemstack.field_77993_c];
                if(itemfood.func_77845_h() && field_70180_af.func_75679_c(18) < 20)
                {
                    if(!p_70085_1_.field_71075_bZ.field_75098_d)
                    {
                        itemstack.field_77994_a--;
                    }
                    func_70691_i(itemfood.func_77847_f());
                    if(itemstack.field_77994_a <= 0)
                    {
                        p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
                    }
                    return true;
                }
            }
            if(p_70085_1_.field_71092_bJ.equalsIgnoreCase(func_70905_p()) && !field_70170_p.field_72995_K && !func_70877_b(itemstack))
            {
                field_70911_d.func_75270_a(!func_70906_o());
                field_70703_bu = false;
                func_70778_a(null);
            }
        } else
        if(itemstack != null && itemstack.field_77993_c == Item.field_77755_aX.field_77779_bT && !func_70919_bu())
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
                    func_70778_a(null);
                    func_70624_b(null);
                    field_70911_d.func_75270_a(true);
                    func_70606_j(20);
                    func_70910_a(p_70085_1_.field_71092_bJ);
                    func_70908_e(true);
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

    public void func_70103_a(byte p_70103_1_)
    {
        if(p_70103_1_ == 8)
        {
            field_70928_h = true;
            field_70929_i = 0.0F;
            field_70927_j = 0.0F;
        } else
        {
            super.func_70103_a(p_70103_1_);
        }
    }

    public float func_70920_v()
    {
        if(func_70919_bu())
        {
            return 1.53938F;
        }
        if(func_70909_n())
        {
            return (0.55F - (float)(20 - field_70180_af.func_75679_c(18)) * 0.02F) * 3.141593F;
        } else
        {
            return 0.6283185F;
        }
    }

    public boolean func_70877_b(ItemStack p_70877_1_)
    {
        if(p_70877_1_ == null)
        {
            return false;
        }
        if(!(Item.field_77698_e[p_70877_1_.field_77993_c] instanceof ItemFood))
        {
            return false;
        } else
        {
            return ((ItemFood)Item.field_77698_e[p_70877_1_.field_77993_c]).func_77845_h();
        }
    }

    public int func_70641_bl()
    {
        return 8;
    }

    public boolean func_70919_bu()
    {
        return (field_70180_af.func_75683_a(16) & 2) != 0;
    }

    public void func_70916_h(boolean p_70916_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        if(p_70916_1_)
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 | 2)));
        } else
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 & -3)));
        }
    }

    public EntityAnimal func_70879_a(EntityAnimal p_70879_1_)
    {
        EntityWolf entitywolf = new EntityWolf(field_70170_p);
        entitywolf.func_70910_a(func_70905_p());
        entitywolf.func_70903_f(true);
        return entitywolf;
    }

    public void func_70918_i(boolean p_70918_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(19);
        if(p_70918_1_)
        {
            field_70180_af.func_75692_b(19, Byte.valueOf((byte)1));
        } else
        {
            field_70180_af.func_75692_b(19, Byte.valueOf((byte)0));
        }
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
        if(!(p_70878_1_ instanceof EntityWolf))
        {
            return false;
        }
        EntityWolf entitywolf = (EntityWolf)p_70878_1_;
        if(!entitywolf.func_70909_n())
        {
            return false;
        }
        if(entitywolf.func_70906_o())
        {
            return false;
        } else
        {
            return func_70880_s() && entitywolf.func_70880_s();
        }
    }

    public boolean func_70922_bv()
    {
        return field_70180_af.func_75683_a(19) == 1;
    }
}
