// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, Material, World, MathHelper, 
//            BlockFluid

public class EntityDropParticleFX extends EntityFX
{

    private Material field_70563_a;
    private int field_70564_aq;

    public EntityDropParticleFX(World p_i3151_1_, double p_i3151_2_, double p_i3151_4_, double p_i3151_6_, 
            Material p_i3151_8_)
    {
        super(p_i3151_1_, p_i3151_2_, p_i3151_4_, p_i3151_6_, 0.0D, 0.0D, 0.0D);
        field_70159_w = field_70181_x = field_70179_y = 0.0D;
        if(p_i3151_8_ == Material.field_76244_g)
        {
            field_70552_h = 0.0F;
            field_70553_i = 0.0F;
            field_70551_j = 1.0F;
        } else
        {
            field_70552_h = 1.0F;
            field_70553_i = 0.0F;
            field_70551_j = 0.0F;
        }
        func_70536_a(113);
        func_70105_a(0.01F, 0.01F);
        field_70545_g = 0.06F;
        field_70563_a = p_i3151_8_;
        field_70564_aq = 40;
        field_70547_e = (int)(64D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
        field_70159_w = field_70181_x = field_70179_y = 0.0D;
    }

    public int func_70070_b(float p_70070_1_)
    {
        if(field_70563_a == Material.field_76244_g)
        {
            return super.func_70070_b(p_70070_1_);
        } else
        {
            return 257;
        }
    }

    public float func_70013_c(float p_70013_1_)
    {
        if(field_70563_a == Material.field_76244_g)
        {
            return super.func_70013_c(p_70013_1_);
        } else
        {
            return 1.0F;
        }
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        if(field_70563_a == Material.field_76244_g)
        {
            field_70552_h = 0.2F;
            field_70553_i = 0.3F;
            field_70551_j = 1.0F;
        } else
        {
            field_70552_h = 1.0F;
            field_70553_i = 16F / (float)((40 - field_70564_aq) + 16);
            field_70551_j = 4F / (float)((40 - field_70564_aq) + 8);
        }
        field_70181_x -= field_70545_g;
        if(field_70564_aq-- > 0)
        {
            field_70159_w *= 0.02D;
            field_70181_x *= 0.02D;
            field_70179_y *= 0.02D;
            func_70536_a(113);
        } else
        {
            func_70536_a(112);
        }
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.98000001907348633D;
        field_70181_x *= 0.98000001907348633D;
        field_70179_y *= 0.98000001907348633D;
        if(field_70547_e-- <= 0)
        {
            func_70106_y();
        }
        if(field_70122_E)
        {
            if(field_70563_a == Material.field_76244_g)
            {
                func_70106_y();
                field_70170_p.func_72869_a("splash", field_70165_t, field_70163_u, field_70161_v, 0.0D, 0.0D, 0.0D);
            } else
            {
                func_70536_a(114);
            }
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
        Material material = field_70170_p.func_72803_f(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v));
        if(material.func_76224_d() || material.func_76220_a())
        {
            double d = (float)(MathHelper.func_76128_c(field_70163_u) + 1) - BlockFluid.func_72199_d(field_70170_p.func_72805_g(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v)));
            if(field_70163_u < d)
            {
                func_70106_y();
            }
        }
    }
}
