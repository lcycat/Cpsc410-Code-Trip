// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StatCollector, GuiTextField, StringTranslate, 
//            GuiButton, ChatAllowedCharacters, MathHelper, WorldType, 
//            ISaveFormat, EnumGameType, WorldSettings

public class GuiCreateWorld extends GuiScreen
{

    private GuiScreen field_73924_a;
    private GuiTextField field_73919_b;
    private GuiTextField field_73921_c;
    private String field_73918_d;
    private String field_73927_m;
    private boolean field_73925_n;
    private boolean field_73926_o;
    private boolean field_73935_p;
    private boolean field_73934_q;
    private boolean field_73933_r;
    private boolean field_73932_s;
    private boolean field_73931_t;
    private GuiButton field_73930_u;
    private GuiButton field_73929_v;
    private GuiButton field_73928_w;
    private GuiButton field_73938_x;
    private GuiButton field_73937_y;
    private GuiButton field_73936_z;
    private String field_73920_A;
    private String field_73922_B;
    private String field_73923_C;
    private String field_73915_D;
    private int field_73916_E;
    private static final String field_73917_F[] = {
        "CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", 
        "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", 
        "LPT6", "LPT7", "LPT8", "LPT9"
    };

    public GuiCreateWorld(GuiScreen p_i3036_1_)
    {
        field_73927_m = "survival";
        field_73925_n = true;
        field_73926_o = false;
        field_73935_p = false;
        field_73934_q = false;
        field_73933_r = false;
        field_73916_E = 0;
        field_73924_a = p_i3036_1_;
        field_73923_C = "";
        field_73915_D = StatCollector.func_74838_a("selectWorld.newWorld");
    }

