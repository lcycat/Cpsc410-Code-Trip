// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, Block, Tessellator, World

public class EntityDiggingFX extends EntityFX
{

    private Block field_70597_a;

    public EntityDiggingFX(World p_i3185_1_, double p_i3185_2_, double p_i3185_4_, double p_i3185_6_, 
            double p_i3185_8_, double p_i3185_10_, double p_i3185_12_, Block p_i3185_14_, 
            int p_i3185_15_, int p_i3185_16_)
    {
        super(p_i3185_1_, p_i3185_2_, p_i3185_4_, p_i3185_6_, p_i3185_8_, p_i3185_10_, p_i3185_12_);
        field_70597_a = p_i3185_14_;
        func_70536_a(p_i3185_14_.func_71858_a(0, p_i3185_16_));
        field_70545_g = p_i3185_14_.field_72017_co;
        field_70552_h = field_70553_i = field_70551_j = 0.6F;
        field_70544_f /= 2.0F;
    }

    public EntityDiggingFX func_70596_a(int p_70596_1_, int p_70596_2_, int p_70596_3_)
    {
        if(field_70597_a == Block.field_71980_u)
        {
            return this;
        } else
        {
            int i = field_70597_a.func_71920_b(field_70170_p, p_70596_1_, p_70596_2_, p_70596_3_);
            field_70552_h *= (float)(i >> 16 & 0xff) / 255F;
            field_70553_i *= (float)(i >> 8 & 0xff) / 255F;
            field_70551_j *= (float)(i & 0xff) / 255F;
            return this;
        }
    }

    public int func_70537_b()
    {
        return 1;
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
