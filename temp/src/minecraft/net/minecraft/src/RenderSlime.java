// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySlime, ModelBase, EntityLiving

public class RenderSlime extends RenderLiving
{

    private ModelBase field_77092_a;

    public RenderSlime(ModelBase p_i3198_1_, ModelBase p_i3198_2_, float p_i3198_3_)
    {
        super(p_i3198_1_, p_i3198_3_);
        field_77092_a = p_i3198_2_;
    }

    protected int func_77090_a(EntitySlime p_77090_1_, int p_77090_2_, float p_77090_3_)
    {
        if(p_77090_2_ == 0)
        {
            func_77042_a(field_77092_a);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        }
        if(p_77090_2_ == 1)
        {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        return -1;
    }

    protected void func_77091_a(EntitySlime p_77091_1_, float p_77091_2_)
    {
        float f = p_77091_1_.func_70809_q();
        float f1 = (p_77091_1_.field_70812_c + (p_77091_1_.field_70811_b - p_77091_1_.field_70812_c) * p_77091_2_) / (f * 0.5F + 1.0F);
        float f2 = 1.0F / (f1 + 1.0F);
        GL11.glScalef(f2 * f, (1.0F / f2) * f, f2 * f);
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77091_a((EntitySlime)p_77041_1_, p_77041_2_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77090_a((EntitySlime)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}
