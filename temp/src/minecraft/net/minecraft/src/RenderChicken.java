// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityChicken, MathHelper, ModelBase, 
//            EntityLiving, Entity

public class RenderChicken extends RenderLiving
{

    public RenderChicken(ModelBase p_i3200_1_, float p_i3200_2_)
    {
        super(p_i3200_1_, p_i3200_2_);
    }

    public void func_77065_a(EntityChicken p_77065_1_, double p_77065_2_, double p_77065_4_, double p_77065_6_, 
            float p_77065_8_, float p_77065_9_)
    {
        super.func_77031_a(p_77065_1_, p_77065_2_, p_77065_4_, p_77065_6_, p_77065_8_, p_77065_9_);
    }

    protected float func_77066_a(EntityChicken p_77066_1_, float p_77066_2_)
    {
        float f = p_77066_1_.field_70888_h + (p_77066_1_.field_70886_e - p_77066_1_.field_70888_h) * p_77066_2_;
        float f1 = p_77066_1_.field_70884_g + (p_77066_1_.field_70883_f - p_77066_1_.field_70884_g) * p_77066_2_;
        return (MathHelper.func_76126_a(f) + 1.0F) * f1;
    }

    protected float func_77044_a(EntityLiving p_77044_1_, float p_77044_2_)
    {
        return func_77066_a((EntityChicken)p_77044_1_, p_77044_2_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77065_a((EntityChicken)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77065_a((EntityChicken)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
