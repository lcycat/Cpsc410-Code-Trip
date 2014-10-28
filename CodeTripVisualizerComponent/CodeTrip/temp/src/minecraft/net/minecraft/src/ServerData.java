// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            NBTTagCompound

public class ServerData
{

    public String field_78847_a;
    public String field_78845_b;
    public String field_78846_c;
    public String field_78843_d;
    public long field_78844_e;
    public boolean field_78841_f;
    private boolean field_78842_g;
    private boolean field_78848_h;

    public ServerData(String p_i3107_1_, String p_i3107_2_)
    {
        field_78841_f = false;
        field_78842_g = true;
        field_78848_h = false;
        field_78847_a = p_i3107_1_;
        field_78845_b = p_i3107_2_;
    }

    public NBTTagCompound func_78836_a()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.func_74778_a("name", field_78847_a);
        nbttagcompound.func_74778_a("ip", field_78845_b);
        if(!field_78842_g)
        {
            nbttagcompound.func_74757_a("acceptTextures", field_78848_h);
        }
        return nbttagcompound;
    }

    public boolean func_78839_b()
    {
        return field_78848_h;
    }

    public boolean func_78840_c()
    {
        return field_78842_g;
    }

    public void func_78838_a(boolean p_78838_1_)
    {
        field_78848_h = p_78838_1_;
        field_78842_g = false;
    }

    public static ServerData func_78837_a(NBTTagCompound p_78837_0_)
    {
        ServerData serverdata = new ServerData(p_78837_0_.func_74779_i("name"), p_78837_0_.func_74779_i("ip"));
        if(p_78837_0_.func_74764_b("acceptTextures"))
        {
            serverdata.func_78838_a(p_78837_0_.func_74767_n("acceptTextures"));
        }
        return serverdata;
    }
}
