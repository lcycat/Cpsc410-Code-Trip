// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            TexturePackImplementation

public class TexturePackFolder extends TexturePackImplementation
{

    public TexturePackFolder(String p_i3029_1_, File p_i3029_2_)
    {
        super(p_i3029_1_, p_i3029_2_, p_i3029_2_.getName());
    }

    public InputStream func_77532_a(String p_77532_1_)
    {
        try
        {
            File file = new File(field_77548_a, p_77532_1_.substring(1));
            if(file.exists())
            {
                return new BufferedInputStream(new FileInputStream(file));
            }
        }
        catch(IOException ioexception) { }
        return super.func_77532_a(p_77532_1_);
    }
}
