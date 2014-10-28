// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayerSP, MathHelper, World, Packet19EntityAction, 
//            NetClientHandler, AxisAlignedBB, Packet11PlayerPosition, Packet13PlayerLookMove, 
//            Packet12PlayerLook, Packet10Flying, Packet14BlockDig, Packet3Chat, 
//            Packet18Animation, Packet205ClientCommand, Packet101CloseWindow, Container, 
//            InventoryPlayer, StatBase, Packet202PlayerAbilities, Session, 
//            DamageSource, EntityItem

public class EntityClientPlayerMP extends EntityPlayerSP
{

    public NetClientHandler field_71174_a;
    private double field_71179_j;
    private double field_71177_cg;
    private double field_71178_ch;
    private double field_71175_ci;
    private float field_71176_cj;
    private float field_71172_ck;
    private boolean field_71173_cl;
    private boolean field_71170_cm;
    private boolean field_71171_cn;
    private int field_71168_co;
    private boolean field_71169_cp;

    public EntityClientPlayerMP(Minecraft p_i3101_1_, World p_i3101_2_, Session p_i3101_3_, NetClientHandler p_i3101_4_)
    {
        super(p_i3101_1_, p_i3101_2_, p_i3101_3_, 0);
        field_71173_cl = false;
        field_71170_cm = false;
        field_71171_cn = false;
        field_71168_co = 0;
        field_71169_cp = false;
        field_71174_a = p_i3101_4_;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        return false;
    }

    public void func_70691_i(int i)
    {
    }

    public void func_70071_h_()
    {
        if(!field_70170_p.func_72899_e(MathHelper.func_76128_c(field_70165_t), 0, MathHelper.func_76128_c(field_70161_v)))
        {
            return;
        } else
        {
            super.func_70071_h_();
            func_71166_b();
            return;
        }
    }

    public void func_71166_b()
    {
        boolean flag = func_70051_ag();
        if(flag != field_71171_cn)
        {
            if(flag)
            {
                field_71174_a.func_72552_c(new Packet19EntityAction(this, 4));
            } else
            {
                field_71174_a.func_72552_c(new Packet19EntityAction(this, 5));
            }
            field_71171_cn = flag;
        }
        boolean flag1 = func_70093_af();
        if(flag1 != field_71170_cm)
        {
            if(flag1)
            {
                field_71174_a.func_72552_c(new Packet19EntityAction(this, 1));
            } else
            {
                field_71174_a.func_72552_c(new Packet19EntityAction(this, 2));
            }
            field_71170_cm = flag1;
        }
        double d = field_70165_t - field_71179_j;
        double d1 = field_70121_D.field_72338_b - field_71177_cg;
        double d2 = field_70161_v - field_71175_ci;
        double d3 = field_70177_z - field_71176_cj;
        double d4 = field_70125_A - field_71172_ck;
        boolean flag2 = d * d + d1 * d1 + d2 * d2 > 0.00089999999999999998D || field_71168_co >= 20;
        boolean flag3 = d3 != 0.0D || d4 != 0.0D;
        if(field_70154_o != null)
        {
            if(flag3)
            {
                field_71174_a.func_72552_c(new Packet11PlayerPosition(field_70159_w, -999D, -999D, field_70179_y, field_70122_E));
            } else
            {
                field_71174_a.func_72552_c(new Packet13PlayerLookMove(field_70159_w, -999D, -999D, field_70179_y, field_70177_z, field_70125_A, field_70122_E));
            }
            flag2 = false;
        } else
        if(flag2 && flag3)
        {
            field_71174_a.func_72552_c(new Packet13PlayerLookMove(field_70165_t, field_70121_D.field_72338_b, field_70163_u, field_70161_v, field_70177_z, field_70125_A, field_70122_E));
        } else
        if(flag2)
        {
            field_71174_a.func_72552_c(new Packet11PlayerPosition(field_70165_t, field_70121_D.field_72338_b, field_70163_u, field_70161_v, field_70122_E));
        } else
        if(flag3)
        {
            field_71174_a.func_72552_c(new Packet12PlayerLook(field_70177_z, field_70125_A, field_70122_E));
        } else
        if(field_71173_cl != field_70122_E)
        {
            field_71174_a.func_72552_c(new Packet10Flying(field_70122_E));
        }
        field_71168_co++;
        field_71173_cl = field_70122_E;
        if(flag2)
        {
            field_71179_j = field_70165_t;
            field_71177_cg = field_70121_D.field_72338_b;
            field_71178_ch = field_70163_u;
            field_71175_ci = field_70161_v;
            field_71168_co = 0;
        }
        if(flag3)
        {
            field_71176_cj = field_70177_z;
            field_71172_ck = field_70125_A;
        }
    }

    public EntityItem func_71040_bB()
    {
        field_71174_a.func_72552_c(new Packet14BlockDig(4, 0, 0, 0, 0));
        return null;
    }

    protected void func_71012_a(EntityItem entityitem)
    {
    }

    public void func_71165_d(String p_71165_1_)
    {
        field_71174_a.func_72552_c(new Packet3Chat(p_71165_1_));
    }

    public void func_71038_i()
    {
        super.func_71038_i();
        field_71174_a.func_72552_c(new Packet18Animation(this, 1));
    }

    public void func_71004_bE()
    {
        field_71174_a.func_72552_c(new Packet205ClientCommand(1));
    }

    protected void func_70665_d(DamageSource p_70665_1_, int p_70665_2_)
    {
        func_70606_j(func_70630_aN() - p_70665_2_);
    }

    public void func_71053_j()
    {
        field_71174_a.func_72552_c(new Packet101CloseWindow(field_71070_bA.field_75152_c));
        field_71071_by.func_70437_b(null);
        super.func_71053_j();
    }

    public void func_71150_b(int p_71150_1_)
    {
        if(field_71169_cp)
        {
            super.func_71150_b(p_71150_1_);
        } else
        {
            func_70606_j(p_71150_1_);
            field_71169_cp = true;
        }
    }

    public void func_71064_a(StatBase p_71064_1_, int p_71064_2_)
    {
        if(p_71064_1_ == null)
        {
            return;
        }
        if(p_71064_1_.field_75972_f)
        {
            super.func_71064_a(p_71064_1_, p_71064_2_);
        }
    }

    public void func_71167_b(StatBase p_71167_1_, int p_71167_2_)
    {
        if(p_71167_1_ == null)
        {
            return;
        }
        if(!p_71167_1_.field_75972_f)
        {
            super.func_71064_a(p_71167_1_, p_71167_2_);
        }
    }

    public void func_71016_p()
    {
        field_71174_a.func_72552_c(new Packet202PlayerAbilities(field_71075_bZ));
    }

    public boolean func_71066_bF()
    {
        return true;
    }
}
