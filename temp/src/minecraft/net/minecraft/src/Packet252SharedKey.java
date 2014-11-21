// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

// Referenced classes of package net.minecraft.src:
//            Packet, CryptManager, NetHandler

public class Packet252SharedKey extends Packet
{

    private byte field_73307_a[];
    private byte field_73305_b[];
    private SecretKey field_73306_c;

    public Packet252SharedKey()
    {
        field_73307_a = new byte[0];
        field_73305_b = new byte[0];
    }

    public Packet252SharedKey(SecretKey p_i3356_1_, PublicKey p_i3356_2_, byte p_i3356_3_[])
    {
        field_73307_a = new byte[0];
        field_73305_b = new byte[0];
        field_73306_c = p_i3356_1_;
        field_73307_a = CryptManager.func_75894_a(p_i3356_2_, p_i3356_1_.getEncoded());
        field_73305_b = CryptManager.func_75894_a(p_i3356_2_, p_i3356_3_);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73307_a = func_73280_b(p_73267_1_);
        field_73305_b = func_73280_b(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        func_73274_a(p_73273_1_, field_73307_a);
        func_73274_a(p_73273_1_, field_73305_b);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72513_a(this);
    }

    public int func_73284_a()
    {
        return 2 + field_73307_a.length + 2 + field_73305_b.length;
    }

    public SecretKey func_73303_a(PrivateKey p_73303_1_)
    {
        if(p_73303_1_ == null)
        {
            return field_73306_c;
        } else
        {
            return field_73306_c = CryptManager.func_75887_a(p_73303_1_, field_73307_a);
        }
    }

    public SecretKey func_73304_d()
    {
        return func_73303_a(null);
    }

    public byte[] func_73302_b(PrivateKey p_73302_1_)
    {
        if(p_73302_1_ == null)
        {
            return field_73305_b;
        } else
        {
            return CryptManager.func_75889_b(p_73302_1_, field_73305_b);
        }
    }
}
