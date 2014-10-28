// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.saj;

import java.io.*;

// Referenced classes of package argo.saj:
//            ThingWithPosition

final class PositionTrackingPushbackReader
    implements ThingWithPosition
{

    private final PushbackReader field_74571_a;
    private int field_74569_b;
    private int field_74570_c;
    private boolean field_74568_d;

    public PositionTrackingPushbackReader(Reader p_i3243_1_)
    {
        field_74569_b = 0;
        field_74570_c = 1;
        field_74568_d = false;
        field_74571_a = new PushbackReader(p_i3243_1_);
    }

    public void func_74567_a(char p_74567_1_)
        throws IOException
    {
        field_74569_b--;
        if(field_74569_b < 0)
        {
            field_74569_b = 0;
        }
        field_74571_a.unread(p_74567_1_);
    }

    public void func_74566_a(char p_74566_1_[])
        throws IOException
    {
        field_74569_b = field_74569_b - p_74566_1_.length;
        if(field_74569_b < 0)
        {
            field_74569_b = 0;
        }
    }

    public int func_74564_a()
        throws IOException
    {
        int i = field_74571_a.read();
        func_74563_a(i);
        return i;
    }

    public int func_74565_b(char p_74565_1_[])
        throws IOException
    {
        int i = field_74571_a.read(p_74565_1_);
        char ac[] = p_74565_1_;
        int j = ac.length;
        for(int k = 0; k < j; k++)
        {
            char c = ac[k];
            func_74563_a(c);
        }

        return i;
    }

    private void func_74563_a(int p_74563_1_)
    {
        if(13 == p_74563_1_)
        {
            field_74569_b = 0;
            field_74570_c++;
            field_74568_d = true;
        } else
        {
            if(10 == p_74563_1_ && !field_74568_d)
            {
                field_74569_b = 0;
                field_74570_c++;
            } else
            {
                field_74569_b++;
            }
            field_74568_d = false;
        }
    }

    public int func_74562_b()
    {
        return field_74569_b;
    }

    public int func_74561_c()
    {
        return field_74570_c;
    }
}
