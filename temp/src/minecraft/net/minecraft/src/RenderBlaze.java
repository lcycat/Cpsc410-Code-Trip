// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelBlaze, EntityBlaze, EntityLiving, 
//            Entity

public class RenderBlaze extends RenderLiving
{

    private int field_77068_a;

    public RenderBlaze()
    {
        super(new ModelBlaze(), 0.5F);
        field_77068_a = ((ModelBlaze)field_77045_g).func_78104_a();
    }

    public void func_77067_a(EntityBlaze p_77067_1_, double p_77067_2_, double p_77067_4_, double p_77067_6_, 
            float p_77067_8_, float p_77067_9_)
    {
        int i = ((ModelBlaze)field_77045_g).func_78104_a();
        if(i != field_77068_a)
        {
            field_77068_a = i;
            field_77045_g = new ModelBlaze();
        }
        super.func_77031_a(p_77067_1_, p_77067_2_, p_77067_4_, p_77067_6_, p_77067_8_, p_77067_9_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77067_a((EntityBlaze)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77067_a((EntityBlaze)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
