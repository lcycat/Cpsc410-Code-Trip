// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, ServerList, LanServerList, ThreadLanServerFind, 
//            GuiSlotServer, StringTranslate, GuiButton, ServerData, 
//            GuiYesNo, GuiScreenServerList, StatCollector, GuiScreenAddServer, 
//            LanServer, GuiConnecting, ServerAddress, Packet, 
//            ChatAllowedCharacters, FontRenderer

public class GuiMultiplayer extends GuiScreen
{

    private static int field_74027_a = 0;
    private static Object field_74023_b = new Object();
    private GuiScreen field_74025_c;
    private GuiSlotServer field_74022_d;
    private ServerList field_74030_m;
    private int field_74028_n;
    private GuiButton field_74029_o;
    private GuiButton field_74038_p;
    private GuiButton field_74037_q;
    private boolean field_74036_r;
    private boolean field_74035_s;
    private boolean field_74034_t;
    private boolean field_74033_u;
    private String field_74032_v;
    private ServerData field_74031_w;
    private LanServerList field_74041_x;
    private ThreadLanServerFind field_74040_y;
    private int field_74039_z;
    private boolean field_74024_A;
    private List field_74026_B;

    public GuiMultiplayer(GuiScreen p_i3064_1_)
    {
        field_74028_n = -1;
        field_74036_r = false;
        field_74035_s = false;
        field_74034_t = false;
        field_74033_u = false;
        field_74032_v = null;
        field_74031_w = null;
        field_74026_B = Collections.emptyList();
        field_74025_c = p_i3064_1_;
    }

    public void func_73866_w_()
    {
        Keyboard.enableRepeatEvents(true);
        field_73887_h.clear();
        if(!field_74024_A)
        {
            field_74024_A = true;
            field_74030_m = new ServerList(field_73882_e);
            field_74030_m.func_78853_a();
            field_74041_x = new LanServerList();
            try
            {
                field_74040_y = new ThreadLanServerFind(field_74041_x);
                field_74040_y.start();
            }
            catch(Exception exception)
            {
                System.out.println((new StringBuilder()).append("Unable to start LAN server detection: ").append(exception.getMessage()).toString());
            }
            field_74022_d = new GuiSlotServer(this);
        } else
        {
            field_74022_d.func_77207_a(field_73880_f, field_73881_g, 32, field_73881_g - 64);
        }
        func_74016_g();
    }

