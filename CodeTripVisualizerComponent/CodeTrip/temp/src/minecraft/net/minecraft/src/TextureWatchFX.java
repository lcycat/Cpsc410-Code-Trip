// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            TextureFX, Item, WorldClient, WorldProvider

public class TextureWatchFX extends TextureFX
{

    private Minecraft field_76860_g;
    private int field_76863_h[];
    private int field_76864_i[];
    private double field_76861_j;
    private double field_76862_k;

    public TextureWatchFX(Minecraft p_i3214_1_)
    {
        super(Item.field_77752_aS.func_77617_a(0));
        field_76863_h = new int[256];
        field_76864_i = new int[256];
        field_76860_g = p_i3214_1_;
        field_76847_f = 1;
        try
        {
            BufferedImage bufferedimage = ImageIO.read((net.minecraft.client.Minecraft.class).getResource("/gui/items.png"));
            int i = (field_76850_b % 16) * 16;
            int j = (field_76850_b / 16) * 16;
            bufferedimage.getRGB(i, j, 16, 16, field_76863_h, 0, 16);
            bufferedimage = ImageIO.read((net.minecraft.client.Minecraft.class).getResource("/misc/dial.png"));
            bufferedimage.getRGB(0, 0, 16, 16, field_76864_i, 0, 16);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void func_76846_a()
    {
        double d = 0.0D;
        if(field_76860_g.field_71441_e != null && field_76860_g.field_71439_g != null)
        {
            float f = field_76860_g.field_71441_e.func_72826_c(1.0F);
            d = -f * 3.141593F * 2.0F;
            if(!field_76860_g.field_71441_e.field_73011_w.func_76569_d())
            {
                d = Math.random() * 3.1415927410125732D * 2D;
            }
        }
        double d1;
        for(d1 = d - field_76861_j; d1 < -3.1415926535897931D; d1 += 6.2831853071795862D) { }
        for(; d1 >= 3.1415926535897931D; d1 -= 6.2831853071795862D) { }
        if(d1 < -1D)
        {
            d1 = -1D;
        }
        if(d1 > 1.0D)
        {
            d1 = 1.0D;
        }
        field_76862_k += d1 * 0.10000000000000001D;
        field_76862_k *= 0.80000000000000004D;
        field_76861_j += field_76862_k;
        double d2 = Math.sin(field_76861_j);
        double d3 = Math.cos(field_76861_j);
        for(int i = 0; i < 256; i++)
        {
            int j = field_76863_h[i] >> 24 & 0xff;
            int k = field_76863_h[i] >> 16 & 0xff;
            int l = field_76863_h[i] >> 8 & 0xff;
            int i1 = field_76863_h[i] >> 0 & 0xff;
            if(k == i1 && l == 0 && i1 > 0)
            {
                double d4 = -((double)(i % 16) / 15D - 0.5D);
                double d5 = (double)(i / 16) / 15D - 0.5D;
                int i2 = k;
                int j2 = (int)((d4 * d3 + d5 * d2 + 0.5D) * 16D);
                int k2 = (int)(((d5 * d3 - d4 * d2) + 0.5D) * 16D);
                int l2 = (j2 & 0xf) + (k2 & 0xf) * 16;
                j = field_76864_i[l2] >> 24 & 0xff;
                k = ((field_76864_i[l2] >> 16 & 0xff) * i2) / 255;
                l = ((field_76864_i[l2] >> 8 & 0xff) * i2) / 255;
                i1 = ((field_76864_i[l2] >> 0 & 0xff) * i2) / 255;
            }
            if(field_76851_c)
            {
                int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
                int k1 = (k * 30 + l * 70) / 100;
                int l1 = (k * 30 + i1 * 70) / 100;
                k = j1;
                l = k1;
                i1 = l1;
            }
            field_76852_a[i * 4 + 0] = (byte)k;
            field_76852_a[i * 4 + 1] = (byte)l;
            field_76852_a[i * 4 + 2] = (byte)i1;
            field_76852_a[i * 4 + 3] = (byte)j;
        }

    }
}
