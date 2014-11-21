// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            Session, StatFileWriter, ThreadStatSyncherReceive, ThreadStatSyncherSend

public class StatsSyncher
{

    private volatile boolean field_77432_a;
    private volatile Map field_77430_b;
    private volatile Map field_77431_c;
    private StatFileWriter field_77428_d;
    private File field_77429_e;
    private File field_77426_f;
    private File field_77427_g;
    private File field_77437_h;
    private File field_77438_i;
    private File field_77435_j;
    private Session field_77436_k;
    private int field_77433_l;
    private int field_77434_m;

    public StatsSyncher(Session p_i3216_1_, StatFileWriter p_i3216_2_, File p_i3216_3_)
    {
        field_77432_a = false;
        field_77430_b = null;
        field_77431_c = null;
        field_77433_l = 0;
        field_77434_m = 0;
        field_77429_e = new File(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b.toLowerCase()).append("_unsent.dat").toString());
        field_77426_f = new File(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b.toLowerCase()).append(".dat").toString());
        field_77438_i = new File(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b.toLowerCase()).append("_unsent.old").toString());
        field_77435_j = new File(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b.toLowerCase()).append(".old").toString());
        field_77427_g = new File(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b.toLowerCase()).append("_unsent.tmp").toString());
        field_77437_h = new File(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b.toLowerCase()).append(".tmp").toString());
        if(!p_i3216_1_.field_74286_b.toLowerCase().equals(p_i3216_1_.field_74286_b))
        {
            func_77412_a(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b).append("_unsent.dat").toString(), field_77429_e);
            func_77412_a(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b).append(".dat").toString(), field_77426_f);
            func_77412_a(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b).append("_unsent.old").toString(), field_77438_i);
            func_77412_a(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b).append(".old").toString(), field_77435_j);
            func_77412_a(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b).append("_unsent.tmp").toString(), field_77427_g);
            func_77412_a(p_i3216_3_, (new StringBuilder()).append("stats_").append(p_i3216_1_.field_74286_b).append(".tmp").toString(), field_77437_h);
        }
        field_77428_d = p_i3216_2_;
        field_77436_k = p_i3216_1_;
        if(field_77429_e.exists())
        {
            p_i3216_2_.func_77447_a(func_77417_a(field_77429_e, field_77427_g, field_77438_i));
        }
        func_77423_b();
    }

    private void func_77412_a(File p_77412_1_, String p_77412_2_, File p_77412_3_)
    {
        File file = new File(p_77412_1_, p_77412_2_);
        if(file.exists() && !file.isDirectory() && !p_77412_3_.exists())
        {
            file.renameTo(p_77412_3_);
        }
    }

    private Map func_77417_a(File p_77417_1_, File p_77417_2_, File p_77417_3_)
    {
        if(p_77417_1_.exists())
        {
            return func_77413_a(p_77417_1_);
        }
        if(p_77417_3_.exists())
        {
            return func_77413_a(p_77417_3_);
        }
        if(p_77417_2_.exists())
        {
            return func_77413_a(p_77417_2_);
        } else
        {
            return null;
        }
    }

    private Map func_77413_a(File p_77413_1_)
    {
        BufferedReader bufferedreader = null;
        try
        {
            bufferedreader = new BufferedReader(new FileReader(p_77413_1_));
            String s = "";
            StringBuilder stringbuilder = new StringBuilder();
            while((s = bufferedreader.readLine()) != null) 
            {
                stringbuilder.append(s);
            }
            Map map = StatFileWriter.func_77453_b(stringbuilder.toString());
            return map;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            if(bufferedreader != null)
            {
                try
                {
                    bufferedreader.close();
                }
                catch(Exception exception2)
                {
                    exception2.printStackTrace();
                }
            }
        }
        return null;
    }

    private void func_77421_a(Map p_77421_1_, File p_77421_2_, File p_77421_3_, File p_77421_4_)
        throws IOException
    {
        PrintWriter printwriter = new PrintWriter(new FileWriter(p_77421_3_, false));
        try
        {
            printwriter.print(StatFileWriter.func_77441_a(field_77436_k.field_74286_b, "local", p_77421_1_));
        }
        finally
        {
            printwriter.close();
        }
        if(p_77421_4_.exists())
        {
            p_77421_4_.delete();
        }
        if(p_77421_2_.exists())
        {
            p_77421_2_.renameTo(p_77421_4_);
        }
        p_77421_3_.renameTo(p_77421_2_);
    }

    public void func_77423_b()
    {
        if(field_77432_a)
        {
            throw new IllegalStateException("Can't get stats from server while StatsSyncher is busy!");
        } else
        {
            field_77433_l = 100;
            field_77432_a = true;
            (new ThreadStatSyncherReceive(this)).start();
            return;
        }
    }

    public void func_77418_a(Map p_77418_1_)
    {
        if(field_77432_a)
        {
            throw new IllegalStateException("Can't save stats while StatsSyncher is busy!");
        } else
        {
            field_77433_l = 100;
            field_77432_a = true;
            (new ThreadStatSyncherSend(this, p_77418_1_)).start();
            return;
        }
    }

    public void func_77420_c(Map p_77420_1_)
    {
        for(int i = 30; field_77432_a && --i > 0;)
        {
            try
            {
                Thread.sleep(100L);
            }
            catch(InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }

        field_77432_a = true;
        try
        {
            func_77421_a(p_77420_1_, field_77429_e, field_77427_g, field_77438_i);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            field_77432_a = false;
        }
    }

    public boolean func_77425_c()
    {
        return field_77433_l <= 0 && !field_77432_a && field_77431_c == null;
    }

    public void func_77422_e()
    {
        if(field_77433_l > 0)
        {
            field_77433_l--;
        }
        if(field_77434_m > 0)
        {
            field_77434_m--;
        }
        if(field_77431_c != null)
        {
            field_77428_d.func_77448_c(field_77431_c);
            field_77431_c = null;
        }
        if(field_77430_b != null)
        {
            field_77428_d.func_77452_b(field_77430_b);
            field_77430_b = null;
        }
    }

    static Map func_77419_a(StatsSyncher p_77419_0_)
    {
        return p_77419_0_.field_77430_b;
    }

    static File func_77408_b(StatsSyncher p_77408_0_)
    {
        return p_77408_0_.field_77426_f;
    }

    static File func_77407_c(StatsSyncher p_77407_0_)
    {
        return p_77407_0_.field_77437_h;
    }

    static File func_77411_d(StatsSyncher p_77411_0_)
    {
        return p_77411_0_.field_77435_j;
    }

    static void func_77414_a(StatsSyncher p_77414_0_, Map p_77414_1_, File p_77414_2_, File p_77414_3_, File p_77414_4_)
        throws IOException
    {
        p_77414_0_.func_77421_a(p_77414_1_, p_77414_2_, p_77414_3_, p_77414_4_);
    }

    static Map func_77416_a(StatsSyncher p_77416_0_, Map p_77416_1_)
    {
        return p_77416_0_.field_77430_b = p_77416_1_;
    }

    static Map func_77410_a(StatsSyncher p_77410_0_, File p_77410_1_, File p_77410_2_, File p_77410_3_)
    {
        return p_77410_0_.func_77417_a(p_77410_1_, p_77410_2_, p_77410_3_);
    }

    static boolean func_77406_a(StatsSyncher p_77406_0_, boolean p_77406_1_)
    {
        return p_77406_0_.field_77432_a = p_77406_1_;
    }

    static File func_77409_e(StatsSyncher p_77409_0_)
    {
        return p_77409_0_.field_77429_e;
    }

    static File func_77415_f(StatsSyncher p_77415_0_)
    {
        return p_77415_0_.field_77427_g;
    }

    static File func_77424_g(StatsSyncher p_77424_0_)
    {
        return p_77424_0_.field_77438_i;
    }
}
