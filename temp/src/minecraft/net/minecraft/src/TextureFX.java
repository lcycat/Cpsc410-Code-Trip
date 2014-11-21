// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderEngine

public class TextureFX
{

    public byte field_76852_a[];
    public int field_76850_b;
    public boolean field_76851_c;
    public int field_76848_d;
    public int field_76849_e;
    public int field_76847_f;

    public TextureFX(int p_i3213_1_)
    {
        field_76852_a = new byte[1024];
        field_76851_c = false;
        field_76848_d = 0;
        field_76849_e = 1;
        field_76847_f = 0;
        field_76850_b = p_i3213_1_;
    }

    public void func_76846_a()
    {
    }

    public void func_76845_a(RenderEngine p_76845_1_)
    {
        if(field_76847_f == 0)
        {
            GL11.glBindTexture(3553, p_76845_1_.func_78341_b("/terrain.png"));
        } else
        if(field_76847_f == 1)
        {
            GL11.glBindTexture(3553, p_76845_1_.func_78341_b("/gui/items.png"));
        }
    }
}
