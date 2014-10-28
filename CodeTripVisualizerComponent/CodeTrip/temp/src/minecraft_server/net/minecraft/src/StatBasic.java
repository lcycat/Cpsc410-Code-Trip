// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            StatBase, StatList, IStatType

public class StatBasic extends StatBase
{

    public StatBasic(int p_i3412_1_, String p_i3412_2_, IStatType p_i3412_3_)
    {
        super(p_i3412_1_, p_i3412_2_, p_i3412_3_);
    }

    public StatBasic(int p_i3413_1_, String p_i3413_2_)
    {
        super(p_i3413_1_, p_i3413_2_);
    }

    public StatBase func_75971_g()
    {
        super.func_75971_g();
        StatList.field_75941_c.add(this);
        return this;
    }
}
