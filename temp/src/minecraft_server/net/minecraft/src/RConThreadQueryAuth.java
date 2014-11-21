// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.net.DatagramPacket;
import java.util.Date;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            RConThreadQuery

class RConThreadQueryAuth
{

    private long field_72598_b;
    private int field_72599_c;
    private byte field_72596_d[];
    private byte field_72597_e[];
    private String field_72595_f;
    final RConThreadQuery field_72600_a; /* synthetic field */

    public RConThreadQueryAuth(RConThreadQuery p_i3405_1_, DatagramPacket p_i3405_2_)
    {
        field_72600_a = p_i3405_1_;
        super();
        field_72598_b = (new Date()).getTime();
        byte abyte0[] = p_i3405_2_.getData();
        field_72596_d = new byte[4];
        field_72596_d[0] = abyte0[3];
        field_72596_d[1] = abyte0[4];
        field_72596_d[2] = abyte0[5];
        field_72596_d[3] = abyte0[6];
        field_72595_f = new String(field_72596_d);
        field_72599_c = (new Random()).nextInt(0x1000000);
        field_72597_e = String.format("\t%s%d\0", new Object[] {
            field_72595_f, Integer.valueOf(field_72599_c)
        }).getBytes();
    }

    public Boolean func_72593_a(long p_72593_1_)
    {
        return Boolean.valueOf(field_72598_b < p_72593_1_);
    }

    public int func_72592_a()
    {
        return field_72599_c;
    }

    public byte[] func_72594_b()
    {
        return field_72597_e;
    }

    public byte[] func_72591_c()
    {
        return field_72596_d;
    }
}
