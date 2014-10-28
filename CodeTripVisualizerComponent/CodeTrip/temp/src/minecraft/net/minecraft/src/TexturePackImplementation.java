// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TexturePackBase, RenderEngine

public abstract class TexturePackImplementation
    implements TexturePackBase
{

    private final String field_77545_e;
    private final String field_77542_f;
    protected final File field_77548_a;
    protected String field_77546_b;
    protected String field_77547_c;
    protected BufferedImage field_77544_d;
    private int field_77543_g;

    protected TexturePackImplementation(String p_i3027_1_, String p_i3027_2_)
    {
        this(p_i3027_1_, null, p_i3027_2_);
    }

    protected TexturePackImplementation(String p_i3028_1_, File p_i3028_2_, String p_i3028_3_)
    {
        field_77543_g = -1;
        field_77545_e = p_i3028_1_;
        field_77542_f = p_i3028_3_;
        field_77548_a = p_i3028_2_;
        func_77539_g();
        func_77540_a();
    }

    private static String func_77541_b(String p_77541_0_)
    {
        if(p_77541_0_ != null && p_77541_0_.length() > 34)
        {
            p_77541_0_ = p_77541_0_.substring(0, 34);
        }
        return p_77541_0_;
    }

    private void func_77539_g()
    {
        InputStream inputstream = null;
        try
        {
            inputstream = func_77532_a("/pack.png");
            field_77544_d = ImageIO.read(inputstream);
        }
        catch(IOException ioexception) { }
        finally
        {
            try
            {
                inputstream.close();
            }
            catch(IOException ioexception1) { }
        }
    }

    protected void func_77540_a()
    {
        InputStream inputstream = null;
        BufferedReader bufferedreader = null;
        try
        {
            inputstream = func_77532_a("/pack.txt");
            bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            field_77546_b = func_77541_b(bufferedreader.readLine());
            field_77547_c = func_77541_b(bufferedreader.readLine());
        }
        catch(IOException ioexception) { }
        finally
        {
            try
            {
                bufferedreader.close();
                inputstream.close();
            }
            catch(IOException ioexception1) { }
        }
    }

    public void func_77533_a(RenderEngine p_77533_1_)
    {
        if(field_77544_d != null && field_77543_g != -1)
        {
            p_77533_1_.func_78344_a(field_77543_g);
        }
    }

    public void func_77535_b(RenderEngine p_77535_1_)
    {
        if(field_77544_d != null)
        {
            if(field_77543_g == -1)
            {
                field_77543_g = p_77535_1_.func_78353_a(field_77544_d);
            }
            p_77535_1_.func_78342_b(field_77543_g);
        } else
        {
            GL11.glBindTexture(3553, p_77535_1_.func_78341_b("/gui/unknown_pack.png"));
        }
    }

    public InputStream func_77532_a(String p_77532_1_)
    {
        return (net.minecraft.src.TexturePackBase.class).getResourceAsStream(p_77532_1_);
    }

    public String func_77536_b()
    {
        return field_77545_e;
    }

    public String func_77538_c()
    {
        return field_77542_f;
    }

    public String func_77531_d()
    {
        return field_77546_b;
    }

    public String func_77537_e()
    {
        return field_77547_c;
    }

    public int func_77534_f()
    {
        return 16;
    }
}
