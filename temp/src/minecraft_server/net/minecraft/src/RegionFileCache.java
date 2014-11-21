// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            RegionFile

public class RegionFileCache
{

    private static final Map field_76553_a = new HashMap();

    public static synchronized RegionFile func_76550_a(File p_76550_0_, int p_76550_1_, int p_76550_2_)
    {
        File file = new File(p_76550_0_, "region");
        File file1 = new File(file, (new StringBuilder()).append("r.").append(p_76550_1_ >> 5).append(".").append(p_76550_2_ >> 5).append(".mca").toString());
        Reference reference = (Reference)field_76553_a.get(file1);
        if(reference != null)
        {
            RegionFile regionfile = (RegionFile)reference.get();
            if(regionfile != null)
            {
                return regionfile;
            }
        }
        if(!file.exists())
        {
            file.mkdirs();
        }
        if(field_76553_a.size() >= 256)
        {
            func_76551_a();
        }
        RegionFile regionfile1 = new RegionFile(file1);
        field_76553_a.put(file1, new SoftReference(regionfile1));
        return regionfile1;
    }

    public static synchronized void func_76551_a()
    {
        Iterator iterator = field_76553_a.values().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Reference reference = (Reference)iterator.next();
            try
            {
                RegionFile regionfile = (RegionFile)reference.get();
                if(regionfile != null)
                {
                    regionfile.func_76708_c();
                }
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        } while(true);
        field_76553_a.clear();
    }

    public static DataInputStream func_76549_c(File p_76549_0_, int p_76549_1_, int p_76549_2_)
    {
        RegionFile regionfile = func_76550_a(p_76549_0_, p_76549_1_, p_76549_2_);
        return regionfile.func_76704_a(p_76549_1_ & 0x1f, p_76549_2_ & 0x1f);
    }

    public static DataOutputStream func_76552_d(File p_76552_0_, int p_76552_1_, int p_76552_2_)
    {
        RegionFile regionfile = func_76550_a(p_76552_0_, p_76552_1_, p_76552_2_);
        return regionfile.func_76710_b(p_76552_1_ & 0x1f, p_76552_2_ & 0x1f);
    }

}
