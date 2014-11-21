// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            NBTTagCompound

public class PlayerCapabilities
{

    public boolean field_75102_a;
    public boolean field_75100_b;
    public boolean field_75101_c;
    public boolean field_75098_d;
    public boolean field_75099_e;
    private float field_75096_f;
    private float field_75097_g;

    public PlayerCapabilities()
    {
        field_75102_a = false;
        field_75100_b = false;
        field_75101_c = false;
        field_75098_d = false;
        field_75099_e = true;
        field_75096_f = 0.05F;
        field_75097_g = 0.1F;
    }

    public void func_75091_a(NBTTagCompound p_75091_1_)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.func_74757_a("invulnerable", field_75102_a);
        nbttagcompound.func_74757_a("flying", field_75100_b);
        nbttagcompound.func_74757_a("mayfly", field_75101_c);
        nbttagcompound.func_74757_a("instabuild", field_75098_d);
        nbttagcompound.func_74757_a("mayBuild", field_75099_e);
        nbttagcompound.func_74776_a("flySpeed", field_75096_f);
        nbttagcompound.func_74776_a("walkSpeed", field_75097_g);
        p_75091_1_.func_74782_a("abilities", nbttagcompound);
    }

    public void func_75095_b(NBTTagCompound p_75095_1_)
    {
        if(p_75095_1_.func_74764_b("abilities"))
        {
            NBTTagCompound nbttagcompound = p_75095_1_.func_74775_l("abilities");
            field_75102_a = nbttagcompound.func_74767_n("invulnerable");
            field_75100_b = nbttagcompound.func_74767_n("flying");
            field_75101_c = nbttagcompound.func_74767_n("mayfly");
            field_75098_d = nbttagcompound.func_74767_n("instabuild");
            if(nbttagcompound.func_74764_b("flySpeed"))
            {
                field_75096_f = nbttagcompound.func_74760_g("flySpeed");
                field_75097_g = nbttagcompound.func_74760_g("walkSpeed");
            }
            if(nbttagcompound.func_74764_b("mayBuild"))
            {
                field_75099_e = nbttagcompound.func_74767_n("mayBuild");
            }
        }
    }

    public float func_75093_a()
    {
        return field_75096_f;
    }

    public void func_75092_a(float p_75092_1_)
    {
        field_75096_f = p_75092_1_;
    }

    public float func_75094_b()
    {
        return field_75097_g;
    }
}
