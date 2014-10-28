// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderEngine, MapData, MapColor, GameSettings, 
//            Tessellator, MapCoord, FontRenderer, EntityPlayer

public class MapItemRenderer
{

    private int field_78323_a[];
    private int field_78321_b;
    private GameSettings field_78322_c;
    private FontRenderer field_78320_d;

    public MapItemRenderer(FontRenderer p_i3063_1_, GameSettings p_i3063_2_, RenderEngine p_i3063_3_)
    {
        field_78323_a = new int[16384];
        field_78322_c = p_i3063_2_;
        field_78320_d = p_i3063_1_;
        field_78321_b = p_i3063_3_.func_78353_a(new BufferedImage(128, 128, 2));
        for(int i = 0; i < 16384; i++)
        {
            field_78323_a[i] = 0;
        }

    }

    public void func_78319_a(EntityPlayer p_78319_1_, RenderEngine p_78319_2_, MapData p_78319_3_)
    {
        for(int i = 0; i < 16384; i++)
        {
            byte byte0 = p_78319_3_.field_76198_e[i];
            if(byte0 / 4 == 0)
            {
                field_78323_a[i] = (i + i / 128 & 1) * 8 + 16 << 24;
                continue;
            }
            int l = MapColor.field_76281_a[byte0 / 4].field_76291_p;
            int i1 = byte0 & 3;
            char c = '\334';
            if(i1 == 2)
            {
                c = '\377';
            }
            if(i1 == 0)
            {
                c = '\264';
            }
            int j1 = ((l >> 16 & 0xff) * c) / 255;
            int k1 = ((l >> 8 & 0xff) * c) / 255;
            int l1 = ((l & 0xff) * c) / 255;
            if(field_78322_c.field_74337_g)
            {
                int i2 = (j1 * 30 + k1 * 59 + l1 * 11) / 100;
                int j2 = (j1 * 30 + k1 * 70) / 100;
                int k2 = (j1 * 30 + l1 * 70) / 100;
                j1 = i2;
                k1 = j2;
                l1 = k2;
            }
            field_78323_a[i] = 0xff000000 | j1 << 16 | k1 << 8 | l1;
        }

        p_78319_2_.func_78349_a(field_78323_a, 128, 128, field_78321_b);
        int j = 0;
        int k = 0;
        Tessellator tessellator = Tessellator.field_78398_a;
        float f = 0.0F;
        GL11.glBindTexture(3553, field_78321_b);
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 771);
        GL11.glDisable(3008);
        tessellator.func_78382_b();
        tessellator.func_78374_a((float)(j + 0) + f, (float)(k + 128) - f, -0.0099999997764825821D, 0.0D, 1.0D);
        tessellator.func_78374_a((float)(j + 128) - f, (float)(k + 128) - f, -0.0099999997764825821D, 1.0D, 1.0D);
        tessellator.func_78374_a((float)(j + 128) - f, (float)(k + 0) + f, -0.0099999997764825821D, 1.0D, 0.0D);
        tessellator.func_78374_a((float)(j + 0) + f, (float)(k + 0) + f, -0.0099999997764825821D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        p_78319_2_.func_78342_b(p_78319_2_.func_78341_b("/misc/mapicons.png"));
        for(Iterator iterator = p_78319_3_.field_76203_h.iterator(); iterator.hasNext(); GL11.glPopMatrix())
        {
            MapCoord mapcoord = (MapCoord)iterator.next();
            GL11.glPushMatrix();
            GL11.glTranslatef((float)j + (float)mapcoord.field_76214_b / 2.0F + 64F, (float)k + (float)mapcoord.field_76215_c / 2.0F + 64F, -0.02F);
            GL11.glRotatef((float)(mapcoord.field_76212_d * 360) / 16F, 0.0F, 0.0F, 1.0F);
            GL11.glScalef(4F, 4F, 3F);
            GL11.glTranslatef(-0.125F, 0.125F, 0.0F);
            float f1 = (float)(mapcoord.field_76216_a % 4 + 0) / 4F;
            float f2 = (float)(mapcoord.field_76216_a / 4 + 0) / 4F;
            float f3 = (float)(mapcoord.field_76216_a % 4 + 1) / 4F;
            float f4 = (float)(mapcoord.field_76216_a / 4 + 1) / 4F;
            tessellator.func_78382_b();
            tessellator.func_78374_a(-1D, 1.0D, 0.0D, f1, f2);
            tessellator.func_78374_a(1.0D, 1.0D, 0.0D, f3, f2);
            tessellator.func_78374_a(1.0D, -1D, 0.0D, f3, f4);
            tessellator.func_78374_a(-1D, -1D, 0.0D, f1, f4);
            tessellator.func_78381_a();
        }

        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -0.04F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        field_78320_d.func_78276_b(p_78319_3_.field_76190_i, j, k, 0xff000000);
        GL11.glPopMatrix();
    }
}
