// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

// Referenced classes of package net.minecraft.src:
//            ServerWindowAdapter, GuiStatsComponent, PlayerListBox, GuiLogOutputHandler, 
//            ServerGuiCommandListener, ServerGuiFocusAdapter, DedicatedServer

public class ServerGUI extends JComponent
{

    public static Logger field_79010_a = Logger.getLogger("Minecraft");
    private static boolean field_79008_b = false;
    private DedicatedServer field_79009_c;

    public static void func_79003_a(DedicatedServer p_79003_0_)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception exception) { }
        ServerGUI servergui = new ServerGUI(p_79003_0_);
        field_79008_b = true;
        JFrame jframe = new JFrame("Minecraft server");
        jframe.add(servergui);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.addWindowListener(new ServerWindowAdapter(p_79003_0_));
    }

    public ServerGUI(DedicatedServer p_i4106_1_)
    {
        field_79009_c = p_i4106_1_;
        setPreferredSize(new Dimension(854, 480));
        setLayout(new BorderLayout());
        try
        {
            add(func_79005_d(), "Center");
            add(func_79006_b(), "West");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private JComponent func_79006_b()
    {
        JPanel jpanel = new JPanel(new BorderLayout());
        jpanel.add(new GuiStatsComponent(field_79009_c), "North");
        jpanel.add(func_79007_c(), "Center");
        jpanel.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
        return jpanel;
    }

    private JComponent func_79007_c()
    {
        PlayerListBox playerlistbox = new PlayerListBox(field_79009_c);
        JScrollPane jscrollpane = new JScrollPane(playerlistbox, 22, 30);
        jscrollpane.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
        return jscrollpane;
    }

    private JComponent func_79005_d()
    {
        JPanel jpanel = new JPanel(new BorderLayout());
        JTextArea jtextarea = new JTextArea();
        field_79010_a.addHandler(new GuiLogOutputHandler(jtextarea));
        JScrollPane jscrollpane = new JScrollPane(jtextarea, 22, 30);
        jtextarea.setEditable(false);
        JTextField jtextfield = new JTextField();
        jtextfield.addActionListener(new ServerGuiCommandListener(this, jtextfield));
        jtextarea.addFocusListener(new ServerGuiFocusAdapter(this));
        jpanel.add(jscrollpane, "Center");
        jpanel.add(jtextfield, "South");
        jpanel.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
        return jpanel;
    }

    static DedicatedServer func_79004_a(ServerGUI p_79004_0_)
    {
        return p_79004_0_.field_79009_c;
    }

}
