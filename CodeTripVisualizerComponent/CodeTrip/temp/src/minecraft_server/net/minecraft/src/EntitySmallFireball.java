// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFireball, World, MovingObjectPosition, Entity, 
//            DamageSource, Block, BlockFire, EntityLiving

public class EntitySmallFireball extends EntityFireball
{

    public EntitySmallFireball(World p_i3577_1_)
    {
        super(p_i3577_1_);
        func_70105_a(0.3125F, 0.3125F);
    }

    public EntitySmallFireball(World p_i3578_1_, EntityLiving p_i3578_2_, double p_i3578_3_, double p_i3578_5_, double p_i3578_7_)
    {
        super(p_i3578_1_, p_i3578_2_, p_i3578_3_, p_i3578_5_, p_i3578_7_);
        func_70105_a(0.3125F, 0.3125F);
    }

    public EntitySmallFireball(World p_i3579_1_, double p_i3579_2_, double p_i3579_4_, double p_i3579_6_, 
            double p_i3579_8_, double p_i3579_10_, double p_i3579_12_)
    {
        super(p_i3579_1_, p_i3579_2_, p_i3579_4_, p_i3579_6_, p_i3579_8_, p_i3579_10_, p_i3579_12_);
        func_70105_a(0.3125F, 0.3125F);
    }

    protected void func_70227_a(MovingObjectPosition p_70227_1_)
    {
        if(!field_70170_p.field_72995_K)
        {
            if(p_70227_1_.field_72308_g != null)
            {
                if(!p_70227_1_.field_72308_g.func_70045_F() && p_70227_1_.field_72308_g.func_70097_a(DamageSource.func_76362_a(this, field_70235_a), 5))
                {
                    p_70227_1_.field_72308_g.func_70015_d(5);
                }
            } else
            {
                int i = p_70227_1_.field_72311_b;
                int j = p_70227_1_.field_72312_c;
                int k = p_70227_1_.field_72309_d;
                switch(p_70227_1_.field_72310_e)
                {
                case 1: // '\001'
                    j++;
                    break;

                case 0: // '\0'
                    j--;
                    break;

                case 2: // '\002'
                    k--;
                    break;

                case 3: // '\003'
                    k++;
                    break;

                case 5: // '\005'
                    i++;
                    break;

                case 4: // '\004'
                    i--;
                    break;
                }
                if(field_70170_p.func_72799_c(i, j, k))
                {
                    field_70170_p.func_72859_e(i, j, k, Block.field_72067_ar.field_71990_ca);
                }
            }
            func_70106_y();
        }
    }

    public boolean func_70067_L()
    {
        return false;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        return false;
    }
}
