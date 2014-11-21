// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, MathHelper, World, Material, 
//            AxisAlignedBB, EntityPlayer, Block, DamageSource, 
//            NBTTagCompound

public class EntityXPOrb extends Entity
{

    public int field_70533_a;
    public int field_70531_b;
    public int field_70532_c;
    private int field_70529_d;
    private int field_70530_e;

    public EntityXPOrb(World p_i3440_1_, double p_i3440_2_, double p_i3440_4_, double p_i3440_6_, 
            int p_i3440_8_)
    {
        super(p_i3440_1_);
        field_70531_b = 0;
        field_70529_d = 5;
        func_70105_a(0.5F, 0.5F);
        field_70129_M = field_70131_O / 2.0F;
        func_70107_b(p_i3440_2_, p_i3440_4_, p_i3440_6_);
        field_70177_z = (float)(Math.random() * 360D);
        field_70159_w = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F;
        field_70181_x = (float)(Math.random() * 0.20000000000000001D) * 2.0F;
        field_70179_y = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F;
        field_70530_e = p_i3440_8_;
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    public EntityXPOrb(World p_i3441_1_)
    {
        super(p_i3441_1_);
        field_70531_b = 0;
        field_70529_d = 5;
        func_70105_a(0.25F, 0.25F);
        field_70129_M = field_70131_O / 2.0F;
    }

    protected void func_70088_a()
    {
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();
        if(field_70532_c > 0)
        {
            field_70532_c--;
        }
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70181_x -= 0.029999999329447746D;
        if(field_70170_p.func_72803_f(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v)) == Material.field_76256_h)
        {
            field_70181_x = 0.20000000298023224D;
            field_70159_w = (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F;
            field_70179_y = (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F;
            field_70170_p.func_72956_a(this, "random.fizz", 0.4F, 2.0F + field_70146_Z.nextFloat() * 0.4F);
        }
        func_70048_i(field_70165_t, (field_70121_D.field_72338_b + field_70121_D.field_72337_e) / 2D, field_70161_v);
        double d = 8D;
        EntityPlayer entityplayer = field_70170_p.func_72890_a(this, d);
        if(entityplayer != null)
        {
            double d1 = (entityplayer.field_70165_t - field_70165_t) / d;
            double d2 = ((entityplayer.field_70163_u + (double)entityplayer.func_70047_e()) - field_70163_u) / d;
            double d3 = (entityplayer.field_70161_v - field_70161_v) / d;
            double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
            double d5 = 1.0D - d4;
            if(d5 > 0.0D)
            {
                d5 *= d5;
                field_70159_w += (d1 / d4) * d5 * 0.10000000000000001D;
                field_70181_x += (d2 / d4) * d5 * 0.10000000000000001D;
                field_70179_y += (d3 / d4) * d5 * 0.10000000000000001D;
            }
        }
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        float f = 0.98F;
        if(field_70122_E)
        {
            f = 0.5880001F;
            int i = field_70170_p.func_72798_a(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(field_70161_v));
            if(i > 0)
            {
                f = Block.field_71973_m[i].field_72016_cq * 0.98F;
            }
        }
        field_70159_w *= f;
        field_70181_x *= 0.98000001907348633D;
        field_70179_y *= f;
        if(field_70122_E)
        {
            field_70181_x *= -0.89999997615814209D;
        }
        field_70533_a++;
        field_70531_b++;
        if(field_70531_b >= 6000)
        {
            func_70106_y();
        }
    }

    public boolean func_70072_I()
    {
        return field_70170_p.func_72918_a(field_70121_D, Material.field_76244_g, this);
    }

    protected void func_70081_e(int p_70081_1_)
    {
        func_70097_a(DamageSource.field_76372_a, p_70081_1_);
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        func_70018_K();
        field_70529_d -= p_70097_2_;
        if(field_70529_d <= 0)
        {
            func_70106_y();
        }
        return false;
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74777_a("Health", (byte)field_70529_d);
        p_70014_1_.func_74777_a("Age", (short)field_70531_b);
        p_70014_1_.func_74777_a("Value", (short)field_70530_e);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70529_d = p_70037_1_.func_74765_d("Health") & 0xff;
        field_70531_b = p_70037_1_.func_74765_d("Age");
        field_70530_e = p_70037_1_.func_74765_d("Value");
    }

    public void func_70100_b_(EntityPlayer p_70100_1_)
    {
        if(field_70170_p.field_72995_K)
        {
            return;
        }
        if(field_70532_c == 0 && p_70100_1_.field_71090_bL == 0)
        {
            p_70100_1_.field_71090_bL = 2;
            field_70170_p.func_72956_a(this, "random.orb", 0.1F, 0.5F * ((field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.7F + 1.8F));
            p_70100_1_.func_71001_a(this, 1);
            p_70100_1_.func_71023_q(field_70530_e);
            func_70106_y();
        }
    }

    public int func_70526_d()
    {
        return field_70530_e;
    }

    public static int func_70527_a(int p_70527_0_)
    {
        if(p_70527_0_ >= 2477)
        {
            return 2477;
        }
        if(p_70527_0_ >= 1237)
        {
            return 1237;
        }
        if(p_70527_0_ >= 617)
        {
            return 617;
        }
        if(p_70527_0_ >= 307)
        {
            return 307;
        }
        if(p_70527_0_ >= 149)
        {
            return 149;
        }
        if(p_70527_0_ >= 73)
        {
            return 73;
        }
        if(p_70527_0_ >= 37)
        {
            return 37;
        }
        if(p_70527_0_ >= 17)
        {
            return 17;
        }
        if(p_70527_0_ >= 7)
        {
            return 7;
        }
        return p_70527_0_ < 3 ? 1 : 3;
    }

    public boolean func_70075_an()
    {
        return false;
    }
}
