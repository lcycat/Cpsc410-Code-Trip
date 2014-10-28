// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

// Referenced classes of package net.minecraft.src:
//            KeyBinding, StringTranslate, StatCollector, EnumOptions, 
//            SoundManager, RenderGlobal, RenderEngine, EnumOptionsHelper, 
//            EntityClientPlayerMP, Packet204ClientInfo, NetClientHandler

public class GameSettings
{

    private static final String field_74360_ac[] = {
        "options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"
    };
    private static final String field_74361_ad[] = {
        "options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"
    };
    private static final String field_74367_ae[] = {
        "options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"
    };
    private static final String field_74369_af[] = {
        "options.chat.visibility.full", "options.chat.visibility.system", "options.chat.visibility.hidden"
    };
    private static final String field_74364_ag[] = {
        "options.particles.all", "options.particles.decreased", "options.particles.minimal"
    };
    private static final String field_74365_ah[] = {
        "performance.max", "performance.balanced", "performance.powersaver"
    };
    public float field_74342_a;
    public float field_74340_b;
    public float field_74341_c;
    public boolean field_74338_d;
    public int field_74339_e;
    public boolean field_74336_f;
    public boolean field_74337_g;
    public boolean field_74349_h;
    public int field_74350_i;
    public boolean field_74347_j;
    public boolean field_74348_k;
    public boolean field_74345_l;
    public String field_74346_m;
    public int field_74343_n;
    public boolean field_74344_o;
    public boolean field_74359_p;
    public boolean field_74358_q;
    public float field_74357_r;
    public boolean field_74356_s;
    public boolean field_74355_t;
    public boolean field_74353_u;
    public boolean field_74352_v;
    public KeyBinding field_74351_w;
    public KeyBinding field_74370_x;
    public KeyBinding field_74368_y;
    public KeyBinding field_74366_z;
    public KeyBinding field_74314_A;
    public KeyBinding field_74315_B;
    public KeyBinding field_74316_C;
    public KeyBinding field_74310_D;
    public KeyBinding field_74311_E;
    public KeyBinding field_74312_F;
    public KeyBinding field_74313_G;
    public KeyBinding field_74321_H;
    public KeyBinding field_74322_I;
    public KeyBinding field_74323_J;
    public KeyBinding field_74324_K[];
    protected Minecraft field_74317_L;
    private File field_74354_ai;
    public int field_74318_M;
    public boolean field_74319_N;
    public int field_74320_O;
    public boolean field_74330_P;
    public boolean field_74329_Q;
    public String field_74332_R;
    public boolean field_74331_S;
    public boolean field_74326_T;
    public boolean field_74325_U;
    public float field_74328_V;
    public float field_74327_W;
    public float field_74334_X;
    public float field_74333_Y;
    public int field_74335_Z;
    public int field_74362_aa;
    public String field_74363_ab;

    public GameSettings(Minecraft p_i3009_1_, File p_i3009_2_)
    {
        field_74342_a = 1.0F;
        field_74340_b = 1.0F;
        field_74341_c = 0.5F;
        field_74338_d = false;
        field_74339_e = 0;
        field_74336_f = true;
        field_74337_g = false;
        field_74349_h = false;
        field_74350_i = 1;
        field_74347_j = true;
        field_74348_k = true;
        field_74345_l = true;
        field_74346_m = "Default";
        field_74343_n = 0;
        field_74344_o = true;
        field_74359_p = true;
        field_74358_q = true;
        field_74357_r = 1.0F;
        field_74356_s = true;
        field_74355_t = true;
        field_74353_u = false;
        field_74352_v = false;
        field_74351_w = new KeyBinding("key.forward", 17);
        field_74370_x = new KeyBinding("key.left", 30);
        field_74368_y = new KeyBinding("key.back", 31);
        field_74366_z = new KeyBinding("key.right", 32);
        field_74314_A = new KeyBinding("key.jump", 57);
        field_74315_B = new KeyBinding("key.inventory", 18);
        field_74316_C = new KeyBinding("key.drop", 16);
        field_74310_D = new KeyBinding("key.chat", 20);
        field_74311_E = new KeyBinding("key.sneak", 42);
        field_74312_F = new KeyBinding("key.attack", -100);
        field_74313_G = new KeyBinding("key.use", -99);
        field_74321_H = new KeyBinding("key.playerlist", 15);
        field_74322_I = new KeyBinding("key.pickItem", -98);
        field_74323_J = new KeyBinding("key.command", 53);
        field_74324_K = (new KeyBinding[] {
            field_74312_F, field_74313_G, field_74351_w, field_74370_x, field_74368_y, field_74366_z, field_74314_A, field_74311_E, field_74316_C, field_74315_B, 
            field_74310_D, field_74321_H, field_74322_I, field_74323_J
        });
        field_74318_M = 2;
        field_74319_N = false;
        field_74320_O = 0;
        field_74330_P = false;
        field_74329_Q = false;
        field_74332_R = "";
        field_74331_S = false;
        field_74326_T = false;
        field_74325_U = false;
        field_74328_V = 1.0F;
        field_74327_W = 1.0F;
        field_74334_X = 0.0F;
        field_74333_Y = 0.0F;
        field_74335_Z = 0;
        field_74362_aa = 0;
        field_74363_ab = "en_US";
        field_74317_L = p_i3009_1_;
        field_74354_ai = new File(p_i3009_2_, "options.txt");
        func_74300_a();
    }

