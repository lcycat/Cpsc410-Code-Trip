// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntityFX, Entity, MathHelper, OpenGlHelper, 
//            RenderManager, World, Tessellator

public class EntityPickupFX extends EntityFX
{

    private Entity field_70591_a;
    private Entity field_70595_aq;
    private int field_70594_ar;
    private int field_70593_as;
    private float field_70592_at;

    public EntityPickupFX(World p_i3176_1_, Entity p_i3176_2_, Entity p_i3176_3_, float p_i3176_4_)
    {
        super(p_i3176_1_, p_i3176_2_.field_70165_t, p_i3176_2_.field_70163_u, p_i3176_2_.field_70161_v, p_i3176_2_.field_70159_w, p_i3176_2_.field_70181_x, p_i3176_2_.field_70179_y);
        field_70594_ar = 0;
        field_70593_as = 0;
        field_70591_a = p_i3176_2_;
        field_70595_aq = p_i3176_3_;
        field_70593_as = 3;
        field_70592_at = p_i3176_4_;
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f = ((float)field_70594_ar + p_70539_2_) / (float)field_70593_as;
        f *= f;
        double d = field_70591_a.field_70165_t;
        double d1 = field_70591_a.field_70163_u;
        double d2 = field_70591_a.field_70161_v;
        double d3 = field_70595_aq.field_70142_S + (field_70595_aq.field_70165_t - field_70595_aq.field_70142_S) * (double)p_70539_2_;
        double d4 = field_70595_aq.field_70137_T + (field_70595_aq.field_70163_u - field_70595_aq.field_70137_T) * (double)p_70539_2_ + (double)field_70592_at;
        double d5 = field_70595_aq.field_70136_U + (field_70595_aq.field_70161_v - field_70595_aq.field_70136_U) * (double)p_70539_2_;
        double d6 = d + (d3 - d) * (double)f;
        double d7 = d1 + (d4 - d1) * (double)f;
        double d8 = d2 + (d5 - d2) * (double)f;
        int i = MathHelper.func_76128_c(d6);
        int j = MathHelper.func_76128_c(d7 + (double)(field_70129_M / 2.0F));
        int k = MathHelper.func_76128_c(d8);
        int l = func_70070_b(p_70539_2_);
        int i1 = l % 0x10000;
        int j1 = l / 0x10000;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)i1 / 1.0F, (float)j1 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        d6 -= field_70556_an;
        d7 -= field_70554_ao;
        d8 -= field_70555_ap;
        RenderManager.field_78727_a.func_78719_a(field_70591_a, (float)d6, (float)d7, (float)d8, field_70591_a.field_70177_z, p_70539_2_);
    }

    public void func_70071_h_()
    {
        field_70594_ar++;
        if(field_70594_ar == field_70593_as)
        {
            func_70106_y();
        }
    }

    public int func_70537_b()
    {
        return 3;
    }
}
