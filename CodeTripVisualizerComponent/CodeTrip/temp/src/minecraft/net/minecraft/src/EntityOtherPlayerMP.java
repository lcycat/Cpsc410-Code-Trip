// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, StringUtils, MathHelper, InventoryPlayer, 
//            Item, ItemStack, GuiIngame, GuiNewChat, 
//            World, DamageSource

public class EntityOtherPlayerMP extends EntityPlayer
{

    private boolean field_71186_a;
    private int field_71184_b;
    private double field_71185_c;
    private double field_71182_d;
    private double field_71183_e;
    private double field_71180_f;
    private double field_71181_g;

    public EntityOtherPlayerMP(World p_i3117_1_, String p_i3117_2_)
    {
        super(p_i3117_1_);
        field_71186_a = false;
        field_71092_bJ = p_i3117_2_;
        field_70129_M = 0.0F;
        field_70138_W = 0.0F;
        if(p_i3117_2_ != null && p_i3117_2_.length() > 0)
        {
            field_70120_cr = (new StringBuilder()).append("http://skins.minecraft.net/MinecraftSkins/").append(StringUtils.func_76338_a(p_i3117_2_)).append(".png").toString();
        }
        field_70145_X = true;
        field_71082_cx = 0.25F;
        field_70155_l = 10D;
    }

    protected void func_71061_d_()
    {
        field_70129_M = 0.0F;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        return true;
    }

    public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, 
            float p_70056_8_, int p_70056_9_)
    {
        field_71185_c = p_70056_1_;
        field_71182_d = p_70056_3_;
        field_71183_e = p_70056_5_;
        field_71180_f = p_70056_7_;
        field_71181_g = p_70056_8_;
        field_71184_b = p_70056_9_;
    }

    public void func_70059_ac()
    {
        field_71084_cw = (new StringBuilder()).append("http://skins.minecraft.net/MinecraftCloaks/").append(StringUtils.func_76338_a(field_71092_bJ)).append(".png").toString();
        field_70119_cs = field_71084_cw;
    }

    public void func_70071_h_()
    {
        field_71082_cx = 0.0F;
        super.func_70071_h_();
        field_70722_aY = field_70721_aZ;
        double d = field_70165_t - field_70169_q;
        double d1 = field_70161_v - field_70166_s;
        float f = MathHelper.func_76133_a(d * d + d1 * d1) * 4F;
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        field_70721_aZ += (f - field_70721_aZ) * 0.4F;
        field_70754_ba += field_70721_aZ;
        if(!field_71186_a && func_70113_ah() && field_71071_by.field_70462_a[field_71071_by.field_70461_c] != null)
        {
            ItemStack itemstack = field_71071_by.field_70462_a[field_71071_by.field_70461_c];
            func_71008_a(field_71071_by.field_70462_a[field_71071_by.field_70461_c], Item.field_77698_e[itemstack.field_77993_c].func_77626_a(itemstack));
            field_71186_a = true;
        } else
        if(field_71186_a && !func_70113_ah())
        {
            func_71041_bz();
            field_71186_a = false;
        }
    }

    public float func_70053_R()
    {
        return 0.0F;
    }

    public void func_70636_d()
    {
        super.func_70626_be();
        if(field_71184_b > 0)
        {
            double d = field_70165_t + (field_71185_c - field_70165_t) / (double)field_71184_b;
            double d1 = field_70163_u + (field_71182_d - field_70163_u) / (double)field_71184_b;
            double d2 = field_70161_v + (field_71183_e - field_70161_v) / (double)field_71184_b;
            double d3;
            for(d3 = field_71180_f - (double)field_70177_z; d3 < -180D; d3 += 360D) { }
            for(; d3 >= 180D; d3 -= 360D) { }
            field_70177_z += d3 / (double)field_71184_b;
            field_70125_A += (field_71181_g - (double)field_70125_A) / (double)field_71184_b;
            field_71184_b--;
            func_70107_b(d, d1, d2);
            func_70101_b(field_70177_z, field_70125_A);
        }
        field_71107_bF = field_71109_bG;
        float f = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70179_y * field_70179_y);
        float f1 = (float)Math.atan(-field_70181_x * 0.20000000298023224D) * 15F;
        if(f > 0.1F)
        {
            f = 0.1F;
        }
        if(!field_70122_E || func_70630_aN() <= 0)
        {
            f = 0.0F;
        }
        if(field_70122_E || func_70630_aN() <= 0)
        {
            f1 = 0.0F;
        }
        field_71109_bG += (f - field_71109_bG) * 0.4F;
        field_70726_aT += (f1 - field_70726_aT) * 0.8F;
    }

    public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_)
    {
        if(p_70062_1_ == 0)
        {
            field_71071_by.field_70462_a[field_71071_by.field_70461_c] = p_70062_2_;
        } else
        {
            field_71071_by.field_70460_b[p_70062_1_ - 1] = p_70062_2_;
        }
    }

    public float func_70047_e()
    {
        return 1.82F;
    }

    public void func_70006_a(String p_70006_1_)
    {
        Minecraft.func_71410_x().field_71456_v.func_73827_b().func_73765_a(p_70006_1_);
    }

    public boolean func_70003_b(String p_70003_1_)
    {
        return false;
    }
}
