// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GuiButton, EnumOptions

public class GuiSmallButton extends GuiButton
{

    private final EnumOptions field_73754_j;

    public GuiSmallButton(int p_i3057_1_, int p_i3057_2_, int p_i3057_3_, String p_i3057_4_)
    {
        this(p_i3057_1_, p_i3057_2_, p_i3057_3_, null, p_i3057_4_);
    }

    public GuiSmallButton(int p_i3058_1_, int p_i3058_2_, int p_i3058_3_, int p_i3058_4_, int p_i3058_5_, String p_i3058_6_)
    {
        super(p_i3058_1_, p_i3058_2_, p_i3058_3_, p_i3058_4_, p_i3058_5_, p_i3058_6_);
        field_73754_j = null;
    }

    public GuiSmallButton(int p_i3059_1_, int p_i3059_2_, int p_i3059_3_, EnumOptions p_i3059_4_, String p_i3059_5_)
    {
        super(p_i3059_1_, p_i3059_2_, p_i3059_3_, 150, 20, p_i3059_5_);
        field_73754_j = p_i3059_4_;
    }

    public EnumOptions func_73753_a()
    {
        return field_73754_j;
    }
}
