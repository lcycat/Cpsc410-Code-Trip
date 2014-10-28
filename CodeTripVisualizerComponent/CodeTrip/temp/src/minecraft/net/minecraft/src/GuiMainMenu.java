// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, RenderEngine, StringTranslate, GuiButton, 
//            GuiButtonLanguage, ISaveFormat, GuiOptions, GuiLanguage, 
//            GuiSelectWorld, GuiMultiplayer, GuiTexturePacks, DemoWorldServer, 
//            WorldInfo, Tessellator, MathHelper, FontRenderer

public class GuiMainMenu extends GuiScreen
{

    private static final Random field_73976_a = new Random();
    private float field_73974_b;
    private String field_73975_c;
    private GuiButton field_73973_d;
    private int field_73979_m;
    private int field_73977_n;
    private static final String field_73978_o[] = {
        "/title/bg/panorama0.png", "/title/bg/panorama1.png", "/title/bg/panorama2.png", "/title/bg/panorama3.png", "/title/bg/panorama4.png", "/title/bg/panorama5.png"
    };

    public GuiMainMenu()
    {
        field_73974_b = 0.0F;
        field_73979_m = 0;
        field_73975_c = "missingno";
        BufferedReader bufferedreader = null;
        try
        {
            ArrayList arraylist = new ArrayList();
            bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.GuiMainMenu.class).getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));
            do
            {
                String s;
                if((s = bufferedreader.readLine()) == null)
                {
                    break;
                }
                s = s.trim();
                if(s.length() > 0)
                {
                    arraylist.add(s);
                }
            } while(true);
            do
            {
                field_73975_c = (String)arraylist.get(field_73976_a.nextInt(arraylist.size()));
            } while(field_73975_c.hashCode() == 0x77f432f);
        }
        catch(IOException ioexception) { }
        finally
        {
            if(bufferedreader != null)
            {
                try
                {
                    bufferedreader.close();
                }
                catch(IOException ioexception1) { }
            }
        }
        field_73974_b = field_73976_a.nextFloat();
    }

    public void func_73876_c()
    {
        field_73979_m++;
    }

    public boolean func_73868_f()
    {
        return false;
    }

    protected void func_73869_a(char c, int i)
    {
    }

    public void func_73866_w_()
    {
        field_73977_n = field_73882_e.field_71446_o.func_78353_a(new java.awt.image.BufferedImage(256, 256, 2));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if(calendar.get(2) + 1 == 11 && calendar.get(5) == 9)
        {
            field_73975_c = "Happy birthday, ez!";
        } else
        if(calendar.get(2) + 1 == 6 && calendar.get(5) == 1)
        {
            field_73975_c = "Happy birthday, Notch!";
        } else
        if(calendar.get(2) + 1 == 12 && calendar.get(5) == 24)
        {
            field_73975_c = "Merry X-mas!";
        } else
        if(calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
        {
            field_73975_c = "Happy new year!";
        }
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        int i = field_73881_g / 4 + 48;
        if(field_73882_e.func_71355_q())
        {
            func_73972_b(i, 24, stringtranslate);
        } else
        {
            func_73969_a(i, 24, stringtranslate);
        }
        field_73887_h.add(new GuiButton(3, field_73880_f / 2 - 100, i + 48, stringtranslate.func_74805_b("menu.mods")));
        if(field_73882_e.field_71448_m)
        {
            field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, i + 72, stringtranslate.func_74805_b("menu.options")));
        } else
        {
            field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, i + 72 + 12, 98, 20, stringtranslate.func_74805_b("menu.options")));
            field_73887_h.add(new GuiButton(4, field_73880_f / 2 + 2, i + 72 + 12, 98, 20, stringtranslate.func_74805_b("menu.quit")));
        }
        field_73887_h.add(new GuiButtonLanguage(5, field_73880_f / 2 - 124, i + 72 + 12));
    }

    private void func_73969_a(int p_73969_1_, int p_73969_2_, StringTranslate p_73969_3_)
    {
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, p_73969_1_, p_73969_3_.func_74805_b("menu.singleplayer")));
        field_73887_h.add(new GuiButton(2, field_73880_f / 2 - 100, p_73969_1_ + p_73969_2_ * 1, p_73969_3_.func_74805_b("menu.multiplayer")));
    }

    private void func_73972_b(int p_73972_1_, int p_73972_2_, StringTranslate p_73972_3_)
    {
        field_73887_h.add(new GuiButton(11, field_73880_f / 2 - 100, p_73972_1_, p_73972_3_.func_74805_b("menu.playdemo")));
        field_73887_h.add(field_73973_d = new GuiButton(12, field_73880_f / 2 - 100, p_73972_1_ + p_73972_2_ * 1, p_73972_3_.func_74805_b("menu.resetdemo")));
        ISaveFormat isaveformat = field_73882_e.func_71359_d();
        WorldInfo worldinfo = isaveformat.func_75803_c("Demo_World");
        if(worldinfo == null)
        {
            field_73973_d.field_73742_g = false;
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(new GuiOptions(this, field_73882_e.field_71474_y));
        }
        if(p_73875_1_.field_73741_f == 5)
        {
            field_73882_e.func_71373_a(new GuiLanguage(this, field_73882_e.field_71474_y));
        }
        if(p_73875_1_.field_73741_f == 1)
        {
            field_73882_e.func_71373_a(new GuiSelectWorld(this));
        }
        if(p_73875_1_.field_73741_f == 2)
        {
            field_73882_e.func_71373_a(new GuiMultiplayer(this));
        }
        if(p_73875_1_.field_73741_f == 3)
        {
            field_73882_e.func_71373_a(new GuiTexturePacks(this));
        }
        if(p_73875_1_.field_73741_f == 4)
        {
            field_73882_e.func_71400_g();
        }
        if(p_73875_1_.field_73741_f == 11)
        {
            field_73882_e.func_71371_a("Demo_World", "Demo_World", DemoWorldServer.field_73071_a);
        }
        if(p_73875_1_.field_73741_f == 12)
        {
            ISaveFormat isaveformat = field_73882_e.func_71359_d();
            WorldInfo worldinfo = isaveformat.func_75803_c("Demo_World");
            if(worldinfo != null)
            {
                GuiYesNo guiyesno = GuiSelectWorld.func_74061_a(this, worldinfo.func_76065_j(), 12);
                field_73882_e.func_71373_a(guiyesno);
            }
        }
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        if(p_73878_1_ && p_73878_2_ == 12)
        {
            ISaveFormat isaveformat = field_73882_e.func_71359_d();
            isaveformat.func_75800_d();
            isaveformat.func_75802_e("Demo_World");
            field_73882_e.func_71373_a(this);
        }
    }

    private void func_73970_b(int p_73970_1_, int p_73970_2_, float p_73970_3_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GLU.gluPerspective(120F, 1.0F, 0.05F, 10F);
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glDisable(2884);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        int i = 8;
        for(int j = 0; j < i * i; j++)
        {
            GL11.glPushMatrix();
            float f = ((float)(j % i) / (float)i - 0.5F) / 64F;
            float f1 = ((float)(j / i) / (float)i - 0.5F) / 64F;
            float f2 = 0.0F;
            GL11.glTranslatef(f, f1, f2);
            GL11.glRotatef(MathHelper.func_76126_a(((float)field_73979_m + p_73970_3_) / 400F) * 25F + 20F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-((float)field_73979_m + p_73970_3_) * 0.1F, 0.0F, 1.0F, 0.0F);
            for(int k = 0; k < 6; k++)
            {
                GL11.glPushMatrix();
                if(k == 1)
                {
                    GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                }
                if(k == 2)
                {
                    GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                }
                if(k == 3)
                {
                    GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                }
                if(k == 4)
                {
                    GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
                }
                if(k == 5)
                {
                    GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                }
                GL11.glBindTexture(3553, field_73882_e.field_71446_o.func_78341_b(field_73978_o[k]));
                tessellator.func_78382_b();
                tessellator.func_78384_a(0xffffff, 255 / (j + 1));
                float f3 = 0.0F;
                tessellator.func_78374_a(-1D, -1D, 1.0D, 0.0F + f3, 0.0F + f3);
                tessellator.func_78374_a(1.0D, -1D, 1.0D, 1.0F - f3, 0.0F + f3);
                tessellator.func_78374_a(1.0D, 1.0D, 1.0D, 1.0F - f3, 1.0F - f3);
                tessellator.func_78374_a(-1D, 1.0D, 1.0D, 0.0F + f3, 1.0F - f3);
                tessellator.func_78381_a();
                GL11.glPopMatrix();
            }

            GL11.glPopMatrix();
            GL11.glColorMask(true, true, true, false);
        }

        tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
        GL11.glColorMask(true, true, true, true);
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        GL11.glDepthMask(true);
        GL11.glEnable(2884);
        GL11.glEnable(3008);
        GL11.glEnable(2929);
    }

    private void func_73968_a(float p_73968_1_)
    {
        GL11.glBindTexture(3553, field_73977_n);
        GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColorMask(true, true, true, false);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        byte byte0 = 3;
        for(int i = 0; i < byte0; i++)
        {
            tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F / (float)(i + 1));
            int j = field_73880_f;
            int k = field_73881_g;
            float f = (float)(i - byte0 / 2) / 256F;
            tessellator.func_78374_a(j, k, field_73735_i, 0.0F + f, 0.0D);
            tessellator.func_78374_a(j, 0.0D, field_73735_i, 1.0F + f, 0.0D);
            tessellator.func_78374_a(0.0D, 0.0D, field_73735_i, 1.0F + f, 1.0D);
            tessellator.func_78374_a(0.0D, k, field_73735_i, 0.0F + f, 1.0D);
        }

        tessellator.func_78381_a();
        GL11.glColorMask(true, true, true, true);
    }

    private void func_73971_c(int p_73971_1_, int p_73971_2_, float p_73971_3_)
    {
        GL11.glViewport(0, 0, 256, 256);
        func_73970_b(p_73971_1_, p_73971_2_, p_73971_3_);
        GL11.glDisable(3553);
        GL11.glEnable(3553);
        func_73968_a(p_73971_3_);
        func_73968_a(p_73971_3_);
        func_73968_a(p_73971_3_);
        func_73968_a(p_73971_3_);
        func_73968_a(p_73971_3_);
        func_73968_a(p_73971_3_);
        func_73968_a(p_73971_3_);
        func_73968_a(p_73971_3_);
        GL11.glViewport(0, 0, field_73882_e.field_71443_c, field_73882_e.field_71440_d);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        float f = field_73880_f <= field_73881_g ? 120F / (float)field_73881_g : 120F / (float)field_73880_f;
        float f1 = ((float)field_73881_g * f) / 256F;
        float f2 = ((float)field_73880_f * f) / 256F;
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
        int i = field_73880_f;
        int j = field_73881_g;
        tessellator.func_78374_a(0.0D, j, field_73735_i, 0.5F - f1, 0.5F + f2);
        tessellator.func_78374_a(i, j, field_73735_i, 0.5F - f1, 0.5F - f2);
        tessellator.func_78374_a(i, 0.0D, field_73735_i, 0.5F + f1, 0.5F - f2);
        tessellator.func_78374_a(0.0D, 0.0D, field_73735_i, 0.5F + f1, 0.5F + f2);
        tessellator.func_78381_a();
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73971_c(p_73863_1_, p_73863_2_, p_73863_3_);
        Tessellator tessellator = Tessellator.field_78398_a;
        char c = '\u0112';
        int i = field_73880_f / 2 - c / 2;
        byte byte0 = 30;
        func_73733_a(0, 0, field_73880_f, field_73881_g, 0x80ffffff, 0xffffff);
        func_73733_a(0, 0, field_73880_f, field_73881_g, 0, 0x80000000);
        GL11.glBindTexture(3553, field_73882_e.field_71446_o.func_78341_b("/title/mclogo.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if((double)field_73974_b < 0.0001D)
        {
            func_73729_b(i + 0, byte0 + 0, 0, 0, 99, 44);
            func_73729_b(i + 99, byte0 + 0, 129, 0, 27, 44);
            func_73729_b(i + 99 + 26, byte0 + 0, 126, 0, 3, 44);
            func_73729_b(i + 99 + 26 + 3, byte0 + 0, 99, 0, 26, 44);
            func_73729_b(i + 155, byte0 + 0, 0, 45, 155, 44);
        } else
        {
            func_73729_b(i + 0, byte0 + 0, 0, 0, 155, 44);
            func_73729_b(i + 155, byte0 + 0, 0, 45, 155, 44);
        }
        tessellator.func_78378_d(0xffffff);
        GL11.glPushMatrix();
        GL11.glTranslatef(field_73880_f / 2 + 90, 70F, 0.0F);
        GL11.glRotatef(-20F, 0.0F, 0.0F, 1.0F);
        float f = 1.8F - MathHelper.func_76135_e(MathHelper.func_76126_a(((float)(Minecraft.func_71386_F() % 1000L) / 1000F) * 3.141593F * 2.0F) * 0.1F);
        f = (f * 100F) / (float)(field_73886_k.func_78256_a(field_73975_c) + 32);
        GL11.glScalef(f, f, f);
        func_73732_a(field_73886_k, field_73975_c, 0, -8, 0xffff00);
        GL11.glPopMatrix();
        String s = "Minecraft 1.3.1";
        if(field_73882_e.func_71355_q())
        {
            s = (new StringBuilder()).append(s).append(" Demo").toString();
        }
        func_73731_b(field_73886_k, s, 2, field_73881_g - 10, 0xffffff);
        String s1 = "Copyright Mojang AB. Do not distribute!";
        func_73731_b(field_73886_k, s1, field_73880_f - field_73886_k.func_78256_a(s1) - 2, field_73881_g - 10, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

}
