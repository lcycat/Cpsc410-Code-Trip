// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelCreeper, EntityCreeper, MathHelper, 
//            ModelBase, EntityLiving

public class RenderCreeper extends RenderLiving
{

    private ModelBase field_77064_a;

    public RenderCreeper()
    {
        super(new ModelCreeper(), 0.5F);
        field_77064_a = new ModelCreeper(2.0F);
    }

    protected void func_77060_a(EntityCreeper p_77060_1_, float p_77060_2_)
    {
        EntityCreeper entitycreeper = p_77060_1_;
        float f = entitycreeper.func_70831_j(p_77060_2_);
        float f1 = 1.0F + MathHelper.func_76126_a(f * 100F) * f * 0.01F;
        if(f < 0.0F)
        {
            f = 0.0F;
        }
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        f *= f;
        f *= f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        GL11.glScalef(f2, f3, f2);
    }

    protected int func_77063_a(EntityCreeper p_77063_1_, float p_77063_2_, float p_77063_3_)
    {
        EntityCreeper entitycreeper = p_77063_1_;
        float f = entitycreeper.func_70831_j(p_77063_3_);
        if((int)(f * 10F) % 2 == 0)
        {
            return 0;
        }
        int i = (int)(f * 0.2F * 255F);
        if(i < 0)
        {
            i = 0;
        }
        if(i > 255)
        {
            i = 255;
        }
        char c = '\377';
        char c1 = '\377';
        char c2 = '\377';
        return i << 24 | c << 16 | c1 << 8 | c2;
    }

    protected int func_77062_a(EntityCreeper p_77062_1_, int p_77062_2_, float p_77062_3_)
    {
        if(p_77062_1_.func_70830_n())
        {
            if(p_77062_2_ == 1)
            {
                float f = (float)p_77062_1_.field_70173_aa + p_77062_3_;
                func_76985_a("/armor/power.png");
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float f1 = f * 0.01F;
                float f2 = f * 0.01F;
                GL11.glTranslatef(f1, f2, 0.0F);
                func_77042_a(field_77064_a);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                float f3 = 0.5F;
                GL11.glColor4f(f3, f3, f3, 1.0F);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
                return 1;
            }
            if(p_77062_2_ == 2)
            {
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
            }
        }
        return -1;
    }

    protected int func_77061_b(EntityCreeper p_77061_1_, int p_77061_2_, float p_77061_3_)
    {
        return -1;
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77060_a((EntityCreeper)p_77041_1_, p_77041_2_);
    }

    protected int func_77030_a(EntityLiving p_77030_1_, float p_77030_2_, float p_77030_3_)
    {
        return func_77063_a((EntityCreeper)p_77030_1_, p_77030_2_, p_77030_3_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77062_a((EntityCreeper)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int func_77035_b(EntityLiving p_77035_1_, int p_77035_2_, float p_77035_3_)
    {
        return func_77061_b((EntityCreeper)p_77035_1_, p_77035_2_, p_77035_3_);
    }
}
