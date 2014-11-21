// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, ChunkCoordinates, EntityAITasks, World, 
//            EntityLookHelper, EntityMoveHelper, EntityJumpHelper, EntityBodyHelper, 
//            PathNavigate, EntitySenses, EntityCreeper, EntityGhast, 
//            MathHelper, DataWatcher, Vec3, Vec3Pool, 
//            Profiler, DamageSource, Material, Potion, 
//            EntityXPOrb, EntityPlayer, EntityWolf, PotionEffect, 
//            EnchantmentHelper, Block, StepSound, PlayerCapabilities, 
//            AxisAlignedBB, NBTTagCompound, NBTTagList, PotionHelper, 
//            EnumCreatureAttribute, ItemStack, Item

public abstract class EntityLiving extends Entity
{

    public int field_70771_an;
    public float field_70769_ao;
    public float field_70770_ap;
    public float field_70761_aq;
    public float field_70760_ar;
    public float field_70759_as;
    public float field_70758_at;
    protected float field_70768_au;
    protected float field_70766_av;
    protected float field_70764_aw;
    protected float field_70763_ax;
    protected boolean field_70753_ay;
    protected String field_70750_az;
    protected boolean field_70740_aA;
    protected float field_70741_aB;
    protected String field_70742_aC;
    protected float field_70743_aD;
    protected int field_70744_aE;
    protected float field_70745_aF;
    public float field_70746_aG;
    public float field_70747_aH;
    public float field_70732_aI;
    public float field_70733_aJ;
    protected int field_70734_aK;
    public int field_70735_aL;
    protected int field_70736_aM;
    private int field_70757_a;
    public int field_70737_aN;
    public int field_70738_aO;
    public float field_70739_aP;
    public int field_70725_aQ;
    public int field_70724_aR;
    public float field_70727_aS;
    public float field_70726_aT;
    protected boolean field_70729_aU;
    protected int field_70728_aV;
    public int field_70731_aW;
    public float field_70730_aX;
    public float field_70722_aY;
    public float field_70721_aZ;
    public float field_70754_ba;
    protected EntityPlayer field_70717_bb;
    protected int field_70718_bc;
    private EntityLiving field_70755_b;
    private int field_70756_c;
    private EntityLiving field_70751_d;
    public int field_70719_bd;
    public int field_70720_be;
    protected HashMap field_70713_bf;
    private boolean field_70752_e;
    private int field_70748_f;
    private EntityLookHelper field_70749_g;
    private EntityMoveHelper field_70765_h;
    private EntityJumpHelper field_70767_i;
    private EntityBodyHelper field_70762_j;
    private PathNavigate field_70699_by;
    protected final EntityAITasks field_70714_bg;
    protected final EntityAITasks field_70715_bh;
    private EntityLiving field_70696_bz;
    private EntitySenses field_70723_bA;
    private float field_70774_bB;
    private ChunkCoordinates field_70775_bC;
    private float field_70772_bD;
    protected int field_70716_bi;
    protected double field_70709_bj;
    protected double field_70710_bk;
    protected double field_70711_bl;
    protected double field_70712_bm;
    protected double field_70705_bn;
    float field_70706_bo;
    protected int field_70707_bp;
    protected int field_70708_bq;
    protected float field_70702_br;
    protected float field_70701_bs;
    protected float field_70704_bt;
    protected boolean field_70703_bu;
    protected float field_70698_bv;
    protected float field_70697_bw;
    private int field_70773_bE;
    private Entity field_70776_bF;
    protected int field_70700_bx;

    public EntityLiving(World p_i3443_1_)
    {
        super(p_i3443_1_);
        field_70771_an = 20;
        field_70761_aq = 0.0F;
        field_70760_ar = 0.0F;
        field_70759_as = 0.0F;
        field_70758_at = 0.0F;
        field_70753_ay = true;
        field_70750_az = "/mob/char.png";
        field_70740_aA = true;
        field_70741_aB = 0.0F;
        field_70742_aC = null;
        field_70743_aD = 1.0F;
        field_70744_aE = 0;
        field_70745_aF = 0.0F;
        field_70746_aG = 0.1F;
        field_70747_aH = 0.02F;
        field_70739_aP = 0.0F;
        field_70725_aQ = 0;
        field_70724_aR = 0;
        field_70729_aU = false;
        field_70731_aW = -1;
        field_70730_aX = (float)(Math.random() * 0.89999997615814209D + 0.10000000149011612D);
        field_70717_bb = null;
        field_70718_bc = 0;
        field_70755_b = null;
        field_70756_c = 0;
        field_70751_d = null;
        field_70719_bd = 0;
        field_70720_be = 0;
        field_70713_bf = new HashMap();
        field_70752_e = true;
        field_70775_bC = new ChunkCoordinates(0, 0, 0);
        field_70772_bD = -1F;
        field_70706_bo = 0.0F;
        field_70707_bp = 0;
        field_70708_bq = 0;
        field_70703_bu = false;
        field_70698_bv = 0.0F;
        field_70697_bw = 0.7F;
        field_70773_bE = 0;
        field_70700_bx = 0;
        field_70734_aK = func_70667_aM();
        field_70156_m = true;
        field_70714_bg = new EntityAITasks(p_i3443_1_ != null && p_i3443_1_.field_72984_F != null ? p_i3443_1_.field_72984_F : null);
        field_70715_bh = new EntityAITasks(p_i3443_1_ != null && p_i3443_1_.field_72984_F != null ? p_i3443_1_.field_72984_F : null);
        field_70749_g = new EntityLookHelper(this);
        field_70765_h = new EntityMoveHelper(this);
        field_70767_i = new EntityJumpHelper(this);
        field_70762_j = new EntityBodyHelper(this);
        field_70699_by = new PathNavigate(this, p_i3443_1_, 16F);
        field_70723_bA = new EntitySenses(this);
        field_70770_ap = (float)(Math.random() + 1.0D) * 0.01F;
        func_70107_b(field_70165_t, field_70163_u, field_70161_v);
        field_70769_ao = (float)Math.random() * 12398F;
        field_70177_z = (float)(Math.random() * 3.1415927410125732D * 2D);
        field_70759_as = field_70177_z;
        field_70138_W = 0.5F;
    }

