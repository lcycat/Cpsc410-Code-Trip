// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, InventoryPlayer, ItemStack, Block, 
//            Vec3, AxisAlignedBB, Vec3Pool, DamageSource, 
//            MathHelper, Entity, Material, Item, 
//            EntityDamageSourceIndirect, BlockGrass, BlockFlower, BlockMycelium

public class EntityEnderman extends EntityMob
{

    private static boolean field_70827_d[];
    private int field_70828_e;
    private int field_70826_g;

    public EntityEnderman(World p_i3548_1_)
    {
        super(p_i3548_1_);
        field_70828_e = 0;
        field_70826_g = 0;
        field_70750_az = "/mob/enderman.png";
        field_70697_bw = 0.2F;
        field_70815_f = 7;
        func_70105_a(0.6F, 2.9F);
        field_70138_W = 1.0F;
    }

    public int func_70667_aM()
    {
        return 40;
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, new Byte((byte)0));
        field_70180_af.func_75682_a(17, new Byte((byte)0));
        field_70180_af.func_75682_a(18, new Byte((byte)0));
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74777_a("carried", (short)func_70822_p());
        p_70014_1_.func_74777_a("carriedData", (short)func_70824_q());
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        func_70818_a(p_70037_1_.func_74765_d("carried"));
        func_70817_b(p_70037_1_.func_74765_d("carriedData"));
    }

    protected Entity func_70782_k()
    {
        EntityPlayer entityplayer = field_70170_p.func_72856_b(this, 64D);
        if(entityplayer != null)
        {
            if(func_70821_d(entityplayer))
            {
                if(field_70826_g++ == 5)
                {
                    field_70826_g = 0;
                    func_70819_e(true);
                    return entityplayer;
                }
            } else
            {
                field_70826_g = 0;
            }
        }
        return null;
    }

    private boolean func_70821_d(EntityPlayer p_70821_1_)
    {
        ItemStack itemstack = p_70821_1_.field_71071_by.field_70460_b[3];
        if(itemstack != null && itemstack.field_77993_c == Block.field_72061_ba.field_71990_ca)
        {
            return false;
        }
        Vec3 vec3 = p_70821_1_.func_70676_i(1.0F).func_72432_b();
        Vec3 vec3_1 = Vec3.func_72437_a().func_72345_a(field_70165_t - p_70821_1_.field_70165_t, (field_70121_D.field_72338_b + (double)(field_70131_O / 2.0F)) - (p_70821_1_.field_70163_u + (double)p_70821_1_.func_70047_e()), field_70161_v - p_70821_1_.field_70161_v);
        double d = vec3_1.func_72433_c();
        vec3_1 = vec3_1.func_72432_b();
        double d1 = vec3.func_72430_b(vec3_1);
        if(d1 > 1.0D - 0.025000000000000001D / d)
        {
            return p_70821_1_.func_70685_l(this);
        } else
        {
            return false;
        }
    }

    public void func_70636_d()
    {
        if(func_70026_G())
        {
            func_70097_a(DamageSource.field_76369_e, 1);
        }
        field_70697_bw = field_70789_a == null ? 0.3F : 6.5F;
        if(!field_70170_p.field_72995_K)
        {
            if(func_70822_p() == 0)
            {
                if(field_70146_Z.nextInt(20) == 0)
                {
                    int i = MathHelper.func_76128_c((field_70165_t - 2D) + field_70146_Z.nextDouble() * 4D);
                    int l = MathHelper.func_76128_c(field_70163_u + field_70146_Z.nextDouble() * 3D);
                    int j1 = MathHelper.func_76128_c((field_70161_v - 2D) + field_70146_Z.nextDouble() * 4D);
                    int l1 = field_70170_p.func_72798_a(i, l, j1);
                    if(field_70827_d[l1])
                    {
                        func_70818_a(field_70170_p.func_72798_a(i, l, j1));
                        func_70817_b(field_70170_p.func_72805_g(i, l, j1));
                        field_70170_p.func_72859_e(i, l, j1, 0);
                    }
                }
            } else
            if(field_70146_Z.nextInt(2000) == 0)
            {
                int j = MathHelper.func_76128_c((field_70165_t - 1.0D) + field_70146_Z.nextDouble() * 2D);
                int i1 = MathHelper.func_76128_c(field_70163_u + field_70146_Z.nextDouble() * 2D);
                int k1 = MathHelper.func_76128_c((field_70161_v - 1.0D) + field_70146_Z.nextDouble() * 2D);
                int i2 = field_70170_p.func_72798_a(j, i1, k1);
                int j2 = field_70170_p.func_72798_a(j, i1 - 1, k1);
                if(i2 == 0 && j2 > 0 && Block.field_71973_m[j2].func_71886_c())
                {
                    field_70170_p.func_72832_d(j, i1, k1, func_70822_p(), func_70824_q());
                    func_70818_a(0);
                }
            }
        }
        for(int k = 0; k < 2; k++)
        {
            field_70170_p.func_72869_a("portal", field_70165_t + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N, (field_70163_u + field_70146_Z.nextDouble() * (double)field_70131_O) - 0.25D, field_70161_v + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N, (field_70146_Z.nextDouble() - 0.5D) * 2D, -field_70146_Z.nextDouble(), (field_70146_Z.nextDouble() - 0.5D) * 2D);
        }

        if(field_70170_p.func_72935_r() && !field_70170_p.field_72995_K)
        {
            float f = func_70013_c(1.0F);
            if(f > 0.5F && field_70170_p.func_72937_j(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v)) && field_70146_Z.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                field_70789_a = null;
                func_70819_e(false);
                func_70820_n();
            }
        }
        if(func_70026_G())
        {
            field_70789_a = null;
            func_70819_e(false);
            func_70820_n();
        }
        field_70703_bu = false;
        if(field_70789_a != null)
        {
            func_70625_a(field_70789_a, 100F, 100F);
        }
        if(!field_70170_p.field_72995_K && func_70089_S())
        {
            if(field_70789_a != null)
            {
                if((field_70789_a instanceof EntityPlayer) && func_70821_d((EntityPlayer)field_70789_a))
                {
                    field_70702_br = field_70701_bs = 0.0F;
                    field_70697_bw = 0.0F;
                    if(field_70789_a.func_70068_e(this) < 16D)
                    {
                        func_70820_n();
                    }
                    field_70828_e = 0;
                } else
                if(field_70789_a.func_70068_e(this) > 256D && field_70828_e++ >= 30 && func_70816_c(field_70789_a))
                {
                    field_70828_e = 0;
                }
            } else
            {
                func_70819_e(false);
                field_70828_e = 0;
            }
        }
        super.func_70636_d();
    }

    protected boolean func_70820_n()
    {
        double d = field_70165_t + (field_70146_Z.nextDouble() - 0.5D) * 64D;
        double d1 = field_70163_u + (double)(field_70146_Z.nextInt(64) - 32);
        double d2 = field_70161_v + (field_70146_Z.nextDouble() - 0.5D) * 64D;
        return func_70825_j(d, d1, d2);
    }

    protected boolean func_70816_c(Entity p_70816_1_)
    {
        Vec3 vec3 = Vec3.func_72437_a().func_72345_a(field_70165_t - p_70816_1_.field_70165_t, ((field_70121_D.field_72338_b + (double)(field_70131_O / 2.0F)) - p_70816_1_.field_70163_u) + (double)p_70816_1_.func_70047_e(), field_70161_v - p_70816_1_.field_70161_v);
        vec3 = vec3.func_72432_b();
        double d = 16D;
        double d1 = (field_70165_t + (field_70146_Z.nextDouble() - 0.5D) * 8D) - vec3.field_72450_a * d;
        double d2 = (field_70163_u + (double)(field_70146_Z.nextInt(16) - 8)) - vec3.field_72448_b * d;
        double d3 = (field_70161_v + (field_70146_Z.nextDouble() - 0.5D) * 8D) - vec3.field_72449_c * d;
        return func_70825_j(d1, d2, d3);
    }

    protected boolean func_70825_j(double p_70825_1_, double p_70825_3_, double p_70825_5_)
    {
        double d = field_70165_t;
        double d1 = field_70163_u;
        double d2 = field_70161_v;
        field_70165_t = p_70825_1_;
        field_70163_u = p_70825_3_;
        field_70161_v = p_70825_5_;
        boolean flag = false;
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76128_c(field_70163_u);
        int k = MathHelper.func_76128_c(field_70161_v);
        if(field_70170_p.func_72899_e(i, j, k))
        {
            boolean flag1;
            for(flag1 = false; !flag1 && j > 0;)
            {
                int i1 = field_70170_p.func_72798_a(i, j - 1, k);
                if(i1 == 0 || !Block.field_71973_m[i1].field_72018_cp.func_76230_c())
                {
                    field_70163_u--;
                    j--;
                } else
                {
                    flag1 = true;
                }
            }

            if(flag1)
            {
                func_70107_b(field_70165_t, field_70163_u, field_70161_v);
                if(field_70170_p.func_72945_a(this, field_70121_D).isEmpty() && !field_70170_p.func_72953_d(field_70121_D))
                {
                    flag = true;
                }
            }
        }
        if(flag)
        {
            int l = 128;
            for(int j1 = 0; j1 < l; j1++)
            {
                double d3 = (double)j1 / ((double)l - 1.0D);
                float f = (field_70146_Z.nextFloat() - 0.5F) * 0.2F;
                float f1 = (field_70146_Z.nextFloat() - 0.5F) * 0.2F;
                float f2 = (field_70146_Z.nextFloat() - 0.5F) * 0.2F;
                double d4 = d + (field_70165_t - d) * d3 + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N * 2D;
                double d5 = d1 + (field_70163_u - d1) * d3 + field_70146_Z.nextDouble() * (double)field_70131_O;
                double d6 = d2 + (field_70161_v - d2) * d3 + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N * 2D;
                field_70170_p.func_72869_a("portal", d4, d5, d6, f, f1, f2);
            }

            field_70170_p.func_72908_a(d, d1, d2, "mob.endermen.portal", 1.0F, 1.0F);
            field_70170_p.func_72956_a(this, "mob.endermen.portal", 1.0F, 1.0F);
            return true;
        } else
        {
            func_70107_b(d, d1, d2);
            return false;
        }
    }

    protected String func_70639_aQ()
    {
        return "mob.endermen.idle";
    }

    protected String func_70621_aR()
    {
        return "mob.endermen.hit";
    }

    protected String func_70673_aS()
    {
        return "mob.endermen.death";
    }

    protected int func_70633_aT()
    {
        return Item.field_77730_bn.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = func_70633_aT();
        if(i > 0)
        {
            int j = field_70146_Z.nextInt(2 + p_70628_2_);
            for(int k = 0; k < j; k++)
            {
                func_70025_b(i, 1);
            }

        }
    }

    public void func_70818_a(int p_70818_1_)
    {
        field_70180_af.func_75692_b(16, Byte.valueOf((byte)(p_70818_1_ & 0xff)));
    }

    public int func_70822_p()
    {
        return field_70180_af.func_75683_a(16);
    }

    public void func_70817_b(int p_70817_1_)
    {
        field_70180_af.func_75692_b(17, Byte.valueOf((byte)(p_70817_1_ & 0xff)));
    }

    public int func_70824_q()
    {
        return field_70180_af.func_75683_a(17);
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(p_70097_1_ instanceof EntityDamageSourceIndirect)
        {
            for(int i = 0; i < 64; i++)
            {
                if(func_70820_n())
                {
                    return true;
                }
            }

            return false;
        }
        if(p_70097_1_.func_76346_g() instanceof EntityPlayer)
        {
            func_70819_e(true);
        }
        return super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    public void func_70819_e(boolean p_70819_1_)
    {
        field_70180_af.func_75692_b(18, Byte.valueOf((byte)(p_70819_1_ ? 1 : 0)));
    }

    static 
    {
        field_70827_d = new boolean[256];
        field_70827_d[Block.field_71980_u.field_71990_ca] = true;
        field_70827_d[Block.field_71979_v.field_71990_ca] = true;
        field_70827_d[Block.field_71939_E.field_71990_ca] = true;
        field_70827_d[Block.field_71940_F.field_71990_ca] = true;
        field_70827_d[Block.field_72097_ad.field_71990_ca] = true;
        field_70827_d[Block.field_72107_ae.field_71990_ca] = true;
        field_70827_d[Block.field_72109_af.field_71990_ca] = true;
        field_70827_d[Block.field_72103_ag.field_71990_ca] = true;
        field_70827_d[Block.field_72091_am.field_71990_ca] = true;
        field_70827_d[Block.field_72038_aV.field_71990_ca] = true;
        field_70827_d[Block.field_72041_aW.field_71990_ca] = true;
        field_70827_d[Block.field_72061_ba.field_71990_ca] = true;
        field_70827_d[Block.field_71997_br.field_71990_ca] = true;
        field_70827_d[Block.field_71994_by.field_71990_ca] = true;
    }
}
