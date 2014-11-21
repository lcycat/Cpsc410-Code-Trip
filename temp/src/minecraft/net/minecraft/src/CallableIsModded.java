// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            IntegratedServer

class CallableIsModded
    implements Callable
{

    final IntegratedServer field_76972_a; /* synthetic field */

    CallableIsModded(IntegratedServer p_i3123_1_)
    {
        field_76972_a = p_i3123_1_;
        super();
    }

    public String func_76971_a()
    {
        String s = ClientBrandRetriever.getClientModName();
        if(!s.equals("vanilla"))
        {
            return (new StringBuilder()).append("Definitely; '").append(s).append("'").toString();
        }
        s = field_76972_a.getServerModName();
        if(!s.equals("vanilla"))
        {
            return (new StringBuilder()).append("Definitely; '").append(s).append("'").toString();
        }
        if((net.minecraft.client.Minecraft.class).getClassLoader().getResource("META-INF/MOJANG_C.DSA") == null)
        {
            return "Very likely";
        } else
        {
            return "Probably not";
        }
    }

    public Object call()
    {
        return func_76971_a();
    }
}
