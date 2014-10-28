// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StatCollector, GuiSlotStatsGeneral, GuiSlotStatsItem, 
//            GuiSlotStatsBlock, StringTranslate, GuiButton, GuiSlot, 
//            RenderHelper, Item, RenderItem, RenderEngine, 
//            Tessellator, StatFileWriter, FontRenderer

public class GuiStats extends GuiScreen
{

    private static RenderItem field_74152_c = new RenderItem();
    protected GuiScreen field_74154_a;
    protected String field_74151_b;
    private GuiSlotStatsGeneral field_74150_d;
    private GuiSlotStatsItem field_74157_m;
    private GuiSlotStatsBlock field_74155_n;
    private StatFileWriter field_74156_o;
    private GuiSlot field_74153_p;

    public GuiStats(GuiScreen p_i3072_1_, StatFileWriter p_i3072_2_)
    {
        field_74151_b = "Select world";
        field_74153_p = null;
        field_74154_a = p_i3072_1_;
        field_74156_o = p_i3072_2_;
    }

    public void func_73866_w_()
    {
        field_74151_b = StatCollector.func_74838_a("gui.stats");
        field_74150_d = new GuiSlotStatsGeneral(this);
        field_74150_d.func_77220_a(field_73887_h, 1, 1);
        field_74157_m = new GuiSlotStatsItem(this);
        field_74157_m.func_77220_a(field_73887_h, 1, 1);
        field_74155_n = new GuiSlotStatsBlock(this);
        field_74155_n.func_77220_a(field_73887_h, 1, 1);
        field_74153_p = field_74150_d;
        func_74143_g();
    }

