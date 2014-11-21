// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            IProgressUpdate, MinecraftError, ScaledResolution, Tessellator, 
//            RenderEngine, FontRenderer

public class LoadingScreenRenderer
    implements IProgressUpdate
{

    private String field_73727_a;
    private Minecraft field_73725_b;
    private String field_73726_c;
    private long field_73723_d;
    private boolean field_73724_e;

    public LoadingScreenRenderer(Minecraft p_i3004_1_)
    {
        field_73727_a = "";
        field_73726_c = "";
        field_73723_d = Minecraft.func_71386_F();
        field_73724_e = false;
        field_73725_b = p_i3004_1_;
    }

    public void func_73721_b(String p_73721_1_)
    {
        field_73724_e = false;
        func_73722_d(p_73721_1_);
    }

    public void func_73720_a(String p_73720_1_)
    {
        field_73724_e = true;
        func_73722_d(p_73720_1_);
    }

    public void func_73722_d(String p_73722_1_)
    {
        field_73726_c = p_73722_1_;
        if(!field_73725_b.field_71425_J)
        {
            if(field_73724_e)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        } else
        {
            ScaledResolution scaledresolution = new ScaledResolution(field_73725_b.field_71474_y, field_73725_b.field_71443_c, field_73725_b.field_71440_d);
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, scaledresolution.func_78327_c(), scaledresolution.func_78324_d(), 0.0D, 100D, 300D);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -200F);
            return;
        }
    }

    public void func_73719_c(String p_73719_1_)
    {
        if(!field_73725_b.field_71425_J)
        {
            if(field_73724_e)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        } else
        {
            field_73723_d = 0L;
            field_73727_a = p_73719_1_;
            func_73718_a(-1);
            field_73723_d = 0L;
            return;
        }
    }

    public void func_73718_a(int p_73718_1_)
    {
        if(!field_73725_b.field_71425_J)
        {
            if(field_73724_e)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        }
        long l = Minecraft.func_71386_F();
        if(l - field_73723_d < 100L)
        {
            return;
        }
        field_73723_d = l;
        ScaledResolution scaledresolution = new ScaledResolution(field_73725_b.field_71474_y, field_73725_b.field_71443_c, field_73725_b.field_71440_d);
        int i = scaledresolution.func_78326_a();
        int j = scaledresolution.func_78328_b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.func_78327_c(), scaledresolution.func_78324_d(), 0.0D, 100D, 300D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
        GL11.glClear(16640);
        Tessellator tessellator = Tessellator.field_78398_a;
        int k = field_73725_b.field_71446_o.func_78341_b("/gui/background.png");
        GL11.glBindTexture(3553, k);
        float f = 32F;
        tessellator.func_78382_b();
        tessellator.func_78378_d(0x404040);
        tessellator.func_78374_a(0.0D, j, 0.0D, 0.0D, (float)j / f);
        tessellator.func_78374_a(i, j, 0.0D, (float)i / f, (float)j / f);
        tessellator.func_78374_a(i, 0.0D, 0.0D, (float)i / f, 0.0D);
        tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        if(p_73718_1_ >= 0)
        {
            byte byte0 = 100;
            byte byte1 = 2;
            int i1 = i / 2 - byte0 / 2;
            int j1 = j / 2 + 16;
            GL11.glDisable(3553);
            tessellator.func_78382_b();
            tessellator.func_78378_d(0x808080);
            tessellator.func_78377_a(i1, j1, 0.0D);
            tessellator.func_78377_a(i1, j1 + byte1, 0.0D);
            tessellator.func_78377_a(i1 + byte0, j1 + byte1, 0.0D);
            tessellator.func_78377_a(i1 + byte0, j1, 0.0D);
            tessellator.func_78378_d(0x80ff80);
            tessellator.func_78377_a(i1, j1, 0.0D);
            tessellator.func_78377_a(i1, j1 + byte1, 0.0D);
            tessellator.func_78377_a(i1 + p_73718_1_, j1 + byte1, 0.0D);
            tessellator.func_78377_a(i1 + p_73718_1_, j1, 0.0D);
            tessellator.func_78381_a();
            GL11.glEnable(3553);
        }
        field_73725_b.field_71466_p.func_78261_a(field_73726_c, (i - field_73725_b.field_71466_p.func_78256_a(field_73726_c)) / 2, j / 2 - 4 - 16, 0xffffff);
        field_73725_b.field_71466_p.func_78261_a(field_73727_a, (i - field_73725_b.field_71466_p.func_78256_a(field_73727_a)) / 2, (j / 2 - 4) + 8, 0xffffff);
        Display.update();
        try
        {
            Thread.yield();
        }
        catch(Exception exception) { }
    }

    public void func_73717_a()
    {
    }
}
