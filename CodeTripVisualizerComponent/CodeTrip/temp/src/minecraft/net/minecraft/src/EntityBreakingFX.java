// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, Item, Block, Tessellator, 
//            World

public class EntityBreakingFX extends EntityFX
{

    public EntityBreakingFX(World p_i3164_1_, double p_i3164_2_, double p_i3164_4_, double p_i3164_6_, 
            Item p_i3164_8_)
    {
        super(p_i3164_1_, p_i3164_2_, p_i3164_4_, p_i3164_6_, 0.0D, 0.0D, 0.0D);
        func_70536_a(p_i3164_8_.func_77617_a(0));
        field_70552_h = field_70553_i = field_70551_j = 1.0F;
        field_70545_g = Block.field_72039_aU.field_72017_co;
        field_70544_f /= 2.0F;
    }

    public EntityBreakingFX(World p_i3165_1_, double p_i3165_2_, double p_i3165_4_, double p_i3165_6_, 
            double p_i3165_8_, double p_i3165_10_, double p_i3165_12_, Item p_i3165_14_)
    {
        this(p_i3165_1_, p_i3165_2_, p_i3165_4_, p_i3165_6_, p_i3165_14_);
        field_70159_w *= 0.10000000149011612D;
        field_70181_x *= 0.10000000149011612D;
        field_70179_y *= 0.10000000149011612D;
        field_70159_w += p_i3165_8_;
        field_70181_x += p_i3165_10_;
        field_70179_y += p_i3165_12_;
    }

    public int func_70537_b()
    {
        return 2;
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f = ((float)(func_70540_h() % 16) + field_70548_b / 4F) / 16F;
        float f1 = f + 0.01560938F;
        float f2 = ((float)(func_70540_h() / 16) + field_70549_c / 4F) / 16F;
        float f3 = f2 + 0.01560938F;
        float f4 = 0.1F * field_70544_f;
        float f5 = (float)((field_70169_q + (field_70165_t - field_70169_q) * (double)p_70539_2_) - field_70556_an);
        float f6 = (float)((field_70167_r + (field_70163_u - field_70167_r) * (double)p_70539_2_) - field_70554_ao);
        float f7 = (float)((field_70166_s + (field_70161_v - field_70166_s) * (double)p_70539_2_) - field_70555_ap);
        float f8 = 1.0F;
        p_70539_1_.func_78386_a(f8 * field_70552_h, f8 * field_70553_i, f8 * field_70551_j);
        p_70539_1_.func_78374_a(f5 - p_70539_3_ * f4 - p_70539_6_ * f4, f6 - p_70539_4_ * f4, f7 - p_70539_5_ * f4 - p_70539_7_ * f4, f, f3);
        p_70539_1_.func_78374_a((f5 - p_70539_3_ * f4) + p_70539_6_ * f4, f6 + p_70539_4_ * f4, (f7 - p_70539_5_ * f4) + p_70539_7_ * f4, f, f2);
        p_70539_1_.func_78374_a(f5 + p_70539_3_ * f4 + p_70539_6_ * f4, f6 + p_70539_4_ * f4, f7 + p_70539_5_ * f4 + p_70539_7_ * f4, f1, f2);
        p_70539_1_.func_78374_a((f5 + p_70539_3_ * f4) - p_70539_6_ * f4, f6 - p_70539_4_ * f4, (f7 + p_70539_5_ * f4) - p_70539_7_ * f4, f1, f3);
    }
}
