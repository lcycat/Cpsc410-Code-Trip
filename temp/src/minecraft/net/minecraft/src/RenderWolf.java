// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityWolf, ModelBase, EntityLiving, 
//            Entity

public class RenderWolf extends RenderLiving
{

    public RenderWolf(ModelBase p_i3211_1_, float p_i3211_2_)
    {
        super(p_i3211_1_, p_i3211_2_);
    }

    public void func_77058_a(EntityWolf p_77058_1_, double p_77058_2_, double p_77058_4_, double p_77058_6_, 
            float p_77058_8_, float p_77058_9_)
    {
        super.func_77031_a(p_77058_1_, p_77058_2_, p_77058_4_, p_77058_6_, p_77058_8_, p_77058_9_);
    }

    protected float func_77057_a(EntityWolf p_77057_1_, float p_77057_2_)
    {
        return p_77057_1_.func_70920_v();
    }

    protected float func_77044_a(EntityLiving p_77044_1_, float p_77044_2_)
    {
        return func_77057_a((EntityWolf)p_77044_1_, p_77044_2_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77058_a((EntityWolf)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77058_a((EntityWolf)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
