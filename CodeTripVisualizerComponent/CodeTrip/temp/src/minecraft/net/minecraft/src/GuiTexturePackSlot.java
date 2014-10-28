// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiTexturePacks, TexturePackList, TexturePackBase, 
//            RenderEngine, Tessellator

class GuiTexturePackSlot extends GuiSlot
{

    final GuiTexturePacks field_77270_a; /* synthetic field */

    public GuiTexturePackSlot(GuiTexturePacks p_i3026_1_)
    {
        field_77270_a = p_i3026_1_;
        super(GuiTexturePacks.func_73950_a(p_i3026_1_), p_i3026_1_.field_73880_f, p_i3026_1_.field_73881_g, 32, (p_i3026_1_.field_73881_g - 55) + 4, 36);
    }

    protected int func_77217_a()
    {
        return GuiTexturePacks.func_73955_b(field_77270_a).field_71418_C.func_77293_d().size();
    }

    protected void func_77213_a(int p_77213_1_, boolean p_77213_2_)
    {
        List list = GuiTexturePacks.func_73958_c(field_77270_a).field_71418_C.func_77293_d();
        try
        {
            GuiTexturePacks.func_73951_d(field_77270_a).field_71418_C.func_77294_a((TexturePackBase)list.get(p_77213_1_));
            GuiTexturePacks.func_73952_e(field_77270_a).field_71446_o.func_78352_b();
        }
        catch(Exception exception)
        {
            GuiTexturePacks.func_73962_f(field_77270_a).field_71418_C.func_77294_a((TexturePackBase)list.get(0));
            GuiTexturePacks.func_73959_g(field_77270_a).field_71446_o.func_78352_b();
        }
    }

    protected boolean func_77218_a(int p_77218_1_)
    {
        List list = GuiTexturePacks.func_73957_h(field_77270_a).field_71418_C.func_77293_d();
        return GuiTexturePacks.func_73956_i(field_77270_a).field_71418_C.func_77292_e() == list.get(p_77218_1_);
    }

    protected int func_77212_b()
    {
        return func_77217_a() * 36;
    }

    protected void func_77221_c()
    {
        field_77270_a.func_73873_v_();
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        TexturePackBase texturepackbase = (TexturePackBase)GuiTexturePacks.func_73953_j(field_77270_a).field_71418_C.func_77293_d().get(p_77214_1_);
        texturepackbase.func_77535_b(GuiTexturePacks.func_73961_k(field_77270_a).field_71446_o);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        p_77214_5_.func_78382_b();
        p_77214_5_.func_78378_d(0xffffff);
        p_77214_5_.func_78374_a(p_77214_2_, p_77214_3_ + p_77214_4_, 0.0D, 0.0D, 1.0D);
        p_77214_5_.func_78374_a(p_77214_2_ + 32, p_77214_3_ + p_77214_4_, 0.0D, 1.0D, 1.0D);
        p_77214_5_.func_78374_a(p_77214_2_ + 32, p_77214_3_, 0.0D, 1.0D, 0.0D);
        p_77214_5_.func_78374_a(p_77214_2_, p_77214_3_, 0.0D, 0.0D, 0.0D);
        p_77214_5_.func_78381_a();
        field_77270_a.func_73731_b(GuiTexturePacks.func_73960_l(field_77270_a), texturepackbase.func_77538_c(), p_77214_2_ + 32 + 2, p_77214_3_ + 1, 0xffffff);
        field_77270_a.func_73731_b(GuiTexturePacks.func_73963_m(field_77270_a), texturepackbase.func_77531_d(), p_77214_2_ + 32 + 2, p_77214_3_ + 12, 0x808080);
        field_77270_a.func_73731_b(GuiTexturePacks.func_73954_n(field_77270_a), texturepackbase.func_77537_e(), p_77214_2_ + 32 + 2, p_77214_3_ + 12 + 10, 0x808080);
    }
}
