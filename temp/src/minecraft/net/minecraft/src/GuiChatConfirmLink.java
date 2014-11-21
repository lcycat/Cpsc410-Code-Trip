// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GuiConfirmOpenLink, ChatClickData, GuiChat, GuiScreen

class GuiChatConfirmLink extends GuiConfirmOpenLink
{

    final ChatClickData field_73949_a; /* synthetic field */
    final GuiChat field_73948_b; /* synthetic field */

    GuiChatConfirmLink(GuiChat p_i3045_1_, GuiScreen p_i3045_2_, String p_i3045_3_, int p_i3045_4_, ChatClickData p_i3045_5_)
    {
        field_73948_b = p_i3045_1_;
        field_73949_a = p_i3045_5_;
        super(p_i3045_2_, p_i3045_3_, p_i3045_4_);
    }

    public void func_73945_e()
    {
        func_73865_d(field_73949_a.func_78309_f());
    }
}
