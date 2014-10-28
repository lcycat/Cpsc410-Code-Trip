// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiIngame, GuiNewChat, GuiTextField, 
//            EntityClientPlayerMP, GameSettings, ChatClickData, GuiChatConfirmLink, 
//            Packet203AutoComplete, NetClientHandler

public class GuiChat extends GuiScreen
{

    private String field_73898_b;
    private int field_73899_c;
    private boolean field_73897_d;
    private boolean field_73905_m;
    private int field_73903_n;
    private List field_73904_o;
    private URI field_73902_p;
    protected GuiTextField field_73901_a;
    private String field_73900_q;

    public GuiChat()
    {
        field_73898_b = "";
        field_73899_c = -1;
        field_73897_d = false;
        field_73905_m = false;
        field_73903_n = 0;
        field_73904_o = new ArrayList();
        field_73902_p = null;
        field_73900_q = "";
    }

    public GuiChat(String p_i3035_1_)
    {
        field_73898_b = "";
        field_73899_c = -1;
        field_73897_d = false;
        field_73905_m = false;
        field_73903_n = 0;
        field_73904_o = new ArrayList();
        field_73902_p = null;
        field_73900_q = "";
        field_73900_q = p_i3035_1_;
    }

    public void func_73866_w_()
    {
        Keyboard.enableRepeatEvents(true);
        field_73899_c = field_73882_e.field_71456_v.func_73827_b().func_73756_b().size();
        field_73901_a = new GuiTextField(field_73886_k, 4, field_73881_g - 12, field_73880_f - 4, 12);
        field_73901_a.func_73804_f(100);
        field_73901_a.func_73786_a(false);
        field_73901_a.func_73796_b(true);
        field_73901_a.func_73782_a(field_73900_q);
        field_73901_a.func_73805_d(false);
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
        field_73882_e.field_71456_v.func_73827_b().func_73764_c();
    }

    public void func_73876_c()
    {
        field_73901_a.func_73780_a();
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        field_73905_m = false;
        if(p_73869_2_ == 15)
        {
            func_73895_u_();
        } else
        {
            field_73897_d = false;
        }
        if(p_73869_2_ == 1)
        {
            field_73882_e.func_71373_a(null);
        } else
        if(p_73869_2_ == 28)
        {
            String s = field_73901_a.func_73781_b().trim();
            if(s.length() > 0)
            {
                field_73882_e.field_71456_v.func_73827_b().func_73767_b(s);
                if(!field_73882_e.func_71409_c(s))
                {
                    field_73882_e.field_71439_g.func_71165_d(s);
                }
            }
            field_73882_e.func_71373_a(null);
        } else
        if(p_73869_2_ == 200)
        {
            func_73892_a(-1);
        } else
        if(p_73869_2_ == 208)
        {
            func_73892_a(1);
        } else
        if(p_73869_2_ == 201)
        {
            field_73882_e.field_71456_v.func_73827_b().func_73758_b(19);
        } else
        if(p_73869_2_ == 209)
        {
            field_73882_e.field_71456_v.func_73827_b().func_73758_b(-19);
        } else
        {
            field_73901_a.func_73802_a(p_73869_1_, p_73869_2_);
        }
    }

