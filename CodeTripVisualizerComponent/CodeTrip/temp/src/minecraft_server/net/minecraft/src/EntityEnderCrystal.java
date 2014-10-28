// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, DataWatcher, MathHelper, World, 
//            Block, BlockFire, NBTTagCompound, DamageSource

public class EntityEnderCrystal extends Entity
{

    public int field_70261_a;
    public int field_70260_b;

    public EntityEnderCrystal(World p_i3529_1_)
    {
        super(p_i3529_1_);
        field_70261_a = 0;
        field_70156_m = true;
        func_70105_a(2.0F, 2.0F);
        field_70129_M = field_70131_O / 2.0F;
        field_70260_b = 5;
        field_70261_a = field_70146_Z.nextInt(0x186a0);
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    protected void func_70088_a()
    {
        field_70180_af.func_75682_a(8, Integer.valueOf(field_70260_b));
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70261_a++;
        field_70180_af.func_75692_b(8, Integer.valueOf(field_70260_b));
        int i = MathHelper.func_76128_c(field_70165_t);
        int j = MathHelper.func_76128_c(field_70163_u);
        int k = MathHelper.func_76128_c(field_70161_v);
        if(field_70170_p.func_72798_a(i, j, k) != Block.field_72067_ar.field_71990_ca)
        {
            field_70170_p.func_72859_e(i, j, k, Block.field_72067_ar.field_71990_ca);
        }
    }

    protected void func_70014_b(NBTTagCompound nbttagcompound)
    {
    }

    protected void func_70037_a(NBTTagCompound nbttagcompound)
    {
    }

    public boolean func_70067_L()
    {
        return true;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_)
    {
        if(!field_70128_L && !field_70170_p.field_72995_K)
        {
            field_70260_b = 0;
            if(field_70260_b <= 0)
            {
                func_70106_y();
                if(!field_70170_p.field_72995_K)
                {
                    field_70170_p.func_72876_a(null, field_70165_t, field_70163_u, field_70161_v, 6F);
                }
            }
        }
        return true;
    }
}
