// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

// Referenced classes of package net.minecraft.src:
//            RConThreadBase, IServer, RConUtils

public class RConThreadClient extends RConThreadBase
{

    private boolean field_72657_g;
    private Socket field_72659_h;
    private byte field_72660_i[];
    private String field_72658_j;

    RConThreadClient(IServer p_i3407_1_, Socket p_i3407_2_)
    {
        super(p_i3407_1_);
        field_72657_g = false;
        field_72660_i = new byte[1460];
        field_72659_h = p_i3407_2_;
        try
        {
            field_72659_h.setSoTimeout(0);
        }
        catch(Exception exception)
        {
            field_72619_a = false;
        }
        field_72658_j = p_i3407_1_.func_71330_a("rcon.password", "");
        func_72609_b((new StringBuilder()).append("Rcon connection from: ").append(p_i3407_2_.getInetAddress()).toString());
    }

    public void run()
    {
        try
        {
            while(true) 
            {
                if(!field_72619_a)
                {
                    break;
                }
                BufferedInputStream bufferedinputstream = new BufferedInputStream(field_72659_h.getInputStream());
                int i = bufferedinputstream.read(field_72660_i, 0, 1460);
                if(10 > i)
                {
                    return;
                }
                int j = 0;
                int k = RConUtils.func_72665_b(field_72660_i, 0, i);
                if(k != i - 4)
                {
                    return;
                }
                j += 4;
                int l = RConUtils.func_72665_b(field_72660_i, j, i);
                j += 4;
                int i1 = RConUtils.func_72662_b(field_72660_i, j);
                j += 4;
                switch(i1)
                {
                case 3: // '\003'
                    String s = RConUtils.func_72661_a(field_72660_i, j, i);
                    j += s.length();
                    if(0 != s.length() && s.equals(field_72658_j))
                    {
                        field_72657_g = true;
                        func_72654_a(l, 2, "");
                    } else
                    {
                        field_72657_g = false;
                        func_72656_f();
                    }
                    break;

                case 2: // '\002'
                    if(field_72657_g)
                    {
                        String s1 = RConUtils.func_72661_a(field_72660_i, j, i);
                        try
                        {
                            func_72655_a(l, field_72617_b.func_71252_i(s1));
                        }
                        catch(Exception exception1)
                        {
                            func_72655_a(l, (new StringBuilder()).append("Error executing: ").append(s1).append(" (").append(exception1.getMessage()).append(")").toString());
                        }
                    } else
                    {
                        func_72656_f();
                    }
                    break;

                default:
                    func_72655_a(l, String.format("Unknown request %s", new Object[] {
                        Integer.toHexString(i1)
                    }));
                    break;
                }
            }
        }
        catch(SocketTimeoutException sockettimeoutexception) { }
        catch(IOException ioexception) { }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
        finally
        {
            func_72653_g();
        }
    }

    private void func_72654_a(int p_72654_1_, int p_72654_2_, String p_72654_3_)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(1248);
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        dataoutputstream.writeInt(Integer.reverseBytes(p_72654_3_.length() + 10));
        dataoutputstream.writeInt(Integer.reverseBytes(p_72654_1_));
        dataoutputstream.writeInt(Integer.reverseBytes(p_72654_2_));
        dataoutputstream.writeBytes(p_72654_3_);
        dataoutputstream.write(0);
        dataoutputstream.write(0);
        field_72659_h.getOutputStream().write(bytearrayoutputstream.toByteArray());
    }

    private void func_72656_f()
        throws IOException
    {
        func_72654_a(-1, 2, "");
    }

    private void func_72655_a(int p_72655_1_, String p_72655_2_)
        throws IOException
    {
        int i = p_72655_2_.length();
        do
        {
            int j = 4096 > i ? i : 4096;
            func_72654_a(p_72655_1_, 0, p_72655_2_.substring(0, j));
            p_72655_2_ = p_72655_2_.substring(j);
            i = p_72655_2_.length();
        } while(0 != i);
    }

    private void func_72653_g()
    {
        if(null == field_72659_h)
        {
            return;
        }
        try
        {
            field_72659_h.close();
        }
        catch(IOException ioexception)
        {
            func_72606_c((new StringBuilder()).append("IO: ").append(ioexception.getMessage()).toString());
        }
        field_72659_h = null;
    }
}