    public EntityLookHelper func_70671_ap()
    {
        return field_70749_g;
    }

    public EntityMoveHelper func_70605_aq()
    {
        return field_70765_h;
    }

    public EntityJumpHelper func_70683_ar()
    {
        return field_70767_i;
    }

    public PathNavigate func_70661_as()
    {
        return field_70699_by;
    }

    public EntitySenses func_70635_at()
    {
        return field_70723_bA;
    }

    public Random func_70681_au()
    {
        return field_70146_Z;
    }

    public EntityLiving func_70643_av()
    {
        return field_70755_b;
    }

    public EntityLiving func_70680_aw()
    {
        return field_70751_d;
    }

    public void func_70607_j(Entity p_70607_1_)
    {
        if(p_70607_1_ instanceof EntityLiving)
        {
            field_70751_d = (EntityLiving)p_70607_1_;
        }
    }

    public int func_70654_ax()
    {
        return field_70708_bq;
    }

    public float func_70079_am()
    {
        return field_70759_as;
    }

    public float func_70689_ay()
    {
        return field_70774_bB;
    }

    public void func_70659_e(float p_70659_1_)
    {
        field_70774_bB = p_70659_1_;
        func_70657_f(p_70659_1_);
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        func_70607_j(p_70652_1_);
        return false;
    }

    public EntityLiving func_70638_az()
    {
        return field_70696_bz;
    }

    public void func_70624_b(EntityLiving p_70624_1_)
    {
        field_70696_bz = p_70624_1_;
    }

    public boolean func_70686_a(Class p_70686_1_)
    {
        return (net.minecraft.src.EntityCreeper.class) != p_70686_1_ && (net.minecraft.src.EntityGhast.class) != p_70686_1_;
    }

    public void func_70615_aA()
    {
    }

