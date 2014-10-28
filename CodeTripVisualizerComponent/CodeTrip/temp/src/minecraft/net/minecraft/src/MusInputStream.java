// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// Referenced classes of package net.minecraft.src:
//            CodecMus

class MusInputStream extends InputStream
{

    private int field_77388_c;
    private InputStream field_77386_d;
    byte field_77389_a[];
    final CodecMus field_77387_b; /* synthetic field */

    public MusInputStream(CodecMus p_i3126_1_, URL p_i3126_2_, InputStream p_i3126_3_)
    {
        field_77387_b = p_i3126_1_;
        super();
        field_77389_a = new byte[1];
        field_77386_d = p_i3126_3_;
        String s = p_i3126_2_.getPath();
        s = s.substring(s.lastIndexOf("/") + 1);
        field_77388_c = s.hashCode();
    }

    public int read()
        throws IOException
    {
        int i = read(field_77389_a, 0, 1);
        if(i < 0)
        {
            return i;
        } else
        {
            return field_77389_a[0];
        }
    }

    public int read(byte p_read_1_[], int p_read_2_, int p_read_3_)
        throws IOException
    {
        p_read_3_ = field_77386_d.read(p_read_1_, p_read_2_, p_read_3_);
        for(int i = 0; i < p_read_3_; i++)
        {
            byte byte0 = p_read_1_[p_read_2_ + i] ^= field_77388_c >> 8;
            field_77388_c = field_77388_c * 0x1dba038f + 0x14ee3 * byte0;
        }

        return p_read_3_;
    }
}
