// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityGolem, PathNavigate, EntityAIAttackOnCollide, EntityAITasks, 
//            EntityAIMoveTowardsTarget, EntityAIMoveThroughVillage, EntityAIMoveTwardsRestriction, EntityAILookAtVillager, 
//            EntityAIWander, EntityAIWatchClosest, EntityPlayer, EntityAILookIdle, 
//            EntityAIDefendVillage, EntityAIHurtByTarget, EntityAINearestAttackableTarget, EntityMob, 
//            DataWatcher, World, MathHelper, VillageCollection, 
//            Village, ChunkCoordinates, AxisAlignedBB, DamageSource, 
//            Entity, Block, BlockFlower, Item

public class EntityIronGolem extends EntityGolem
{

    private int field_70858_e;
    Village field_70857_d;
    private int field_70855_f;
    private int field_70856_g;

    public EntityIronGolem(World p_i3524_1_)
    {
        super(p_i3524_1_);
        field_70858_e = 0;
        field_70857_d = null;
        field_70750_az = "/mob/villager_golem.png";
        func_70105_a(1.4F, 2.9F);
        func_70661_as().func_75491_a(true);
        field_70714_bg.func_75776_a(1, new EntityAIAttackOnCollide(this, 0.25F, true));
        field_70714_bg.func_75776_a(2, new EntityAIMoveTowardsTarget(this, 0.22F, 32F));
        field_70714_bg.func_75776_a(3, new EntityAIMoveThroughVillage(this, 0.16F, true));
        field_70714_bg.func_75776_a(4, new EntityAIMoveTwardsRestriction(this, 0.16F));
        field_70714_bg.func_75776_a(5, new EntityAILookAtVillager(this));
        field_70714_bg.func_75776_a(6, new EntityAIWander(this, 0.16F));
        field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 6F));
        field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
        field_70715_bh.func_75776_a(1, new EntityAIDefendVillage(this));
        field_70715_bh.func_75776_a(2, new EntityAIHurtByTarget(this, false));
        field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityMob.class, 16F, 0, false, true));
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
    }

    public boolean func_70650_aV()
    {
        return true;
    }

    protected void func_70629_bd()
    {
        if(--field_70858_e <= 0)
        {
            field_70858_e = 70 + field_70146_Z.nextInt(50);
            field_70857_d = field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v), 32);
            if(field_70857_d == null)
            {
                func_70677_aE();
            } else
            {
                ChunkCoordinates chunkcoordinates = field_70857_d.func_75577_a();
                func_70598_b(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c, field_70857_d.func_75568_b());
            }
        }
        super.func_70629_bd();
    }

    public int func_70667_aM()
    {
        return 100;
    }

    protected int func_70682_h(int p_70682_1_)
    {
        return p_70682_1_;
    }

    public void func_70636_d()
    {
        super.func_70636_d();
        if(field_70855_f > 0)
        {
            field_70855_f--;
        }
        if(field_70856_g > 0)
        {
            field_70856_g--;
        }
        if(field_70159_w * field_70159_w + field_70179_y * field_70179_y > 2.5000002779052011E-007D && field_70146_Z.nextInt(5) == 0)
        {
            int i = MathHelper.func_76128_c(field_70165_t);
            int j = MathHelper.func_76128_c(field_70163_u - 0.20000000298023224D - (double)field_70129_M);
            int k = MathHelper.func_76128_c(field_70161_v);
            int l = field_70170_p.func_72798_a(i, j, k);
            if(l > 0)
            {
                field_70170_p.func_72869_a((new StringBuilder()).append("tilecrack_").append(l).toString(), field_70165_t + ((double)field_70146_Z.nextFloat() - 0.5D) * (double)field_70130_N, field_70121_D.field_72338_b + 0.10000000000000001D, field_70161_v + ((double)field_70146_Z.nextFloat() - 0.5D) * (double)field_70130_N, 4D * ((double)field_70146_Z.nextFloat() - 0.5D), 0.5D, ((double)field_70146_Z.nextFloat() - 0.5D) * 4D);
            }
        }
    }

    public boolean func_70686_a(Class p_70686_1_)
    {
        if(func_70850_q() && (net.minecraft.src.EntityPlayer.class).isAssignableFrom(p_70686_1_))
        {
            return false;
        } else
        {
            return super.func_70686_a(p_70686_1_);
        }
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        field_70855_f = 10;
        field_70170_p.func_72960_a(this, (byte)4);
        boolean flag = p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), 7 + field_70146_Z.nextInt(15));
        if(flag)
        {
            p_70652_1_.field_70181_x += 0.40000000596046448D;
        }
        field_70170_p.func_72956_a(this, "mob.irongolem.throw", 1.0F, 1.0F);
        return flag;
    }

    public Village func_70852_n()
    {
        return field_70857_d;
    }

    public void func_70851_e(boolean p_70851_1_)
    {
        field_70856_g = p_70851_1_ ? 400 : 0;
        field_70170_p.func_72960_a(this, (byte)11);
    }

    protected String func_70639_aQ()
    {
        return "none";
    }

    protected String func_70621_aR()
    {
        return "mob.irongolem.hit";
    }

    protected String func_70673_aS()
    {
        return "mob.irongolem.death";
    }

    protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_)
    {
        field_70170_p.func_72956_a(this, "mob.irongolem.walk", 1.0F, 1.0F);
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = field_70146_Z.nextInt(3);
        for(int j = 0; j < i; j++)
        {
            func_70025_b(Block.field_72107_ae.field_71990_ca, 1);
        }

        int k = 3 + field_70146_Z.nextInt(3);
        for(int l = 0; l < k; l++)
        {
            func_70025_b(Item.field_77703_o.field_77779_bT, 1);
        }

    }

    public int func_70853_p()
    {
        return field_70856_g;
    }

    public boolean func_70850_q()
    {
        return (field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void func_70849_f(boolean p_70849_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        if(p_70849_1_)
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 | 1)));
        } else
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 & -2)));
        }
    }
}
