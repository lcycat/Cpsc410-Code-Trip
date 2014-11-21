// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Graphics;
import java.awt.image.*;

// Referenced classes of package net.minecraft.src:
//            ImageBuffer

public class ImageBufferDownload
    implements ImageBuffer
{

    private int field_78438_a[];
    private int field_78436_b;
    private int field_78437_c;

    public ImageBufferDownload()
    {
    }

    public BufferedImage func_78432_a(BufferedImage p_78432_1_)
    {
        if(p_78432_1_ == null)
        {
            return null;
        }
        field_78436_b = 64;
        field_78437_c = 32;
        BufferedImage bufferedimage = new BufferedImage(field_78436_b, field_78437_c, 2);
        Graphics g = bufferedimage.getGraphics();
        g.drawImage(p_78432_1_, 0, 0, null);
        g.dispose();
        field_78438_a = ((DataBufferInt)bufferedimage.getRaster().getDataBuffer()).getData();
        func_78433_b(0, 0, 32, 16);
        func_78434_a(32, 0, 64, 32);
        func_78433_b(0, 16, 64, 32);
        boolean flag = false;
        for(int i = 32; i < 64; i++)
        {
            for(int k = 0; k < 16; k++)
            {
                int i1 = field_78438_a[i + k * 64];
                if((i1 >> 24 & 0xff) < 128)
                {
                    flag = true;
                }
            }

        }

        if(!flag)
        {
            for(int j = 32; j < 64; j++)
            {
                for(int l = 0; l < 16; l++)
                {
                    int j1 = field_78438_a[j + l * 64];
                    boolean flag1;
                    if((j1 >> 24 & 0xff) < 128)
                    {
                        flag1 = true;
                    }
                }

            }

        }
        return bufferedimage;
    }

    private void func_78434_a(int p_78434_1_, int p_78434_2_, int p_78434_3_, int p_78434_4_)
    {
        if(func_78435_c(p_78434_1_, p_78434_2_, p_78434_3_, p_78434_4_))
        {
            return;
        }
        for(int i = p_78434_1_; i < p_78434_3_; i++)
        {
            for(int j = p_78434_2_; j < p_78434_4_; j++)
            {
                field_78438_a[i + j * field_78436_b] &= 0xffffff;
            }

        }

    }

    private void func_78433_b(int p_78433_1_, int p_78433_2_, int p_78433_3_, int p_78433_4_)
    {
        for(int i = p_78433_1_; i < p_78433_3_; i++)
        {
            for(int j = p_78433_2_; j < p_78433_4_; j++)
            {
                field_78438_a[i + j * field_78436_b] |= 0xff000000;
            }

        }

    }

    private boolean func_78435_c(int p_78435_1_, int p_78435_2_, int p_78435_3_, int p_78435_4_)
    {
        for(int i = p_78435_1_; i < p_78435_3_; i++)
        {
            for(int j = p_78435_2_; j < p_78435_4_; j++)
            {
                int k = field_78438_a[i + j * field_78436_b];
                if((k >> 24 & 0xff) < 128)
                {
                    return true;
                }
            }

        }

        return false;
    }
}
