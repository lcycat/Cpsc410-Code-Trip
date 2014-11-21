// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Entity, World, NBTTagCompound

public class EntityTNTPrimed extends Entity
{

    public int field_70516_a;

    public EntityTNTPrimed(World p_i3543_1_)
    {
        super(p_i3543_1_);
        field_70516_a = 0;
        field_70156_m = true;
        func_70105_a(0.98F, 0.98F);
        field_70129_M = field_70131_O / 2.0F;
    }

    public EntityTNTPrimed(World p_i3544_1_, double p_i3544_2_, double p_i3544_4_, double p_i3544_6_)
    {
        this(p_i3544_1_);
        func_70107_b(p_i3544_2_, p_i3544_4_, p_i3544_6_);
        float f = (float)(Math.random() * 3.1415927410125732D * 2D);
        field_70159_w = -(float)Math.sin(f) * 0.02F;
        field_70181_x = 0.20000000298023224D;
        field_70179_y = -(float)Math.cos(f) * 0.02F;
        field_70516_a = 80;
        field_70169_q = p_i3544_2_;
        field_70167_r = p_i3544_4_;
        field_70166_s = p_i3544_6_;
    }

    protected void func_70088_a()
    {
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    public boolean func_70067_L()
    {
        return !field_70128_L;
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70181_x -= 0.039999999105930328D;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.98000001907348633D;
        field_70181_x *= 0.98000001907348633D;
        field_70179_y *= 0.98000001907348633D;
        if(field_70122_E)
        {
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
            field_70181_x *= -0.5D;
        }
        if(field_70516_a-- <= 0)
        {
            func_70106_y();
            if(!field_70170_p.field_72995_K)
            {
                func_70515_d();
            }
        } else
        {
            field_70170_p.func_72869_a("smoke", field_70165_t, field_70163_u + 0.5D, field_70161_v, 0.0D, 0.0D, 0.0D);
        }
    }

    private void func_70515_d()
    {
        float f = 4F;
        field_70170_p.func_72876_a(null, field_70165_t, field_70163_u, field_70161_v, f);
    }

    protected void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74774_a("Fuse", (byte)field_70516_a);
    }

    protected void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70516_a = p_70037_1_.func_74771_c("Fuse");
    }

    public float func_70053_R()
    {
        return 0.0F;
    }
}