    public void func_73876_c()
    {
        field_73919_b.func_73780_a();
        field_73921_c.func_73780_a();
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        Keyboard.enableRepeatEvents(true);
        field_73887_h.clear();
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 155, field_73881_g - 28, 150, 20, stringtranslate.func_74805_b("selectWorld.create")));
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 + 5, field_73881_g - 28, 150, 20, stringtranslate.func_74805_b("gui.cancel")));
        field_73887_h.add(field_73930_u = new GuiButton(2, field_73880_f / 2 - 75, 100, 150, 20, stringtranslate.func_74805_b("selectWorld.gameMode")));
        field_73887_h.add(field_73929_v = new GuiButton(3, field_73880_f / 2 - 75, 172, 150, 20, stringtranslate.func_74805_b("selectWorld.moreWorldOptions")));
        field_73887_h.add(field_73928_w = new GuiButton(4, field_73880_f / 2 - 155, 100, 150, 20, stringtranslate.func_74805_b("selectWorld.mapFeatures")));
        field_73928_w.field_73748_h = false;
        field_73887_h.add(field_73938_x = new GuiButton(7, field_73880_f / 2 + 5, 136, 150, 20, stringtranslate.func_74805_b("selectWorld.bonusItems")));
        field_73938_x.field_73748_h = false;
        field_73887_h.add(field_73937_y = new GuiButton(5, field_73880_f / 2 + 5, 100, 150, 20, stringtranslate.func_74805_b("selectWorld.mapType")));
        field_73937_y.field_73748_h = false;
        field_73887_h.add(field_73936_z = new GuiButton(6, field_73880_f / 2 - 155, 136, 150, 20, stringtranslate.func_74805_b("selectWorld.allowCommands")));
        field_73936_z.field_73748_h = false;
        field_73919_b = new GuiTextField(field_73886_k, field_73880_f / 2 - 100, 60, 200, 20);
        field_73919_b.func_73796_b(true);
        field_73919_b.func_73782_a(field_73915_D);
        field_73921_c = new GuiTextField(field_73886_k, field_73880_f / 2 - 100, 60, 200, 20);
        field_73921_c.func_73782_a(field_73923_C);
        func_73912_g();
        func_73914_h();
    }

    private void func_73912_g()
    {
        field_73918_d = field_73919_b.func_73781_b().trim();
        char ac[] = ChatAllowedCharacters.field_71567_b;
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            char c = ac[j];
            field_73918_d = field_73918_d.replace(c, '_');
        }

        if(MathHelper.func_76139_a(field_73918_d))
        {
            field_73918_d = "World";
        }
        field_73918_d = func_73913_a(field_73882_e.func_71359_d(), field_73918_d);
    }

    private void func_73914_h()
    {
        StringTranslate stringtranslate;
        stringtranslate = StringTranslate.func_74808_a();
        field_73930_u.field_73744_e = (new StringBuilder()).append(stringtranslate.func_74805_b("selectWorld.gameMode")).append(" ").append(stringtranslate.func_74805_b((new StringBuilder()).append("selectWorld.gameMode.").append(field_73927_m).toString())).toString();
        field_73920_A = stringtranslate.func_74805_b((new StringBuilder()).append("selectWorld.gameMode.").append(field_73927_m).append(".line1").toString());
        field_73922_B = stringtranslate.func_74805_b((new StringBuilder()).append("selectWorld.gameMode.").append(field_73927_m).append(".line2").toString());
        field_73928_w.field_73744_e = (new StringBuilder()).append(stringtranslate.func_74805_b("selectWorld.mapFeatures")).append(" ").toString();
        if(!field_73925_n) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        field_73928_w;
        JVM INSTR dup_x1 ;
        field_73744_e;
        append();
        stringtranslate.func_74805_b("options.on");
        append();
        toString();
        field_73744_e;
          goto _L3
_L2:
        new StringBuilder();
        field_73928_w;
        JVM INSTR dup_x1 ;
        field_73744_e;
        append();
        stringtranslate.func_74805_b("options.off");
        append();
        toString();
        field_73744_e;
_L3:
        field_73938_x.field_73744_e = (new StringBuilder()).append(stringtranslate.func_74805_b("selectWorld.bonusItems")).append(" ").toString();
        if(!field_73934_q || field_73933_r) goto _L5; else goto _L4
_L4:
        new StringBuilder();
        field_73938_x;
        JVM INSTR dup_x1 ;
        field_73744_e;
        append();
        stringtranslate.func_74805_b("options.on");
        append();
        toString();
        field_73744_e;
          goto _L6
_L5:
        new StringBuilder();
        field_73938_x;
        JVM INSTR dup_x1 ;
        field_73744_e;
        append();
        stringtranslate.func_74805_b("options.off");
        append();
        toString();
        field_73744_e;
_L6:
        field_73937_y.field_73744_e = (new StringBuilder()).append(stringtranslate.func_74805_b("selectWorld.mapType")).append(" ").append(stringtranslate.func_74805_b(WorldType.field_77139_a[field_73916_E].func_77128_b())).toString();
        field_73936_z.field_73744_e = (new StringBuilder()).append(stringtranslate.func_74805_b("selectWorld.allowCommands")).append(" ").toString();
        if(!field_73926_o || field_73933_r) goto _L8; else goto _L7
_L7:
        new StringBuilder();
        field_73936_z;
        JVM INSTR dup_x1 ;
        field_73744_e;
        append();
        stringtranslate.func_74805_b("options.on");
        append();
        toString();
        field_73744_e;
          goto _L9
_L8:
        new StringBuilder();
        field_73936_z;
        JVM INSTR dup_x1 ;
        field_73744_e;
        append();
        stringtranslate.func_74805_b("options.off");
        append();
        toString();
        field_73744_e;
_L9:
    }

    public static String func_73913_a(ISaveFormat p_73913_0_, String p_73913_1_)
    {
        p_73913_1_ = p_73913_1_.replaceAll("[\\./\"]", "_");
        String as[] = field_73917_F;
        int i = as.length;
        for(int j = 0; j < i; j++)
        {
            String s = as[j];
            if(p_73913_1_.equalsIgnoreCase(s))
            {
                p_73913_1_ = (new StringBuilder()).append("_").append(p_73913_1_).append("_").toString();
            }
        }

        for(; p_73913_0_.func_75803_c(p_73913_1_) != null; p_73913_1_ = (new StringBuilder()).append(p_73913_1_).append("-").toString()) { }
        return p_73913_1_;
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 1)
        {
            field_73882_e.func_71373_a(field_73924_a);
        } else
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(null);
            if(field_73932_s)
            {
                return;
            }
            field_73932_s = true;
            long l = (new Random()).nextLong();
            String s = field_73921_c.func_73781_b();
            if(!MathHelper.func_76139_a(s))
            {
                try
                {
                    long l1 = Long.parseLong(s);
                    if(l1 != 0L)
                    {
                        l = l1;
                    }
                }
                catch(NumberFormatException numberformatexception)
                {
                    l = s.hashCode();
                }
            }
            EnumGameType enumgametype = EnumGameType.func_77142_a(field_73927_m);
            WorldSettings worldsettings = new WorldSettings(l, enumgametype, field_73925_n, field_73933_r, WorldType.field_77139_a[field_73916_E]);
            if(field_73934_q && !field_73933_r)
            {
                worldsettings.func_77159_a();
            }
            if(field_73926_o && !field_73933_r)
            {
                worldsettings.func_77166_b();
            }
            field_73882_e.func_71371_a(field_73918_d, field_73919_b.func_73781_b().trim(), worldsettings);
        } else
        if(p_73875_1_.field_73741_f == 3)
        {
            field_73931_t = !field_73931_t;
            field_73930_u.field_73748_h = !field_73931_t;
            field_73928_w.field_73748_h = field_73931_t;
            field_73938_x.field_73748_h = field_73931_t;
            field_73937_y.field_73748_h = field_73931_t;
            field_73936_z.field_73748_h = field_73931_t;
            if(field_73931_t)
            {
                StringTranslate stringtranslate = StringTranslate.func_74808_a();
                field_73929_v.field_73744_e = stringtranslate.func_74805_b("gui.done");
            } else
            {
                StringTranslate stringtranslate1 = StringTranslate.func_74808_a();
                field_73929_v.field_73744_e = stringtranslate1.func_74805_b("selectWorld.moreWorldOptions");
            }
        } else
        if(p_73875_1_.field_73741_f == 2)
        {
            if(field_73927_m.equals("survival"))
            {
                if(!field_73935_p)
                {
                    field_73926_o = false;
                }
                field_73933_r = false;
                field_73927_m = "hardcore";
                field_73933_r = true;
                field_73936_z.field_73742_g = false;
                field_73938_x.field_73742_g = false;
                func_73914_h();
            } else
            if(field_73927_m.equals("hardcore"))
            {
                if(!field_73935_p)
                {
                    field_73926_o = true;
                }
                field_73933_r = false;
                field_73927_m = "creative";
                func_73914_h();
                field_73933_r = false;
                field_73936_z.field_73742_g = true;
                field_73938_x.field_73742_g = true;
            } else
            {
                if(!field_73935_p)
                {
                    field_73926_o = false;
                }
                field_73927_m = "survival";
                func_73914_h();
                field_73936_z.field_73742_g = true;
                field_73938_x.field_73742_g = true;
                field_73933_r = false;
            }
            func_73914_h();
        } else
        if(p_73875_1_.field_73741_f == 4)
        {
            field_73925_n = !field_73925_n;
            func_73914_h();
        } else
        if(p_73875_1_.field_73741_f == 7)
        {
            field_73934_q = !field_73934_q;
            func_73914_h();
        } else
        if(p_73875_1_.field_73741_f == 5)
        {
            field_73916_E++;
            if(field_73916_E >= WorldType.field_77139_a.length)
            {
                field_73916_E = 0;
            }
            do
            {
                if(WorldType.field_77139_a[field_73916_E] != null && WorldType.field_77139_a[field_73916_E].func_77126_d())
                {
                    break;
                }
                field_73916_E++;
                if(field_73916_E >= WorldType.field_77139_a.length)
                {
                    field_73916_E = 0;
                }
            } while(true);
            func_73914_h();
        } else
        if(p_73875_1_.field_73741_f == 6)
        {
            field_73935_p = true;
            field_73926_o = !field_73926_o;
            func_73914_h();
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(field_73919_b.func_73806_l() && !field_73931_t)
        {
            field_73919_b.func_73802_a(p_73869_1_, p_73869_2_);
            field_73915_D = field_73919_b.func_73781_b();
        } else
        if(field_73921_c.func_73806_l() && field_73931_t)
        {
            field_73921_c.func_73802_a(p_73869_1_, p_73869_2_);
            field_73923_C = field_73921_c.func_73781_b();
        }
        if(p_73869_1_ == '\r')
        {
            func_73875_a((GuiButton)field_73887_h.get(0));
        }
        ((GuiButton)field_73887_h.get(0)).field_73742_g = field_73919_b.func_73781_b().length() > 0;
        func_73912_g();
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        if(field_73931_t)
        {
            field_73921_c.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
        } else
        {
            field_73919_b.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        func_73873_v_();
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("selectWorld.create"), field_73880_f / 2, 20, 0xffffff);
        if(field_73931_t)
        {
            func_73731_b(field_73886_k, stringtranslate.func_74805_b("selectWorld.enterSeed"), field_73880_f / 2 - 100, 47, 0xa0a0a0);
            func_73731_b(field_73886_k, stringtranslate.func_74805_b("selectWorld.seedInfo"), field_73880_f / 2 - 100, 85, 0xa0a0a0);
            func_73731_b(field_73886_k, stringtranslate.func_74805_b("selectWorld.mapFeatures.info"), field_73880_f / 2 - 150, 122, 0xa0a0a0);
            func_73731_b(field_73886_k, stringtranslate.func_74805_b("selectWorld.allowCommands.info"), field_73880_f / 2 - 150, 157, 0xa0a0a0);
            field_73921_c.func_73795_f();
        } else
        {
            func_73731_b(field_73886_k, stringtranslate.func_74805_b("selectWorld.enterName"), field_73880_f / 2 - 100, 47, 0xa0a0a0);
            func_73731_b(field_73886_k, (new StringBuilder()).append(stringtranslate.func_74805_b("selectWorld.resultFolder")).append(" ").append(field_73918_d).toString(), field_73880_f / 2 - 100, 85, 0xa0a0a0);
            field_73919_b.func_73795_f();
            func_73731_b(field_73886_k, field_73920_A, field_73880_f / 2 - 100, 122, 0xa0a0a0);
            func_73731_b(field_73886_k, field_73922_B, field_73880_f / 2 - 100, 134, 0xa0a0a0);
        }
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

}
