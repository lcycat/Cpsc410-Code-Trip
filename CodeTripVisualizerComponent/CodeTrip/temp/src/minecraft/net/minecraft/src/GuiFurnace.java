// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerFurnace, StatCollector, FontRenderer, 
//            RenderEngine, TileEntityFurnace, InventoryPlayer

public class GuiFurnace extends GuiContainer
{

    private TileEntityFurnace field_74204_o;

    public GuiFurnace(InventoryPlayer p_i3094_1_, TileEntityFurnace p_i3094_2_)
    {
        super(new ContainerFurnace(p_i3094_1_, p_i3094_2_));
        field_74204_o = p_i3094_2_;
    }

    protected void func_74189_g()
    {
        field_73886_k.func_78276_b(StatCollector.func_74838_a("container.furnace"), 60, 6, 0x404040);
        field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, (field_74195_c - 96) + 2, 0x404040);
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/furnace.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        int j = (field_73880_f - field_74194_b) / 2;
        int k = (field_73881_g - field_74195_c) / 2;
        func_73729_b(j, k, 0, 0, field_74194_b, field_74195_c);
        if(field_74204_o.func_70400_i())
        {
            int l = field_74204_o.func_70403_d(12);
            func_73729_b(j + 56, (k + 36 + 12) - l, 176, 12 - l, 14, l + 2);
        }
        int i1 = field_74204_o.func_70397_c(24);
        func_73729_b(j + 79, k + 34, 176, 14, i1 + 1, 16);
    }
}
