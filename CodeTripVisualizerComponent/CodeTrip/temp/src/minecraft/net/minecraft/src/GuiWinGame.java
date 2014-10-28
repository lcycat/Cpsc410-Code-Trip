// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, EntityClientPlayerMP, Packet205ClientCommand, NetClientHandler, 
//            Session, FontRenderer, Tessellator, RenderEngine

public class GuiWinGame extends GuiScreen
{

    private int field_73990_a;
    private List field_73988_b;
    private int field_73989_c;
    private float field_73987_d;

    public GuiWinGame()
    {
        field_73990_a = 0;
        field_73989_c = 0;
        field_73987_d = 0.5F;
    }

    public void func_73876_c()
    {
        field_73990_a++;
        float f = (float)(field_73989_c + field_73881_g + field_73881_g + 24) / field_73987_d;
        if((float)field_73990_a > f)
        {
            func_73985_g();
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(p_73869_2_ == 1)
        {
            func_73985_g();
        }
    }

    private void func_73985_g()
    {
        field_73882_e.field_71439_g.field_71174_a.func_72552_c(new Packet205ClientCommand(1));
        field_73882_e.func_71373_a(null);
    }

    public boolean func_73868_f()
    {
        return true;
    }

    public void func_73866_w_()
    {
        if(field_73988_b != null)
        {
            return;
        }
        field_73988_b = new ArrayList();
        try
        {
            String s = "";
            String s1 = "\247f\247k\247a\247b";
            char c = '\u0112';
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.GuiWinGame.class).getResourceAsStream("/title/win.txt"), Charset.forName("UTF-8")));
            Random random = new Random(0x7bf7d3L);
            while((s = bufferedreader.readLine()) != null) 
            {
                String s2;
                String s3;
                for(s = s.replaceAll("PLAYERNAME", field_73882_e.field_71449_j.field_74286_b); s.contains(s1); s = (new StringBuilder()).append(s2).append("\247f\247k").append("XXXXXXXX".substring(0, random.nextInt(4) + 3)).append(s3).toString())
                {
                    int i = s.indexOf(s1);
                    s2 = s.substring(0, i);
                    s3 = s.substring(i + s1.length());
                }

                field_73988_b.addAll(field_73882_e.field_71466_p.func_78271_c(s, c));
                field_73988_b.add("");
            }
            for(int j = 0; j < 8; j++)
            {
                field_73988_b.add("");
            }

            bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.GuiWinGame.class).getResourceAsStream("/title/credits.txt"), Charset.forName("UTF-8")));
            while((s = bufferedreader.readLine()) != null) 
            {
                s = s.replaceAll("PLAYERNAME", field_73882_e.field_71449_j.field_74286_b);
                s = s.replaceAll("\t", "    ");
                field_73988_b.addAll(field_73882_e.field_71466_p.func_78271_c(s, c));
                field_73988_b.add("");
            }
            field_73989_c = field_73988_b.size() * 12;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_73986_b(int p_73986_1_, int p_73986_2_, float p_73986_3_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glBindTexture(3553, field_73882_e.field_71446_o.func_78341_b("%blur%/gui/background.png"));
        tessellator.func_78382_b();
        tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
        int i = field_73880_f;
        float f = 0.0F - ((float)field_73990_a + p_73986_3_) * 0.5F * field_73987_d;
        float f1 = (float)field_73881_g - ((float)field_73990_a + p_73986_3_) * 0.5F * field_73987_d;
        float f2 = 0.015625F;
        float f3 = (((float)field_73990_a + p_73986_3_) - 0.0F) * 0.02F;
        float f4 = (float)(field_73989_c + field_73881_g + field_73881_g + 24) / field_73987_d;
        float f5 = (f4 - 20F - ((float)field_73990_a + p_73986_3_)) * 0.005F;
        if(f5 < f3)
        {
            f3 = f5;
        }
        if(f3 > 1.0F)
        {
            f3 = 1.0F;
        }
        f3 *= f3;
        f3 = (f3 * 96F) / 255F;
        tessellator.func_78386_a(f3, f3, f3);
        tessellator.func_78374_a(0.0D, field_73881_g, field_73735_i, 0.0D, f * f2);
        tessellator.func_78374_a(i, field_73881_g, field_73735_i, (float)i * f2, f * f2);
        tessellator.func_78374_a(i, 0.0D, field_73735_i, (float)i * f2, f1 * f2);
        tessellator.func_78374_a(0.0D, 0.0D, field_73735_i, 0.0D, f1 * f2);
        tessellator.func_78381_a();
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73986_b(p_73863_1_, p_73863_2_, p_73863_3_);
        Tessellator tessellator = Tessellator.field_78398_a;
        char c = '\u0112';
        int i = field_73880_f / 2 - c / 2;
        int j = field_73881_g + 50;
        float f = -((float)field_73990_a + p_73863_3_) * field_73987_d;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, f, 0.0F);
        GL11.glBindTexture(3553, field_73882_e.field_71446_o.func_78341_b("/title/mclogo.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        func_73729_b(i, j, 0, 0, 155, 44);
        func_73729_b(i + 155, j, 0, 45, 155, 44);
        tessellator.func_78378_d(0xffffff);
        int k = j + 200;
        for(int l = 0; l < field_73988_b.size(); l++)
        {
            if(l == field_73988_b.size() - 1)
            {
                float f1 = ((float)k + f) - (float)(field_73881_g / 2 - 6);
                if(f1 < 0.0F)
                {
                    GL11.glTranslatef(0.0F, -f1, 0.0F);
                }
            }
            if((float)k + f + 12F + 8F > 0.0F && (float)k + f < (float)field_73881_g)
            {
                String s = (String)field_73988_b.get(l);
                if(s.startsWith("[C]"))
                {
                    field_73886_k.func_78261_a(s.substring(3), i + (c - field_73886_k.func_78256_a(s.substring(3))) / 2, k, 0xffffff);
                } else
                {
                    field_73886_k.field_78289_c.setSeed((long)l * 0xfca99533L + (long)(field_73990_a / 4));
                    field_73886_k.func_78261_a(s, i, k, 0xffffff);
                }
            }
            k += 12;
        }

        GL11.glPopMatrix();
        GL11.glBindTexture(3553, field_73882_e.field_71446_o.func_78341_b("%blur%/misc/vignette.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(0, 769);
        tessellator.func_78382_b();
        tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
        int i1 = field_73880_f;
        int j1 = field_73881_g;
        tessellator.func_78374_a(0.0D, j1, field_73735_i, 0.0D, 1.0D);
        tessellator.func_78374_a(i1, j1, field_73735_i, 1.0D, 1.0D);
        tessellator.func_78374_a(i1, 0.0D, field_73735_i, 1.0D, 0.0D);
        tessellator.func_78374_a(0.0D, 0.0D, field_73735_i, 0.0D, 0.0D);
        tessellator.func_78381_a();
        GL11.glDisable(3042);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
