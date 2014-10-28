// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, World, EntityDamageSource, DamageSource, 
//            Entity, AxisAlignedBB, MathHelper, Block, 
//            Facing, BlockSilverfish, EnumCreatureAttribute

public class EntitySilverfish extends EntityMob
{

    private int field_70843_d;

    public EntitySilverfish(World p_i3554_1_)
    {
        super(p_i3554_1_);
        field_70750_az = "/mob/silverfish.png";
        func_70105_a(0.3F, 0.7F);
        field_70697_bw = 0.6F;
        field_70815_f = 1;
    }

    public int func_70667_aM()
    {
        return 8;
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    protected Entity func_70782_k()
    {
        double d = 8D;
        return field_70170_p.func_72856_b(this, d);
    }

    protected String func_70639_aQ()
    {
        return "mob.silverfish.say";
    }

    protected String func_70621_aR()
    {
        return "mob.silverfish.hit";
    }

    protected String func_70673_aS()
    {
        return "mob.silverfish.kill";
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(field_70843_d <= 0 && ((p_70097_1_ instanceof EntityDamageSource) || p_70097_1_ == DamageSource.field_76376_m))
        {
            field_70843_d = 20;
        }
        return super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    protected void func_70785_a(Entity p_70785_1_, float p_70785_2_)
    {
        if(field_70724_aR <= 0 && p_70785_2_ < 1.2F && p_70785_1_.field_70121_D.field_72337_e > field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < field_70121_D.field_72337_e)
        {
            field_70724_aR = 20;
            p_70785_1_.func_70097_a(DamageSource.func_76358_a(this), field_70815_f);
        }
    }

    protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_)
    {
        field_70170_p.func_72956_a(this, "mob.silverfish.step", 1.0F, 1.0F);
    }

    protected int func_70633_aT()
    {
        return 0;
    }

    public void func_70071_h_()
    {
        field_70761_aq = field_70177_z;
        super.func_70071_h_();
    }

    protected void func_70626_be()
    {
        super.func_70626_be();
        if(field_70170_p.field_72995_K)
        {
            return;
        }
        if(field_70843_d > 0)
        {
            field_70843_d--;
            if(field_70843_d == 0)
            {
                int i = MathHelper.func_76128_c(field_70165_t);
                int k = MathHelper.func_76128_c(field_70163_u);
                int i1 = MathHelper.func_76128_c(field_70161_v);
                boolean flag = false;
                for(int l1 = 0; !flag && l1 <= 5 && l1 >= -5; l1 = l1 > 0 ? 0 - l1 : 1 - l1)
                {
                    for(int j2 = 0; !flag && j2 <= 10 && j2 >= -10; j2 = j2 > 0 ? 0 - j2 : 1 - j2)
                    {
                        for(int k2 = 0; !flag && k2 <= 10 && k2 >= -10; k2 = k2 > 0 ? 0 - k2 : 1 - k2)
                        {
                            int l2 = field_70170_p.func_72798_a(i + j2, k + l1, i1 + k2);
                            if(l2 != Block.field_72006_bl.field_71990_ca)
                            {
                                continue;
                            }
                            field_70170_p.func_72926_e(2001, i + j2, k + l1, i1 + k2, Block.field_72006_bl.field_71990_ca + (field_70170_p.func_72805_g(i + j2, k + l1, i1 + k2) << 12));
                            field_70170_p.func_72859_e(i + j2, k + l1, i1 + k2, 0);
                            Block.field_72006_bl.func_71898_d(field_70170_p, i + j2, k + l1, i1 + k2, 0);
                            if(!field_70146_Z.nextBoolean())
                            {
                                continue;
                            }
                            flag = true;
                            break;
                        }

                    }

                }

            }
        }
        if(field_70789_a == null && !func_70781_l())
        {
            int j = MathHelper.func_76128_c(field_70165_t);
            int l = MathHelper.func_76128_c(field_70163_u + 0.5D);
            int j1 = MathHelper.func_76128_c(field_70161_v);
            int k1 = field_70146_Z.nextInt(6);
            int i2 = field_70170_p.func_72798_a(j + Facing.field_71586_b[k1], l + Facing.field_71587_c[k1], j1 + Facing.field_71585_d[k1]);
            if(BlockSilverfish.func_72154_e(i2))
            {
                field_70170_p.func_72832_d(j + Facing.field_71586_b[k1], l + Facing.field_71587_c[k1], j1 + Facing.field_71585_d[k1], Block.field_72006_bl.field_71990_ca, BlockSilverfish.func_72153_f(i2));
                func_70656_aK();
                func_70106_y();
            } else
            {
                func_70779_j();
            }
        } else
        if(field_70789_a != null && !func_70781_l())
        {
            field_70789_a = null;
        }
    }

    public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_)
    {
        if(field_70170_p.func_72798_a(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Block.field_71981_t.field_71990_ca)
        {
            return 10F;
        } else
        {
            return super.func_70783_a(p_70783_1_, p_70783_2_, p_70783_3_);
        }
    }

    protected boolean func_70814_o()
    {
        return true;
    }

    public boolean func_70601_bi()
    {
        if(super.func_70601_bi())
        {
            EntityPlayer entityplayer = field_70170_p.func_72890_a(this, 5D);
            return entityplayer == null;
        } else
        {
            return false;
        }
    }

    public EnumCreatureAttribute func_70668_bt()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }
}
