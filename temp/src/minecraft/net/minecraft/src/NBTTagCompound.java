// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase, NBTTagByte, NBTTagShort, NBTTagInt, 
//            NBTTagLong, NBTTagFloat, NBTTagDouble, NBTTagString, 
//            NBTTagByteArray, NBTTagIntArray, NBTTagList

public class NBTTagCompound extends NBTBase
{

    private Map field_74784_a;

    public NBTTagCompound()
    {
        super("");
        field_74784_a = new HashMap();
    }

    public NBTTagCompound(String p_i3265_1_)
    {
        super(p_i3265_1_);
        field_74784_a = new HashMap();
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        NBTBase nbtbase;
        for(Iterator iterator = field_74784_a.values().iterator(); iterator.hasNext(); NBTBase.func_74731_a(nbtbase, p_74734_1_))
        {
            nbtbase = (NBTBase)iterator.next();
        }

        p_74734_1_.writeByte(0);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74784_a.clear();
        NBTBase nbtbase;
        for(; (nbtbase = NBTBase.func_74739_b(p_74735_1_)).func_74732_a() != 0; field_74784_a.put(nbtbase.func_74740_e(), nbtbase)) { }
    }

    public Collection func_74758_c()
    {
        return field_74784_a.values();
    }

    public byte func_74732_a()
    {
        return 10;
    }

    public void func_74782_a(String p_74782_1_, NBTBase p_74782_2_)
    {
        field_74784_a.put(p_74782_1_, p_74782_2_.func_74738_o(p_74782_1_));
    }

    public void func_74774_a(String p_74774_1_, byte p_74774_2_)
    {
        field_74784_a.put(p_74774_1_, new NBTTagByte(p_74774_1_, p_74774_2_));
    }

    public void func_74777_a(String p_74777_1_, short p_74777_2_)
    {
        field_74784_a.put(p_74777_1_, new NBTTagShort(p_74777_1_, p_74777_2_));
    }

    public void func_74768_a(String p_74768_1_, int p_74768_2_)
    {
        field_74784_a.put(p_74768_1_, new NBTTagInt(p_74768_1_, p_74768_2_));
    }

    public void func_74772_a(String p_74772_1_, long p_74772_2_)
    {
        field_74784_a.put(p_74772_1_, new NBTTagLong(p_74772_1_, p_74772_2_));
    }

    public void func_74776_a(String p_74776_1_, float p_74776_2_)
    {
        field_74784_a.put(p_74776_1_, new NBTTagFloat(p_74776_1_, p_74776_2_));
    }

    public void func_74780_a(String p_74780_1_, double p_74780_2_)
    {
        field_74784_a.put(p_74780_1_, new NBTTagDouble(p_74780_1_, p_74780_2_));
    }

    public void func_74778_a(String p_74778_1_, String p_74778_2_)
    {
        field_74784_a.put(p_74778_1_, new NBTTagString(p_74778_1_, p_74778_2_));
    }

    public void func_74773_a(String p_74773_1_, byte p_74773_2_[])
    {
        field_74784_a.put(p_74773_1_, new NBTTagByteArray(p_74773_1_, p_74773_2_));
    }

    public void func_74783_a(String p_74783_1_, int p_74783_2_[])
    {
        field_74784_a.put(p_74783_1_, new NBTTagIntArray(p_74783_1_, p_74783_2_));
    }

    public void func_74766_a(String p_74766_1_, NBTTagCompound p_74766_2_)
    {
        field_74784_a.put(p_74766_1_, p_74766_2_.func_74738_o(p_74766_1_));
    }

    public void func_74757_a(String p_74757_1_, boolean p_74757_2_)
    {
        func_74774_a(p_74757_1_, ((byte)(p_74757_2_ ? 1 : 0)));
    }

    public NBTBase func_74781_a(String p_74781_1_)
    {
        return (NBTBase)field_74784_a.get(p_74781_1_);
    }

