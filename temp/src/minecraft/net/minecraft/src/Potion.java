// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, DamageSource, EntityPlayer, PotionEffect, 
//            StringUtils, PotionHealth

public class Potion
{

    public static final Potion field_76425_a[] = new Potion[32];
    public static final Potion field_76423_b = null;
    public static final Potion field_76424_c = (new Potion(1, false, 0x7cafc6)).func_76390_b("potion.moveSpeed").func_76399_b(0, 0);
    public static final Potion field_76421_d = (new Potion(2, true, 0x5a6c81)).func_76390_b("potion.moveSlowdown").func_76399_b(1, 0);
    public static final Potion field_76422_e = (new Potion(3, false, 0xd9c043)).func_76390_b("potion.digSpeed").func_76399_b(2, 0).func_76404_a(1.5D);
    public static final Potion field_76419_f = (new Potion(4, true, 0x4a4217)).func_76390_b("potion.digSlowDown").func_76399_b(3, 0);
    public static final Potion field_76420_g = (new Potion(5, false, 0x932423)).func_76390_b("potion.damageBoost").func_76399_b(4, 0);
    public static final Potion field_76432_h = (new PotionHealth(6, false, 0xf82423)).func_76390_b("potion.heal");
    public static final Potion field_76433_i = (new PotionHealth(7, true, 0x430a09)).func_76390_b("potion.harm");
    public static final Potion field_76430_j = (new Potion(8, false, 0x786297)).func_76390_b("potion.jump").func_76399_b(2, 1);
    public static final Potion field_76431_k = (new Potion(9, true, 0x551d4a)).func_76390_b("potion.confusion").func_76399_b(3, 1).func_76404_a(0.25D);
    public static final Potion field_76428_l = (new Potion(10, false, 0xcd5cab)).func_76390_b("potion.regeneration").func_76399_b(7, 0).func_76404_a(0.25D);
    public static final Potion field_76429_m = (new Potion(11, false, 0x99453a)).func_76390_b("potion.resistance").func_76399_b(6, 1);
    public static final Potion field_76426_n = (new Potion(12, false, 0xe49a3a)).func_76390_b("potion.fireResistance").func_76399_b(7, 1);
    public static final Potion field_76427_o = (new Potion(13, false, 0x2e5299)).func_76390_b("potion.waterBreathing").func_76399_b(0, 2);
    public static final Potion field_76441_p = (new Potion(14, false, 0x7f8392)).func_76390_b("potion.invisibility").func_76399_b(0, 1).func_76391_h();
    public static final Potion field_76440_q = (new Potion(15, true, 0x1f1f23)).func_76390_b("potion.blindness").func_76399_b(5, 1).func_76404_a(0.25D);
    public static final Potion field_76439_r = (new Potion(16, false, 0x1f1fa1)).func_76390_b("potion.nightVision").func_76399_b(4, 1).func_76391_h();
    public static final Potion field_76438_s = (new Potion(17, true, 0x587653)).func_76390_b("potion.hunger").func_76399_b(1, 1);
    public static final Potion field_76437_t = (new Potion(18, true, 0x484d48)).func_76390_b("potion.weakness").func_76399_b(5, 0);
    public static final Potion field_76436_u = (new Potion(19, true, 0x4e9331)).func_76390_b("potion.poison").func_76399_b(6, 0).func_76404_a(0.25D);
    public static final Potion field_76435_v = null;
    public static final Potion field_76434_w = null;
    public static final Potion field_76444_x = null;
    public static final Potion field_76443_y = null;
    public static final Potion field_76442_z = null;
    public static final Potion field_76409_A = null;
    public static final Potion field_76410_B = null;
    public static final Potion field_76411_C = null;
    public static final Potion field_76405_D = null;
    public static final Potion field_76406_E = null;
    public static final Potion field_76407_F = null;
    public static final Potion field_76408_G = null;
    public final int field_76415_H;
    private String field_76416_I;
    private int field_76417_J;
    private final boolean field_76418_K;
    private double field_76412_L;
    private boolean field_76413_M;
    private final int field_76414_N;

    protected Potion(int p_i3433_1_, boolean p_i3433_2_, int p_i3433_3_)
    {
        field_76416_I = "";
        field_76417_J = -1;
        field_76415_H = p_i3433_1_;
        field_76425_a[p_i3433_1_] = this;
        field_76418_K = p_i3433_2_;
        if(p_i3433_2_)
        {
            field_76412_L = 0.5D;
        } else
        {
            field_76412_L = 1.0D;
        }
        field_76414_N = p_i3433_3_;
    }

