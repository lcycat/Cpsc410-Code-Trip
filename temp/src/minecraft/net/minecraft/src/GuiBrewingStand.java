// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerBrewingStand, StatCollector, FontRenderer, 
//            RenderEngine, TileEntityBrewingStand, InventoryPlayer

public class GuiBrewingStand extends GuiContainer
{

    private TileEntityBrewingStand field_74217_o;

    public GuiBrewingStand(InventoryPlayer p_i3092_1_, TileEntityBrewingStand p_i3092_2_)
    {
        super(new ContainerBrewingStand(p_i3092_1_, p_i3092_2_));
        field_74217_o = p_i3092_2_;
    }

    protected void func_74189_g()
    {
        field_73886_k.func_78276_b(StatCollector.func_74838_a("container.brewing"), 56, 6, 0x404040);
        field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, (field_74195_c - 96) + 2, 0x404040);
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/alchemy.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        int j = (field_73880_f - field_74194_b) / 2;
        int k = (field_73881_g - field_74195_c) / 2;
        func_73729_b(j, k, 0, 0, field_74194_b, field_74195_c);
        int l = field_74217_o.func_70355_t_();
        if(l > 0)
        {
            int i1 = (int)(28F * (1.0F - (float)l / 400F));
            if(i1 > 0)
            {
                func_73729_b(j + 97, k + 16, 176, 0, 9, i1);
            }
            int j1 = (l / 2) % 7;
            switch(j1)
            {
            case 6: // '\006'
                i1 = 0;
                break;

            case 5: // '\005'
                i1 = 6;
                break;

            case 4: // '\004'
                i1 = 11;
                break;

            case 3: // '\003'
                i1 = 16;
                break;

            case 2: // '\002'
                i1 = 20;
                break;

            case 1: // '\001'
                i1 = 24;
                break;

            case 0: // '\0'
                i1 = 29;
                break;
            }
            if(i1 > 0)
            {
                func_73729_b(j + 65, (k + 14 + 29) - i1, 185, 29 - i1, 12, i1);
            }
        }
    }
}