    public void func_74143_g()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 + 4, field_73881_g - 28, 150, 20, stringtranslate.func_74805_b("gui.done")));
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 154, field_73881_g - 52, 100, 20, stringtranslate.func_74805_b("stat.generalButton")));
        GuiButton guibutton;
        field_73887_h.add(guibutton = new GuiButton(2, field_73880_f / 2 - 46, field_73881_g - 52, 100, 20, stringtranslate.func_74805_b("stat.blocksButton")));
        GuiButton guibutton1;
        field_73887_h.add(guibutton1 = new GuiButton(3, field_73880_f / 2 + 62, field_73881_g - 52, 100, 20, stringtranslate.func_74805_b("stat.itemsButton")));
        if(field_74155_n.func_77217_a() == 0)
        {
            guibutton.field_73742_g = false;
        }
        if(field_74157_m.func_77217_a() == 0)
        {
            guibutton1.field_73742_g = false;
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(field_74154_a);
        } else
        if(p_73875_1_.field_73741_f == 1)
        {
            field_74153_p = field_74150_d;
        } else
        if(p_73875_1_.field_73741_f == 3)
        {
            field_74153_p = field_74157_m;
        } else
        if(p_73875_1_.field_73741_f == 2)
        {
            field_74153_p = field_74155_n;
        } else
        {
            field_74153_p.func_77219_a(p_73875_1_);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        field_74153_p.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
        func_73732_a(field_73886_k, field_74151_b, field_73880_f / 2, 20, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    private void func_74137_c(int p_74137_1_, int p_74137_2_, int p_74137_3_)
    {
        func_74142_b(p_74137_1_ + 1, p_74137_2_ + 1);
        GL11.glEnable(32826);
        RenderHelper.func_74520_c();
        field_74152_c.func_77019_a(field_73886_k, field_73882_e.field_71446_o, p_74137_3_, 0, Item.field_77698_e[p_74137_3_].func_77617_a(0), p_74137_1_ + 2, p_74137_2_ + 2);
        RenderHelper.func_74518_a();
        GL11.glDisable(32826);
    }

    private void func_74142_b(int p_74142_1_, int p_74142_2_)
    {
        func_74138_c(p_74142_1_, p_74142_2_, 0, 0);
    }

    private void func_74138_c(int p_74138_1_, int p_74138_2_, int p_74138_3_, int p_74138_4_)
    {
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/slot.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a(p_74138_1_ + 0, p_74138_2_ + 18, field_73735_i, (float)(p_74138_3_ + 0) * 0.0078125F, (float)(p_74138_4_ + 18) * 0.0078125F);
        tessellator.func_78374_a(p_74138_1_ + 18, p_74138_2_ + 18, field_73735_i, (float)(p_74138_3_ + 18) * 0.0078125F, (float)(p_74138_4_ + 18) * 0.0078125F);
        tessellator.func_78374_a(p_74138_1_ + 18, p_74138_2_ + 0, field_73735_i, (float)(p_74138_3_ + 18) * 0.0078125F, (float)(p_74138_4_ + 0) * 0.0078125F);
        tessellator.func_78374_a(p_74138_1_ + 0, p_74138_2_ + 0, field_73735_i, (float)(p_74138_3_ + 0) * 0.0078125F, (float)(p_74138_4_ + 0) * 0.0078125F);
        tessellator.func_78381_a();
    }

    static Minecraft func_74130_a(GuiStats p_74130_0_)
    {
        return p_74130_0_.field_73882_e;
    }

    static FontRenderer func_74145_b(GuiStats p_74145_0_)
    {
        return p_74145_0_.field_73886_k;
    }

    static StatFileWriter func_74127_c(GuiStats p_74127_0_)
    {
        return p_74127_0_.field_74156_o;
    }

    static FontRenderer func_74132_d(GuiStats p_74132_0_)
    {
        return p_74132_0_.field_73886_k;
    }

    static FontRenderer func_74128_e(GuiStats p_74128_0_)
    {
        return p_74128_0_.field_73886_k;
    }

    static Minecraft func_74139_f(GuiStats p_74139_0_)
    {
        return p_74139_0_.field_73882_e;
    }

    static void func_74134_a(GuiStats p_74134_0_, int p_74134_1_, int p_74134_2_, int p_74134_3_, int p_74134_4_)
    {
        p_74134_0_.func_74138_c(p_74134_1_, p_74134_2_, p_74134_3_, p_74134_4_);
    }

    static Minecraft func_74133_g(GuiStats p_74133_0_)
    {
        return p_74133_0_.field_73882_e;
    }

    static FontRenderer func_74129_h(GuiStats p_74129_0_)
    {
        return p_74129_0_.field_73886_k;
    }

    static FontRenderer func_74146_i(GuiStats p_74146_0_)
    {
        return p_74146_0_.field_73886_k;
    }

    static FontRenderer func_74135_j(GuiStats p_74135_0_)
    {
        return p_74135_0_.field_73886_k;
    }

    static FontRenderer func_74148_k(GuiStats p_74148_0_)
    {
        return p_74148_0_.field_73886_k;
    }

    static FontRenderer func_74147_l(GuiStats p_74147_0_)
    {
        return p_74147_0_.field_73886_k;
    }

    static void func_74149_a(GuiStats p_74149_0_, int p_74149_1_, int p_74149_2_, int p_74149_3_, int p_74149_4_, int p_74149_5_, int p_74149_6_)
    {
        p_74149_0_.func_73733_a(p_74149_1_, p_74149_2_, p_74149_3_, p_74149_4_, p_74149_5_, p_74149_6_);
    }

    static FontRenderer func_74141_m(GuiStats p_74141_0_)
    {
        return p_74141_0_.field_73886_k;
    }

    static FontRenderer func_74140_n(GuiStats p_74140_0_)
    {
        return p_74140_0_.field_73886_k;
    }

    static void func_74136_b(GuiStats p_74136_0_, int p_74136_1_, int p_74136_2_, int p_74136_3_, int p_74136_4_, int p_74136_5_, int p_74136_6_)
    {
        p_74136_0_.func_73733_a(p_74136_1_, p_74136_2_, p_74136_3_, p_74136_4_, p_74136_5_, p_74136_6_);
    }

    static FontRenderer func_74144_o(GuiStats p_74144_0_)
    {
        return p_74144_0_.field_73886_k;
    }

    static void func_74131_a(GuiStats p_74131_0_, int p_74131_1_, int p_74131_2_, int p_74131_3_)
    {
        p_74131_0_.func_74137_c(p_74131_1_, p_74131_2_, p_74131_3_);
    }

}
