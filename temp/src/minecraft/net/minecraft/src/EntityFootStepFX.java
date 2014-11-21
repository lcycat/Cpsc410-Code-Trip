// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntityFX, MathHelper, World, RenderEngine, 
//            Tessellator

public class EntityFootStepFX extends EntityFX
{

    private int field_70576_a;
    private int field_70578_aq;
    private RenderEngine field_70577_ar;

    public EntityFootStepFX(RenderEngine p_i3168_1_, World p_i3168_2_, double p_i3168_3_, double p_i3168_5_, double p_i3168_7_)
    {
        super(p_i3168_2_, p_i3168_3_, p_i3168_5_, p_i3168_7_, 0.0D, 0.0D, 0.0D);
        field_70576_a = 0;
        field_70578_aq = 0;
        field_70577_ar = p_i3168_1_;
        field_70159_w = field_70181_x = field_70179_y = 0.0D;
        field_70578_aq = 200;
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f = ((float)field_70576_a + p_70539_2_) / (float)field_70578_aq;
        f *= f;
        float f1 = 2.0F - f * 2.0F;
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        f1 *= 0.2F;
        GL11.glDisable(2896);
        float f2 = 0.125F;
        float f3 = (float)(field_70165_t - field_70556_an);
        float f4 = (float)(field_70163_u - field_70554_ao);
        float f5 = (float)(field_70161_v - field_70555_ap);
        float f6 = field_70170_p.func_72801_o(MathHelper.func_76128_c(field_70165_t), MathHelper.func_76128_c(field_70163_u), MathHelper.func_76128_c(field_70161_v));
        field_70577_ar.func_78342_b(field_70577_ar.func_78341_b("/misc/footprint.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        p_70539_1_.func_78382_b();
        p_70539_1_.func_78369_a(f6, f6, f6, f1);
        p_70539_1_.func_78374_a(f3 - f2, f4, f5 + f2, 0.0D, 1.0D);
        p_70539_1_.func_78374_a(f3 + f2, f4, f5 + f2, 1.0D, 1.0D);
        p_70539_1_.func_78374_a(f3 + f2, f4, f5 - f2, 1.0D, 0.0D);
        p_70539_1_.func_78374_a(f3 - f2, f4, f5 - f2, 0.0D, 0.0D);
        p_70539_1_.func_78381_a();
        GL11.glDisable(3042);
        GL11.glEnable(2896);
    }

    public void func_70071_h_()
    {
        field_70576_a++;
        if(field_70576_a == field_70578_aq)
        {
            func_70106_y();
        }
    }

    public int func_70537_b()
    {
        return 3;
    }
}
