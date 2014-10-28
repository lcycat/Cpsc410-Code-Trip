// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelGhast, EntityGhast, EntityLiving

public class RenderGhast extends RenderLiving
{

    public RenderGhast()
    {
        super(new ModelGhast(), 0.5F);
    }

    protected void func_77069_a(EntityGhast p_77069_1_, float p_77069_2_)
    {
        EntityGhast entityghast = p_77069_1_;
        float f = ((float)entityghast.field_70794_e + (float)(entityghast.field_70791_f - entityghast.field_70794_e) * p_77069_2_) / 20F;
        if(f < 0.0F)
        {
            f = 0.0F;
        }
        f = 1.0F / (f * f * f * f * f * 2.0F + 1.0F);
        float f1 = (8F + f) / 2.0F;
        float f2 = (8F + 1.0F / f) / 2.0F;
        GL11.glScalef(f2, f1, f2);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77069_a((EntityGhast)p_77041_1_, p_77041_2_);
    }
}
