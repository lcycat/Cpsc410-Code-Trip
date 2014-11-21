// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;

// Referenced classes of package net.minecraft.src:
//            ThreadDownloadImage, ImageBuffer

public class ThreadDownloadImageData
{

    public BufferedImage field_78462_a;
    public int field_78460_b;
    public int field_78461_c;
    public boolean field_78459_d;

    public ThreadDownloadImageData(String p_i3195_1_, ImageBuffer p_i3195_2_)
    {
        field_78460_b = 1;
        field_78461_c = -1;
        field_78459_d = false;
        (new ThreadDownloadImage(this, p_i3195_1_, p_i3195_2_)).start();
    }
}
