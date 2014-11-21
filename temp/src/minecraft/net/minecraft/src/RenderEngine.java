// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            IntHashMap, GLAllocation, TexturePackList, TexturePackBase, 
//            GameSettings, ThreadDownloadImageData, TextureFX, ImageBuffer

public class RenderEngine
{

    private HashMap field_78362_c;
    private HashMap field_78359_d;
    private IntHashMap field_78360_e;
    private IntBuffer field_78357_f;
    private ByteBuffer field_78358_g;
    private java.util.List field_78367_h;
    private Map field_78368_i;
    private GameSettings field_78365_j;
    public boolean field_78363_a;
    public boolean field_78361_b;
    private TexturePackList field_78366_k;
    private BufferedImage field_78364_l;

    public RenderEngine(TexturePackList p_i3192_1_, GameSettings p_i3192_2_)
    {
        field_78362_c = new HashMap();
        field_78359_d = new HashMap();
        field_78360_e = new IntHashMap();
        field_78357_f = GLAllocation.func_74527_f(1);
        field_78358_g = GLAllocation.func_74524_c(0x1000000);
        field_78367_h = new ArrayList();
        field_78368_i = new HashMap();
        field_78363_a = false;
        field_78361_b = false;
        field_78364_l = new BufferedImage(64, 64, 2);
        field_78366_k = p_i3192_1_;
        field_78365_j = p_i3192_2_;
        Graphics g = field_78364_l.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 64, 64);
        g.setColor(Color.BLACK);
        g.drawString("missingtex", 1, 10);
        g.dispose();
    }

    public int[] func_78346_a(String p_78346_1_)
    {
        TexturePackBase texturepackbase = field_78366_k.func_77292_e();
        int ai[] = (int[])field_78359_d.get(p_78346_1_);
        if(ai != null)
        {
            return ai;
        }
        try
        {
            int ai1[] = null;
            if(p_78346_1_.startsWith("##"))
            {
                ai1 = func_78348_b(func_78354_c(func_78345_a(texturepackbase.func_77532_a(p_78346_1_.substring(2)))));
            } else
            if(p_78346_1_.startsWith("%clamp%"))
            {
                field_78363_a = true;
                ai1 = func_78348_b(func_78345_a(texturepackbase.func_77532_a(p_78346_1_.substring(7))));
                field_78363_a = false;
            } else
            if(p_78346_1_.startsWith("%blur%"))
            {
                field_78361_b = true;
                field_78363_a = true;
                ai1 = func_78348_b(func_78345_a(texturepackbase.func_77532_a(p_78346_1_.substring(6))));
                field_78363_a = false;
                field_78361_b = false;
            } else
            {
                InputStream inputstream = texturepackbase.func_77532_a(p_78346_1_);
                if(inputstream == null)
                {
                    ai1 = func_78348_b(field_78364_l);
                } else
                {
                    ai1 = func_78348_b(func_78345_a(inputstream));
                }
            }
            field_78359_d.put(p_78346_1_, ai1);
            return ai1;
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        int ai2[] = func_78348_b(field_78364_l);
        field_78359_d.put(p_78346_1_, ai2);
        return ai2;
    }

    private int[] func_78348_b(BufferedImage p_78348_1_)
    {
        int i = p_78348_1_.getWidth();
        int j = p_78348_1_.getHeight();
        int ai[] = new int[i * j];
        p_78348_1_.getRGB(0, 0, i, j, ai, 0, i);
        return ai;
    }

    private int[] func_78340_a(BufferedImage p_78340_1_, int p_78340_2_[])
    {
        int i = p_78340_1_.getWidth();
        int j = p_78340_1_.getHeight();
        p_78340_1_.getRGB(0, 0, i, j, p_78340_2_, 0, i);
        return p_78340_2_;
    }

    public int func_78341_b(String p_78341_1_)
    {
        Object obj = (Integer)field_78362_c.get(p_78341_1_);
        if(obj != null)
        {
            return ((Integer) (obj)).intValue();
        }
        obj = field_78366_k.func_77292_e();
        try
        {
            field_78357_f.clear();
            GLAllocation.func_74528_a(field_78357_f);
            int i = field_78357_f.get(0);
            if(p_78341_1_.startsWith("##"))
            {
                func_78351_a(func_78354_c(func_78345_a(((TexturePackBase) (obj)).func_77532_a(p_78341_1_.substring(2)))), i);
            } else
            if(p_78341_1_.startsWith("%clamp%"))
            {
                field_78363_a = true;
                func_78351_a(func_78345_a(((TexturePackBase) (obj)).func_77532_a(p_78341_1_.substring(7))), i);
                field_78363_a = false;
            } else
            if(p_78341_1_.startsWith("%blur%"))
            {
                field_78361_b = true;
                func_78351_a(func_78345_a(((TexturePackBase) (obj)).func_77532_a(p_78341_1_.substring(6))), i);
                field_78361_b = false;
            } else
            if(p_78341_1_.startsWith("%blurclamp%"))
            {
                field_78361_b = true;
                field_78363_a = true;
                func_78351_a(func_78345_a(((TexturePackBase) (obj)).func_77532_a(p_78341_1_.substring(11))), i);
                field_78361_b = false;
                field_78363_a = false;
            } else
            {
                InputStream inputstream = ((TexturePackBase) (obj)).func_77532_a(p_78341_1_);
                if(inputstream == null)
                {
                    func_78351_a(field_78364_l, i);
                } else
                {
                    func_78351_a(func_78345_a(inputstream), i);
                }
            }
            field_78362_c.put(p_78341_1_, Integer.valueOf(i));
            return i;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        GLAllocation.func_74528_a(field_78357_f);
        int j = field_78357_f.get(0);
        func_78351_a(field_78364_l, j);
        field_78362_c.put(p_78341_1_, Integer.valueOf(j));
        return j;
    }

    private BufferedImage func_78354_c(BufferedImage p_78354_1_)
    {
        int i = p_78354_1_.getWidth() / 16;
        BufferedImage bufferedimage = new BufferedImage(16, p_78354_1_.getHeight() * i, 2);
        Graphics g = bufferedimage.getGraphics();
        for(int j = 0; j < i; j++)
        {
            g.drawImage(p_78354_1_, -j * 16, j * p_78354_1_.getHeight(), null);
        }

        g.dispose();
        return bufferedimage;
    }

    public int func_78353_a(BufferedImage p_78353_1_)
    {
        field_78357_f.clear();
        GLAllocation.func_74528_a(field_78357_f);
        int i = field_78357_f.get(0);
        func_78351_a(p_78353_1_, i);
        field_78360_e.func_76038_a(i, p_78353_1_);
        return i;
    }

    public void func_78351_a(BufferedImage p_78351_1_, int p_78351_2_)
    {
        GL11.glBindTexture(3553, p_78351_2_);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        if(field_78361_b)
        {
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        }
        if(field_78363_a)
        {
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
        } else
        {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
        int i = p_78351_1_.getWidth();
        int j = p_78351_1_.getHeight();
        int ai[] = new int[i * j];
        byte abyte0[] = new byte[i * j * 4];
        p_78351_1_.getRGB(0, 0, i, j, ai, 0, i);
        for(int k = 0; k < ai.length; k++)
        {
            int l = ai[k] >> 24 & 0xff;
            int i1 = ai[k] >> 16 & 0xff;
            int j1 = ai[k] >> 8 & 0xff;
            int k1 = ai[k] & 0xff;
            if(field_78365_j != null && field_78365_j.field_74337_g)
            {
                int l1 = (i1 * 30 + j1 * 59 + k1 * 11) / 100;
                int i2 = (i1 * 30 + j1 * 70) / 100;
                int j2 = (i1 * 30 + k1 * 70) / 100;
                i1 = l1;
                j1 = i2;
                k1 = j2;
            }
            abyte0[k * 4 + 0] = (byte)i1;
            abyte0[k * 4 + 1] = (byte)j1;
            abyte0[k * 4 + 2] = (byte)k1;
            abyte0[k * 4 + 3] = (byte)l;
        }

        field_78358_g.clear();
        field_78358_g.put(abyte0);
        field_78358_g.position(0).limit(abyte0.length);
        GL11.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, field_78358_g);
    }

    public void func_78349_a(int p_78349_1_[], int p_78349_2_, int p_78349_3_, int p_78349_4_)
    {
        GL11.glBindTexture(3553, p_78349_4_);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        if(field_78361_b)
        {
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        }
        if(field_78363_a)
        {
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
        } else
        {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
        byte abyte0[] = new byte[p_78349_2_ * p_78349_3_ * 4];
        for(int i = 0; i < p_78349_1_.length; i++)
        {
            int j = p_78349_1_[i] >> 24 & 0xff;
            int k = p_78349_1_[i] >> 16 & 0xff;
            int l = p_78349_1_[i] >> 8 & 0xff;
            int i1 = p_78349_1_[i] & 0xff;
            if(field_78365_j != null && field_78365_j.field_74337_g)
            {
                int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
                int k1 = (k * 30 + l * 70) / 100;
                int l1 = (k * 30 + i1 * 70) / 100;
                k = j1;
                l = k1;
                i1 = l1;
            }
            abyte0[i * 4 + 0] = (byte)k;
            abyte0[i * 4 + 1] = (byte)l;
            abyte0[i * 4 + 2] = (byte)i1;
            abyte0[i * 4 + 3] = (byte)j;
        }

        field_78358_g.clear();
        field_78358_g.put(abyte0);
        field_78358_g.position(0).limit(abyte0.length);
        GL11.glTexSubImage2D(3553, 0, 0, 0, p_78349_2_, p_78349_3_, 6408, 5121, field_78358_g);
    }

    public void func_78344_a(int p_78344_1_)
    {
        field_78360_e.func_76049_d(p_78344_1_);
        field_78357_f.clear();
        field_78357_f.put(p_78344_1_);
        field_78357_f.flip();
        GL11.glDeleteTextures(field_78357_f);
    }

    public int func_78350_a(String p_78350_1_, String p_78350_2_)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_78368_i.get(p_78350_1_);
        if(threaddownloadimagedata != null && threaddownloadimagedata.field_78462_a != null && !threaddownloadimagedata.field_78459_d)
        {
            if(threaddownloadimagedata.field_78461_c < 0)
            {
                threaddownloadimagedata.field_78461_c = func_78353_a(threaddownloadimagedata.field_78462_a);
            } else
            {
                func_78351_a(threaddownloadimagedata.field_78462_a, threaddownloadimagedata.field_78461_c);
            }
            threaddownloadimagedata.field_78459_d = true;
        }
        if(threaddownloadimagedata == null || threaddownloadimagedata.field_78461_c < 0)
        {
            if(p_78350_2_ == null)
            {
                return -1;
            } else
            {
                return func_78341_b(p_78350_2_);
            }
        } else
        {
            return threaddownloadimagedata.field_78461_c;
        }
    }

    public ThreadDownloadImageData func_78356_a(String p_78356_1_, ImageBuffer p_78356_2_)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_78368_i.get(p_78356_1_);
        if(threaddownloadimagedata == null)
        {
            field_78368_i.put(p_78356_1_, new ThreadDownloadImageData(p_78356_1_, p_78356_2_));
        } else
        {
            threaddownloadimagedata.field_78460_b++;
        }
        return threaddownloadimagedata;
    }

    public void func_78347_c(String p_78347_1_)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_78368_i.get(p_78347_1_);
        if(threaddownloadimagedata != null)
        {
            threaddownloadimagedata.field_78460_b--;
            if(threaddownloadimagedata.field_78460_b == 0)
            {
                if(threaddownloadimagedata.field_78461_c >= 0)
                {
                    func_78344_a(threaddownloadimagedata.field_78461_c);
                }
                field_78368_i.remove(p_78347_1_);
            }
        }
    }

    public void func_78355_a(TextureFX p_78355_1_)
    {
        field_78367_h.add(p_78355_1_);
        p_78355_1_.func_76846_a();
    }

    public void func_78343_a()
    {
        int i = -1;
        for(Iterator iterator = field_78367_h.iterator(); iterator.hasNext();)
        {
            TextureFX texturefx = (TextureFX)iterator.next();
            texturefx.field_76851_c = field_78365_j.field_74337_g;
            texturefx.func_76846_a();
            field_78358_g.clear();
            field_78358_g.put(texturefx.field_76852_a);
            field_78358_g.position(0).limit(texturefx.field_76852_a.length);
            if(texturefx.field_76850_b != i)
            {
                texturefx.func_76845_a(this);
                i = texturefx.field_76850_b;
            }
            int j = 0;
            while(j < texturefx.field_76849_e) 
            {
                for(int k = 0; k < texturefx.field_76849_e; k++)
                {
                    GL11.glTexSubImage2D(3553, 0, (texturefx.field_76850_b % 16) * 16 + j * 16, (texturefx.field_76850_b / 16) * 16 + k * 16, 16, 16, 6408, 5121, field_78358_g);
                }

                j++;
            }
        }

    }

    public void func_78352_b()
    {
        TexturePackBase texturepackbase = field_78366_k.func_77292_e();
        int i;
        BufferedImage bufferedimage;
        for(Iterator iterator = field_78360_e.func_76039_d().iterator(); iterator.hasNext(); func_78351_a(bufferedimage, i))
        {
            i = ((Integer)iterator.next()).intValue();
            bufferedimage = (BufferedImage)field_78360_e.func_76041_a(i);
        }

        for(Iterator iterator1 = field_78368_i.values().iterator(); iterator1.hasNext();)
        {
            ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)iterator1.next();
            threaddownloadimagedata.field_78459_d = false;
        }

        for(Iterator iterator2 = field_78362_c.keySet().iterator(); iterator2.hasNext();)
        {
            String s = (String)iterator2.next();
            try
            {
                BufferedImage bufferedimage1;
                if(s.startsWith("##"))
                {
                    bufferedimage1 = func_78354_c(func_78345_a(texturepackbase.func_77532_a(s.substring(2))));
                } else
                if(s.startsWith("%clamp%"))
                {
                    field_78363_a = true;
                    bufferedimage1 = func_78345_a(texturepackbase.func_77532_a(s.substring(7)));
                } else
                if(s.startsWith("%blur%"))
                {
                    field_78361_b = true;
                    bufferedimage1 = func_78345_a(texturepackbase.func_77532_a(s.substring(6)));
                } else
                if(s.startsWith("%blurclamp%"))
                {
                    field_78361_b = true;
                    field_78363_a = true;
                    bufferedimage1 = func_78345_a(texturepackbase.func_77532_a(s.substring(11)));
                } else
                {
                    bufferedimage1 = func_78345_a(texturepackbase.func_77532_a(s));
                }
                int j = ((Integer)field_78362_c.get(s)).intValue();
                func_78351_a(bufferedimage1, j);
                field_78361_b = false;
                field_78363_a = false;
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }

        for(Iterator iterator3 = field_78359_d.keySet().iterator(); iterator3.hasNext();)
        {
            String s1 = (String)iterator3.next();
            try
            {
                BufferedImage bufferedimage2;
                if(s1.startsWith("##"))
                {
                    bufferedimage2 = func_78354_c(func_78345_a(texturepackbase.func_77532_a(s1.substring(2))));
                } else
                if(s1.startsWith("%clamp%"))
                {
                    field_78363_a = true;
                    bufferedimage2 = func_78345_a(texturepackbase.func_77532_a(s1.substring(7)));
                } else
                if(s1.startsWith("%blur%"))
                {
                    field_78361_b = true;
                    bufferedimage2 = func_78345_a(texturepackbase.func_77532_a(s1.substring(6)));
                } else
                {
                    bufferedimage2 = func_78345_a(texturepackbase.func_77532_a(s1));
                }
                func_78340_a(bufferedimage2, (int[])field_78359_d.get(s1));
                field_78361_b = false;
                field_78363_a = false;
            }
            catch(IOException ioexception1)
            {
                ioexception1.printStackTrace();
            }
        }

    }

    private BufferedImage func_78345_a(InputStream p_78345_1_)
        throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(p_78345_1_);
        p_78345_1_.close();
        return bufferedimage;
    }

    public void func_78342_b(int p_78342_1_)
    {
        if(p_78342_1_ < 0)
        {
            return;
        } else
        {
            GL11.glBindTexture(3553, p_78342_1_);
            return;
        }
    }
}
