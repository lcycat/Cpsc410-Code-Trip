// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTTagEnd, NBTTagByte, NBTTagShort, NBTTagInt, 
//            NBTTagLong, NBTTagFloat, NBTTagDouble, NBTTagByteArray, 
//            NBTTagIntArray, NBTTagString, NBTTagList, NBTTagCompound

public abstract class NBTBase
{

    private String field_74741_a;

    abstract void func_74734_a(DataOutput dataoutput)
        throws IOException;

    abstract void func_74735_a(DataInput datainput)
        throws IOException;

    public abstract byte func_74732_a();

    protected NBTBase(String p_i3281_1_)
    {
        if(p_i3281_1_ == null)
        {
            field_74741_a = "";
        } else
        {
            field_74741_a = p_i3281_1_;
        }
    }

    public NBTBase func_74738_o(String p_74738_1_)
    {
        if(p_74738_1_ == null)
        {
            field_74741_a = "";
        } else
        {
            field_74741_a = p_74738_1_;
        }
        return this;
    }

    public String func_74740_e()
    {
        if(field_74741_a == null)
        {
            return "";
        } else
        {
            return field_74741_a;
        }
    }

    public static NBTBase func_74739_b(DataInput p_74739_0_)
        throws IOException
    {
        byte byte0 = p_74739_0_.readByte();
        if(byte0 == 0)
        {
            return new NBTTagEnd();
        } else
        {
            String s = p_74739_0_.readUTF();
            NBTBase nbtbase = func_74733_a(byte0, s);
            nbtbase.func_74735_a(p_74739_0_);
            return nbtbase;
        }
    }

    public static void func_74731_a(NBTBase p_74731_0_, DataOutput p_74731_1_)
        throws IOException
    {
        p_74731_1_.writeByte(p_74731_0_.func_74732_a());
        if(p_74731_0_.func_74732_a() == 0)
        {
            return;
        } else
        {
            p_74731_1_.writeUTF(p_74731_0_.func_74740_e());
            p_74731_0_.func_74734_a(p_74731_1_);
            return;
        }
    }

    public static NBTBase func_74733_a(byte p_74733_0_, String p_74733_1_)
    {
        switch(p_74733_0_)
        {
        case 0: // '\0'
            return new NBTTagEnd();

        case 1: // '\001'
            return new NBTTagByte(p_74733_1_);

        case 2: // '\002'
            return new NBTTagShort(p_74733_1_);

        case 3: // '\003'
            return new NBTTagInt(p_74733_1_);

        case 4: // '\004'
            return new NBTTagLong(p_74733_1_);

        case 5: // '\005'
            return new NBTTagFloat(p_74733_1_);

        case 6: // '\006'
            return new NBTTagDouble(p_74733_1_);

        case 7: // '\007'
            return new NBTTagByteArray(p_74733_1_);

        case 11: // '\013'
            return new NBTTagIntArray(p_74733_1_);

        case 8: // '\b'
            return new NBTTagString(p_74733_1_);

        case 9: // '\t'
            return new NBTTagList(p_74733_1_);

        case 10: // '\n'
            return new NBTTagCompound(p_74733_1_);
        }
        return null;
    }

    public static String func_74736_a(byte p_74736_0_)
    {
        switch(p_74736_0_)
        {
        case 0: // '\0'
            return "TAG_End";

        case 1: // '\001'
            return "TAG_Byte";

        case 2: // '\002'
            return "TAG_Short";

        case 3: // '\003'
            return "TAG_Int";

        case 4: // '\004'
            return "TAG_Long";

        case 5: // '\005'
            return "TAG_Float";

        case 6: // '\006'
            return "TAG_Double";

        case 7: // '\007'
            return "TAG_Byte_Array";

        case 11: // '\013'
            return "TAG_Int_Array";

        case 8: // '\b'
            return "TAG_String";

        case 9: // '\t'
            return "TAG_List";

        case 10: // '\n'
            return "TAG_Compound";
        }
        return "UNKNOWN";
    }

    public abstract NBTBase func_74737_b();

    public boolean equals(Object p_equals_1_)
    {
        if(!(p_equals_1_ instanceof NBTBase))
        {
            return false;
        }
        NBTBase nbtbase = (NBTBase)p_equals_1_;
        if(func_74732_a() != nbtbase.func_74732_a())
        {
            return false;
        }
        if(field_74741_a == null && nbtbase.field_74741_a != null || field_74741_a != null && nbtbase.field_74741_a == null)
        {
            return false;
        }
        return field_74741_a == null || field_74741_a.equals(nbtbase.field_74741_a);
    }

    public int hashCode()
    {
        return field_74741_a.hashCode() ^ func_74732_a();
    }
}
