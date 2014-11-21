// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntityFX, RenderEngine, RenderHelper, Tessellator, 
//            World

public class EntityLargeExplodeFX extends EntityFX
{

    private int field_70581_a;
    private int field_70584_aq;
    private RenderEngine field_70583_ar;
    private float field_70582_as;

    public EntityLargeExplodeFX(RenderEngine p_i3181_1_, World p_i3181_2_, double p_i3181_3_, double p_i3181_5_, double p_i3181_7_, double p_i3181_9_, double p_i3181_11_, double p_i3181_13_)
    {
        super(p_i3181_2_, p_i3181_3_, p_i3181_5_, p_i3181_7_, 0.0D, 0.0D, 0.0D);
        field_70581_a = 0;
        field_70584_aq = 0;
        field_70583_ar = p_i3181_1_;
        field_70584_aq = 6 + field_70146_Z.nextInt(4);
        field_70552_h = field_70553_i = field_70551_j = field_70146_Z.nextFloat() * 0.6F + 0.4F;
        field_70582_as = 1.0F - (float)p_i3181_9_ * 0.5F;
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        int i = (int)((((float)field_70581_a + p_70539_2_) * 15F) / (float)field_70584_aq);
        if(i > 15)
        {
            return;
        } else
        {
            field_70583_ar.func_78342_b(field_70583_ar.func_78341_b("/misc/explosion.png"));
            float f = (float)(i % 4) / 4F;
            float f1 = f + 0.24975F;
            float f2 = (float)(i / 4) / 4F;
            float f3 = f2 + 0.24975F;
            float f4 = 2.0F * field_70582_as;
            float f5 = (float)((field_70169_q + (field_70165_t - field_70169_q) * (double)p_70539_2_) - field_70556_an);
            float f6 = (float)((field_70167_r + (field_70163_u - field_70167_r) * (double)p_70539_2_) - field_70554_ao);
            float f7 = (float)((field_70166_s + (field_70161_v - field_70166_s) * (double)p_70539_2_) - field_70555_ap);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(2896);
            RenderHelper.func_74518_a();
            p_70539_1_.func_78382_b();
            p_70539_1_.func_78369_a(field_70552_h, field_70553_i, field_70551_j, 1.0F);
            p_70539_1_.func_78375_b(0.0F, 1.0F, 0.0F);
            p_70539_1_.func_78380_c(240);
            p_70539_1_.func_78374_a(f5 - p_70539_3_ * f4 - p_70539_6_ * f4, f6 - p_70539_4_ * f4, f7 - p_70539_5_ * f4 - p_70539_7_ * f4, f1, f3);
            p_70539_1_.func_78374_a((f5 - p_70539_3_ * f4) + p_70539_6_ * f4, f6 + p_70539_4_ * f4, (f7 - p_70539_5_ * f4) + p_70539_7_ * f4, f1, f2);
            p_70539_1_.func_78374_a(f5 + p_70539_3_ * f4 + p_70539_6_ * f4, f6 + p_70539_4_ * f4, f7 + p_70539_5_ * f4 + p_70539_7_ * f4, f, f2);
            p_70539_1_.func_78374_a((f5 + p_70539_3_ * f4) - p_70539_6_ * f4, f6 - p_70539_4_ * f4, (f7 + p_70539_5_ * f4) - p_70539_7_ * f4, f, f3);
            p_70539_1_.func_78381_a();
            GL11.glPolygonOffset(0.0F, 0.0F);
            GL11.glEnable(2896);
            return;
        }
    }

    public int func_70070_b(float p_70070_1_)
    {
        return 61680;
    }

    public void func_70071_h_()
    {
        field_70169_q = field_70165_t;
        field_70167_r = field_70163_u;
        field_70166_s = field_70161_v;
        field_70581_a++;
        if(field_70581_a == field_70584_aq)
        {
            func_70106_y();
        }
    }

    public int func_70537_b()
    {
        return 3;
    }
}
