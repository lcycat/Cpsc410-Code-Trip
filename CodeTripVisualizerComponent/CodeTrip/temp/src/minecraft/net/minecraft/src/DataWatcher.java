// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.*;

// Referenced classes of package net.minecraft.src:
//            WatchableObject, CrashReport, ReportedException, Packet, 
//            ItemStack, Item, ChunkCoordinates

public class DataWatcher
{

    private static final HashMap field_75697_a;
    private final Map field_75695_b = new HashMap();
    private boolean field_75696_c;
    private ReadWriteLock field_75694_d;

    public DataWatcher()
    {
        field_75694_d = new ReentrantReadWriteLock();
    }

    public void func_75682_a(int p_75682_1_, Object p_75682_2_)
    {
        Integer integer = (Integer)field_75697_a.get(p_75682_2_.getClass());
        if(integer == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown data type: ").append(p_75682_2_.getClass()).toString());
        }
        if(p_75682_1_ > 31)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Data value id is too big with ").append(p_75682_1_).append("! (Max is ").append(31).append(")").toString());
        }
        if(field_75695_b.containsKey(Integer.valueOf(p_75682_1_)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate id value for ").append(p_75682_1_).append("!").toString());
        } else
        {
            WatchableObject watchableobject = new WatchableObject(integer.intValue(), p_75682_1_, p_75682_2_);
            field_75694_d.writeLock().lock();
            field_75695_b.put(Integer.valueOf(p_75682_1_), watchableobject);
            field_75694_d.writeLock().unlock();
            return;
        }
    }

    public byte func_75683_a(int p_75683_1_)
    {
        return ((Byte)func_75691_i(p_75683_1_).func_75669_b()).byteValue();
    }

    public short func_75693_b(int p_75693_1_)
    {
        return ((Short)func_75691_i(p_75693_1_).func_75669_b()).shortValue();
    }

    public int func_75679_c(int p_75679_1_)
    {
        return ((Integer)func_75691_i(p_75679_1_).func_75669_b()).intValue();
    }

    public String func_75681_e(int p_75681_1_)
    {
        return (String)func_75691_i(p_75681_1_).func_75669_b();
    }

    private WatchableObject func_75691_i(int p_75691_1_)
    {
        field_75694_d.readLock().lock();
        WatchableObject watchableobject;
        try
        {
            watchableobject = (WatchableObject)field_75695_b.get(Integer.valueOf(p_75691_1_));
        }
        catch(Throwable throwable)
        {
            CrashReport crashreport = new CrashReport("getting synched entity data", throwable);
            crashreport.func_71507_a("EntityData ID", Integer.valueOf(p_75691_1_));
            throw new ReportedException(crashreport);
        }
        field_75694_d.readLock().unlock();
        return watchableobject;
    }

    public void func_75692_b(int p_75692_1_, Object p_75692_2_)
    {
        WatchableObject watchableobject = func_75691_i(p_75692_1_);
        if(!p_75692_2_.equals(watchableobject.func_75669_b()))
        {
            watchableobject.func_75673_a(p_75692_2_);
            watchableobject.func_75671_a(true);
            field_75696_c = true;
        }
    }

    public boolean func_75684_a()
    {
        return field_75696_c;
    }

    public static void func_75680_a(List p_75680_0_, DataOutputStream p_75680_1_)
        throws IOException
    {
        if(p_75680_0_ != null)
        {
            WatchableObject watchableobject;
            for(Iterator iterator = p_75680_0_.iterator(); iterator.hasNext(); func_75690_a(p_75680_1_, watchableobject))
            {
                watchableobject = (WatchableObject)iterator.next();
            }

        }
        p_75680_1_.writeByte(127);
    }

