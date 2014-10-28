// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Entity, World, MathHelper, Block, 
//            BlockPistonMoving, BlockSand, ItemStack, NBTTagCompound

public class EntityFallingSand extends Entity
{

    public int field_70287_a;
    public int field_70285_b;
    public int field_70286_c;
    public boolean field_70284_d;

    public EntityFallingSand(World p_i3536_1_)
    {
        super(p_i3536_1_);
        field_70286_c = 0;
        field_70284_d = true;
    }

    public EntityFallingSand(World p_i3537_1_, double p_i3537_2_, double p_i3537_4_, double p_i3537_6_, 
            int p_i3537_8_)
    {
        this(p_i3537_1_, p_i3537_2_, p_i3537_4_, p_i3537_6_, p_i3537_8_, 0);
    }

    public EntityFallingSand(World p_i3538_1_, double p_i3538_2_, double p_i3538_4_, double p_i3538_6_, 
            int p_i3538_8_, int p_i3538_9_)
    {
        super(p_i3538_1_);
        field_70286_c = 0;
        field_70284_d = true;
        field_70287_a = p_i3538_8_;
        field_70285_b = p_i3538_9_;
        field_70156_m = true;
        func_70105_a(0.98F, 0.98F);
        field_70129_M = field_70131_O / 2.0F;
        func_70107_b(p_i3538_2_, p_i3538_4_, p_i3538_6_);
        field_70159_w = 0.0D;
        field_70181_x = 0.0D;
        field_70179_y = 0.0D;
        field_70169_q = p_i3538_2_;
        field_70167_r = p_i3538_4_;
        field_70166_s = p_i3538_6_;
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    protected void func_70088_a()
    {
    }

    public boolean func_70067_L()
    {
        return !field_70128_L;
    }

    public void func_70071_h_()
    {
        if(field_70287_a == 0)
        {
            func_70106_y();
            return;
        }
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70286_c++;
        field_70181_x -= 0.039999999105930328D;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.98000001907348633D;
        field_70181_x *= 0.98000001907348633D;
        field_70179_y *= 0.98000001907348633D;
        if(!field_70170_p.field_72995_K)
        {
            int i = MathHelper.func_76128_c(field_70165_t);
            int j = MathHelper.func_76128_c(field_70163_u);
            int k = MathHelper.func_76128_c(field_70161_v);
            if(field_70286_c == 1)
            {
                if(field_70286_c == 1 && field_70170_p.func_72798_a(i, j, k) == field_70287_a)
                {
                    field_70170_p.func_72859_e(i, j, k, 0);
                } else
                {
                    func_70106_y();
                }
            }
            if(field_70122_E)
            {
                field_70159_w *= 0.69999998807907104D;
                field_70179_y *= 0.69999998807907104D;
                field_70181_x *= -0.5D;
                if(field_70170_p.func_72798_a(i, j, k) != Block.field_72095_ac.field_71990_ca)
                {
                    func_70106_y();
                    if((!field_70170_p.func_72931_a(field_70287_a, i, j, k, true, 1, null) || BlockSand.func_72191_e_(field_70170_p, i, j - 1, k) || !field_70170_p.func_72832_d(i, j, k, field_70287_a, field_70285_b)) && !field_70170_p.field_72995_K && field_70284_d)
                    {
                        func_70099_a(new ItemStack(field_70287_a, 1, field_70285_b), 0.0F);
                    }
                }
            } else
            if(field_70286_c > 100 && !field_70170_p.field_72995_K && (j < 1 || j > 256) || field_70286_c > 600)
            {
                if(field_70284_d)
                {
                    func_70025_b(field_70287_a, 1);
                }
                func_70106_y();
            }
        }
    }

    protected void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74774_a("Tile", (byte)field_70287_a);
        p_70014_1_.func_74774_a("Data", (byte)field_70285_b);
        p_70014_1_.func_74774_a("Time", (byte)field_70286_c);
        p_70014_1_.func_74757_a("DropItem", field_70284_d);
    }

    protected void func_70037_a(NBTTagCompound p_70037_1_)
    {
        field_70287_a = p_70037_1_.func_74771_c("Tile") & 0xff;
        field_70285_b = p_70037_1_.func_74771_c("Data") & 0xff;
        field_70286_c = p_70037_1_.func_74771_c("Time") & 0xff;
        if(p_70037_1_.func_74764_b("DropItem"))
        {
            field_70284_d = p_70037_1_.func_74767_n("DropItem");
        }
        if(field_70287_a == 0)
        {
            field_70287_a = Block.field_71939_E.field_71990_ca;
        }
    }
}
