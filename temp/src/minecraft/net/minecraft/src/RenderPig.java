// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityPig, ModelBase, EntityLiving, 
//            Entity

public class RenderPig extends RenderLiving
{

    public RenderPig(ModelBase p_i3197_1_, ModelBase p_i3197_2_, float p_i3197_3_)
    {
        super(p_i3197_1_, p_i3197_3_);
        func_77042_a(p_i3197_2_);
    }

    protected int func_77099_a(EntityPig p_77099_1_, int p_77099_2_, float p_77099_3_)
    {
        func_76985_a("/mob/saddle.png");
        return p_77099_2_ != 0 || !p_77099_1_.func_70901_n() ? -1 : 1;
    }

    public void func_77098_a(EntityPig p_77098_1_, double p_77098_2_, double p_77098_4_, double p_77098_6_, 
            float p_77098_8_, float p_77098_9_)
    {
        super.func_77031_a(p_77098_1_, p_77098_2_, p_77098_4_, p_77098_6_, p_77098_8_, p_77098_9_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77099_a((EntityPig)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77098_a((EntityPig)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77098_a((EntityPig)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
