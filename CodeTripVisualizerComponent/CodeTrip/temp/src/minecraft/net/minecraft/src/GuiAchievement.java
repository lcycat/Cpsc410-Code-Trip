// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, RenderItem, StatCollector, Achievement, 
//            ScaledResolution, RenderEngine, FontRenderer, RenderHelper

public class GuiAchievement extends Gui
{

    private Minecraft field_73856_a;
    private int field_73854_b;
    private int field_73855_c;
    private String field_73852_d;
    private String field_73853_e;
    private Achievement field_73850_f;
    private long field_73851_g;
    private RenderItem field_73858_h;
    private boolean field_73857_j;

    public GuiAchievement(Minecraft p_i3069_1_)
    {
        field_73856_a = p_i3069_1_;
        field_73858_h = new RenderItem();
    }

    public void func_73846_a(Achievement p_73846_1_)
    {
        field_73852_d = StatCollector.func_74838_a("achievement.get");
        field_73853_e = StatCollector.func_74838_a(p_73846_1_.func_75970_i());
        field_73851_g = Minecraft.func_71386_F();
        field_73850_f = p_73846_1_;
        field_73857_j = false;
    }

    public void func_73848_b(Achievement p_73848_1_)
    {
        field_73852_d = StatCollector.func_74838_a(p_73848_1_.func_75970_i());
        field_73853_e = p_73848_1_.func_75989_e();
        field_73851_g = Minecraft.func_71386_F() - 2500L;
        field_73850_f = p_73848_1_;
        field_73857_j = true;
    }

    private void func_73849_b()
    {
        GL11.glViewport(0, 0, field_73856_a.field_71443_c, field_73856_a.field_71440_d);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        field_73854_b = field_73856_a.field_71443_c;
        field_73855_c = field_73856_a.field_71440_d;
        ScaledResolution scaledresolution = new ScaledResolution(field_73856_a.field_71474_y, field_73856_a.field_71443_c, field_73856_a.field_71440_d);
        field_73854_b = scaledresolution.func_78326_a();
        field_73855_c = scaledresolution.func_78328_b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, field_73854_b, field_73855_c, 0.0D, 1000D, 3000D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000F);
    }

    public void func_73847_a()
    {
        if(field_73850_f == null || field_73851_g == 0L)
        {
            return;
        }
        double d = (double)(Minecraft.func_71386_F() - field_73851_g) / 3000D;
        if(!field_73857_j && (d < 0.0D || d > 1.0D))
        {
            field_73851_g = 0L;
            return;
        }
        func_73849_b();
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        double d1 = d * 2D;
        if(d1 > 1.0D)
        {
            d1 = 2D - d1;
        }
        d1 *= 4D;
        d1 = 1.0D - d1;
        if(d1 < 0.0D)
        {
            d1 = 0.0D;
        }
        d1 *= d1;
        d1 *= d1;
        int i = field_73854_b - 160;
        int j = 0 - (int)(d1 * 36D);
        int k = field_73856_a.field_71446_o.func_78341_b("/achievement/bg.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, k);
        GL11.glDisable(2896);
        func_73729_b(i, j, 96, 202, 160, 32);
        if(field_73857_j)
        {
            field_73856_a.field_71466_p.func_78279_b(field_73853_e, i + 30, j + 7, 120, -1);
        } else
        {
            field_73856_a.field_71466_p.func_78276_b(field_73852_d, i + 30, j + 7, -256);
            field_73856_a.field_71466_p.func_78276_b(field_73853_e, i + 30, j + 18, -1);
        }
        RenderHelper.func_74520_c();
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glEnable(2896);
        field_73858_h.func_77015_a(field_73856_a.field_71466_p, field_73856_a.field_71446_o, field_73850_f.field_75990_d, i + 8, j + 8);
        GL11.glDisable(2896);
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
    }
}
