// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            WorldSavedData, ISaveHandler, CompressedStreamTools, NBTTagCompound, 
//            NBTBase, NBTTagShort

public class MapStorage
{

    private ISaveHandler field_75751_a;
    private Map field_75749_b;
    private List field_75750_c;
    private Map field_75748_d;

    public MapStorage(ISaveHandler p_i3918_1_)
    {
        field_75749_b = new HashMap();
        field_75750_c = new ArrayList();
        field_75748_d = new HashMap();
        field_75751_a = p_i3918_1_;
        func_75746_b();
    }

    public WorldSavedData func_75742_a(Class p_75742_1_, String p_75742_2_)
    {
        WorldSavedData worldsaveddata = (WorldSavedData)field_75749_b.get(p_75742_2_);
        if(worldsaveddata != null)
        {
            return worldsaveddata;
        }
        if(field_75751_a != null)
        {
            try
            {
                File file = field_75751_a.func_75758_b(p_75742_2_);
                if(file != null && file.exists())
                {
                    try
                    {
                        worldsaveddata = (WorldSavedData)p_75742_1_.getConstructor(new Class[] {
                            java.lang.String.class
                        }).newInstance(new Object[] {
                            p_75742_2_
                        });
                    }
                    catch(Exception exception1)
                    {
                        throw new RuntimeException((new StringBuilder()).append("Failed to instantiate ").append(p_75742_1_.toString()).toString(), exception1);
                    }
                    FileInputStream fileinputstream = new FileInputStream(file);
                    NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(fileinputstream);
                    fileinputstream.close();
                    worldsaveddata.func_76184_a(nbttagcompound.func_74775_l("data"));
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        if(worldsaveddata != null)
        {
            field_75749_b.put(p_75742_2_, worldsaveddata);
            field_75750_c.add(worldsaveddata);
        }
        return worldsaveddata;
    }

    public void func_75745_a(String p_75745_1_, WorldSavedData p_75745_2_)
    {
        if(p_75745_2_ == null)
        {
            throw new RuntimeException("Can't set null data");
        }
        if(field_75749_b.containsKey(p_75745_1_))
        {
            field_75750_c.remove(field_75749_b.remove(p_75745_1_));
        }
        field_75749_b.put(p_75745_1_, p_75745_2_);
        field_75750_c.add(p_75745_2_);
    }

    public void func_75744_a()
    {
        Iterator iterator = field_75750_c.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            WorldSavedData worldsaveddata = (WorldSavedData)iterator.next();
            if(worldsaveddata.func_76188_b())
            {
                func_75747_a(worldsaveddata);
                worldsaveddata.func_76186_a(false);
            }
        } while(true);
    }

    private void func_75747_a(WorldSavedData p_75747_1_)
    {
        if(field_75751_a == null)
        {
            return;
        }
        try
        {
            File file = field_75751_a.func_75758_b(p_75747_1_.field_76190_i);
            if(file != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                p_75747_1_.func_76187_b(nbttagcompound);
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_74766_a("data", nbttagcompound);
                FileOutputStream fileoutputstream = new FileOutputStream(file);
                CompressedStreamTools.func_74799_a(nbttagcompound1, fileoutputstream);
                fileoutputstream.close();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_75746_b()
    {
        try
        {
            field_75748_d.clear();
            if(field_75751_a == null)
            {
                return;
            }
            File file = field_75751_a.func_75758_b("idcounts");
            if(file != null && file.exists())
            {
                DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
                NBTTagCompound nbttagcompound = CompressedStreamTools.func_74794_a(datainputstream);
                datainputstream.close();
                Iterator iterator = nbttagcompound.func_74758_c().iterator();
                do
                {
                    if(!iterator.hasNext())
                    {
                        break;
                    }
                    NBTBase nbtbase = (NBTBase)iterator.next();
                    if(nbtbase instanceof NBTTagShort)
                    {
                        NBTTagShort nbttagshort = (NBTTagShort)nbtbase;
                        String s = nbttagshort.func_74740_e();
                        short word0 = nbttagshort.field_74752_a;
                        field_75748_d.put(s, Short.valueOf(word0));
                    }
                } while(true);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public int func_75743_a(String p_75743_1_)
    {
        Short short1 = (Short)field_75748_d.get(p_75743_1_);
        if(short1 == null)
        {
            short1 = Short.valueOf((short)0);
        } else
        {
            Short short2 = short1;
            Short short3 = short1 = Short.valueOf((short)(short1.shortValue() + 1));
            Short _tmp = short2;
        }
        field_75748_d.put(p_75743_1_, short1);
        if(field_75751_a == null)
        {
            return short1.shortValue();
        }
        try
        {
            File file = field_75751_a.func_75758_b("idcounts");
            if(file != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                String s;
                short word0;
                for(Iterator iterator = field_75748_d.keySet().iterator(); iterator.hasNext(); nbttagcompound.func_74777_a(s, word0))
                {
                    s = (String)iterator.next();
                    word0 = ((Short)field_75748_d.get(s)).shortValue();
                }

                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));
                CompressedStreamTools.func_74800_a(nbttagcompound, dataoutputstream);
                dataoutputstream.close();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return short1.shortValue();
    }
}
