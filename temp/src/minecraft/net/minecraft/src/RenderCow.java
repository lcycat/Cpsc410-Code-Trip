// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityCow, ModelBase, EntityLiving, 
//            Entity

public class RenderCow extends RenderLiving
{

    public RenderCow(ModelBase p_i3210_1_, float p_i3210_2_)
    {
        super(p_i3210_1_, p_i3210_2_);
    }

    public void func_77059_a(EntityCow p_77059_1_, double p_77059_2_, double p_77059_4_, double p_77059_6_, 
            float p_77059_8_, float p_77059_9_)
    {
        super.func_77031_a(p_77059_1_, p_77059_2_, p_77059_4_, p_77059_6_, p_77059_8_, p_77059_9_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77059_a((EntityCow)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77059_a((EntityCow)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
