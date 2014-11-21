// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JComponent;
import javax.swing.Timer;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            GuiStatsListener, TcpConnection, WorldServer, ChunkProviderServer

public class GuiStatsComponent extends JComponent
{

    private static final DecimalFormat field_79020_a = new DecimalFormat("########0.000");
    private int field_79018_b[];
    private int field_79019_c;
    private String field_79016_d[];
    private final MinecraftServer field_79017_e;

    public GuiStatsComponent(MinecraftServer p_i4103_1_)
    {
        field_79018_b = new int[256];
        field_79019_c = 0;
        field_79016_d = new String[10];
        field_79017_e = p_i4103_1_;
        setPreferredSize(new Dimension(356, 246));
        setMinimumSize(new Dimension(356, 246));
        setMaximumSize(new Dimension(356, 246));
        (new Timer(500, new GuiStatsListener(this))).start();
        setBackground(Color.BLACK);
    }

    private void func_79014_a()
    {
        int i;
        long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.gc();
        field_79016_d[0] = (new StringBuilder()).append("Memory use: ").append(l / 1024L / 1024L).append(" mb (").append((Runtime.getRuntime().freeMemory() * 100L) / Runtime.getRuntime().maxMemory()).append("% free)").toString();
        field_79016_d[1] = (new StringBuilder()).append("Threads: ").append(TcpConnection.field_74471_a.get()).append(" + ").append(TcpConnection.field_74469_b.get()).toString();
        field_79016_d[2] = (new StringBuilder()).append("Avg tick: ").append(field_79020_a.format(func_79015_a(field_79017_e.field_71311_j) * 9.9999999999999995E-007D)).append(" ms").toString();
        field_79016_d[3] = (new StringBuilder()).append("Avg sent: ").append((int)func_79015_a(field_79017_e.field_71300_f)).append(", Avg size: ").append((int)func_79015_a(field_79017_e.field_71301_g)).toString();
        field_79016_d[4] = (new StringBuilder()).append("Avg rec: ").append((int)func_79015_a(field_79017_e.field_71313_h)).append(", Avg size: ").append((int)func_79015_a(field_79017_e.field_71314_i)).toString();
        if(field_79017_e.field_71305_c == null)
        {
            break MISSING_BLOCK_LABEL_452;
        }
        i = 0;
_L3:
        if(i >= field_79017_e.field_71305_c.length) goto _L2; else goto _L1
_L1:
        field_79016_d[5 + i] = (new StringBuilder()).append("Lvl ").append(i).append(" tick: ").append(field_79020_a.format(func_79015_a(field_79017_e.field_71312_k[i]) * 9.9999999999999995E-007D)).append(" ms").toString();
        if(field_79017_e.field_71305_c[i] == null || field_79017_e.field_71305_c[i].field_73059_b == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        new StringBuilder();
        field_79016_d;
        5 + i;
        JVM INSTR dup2_x1 ;
        JVM INSTR aaload ;
        append();
        ", ";
        append();
        field_79017_e.field_71305_c[i].field_73059_b.func_73148_d();
        append();
        toString();
        JVM INSTR aastore ;
        i++;
          goto _L3
_L2:
        field_79018_b[field_79019_c++ & 0xff] = (int)((func_79015_a(field_79017_e.field_71301_g) * 100D) / 12500D);
        repaint();
        return;
    }

    private double func_79015_a(long p_79015_1_[])
    {
        long l = 0L;
        long al[] = p_79015_1_;
        int i = al.length;
        for(int j = 0; j < i; j++)
        {
            long l1 = al[j];
            l += l1;
        }

        return (double)l / (double)p_79015_1_.length;
    }

    public void paint(Graphics p_paint_1_)
    {
        p_paint_1_.setColor(new Color(0xffffff));
        p_paint_1_.fillRect(0, 0, 356, 246);
        for(int i = 0; i < 256; i++)
        {
            int k = field_79018_b[i + field_79019_c & 0xff];
            p_paint_1_.setColor(new Color(k + 28 << 16));
            p_paint_1_.fillRect(i, 100 - k, 1, k);
        }

        p_paint_1_.setColor(Color.BLACK);
        for(int j = 0; j < field_79016_d.length; j++)
        {
            String s = field_79016_d[j];
            if(s != null)
            {
                p_paint_1_.drawString(s, 32, 116 + j * 16);
            }
        }

    }

    static void func_79013_a(GuiStatsComponent p_79013_0_)
    {
        p_79013_0_.func_79014_a();
    }

}
