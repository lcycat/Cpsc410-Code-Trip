// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.zip.ZipFile;

// Referenced classes of package net.minecraft.src:
//            TexturePackImplementation, RenderEngine

public class TexturePackCustom extends TexturePackImplementation
{

    private ZipFile field_77550_e;

    public TexturePackCustom(String p_i3031_1_, File p_i3031_2_)
    {
        super(p_i3031_1_, p_i3031_2_, p_i3031_2_.getName());
    }

    public void func_77533_a(RenderEngine p_77533_1_)
    {
        super.func_77533_a(p_77533_1_);
        try
        {
            field_77550_e.close();
        }
        catch(IOException ioexception) { }
        field_77550_e = null;
    }

    public InputStream func_77532_a(String p_77532_1_)
    {
        func_77549_g();
        try
        {
            java.util.zip.ZipEntry zipentry = field_77550_e.getEntry(p_77532_1_.substring(1));
            if(zipentry != null)
            {
                return field_77550_e.getInputStream(zipentry);
            }
        }
        catch(Exception exception) { }
        return super.func_77532_a(p_77532_1_);
    }

    private void func_77549_g()
    {
        if(field_77550_e != null)
        {
            return;
        }
        try
        {
            field_77550_e = new ZipFile(field_77548_a);
        }
        catch(IOException ioexception) { }
    }
}
