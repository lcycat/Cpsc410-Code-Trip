// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, Entity

public class RenderEntity extends Render
{

    public RenderEntity()
    {
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        GL11.glPushMatrix();
        func_76978_a(p_76986_1_.field_70121_D, p_76986_2_ - p_76986_1_.field_70142_S, p_76986_4_ - p_76986_1_.field_70137_T, p_76986_6_ - p_76986_1_.field_70136_U);
        GL11.glPopMatrix();
    }
}
