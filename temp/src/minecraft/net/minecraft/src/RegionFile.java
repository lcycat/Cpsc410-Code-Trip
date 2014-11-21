// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.*;

// Referenced classes of package net.minecraft.src:
//            RegionFileChunkBuffer

public class RegionFile
{

    private static final byte field_76720_a[] = new byte[4096];
    private final File field_76718_b;
    private RandomAccessFile field_76719_c;
    private final int field_76716_d[] = new int[1024];
    private final int field_76717_e[] = new int[1024];
    private ArrayList field_76714_f;
    private int field_76715_g;
    private long field_76721_h;

    public RegionFile(File p_i3777_1_)
    {
        field_76721_h = 0L;
        field_76718_b = p_i3777_1_;
        field_76715_g = 0;
        try
        {
            if(p_i3777_1_.exists())
            {
                field_76721_h = p_i3777_1_.lastModified();
            }
            field_76719_c = new RandomAccessFile(p_i3777_1_, "rw");
            if(field_76719_c.length() < 4096L)
            {
                for(int i = 0; i < 1024; i++)
                {
                    field_76719_c.writeInt(0);
                }

                for(int j = 0; j < 1024; j++)
                {
                    field_76719_c.writeInt(0);
                }

                field_76715_g += 8192;
            }
            if((field_76719_c.length() & 4095L) != 0L)
            {
                for(int k = 0; (long)k < (field_76719_c.length() & 4095L); k++)
                {
                    field_76719_c.write(0);
                }

            }
            int l = (int)field_76719_c.length() / 4096;
            field_76714_f = new ArrayList(l);
            for(int i1 = 0; i1 < l; i1++)
            {
                field_76714_f.add(Boolean.valueOf(true));
            }

            field_76714_f.set(0, Boolean.valueOf(false));
            field_76714_f.set(1, Boolean.valueOf(false));
            field_76719_c.seek(0L);
            for(int j1 = 0; j1 < 1024; j1++)
            {
                int l1 = field_76719_c.readInt();
                field_76716_d[j1] = l1;
                if(l1 == 0 || (l1 >> 8) + (l1 & 0xff) > field_76714_f.size())
                {
                    continue;
                }
                for(int j2 = 0; j2 < (l1 & 0xff); j2++)
                {
                    field_76714_f.set((l1 >> 8) + j2, Boolean.valueOf(false));
                }

            }

            for(int k1 = 0; k1 < 1024; k1++)
            {
                int i2 = field_76719_c.readInt();
                field_76717_e[k1] = i2;
            }

        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public synchronized DataInputStream func_76704_a(int p_76704_1_, int p_76704_2_)
    {
        if(func_76705_d(p_76704_1_, p_76704_2_))
        {
            return null;
        }
        try
        {
            int i = func_76707_e(p_76704_1_, p_76704_2_);
            if(i == 0)
            {
                return null;
            }
            int j = i >> 8;
            int k = i & 0xff;
            if(j + k > field_76714_f.size())
            {
                return null;
            }
            field_76719_c.seek(j * 4096);
            int l = field_76719_c.readInt();
            if(l > 4096 * k)
            {
                return null;
            }
            if(l <= 0)
            {
                return null;
            }
            byte byte0 = field_76719_c.readByte();
            if(byte0 == 1)
            {
                byte abyte0[] = new byte[l - 1];
                field_76719_c.read(abyte0);
                return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(abyte0))));
            }
            if(byte0 == 2)
            {
                byte abyte1[] = new byte[l - 1];
                field_76719_c.read(abyte1);
                return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(abyte1))));
            } else
            {
                return null;
            }
        }
        catch(IOException ioexception)
        {
            return null;
        }
    }

    public DataOutputStream func_76710_b(int p_76710_1_, int p_76710_2_)
    {
        if(func_76705_d(p_76710_1_, p_76710_2_))
        {
            return null;
        } else
        {
            return new DataOutputStream(new DeflaterOutputStream(new RegionFileChunkBuffer(this, p_76710_1_, p_76710_2_)));
        }
    }

    protected synchronized void func_76706_a(int p_76706_1_, int p_76706_2_, byte p_76706_3_[], int p_76706_4_)
    {
        try
        {
            int i = func_76707_e(p_76706_1_, p_76706_2_);
            int j = i >> 8;
            int i1 = i & 0xff;
            int j1 = (p_76706_4_ + 5) / 4096 + 1;
            if(j1 >= 256)
            {
                return;
            }
            if(j != 0 && i1 == j1)
            {
                func_76712_a(j, p_76706_3_, p_76706_4_);
            } else
            {
                for(int k1 = 0; k1 < i1; k1++)
                {
                    field_76714_f.set(j + k1, Boolean.valueOf(true));
                }

                int l1 = field_76714_f.indexOf(Boolean.valueOf(true));
                int i2 = 0;
                if(l1 != -1)
                {
                    int j2 = l1;
                    do
                    {
                        if(j2 >= field_76714_f.size())
                        {
                            break;
                        }
                        if(i2 != 0)
                        {
                            if(((Boolean)field_76714_f.get(j2)).booleanValue())
                            {
                                i2++;
                            } else
                            {
                                i2 = 0;
                            }
                        } else
                        if(((Boolean)field_76714_f.get(j2)).booleanValue())
                        {
                            l1 = j2;
                            i2 = 1;
                        }
                        if(i2 >= j1)
                        {
                            break;
                        }
                        j2++;
                    } while(true);
                }
                if(i2 >= j1)
                {
                    int k = l1;
                    func_76711_a(p_76706_1_, p_76706_2_, k << 8 | j1);
                    for(int k2 = 0; k2 < j1; k2++)
                    {
                        field_76714_f.set(k + k2, Boolean.valueOf(false));
                    }

                    func_76712_a(k, p_76706_3_, p_76706_4_);
                } else
                {
                    field_76719_c.seek(field_76719_c.length());
                    int l = field_76714_f.size();
                    for(int l2 = 0; l2 < j1; l2++)
                    {
                        field_76719_c.write(field_76720_a);
                        field_76714_f.add(Boolean.valueOf(false));
                    }

                    field_76715_g += 4096 * j1;
                    func_76712_a(l, p_76706_3_, p_76706_4_);
                    func_76711_a(p_76706_1_, p_76706_2_, l << 8 | j1);
                }
            }
            func_76713_b(p_76706_1_, p_76706_2_, (int)(System.currentTimeMillis() / 1000L));
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private void func_76712_a(int p_76712_1_, byte p_76712_2_[], int p_76712_3_)
        throws IOException
    {
        field_76719_c.seek(p_76712_1_ * 4096);
        field_76719_c.writeInt(p_76712_3_ + 1);
        field_76719_c.writeByte(2);
        field_76719_c.write(p_76712_2_, 0, p_76712_3_);
    }

    private boolean func_76705_d(int p_76705_1_, int p_76705_2_)
    {
        return p_76705_1_ < 0 || p_76705_1_ >= 32 || p_76705_2_ < 0 || p_76705_2_ >= 32;
    }

    private int func_76707_e(int p_76707_1_, int p_76707_2_)
    {
        return field_76716_d[p_76707_1_ + p_76707_2_ * 32];
    }

    public boolean func_76709_c(int p_76709_1_, int p_76709_2_)
    {
        return func_76707_e(p_76709_1_, p_76709_2_) != 0;
    }

    private void func_76711_a(int p_76711_1_, int p_76711_2_, int p_76711_3_)
        throws IOException
    {
        field_76716_d[p_76711_1_ + p_76711_2_ * 32] = p_76711_3_;
        field_76719_c.seek((p_76711_1_ + p_76711_2_ * 32) * 4);
        field_76719_c.writeInt(p_76711_3_);
    }

    private void func_76713_b(int p_76713_1_, int p_76713_2_, int p_76713_3_)
        throws IOException
    {
        field_76717_e[p_76713_1_ + p_76713_2_ * 32] = p_76713_3_;
        field_76719_c.seek(4096 + (p_76713_1_ + p_76713_2_ * 32) * 4);
        field_76719_c.writeInt(p_76713_3_);
    }

    public void func_76708_c()
        throws IOException
    {
        if(field_76719_c != null)
        {
            field_76719_c.close();
        }
    }

}
