// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            ServerGUI, DedicatedServer

class ServerGuiCommandListener
    implements ActionListener
{

    final JTextField field_79027_a; /* synthetic field */
    final ServerGUI field_79026_b; /* synthetic field */

    ServerGuiCommandListener(ServerGUI p_i4104_1_, JTextField p_i4104_2_)
    {
        field_79026_b = p_i4104_1_;
        field_79027_a = p_i4104_2_;
        super();
    }

    public void actionPerformed(ActionEvent p_actionPerformed_1_)
    {
        String s = field_79027_a.getText().trim();
        if(s.length() > 0)
        {
            ServerGUI.func_79004_a(field_79026_b).func_71331_a(s, MinecraftServer.func_71276_C());
        }
        field_79027_a.setText("");
    }
}
