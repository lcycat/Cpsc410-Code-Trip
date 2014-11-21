// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Entity, EntityPlayer

public interface IWorldAccess
{

    public abstract void func_72710_a(int i, int j, int k);

    public abstract void func_72711_b(int i, int j, int k);

    public abstract void func_72707_a(int i, int j, int k, int l, int i1, int j1);

    public abstract void func_72704_a(String s, double d, double d1, double d2, 
            float f, float f1);

    public abstract void func_72708_a(String s, double d, double d1, double d2, 
            double d3, double d4, double d5);

    public abstract void func_72703_a(Entity entity);

    public abstract void func_72709_b(Entity entity);

    public abstract void func_72702_a(String s, int i, int j, int k);

    public abstract void func_72706_a(EntityPlayer entityplayer, int i, int j, int k, int l, int i1);

    public abstract void func_72705_a(int i, int j, int k, int l, int i1);
}
