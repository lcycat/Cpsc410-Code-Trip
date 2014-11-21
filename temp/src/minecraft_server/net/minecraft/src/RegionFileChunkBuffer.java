// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package net.minecraft.src:
//            RegionFile

class RegionFileChunkBuffer extends ByteArrayOutputStream
{

    private int field_76722_b;
    private int field_76723_c;
    final RegionFile field_76724_a; /* synthetic field */

    public RegionFileChunkBuffer(RegionFile p_i3776_1_, int p_i3776_2_, int p_i3776_3_)
    {
        field_76724_a = p_i3776_1_;
        super(8096);
        field_76722_b = p_i3776_2_;
        field_76723_c = p_i3776_3_;
    }

    public void close()
        throws IOException
    {
        field_76724_a.func_76706_a(field_76722_b, field_76723_c, buf, count);
    }
}
