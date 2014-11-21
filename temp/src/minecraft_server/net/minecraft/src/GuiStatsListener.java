// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Referenced classes of package net.minecraft.src:
//            GuiStatsComponent

class GuiStatsListener
    implements ActionListener
{

    final GuiStatsComponent field_79021_a; /* synthetic field */

    GuiStatsListener(GuiStatsComponent p_i4109_1_)
    {
        field_79021_a = p_i4109_1_;
        super();
    }

    public void actionPerformed(ActionEvent p_actionPerformed_1_)
    {
        GuiStatsComponent.func_79013_a(field_79021_a);
    }
}
