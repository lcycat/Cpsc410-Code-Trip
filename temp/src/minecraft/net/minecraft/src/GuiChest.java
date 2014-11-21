// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerChest, IInventory, StatCollector, 
//            FontRenderer, RenderEngine

public class GuiChest extends GuiContainer
{

    private IInventory field_74220_o;
    private IInventory field_74219_p;
    private int field_74218_q;

    public GuiChest(IInventory p_i3078_1_, IInventory p_i3078_2_)
    {
        super(new ContainerChest(p_i3078_1_, p_i3078_2_));
        field_74218_q = 0;
        field_74220_o = p_i3078_1_;
        field_74219_p = p_i3078_2_;
        field_73885_j = false;
        char c = '\336';
        int i = c - 108;
        field_74218_q = p_i3078_2_.func_70302_i_() / 9;
        field_74195_c = i + field_74218_q * 18;
    }

    protected void func_74189_g()
    {
        field_73886_k.func_78276_b(StatCollector.func_74838_a(field_74219_p.func_70303_b()), 8, 6, 0x404040);
        field_73886_k.func_78276_b(StatCollector.func_74838_a(field_74220_o.func_70303_b()), 8, (field_74195_c - 96) + 2, 0x404040);
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/container.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        int j = (field_73880_f - field_74194_b) / 2;
        int k = (field_73881_g - field_74195_c) / 2;
        func_73729_b(j, k, 0, 0, field_74194_b, field_74218_q * 18 + 17);
        func_73729_b(j, k + field_74218_q * 18 + 17, 0, 126, field_74194_b, 96);
    }
}
