// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, MathHelper, Tessellator, World, 
//            NBTTagCompound

public class EntityFX extends Entity
{

    private int field_70550_a;
    protected float field_70548_b;
    protected float field_70549_c;
    protected int field_70546_d;
    protected int field_70547_e;
    protected float field_70544_f;
    protected float field_70545_g;
    protected float field_70552_h;
    protected float field_70553_i;
    protected float field_70551_j;
    public static double field_70556_an;
    public static double field_70554_ao;
    public static double field_70555_ap;

    public EntityFX(World p_i3154_1_, double p_i3154_2_, double p_i3154_4_, double p_i3154_6_, 
            double p_i3154_8_, double p_i3154_10_, double p_i3154_12_)
    {
        super(p_i3154_1_);
        field_70546_d = 0;
        field_70547_e = 0;
        func_70105_a(0.2F, 0.2F);
        field_70129_M = field_70131_O / 2.0F;
        func_70107_b(p_i3154_2_, p_i3154_4_, p_i3154_6_);
        field_70552_h = field_70553_i = field_70551_j = 1.0F;
        field_70159_w = p_i3154_8_ + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        field_70181_x = p_i3154_10_ + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        field_70179_y = p_i3154_12_ + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        float f = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
        float f1 = MathHelper.func_76133_a(field_70159_w * field_70159_w + field_70181_x * field_70181_x + field_70179_y * field_70179_y);
        field_70159_w = (field_70159_w / (double)f1) * (double)f * 0.40000000596046448D;
        field_70181_x = (field_70181_x / (double)f1) * (double)f * 0.40000000596046448D + 0.10000000149011612D;
        field_70179_y = (field_70179_y / (double)f1) * (double)f * 0.40000000596046448D;
        field_70548_b = field_70146_Z.nextFloat() * 3F;
        field_70549_c = field_70146_Z.nextFloat() * 3F;
        field_70544_f = (field_70146_Z.nextFloat() * 0.5F + 0.5F) * 2.0F;
        field_70547_e = (int)(4F / (field_70146_Z.nextFloat() * 0.9F + 0.1F));
        field_70546_d = 0;
    }

    public EntityFX func_70543_e(float p_70543_1_)
    {
        field_70159_w *= p_70543_1_;
        field_70181_x = (field_70181_x - 0.10000000149011612D) * (double)p_70543_1_ + 0.10000000149011612D;
        field_70179_y *= p_70543_1_;
        return this;
    }

    public EntityFX func_70541_f(float p_70541_1_)
    {
        func_70105_a(0.2F * p_70541_1_, 0.2F * p_70541_1_);
        field_70544_f *= p_70541_1_;
        return this;
    }

    public void func_70538_b(float p_70538_1_, float p_70538_2_, float p_70538_3_)
    {
        field_70552_h = p_70538_1_;
        field_70553_i = p_70538_2_;
        field_70551_j = p_70538_3_;
    }

    public float func_70534_d()
    {
        return field_70552_h;
    }

    public float func_70542_f()
    {
        return field_70553_i;
    }

    public float func_70535_g()
    {
        return field_70551_j;
    }

    protected boolean func_70041_e_()
    {
        return false;
    }

    protected void func_70088_a()
    {
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        if(field_70546_d++ >= field_70547_e)
        {
            func_70106_y();
        }
        field_70181_x -= 0.040000000000000001D * (double)field_70545_g;
        func_70091_d(field_70159_w, field_70181_x, field_70179_y);
        field_70159_w *= 0.98000001907348633D;
        field_70181_x *= 0.98000001907348633D;
        field_70179_y *= 0.98000001907348633D;
        if(field_70122_E)
        {
            field_70159_w *= 0.69999998807907104D;
            field_70179_y *= 0.69999998807907104D;
        }
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f = (float)(field_70550_a % 16) / 16F;
        float f1 = f + 0.0624375F;
        float f2 = (float)(field_70550_a / 16) / 16F;
        float f3 = f2 + 0.0624375F;
        float f4 = 0.1F * field_70544_f;
        float f5 = (float)((field_70169_q + (field_70165_t - field_70169_q) * (double)p_70539_2_) - field_70556_an);
        float f6 = (float)((field_70167_r + (field_70163_u - field_70167_r) * (double)p_70539_2_) - field_70554_ao);
        float f7 = (float)((field_70166_s + (field_70161_v - field_70166_s) * (double)p_70539_2_) - field_70555_ap);
        float f8 = 1.0F;
        p_70539_1_.func_78386_a(field_70552_h * f8, field_70553_i * f8, field_70551_j * f8);
        p_70539_1_.func_78374_a(f5 - p_70539_3_ * f4 - p_70539_6_ * f4, f6 - p_70539_4_ * f4, f7 - p_70539_5_ * f4 - p_70539_7_ * f4, f1, f3);
        p_70539_1_.func_78374_a((f5 - p_70539_3_ * f4) + p_70539_6_ * f4, f6 + p_70539_4_ * f4, (f7 - p_70539_5_ * f4) + p_70539_7_ * f4, f1, f2);
        p_70539_1_.func_78374_a(f5 + p_70539_3_ * f4 + p_70539_6_ * f4, f6 + p_70539_4_ * f4, f7 + p_70539_5_ * f4 + p_70539_7_ * f4, f, f2);
        p_70539_1_.func_78374_a((f5 + p_70539_3_ * f4) - p_70539_6_ * f4, f6 - p_70539_4_ * f4, (f7 + p_70539_5_ * f4) - p_70539_7_ * f4, f, f3);
    }

    public int func_70537_b()
    {
        return 0;
    }

    public void func_70014_b(NBTTagCompound nbttagcompound)
    {
    }

    public void func_70037_a(NBTTagCompound nbttagcompound)
    {
    }

    public void func_70536_a(int p_70536_1_)
    {
        field_70550_a = p_70536_1_;
    }

    public int func_70540_h()
    {
        return field_70550_a;
    }

    public boolean func_70075_an()
    {
        return false;
    }
}
