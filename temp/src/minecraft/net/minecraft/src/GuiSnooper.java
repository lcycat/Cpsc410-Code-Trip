// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StatCollector, FontRenderer, GuiButton, 
//            EnumOptions, GameSettings, PlayerUsageSnooper, GuiSnooperList

public class GuiSnooper extends GuiScreen
{

    private final GuiScreen field_74100_a;
    private final GameSettings field_74097_b;
    private final List field_74098_c = new ArrayList();
    private final List field_74096_d = new ArrayList();
    private String field_74103_m;
    private String field_74101_n[];
    private GuiSnooperList field_74102_o;
    private GuiButton field_74099_p;

    public GuiSnooper(GuiScreen p_i3041_1_, GameSettings p_i3041_2_)
    {
        field_74100_a = p_i3041_1_;
        field_74097_b = p_i3041_2_;
    }

    public void func_73866_w_()
    {
        field_74103_m = StatCollector.func_74838_a("options.snooper.title");
        String s = StatCollector.func_74838_a("options.snooper.desc");
        ArrayList arraylist = new ArrayList();
        String s1;
        for(Iterator iterator = field_73886_k.func_78271_c(s, field_73880_f - 30).iterator(); iterator.hasNext(); arraylist.add(s1))
        {
            s1 = (String)iterator.next();
        }

        field_74101_n = (String[])arraylist.toArray(new String[0]);
        field_74098_c.clear();
        field_74096_d.clear();
        field_73887_h.add(field_74099_p = new GuiButton(1, field_73880_f / 2 - 152, field_73881_g - 30, 150, 20, field_74097_b.func_74297_c(EnumOptions.SNOOPER_ENABLED)));
        field_73887_h.add(new GuiButton(2, field_73880_f / 2 + 2, field_73881_g - 30, 150, 20, StatCollector.func_74838_a("gui.done")));
        java.util.Map.Entry entry;
        for(Iterator iterator1 = (new TreeMap(field_73882_e.func_71378_E().func_76465_c())).entrySet().iterator(); iterator1.hasNext(); field_74096_d.add(field_73886_k.func_78269_a((String)entry.getValue(), field_73880_f - 210)))
        {
            entry = (java.util.Map.Entry)iterator1.next();
            field_74098_c.add(entry.getKey());
        }

        field_74102_o = new GuiSnooperList(this);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 2)
        {
            field_74097_b.func_74303_b();
            field_74097_b.func_74303_b();
            field_73882_e.func_71373_a(field_74100_a);
        }
        if(p_73875_1_.field_73741_f == 1)
        {
            field_74097_b.func_74306_a(EnumOptions.SNOOPER_ENABLED, 1);
            field_74099_p.field_73744_e = field_74097_b.func_74297_c(EnumOptions.SNOOPER_ENABLED);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        field_74102_o.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
        func_73732_a(field_73886_k, field_74103_m, field_73880_f / 2, 8, 0xffffff);
        int i = 22;
        String as[] = field_74101_n;
        int j = as.length;
        for(int k = 0; k < j; k++)
        {
            String s = as[k];
            func_73732_a(field_73886_k, s, field_73880_f / 2, i, 0x808080);
            i += field_73886_k.field_78288_b;
        }

        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    static List func_74095_a(GuiSnooper p_74095_0_)
    {
        return p_74095_0_.field_74098_c;
    }

    static List func_74094_b(GuiSnooper p_74094_0_)
    {
        return p_74094_0_.field_74096_d;
    }
}
