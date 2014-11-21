// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            IDownloadSuccess, TexturePackList, TexturePackCustom

class TexturePackDownloadSuccess
    implements IDownloadSuccess
{

    final TexturePackList field_76171_a; /* synthetic field */

    TexturePackDownloadSuccess(TexturePackList p_i3024_1_)
    {
        field_76171_a = p_i3024_1_;
        super();
    }

    public void func_76170_a(File p_76170_1_)
    {
        if(!TexturePackList.func_77301_a(field_76171_a))
        {
            return;
        } else
        {
            TexturePackList.func_77303_a(field_76171_a, new TexturePackCustom(TexturePackList.func_77291_a(field_76171_a, p_76170_1_), p_76170_1_));
            TexturePackList.func_77306_b(field_76171_a).func_71395_y();
            return;
        }
    }
}