    public GameSettings()
    {
        field_74342_a = 1.0F;
        field_74340_b = 1.0F;
        field_74341_c = 0.5F;
        field_74338_d = false;
        field_74339_e = 0;
        field_74336_f = true;
        field_74337_g = false;
        field_74349_h = false;
        field_74350_i = 1;
        field_74347_j = true;
        field_74348_k = true;
        field_74345_l = true;
        field_74346_m = "Default";
        field_74343_n = 0;
        field_74344_o = true;
        field_74359_p = true;
        field_74358_q = true;
        field_74357_r = 1.0F;
        field_74356_s = true;
        field_74355_t = true;
        field_74353_u = false;
        field_74352_v = false;
        field_74351_w = new KeyBinding("key.forward", 17);
        field_74370_x = new KeyBinding("key.left", 30);
        field_74368_y = new KeyBinding("key.back", 31);
        field_74366_z = new KeyBinding("key.right", 32);
        field_74314_A = new KeyBinding("key.jump", 57);
        field_74315_B = new KeyBinding("key.inventory", 18);
        field_74316_C = new KeyBinding("key.drop", 16);
        field_74310_D = new KeyBinding("key.chat", 20);
        field_74311_E = new KeyBinding("key.sneak", 42);
        field_74312_F = new KeyBinding("key.attack", -100);
        field_74313_G = new KeyBinding("key.use", -99);
        field_74321_H = new KeyBinding("key.playerlist", 15);
        field_74322_I = new KeyBinding("key.pickItem", -98);
        field_74323_J = new KeyBinding("key.command", 53);
        field_74324_K = (new KeyBinding[] {
            field_74312_F, field_74313_G, field_74351_w, field_74370_x, field_74368_y, field_74366_z, field_74314_A, field_74311_E, field_74316_C, field_74315_B, 
            field_74310_D, field_74321_H, field_74322_I, field_74323_J
        });
        field_74318_M = 2;
        field_74319_N = false;
        field_74320_O = 0;
        field_74330_P = false;
        field_74329_Q = false;
        field_74332_R = "";
        field_74331_S = false;
        field_74326_T = false;
        field_74325_U = false;
        field_74328_V = 1.0F;
        field_74327_W = 1.0F;
        field_74334_X = 0.0F;
        field_74333_Y = 0.0F;
        field_74335_Z = 0;
        field_74362_aa = 0;
        field_74363_ab = "en_US";
    }

