// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, DataWatcher, World, DamageSource, 
//            Entity, AxisAlignedBB, MathHelper, EntitySmallFireball, 
//            Item

public class EntityBlaze extends EntityMob
{

    private float field_70847_d;
    private int field_70848_e;
    private int field_70846_g;

    public EntityBlaze(World p_i3545_1_)
    {
        super(p_i3545_1_);
        field_70847_d = 0.5F;
        field_70750_az = "/mob/fire.png";
        field_70178_ae = true;
        field_70815_f = 6;
        field_70728_aV = 10;
    }

    public int func_70667_aM()
    {
        return 20;
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, new Byte((byte)0));
    }

    protected String func_70639_aQ()
    {
        return "mob.blaze.breathe";
    }

    protected String func_70621_aR()
    {
        return "mob.blaze.hit";
    }

    protected String func_70673_aS()
    {
        return "mob.blaze.death";
    }

    public int func_70070_b(float p_70070_1_)
    {
        return 0xf000f0;
    }

    public float func_70013_c(float p_70013_1_)
    {
        return 1.0F;
    }

    public void func_70636_d()
    {
        if(!field_70170_p.field_72995_K)
        {
            if(func_70026_G())
            {
                func_70097_a(DamageSource.field_76369_e, 1);
            }
            field_70848_e--;
            if(field_70848_e <= 0)
            {
                field_70848_e = 100;
                field_70847_d = 0.5F + (float)field_70146_Z.nextGaussian() * 3F;
            }
            if(func_70777_m() != null && func_70777_m().field_70163_u + (double)func_70777_m().func_70047_e() > field_70163_u + (double)func_70047_e() + (double)field_70847_d)
            {
                field_70181_x += (0.30000001192092896D - field_70181_x) * 0.30000001192092896D;
            }
        }
        if(field_70146_Z.nextInt(24) == 0)
        {
            field_70170_p.func_72908_a(field_70165_t + 0.5D, field_70163_u + 0.5D, field_70161_v + 0.5D, "fire.fire", 1.0F + field_70146_Z.nextFloat(), field_70146_Z.nextFloat() * 0.7F + 0.3F);
        }
        if(!field_70122_E && field_70181_x < 0.0D)
        {
            field_70181_x *= 0.59999999999999998D;
        }
        for(int i = 0; i < 2; i++)
        {
            field_70170_p.func_72869_a("largesmoke", field_70165_t + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N, field_70163_u + field_70146_Z.nextDouble() * (double)field_70131_O, field_70161_v + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N, 0.0D, 0.0D, 0.0D);
        }

        super.func_70636_d();
    }

    protected void func_70785_a(Entity p_70785_1_, float p_70785_2_)
    {
        if(field_70724_aR <= 0 && p_70785_2_ < 2.0F && p_70785_1_.field_70121_D.field_72337_e > field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < field_70121_D.field_72337_e)
        {
            field_70724_aR = 20;
            func_70652_k(p_70785_1_);
        } else
        if(p_70785_2_ < 30F)
        {
            double d = p_70785_1_.field_70165_t - field_70165_t;
            double d1 = (p_70785_1_.field_70121_D.field_72338_b + (double)(p_70785_1_.field_70131_O / 2.0F)) - (field_70163_u + (double)(field_70131_O / 2.0F));
            double d2 = p_70785_1_.field_70161_v - field_70161_v;
            if(field_70724_aR == 0)
            {
                field_70846_g++;
                if(field_70846_g == 1)
                {
                    field_70724_aR = 60;
                    func_70844_e(true);
                } else
                if(field_70846_g <= 4)
                {
                    field_70724_aR = 6;
                } else
                {
                    field_70724_aR = 100;
                    field_70846_g = 0;
                    func_70844_e(false);
                }
                if(field_70846_g > 1)
                {
                    float f = MathHelper.func_76129_c(p_70785_2_) * 0.5F;
                    field_70170_p.func_72889_a(null, 1009, (int)field_70165_t, (int)field_70163_u, (int)field_70161_v, 0);
                    for(int i = 0; i < 1; i++)
                    {
                        EntitySmallFireball entitysmallfireball = new EntitySmallFireball(field_70170_p, this, d + field_70146_Z.nextGaussian() * (double)f, d1, d2 + field_70146_Z.nextGaussian() * (double)f);
                        entitysmallfireball.field_70163_u = field_70163_u + (double)(field_70131_O / 2.0F) + 0.5D;
                        field_70170_p.func_72838_d(entitysmallfireball);
                    }

                }
            }
            field_70177_z = (float)((Math.atan2(d2, d) * 180D) / 3.1415927410125732D) - 90F;
            field_70787_b = true;
        }
    }

    protected void func_70069_a(float f)
    {
    }

    protected int func_70633_aT()
    {
        return Item.field_77731_bo.field_77779_bT;
    }

    public boolean func_70027_ad()
    {
        return func_70845_n();
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        if(p_70628_1_)
        {
            int i = field_70146_Z.nextInt(2 + p_70628_2_);
            for(int j = 0; j < i; j++)
            {
                func_70025_b(Item.field_77731_bo.field_77779_bT, 1);
            }

        }
    }

    public boolean func_70845_n()
    {
        return (field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void func_70844_e(boolean p_70844_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        if(p_70844_1_)
        {
            byte0 |= 1;
        } else
        {
            byte0 &= 0xfe;
        }
        field_70180_af.func_75692_b(16, Byte.valueOf(byte0));
    }

    protected boolean func_70814_o()
    {
        return true;
    }
}
