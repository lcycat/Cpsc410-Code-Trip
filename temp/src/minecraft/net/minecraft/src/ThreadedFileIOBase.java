// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IThreadedFileIO

public class ThreadedFileIOBase
    implements Runnable
{

    public static final ThreadedFileIOBase field_75741_a = new ThreadedFileIOBase();
    private List field_75739_b;
    private volatile long field_75740_c;
    private volatile long field_75737_d;
    private volatile boolean field_75738_e;

    private ThreadedFileIOBase()
    {
        field_75739_b = Collections.synchronizedList(new ArrayList());
        field_75740_c = 0L;
        field_75737_d = 0L;
        field_75738_e = false;
        Thread thread = new Thread(this, "File IO Thread");
        thread.setPriority(1);
        thread.start();
    }

    public void run()
    {
        do
        {
            func_75736_b();
        } while(true);
    }

    private void func_75736_b()
    {
        for(int i = 0; i < field_75739_b.size(); i++)
        {
            IThreadedFileIO ithreadedfileio = (IThreadedFileIO)field_75739_b.get(i);
            boolean flag = ithreadedfileio.func_75814_c();
            if(!flag)
            {
                field_75739_b.remove(i--);
                field_75737_d++;
            }
            try
            {
                Thread.sleep(field_75738_e ? 0L : 10L);
            }
            catch(InterruptedException interruptedexception1)
            {
                interruptedexception1.printStackTrace();
            }
        }

        if(field_75739_b.isEmpty())
        {
            try
            {
                Thread.sleep(25L);
            }
            catch(InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
    }

    public void func_75735_a(IThreadedFileIO p_75735_1_)
    {
        if(field_75739_b.contains(p_75735_1_))
        {
            return;
        } else
        {
            field_75740_c++;
            field_75739_b.add(p_75735_1_);
            return;
        }
    }

    public void func_75734_a()
        throws InterruptedException
    {
        field_75738_e = true;
        while(field_75740_c != field_75737_d) 
        {
            Thread.sleep(10L);
        }
        field_75738_e = false;
    }

}
