// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, GuiButton, SoundManager, GuiParticle, 
//            Tessellator, RenderEngine, EnumOS, FontRenderer

public class GuiScreen extends Gui
{

    protected Minecraft field_73882_e;
    public int field_73880_f;
    public int field_73881_g;
    protected List field_73887_h;
    public boolean field_73885_j;
    protected FontRenderer field_73886_k;
    public GuiParticle field_73884_l;
    private GuiButton field_73883_a;

    public GuiScreen()
    {
        field_73887_h = new ArrayList();
        field_73885_j = false;
        field_73883_a = null;
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        GuiButton guibutton;
        for(Iterator iterator = field_73887_h.iterator(); iterator.hasNext(); guibutton.func_73737_a(field_73882_e, p_73863_1_, p_73863_2_))
        {
            guibutton = (GuiButton)iterator.next();
        }

    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(p_73869_2_ == 1)
        {
            field_73882_e.func_71373_a(null);
            field_73882_e.func_71381_h();
        }
    }

    public static String func_73870_l()
    {
        try
        {
            java.awt.datatransfer.Transferable transferable = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if(transferable != null && transferable.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.stringFlavor))
            {
                return (String)transferable.getTransferData(java.awt.datatransfer.DataFlavor.stringFlavor);
            }
        }
        catch(Exception exception) { }
        return "";
    }

    public static void func_73865_d(String p_73865_0_)
    {
        try
        {
            java.awt.datatransfer.StringSelection stringselection = new java.awt.datatransfer.StringSelection(p_73865_0_);
            java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
        }
        catch(Exception exception) { }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        if(p_73864_3_ == 0)
        {
            for(int i = 0; i < field_73887_h.size(); i++)
            {
                GuiButton guibutton = (GuiButton)field_73887_h.get(i);
                if(guibutton.func_73736_c(field_73882_e, p_73864_1_, p_73864_2_))
                {
                    field_73883_a = guibutton;
                    field_73882_e.field_71416_A.func_77366_a("random.click", 1.0F, 1.0F);
                    func_73875_a(guibutton);
                }
            }

        }
    }

    protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_)
    {
        if(field_73883_a != null && p_73879_3_ == 0)
        {
            field_73883_a.func_73740_a(p_73879_1_, p_73879_2_);
            field_73883_a = null;
        }
    }

    protected void func_73875_a(GuiButton guibutton)
    {
    }

    public void func_73872_a(Minecraft p_73872_1_, int p_73872_2_, int p_73872_3_)
    {
        field_73884_l = new GuiParticle(p_73872_1_);
        field_73882_e = p_73872_1_;
        field_73886_k = p_73872_1_.field_71466_p;
        field_73880_f = p_73872_2_;
        field_73881_g = p_73872_3_;
        field_73887_h.clear();
        func_73866_w_();
    }

    public void func_73866_w_()
    {
    }

    public void func_73862_m()
    {
        for(; Mouse.next(); func_73867_d()) { }
        for(; Keyboard.next(); func_73860_n()) { }
    }

    public void func_73867_d()
    {
        if(Mouse.getEventButtonState())
        {
            int i = (Mouse.getEventX() * field_73880_f) / field_73882_e.field_71443_c;
            int k = field_73881_g - (Mouse.getEventY() * field_73881_g) / field_73882_e.field_71440_d - 1;
            func_73864_a(i, k, Mouse.getEventButton());
        } else
        {
            int j = (Mouse.getEventX() * field_73880_f) / field_73882_e.field_71443_c;
            int l = field_73881_g - (Mouse.getEventY() * field_73881_g) / field_73882_e.field_71440_d - 1;
            func_73879_b(j, l, Mouse.getEventButton());
        }
    }

    public void func_73860_n()
    {
        if(Keyboard.getEventKeyState())
        {
            if(Keyboard.getEventKey() == 87)
            {
                field_73882_e.func_71352_k();
                return;
            }
            func_73869_a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        }
    }

    public void func_73876_c()
    {
    }

    public void func_73874_b()
    {
    }

    public void func_73873_v_()
    {
        func_73859_b(0);
    }

    public void func_73859_b(int p_73859_1_)
    {
        if(field_73882_e.field_71441_e != null)
        {
            func_73733_a(0, 0, field_73880_f, field_73881_g, 0xc0101010, 0xd0101010);
        } else
        {
            func_73871_c(p_73859_1_);
        }
    }

    public void func_73871_c(int p_73871_1_)
    {
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glBindTexture(3553, field_73882_e.field_71446_o.func_78341_b("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32F;
        tessellator.func_78382_b();
        tessellator.func_78378_d(0x404040);
        tessellator.func_78374_a(0.0D, field_73881_g, 0.0D, 0.0D, (float)field_73881_g / f + (float)p_73871_1_);
        tessellator.func_78374_a(field_73880_f, field_73881_g, 0.0D, (float)field_73880_f / f, (float)field_73881_g / f + (float)p_73871_1_);
        tessellator.func_78374_a(field_73880_f, 0.0D, 0.0D, (float)field_73880_f / f, p_73871_1_);
        tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, p_73871_1_);
        tessellator.func_78381_a();
    }

    public boolean func_73868_f()
    {
        return true;
    }

    public void func_73878_a(boolean flag, int i)
    {
    }

    public static boolean func_73861_o()
    {
        return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) || Minecraft.func_71376_c() == EnumOS.MACOS && (Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220));
    }

    public static boolean func_73877_p()
    {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }
}
