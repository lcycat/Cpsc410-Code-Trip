// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, MouseFilter, Session, StringUtils, 
//            MovementInput, PlayerControllerMP, AchievementList, StatFileWriter, 
//            GuiAchievement, SoundManager, Potion, PotionEffect, 
//            AxisAlignedBB, FoodStats, PlayerCapabilities, ItemStack, 
//            Item, NBTTagCompound, GuiEditSign, GuiScreenBook, 
//            GuiChest, GuiCrafting, GuiEnchantment, GuiFurnace, 
//            GuiBrewingStand, GuiDispenser, GuiMerchant, EntityCrit2FX, 
//            EffectRenderer, EntityPickupFX, DamageSource, GuiIngame, 
//            GuiNewChat, StatBase, Achievement, World, 
//            MathHelper, WorldInfo, TileEntitySign, IInventory, 
//            TileEntityFurnace, TileEntityBrewingStand, TileEntityDispenser, IMerchant, 
//            Entity

public class EntityPlayerSP extends EntityPlayer
{

    public MovementInput field_71158_b;
    protected Minecraft field_71159_c;
    protected int field_71156_d;
    public int field_71157_e;
    public float field_71154_f;
    public float field_71155_g;
    public float field_71163_h;
    public float field_71164_i;
    private MouseFilter field_71162_ch;
    private MouseFilter field_71160_ci;
    private MouseFilter field_71161_cj;

    public EntityPlayerSP(Minecraft p_i3116_1_, World p_i3116_2_, Session p_i3116_3_, int p_i3116_4_)
    {
        super(p_i3116_2_);
        field_71156_d = 0;
        field_71157_e = 0;
        field_71162_ch = new MouseFilter();
        field_71160_ci = new MouseFilter();
        field_71161_cj = new MouseFilter();
        field_71159_c = p_i3116_1_;
        field_71093_bK = p_i3116_4_;
        if(p_i3116_3_ != null && p_i3116_3_.field_74286_b != null && p_i3116_3_.field_74286_b.length() > 0)
        {
            field_70120_cr = (new StringBuilder()).append("http://skins.minecraft.net/MinecraftSkins/").append(StringUtils.func_76338_a(p_i3116_3_.field_74286_b)).append(".png").toString();
        }
        field_71092_bJ = p_i3116_3_.field_74286_b;
    }

