// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, ServerData, ServerList, TexturePackList, 
//            NetClientHandler

class NetClientWebTextures extends GuiScreen
{

    final String field_74244_a; /* synthetic field */
    final NetClientHandler field_74243_b; /* synthetic field */

    NetClientWebTextures(NetClientHandler p_i3099_1_, String p_i3099_2_)
    {
        field_74243_b = p_i3099_1_;
        field_74244_a = p_i3099_2_;
        super();
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        field_73882_e = Minecraft.func_71410_x();
        if(field_73882_e.func_71362_z() != null)
        {
            field_73882_e.func_71362_z().func_78838_a(p_73878_1_);
            ServerList.func_78852_b(field_73882_e.func_71362_z());
        }
        if(p_73878_1_)
        {
            field_73882_e.field_71418_C.func_77296_a(field_74244_a);
        }
        field_73882_e.func_71373_a(null);
    }
}
