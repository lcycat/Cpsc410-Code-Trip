// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelSilverfish, EntitySilverfish, EntityLiving, 
//            Entity

public class RenderSilverfish extends RenderLiving
{

    public RenderSilverfish()
    {
        super(new ModelSilverfish(), 0.3F);
    }

    protected float func_77089_a(EntitySilverfish p_77089_1_)
    {
        return 180F;
    }

    public void func_77088_a(EntitySilverfish p_77088_1_, double p_77088_2_, double p_77088_4_, double p_77088_6_, 
            float p_77088_8_, float p_77088_9_)
    {
        super.func_77031_a(p_77088_1_, p_77088_2_, p_77088_4_, p_77088_6_, p_77088_8_, p_77088_9_);
    }

    protected int func_77087_a(EntitySilverfish p_77087_1_, int p_77087_2_, float p_77087_3_)
    {
        return -1;
    }

    protected float func_77037_a(EntityLiving p_77037_1_)
    {
        return func_77089_a((EntitySilverfish)p_77037_1_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77087_a((EntitySilverfish)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77088_a((EntitySilverfish)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77088_a((EntitySilverfish)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
