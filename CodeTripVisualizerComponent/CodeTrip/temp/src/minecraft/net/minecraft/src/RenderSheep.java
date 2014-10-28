// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySheep, ModelBase, EntityLiving, 
//            Entity

public class RenderSheep extends RenderLiving
{

    public RenderSheep(ModelBase p_i3209_1_, ModelBase p_i3209_2_, float p_i3209_3_)
    {
        super(p_i3209_1_, p_i3209_3_);
        func_77042_a(p_i3209_2_);
    }

    protected int func_77113_a(EntitySheep p_77113_1_, int p_77113_2_, float p_77113_3_)
    {
        if(p_77113_2_ == 0 && !p_77113_1_.func_70892_o())
        {
            func_76985_a("/mob/sheep_fur.png");
            float f = 1.0F;
            int i = p_77113_1_.func_70896_n();
            GL11.glColor3f(f * EntitySheep.field_70898_d[i][0], f * EntitySheep.field_70898_d[i][1], f * EntitySheep.field_70898_d[i][2]);
            return 1;
        } else
        {
            return -1;
        }
    }

    public void func_77112_a(EntitySheep p_77112_1_, double p_77112_2_, double p_77112_4_, double p_77112_6_, 
            float p_77112_8_, float p_77112_9_)
    {
        super.func_77031_a(p_77112_1_, p_77112_2_, p_77112_4_, p_77112_6_, p_77112_8_, p_77112_9_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77113_a((EntitySheep)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77112_a((EntitySheep)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77112_a((EntitySheep)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
