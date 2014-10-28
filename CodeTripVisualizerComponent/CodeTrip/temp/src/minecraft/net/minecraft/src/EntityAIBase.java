// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public abstract class EntityAIBase
{

    private int field_75254_a;

    public EntityAIBase()
    {
        field_75254_a = 0;
    }

    public abstract boolean func_75250_a();

    public boolean func_75253_b()
    {
        return func_75250_a();
    }

    public boolean func_75252_g()
    {
        return true;
    }

    public void func_75249_e()
    {
    }

    public void func_75251_c()
    {
    }

    public void func_75246_d()
    {
    }

    public void func_75248_a(int p_75248_1_)
    {
        field_75254_a = p_75248_1_;
    }

    public int func_75247_h()
    {
        return field_75254_a;
    }
}
