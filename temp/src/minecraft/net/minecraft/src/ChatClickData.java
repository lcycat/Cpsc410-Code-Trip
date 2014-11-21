// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package net.minecraft.src:
//            ChatLine, FontRenderer, StringUtils

public class ChatClickData
{

    public static final Pattern field_78316_a = Pattern.compile("^(?:(https?)://)?([-\\w_\\.]{2,}\\.[a-z]{2,3})(/\\S*)?$");
    private final FontRenderer field_78314_b;
    private final ChatLine field_78315_c;
    private final int field_78312_d;
    private final int field_78313_e;
    private final String field_78310_f;
    private final String field_78311_g = func_78307_h();

    public ChatClickData(FontRenderer p_i3053_1_, ChatLine p_i3053_2_, int p_i3053_3_, int p_i3053_4_)
    {
        field_78314_b = p_i3053_1_;
        field_78315_c = p_i3053_2_;
        field_78312_d = p_i3053_3_;
        field_78313_e = p_i3053_4_;
        field_78310_f = p_i3053_1_.func_78269_a(p_i3053_2_.func_74538_a(), p_i3053_3_);
    }

    public String func_78309_f()
    {
        return field_78311_g;
    }

    public URI func_78308_g()
    {
        String s = func_78309_f();
        if(s == null)
        {
            return null;
        }
        Matcher matcher = field_78316_a.matcher(s);
        if(matcher.matches())
        {
            try
            {
                String s1 = matcher.group(0);
                if(matcher.group(1) == null)
                {
                    s1 = (new StringBuilder()).append("http://").append(s1).toString();
                }
                return new URI(s1);
            }
            catch(URISyntaxException urisyntaxexception)
            {
                Logger.getLogger("Minecraft").log(Level.SEVERE, "Couldn't create URI from chat", urisyntaxexception);
            }
        }
        return null;
    }

    private String func_78307_h()
    {
        int i = field_78310_f.lastIndexOf(" ", field_78310_f.length()) + 1;
        if(i < 0)
        {
            i = 0;
        }
        int j = field_78315_c.func_74538_a().indexOf(" ", i);
        if(j < 0)
        {
            j = field_78315_c.func_74538_a().length();
        }
        return StringUtils.func_76338_a(field_78315_c.func_74538_a().substring(i, j));
    }

}
