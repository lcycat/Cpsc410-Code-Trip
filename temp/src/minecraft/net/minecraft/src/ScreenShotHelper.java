// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ScreenShotHelper
{

    private static final DateFormat field_74295_a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    private static IntBuffer field_74293_b;
    private static int field_74294_c[];

    public static String func_74291_a(File p_74291_0_, int p_74291_1_, int p_74291_2_)
    {
        return func_74292_a(p_74291_0_, null, p_74291_1_, p_74291_2_);
    }

    public static String func_74292_a(File p_74292_0_, String p_74292_1_, int p_74292_2_, int p_74292_3_)
    {
        try
        {
            File file = new File(p_74292_0_, "screenshots");
            file.mkdir();
            int i = p_74292_2_ * p_74292_3_;
            if(field_74293_b == null || field_74293_b.capacity() < i)
            {
                field_74293_b = BufferUtils.createIntBuffer(i);
                field_74294_c = new int[i];
            }
            GL11.glPixelStorei(3333, 1);
            GL11.glPixelStorei(3317, 1);
            field_74293_b.clear();
            GL11.glReadPixels(0, 0, p_74292_2_, p_74292_3_, 32993, 33639, field_74293_b);
            field_74293_b.get(field_74294_c);
            func_74289_a(field_74294_c, p_74292_2_, p_74292_3_);
            BufferedImage bufferedimage = new BufferedImage(p_74292_2_, p_74292_3_, 1);
            bufferedimage.setRGB(0, 0, p_74292_2_, p_74292_3_, field_74294_c, 0, p_74292_2_);
            File file1;
            if(p_74292_1_ == null)
            {
                file1 = func_74290_a(file);
            } else
            {
                file1 = new File(file, p_74292_1_);
            }
            ImageIO.write(bufferedimage, "png", file1);
            return (new StringBuilder()).append("Saved screenshot as ").append(file1.getName()).toString();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return (new StringBuilder()).append("Failed to save: ").append(exception).toString();
        }
    }

    private static File func_74290_a(File p_74290_0_)
    {
        String s = field_74295_a.format(new Date()).toString();
        int i = 1;
        do
        {
            File file = new File(p_74290_0_, (new StringBuilder()).append(s).append(i != 1 ? (new StringBuilder()).append("_").append(i).toString() : "").append(".png").toString());
            if(!file.exists())
            {
                return file;
            }
            i++;
        } while(true);
    }

    private static void func_74289_a(int p_74289_0_[], int p_74289_1_, int p_74289_2_)
    {
        int ai[] = new int[p_74289_1_];
        int i = p_74289_2_ / 2;
        for(int j = 0; j < i; j++)
        {
            System.arraycopy(p_74289_0_, j * p_74289_1_, ai, 0, p_74289_1_);
            System.arraycopy(p_74289_0_, (p_74289_2_ - 1 - j) * p_74289_1_, p_74289_0_, j * p_74289_1_, p_74289_1_);
            System.arraycopy(ai, 0, p_74289_0_, (p_74289_2_ - 1 - j) * p_74289_1_, p_74289_1_);
        }

    }

}
