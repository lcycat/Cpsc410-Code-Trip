// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, EntityAIEatGrass, PathNavigate, EntityAISwimming, 
//            EntityAITasks, EntityAIPanic, EntityAIMate, EntityAITempt, 
//            Item, EntityAIFollowParent, EntityAIWander, EntityAIWatchClosest, 
//            EntityPlayer, EntityAILookIdle, World, DataWatcher, 
//            ItemStack, Block, MathHelper, InventoryPlayer, 
//            ItemShears, EntityItem, NBTTagCompound

public class EntitySheep extends EntityAnimal
{

    public static final float field_70898_d[][] = {
        {
            1.0F, 1.0F, 1.0F
        }, {
            0.95F, 0.7F, 0.2F
        }, {
            0.9F, 0.5F, 0.85F
        }, {
            0.6F, 0.7F, 0.95F
        }, {
            0.9F, 0.9F, 0.2F
        }, {
            0.5F, 0.8F, 0.1F
        }, {
            0.95F, 0.7F, 0.8F
        }, {
            0.3F, 0.3F, 0.3F
        }, {
            0.6F, 0.6F, 0.6F
        }, {
            0.3F, 0.6F, 0.7F
        }, {
            0.7F, 0.4F, 0.9F
        }, {
            0.2F, 0.4F, 0.8F
        }, {
            0.5F, 0.4F, 0.3F
        }, {
            0.4F, 0.5F, 0.2F
        }, {
            0.8F, 0.3F, 0.3F
        }, {
            0.1F, 0.1F, 0.1F
        }
    };
    private int field_70899_e;
    private EntityAIEatGrass field_70897_f;

    public EntitySheep(World p_i3521_1_)
    {
        super(p_i3521_1_);
        field_70897_f = new EntityAIEatGrass(this);
        field_70750_az = "/mob/sheep.png";
        func_70105_a(0.9F, 1.3F);
        float f = 0.23F;
        func_70661_as().func_75491_a(true);
        field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
        field_70714_bg.func_75776_a(2, new EntityAIMate(this, f));
        field_70714_bg.func_75776_a(3, new EntityAITempt(this, 0.25F, Item.field_77685_T.field_77779_bT, false));
        field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 0.25F));
        field_70714_bg.func_75776_a(5, field_70897_f);
        field_70714_bg.func_75776_a(6, new EntityAIWander(this, f));
        field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 6F));
        field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
    }

    protected boolean func_70650_aV()
    {
        return true;
    }

    protected void func_70619_bc()
    {
        field_70899_e = field_70897_f.func_75362_f();
        super.func_70619_bc();
    }

    public void func_70636_d()
    {
        if(field_70170_p.field_72995_K)
        {
            field_70899_e = Math.max(0, field_70899_e - 1);
        }
        super.func_70636_d();
    }

    public int func_70667_aM()
    {
        return 8;
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, new Byte((byte)0));
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        if(!func_70892_o())
        {
            func_70099_a(new ItemStack(Block.field_72101_ab.field_71990_ca, 1, func_70896_n()), 0.0F);
        }
    }

    protected int func_70633_aT()
    {
        return Block.field_72101_ab.field_71990_ca;
    }

    public void func_70103_a(byte p_70103_1_)
    {
        if(p_70103_1_ == 10)
        {
            field_70899_e = 40;
        } else
        {
            super.func_70103_a(p_70103_1_);
        }
    }

    public float func_70894_j(float p_70894_1_)
    {
        if(field_70899_e <= 0)
        {
            return 0.0F;
        }
        if(field_70899_e >= 4 && field_70899_e <= 36)
        {
            return 1.0F;
        }
        if(field_70899_e < 4)
        {
            return ((float)field_70899_e - p_70894_1_) / 4F;
        } else
        {
            return -((float)(field_70899_e - 40) - p_70894_1_) / 4F;
        }
    }

    public float func_70890_k(float p_70890_1_)
    {
        if(field_70899_e > 4 && field_70899_e <= 36)
        {
            float f = ((float)(field_70899_e - 4) - p_70890_1_) / 32F;
            return 0.6283185F + 0.2199115F * MathHelper.func_76126_a(f * 28.7F);
        }
        if(field_70899_e > 0)
        {
            return 0.6283185F;
        } else
        {
            return field_70125_A / 57.29578F;
        }
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();
        if(itemstack != null && itemstack.field_77993_c == Item.field_77745_be.field_77779_bT && !func_70892_o() && !func_70631_g_())
        {
            if(!field_70170_p.field_72995_K)
            {
                func_70893_e(true);
                int i = 1 + field_70146_Z.nextInt(3);
                for(int j = 0; j < i; j++)
                {
                    EntityItem entityitem = func_70099_a(new ItemStack(Block.field_72101_ab.field_71990_ca, 1, func_70896_n()), 1.0F);
                    entityitem.field_70181_x += field_70146_Z.nextFloat() * 0.05F;
                    entityitem.field_70159_w += (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.1F;
                    entityitem.field_70179_y += (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.1F;
                }

            }
            itemstack.func_77972_a(1, p_70085_1_);
        }
        return super.func_70085_c(p_70085_1_);
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74757_a("Sheared", func_70892_o());
        p_70014_1_.func_74774_a("Color", (byte)func_70896_n());
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        func_70893_e(p_70037_1_.func_74767_n("Sheared"));
        func_70891_b(p_70037_1_.func_74771_c("Color"));
    }

    protected String func_70639_aQ()
    {
        return "mob.sheep";
    }

    protected String func_70621_aR()
    {
        return "mob.sheep";
    }

    protected String func_70673_aS()
    {
        return "mob.sheep";
    }

    public int func_70896_n()
    {
        return field_70180_af.func_75683_a(16) & 0xf;
    }

    public void func_70891_b(int p_70891_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 & 0xf0 | p_70891_1_ & 0xf)));
    }

    public boolean func_70892_o()
    {
        return (field_70180_af.func_75683_a(16) & 0x10) != 0;
    }

    public void func_70893_e(boolean p_70893_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        if(p_70893_1_)
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 | 0x10)));
        } else
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 & 0xffffffef)));
        }
    }

    public static int func_70895_a(Random p_70895_0_)
    {
        int i = p_70895_0_.nextInt(100);
        if(i < 5)
        {
            return 15;
        }
        if(i < 10)
        {
            return 7;
        }
        if(i < 15)
        {
            return 8;
        }
        if(i < 18)
        {
            return 12;
        }
        return p_70895_0_.nextInt(500) != 0 ? 0 : 6;
    }

    public EntityAnimal func_70879_a(EntityAnimal p_70879_1_)
    {
        EntitySheep entitysheep = (EntitySheep)p_70879_1_;
        EntitySheep entitysheep1 = new EntitySheep(field_70170_p);
        if(field_70146_Z.nextBoolean())
        {
            entitysheep1.func_70891_b(func_70896_n());
        } else
        {
            entitysheep1.func_70891_b(entitysheep.func_70896_n());
        }
        return entitysheep1;
    }

    public void func_70615_aA()
    {
        func_70893_e(false);
        if(func_70631_g_())
        {
            int i = func_70874_b() + 1200;
            if(i > 0)
            {
                i = 0;
            }
            func_70873_a(i);
        }
    }

}
