// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            SoundPoolEntry

public class SoundPool
{

    private Random field_77464_c;
    private Map field_77461_d;
    private List field_77462_e;
    public int field_77465_a;
    public boolean field_77463_b;

    public SoundPool()
    {
        field_77464_c = new Random();
        field_77461_d = new HashMap();
        field_77462_e = new ArrayList();
        field_77465_a = 0;
        field_77463_b = true;
    }

    public SoundPoolEntry func_77459_a(String p_77459_1_, File p_77459_2_)
    {
        try
        {
            String s = p_77459_1_;
            p_77459_1_ = p_77459_1_.substring(0, p_77459_1_.indexOf("."));
            if(field_77463_b)
            {
                for(; Character.isDigit(p_77459_1_.charAt(p_77459_1_.length() - 1)); p_77459_1_ = p_77459_1_.substring(0, p_77459_1_.length() - 1)) { }
            }
            p_77459_1_ = p_77459_1_.replaceAll("/", ".");
            if(!field_77461_d.containsKey(p_77459_1_))
            {
                field_77461_d.put(p_77459_1_, new ArrayList());
            }
            SoundPoolEntry soundpoolentry = new SoundPoolEntry(s, p_77459_2_.toURI().toURL());
            ((List)field_77461_d.get(p_77459_1_)).add(soundpoolentry);
            field_77462_e.add(soundpoolentry);
            field_77465_a++;
            return soundpoolentry;
        }
        catch(MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            throw new RuntimeException(malformedurlexception);
        }
    }

    public SoundPoolEntry func_77458_a(String p_77458_1_)
    {
        List list = (List)field_77461_d.get(p_77458_1_);
        if(list == null)
        {
            return null;
        } else
        {
            return (SoundPoolEntry)list.get(field_77464_c.nextInt(list.size()));
        }
    }

    public SoundPoolEntry func_77460_a()
    {
        if(field_77462_e.isEmpty())
        {
            return null;
        } else
        {
            return (SoundPoolEntry)field_77462_e.get(field_77464_c.nextInt(field_77462_e.size()));
        }
    }
}