    public List func_75688_b()
    {
        ArrayList arraylist = null;
        if(field_75696_c)
        {
            field_75694_d.readLock().lock();
            Iterator iterator = field_75695_b.values().iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                WatchableObject watchableobject = (WatchableObject)iterator.next();
                if(watchableobject.func_75670_d())
                {
                    watchableobject.func_75671_a(false);
                    if(arraylist == null)
                    {
                        arraylist = new ArrayList();
                    }
                    arraylist.add(watchableobject);
                }
            } while(true);
            field_75694_d.readLock().unlock();
        }
        field_75696_c = false;
        return arraylist;
    }

    public void func_75689_a(DataOutputStream p_75689_1_)
        throws IOException
    {
        field_75694_d.readLock().lock();
        WatchableObject watchableobject;
        for(Iterator iterator = field_75695_b.values().iterator(); iterator.hasNext(); func_75690_a(p_75689_1_, watchableobject))
        {
            watchableobject = (WatchableObject)iterator.next();
        }

        field_75694_d.readLock().unlock();
        p_75689_1_.writeByte(127);
    }

    public List func_75685_c()
    {
        ArrayList arraylist = null;
        field_75694_d.readLock().lock();
        WatchableObject watchableobject;
        for(Iterator iterator = field_75695_b.values().iterator(); iterator.hasNext(); arraylist.add(watchableobject))
        {
            watchableobject = (WatchableObject)iterator.next();
            if(arraylist == null)
            {
                arraylist = new ArrayList();
            }
        }

        field_75694_d.readLock().unlock();
        return arraylist;
    }

    private static void func_75690_a(DataOutputStream p_75690_0_, WatchableObject p_75690_1_)
        throws IOException
    {
        int i = (p_75690_1_.func_75674_c() << 5 | p_75690_1_.func_75672_a() & 0x1f) & 0xff;
        p_75690_0_.writeByte(i);
        switch(p_75690_1_.func_75674_c())
        {
        case 0: // '\0'
            p_75690_0_.writeByte(((Byte)p_75690_1_.func_75669_b()).byteValue());
            break;

        case 1: // '\001'
            p_75690_0_.writeShort(((Short)p_75690_1_.func_75669_b()).shortValue());
            break;

        case 2: // '\002'
            p_75690_0_.writeInt(((Integer)p_75690_1_.func_75669_b()).intValue());
            break;

        case 3: // '\003'
            p_75690_0_.writeFloat(((Float)p_75690_1_.func_75669_b()).floatValue());
            break;

        case 4: // '\004'
            Packet.func_73271_a((String)p_75690_1_.func_75669_b(), p_75690_0_);
            break;

        case 5: // '\005'
            ItemStack itemstack = (ItemStack)p_75690_1_.func_75669_b();
            p_75690_0_.writeShort(itemstack.func_77973_b().field_77779_bT);
            p_75690_0_.writeByte(itemstack.field_77994_a);
            p_75690_0_.writeShort(itemstack.func_77960_j());
            break;

        case 6: // '\006'
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)p_75690_1_.func_75669_b();
            p_75690_0_.writeInt(chunkcoordinates.field_71574_a);
            p_75690_0_.writeInt(chunkcoordinates.field_71572_b);
            p_75690_0_.writeInt(chunkcoordinates.field_71573_c);
            break;
        }
    }

    public static List func_75686_a(DataInputStream p_75686_0_)
        throws IOException
    {
        ArrayList arraylist = null;
        for(byte byte0 = p_75686_0_.readByte(); byte0 != 127; byte0 = p_75686_0_.readByte())
        {
            if(arraylist == null)
            {
                arraylist = new ArrayList();
            }
            int i = (byte0 & 0xe0) >> 5;
            int j = byte0 & 0x1f;
            WatchableObject watchableobject = null;
            switch(i)
            {
            case 0: // '\0'
                watchableobject = new WatchableObject(i, j, Byte.valueOf(p_75686_0_.readByte()));
                break;

            case 1: // '\001'
                watchableobject = new WatchableObject(i, j, Short.valueOf(p_75686_0_.readShort()));
                break;

            case 2: // '\002'
                watchableobject = new WatchableObject(i, j, Integer.valueOf(p_75686_0_.readInt()));
                break;

            case 3: // '\003'
                watchableobject = new WatchableObject(i, j, Float.valueOf(p_75686_0_.readFloat()));
                break;

            case 4: // '\004'
                watchableobject = new WatchableObject(i, j, Packet.func_73282_a(p_75686_0_, 64));
                break;

            case 5: // '\005'
                short word0 = p_75686_0_.readShort();
                byte byte1 = p_75686_0_.readByte();
                short word1 = p_75686_0_.readShort();
                watchableobject = new WatchableObject(i, j, new ItemStack(word0, byte1, word1));
                break;

            case 6: // '\006'
                int k = p_75686_0_.readInt();
                int l = p_75686_0_.readInt();
                int i1 = p_75686_0_.readInt();
                watchableobject = new WatchableObject(i, j, new ChunkCoordinates(k, l, i1));
                break;
            }
            arraylist.add(watchableobject);
        }

        return arraylist;
    }

    public void func_75687_a(List p_75687_1_)
    {
        field_75694_d.writeLock().lock();
        Iterator iterator = p_75687_1_.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            WatchableObject watchableobject = (WatchableObject)iterator.next();
            WatchableObject watchableobject1 = (WatchableObject)field_75695_b.get(Integer.valueOf(watchableobject.func_75672_a()));
            if(watchableobject1 != null)
            {
                watchableobject1.func_75673_a(watchableobject.func_75669_b());
            }
        } while(true);
        field_75694_d.writeLock().unlock();
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static 
    {
        field_75697_a = new HashMap();
        field_75697_a.put(java.lang.Byte.class, Integer.valueOf(0));
        field_75697_a.put(java.lang.Short.class, Integer.valueOf(1));
        field_75697_a.put(java.lang.Integer.class, Integer.valueOf(2));
        field_75697_a.put(java.lang.Float.class, Integer.valueOf(3));
        field_75697_a.put(java.lang.String.class, Integer.valueOf(4));
        field_75697_a.put(net.minecraft.src.ItemStack.class, Integer.valueOf(5));
        field_75697_a.put(net.minecraft.src.ChunkCoordinates.class, Integer.valueOf(6));
    }
}