    public String func_74302_a(int p_74302_1_)
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        return stringtranslate.func_74805_b(field_74324_K[p_74302_1_].field_74515_c);
    }

    public String func_74301_b(int p_74301_1_)
    {
        int i = field_74324_K[p_74301_1_].field_74512_d;
        return func_74298_c(i);
    }

    public static String func_74298_c(int p_74298_0_)
    {
        if(p_74298_0_ < 0)
        {
            return StatCollector.func_74837_a("key.mouseButton", new Object[] {
                Integer.valueOf(p_74298_0_ + 101)
            });
        } else
        {
            return Keyboard.getKeyName(p_74298_0_);
        }
    }

    public void func_74307_a(int p_74307_1_, int p_74307_2_)
    {
        field_74324_K[p_74307_1_].field_74512_d = p_74307_2_;
        func_74303_b();
    }

    public void func_74304_a(EnumOptions p_74304_1_, float p_74304_2_)
    {
        if(p_74304_1_ == EnumOptions.MUSIC)
        {
            field_74342_a = p_74304_2_;
            field_74317_L.field_71416_A.func_77367_a();
        }
        if(p_74304_1_ == EnumOptions.SOUND)
        {
            field_74340_b = p_74304_2_;
            field_74317_L.field_71416_A.func_77367_a();
        }
        if(p_74304_1_ == EnumOptions.SENSITIVITY)
        {
            field_74341_c = p_74304_2_;
        }
        if(p_74304_1_ == EnumOptions.FOV)
        {
            field_74334_X = p_74304_2_;
        }
        if(p_74304_1_ == EnumOptions.GAMMA)
        {
            field_74333_Y = p_74304_2_;
        }
        if(p_74304_1_ == EnumOptions.CHAT_OPACITY)
        {
            field_74357_r = p_74304_2_;
        }
    }

    public void func_74306_a(EnumOptions p_74306_1_, int p_74306_2_)
    {
        if(p_74306_1_ == EnumOptions.INVERT_MOUSE)
        {
            field_74338_d = !field_74338_d;
        }
        if(p_74306_1_ == EnumOptions.RENDER_DISTANCE)
        {
            field_74339_e = field_74339_e + p_74306_2_ & 3;
        }
        if(p_74306_1_ == EnumOptions.GUI_SCALE)
        {
            field_74335_Z = field_74335_Z + p_74306_2_ & 3;
        }
        if(p_74306_1_ == EnumOptions.PARTICLES)
        {
            field_74362_aa = (field_74362_aa + p_74306_2_) % 3;
        }
        if(p_74306_1_ == EnumOptions.VIEW_BOBBING)
        {
            field_74336_f = !field_74336_f;
        }
        if(p_74306_1_ == EnumOptions.RENDER_CLOUDS)
        {
            field_74345_l = !field_74345_l;
        }
        if(p_74306_1_ == EnumOptions.ADVANCED_OPENGL)
        {
            field_74349_h = !field_74349_h;
            field_74317_L.field_71438_f.func_72712_a();
        }
        if(p_74306_1_ == EnumOptions.ANAGLYPH)
        {
            field_74337_g = !field_74337_g;
            field_74317_L.field_71446_o.func_78352_b();
        }
        if(p_74306_1_ == EnumOptions.FRAMERATE_LIMIT)
        {
            field_74350_i = (field_74350_i + p_74306_2_ + 3) % 3;
        }
        if(p_74306_1_ == EnumOptions.DIFFICULTY)
        {
            field_74318_M = field_74318_M + p_74306_2_ & 3;
        }
        if(p_74306_1_ == EnumOptions.GRAPHICS)
        {
            field_74347_j = !field_74347_j;
            field_74317_L.field_71438_f.func_72712_a();
        }
        if(p_74306_1_ == EnumOptions.AMBIENT_OCCLUSION)
        {
            field_74348_k = !field_74348_k;
            field_74317_L.field_71438_f.func_72712_a();
        }
        if(p_74306_1_ == EnumOptions.CHAT_VISIBILITY)
        {
            field_74343_n = (field_74343_n + p_74306_2_) % 3;
        }
        if(p_74306_1_ == EnumOptions.CHAT_COLOR)
        {
            field_74344_o = !field_74344_o;
        }
        if(p_74306_1_ == EnumOptions.CHAT_LINKS)
        {
            field_74359_p = !field_74359_p;
        }
        if(p_74306_1_ == EnumOptions.CHAT_LINKS_PROMPT)
        {
            field_74358_q = !field_74358_q;
        }
        if(p_74306_1_ == EnumOptions.USE_SERVER_TEXTURES)
        {
            field_74356_s = !field_74356_s;
        }
        if(p_74306_1_ == EnumOptions.SNOOPER_ENABLED)
        {
            field_74355_t = !field_74355_t;
        }
        if(p_74306_1_ == EnumOptions.USE_FULLSCREEN)
        {
            field_74353_u = !field_74353_u;
            if(field_74317_L.func_71372_G() != field_74353_u)
            {
                field_74317_L.func_71352_k();
            }
        }
        if(p_74306_1_ == EnumOptions.ENABLE_VSYNC)
        {
            field_74352_v = !field_74352_v;
            Display.setVSyncEnabled(field_74352_v);
        }
        func_74303_b();
    }

    public float func_74296_a(EnumOptions p_74296_1_)
    {
        if(p_74296_1_ == EnumOptions.FOV)
        {
            return field_74334_X;
        }
        if(p_74296_1_ == EnumOptions.GAMMA)
        {
            return field_74333_Y;
        }
        if(p_74296_1_ == EnumOptions.MUSIC)
        {
            return field_74342_a;
        }
        if(p_74296_1_ == EnumOptions.SOUND)
        {
            return field_74340_b;
        }
        if(p_74296_1_ == EnumOptions.SENSITIVITY)
        {
            return field_74341_c;
        }
        if(p_74296_1_ == EnumOptions.CHAT_OPACITY)
        {
            return field_74357_r;
        } else
        {
            return 0.0F;
        }
    }

    public boolean func_74308_b(EnumOptions p_74308_1_)
    {
        switch(EnumOptionsHelper.field_74414_a[p_74308_1_.ordinal()])
        {
        case 1: // '\001'
            return field_74338_d;

        case 2: // '\002'
            return field_74336_f;

        case 3: // '\003'
            return field_74337_g;

        case 4: // '\004'
            return field_74349_h;

        case 5: // '\005'
            return field_74348_k;

        case 6: // '\006'
            return field_74345_l;

        case 7: // '\007'
            return field_74344_o;

        case 8: // '\b'
            return field_74359_p;

        case 9: // '\t'
            return field_74358_q;

        case 10: // '\n'
            return field_74356_s;

        case 11: // '\013'
            return field_74355_t;

        case 12: // '\f'
            return field_74353_u;

        case 13: // '\r'
            return field_74352_v;
        }
        return false;
    }

    private static String func_74299_a(String p_74299_0_[], int p_74299_1_)
    {
        if(p_74299_1_ < 0 || p_74299_1_ >= p_74299_0_.length)
        {
            p_74299_1_ = 0;
        }
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        return stringtranslate.func_74805_b(p_74299_0_[p_74299_1_]);
    }

    public String func_74297_c(EnumOptions p_74297_1_)
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        String s = (new StringBuilder()).append(stringtranslate.func_74805_b(p_74297_1_.func_74378_d())).append(": ").toString();
        if(p_74297_1_.func_74380_a())
        {
            float f = func_74296_a(p_74297_1_);
            if(p_74297_1_ == EnumOptions.SENSITIVITY)
            {
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.sensitivity.min")).toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.sensitivity.max")).toString();
                } else
                {
                    return (new StringBuilder()).append(s).append((int)(f * 200F)).append("%").toString();
                }
            }
            if(p_74297_1_ == EnumOptions.FOV)
            {
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.fov.min")).toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.fov.max")).toString();
                } else
                {
                    return (new StringBuilder()).append(s).append((int)(70F + f * 40F)).toString();
                }
            }
            if(p_74297_1_ == EnumOptions.GAMMA)
            {
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.gamma.min")).toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.gamma.max")).toString();
                } else
                {
                    return (new StringBuilder()).append(s).append("+").append((int)(f * 100F)).append("%").toString();
                }
            }
            if(p_74297_1_ == EnumOptions.CHAT_OPACITY)
            {
                return (new StringBuilder()).append(s).append((int)(f * 90F + 10F)).append("%").toString();
            }
            if(f == 0.0F)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.off")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append((int)(f * 100F)).append("%").toString();
            }
        }
        if(p_74297_1_.func_74382_b())
        {
            boolean flag = func_74308_b(p_74297_1_);
            if(flag)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.on")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.off")).toString();
            }
        }
        if(p_74297_1_ == EnumOptions.RENDER_DISTANCE)
        {
            return (new StringBuilder()).append(s).append(func_74299_a(field_74360_ac, field_74339_e)).toString();
        }
        if(p_74297_1_ == EnumOptions.DIFFICULTY)
        {
            return (new StringBuilder()).append(s).append(func_74299_a(field_74361_ad, field_74318_M)).toString();
        }
        if(p_74297_1_ == EnumOptions.GUI_SCALE)
        {
            return (new StringBuilder()).append(s).append(func_74299_a(field_74367_ae, field_74335_Z)).toString();
        }
        if(p_74297_1_ == EnumOptions.CHAT_VISIBILITY)
        {
            return (new StringBuilder()).append(s).append(func_74299_a(field_74369_af, field_74343_n)).toString();
        }
        if(p_74297_1_ == EnumOptions.PARTICLES)
        {
            return (new StringBuilder()).append(s).append(func_74299_a(field_74364_ag, field_74362_aa)).toString();
        }
        if(p_74297_1_ == EnumOptions.FRAMERATE_LIMIT)
        {
            return (new StringBuilder()).append(s).append(func_74299_a(field_74365_ah, field_74350_i)).toString();
        }
        if(p_74297_1_ == EnumOptions.GRAPHICS)
        {
            if(field_74347_j)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.graphics.fancy")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_74805_b("options.graphics.fast")).toString();
            }
        } else
        {
            return s;
        }
    }

    public void func_74300_a()
    {
        try
        {
            if(!field_74354_ai.exists())
            {
                return;
            }
            BufferedReader bufferedreader = new BufferedReader(new FileReader(field_74354_ai));
            for(String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                try
                {
                    String as[] = s.split(":");
                    if(as[0].equals("music"))
                    {
                        field_74342_a = func_74305_a(as[1]);
                    }
                    if(as[0].equals("sound"))
                    {
                        field_74340_b = func_74305_a(as[1]);
                    }
                    if(as[0].equals("mouseSensitivity"))
                    {
                        field_74341_c = func_74305_a(as[1]);
                    }
                    if(as[0].equals("fov"))
                    {
                        field_74334_X = func_74305_a(as[1]);
                    }
                    if(as[0].equals("gamma"))
                    {
                        field_74333_Y = func_74305_a(as[1]);
                    }
                    if(as[0].equals("invertYMouse"))
                    {
                        field_74338_d = as[1].equals("true");
                    }
                    if(as[0].equals("viewDistance"))
                    {
                        field_74339_e = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("guiScale"))
                    {
                        field_74335_Z = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("particles"))
                    {
                        field_74362_aa = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("bobView"))
                    {
                        field_74336_f = as[1].equals("true");
                    }
                    if(as[0].equals("anaglyph3d"))
                    {
                        field_74337_g = as[1].equals("true");
                    }
                    if(as[0].equals("advancedOpengl"))
                    {
                        field_74349_h = as[1].equals("true");
                    }
                    if(as[0].equals("fpsLimit"))
                    {
                        field_74350_i = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("difficulty"))
                    {
                        field_74318_M = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("fancyGraphics"))
                    {
                        field_74347_j = as[1].equals("true");
                    }
                    if(as[0].equals("ao"))
                    {
                        field_74348_k = as[1].equals("true");
                    }
                    if(as[0].equals("clouds"))
                    {
                        field_74345_l = as[1].equals("true");
                    }
                    if(as[0].equals("skin"))
                    {
                        field_74346_m = as[1];
                    }
                    if(as[0].equals("lastServer") && as.length >= 2)
                    {
                        field_74332_R = as[1];
                    }
                    if(as[0].equals("lang") && as.length >= 2)
                    {
                        field_74363_ab = as[1];
                    }
                    if(as[0].equals("chatVisibility"))
                    {
                        field_74343_n = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("chatColors"))
                    {
                        field_74344_o = as[1].equals("true");
                    }
                    if(as[0].equals("chatLinks"))
                    {
                        field_74359_p = as[1].equals("true");
                    }
                    if(as[0].equals("chatLinksPrompt"))
                    {
                        field_74358_q = as[1].equals("true");
                    }
                    if(as[0].equals("chatOpacity"))
                    {
                        field_74357_r = func_74305_a(as[1]);
                    }
                    if(as[0].equals("serverTextures"))
                    {
                        field_74356_s = as[1].equals("true");
                    }
                    if(as[0].equals("snooperEnabled"))
                    {
                        field_74355_t = as[1].equals("true");
                    }
                    if(as[0].equals("fullscreen"))
                    {
                        field_74353_u = as[1].equals("true");
                    }
                    if(as[0].equals("enableVsync"))
                    {
                        field_74352_v = as[1].equals("true");
                    }
                    KeyBinding akeybinding[] = field_74324_K;
                    int i = akeybinding.length;
                    int j = 0;
                    while(j < i) 
                    {
                        KeyBinding keybinding = akeybinding[j];
                        if(as[0].equals((new StringBuilder()).append("key_").append(keybinding.field_74515_c).toString()))
                        {
                            keybinding.field_74512_d = Integer.parseInt(as[1]);
                        }
                        j++;
                    }
                }
                catch(Exception exception1)
                {
                    System.out.println((new StringBuilder()).append("Skipping bad option: ").append(s).toString());
                }
            }

            KeyBinding.func_74508_b();
            bufferedreader.close();
        }
        catch(Exception exception)
        {
            System.out.println("Failed to load options");
            exception.printStackTrace();
        }
    }

    private float func_74305_a(String p_74305_1_)
    {
        if(p_74305_1_.equals("true"))
        {
            return 1.0F;
        }
        if(p_74305_1_.equals("false"))
        {
            return 0.0F;
        } else
        {
            return Float.parseFloat(p_74305_1_);
        }
    }

    public void func_74303_b()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(field_74354_ai));
            printwriter.println((new StringBuilder()).append("music:").append(field_74342_a).toString());
            printwriter.println((new StringBuilder()).append("sound:").append(field_74340_b).toString());
            printwriter.println((new StringBuilder()).append("invertYMouse:").append(field_74338_d).toString());
            printwriter.println((new StringBuilder()).append("mouseSensitivity:").append(field_74341_c).toString());
            printwriter.println((new StringBuilder()).append("fov:").append(field_74334_X).toString());
            printwriter.println((new StringBuilder()).append("gamma:").append(field_74333_Y).toString());
            printwriter.println((new StringBuilder()).append("viewDistance:").append(field_74339_e).toString());
            printwriter.println((new StringBuilder()).append("guiScale:").append(field_74335_Z).toString());
            printwriter.println((new StringBuilder()).append("particles:").append(field_74362_aa).toString());
            printwriter.println((new StringBuilder()).append("bobView:").append(field_74336_f).toString());
            printwriter.println((new StringBuilder()).append("anaglyph3d:").append(field_74337_g).toString());
            printwriter.println((new StringBuilder()).append("advancedOpengl:").append(field_74349_h).toString());
            printwriter.println((new StringBuilder()).append("fpsLimit:").append(field_74350_i).toString());
            printwriter.println((new StringBuilder()).append("difficulty:").append(field_74318_M).toString());
            printwriter.println((new StringBuilder()).append("fancyGraphics:").append(field_74347_j).toString());
            printwriter.println((new StringBuilder()).append("ao:").append(field_74348_k).toString());
            printwriter.println((new StringBuilder()).append("clouds:").append(field_74345_l).toString());
            printwriter.println((new StringBuilder()).append("skin:").append(field_74346_m).toString());
            printwriter.println((new StringBuilder()).append("lastServer:").append(field_74332_R).toString());
            printwriter.println((new StringBuilder()).append("lang:").append(field_74363_ab).toString());
            printwriter.println((new StringBuilder()).append("chatVisibility:").append(field_74343_n).toString());
            printwriter.println((new StringBuilder()).append("chatColors:").append(field_74344_o).toString());
            printwriter.println((new StringBuilder()).append("chatLinks:").append(field_74359_p).toString());
            printwriter.println((new StringBuilder()).append("chatLinksPrompt:").append(field_74358_q).toString());
            printwriter.println((new StringBuilder()).append("chatOpacity:").append(field_74357_r).toString());
            printwriter.println((new StringBuilder()).append("serverTextures:").append(field_74356_s).toString());
            printwriter.println((new StringBuilder()).append("snooperEnabled:").append(field_74355_t).toString());
            printwriter.println((new StringBuilder()).append("fullscreen:").append(field_74353_u).toString());
            printwriter.println((new StringBuilder()).append("enableVsync:").append(field_74352_v).toString());
            KeyBinding akeybinding[] = field_74324_K;
            int i = akeybinding.length;
            for(int j = 0; j < i; j++)
            {
                KeyBinding keybinding = akeybinding[j];
                printwriter.println((new StringBuilder()).append("key_").append(keybinding.field_74515_c).append(":").append(keybinding.field_74512_d).toString());
            }

            printwriter.close();
        }
        catch(Exception exception)
        {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }
        if(field_74317_L.field_71439_g != null)
        {
            field_74317_L.field_71439_g.field_71174_a.func_72552_c(new Packet204ClientInfo(field_74363_ab, field_74339_e, field_74343_n, field_74344_o, field_74318_M));
        }
    }

    public boolean func_74309_c()
    {
        return field_74339_e < 2 && field_74345_l;
    }

}