    public boolean func_74764_b(String p_74764_1_)
    {
        return field_74784_a.containsKey(p_74764_1_);
    }

    public byte func_74771_c(String p_74771_1_)
    {
        if(!field_74784_a.containsKey(p_74771_1_))
        {
            return 0;
        } else
        {
            return ((NBTTagByte)field_74784_a.get(p_74771_1_)).field_74756_a;
        }
    }

    public short func_74765_d(String p_74765_1_)
    {
        if(!field_74784_a.containsKey(p_74765_1_))
        {
            return 0;
        } else
        {
            return ((NBTTagShort)field_74784_a.get(p_74765_1_)).field_74752_a;
        }
    }

    public int func_74762_e(String p_74762_1_)
    {
        if(!field_74784_a.containsKey(p_74762_1_))
        {
            return 0;
        } else
        {
            return ((NBTTagInt)field_74784_a.get(p_74762_1_)).field_74748_a;
        }
    }

    public long func_74763_f(String p_74763_1_)
    {
        if(!field_74784_a.containsKey(p_74763_1_))
        {
            return 0L;
        } else
        {
            return ((NBTTagLong)field_74784_a.get(p_74763_1_)).field_74753_a;
        }
    }

    public float func_74760_g(String p_74760_1_)
    {
        if(!field_74784_a.containsKey(p_74760_1_))
        {
            return 0.0F;
        } else
        {
            return ((NBTTagFloat)field_74784_a.get(p_74760_1_)).field_74750_a;
        }
    }

    public double func_74769_h(String p_74769_1_)
    {
        if(!field_74784_a.containsKey(p_74769_1_))
        {
            return 0.0D;
        } else
        {
            return ((NBTTagDouble)field_74784_a.get(p_74769_1_)).field_74755_a;
        }
    }

    public String func_74779_i(String p_74779_1_)
    {
        if(!field_74784_a.containsKey(p_74779_1_))
        {
            return "";
        } else
        {
            return ((NBTTagString)field_74784_a.get(p_74779_1_)).field_74751_a;
        }
    }

    public byte[] func_74770_j(String p_74770_1_)
    {
        if(!field_74784_a.containsKey(p_74770_1_))
        {
            return new byte[0];
        } else
        {
            return ((NBTTagByteArray)field_74784_a.get(p_74770_1_)).field_74754_a;
        }
    }

    public int[] func_74759_k(String p_74759_1_)
    {
        if(!field_74784_a.containsKey(p_74759_1_))
        {
            return new int[0];
        } else
        {
            return ((NBTTagIntArray)field_74784_a.get(p_74759_1_)).field_74749_a;
        }
    }

    public NBTTagCompound func_74775_l(String p_74775_1_)
    {
        if(!field_74784_a.containsKey(p_74775_1_))
        {
            return new NBTTagCompound(p_74775_1_);
        } else
        {
            return (NBTTagCompound)field_74784_a.get(p_74775_1_);
        }
    }

    public NBTTagList func_74761_m(String p_74761_1_)
    {
        if(!field_74784_a.containsKey(p_74761_1_))
        {
            return new NBTTagList(p_74761_1_);
        } else
        {
            return (NBTTagList)field_74784_a.get(p_74761_1_);
        }
    }

    public boolean func_74767_n(String p_74767_1_)
    {
        return func_74771_c(p_74767_1_) != 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74784_a.size()).append(" entries").toString();
    }

    public NBTBase func_74737_b()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound(func_74740_e());
        String s;
        for(Iterator iterator = field_74784_a.keySet().iterator(); iterator.hasNext(); nbttagcompound.func_74782_a(s, ((NBTBase)field_74784_a.get(s)).func_74737_b()))
        {
            s = (String)iterator.next();
        }

        return nbttagcompound;
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)p_equals_1_;
            return field_74784_a.entrySet().equals(nbttagcompound.field_74784_a.entrySet());
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ field_74784_a.hashCode();
    }
}
