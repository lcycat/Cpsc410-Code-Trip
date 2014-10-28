// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ICommandSender, StringTranslate

public class RConConsoleSource
    implements ICommandSender
{

    public static final RConConsoleSource field_70010_a = new RConConsoleSource();
    private StringBuffer field_70009_b;

    public RConConsoleSource()
    {
        field_70009_b = new StringBuffer();
    }

    public void func_70007_b()
    {
        field_70009_b.setLength(0);
    }

    public String func_70008_c()
    {
        return field_70009_b.toString();
    }

    public String func_70005_c_()
    {
        return "Rcon";
    }

    public void func_70006_a(String p_70006_1_)
    {
        field_70009_b.append(p_70006_1_);
    }

    public boolean func_70003_b(String p_70003_1_)
    {
        return true;
    }

    public String func_70004_a(String p_70004_1_, Object p_70004_2_[])
    {
        return StringTranslate.func_74808_a().func_74803_a(p_70004_1_, p_70004_2_);
    }

}
