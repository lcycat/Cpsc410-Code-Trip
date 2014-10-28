// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            MathHelper, EnumEntitySizeHelper

public final class EnumEntitySize extends Enum
{

    public static final EnumEntitySize SIZE_1;
    public static final EnumEntitySize SIZE_2;
    public static final EnumEntitySize SIZE_3;
    public static final EnumEntitySize SIZE_4;
    public static final EnumEntitySize SIZE_5;
    public static final EnumEntitySize SIZE_6;
    private static final EnumEntitySize $VALUES[]; /* synthetic field */

    public static EnumEntitySize[] values()
    {
        return (EnumEntitySize[])$VALUES.clone();
    }

    public static EnumEntitySize valueOf(String p_valueOf_0_)
    {
        return (EnumEntitySize)Enum.valueOf(net.minecraft.src.EnumEntitySize.class, p_valueOf_0_);
    }

    private EnumEntitySize(String p_i3437_1_, int p_i3437_2_)
    {
        super(p_i3437_1_, p_i3437_2_);
    }

    public int func_75630_a(double p_75630_1_)
    {
        double d = p_75630_1_ - ((double)MathHelper.func_76128_c(p_75630_1_) + 0.5D);
        switch(EnumEntitySizeHelper.field_75628_a[ordinal()])
        {
        case 1: // '\001'
            if(d >= 0.0D ? d < 0.3125D : d < -0.3125D)
            {
                return MathHelper.func_76143_f(p_75630_1_ * 32D);
            } else
            {
                return MathHelper.func_76128_c(p_75630_1_ * 32D);
            }

        case 2: // '\002'
            if(d >= 0.0D ? d < 0.3125D : d < -0.3125D)
            {
                return MathHelper.func_76128_c(p_75630_1_ * 32D);
            } else
            {
                return MathHelper.func_76143_f(p_75630_1_ * 32D);
            }

        case 3: // '\003'
            if(d > 0.0D)
            {
                return MathHelper.func_76128_c(p_75630_1_ * 32D);
            } else
            {
                return MathHelper.func_76143_f(p_75630_1_ * 32D);
            }

        case 4: // '\004'
            if(d >= 0.0D ? d < 0.1875D : d < -0.1875D)
            {
                return MathHelper.func_76143_f(p_75630_1_ * 32D);
            } else
            {
                return MathHelper.func_76128_c(p_75630_1_ * 32D);
            }

        case 5: // '\005'
            if(d >= 0.0D ? d < 0.1875D : d < -0.1875D)
            {
                return MathHelper.func_76128_c(p_75630_1_ * 32D);
            } else
            {
                return MathHelper.func_76143_f(p_75630_1_ * 32D);
            }
        }
        if(d > 0.0D)
        {
            return MathHelper.func_76143_f(p_75630_1_ * 32D);
        } else
        {
            return MathHelper.func_76128_c(p_75630_1_ * 32D);
        }
    }

    static 
    {
        SIZE_1 = new EnumEntitySize("SIZE_1", 0);
        SIZE_2 = new EnumEntitySize("SIZE_2", 1);
        SIZE_3 = new EnumEntitySize("SIZE_3", 2);
        SIZE_4 = new EnumEntitySize("SIZE_4", 3);
        SIZE_5 = new EnumEntitySize("SIZE_5", 4);
        SIZE_6 = new EnumEntitySize("SIZE_6", 5);
        $VALUES = (new EnumEntitySize[] {
            SIZE_1, SIZE_2, SIZE_3, SIZE_4, SIZE_5, SIZE_6
        });
    }
}