    protected Potion func_76399_b(int p_76399_1_, int p_76399_2_)
    {
        field_76417_J = p_76399_1_ + p_76399_2_ * 8;
        return this;
    }

    public int func_76396_c()
    {
        return field_76415_H;
    }

    public void func_76394_a(EntityLiving p_76394_1_, int p_76394_2_)
    {
        if(field_76415_H == field_76428_l.field_76415_H)
        {
            if(p_76394_1_.func_70630_aN() < p_76394_1_.func_70667_aM())
            {
                p_76394_1_.func_70691_i(1);
            }
        } else
        if(field_76415_H == field_76436_u.field_76415_H)
        {
            if(p_76394_1_.func_70630_aN() > 1)
            {
                p_76394_1_.func_70097_a(DamageSource.field_76376_m, 1);
            }
        } else
        if(field_76415_H == field_76438_s.field_76415_H && (p_76394_1_ instanceof EntityPlayer))
        {
            ((EntityPlayer)p_76394_1_).func_71020_j(0.025F * (float)(p_76394_2_ + 1));
        } else
        if(field_76415_H == field_76432_h.field_76415_H && !p_76394_1_.func_70662_br() || field_76415_H == field_76433_i.field_76415_H && p_76394_1_.func_70662_br())
        {
            p_76394_1_.func_70691_i(6 << p_76394_2_);
        } else
        if(field_76415_H == field_76433_i.field_76415_H && !p_76394_1_.func_70662_br() || field_76415_H == field_76432_h.field_76415_H && p_76394_1_.func_70662_br())
        {
            p_76394_1_.func_70097_a(DamageSource.field_76376_m, 6 << p_76394_2_);
        }
    }

    public void func_76402_a(EntityLiving p_76402_1_, EntityLiving p_76402_2_, int p_76402_3_, double p_76402_4_)
    {
        if(field_76415_H == field_76432_h.field_76415_H && !p_76402_2_.func_70662_br() || field_76415_H == field_76433_i.field_76415_H && p_76402_2_.func_70662_br())
        {
            int i = (int)(p_76402_4_ * (double)(6 << p_76402_3_) + 0.5D);
            p_76402_2_.func_70691_i(i);
        } else
        if(field_76415_H == field_76433_i.field_76415_H && !p_76402_2_.func_70662_br() || field_76415_H == field_76432_h.field_76415_H && p_76402_2_.func_70662_br())
        {
            int j = (int)(p_76402_4_ * (double)(6 << p_76402_3_) + 0.5D);
            if(p_76402_1_ == null)
            {
                p_76402_2_.func_70097_a(DamageSource.field_76376_m, j);
            } else
            {
                p_76402_2_.func_70097_a(DamageSource.func_76354_b(p_76402_2_, p_76402_1_), j);
            }
        }
    }

    public boolean func_76403_b()
    {
        return false;
    }

    public boolean func_76397_a(int p_76397_1_, int p_76397_2_)
    {
        if(field_76415_H == field_76428_l.field_76415_H || field_76415_H == field_76436_u.field_76415_H)
        {
            int i = 25 >> p_76397_2_;
            if(i > 0)
            {
                return p_76397_1_ % i == 0;
            } else
            {
                return true;
            }
        }
        return field_76415_H == field_76438_s.field_76415_H;
    }

    public Potion func_76390_b(String p_76390_1_)
    {
        field_76416_I = p_76390_1_;
        return this;
    }

    public String func_76393_a()
    {
        return field_76416_I;
    }

    public boolean func_76400_d()
    {
        return field_76417_J >= 0;
    }

    public int func_76392_e()
    {
        return field_76417_J;
    }

    public boolean func_76398_f()
    {
        return field_76418_K;
    }

    public static String func_76389_a(PotionEffect p_76389_0_)
    {
        int i = p_76389_0_.func_76459_b();
        return StringUtils.func_76337_a(i);
    }

    protected Potion func_76404_a(double p_76404_1_)
    {
        field_76412_L = p_76404_1_;
        return this;
    }

    public double func_76388_g()
    {
        return field_76412_L;
    }

    public Potion func_76391_h()
    {
        field_76413_M = true;
        return this;
    }

    public boolean func_76395_i()
    {
        return field_76413_M;
    }

    public int func_76401_j()
    {
        return field_76414_N;
    }

}
