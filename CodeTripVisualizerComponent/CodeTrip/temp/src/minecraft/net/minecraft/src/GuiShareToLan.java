// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiButton, StatCollector, StringTranslate, 
//            EnumGameType, IntegratedServer, EntityClientPlayerMP, GuiIngame, 
//            GuiNewChat

public class GuiShareToLan extends GuiScreen
{

    private final GuiScreen field_74092_a;
    private GuiButton field_74090_b;
    private GuiButton field_74091_c;
    private String field_74089_d;
    private boolean field_74093_m;

    public GuiShareToLan(GuiScreen p_i3054_1_)
    {
        field_74089_d = "survival";
        field_74093_m = false;
        field_74092_a = p_i3054_1_;
    }

    public void func_73866_w_()
    {
        field_73887_h.clear();
        field_73887_h.add(new GuiButton(101, field_73880_f / 2 - 155, field_73881_g - 28, 150, 20, StatCollector.func_74838_a("lanServer.start")));
        field_73887_h.add(new GuiButton(102, field_73880_f / 2 + 5, field_73881_g - 28, 150, 20, StatCollector.func_74838_a("gui.cancel")));
        field_73887_h.add(field_74091_c = new GuiButton(104, field_73880_f / 2 - 155, 100, 150, 20, StatCollector.func_74838_a("selectWorld.gameMode")));
        field_73887_h.add(field_74090_b = new GuiButton(103, field_73880_f / 2 + 5, 100, 150, 20, StatCollector.func_74838_a("selectWorld.allowCommands")));
        func_74088_g();
    }

    private void func_74088_g()
    {
        StringTranslate stringtranslate;
        stringtranslate = StringTranslate.func_74808_a();
        field_74091_c.field_73744_e = (new StringBuilder()).append(stringtranslate.func_74805_b("selectWorld.gameMode")).append(" ").append(stringtranslate.func_74805_b((new StringBuilder()).append("selectWorld.gameMode.").append(field_74089_d).toString())).toString();
        field_74090_b.field_73744_e = (new StringBuilder()).append(stringtranslate.func_74805_b("selectWorld.allowCommands")).append(" ").toString();
        if(!field_74093_m) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        field_74090_b;
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
        field_74090_b;
        JVM INSTR dup_x1 ;
        field_73744_e;
        append();
        stringtranslate.func_74805_b("options.off");
        append();
        toString();
        field_73744_e;
_L3:
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 102)
        {
            field_73882_e.func_71373_a(field_74092_a);
        } else
        if(p_73875_1_.field_73741_f == 104)
        {
            if(field_74089_d.equals("survival"))
            {
                field_74089_d = "creative";
            } else
            if(field_74089_d.equals("creative"))
            {
                field_74089_d = "adventure";
            } else
            {
                field_74089_d = "survival";
            }
            func_74088_g();
        } else
        if(p_73875_1_.field_73741_f == 103)
        {
            field_74093_m = !field_74093_m;
            func_74088_g();
        } else
        if(p_73875_1_.field_73741_f == 101)
        {
            field_73882_e.func_71373_a(null);
            String s = field_73882_e.func_71401_C().func_71206_a(EnumGameType.func_77142_a(field_74089_d), field_74093_m);
            String s1 = "";
            if(s != null)
            {
                s1 = field_73882_e.field_71439_g.func_70004_a("commands.publish.started", new Object[] {
                    s
                });
            } else
            {
                s1 = field_73882_e.field_71439_g.func_70004_a("commands.publish.failed", new Object[0]);
            }
            field_73882_e.field_71456_v.func_73827_b().func_73765_a(s1);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, StatCollector.func_74838_a("lanServer.title"), field_73880_f / 2, 50, 0xffffff);
        func_73732_a(field_73886_k, StatCollector.func_74838_a("lanServer.otherPlayers"), field_73880_f / 2, 82, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
