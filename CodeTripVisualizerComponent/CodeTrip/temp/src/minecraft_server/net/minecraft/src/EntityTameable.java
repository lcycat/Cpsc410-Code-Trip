// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, EntityAISit, DataWatcher, NBTTagCompound, 
//            World, EntityLiving

public abstract class EntityTameable extends EntityAnimal
{

    protected EntityAISit field_70911_d;

    public EntityTameable(World p_i3452_1_)
    {
        super(p_i3452_1_);
        field_70911_d = new EntityAISit(this);
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
        field_70180_af.func_75682_a(17, "");
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        if(func_70905_p() == null)
        {
            p_70014_1_.func_74778_a("Owner", "");
        } else
        {
            p_70014_1_.func_74778_a("Owner", func_70905_p());
        }
        p_70014_1_.func_74757_a("Sitting", func_70906_o());
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        String s = p_70037_1_.func_74779_i("Owner");
        if(s.length() > 0)
        {
            func_70910_a(s);
            func_70903_f(true);
        }
        field_70911_d.func_75270_a(p_70037_1_.func_74767_n("Sitting"));
    }

    protected void func_70908_e(boolean p_70908_1_)
    {
        String s = "heart";
        if(!p_70908_1_)
        {
            s = "smoke";
        }
        for(int i = 0; i < 7; i++)
        {
            double d = field_70146_Z.nextGaussian() * 0.02D;
            double d1 = field_70146_Z.nextGaussian() * 0.02D;
            double d2 = field_70146_Z.nextGaussian() * 0.02D;
            field_70170_p.func_72869_a(s, (field_70165_t + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, field_70163_u + 0.5D + (double)(field_70146_Z.nextFloat() * field_70131_O), (field_70161_v + (double)(field_70146_Z.nextFloat() * field_70130_N * 2.0F)) - (double)field_70130_N, d, d1, d2);
        }

    }

    public boolean func_70909_n()
    {
        return (field_70180_af.func_75683_a(16) & 4) != 0;
    }

    public void func_70903_f(boolean p_70903_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        if(p_70903_1_)
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 | 4)));
        } else
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 & -5)));
        }
    }

    public boolean func_70906_o()
    {
        return (field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void func_70904_g(boolean p_70904_1_)
    {
        byte byte0 = field_70180_af.func_75683_a(16);
        if(p_70904_1_)
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 | 1)));
        } else
        {
            field_70180_af.func_75692_b(16, Byte.valueOf((byte)(byte0 & -2)));
        }
    }

    public String func_70905_p()
    {
        return field_70180_af.func_75681_e(17);
    }

    public void func_70910_a(String p_70910_1_)
    {
        field_70180_af.func_75692_b(17, p_70910_1_);
    }

    public EntityLiving func_70902_q()
    {
        return field_70170_p.func_72924_a(func_70905_p());
    }

    public EntityAISit func_70907_r()
    {
        return field_70911_d;
    }
}
