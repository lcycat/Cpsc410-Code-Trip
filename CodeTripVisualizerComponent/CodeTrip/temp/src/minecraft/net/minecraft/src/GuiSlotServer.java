// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiMultiplayer, ServerList, GuiButton, 
//            GuiScreen, LanServer, StatCollector, ServerData, 
//            ThreadPollServers, FontRenderer, RenderEngine, Tessellator

class GuiSlotServer extends GuiSlot
{

    final GuiMultiplayer field_77250_a; /* synthetic field */

    public GuiSlotServer(GuiMultiplayer p_i3051_1_)
    {
        field_77250_a = p_i3051_1_;
        super(p_i3051_1_.field_73882_e, p_i3051_1_.field_73880_f, p_i3051_1_.field_73881_g, 32, p_i3051_1_.field_73881_g - 64, 36);
    }

    protected int func_77217_a()
    {
        return GuiMultiplayer.func_74006_a(field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(field_77250_a).size() + 1;
    }

    protected void func_77213_a(int p_77213_1_, boolean p_77213_2_)
    {
        if(p_77213_1_ >= GuiMultiplayer.func_74006_a(field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(field_77250_a).size())
        {
            return;
        }
        int i = GuiMultiplayer.func_74020_c(field_77250_a);
        GuiMultiplayer.func_74015_a(field_77250_a, p_77213_1_);
        boolean flag = GuiMultiplayer.func_74020_c(field_77250_a) >= 0 && GuiMultiplayer.func_74020_c(field_77250_a) < func_77217_a();
        boolean flag1 = GuiMultiplayer.func_74020_c(field_77250_a) < GuiMultiplayer.func_74006_a(field_77250_a).func_78856_c();
        GuiMultiplayer.func_74014_d(field_77250_a).field_73742_g = flag;
        GuiMultiplayer.func_74005_e(field_77250_a).field_73742_g = flag1;
        GuiMultiplayer.func_74019_f(field_77250_a).field_73742_g = flag1;
        if(p_77213_2_ && flag)
        {
            GuiMultiplayer.func_74008_b(field_77250_a, p_77213_1_);
        } else
        if(flag1 && GuiScreen.func_73877_p() && i >= 0 && i < GuiMultiplayer.func_74006_a(field_77250_a).func_78856_c())
        {
            GuiMultiplayer.func_74006_a(field_77250_a).func_78857_a(i, GuiMultiplayer.func_74020_c(field_77250_a));
        }
    }

    protected boolean func_77218_a(int p_77218_1_)
    {
        return p_77218_1_ == GuiMultiplayer.func_74020_c(field_77250_a);
    }

    protected int func_77212_b()
    {
        return func_77217_a() * 36;
    }

    protected void func_77221_c()
    {
        field_77250_a.func_73873_v_();
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        if(p_77214_1_ < GuiMultiplayer.func_74006_a(field_77250_a).func_78856_c())
        {
            func_77247_d(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
        } else
        if(p_77214_1_ < GuiMultiplayer.func_74006_a(field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(field_77250_a).size())
        {
            func_77248_b(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
        } else
        {
            func_77249_c(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
        }
    }

    private void func_77248_b(int p_77248_1_, int p_77248_2_, int p_77248_3_, int p_77248_4_, Tessellator p_77248_5_)
    {
        LanServer lanserver = (LanServer)GuiMultiplayer.func_74003_b(field_77250_a).get(p_77248_1_ - GuiMultiplayer.func_74006_a(field_77250_a).func_78856_c());
        field_77250_a.func_73731_b(field_77250_a.field_73886_k, StatCollector.func_74838_a("lanServer.title"), p_77248_2_ + 2, p_77248_3_ + 1, 0xffffff);
        field_77250_a.func_73731_b(field_77250_a.field_73886_k, lanserver.func_77487_a(), p_77248_2_ + 2, p_77248_3_ + 12, 0x808080);
        field_77250_a.func_73731_b(field_77250_a.field_73886_k, lanserver.func_77488_b(), p_77248_2_ + 2, p_77248_3_ + 12 + 11, 0x303030);
    }

    private void func_77249_c(int p_77249_1_, int p_77249_2_, int p_77249_3_, int p_77249_4_, Tessellator p_77249_5_)
    {
        field_77250_a.func_73732_a(field_77250_a.field_73886_k, StatCollector.func_74838_a("lanServer.scanning"), field_77250_a.field_73880_f / 2, p_77249_3_ + 1, 0xffffff);
        String s;
        switch((GuiMultiplayer.func_74010_g(field_77250_a) / 3) % 4)
        {
        case 0: // '\0'
        default:
            s = "O o o";
            break;

        case 1: // '\001'
        case 3: // '\003'
            s = "o O o";
            break;

        case 2: // '\002'
            s = "o o O";
            break;
        }
        field_77250_a.func_73732_a(field_77250_a.field_73886_k, s, field_77250_a.field_73880_f / 2, p_77249_3_ + 12, 0x808080);
    }

    private void func_77247_d(int p_77247_1_, int p_77247_2_, int p_77247_3_, int p_77247_4_, Tessellator p_77247_5_)
    {
        ServerData serverdata = GuiMultiplayer.func_74006_a(field_77250_a).func_78850_a(p_77247_1_);
        synchronized(GuiMultiplayer.func_74011_h())
        {
            if(GuiMultiplayer.func_74012_i() < 5 && !serverdata.field_78841_f)
            {
                serverdata.field_78841_f = true;
                serverdata.field_78844_e = -2L;
                serverdata.field_78843_d = "";
                serverdata.field_78846_c = "";
                GuiMultiplayer.func_74021_j();
                (new ThreadPollServers(this, serverdata)).start();
            }
        }
        field_77250_a.func_73731_b(field_77250_a.field_73886_k, serverdata.field_78847_a, p_77247_2_ + 2, p_77247_3_ + 1, 0xffffff);
        field_77250_a.func_73731_b(field_77250_a.field_73886_k, serverdata.field_78843_d, p_77247_2_ + 2, p_77247_3_ + 12, 0x808080);
        field_77250_a.func_73731_b(field_77250_a.field_73886_k, serverdata.field_78846_c, (p_77247_2_ + 215) - field_77250_a.field_73886_k.func_78256_a(serverdata.field_78846_c), p_77247_3_ + 12, 0x808080);
        field_77250_a.func_73731_b(field_77250_a.field_73886_k, serverdata.field_78845_b, p_77247_2_ + 2, p_77247_3_ + 12 + 11, 0x303030);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_77250_a.field_73882_e.field_71446_o.func_78342_b(field_77250_a.field_73882_e.field_71446_o.func_78341_b("/gui/icons.png"));
        String s = "";
        int i;
        int j;
        if(serverdata.field_78841_f && serverdata.field_78844_e != -2L)
        {
            i = 0;
            j = 0;
            if(serverdata.field_78844_e < 0L)
            {
                j = 5;
            } else
            if(serverdata.field_78844_e < 150L)
            {
                j = 0;
            } else
            if(serverdata.field_78844_e < 300L)
            {
                j = 1;
            } else
            if(serverdata.field_78844_e < 600L)
            {
                j = 2;
            } else
            if(serverdata.field_78844_e < 1000L)
            {
                j = 3;
            } else
            {
                j = 4;
            }
            if(serverdata.field_78844_e < 0L)
            {
                s = "(no connection)";
            } else
            {
                s = (new StringBuilder()).append(serverdata.field_78844_e).append("ms").toString();
            }
        } else
        {
            i = 1;
            j = (int)(Minecraft.func_71386_F() / 100L + (long)(p_77247_1_ * 2) & 7L);
            if(j > 4)
            {
                j = 8 - j;
            }
            s = "Polling..";
        }
        field_77250_a.func_73729_b(p_77247_2_ + 205, p_77247_3_, 0 + i * 10, 176 + j * 8, 10, 8);
        byte byte0 = 4;
        if(field_77230_e >= (p_77247_2_ + 205) - byte0 && field_77227_f >= p_77247_3_ - byte0 && field_77230_e <= p_77247_2_ + 205 + 10 + byte0 && field_77227_f <= p_77247_3_ + 8 + byte0)
        {
            GuiMultiplayer.func_74009_a(field_77250_a, s);
        }
    }
}
