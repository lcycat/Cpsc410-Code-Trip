// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            NBTTagCompound

public abstract class WorldSavedData
{

    public final String field_76190_i;
    private boolean field_76189_a;

    public WorldSavedData(String p_i3907_1_)
    {
        field_76190_i = p_i3907_1_;
    }

    public abstract void func_76184_a(NBTTagCompound nbttagcompound);

    public abstract void func_76187_b(NBTTagCompound nbttagcompound);

    public void func_76185_a()
    {
        func_76186_a(true);
    }

    public void func_76186_a(boolean p_76186_1_)
    {
        field_76189_a = p_76186_1_;
    }

    public boolean func_76188_b()
    {
        return field_76189_a;
    }
}