    public void func_73867_d()
    {
        super.func_73867_d();
        int i = Mouse.getEventDWheel();
        if(i != 0)
        {
            if(i > 1)
            {
                i = 1;
            }
            if(i < -1)
            {
                i = -1;
            }
            if(!func_73877_p())
            {
                i *= 7;
            }
            field_73882_e.field_71456_v.func_73827_b().func_73758_b(i);
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        if(p_73864_3_ == 0 && field_73882_e.field_71474_y.field_74359_p)
        {
            ChatClickData chatclickdata = field_73882_e.field_71456_v.func_73827_b().func_73766_a(Mouse.getX(), Mouse.getY());
            if(chatclickdata != null)
            {
                URI uri = chatclickdata.func_78308_g();
                if(uri != null)
                {
                    if(field_73882_e.field_71474_y.field_74358_q)
                    {
                        field_73902_p = uri;
                        field_73882_e.func_71373_a(new GuiChatConfirmLink(this, this, chatclickdata.func_78309_f(), 0, chatclickdata));
                    } else
                    {
                        func_73896_a(uri);
                    }
                    return;
                }
            }
        }
        field_73901_a.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        if(p_73878_2_ == 0)
        {
            if(p_73878_1_)
            {
                func_73896_a(field_73902_p);
            }
            field_73902_p = null;
            field_73882_e.func_71373_a(this);
        }
    }

    private void func_73896_a(URI p_73896_1_)
    {
        try
        {
            Class class1 = Class.forName("java.awt.Desktop");
            Object obj = class1.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            class1.getMethod("browse", new Class[] {
                java.net.URI.class
            }).invoke(obj, new Object[] {
                p_73896_1_
            });
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void func_73895_u_()
    {
        if(field_73897_d)
        {
            field_73901_a.func_73777_b(field_73901_a.func_73798_a(-1, field_73901_a.func_73799_h(), false) - field_73901_a.func_73799_h());
            if(field_73903_n >= field_73904_o.size())
            {
                field_73903_n = 0;
            }
        } else
        {
            int i = field_73901_a.func_73798_a(-1, field_73901_a.func_73799_h(), false);
            field_73904_o.clear();
            field_73903_n = 0;
            String s = field_73901_a.func_73781_b().substring(i).toLowerCase();
            String s1 = field_73901_a.func_73781_b().substring(0, field_73901_a.func_73799_h());
            func_73893_a(s1, s);
            if(field_73904_o.isEmpty())
            {
                return;
            }
            field_73897_d = true;
            field_73901_a.func_73777_b(i - field_73901_a.func_73799_h());
        }
        if(field_73904_o.size() > 1)
        {
            StringBuilder stringbuilder = new StringBuilder();
            String s2;
            for(Iterator iterator = field_73904_o.iterator(); iterator.hasNext(); stringbuilder.append(s2))
            {
                s2 = (String)iterator.next();
                if(stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
            }

            field_73882_e.field_71456_v.func_73827_b().func_73763_a(stringbuilder.toString(), 1);
        }
        field_73901_a.func_73792_b((String)field_73904_o.get(field_73903_n++));
    }

    private void func_73893_a(String p_73893_1_, String p_73893_2_)
    {
        if(p_73893_1_.length() < 1)
        {
            return;
        } else
        {
            field_73882_e.field_71439_g.field_71174_a.func_72552_c(new Packet203AutoComplete(p_73893_1_));
            field_73905_m = true;
            return;
        }
    }

    public void func_73892_a(int p_73892_1_)
    {
        int i = field_73899_c + p_73892_1_;
        int j = field_73882_e.field_71456_v.func_73827_b().func_73756_b().size();
        if(i < 0)
        {
            i = 0;
        }
        if(i > j)
        {
            i = j;
        }
        if(i == field_73899_c)
        {
            return;
        }
        if(i == j)
        {
            field_73899_c = j;
            field_73901_a.func_73782_a(field_73898_b);
            return;
        }
        if(field_73899_c == j)
        {
            field_73898_b = field_73901_a.func_73781_b();
        }
        field_73901_a.func_73782_a((String)field_73882_e.field_71456_v.func_73827_b().func_73756_b().get(i));
        field_73899_c = i;
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73734_a(2, field_73881_g - 14, field_73880_f - 2, field_73881_g - 2, 0x80000000);
        field_73901_a.func_73795_f();
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    public void func_73894_a(String p_73894_1_[])
    {
        if(field_73905_m)
        {
            field_73904_o.clear();
            String as[] = p_73894_1_;
            int i = as.length;
            for(int j = 0; j < i; j++)
            {
                String s = as[j];
                if(s.length() > 0)
                {
                    field_73904_o.add(s);
                }
            }

            if(field_73904_o.size() > 0)
            {
                field_73897_d = true;
                func_73895_u_();
            }
        }
    }

    public boolean func_73868_f()
    {
        return false;
    }
}