    public boolean func_70611_aB()
    {
        return func_70649_d(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v));
    }

    public boolean func_70649_d(int p_70649_1_, int p_70649_2_, int p_70649_3_)
    {
        if(field_70772_bD == -1F)
        {
            return true;
        } else
        {
            return field_70775_bC.func_71569_e(p_70649_1_, p_70649_2_, p_70649_3_) < field_70772_bD * field_70772_bD;
        }
    }

    public void func_70598_b(int p_70598_1_, int p_70598_2_, int p_70598_3_, int p_70598_4_)
    {
        field_70775_bC.func_71571_b(p_70598_1_, p_70598_2_, p_70598_3_);
        field_70772_bD = p_70598_4_;
    }

    public ChunkCoordinates func_70602_aC()
    {
        return field_70775_bC;
    }

    public float func_70640_aD()
    {
        return field_70772_bD;
    }

    public void func_70677_aE()
    {
        field_70772_bD = -1F;
    }

    public boolean func_70622_aF()
    {
        return field_70772_bD != -1F;
    }

    public void func_70604_c(EntityLiving p_70604_1_)
    {
        field_70755_b = p_70604_1_;
        field_70756_c = field_70755_b == null ? 0 : 60;
    }

    protected void func_70088_a()
    {
        field_70180_af.func_75682_a(8, Integer.valueOf(field_70748_f));
    }

    public boolean func_70685_l(Entity p_70685_1_)
    {
        return field_70170_p.func_72933_a(Vec3.func_72437_a().func_72345_a(field_70165_t, field_70163_u + (double)func_70047_e(), field_70161_v), Vec3.func_72437_a().func_72345_a(p_70685_1_.field_70165_t, p_70685_1_.field_70163_u + (double)p_70685_1_.func_70047_e(), p_70685_1_.field_70161_v)) == null;
    }

    public boolean func_70067_L()
    {
        return !field_70128_L;
    }

    public boolean func_70104_M()
    {
        return !field_70128_L;
    }

    public float func_70047_e()
    {
        return field_70131_O * 0.85F;
    }

    public int func_70627_aG()
    {
        return 80;
    }

    public void func_70642_aH()
    {
        String s = func_70639_aQ();
        if(s != null)
        {
            field_70170_p.func_72956_a(this, s, func_70599_aP(), func_70647_i());
        }
    }

    public void func_70030_z()
    {
        field_70732_aI = field_70733_aJ;
        super.func_70030_z();
        field_70170_p.field_72984_F.func_76320_a("mobBaseTick");
        if(func_70089_S() && field_70146_Z.nextInt(1000) < field_70757_a++)
        {
            field_70757_a = -func_70627_aG();
            func_70642_aH();
        }
        if(func_70089_S() && func_70094_T())
        {
            func_70097_a(DamageSource.field_76368_d, 1);
        }
        if(func_70045_F() || field_70170_p.field_72995_K)
        {
            func_70066_B();
        }
        if(func_70089_S() && func_70055_a(Material.field_76244_g) && !func_70648_aU() && !field_70713_bf.containsKey(Integer.valueOf(Potion.field_76427_o.field_76415_H)))
        {
            func_70050_g(func_70682_h(func_70086_ai()));
            if(func_70086_ai() == -20)
            {
                func_70050_g(0);
                for(int i = 0; i < 8; i++)
                {
                    float f = field_70146_Z.nextFloat() - field_70146_Z.nextFloat();
                    float f1 = field_70146_Z.nextFloat() - field_70146_Z.nextFloat();
                    float f2 = field_70146_Z.nextFloat() - field_70146_Z.nextFloat();
                    field_70170_p.func_72869_a("bubble", field_70165_t + (double)f, field_70163_u + (double)f1, field_70161_v + (double)f2, field_70159_w, field_70181_x, field_70179_y);
                }

                func_70097_a(DamageSource.field_76369_e, 2);
            }
            func_70066_B();
        } else
        {
            func_70050_g(300);
        }
        field_70727_aS = field_70726_aT;
        if(field_70724_aR > 0)
        {
            field_70724_aR--;
        }
        if(field_70737_aN > 0)
        {
            field_70737_aN--;
        }
        if(field_70172_ad > 0)
        {
            field_70172_ad--;
        }
        if(field_70734_aK <= 0)
        {
            func_70609_aI();
        }
        if(field_70718_bc > 0)
        {
            field_70718_bc--;
        } else
        {
            field_70717_bb = null;
        }
        if(field_70751_d != null && !field_70751_d.func_70089_S())
        {
            field_70751_d = null;
        }
        if(field_70755_b != null)
        {
            if(!field_70755_b.func_70089_S())
            {
                func_70604_c(null);
            } else
            if(field_70756_c > 0)
            {
                field_70756_c--;
            } else
            {
                func_70604_c(null);
            }
        }
        func_70679_bo();
        field_70763_ax = field_70764_aw;
        field_70760_ar = field_70761_aq;
        field_70758_at = field_70759_as;
        field_70126_B = field_70177_z;
        field_70127_C = field_70125_A;
        field_70170_p.field_72984_F.func_76319_b();
    }

    protected void func_70609_aI()
    {
        field_70725_aQ++;
        if(field_70725_aQ == 20)
        {
            if(!field_70170_p.field_72995_K && (field_70718_bc > 0 || func_70684_aJ()) && !func_70631_g_())
            {
                for(int i = func_70693_a(field_70717_bb); i > 0;)
                {
                    int k = EntityXPOrb.func_70527_a(i);
                    i -= k;
                    field_70170_p.func_72838_d(new EntityXPOrb(field_70170_p, field_70165_t, field_70163_u, field_70161_v, k));
                }

            }
            func_70106_y();
            for(int j = 0; j < 20; j++)
            {
                double d = field_70146_Z.nextGaussian() * 0.02D;
                double d1 = field_70146_Z.nextGaussian() * 0.02D;
                double d2 = field_70146_Z.nextGaussian() * 0.02D;
                field_70170_p.func_72869_a("explode", (field_70165_t + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, field_70163_u + (double)(field_70146_Z.nextFloat() * field_70131_O), (field_70161_v + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, d, d1, d2);
            }

        }
    }

    protected int func_70682_h(int p_70682_1_)
    {
        return p_70682_1_ - 1;
    }

    protected int func_70693_a(EntityPlayer p_70693_1_)
    {
        return field_70728_aV;
    }

    protected boolean func_70684_aJ()
    {
        return false;
    }

    public void func_70656_aK()
    {
        for(int i = 0; i < 20; i++)
        {
            double d = field_70146_Z.nextGaussian() * 0.02D;
            double d1 = field_70146_Z.nextGaussian() * 0.02D;
            double d2 = field_70146_Z.nextGaussian() * 0.02D;
            double d3 = 10D;
            field_70170_p.func_72869_a("explode", (field_70165_t + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N - d * d3, (field_70163_u + (double)(field_70146_Z.nextFloat() * field_70131_O)) - d1 * d3, (field_70161_v + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N - d2 * d3, d, d1, d2);
        }

    }

    public void func_70098_U()
    {
        super.func_70098_U();
        field_70768_au = field_70766_av;
        field_70766_av = 0.0F;
        field_70143_R = 0.0F;
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(field_70719_bd > 0)
        {
            if(field_70720_be <= 0)
            {
                field_70720_be = 60;
            }
            field_70720_be--;
            if(field_70720_be <= 0)
            {
                field_70719_bd--;
            }
        }
        func_70636_d();
        double d = field_70165_t - field_70169_q;
        double d1 = field_70161_v - field_70166_s;
        float f = (float)(d * d + d1 * d1);
        float f1 = field_70761_aq;
        float f2 = 0.0F;
        field_70768_au = field_70766_av;
        float f3 = 0.0F;
        if(f > 0.0025F)
        {
            f3 = 1.0F;
            f2 = (float)Math.sqrt(f) * 3F;
            f1 = ((float)Math.atan2(d1, d) * 180F) / 3.141593F - 90F;
        }
        if(field_70733_aJ > 0.0F)
        {
            f1 = field_70177_z;
        }
        if(!field_70122_E)
        {
            f3 = 0.0F;
        }
        field_70766_av += (f3 - field_70766_av) * 0.3F;
        field_70170_p.field_72984_F.func_76320_a("headTurn");
        if(func_70650_aV())
        {
            field_70762_j.func_75664_a();
        } else
        {
            float f4 = MathHelper.func_76142_g(f1 - field_70761_aq);
            field_70761_aq += f4 * 0.3F;
            float f5 = MathHelper.func_76142_g(field_70177_z - field_70761_aq);
            boolean flag = f5 < -90F || f5 >= 90F;
            if(f5 < -75F)
            {
                f5 = -75F;
            }
            if(f5 >= 75F)
            {
                f5 = 75F;
            }
            field_70761_aq = field_70177_z - f5;
            if(f5 * f5 > 2500F)
            {
                field_70761_aq += f5 * 0.2F;
            }
            if(flag)
            {
                f2 *= -1F;
            }
        }
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("rangeChecks");
        for(; field_70177_z - field_70126_B < -180F; field_70126_B -= 360F) { }
        for(; field_70177_z - field_70126_B >= 180F; field_70126_B += 360F) { }
        for(; field_70761_aq - field_70760_ar < -180F; field_70760_ar -= 360F) { }
        for(; field_70761_aq - field_70760_ar >= 180F; field_70760_ar += 360F) { }
        for(; field_70125_A - field_70127_C < -180F; field_70127_C -= 360F) { }
        for(; field_70125_A - field_70127_C >= 180F; field_70127_C += 360F) { }
        for(; field_70759_as - field_70758_at < -180F; field_70758_at -= 360F) { }
        for(; field_70759_as - field_70758_at >= 180F; field_70758_at += 360F) { }
        field_70170_p.field_72984_F.func_76319_b();
        field_70764_aw += f2;
    }

    public void func_70691_i(int p_70691_1_)
    {
        if(field_70734_aK <= 0)
        {
            return;
        }
        field_70734_aK += p_70691_1_;
        if(field_70734_aK > func_70667_aM())
        {
            field_70734_aK = func_70667_aM();
        }
        field_70172_ad = field_70771_an / 2;
    }

    public abstract int func_70667_aM();

    public int func_70630_aN()
    {
        return field_70734_aK;
    }

    public void func_70606_j(int p_70606_1_)
    {
        field_70734_aK = p_70606_1_;
        if(p_70606_1_ > func_70667_aM())
        {
            p_70606_1_ = func_70667_aM();
        }
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(field_70170_p.field_72995_K)
        {
            return false;
        }
        field_70708_bq = 0;
        if(field_70734_aK <= 0)
        {
            return false;
        }
        if(p_70097_1_.func_76347_k() && func_70644_a(Potion.field_76426_n))
        {
            return false;
        }
        field_70721_aZ = 1.5F;
        boolean flag = true;
        if((float)field_70172_ad > (float)field_70771_an / 2.0F)
        {
            if(p_70097_2_ <= field_70707_bp)
            {
                return false;
            }
            func_70665_d(p_70097_1_, p_70097_2_ - field_70707_bp);
            field_70707_bp = p_70097_2_;
            flag = false;
        } else
        {
            field_70707_bp = p_70097_2_;
            field_70735_aL = field_70734_aK;
            field_70172_ad = field_70771_an;
            func_70665_d(p_70097_1_, p_70097_2_);
            field_70737_aN = field_70738_aO = 10;
        }
        field_70739_aP = 0.0F;
        Entity entity = p_70097_1_.func_76346_g();
        if(entity != null)
        {
            if(entity instanceof EntityLiving)
            {
                func_70604_c((EntityLiving)entity);
            }
            if(entity instanceof EntityPlayer)
            {
                field_70718_bc = 60;
                field_70717_bb = (EntityPlayer)entity;
            } else
            if(entity instanceof EntityWolf)
            {
                EntityWolf entitywolf = (EntityWolf)entity;
                if(entitywolf.func_70909_n())
                {
                    field_70718_bc = 60;
                    field_70717_bb = null;
                }
            }
        }
        if(flag)
        {
            field_70170_p.func_72960_a(this, (byte)2);
            if(p_70097_1_ != DamageSource.field_76369_e && p_70097_1_ != DamageSource.field_76375_l)
            {
                func_70018_K();
            }
            if(entity != null)
            {
                double d = entity.field_70165_t - field_70165_t;
                double d1;
                for(d1 = entity.field_70161_v - field_70161_v; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D)
                {
                    d = (Math.random() - Math.random()) * 0.01D;
                }

                field_70739_aP = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - field_70177_z;
                func_70653_a(entity, p_70097_2_, d, d1);
            } else
            {
                field_70739_aP = (int)(Math.random() * 2D) * 180;
            }
        }
        if(field_70734_aK <= 0)
        {
            if(flag)
            {
                field_70170_p.func_72956_a(this, func_70673_aS(), func_70599_aP(), func_70647_i());
            }
            func_70645_a(p_70097_1_);
        } else
        if(flag)
        {
            field_70170_p.func_72956_a(this, func_70621_aR(), func_70599_aP(), func_70647_i());
        }
        return true;
    }

    private float func_70647_i()
    {
        if(func_70631_g_())
        {
            return (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.5F;
        } else
        {
            return (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 1.0F;
        }
    }

    public int func_70658_aO()
    {
        return 0;
    }

    protected void func_70675_k(int i)
    {
    }

    protected int func_70655_b(DamageSource p_70655_1_, int p_70655_2_)
    {
        if(!p_70655_1_.func_76363_c())
        {
            int i = 25 - func_70658_aO();
            int j = p_70655_2_ * i + field_70736_aM;
            func_70675_k(p_70655_2_);
            p_70655_2_ = j / 25;
            field_70736_aM = j % 25;
        }
        return p_70655_2_;
    }

    protected int func_70672_c(DamageSource p_70672_1_, int p_70672_2_)
    {
        if(func_70644_a(Potion.field_76429_m))
        {
            int i = (func_70660_b(Potion.field_76429_m).func_76458_c() + 1) * 5;
            int j = 25 - i;
            int k = p_70672_2_ * j + field_70736_aM;
            p_70672_2_ = k / 25;
            field_70736_aM = k % 25;
        }
        return p_70672_2_;
    }

    protected void func_70665_d(DamageSource p_70665_1_, int p_70665_2_)
    {
        p_70665_2_ = func_70655_b(p_70665_1_, p_70665_2_);
        p_70665_2_ = func_70672_c(p_70665_1_, p_70665_2_);
        field_70734_aK -= p_70665_2_;
    }

    protected float func_70599_aP()
    {
        return 1.0F;
    }

    protected String func_70639_aQ()
    {
        return null;
    }

    protected String func_70621_aR()
    {
        return "damage.hurtflesh";
    }

    protected String func_70673_aS()
    {
        return "damage.hurtflesh";
    }

    public void func_70653_a(Entity p_70653_1_, int p_70653_2_, double p_70653_3_, double p_70653_5_)
    {
        field_70160_al = true;
        float f = MathHelper.func_76133_a(p_70653_3_ * p_70653_3_ + p_70653_5_ * p_70653_5_);
        float f1 = 0.4F;
        field_70159_w /= 2D;
        field_70181_x /= 2D;
        field_70179_y /= 2D;
        field_70159_w -= (p_70653_3_ / (double)f) * (double)f1;
        field_70181_x += f1;
        field_70179_y -= (p_70653_5_ / (double)f) * (double)f1;
        if(field_70181_x > 0.40000000596046448D)
        {
            field_70181_x = 0.40000000596046448D;
        }
    }

    public void func_70645_a(DamageSource p_70645_1_)
    {
        Entity entity = p_70645_1_.func_76346_g();
        if(field_70744_aE >= 0 && entity != null)
        {
            entity.func_70084_c(this, field_70744_aE);
        }
        if(entity != null)
        {
            entity.func_70074_a(this);
        }
        field_70729_aU = true;
        if(!field_70170_p.field_72995_K)
        {
            int i = 0;
            if(entity instanceof EntityPlayer)
            {
                i = EnchantmentHelper.func_77519_f(((EntityPlayer)entity).field_71071_by);
            }
            if(!func_70631_g_())
            {
                func_70628_a(field_70718_bc > 0, i);
                if(field_70718_bc > 0)
                {
                    int j = field_70146_Z.nextInt(200) - i;
                    if(j < 5)
                    {
                        func_70600_l(j > 0 ? 0 : 1);
                    }
                }
            }
        }
        field_70170_p.func_72960_a(this, (byte)3);
    }

    protected void func_70600_l(int i)
    {
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        int i = func_70633_aT();
        if(i > 0)
        {
            int j = field_70146_Z.nextInt(3);
            if(p_70628_2_ > 0)
            {
                j += field_70146_Z.nextInt(p_70628_2_ + 1);
            }
            for(int k = 0; k < j; k++)
            {
                func_70025_b(i, 1);
            }

        }
    }

    protected int func_70633_aT()
    {
        return 0;
    }

    protected void func_70069_a(float p_70069_1_)
    {
        super.func_70069_a(p_70069_1_);
        int i = MathHelper.func_76123_f(p_70069_1_ - 3F);
        if(i > 0)
        {
            if(i > 4)
            {
                field_70170_p.func_72956_a(this, "damage.fallbig", 1.0F, 1.0F);
            } else
            {
                field_70170_p.func_72956_a(this, "damage.fallsmall", 1.0F, 1.0F);
            }
            func_70097_a(DamageSource.field_76379_h, i);
            int j = field_70170_p.func_72798_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u - 0.20000000298023224D - (double)field_70129_M), MathHelper.func_76128_c(field_70161_v));
            if(j > 0)
            {
                StepSound stepsound = Block.field_71973_m[j].field_72020_cn;
                field_70170_p.func_72956_a(this, stepsound.func_72675_d(), stepsound.func_72677_b() * 0.5F, stepsound.func_72678_c() * 0.75F);
            }
        }
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_)
    {
        if(func_70090_H() && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).field_71075_bZ.field_75100_b))
        {
            double d = field_70163_u;
            func_70060_a(p_70612_1_, p_70612_2_, func_70650_aV() ? 0.04F : 0.02F);
            func_70091_d(field_70159_w, field_70181_x, field_70179_y);
            field_70159_w *= 0.80000001192092896D;
            field_70181_x *= 0.80000001192092896D;
            field_70179_y *= 0.80000001192092896D;
            field_70181_x -= 0.02D;
            if(field_70123_F && func_70038_c(field_70159_w, ((field_70181_x + 0.60000002384185791D) - field_70163_u) + d, field_70179_y))
            {
                field_70181_x = 0.30000001192092896D;
            }
        } else
        if(func_70058_J() && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).field_71075_bZ.field_75100_b))
        {
            double d1 = field_70163_u;
            func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
            func_70091_d(field_70159_w, field_70181_x, field_70179_y);
            field_70159_w *= 0.5D;
            field_70181_x *= 0.5D;
            field_70179_y *= 0.5D;
            field_70181_x -= 0.02D;
            if(field_70123_F && func_70038_c(field_70159_w, ((field_70181_x + 0.60000002384185791D) - field_70163_u) + d1, field_70179_y))
            {
                field_70181_x = 0.30000001192092896D;
            }
        } else
        {
            float f = 0.91F;
            if(field_70122_E)
            {
                f = 0.5460001F;
                int i = field_70170_p.func_72798_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(field_70161_v));
                if(i > 0)
                {
                    f = Block.field_71973_m[i].field_72016_cq * 0.91F;
                }
            }
            float f1 = 0.1627714F / (f * f * f);
            float f2;
            if(field_70122_E)
            {
                if(func_70650_aV())
                {
                    f2 = func_70689_ay();
                } else
                {
                    f2 = field_70746_aG;
                }
                f2 *= f1;
            } else
            {
                f2 = field_70747_aH;
            }
            func_70060_a(p_70612_1_, p_70612_2_, f2);
            f = 0.91F;
            if(field_70122_E)
            {
                f = 0.5460001F;
                int j = field_70170_p.func_72798_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(field_70161_v));
                if(j > 0)
                {
                    f = Block.field_71973_m[j].field_72016_cq * 0.91F;
                }
            }
            if(func_70617_f_())
            {
                float f3 = 0.15F;
                if(field_70159_w < (double)(-f3))
                {
                    field_70159_w = -f3;
                }
                if(field_70159_w > (double)f3)
                {
                    field_70159_w = f3;
                }
                if(field_70179_y < (double)(-f3))
                {
                    field_70179_y = -f3;
                }
                if(field_70179_y > (double)f3)
                {
                    field_70179_y = f3;
                }
                field_70143_R = 0.0F;
                if(field_70181_x < -0.14999999999999999D)
                {
                    field_70181_x = -0.14999999999999999D;
                }
                boolean flag = func_70093_af() && (this instanceof EntityPlayer);
                if(flag && field_70181_x < 0.0D)
                {
                    field_70181_x = 0.0D;
                }
            }
            func_70091_d(field_70159_w, field_70181_x, field_70179_y);
            if(field_70123_F && func_70617_f_())
            {
                field_70181_x = 0.20000000000000001D;
            }
            field_70181_x -= 0.080000000000000002D;
            field_70181_x *= 0.98000001907348633D;
            field_70159_w *= f;
            field_70179_y *= f;
        }
        field_70722_aY = field_70721_aZ;
        double d2 = field_70165_t - field_70169_q;
        double d3 = field_70161_v - field_70166_s;
        float f4 = MathHelper.func_76133_a(d2 * d2 + d3 * d3) * 4F;
        if(f4 > 1.0F)
        {
            f4 = 1.0F;
        }
        field_70721_aZ += (f4 - field_70721_aZ) * 0.4F;
        field_70754_ba += field_70721_aZ;
    }

    public boolean func_70617_f_()
    {
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76128_c(field_70121_D.field_72338_b);
        int k = MathHelper.func_76128_c(field_70161_v);
        int l = field_70170_p.func_72798_a(i, j, k);
        return l == Block.field_72055_aF.field_71990_ca || l == Block.field_71998_bu.field_71990_ca;
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74777_a("Health", (short)field_70734_aK);
        p_70014_1_.func_74777_a("HurtTime", (short)field_70737_aN);
        p_70014_1_.func_74777_a("DeathTime", (short)field_70725_aQ);
        p_70014_1_.func_74777_a("AttackTime", (short)field_70724_aR);
        if(!field_70713_bf.isEmpty())
        {
            NBTTagList nbttaglist = new NBTTagList();
            NBTTagCompound nbttagcompound;
            for(Iterator iterator = field_70713_bf.values().iterator(); iterator.hasNext(); nbttaglist.func_74742_a(nbttagcompound))
            {
                PotionEffect potioneffect = (PotionEffect)iterator.next();
                nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Id", (byte)potioneffect.func_76456_a());
                nbttagcompound.func_74774_a("Amplifier", (byte)potioneffect.func_76458_c());
                nbttagcompound.func_74768_a("Duration", potioneffect.func_76459_b());
            }

            p_70014_1_.func_74782_a("ActiveEffects", nbttaglist);
        }
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        if(field_70734_aK < -32768)
        {
            field_70734_aK = -32768;
        }
        field_70734_aK = p_70037_1_.func_74765_d("Health");
        if(!p_70037_1_.func_74764_b("Health"))
        {
            field_70734_aK = func_70667_aM();
        }
        field_70737_aN = p_70037_1_.func_74765_d("HurtTime");
        field_70725_aQ = p_70037_1_.func_74765_d("DeathTime");
        field_70724_aR = p_70037_1_.func_74765_d("AttackTime");
        if(p_70037_1_.func_74764_b("ActiveEffects"))
        {
            NBTTagList nbttaglist = p_70037_1_.func_74761_m("ActiveEffects");
            for(int i = 0; i < nbttaglist.func_74745_c(); i++)
            {
                NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_74743_b(i);
                byte byte0 = nbttagcompound.func_74771_c("Id");
                byte byte1 = nbttagcompound.func_74771_c("Amplifier");
                int j = nbttagcompound.func_74762_e("Duration");
                field_70713_bf.put(Integer.valueOf(byte0), new PotionEffect(byte0, j, byte1));
            }

        }
    }

    public boolean func_70089_S()
    {
        return !field_70128_L && field_70734_aK > 0;
    }

    public boolean func_70648_aU()
    {
        return false;
    }

    public void func_70657_f(float p_70657_1_)
    {
        field_70701_bs = p_70657_1_;
    }

    public void func_70637_d(boolean p_70637_1_)
    {
        field_70703_bu = p_70637_1_;
    }

    public void func_70636_d()
    {
        if(field_70773_bE > 0)
        {
            field_70773_bE--;
        }
        if(field_70716_bi > 0)
        {
            double d = field_70165_t + (field_70709_bj - field_70165_t) / (double)field_70716_bi;
            double d1 = field_70163_u + (field_70710_bk - field_70163_u) / (double)field_70716_bi;
            double d2 = field_70161_v + (field_70711_bl - field_70161_v) / (double)field_70716_bi;
            double d3 = MathHelper.func_76138_g(field_70712_bm - (double)field_70177_z);
            field_70177_z += d3 / (double)field_70716_bi;
            field_70125_A += (field_70705_bn - (double)field_70125_A) / (double)field_70716_bi;
            field_70716_bi--;
            func_70107_b(d, d1, d2);
            func_70101_b(field_70177_z, field_70125_A);
        }
        if(Math.abs(field_70159_w) < 0.0050000000000000001D)
        {
            field_70159_w = 0.0D;
        }
        if(Math.abs(field_70181_x) < 0.0050000000000000001D)
        {
            field_70181_x = 0.0D;
        }
        if(Math.abs(field_70179_y) < 0.0050000000000000001D)
        {
            field_70179_y = 0.0D;
        }
        field_70170_p.field_72984_F.func_76320_a("ai");
        if(func_70610_aX())
        {
            field_70703_bu = false;
            field_70702_br = 0.0F;
            field_70701_bs = 0.0F;
            field_70704_bt = 0.0F;
        } else
        if(func_70613_aW())
        {
            if(func_70650_aV())
            {
                field_70170_p.field_72984_F.func_76320_a("newAi");
                func_70619_bc();
                field_70170_p.field_72984_F.func_76319_b();
            } else
            {
                field_70170_p.field_72984_F.func_76320_a("oldAi");
                func_70626_be();
                field_70170_p.field_72984_F.func_76319_b();
                field_70759_as = field_70177_z;
            }
        }
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("jump");
        if(field_70703_bu)
        {
            if(func_70090_H() || func_70058_J())
            {
                field_70181_x += 0.039999999105930328D;
            } else
            if(field_70122_E && field_70773_bE == 0)
            {
                func_70664_aZ();
                field_70773_bE = 10;
            }
        } else
        {
            field_70773_bE = 0;
        }
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("travel");
        field_70702_br *= 0.98F;
        field_70701_bs *= 0.98F;
        field_70704_bt *= 0.9F;
        float f = field_70746_aG;
        field_70746_aG *= func_70616_bs();
        func_70612_e(field_70702_br, field_70701_bs);
        field_70746_aG = f;
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("push");
        if(!field_70170_p.field_72995_K)
        {
            List list = field_70170_p.func_72839_b(this, field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            if(list != null && !list.isEmpty())
            {
                Iterator iterator = list.iterator();
                do
                {
                    if(!iterator.hasNext())
                    {
                        break;
                    }
                    Entity entity = (Entity)iterator.next();
                    if(entity.func_70104_M())
                    {
                        entity.func_70108_f(this);
                    }
                } while(true);
            }
        }
        field_70170_p.field_72984_F.func_76319_b();
    }

    protected boolean func_70650_aV()
    {
        return false;
    }

    protected boolean func_70613_aW()
    {
        return !field_70170_p.field_72995_K;
    }

    protected boolean func_70610_aX()
    {
        return field_70734_aK <= 0;
    }

    public boolean func_70632_aY()
    {
        return false;
    }

    protected void func_70664_aZ()
    {
        field_70181_x = 0.41999998688697815D;
        if(func_70644_a(Potion.field_76430_j))
        {
            field_70181_x += (float)(func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1F;
        }
        if(func_70051_ag())
        {
            float f = field_70177_z * 0.01745329F;
            field_70159_w -= MathHelper.func_76126_a(f) * 0.2F;
            field_70179_y += MathHelper.func_76134_b(f) * 0.2F;
        }
        field_70160_al = true;
    }

    protected boolean func_70692_ba()
    {
        return true;
    }

    protected void func_70623_bb()
    {
        EntityPlayer entityplayer = field_70170_p.func_72890_a(this, -1D);
        if(entityplayer != null)
        {
            double d = ((Entity) (entityplayer)).field_70165_t - field_70165_t;
            double d1 = ((Entity) (entityplayer)).field_70163_u - field_70163_u;
            double d2 = ((Entity) (entityplayer)).field_70161_v - field_70161_v;
            double d3 = d * d + d1 * d1 + d2 * d2;
            if(func_70692_ba() && d3 > 16384D)
            {
                func_70106_y();
            }
            if(field_70708_bq > 600 && field_70146_Z.nextInt(800) == 0 && d3 > 1024D && func_70692_ba())
            {
                func_70106_y();
            } else
            if(d3 < 1024D)
            {
                field_70708_bq = 0;
            }
        }
    }

    protected void func_70619_bc()
    {
        field_70708_bq++;
        field_70170_p.field_72984_F.func_76320_a("checkDespawn");
        func_70623_bb();
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("sensing");
        field_70723_bA.func_75523_a();
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("targetSelector");
        field_70715_bh.func_75774_a();
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("goalSelector");
        field_70714_bg.func_75774_a();
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("navigation");
        field_70699_by.func_75501_e();
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("mob tick");
        func_70629_bd();
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76320_a("controls");
        field_70170_p.field_72984_F.func_76320_a("move");
        field_70765_h.func_75641_c();
        field_70170_p.field_72984_F.func_76318_c("look");
        field_70749_g.func_75649_a();
        field_70170_p.field_72984_F.func_76318_c("jump");
        field_70767_i.func_75661_b();
        field_70170_p.field_72984_F.func_76319_b();
        field_70170_p.field_72984_F.func_76319_b();
    }

    protected void func_70629_bd()
    {
    }

    protected void func_70626_be()
    {
        field_70708_bq++;
        func_70623_bb();
        field_70702_br = 0.0F;
        field_70701_bs = 0.0F;
        float f = 8F;
        if(field_70146_Z.nextFloat() < 0.02F)
        {
            EntityPlayer entityplayer = field_70170_p.func_72890_a(this, f);
            if(entityplayer != null)
            {
                field_70776_bF = entityplayer;
                field_70700_bx = 10 + field_70146_Z.nextInt(20);
            } else
            {
                field_70704_bt = (field_70146_Z.nextFloat() - 0.5F) * 20F;
            }
        }
        if(field_70776_bF != null)
        {
            func_70625_a(field_70776_bF, 10F, func_70646_bf());
            if(field_70700_bx-- <= 0 || field_70776_bF.field_70128_L || field_70776_bF.func_70068_e(this) > (double)(f * f))
            {
                field_70776_bF = null;
            }
        } else
        {
            if(field_70146_Z.nextFloat() < 0.05F)
            {
                field_70704_bt = (field_70146_Z.nextFloat() - 0.5F) * 20F;
            }
            field_70177_z += field_70704_bt;
            field_70125_A = field_70698_bv;
        }
        boolean flag = func_70090_H();
        boolean flag1 = func_70058_J();
        if(flag || flag1)
        {
            field_70703_bu = field_70146_Z.nextFloat() < 0.8F;
        }
    }

    public int func_70646_bf()
    {
        return 40;
    }

    public void func_70625_a(Entity p_70625_1_, float p_70625_2_, float p_70625_3_)
    {
        double d = p_70625_1_.field_70165_t - field_70165_t;
        double d2 = p_70625_1_.field_70161_v - field_70161_v;
        double d1;
        if(p_70625_1_ instanceof EntityLiving)
        {
            EntityLiving entityliving = (EntityLiving)p_70625_1_;
            d1 = (field_70163_u + (double)func_70047_e()) - (entityliving.field_70163_u + (double)entityliving.func_70047_e());
        } else
        {
            d1 = (p_70625_1_.field_70121_D.field_72338_b + p_70625_1_.field_70121_D.field_72337_e) / 2D - (field_70163_u + (double)func_70047_e());
        }
        double d3 = MathHelper.func_76133_a(d * d + d2 * d2);
        float f = (float)((Math.atan2(d2, d) * 180D) / 3.1415927410125732D) - 90F;
        float f1 = (float)(-((Math.atan2(d1, d3) * 180D) / 3.1415927410125732D));
        field_70125_A = -func_70663_b(field_70125_A, f1, p_70625_3_);
        field_70177_z = func_70663_b(field_70177_z, f, p_70625_2_);
    }

    private float func_70663_b(float p_70663_1_, float p_70663_2_, float p_70663_3_)
    {
        float f = MathHelper.func_76142_g(p_70663_2_ - p_70663_1_);
        if(f > p_70663_3_)
        {
            f = p_70663_3_;
        }
        if(f < -p_70663_3_)
        {
            f = -p_70663_3_;
        }
        return p_70663_1_ + f;
    }

    public boolean func_70601_bi()
    {
        return field_70170_p.func_72855_b(field_70121_D) && field_70170_p.func_72945_a(this, field_70121_D).isEmpty() && !field_70170_p.func_72953_d(field_70121_D);
    }

    protected void func_70076_C()
    {
        func_70097_a(DamageSource.field_76380_i, 4);
    }

    public Vec3 func_70040_Z()
    {
        return func_70676_i(1.0F);
    }

    public Vec3 func_70676_i(float p_70676_1_)
    {
        if(p_70676_1_ == 1.0F)
        {
            float f = MathHelper.func_76134_b(-field_70177_z * 0.01745329F - 3.141593F);
            float f2 = MathHelper.func_76126_a(-field_70177_z * 0.01745329F - 3.141593F);
            float f4 = -MathHelper.func_76134_b(-field_70125_A * 0.01745329F);
            float f6 = MathHelper.func_76126_a(-field_70125_A * 0.01745329F);
            return Vec3.func_72437_a().func_72345_a(f2 * f4, f6, f * f4);
        } else
        {
            float f1 = field_70127_C + (field_70125_A - field_70127_C) * p_70676_1_;
            float f3 = field_70126_B + (field_70177_z - field_70126_B) * p_70676_1_;
            float f5 = MathHelper.func_76134_b(-f3 * 0.01745329F - 3.141593F);
            float f7 = MathHelper.func_76126_a(-f3 * 0.01745329F - 3.141593F);
            float f8 = -MathHelper.func_76134_b(-f1 * 0.01745329F);
            float f9 = MathHelper.func_76126_a(-f1 * 0.01745329F);
            return Vec3.func_72437_a().func_72345_a(f7 * f8, f9, f5 * f8);
        }
    }

    public int func_70641_bl()
    {
        return 4;
    }

    public boolean func_70608_bn()
    {
        return false;
    }

    protected void func_70679_bo()
    {
        Iterator iterator = field_70713_bf.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Integer integer = (Integer)iterator.next();
            PotionEffect potioneffect = (PotionEffect)field_70713_bf.get(integer);
            if(!potioneffect.func_76455_a(this) && !field_70170_p.field_72995_K)
            {
                iterator.remove();
                func_70688_c(potioneffect);
            }
        } while(true);
        if(field_70752_e)
        {
            if(!field_70170_p.field_72995_K)
            {
                if(field_70713_bf.isEmpty())
                {
                    field_70180_af.func_75692_b(8, Integer.valueOf(0));
                } else
                {
                    int i = PotionHelper.func_77911_a(field_70713_bf.values());
                    field_70180_af.func_75692_b(8, Integer.valueOf(i));
                }
            }
            field_70752_e = false;
        }
        if(field_70146_Z.nextBoolean())
        {
            int j = field_70180_af.func_75679_c(8);
            if(j > 0)
            {
                double d = (double)(j >> 16 & 0xff) / 255D;
                double d1 = (double)(j >> 8 & 0xff) / 255D;
                double d2 = (double)(j >> 0 & 0xff) / 255D;
                field_70170_p.func_72869_a("mobSpell", field_70165_t + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N, (field_70163_u + field_70146_Z.nextDouble() * (double)field_70131_O) - (double)field_70129_M, field_70161_v + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N, d, d1, d2);
            }
        }
    }

    public void func_70674_bp()
    {
        Iterator iterator = field_70713_bf.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Integer integer = (Integer)iterator.next();
            PotionEffect potioneffect = (PotionEffect)field_70713_bf.get(integer);
            if(!field_70170_p.field_72995_K)
            {
                iterator.remove();
                func_70688_c(potioneffect);
            }
        } while(true);
    }

    public Collection func_70651_bq()
    {
        return field_70713_bf.values();
    }

    public boolean func_70644_a(Potion p_70644_1_)
    {
        return field_70713_bf.containsKey(Integer.valueOf(p_70644_1_.field_76415_H));
    }

    public PotionEffect func_70660_b(Potion p_70660_1_)
    {
        return (PotionEffect)field_70713_bf.get(Integer.valueOf(p_70660_1_.field_76415_H));
    }

    public void func_70690_d(PotionEffect p_70690_1_)
    {
        if(!func_70687_e(p_70690_1_))
        {
            return;
        }
        if(field_70713_bf.containsKey(Integer.valueOf(p_70690_1_.func_76456_a())))
        {
            ((PotionEffect)field_70713_bf.get(Integer.valueOf(p_70690_1_.func_76456_a()))).func_76452_a(p_70690_1_);
            func_70695_b((PotionEffect)field_70713_bf.get(Integer.valueOf(p_70690_1_.func_76456_a())));
        } else
        {
            field_70713_bf.put(Integer.valueOf(p_70690_1_.func_76456_a()), p_70690_1_);
            func_70670_a(p_70690_1_);
        }
    }

    public boolean func_70687_e(PotionEffect p_70687_1_)
    {
        if(func_70668_bt() == EnumCreatureAttribute.UNDEAD)
        {
            int i = p_70687_1_.func_76456_a();
            if(i == Potion.field_76428_l.field_76415_H || i == Potion.field_76436_u.field_76415_H)
            {
                return false;
            }
        }
        return true;
    }

    public boolean func_70662_br()
    {
        return func_70668_bt() == EnumCreatureAttribute.UNDEAD;
    }

    protected void func_70670_a(PotionEffect p_70670_1_)
    {
        field_70752_e = true;
    }

    protected void func_70695_b(PotionEffect p_70695_1_)
    {
        field_70752_e = true;
    }

    protected void func_70688_c(PotionEffect p_70688_1_)
    {
        field_70752_e = true;
    }

    protected float func_70616_bs()
    {
        float f = 1.0F;
        if(func_70644_a(Potion.field_76424_c))
        {
            f *= 1.0F + 0.2F * (float)(func_70660_b(Potion.field_76424_c).func_76458_c() + 1);
        }
        if(func_70644_a(Potion.field_76421_d))
        {
            f *= 1.0F - 0.15F * (float)(func_70660_b(Potion.field_76421_d).func_76458_c() + 1);
        }
        return f;
    }

    public void func_70634_a(double p_70634_1_, double p_70634_3_, double p_70634_5_)
    {
        func_70012_b(p_70634_1_, p_70634_3_, p_70634_5_, field_70177_z, field_70125_A);
    }

    public boolean func_70631_g_()
    {
        return false;
    }

    public EnumCreatureAttribute func_70668_bt()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

    public void func_70669_a(ItemStack p_70669_1_)
    {
        field_70170_p.func_72956_a(this, "random.break", 0.8F, 0.8F + field_70170_p.field_73012_v.nextFloat() * 0.4F);
        for(int i = 0; i < 5; i++)
        {
            Vec3 vec3 = Vec3.func_72437_a().func_72345_a(((double)field_70146_Z.nextFloat() - 0.5D) * 0.10000000000000001D, Math.random() * 0.10000000000000001D + 0.10000000000000001D, 0.0D);
            vec3.func_72440_a((-field_70125_A * 3.141593F) / 180F);
            vec3.func_72442_b((-field_70177_z * 3.141593F) / 180F);
            Vec3 vec3_1 = Vec3.func_72437_a().func_72345_a(((double)field_70146_Z.nextFloat() - 0.5D) * 0.29999999999999999D, (double)(-field_70146_Z.nextFloat()) * 0.59999999999999998D - 0.29999999999999999D, 0.59999999999999998D);
            vec3_1.func_72440_a((-field_70125_A * 3.141593F) / 180F);
            vec3_1.func_72442_b((-field_70177_z * 3.141593F) / 180F);
            vec3_1 = vec3_1.func_72441_c(field_70165_t, field_70163_u + (double)func_70047_e(), field_70161_v);
            field_70170_p.func_72869_a((new StringBuilder()).append("iconcrack_").append(p_70669_1_.func_77973_b().field_77779_bT).toString(), vec3_1.field_72450_a, vec3_1.field_72448_b, vec3_1.field_72449_c, vec3.field_72450_a, vec3.field_72448_b + 0.050000000000000003D, vec3.field_72449_c);
        }

    }
}
