// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package net.minecraft.src:
//            NBTBase, NBTTagCompound

public class CompressedStreamTools
{

    public static NBTTagCompound func_74796_a(InputStream p_74796_0_)
        throws IOException
    {
        DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(p_74796_0_)));
        try
        {
            NBTTagCompound nbttagcompound = func_74794_a(datainputstream);
            return nbttagcompound;
        }
        finally
        {
            datainputstream.close();
        }
    }

    public static void func_74799_a(NBTTagCompound p_74799_0_, OutputStream p_74799_1_)
        throws IOException
    {
        DataOutputStream dataoutputstream = new DataOutputStream(new GZIPOutputStream(p_74799_1_));
        try
        {
            func_74800_a(p_74799_0_, dataoutputstream);
        }
        finally
        {
            dataoutputstream.close();
        }
    }

    public static NBTTagCompound func_74792_a(byte p_74792_0_[])
        throws IOException
    {
        DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(p_74792_0_))));
        try
        {
            NBTTagCompound nbttagcompound = func_74794_a(datainputstream);
            return nbttagcompound;
        }
        finally
        {
            datainputstream.close();
        }
    }

    public static byte[] func_74798_a(NBTTagCompound p_74798_0_)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(new GZIPOutputStream(bytearrayoutputstream));
        try
        {
            func_74800_a(p_74798_0_, dataoutputstream);
        }
        finally
        {
            dataoutputstream.close();
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static NBTTagCompound func_74794_a(DataInput p_74794_0_)
        throws IOException
    {
        NBTBase nbtbase = NBTBase.func_74739_b(p_74794_0_);
        if(nbtbase instanceof NBTTagCompound)
        {
            return (NBTTagCompound)nbtbase;
        } else
        {
            throw new IOException("Root tag must be a named compound tag");
        }
    }

    public static void func_74800_a(NBTTagCompound p_74800_0_, DataOutput p_74800_1_)
        throws IOException
    {
        NBTBase.func_74731_a(p_74800_0_, p_74800_1_);
    }
}