    public void func_74016_g()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73887_h.add(field_74029_o = new GuiButton(7, field_73880_f / 2 - 154, field_73881_g - 28, 70, 20, stringtranslate.func_74805_b("selectServer.edit")));
        field_73887_h.add(field_74037_q = new GuiButton(2, field_73880_f / 2 - 74, field_73881_g - 28, 70, 20, stringtranslate.func_74805_b("selectServer.delete")));
        field_73887_h.add(field_74038_p = new GuiButton(1, field_73880_f / 2 - 154, field_73881_g - 52, 100, 20, stringtranslate.func_74805_b("selectServer.select")));
        field_73887_h.add(new GuiButton(4, field_73880_f / 2 - 50, field_73881_g - 52, 100, 20, stringtranslate.func_74805_b("selectServer.direct")));
        field_73887_h.add(new GuiButton(3, field_73880_f / 2 + 4 + 50, field_73881_g - 52, 100, 20, stringtranslate.func_74805_b("selectServer.add")));
        field_73887_h.add(new GuiButton(8, field_73880_f / 2 + 4, field_73881_g - 28, 70, 20, stringtranslate.func_74805_b("selectServer.refresh")));
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 + 4 + 76, field_73881_g - 28, 75, 20, stringtranslate.func_74805_b("gui.cancel")));
        boolean flag = field_74028_n >= 0 && field_74028_n < field_74022_d.func_77217_a();
        field_74038_p.field_73742_g = flag;
        field_74029_o.field_73742_g = flag;
        field_74037_q.field_73742_g = flag;
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        field_74039_z++;
        if(field_74041_x.func_77553_a())
        {
            field_74026_B = field_74041_x.func_77554_c();
            field_74041_x.func_77552_b();
        }
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
        if(field_74040_y != null)
        {
            field_74040_y.interrupt();
            field_74040_y = null;
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 2)
        {
            String s = field_74030_m.func_78850_a(field_74028_n).field_78847_a;
            if(s != null)
            {
                field_74036_r = true;
                StringTranslate stringtranslate = StringTranslate.func_74808_a();
                String s1 = stringtranslate.func_74805_b("selectServer.deleteQuestion");
                String s2 = (new StringBuilder()).append("'").append(s).append("' ").append(stringtranslate.func_74805_b("selectServer.deleteWarning")).toString();
                String s3 = stringtranslate.func_74805_b("selectServer.deleteButton");
                String s4 = stringtranslate.func_74805_b("gui.cancel");
                GuiYesNo guiyesno = new GuiYesNo(this, s1, s2, s3, s4, field_74028_n);
                field_73882_e.func_71373_a(guiyesno);
            }
        } else
        if(p_73875_1_.field_73741_f == 1)
        {
            func_74004_a(field_74028_n);
        } else
        if(p_73875_1_.field_73741_f == 4)
        {
            field_74033_u = true;
            field_73882_e.func_71373_a(new GuiScreenServerList(this, field_74031_w = new ServerData(StatCollector.func_74838_a("selectServer.defaultName"), "")));
        } else
        if(p_73875_1_.field_73741_f == 3)
        {
            field_74035_s = true;
            field_73882_e.func_71373_a(new GuiScreenAddServer(this, field_74031_w = new ServerData(StatCollector.func_74838_a("selectServer.defaultName"), "")));
        } else
        if(p_73875_1_.field_73741_f == 7)
        {
            field_74034_t = true;
            ServerData serverdata = field_74030_m.func_78850_a(field_74028_n);
            field_73882_e.func_71373_a(new GuiScreenAddServer(this, field_74031_w = new ServerData(serverdata.field_78847_a, serverdata.field_78845_b)));
        } else
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(field_74025_c);
        } else
        if(p_73875_1_.field_73741_f == 8)
        {
            field_73882_e.func_71373_a(new GuiMultiplayer(field_74025_c));
        } else
        {
            field_74022_d.func_77219_a(p_73875_1_);
        }
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        if(field_74036_r)
        {
            field_74036_r = false;
            if(p_73878_1_)
            {
                field_74030_m.func_78851_b(p_73878_2_);
                field_74030_m.func_78855_b();
                field_74028_n = -1;
            }
            field_73882_e.func_71373_a(this);
        } else
        if(field_74033_u)
        {
            field_74033_u = false;
            if(p_73878_1_)
            {
                func_74002_a(field_74031_w);
            } else
            {
                field_73882_e.func_71373_a(this);
            }
        } else
        if(field_74035_s)
        {
            field_74035_s = false;
            if(p_73878_1_)
            {
                field_74030_m.func_78849_a(field_74031_w);
                field_74030_m.func_78855_b();
                field_74028_n = -1;
            }
            field_73882_e.func_71373_a(this);
        } else
        if(field_74034_t)
        {
            field_74034_t = false;
            if(p_73878_1_)
            {
                ServerData serverdata = field_74030_m.func_78850_a(field_74028_n);
                serverdata.field_78847_a = field_74031_w.field_78847_a;
                serverdata.field_78845_b = field_74031_w.field_78845_b;
                field_74030_m.func_78855_b();
            }
            field_73882_e.func_71373_a(this);
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        int i = field_74028_n;
        if(func_73877_p() && p_73869_2_ == 200)
        {
            if(i > 0 && i < field_74030_m.func_78856_c())
            {
                field_74030_m.func_78857_a(i, i - 1);
                field_74028_n--;
                if(i < field_74030_m.func_78856_c() - 1)
                {
                    field_74022_d.func_77208_b(-field_74022_d.field_77229_d);
                }
            }
        } else
        if(func_73877_p() && p_73869_2_ == 208)
        {
            if(i < field_74030_m.func_78856_c() - 1)
            {
                field_74030_m.func_78857_a(i, i + 1);
                field_74028_n++;
                if(i > 0)
                {
                    field_74022_d.func_77208_b(field_74022_d.field_77229_d);
                }
            }
        } else
        if(p_73869_1_ == '\r')
        {
            func_73875_a((GuiButton)field_73887_h.get(2));
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        field_74032_v = null;
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        func_73873_v_();
        field_74022_d.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("multiplayer.title"), field_73880_f / 2, 20, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        if(field_74032_v != null)
        {
            func_74007_a(field_74032_v, p_73863_1_, p_73863_2_);
        }
    }

    private void func_74004_a(int p_74004_1_)
    {
        if(p_74004_1_ < field_74030_m.func_78856_c())
        {
            func_74002_a(field_74030_m.func_78850_a(p_74004_1_));
            return;
        }
        p_74004_1_ -= field_74030_m.func_78856_c();
        if(p_74004_1_ < field_74026_B.size())
        {
            LanServer lanserver = (LanServer)field_74026_B.get(p_74004_1_);
            func_74002_a(new ServerData(lanserver.func_77487_a(), lanserver.func_77488_b()));
        }
    }

    private void func_74002_a(ServerData p_74002_1_)
    {
        field_73882_e.func_71373_a(new GuiConnecting(field_73882_e, p_74002_1_));
    }

    private void func_74017_b(ServerData p_74017_1_)
        throws IOException
    {
        ServerAddress serveraddress = ServerAddress.func_78860_a(p_74017_1_.field_78845_b);
        Socket socket = null;
        DataInputStream datainputstream = null;
        DataOutputStream dataoutputstream = null;
        try
        {
            socket = new Socket();
            socket.setSoTimeout(3000);
            socket.setTcpNoDelay(true);
            socket.setTrafficClass(18);
            socket.connect(new InetSocketAddress(serveraddress.func_78861_a(), serveraddress.func_78864_b()), 3000);
            datainputstream = new DataInputStream(socket.getInputStream());
            dataoutputstream = new DataOutputStream(socket.getOutputStream());
            dataoutputstream.write(254);
            if(datainputstream.read() != 255)
            {
                throw new IOException("Bad message");
            }
            String s = Packet.func_73282_a(datainputstream, 256);
            char ac[] = s.toCharArray();
            for(int i = 0; i < ac.length; i++)
            {
                if(ac[i] != '\247' && ChatAllowedCharacters.field_71568_a.indexOf(ac[i]) < 0)
                {
                    ac[i] = '?';
                }
            }

            s = new String(ac);
            String as[] = s.split("\247");
            s = as[0];
            int j = -1;
            int k = -1;
            try
            {
                j = Integer.parseInt(as[1]);
                k = Integer.parseInt(as[2]);
            }
            catch(Exception exception) { }
            p_74017_1_.field_78843_d = (new StringBuilder()).append("\2477").append(s).toString();
            if(j >= 0 && k > 0)
            {
                p_74017_1_.field_78846_c = (new StringBuilder()).append("\2477").append(j).append("\2478/\2477").append(k).toString();
            } else
            {
                p_74017_1_.field_78846_c = "\2478???";
            }
        }
        finally
        {
            try
            {
                if(datainputstream != null)
                {
                    datainputstream.close();
                }
            }
            catch(Throwable throwable) { }
            try
            {
                if(dataoutputstream != null)
                {
                    dataoutputstream.close();
                }
            }
            catch(Throwable throwable1) { }
            try
            {
                if(socket != null)
                {
                    socket.close();
                }
            }
            catch(Throwable throwable2) { }
        }
    }

    protected void func_74007_a(String p_74007_1_, int p_74007_2_, int p_74007_3_)
    {
        if(p_74007_1_ == null)
        {
            return;
        } else
        {
            int i = p_74007_2_ + 12;
            int j = p_74007_3_ - 12;
            int k = field_73886_k.func_78256_a(p_74007_1_);
            func_73733_a(i - 3, j - 3, i + k + 3, j + 8 + 3, 0xc0000000, 0xc0000000);
            field_73886_k.func_78261_a(p_74007_1_, i, j, -1);
            return;
        }
    }

    static ServerList func_74006_a(GuiMultiplayer p_74006_0_)
    {
        return p_74006_0_.field_74030_m;
    }

    static List func_74003_b(GuiMultiplayer p_74003_0_)
    {
        return p_74003_0_.field_74026_B;
    }

    static int func_74020_c(GuiMultiplayer p_74020_0_)
    {
        return p_74020_0_.field_74028_n;
    }

    static int func_74015_a(GuiMultiplayer p_74015_0_, int p_74015_1_)
    {
        return p_74015_0_.field_74028_n = p_74015_1_;
    }

    static GuiButton func_74014_d(GuiMultiplayer p_74014_0_)
    {
        return p_74014_0_.field_74038_p;
    }

    static GuiButton func_74005_e(GuiMultiplayer p_74005_0_)
    {
        return p_74005_0_.field_74029_o;
    }

    static GuiButton func_74019_f(GuiMultiplayer p_74019_0_)
    {
        return p_74019_0_.field_74037_q;
    }

    static void func_74008_b(GuiMultiplayer p_74008_0_, int p_74008_1_)
    {
        p_74008_0_.func_74004_a(p_74008_1_);
    }

    static int func_74010_g(GuiMultiplayer p_74010_0_)
    {
        return p_74010_0_.field_74039_z;
    }

    static Object func_74011_h()
    {
        return field_74023_b;
    }

    static int func_74012_i()
    {
        return field_74027_a;
    }

    static int func_74021_j()
    {
        return field_74027_a++;
    }

    static void func_74013_a(GuiMultiplayer p_74013_0_, ServerData p_74013_1_)
        throws IOException
    {
        p_74013_0_.func_74017_b(p_74013_1_);
    }

    static int func_74018_k()
    {
        return field_74027_a--;
    }

    static String func_74009_a(GuiMultiplayer p_74009_0_, String p_74009_1_)
    {
        return p_74009_0_.field_74032_v = p_74009_1_;
    }

}
