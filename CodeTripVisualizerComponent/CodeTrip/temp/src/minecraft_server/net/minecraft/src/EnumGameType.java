// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PlayerCapabilities

public final class EnumGameType extends Enum
{

    public static final EnumGameType NOT_SET;
    public static final EnumGameType SURVIVAL;
    public static final EnumGameType CREATIVE;
    public static final EnumGameType ADVENTURE;
    int field_77154_e;
    String field_77151_f;
    private static final EnumGameType $VALUES[]; /* synthetic field */

    public static EnumGameType[] values()
    {
        return (EnumGameType[])$VALUES.clone();
    }

    public static EnumGameType valueOf(String p_valueOf_0_)
    {
        return (EnumGameType)Enum.valueOf(net.minecraft.src.EnumGameType.class, p_valueOf_0_);
    }

    private EnumGameType(String p_i3734_1_, int p_i3734_2_, int p_i3734_3_, String p_i3734_4_)
    {
        super(p_i3734_1_, p_i3734_2_);
        field_77154_e = p_i3734_3_;
        field_77151_f = p_i3734_4_;
    }

    public int func_77148_a()
    {
        return field_77154_e;
    }

    public String func_77149_b()
    {
        return field_77151_f;
    }

    public void func_77147_a(PlayerCapabilities p_77147_1_)
    {
        if(this == CREATIVE)
        {
            p_77147_1_.field_75101_c = true;
            p_77147_1_.field_75098_d = true;
            p_77147_1_.field_75102_a = true;
        } else
        {
            p_77147_1_.field_75101_c = false;
            p_77147_1_.field_75098_d = false;
            p_77147_1_.field_75102_a = false;
            p_77147_1_.field_75100_b = false;
        }
        p_77147_1_.field_75099_e = !func_77150_c();
    }

    public boolean func_77150_c()
    {
        return this == ADVENTURE;
    }

    public boolean func_77145_d()
    {
        return this == CREATIVE;
    }

    public static EnumGameType func_77146_a(int p_77146_0_)
    {
        EnumGameType aenumgametype[] = values();
        int i = aenumgametype.length;
        for(int j = 0; j < i; j++)
        {
            EnumGameType enumgametype = aenumgametype[j];
            if(enumgametype.field_77154_e == p_77146_0_)
            {
                return enumgametype;
            }
        }

        return SURVIVAL;
    }

    static 
    {
        NOT_SET = new EnumGameType("NOT_SET", 0, -1, "");
        SURVIVAL = new EnumGameType("SURVIVAL", 1, 0, "survival");
        CREATIVE = new EnumGameType("CREATIVE", 2, 1, "creative");
        ADVENTURE = new EnumGameType("ADVENTURE", 3, 2, "adventure");
        $VALUES = (new EnumGameType[] {
            NOT_SET, SURVIVAL, CREATIVE, ADVENTURE
        });
    }
}
