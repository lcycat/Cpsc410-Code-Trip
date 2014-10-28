// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityGiantZombie, ModelBase, EntityLiving

public class RenderGiantZombie extends RenderLiving
{

    private float field_77073_a;

    public RenderGiantZombie(ModelBase p_i3205_1_, float p_i3205_2_, float p_i3205_3_)
    {
        super(p_i3205_1_, p_i3205_2_ * p_i3205_3_);
        field_77073_a = p_i3205_3_;
    }

    protected void func_77072_a(EntityGiantZombie p_77072_1_, float p_77072_2_)
    {
        GL11.glScalef(field_77073_a, field_77073_a, field_77073_a);
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77072_a((EntityGiantZombie)p_77041_1_, p_77041_2_);
    }
}