    public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_)
    {
        super.func_70091_d(p_70091_1_, p_70091_3_, p_70091_5_);
    }

    public void func_70626_be()
    {
        super.func_70626_be();
        field_70702_br = field_71158_b.field_78902_a;
        field_70701_bs = field_71158_b.field_78900_b;
        field_70703_bu = field_71158_b.field_78901_c;
        field_71163_h = field_71154_f;
        field_71164_i = field_71155_g;
        field_71155_g += (double)(field_70125_A - field_71155_g) * 0.5D;
        field_71154_f += (double)(field_70177_z - field_71154_f) * 0.5D;
    }

    protected boolean func_70613_aW()
    {
        return true;
    }

    public void func_70636_d()
    {
        if(field_71157_e > 0)
        {
            field_71157_e--;
            if(field_71157_e == 0)
            {
                func_70031_b(false);
            }
        }
        if(field_71156_d > 0)
        {
            field_71156_d--;
        }
        if(field_71159_c.field_71442_b.func_78747_a())
        {
            field_70165_t = field_70161_v = 0.5D;
            field_70165_t = 0.0D;
            field_70161_v = 0.0D;
            field_70177_z = (float)field_70173_aa / 12F;
            field_70125_A = 10F;
            field_70163_u = 68.5D;
            return;
        }
        if(!field_71159_c.field_71413_E.func_77443_a(AchievementList.field_76004_f))
        {
            field_71159_c.field_71458_u.func_73848_b(AchievementList.field_76004_f);
        }
        field_71080_cy = field_71086_bY;
        if(field_71087_bX)
        {
            if(field_71159_c.field_71462_r != null)
            {
                field_71159_c.func_71373_a(null);
            }
            if(field_71086_bY == 0.0F)
            {
                field_71159_c.field_71416_A.func_77366_a("portal.trigger", 1.0F, field_70146_Z.nextFloat() * 0.4F + 0.8F);
            }
            field_71086_bY += 0.0125F;
            if(field_71086_bY >= 1.0F)
            {
                field_71086_bY = 1.0F;
            }
            field_71087_bX = false;
        } else
        if(func_70644_a(Potion.field_76431_k) && func_70660_b(Potion.field_76431_k).func_76459_b() > 60)
        {
            field_71086_bY += 0.006666667F;
            if(field_71086_bY > 1.0F)
            {
                field_71086_bY = 1.0F;
            }
        } else
        {
            if(field_71086_bY > 0.0F)
            {
                field_71086_bY -= 0.05F;
            }
            if(field_71086_bY < 0.0F)
            {
                field_71086_bY = 0.0F;
            }
        }
        if(field_71088_bW > 0)
        {
            field_71088_bW--;
        }
        boolean flag = field_71158_b.field_78901_c;
        float f = 0.8F;
        boolean flag1 = field_71158_b.field_78900_b >= f;
        field_71158_b.func_78898_a();
        if(func_71039_bw())
        {
            field_71158_b.field_78902_a *= 0.2F;
            field_71158_b.field_78900_b *= 0.2F;
            field_71156_d = 0;
        }
        if(field_71158_b.field_78899_d && field_70139_V < 0.2F)
        {
            field_70139_V = 0.2F;
        }
        func_70048_i(field_70165_t - (double)field_70130_N * 0.34999999999999998D, field_70121_D.field_72338_b + 0.5D, field_70161_v + (double)field_70130_N * 0.34999999999999998D);
        func_70048_i(field_70165_t - (double)field_70130_N * 0.34999999999999998D, field_70121_D.field_72338_b + 0.5D, field_70161_v - (double)field_70130_N * 0.34999999999999998D);
        func_70048_i(field_70165_t + (double)field_70130_N * 0.34999999999999998D, field_70121_D.field_72338_b + 0.5D, field_70161_v - (double)field_70130_N * 0.34999999999999998D);
        func_70048_i(field_70165_t + (double)field_70130_N * 0.34999999999999998D, field_70121_D.field_72338_b + 0.5D, field_70161_v + (double)field_70130_N * 0.34999999999999998D);
        boolean flag2 = (float)func_71024_bL().func_75116_a() > 6F || field_71075_bZ.field_75101_c;
        if(field_70122_E && !flag1 && field_71158_b.field_78900_b >= f && !func_70051_ag() && flag2 && !func_71039_bw() && !func_70644_a(Potion.field_76440_q))
        {
            if(field_71156_d == 0)
            {
                field_71156_d = 7;
            } else
            {
                func_70031_b(true);
                field_71156_d = 0;
            }
        }
        if(func_70093_af())
        {
            field_71156_d = 0;
        }
        if(func_70051_ag() && (field_71158_b.field_78900_b < f || field_70123_F || !flag2))
        {
            func_70031_b(false);
        }
        if(field_71075_bZ.field_75101_c && !flag && field_71158_b.field_78901_c)
        {
            if(field_71101_bC == 0)
            {
                field_71101_bC = 7;
            } else
            {
                field_71075_bZ.field_75100_b = !field_71075_bZ.field_75100_b;
                func_71016_p();
                field_71101_bC = 0;
            }
        }
        if(field_71075_bZ.field_75100_b)
        {
            if(field_71158_b.field_78899_d)
            {
                field_70181_x -= 0.14999999999999999D;
            }
            if(field_71158_b.field_78901_c)
            {
                field_70181_x += 0.14999999999999999D;
            }
        }
        super.func_70636_d();
        if(field_70122_E && field_71075_bZ.field_75100_b)
        {
            field_71075_bZ.field_75100_b = false;
            func_71016_p();
        }
    }

    public float func_71151_f()
    {
        float f = 1.0F;
        if(field_71075_bZ.field_75100_b)
        {
            f *= 1.1F;
        }
        f *= ((field_70746_aG * func_70616_bs()) / field_71108_cd + 1.0F) / 2.0F;
        if(func_71039_bw() && func_71011_bu().field_77993_c == Item.field_77707_k.field_77779_bT)
        {
            int i = func_71057_bx();
            float f1 = (float)i / 20F;
            if(f1 > 1.0F)
            {
                f1 = 1.0F;
            } else
            {
                f1 *= f1;
            }
            f *= 1.0F - f1 * 0.15F;
        }
        return f;
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74768_a("Score", field_71099_bE);
    }

    public void func_70059_ac()
    {
        field_71084_cw = (new StringBuilder()).append("http://skins.minecraft.net/MinecraftCloaks/").append(StringUtils.func_76338_a(field_71092_bJ)).append(".png").toString();
        field_70119_cs = field_71084_cw;
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        field_71099_bE = p_70037_1_.func_74762_e("Score");
    }

    public void func_71053_j()
    {
        super.func_71053_j();
        field_71159_c.func_71373_a(null);
    }

    public void func_71014_a(TileEntitySign p_71014_1_)
    {
        field_71159_c.func_71373_a(new GuiEditSign(p_71014_1_));
    }

    public void func_71048_c(ItemStack p_71048_1_)
    {
        Item item = p_71048_1_.func_77973_b();
        if(item == Item.field_77823_bG)
        {
            field_71159_c.func_71373_a(new GuiScreenBook(this, p_71048_1_, false));
        } else
        if(item == Item.field_77821_bF)
        {
            field_71159_c.func_71373_a(new GuiScreenBook(this, p_71048_1_, true));
        }
    }

    public void func_71007_a(IInventory p_71007_1_)
    {
        field_71159_c.func_71373_a(new GuiChest(field_71071_by, p_71007_1_));
    }

    public void func_71058_b(int p_71058_1_, int p_71058_2_, int p_71058_3_)
    {
        field_71159_c.func_71373_a(new GuiCrafting(field_71071_by, field_70170_p, p_71058_1_, p_71058_2_, p_71058_3_));
    }

    public void func_71002_c(int p_71002_1_, int p_71002_2_, int p_71002_3_)
    {
        field_71159_c.func_71373_a(new GuiEnchantment(field_71071_by, field_70170_p, p_71002_1_, p_71002_2_, p_71002_3_));
    }

    public void func_71042_a(TileEntityFurnace p_71042_1_)
    {
        field_71159_c.func_71373_a(new GuiFurnace(field_71071_by, p_71042_1_));
    }

    public void func_71017_a(TileEntityBrewingStand p_71017_1_)
    {
        field_71159_c.func_71373_a(new GuiBrewingStand(field_71071_by, p_71017_1_));
    }

    public void func_71006_a(TileEntityDispenser p_71006_1_)
    {
        field_71159_c.func_71373_a(new GuiDispenser(field_71071_by, p_71006_1_));
    }

    public void func_71030_a(IMerchant p_71030_1_)
    {
        field_71159_c.func_71373_a(new GuiMerchant(field_71071_by, p_71030_1_, field_70170_p));
    }

    public void func_71009_b(Entity p_71009_1_)
    {
        field_71159_c.field_71452_i.func_78873_a(new EntityCrit2FX(field_71159_c.field_71441_e, p_71009_1_));
    }

    public void func_71047_c(Entity p_71047_1_)
    {
        EntityCrit2FX entitycrit2fx = new EntityCrit2FX(field_71159_c.field_71441_e, p_71047_1_, "magicCrit");
        field_71159_c.field_71452_i.func_78873_a(entitycrit2fx);
    }

    public void func_71001_a(Entity p_71001_1_, int p_71001_2_)
    {
        field_71159_c.field_71452_i.func_78873_a(new EntityPickupFX(field_71159_c.field_71441_e, p_71001_1_, this, -0.5F));
    }

    public boolean func_70093_af()
    {
        return field_71158_b.field_78899_d && !field_71083_bS;
    }

    public void func_71150_b(int p_71150_1_)
    {
        int i = func_70630_aN() - p_71150_1_;
        if(i <= 0)
        {
            func_70606_j(p_71150_1_);
            if(i < 0)
            {
                field_70172_ad = field_70771_an / 2;
            }
        } else
        {
            field_70707_bp = i;
            func_70606_j(func_70630_aN());
            field_70172_ad = field_70771_an;
            func_70665_d(DamageSource.field_76377_j, i);
            field_70737_aN = field_70738_aO = 10;
        }
    }

    public void func_71035_c(String p_71035_1_)
    {
        field_71159_c.field_71456_v.func_73827_b().func_73757_a(p_71035_1_, new Object[0]);
    }

    public void func_71064_a(StatBase p_71064_1_, int p_71064_2_)
    {
        if(p_71064_1_ == null)
        {
            return;
        }
        if(p_71064_1_.func_75967_d())
        {
            Achievement achievement = (Achievement)p_71064_1_;
            if(achievement.field_75992_c == null || field_71159_c.field_71413_E.func_77443_a(achievement.field_75992_c))
            {
                if(!field_71159_c.field_71413_E.func_77443_a(achievement))
                {
                    field_71159_c.field_71458_u.func_73846_a(achievement);
                }
                field_71159_c.field_71413_E.func_77450_a(p_71064_1_, p_71064_2_);
            }
        } else
        {
            field_71159_c.field_71413_E.func_77450_a(p_71064_1_, p_71064_2_);
        }
    }

    private boolean func_71153_f(int p_71153_1_, int p_71153_2_, int p_71153_3_)
    {
        return field_70170_p.func_72809_s(p_71153_1_, p_71153_2_, p_71153_3_);
    }

    protected boolean func_70048_i(double p_70048_1_, double p_70048_3_, double p_70048_5_)
    {
        int i = MathHelper.func_76128_c(p_70048_1_);
        int j = MathHelper.func_76128_c(p_70048_3_);
        int k = MathHelper.func_76128_c(p_70048_5_);
        double d = p_70048_1_ - (double)i;
        double d1 = p_70048_5_ - (double)k;
        if(func_71153_f(i, j, k) || func_71153_f(i, j + 1, k))
        {
            boolean flag = !func_71153_f(i - 1, j, k) && !func_71153_f(i - 1, j + 1, k);
            boolean flag1 = !func_71153_f(i + 1, j, k) && !func_71153_f(i + 1, j + 1, k);
            boolean flag2 = !func_71153_f(i, j, k - 1) && !func_71153_f(i, j + 1, k - 1);
            boolean flag3 = !func_71153_f(i, j, k + 1) && !func_71153_f(i, j + 1, k + 1);
            byte byte0 = -1;
            double d2 = 9999D;
            if(flag && d < d2)
            {
                d2 = d;
                byte0 = 0;
            }
            if(flag1 && 1.0D - d < d2)
            {
                d2 = 1.0D - d;
                byte0 = 1;
            }
            if(flag2 && d1 < d2)
            {
                d2 = d1;
                byte0 = 4;
            }
            if(flag3 && 1.0D - d1 < d2)
            {
                double d3 = 1.0D - d1;
                byte0 = 5;
            }
            float f = 0.1F;
            if(byte0 == 0)
            {
                field_70159_w = -f;
            }
            if(byte0 == 1)
            {
                field_70159_w = f;
            }
            if(byte0 == 4)
            {
                field_70179_y = -f;
            }
            if(byte0 == 5)
            {
                field_70179_y = f;
            }
        }
        return false;
    }

    public void func_70031_b(boolean p_70031_1_)
    {
        super.func_70031_b(p_70031_1_);
        field_71157_e = p_70031_1_ ? 600 : 0;
    }

    public void func_71152_a(float p_71152_1_, int p_71152_2_, int p_71152_3_)
    {
        field_71106_cc = p_71152_1_;
        field_71067_cb = p_71152_2_;
        field_71068_ca = p_71152_3_;
    }

    public void func_70006_a(String p_70006_1_)
    {
        field_71159_c.field_71456_v.func_73827_b().func_73765_a(p_70006_1_);
    }

    public boolean func_70003_b(String p_70003_1_)
    {
        return field_70170_p.func_72912_H().func_76086_u();
    }
}
