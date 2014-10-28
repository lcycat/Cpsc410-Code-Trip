// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelSpider, OpenGlHelper, EntitySpider, 
//            EntityLiving

public class RenderSpider extends RenderLiving
{

    public RenderSpider()
    {
        super(new ModelSpider(), 1.0F);
        func_77042_a(new ModelSpider());
    }

    protected float func_77095_a(EntitySpider p_77095_1_)
    {
        return 180F;
    }

    protected int func_77097_a(EntitySpider p_77097_1_, int p_77097_2_, float p_77097_3_)
    {
        if(p_77097_2_ != 0)
        {
            return -1;
        } else
        {
            func_76985_a("/mob/spider_eyes.png");
            float f = 1.0F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            int i = 61680;
            int j = i % 0x10000;
            int k = i / 0x10000;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
            return 1;
        }
    }

    protected void func_77096_a(EntitySpider p_77096_1_, float p_77096_2_)
    {
        float f = p_77096_1_.func_70840_n();
        GL11.glScalef(f, f, f);
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77096_a((EntitySpider)p_77041_1_, p_77041_2_);
    }

    protected float func_77037_a(EntityLiving p_77037_1_)
    {
        return func_77095_a((EntitySpider)p_77037_1_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77097_a((EntitySpider)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}
