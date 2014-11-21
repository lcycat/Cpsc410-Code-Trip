// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, Material, BiomeGenBase

public interface IBlockAccess
{

    public abstract int func_72798_a(int i, int j, int k);

    public abstract TileEntity func_72796_p(int i, int j, int k);

    public abstract int func_72802_i(int i, int j, int k, int l);

    public abstract float func_72808_j(int i, int j, int k, int l);

    public abstract float func_72801_o(int i, int j, int k);

    public abstract int func_72805_g(int i, int j, int k);

    public abstract Material func_72803_f(int i, int j, int k);

    public abstract boolean func_72804_r(int i, int j, int k);

    public abstract boolean func_72809_s(int i, int j, int k);

    public abstract boolean func_72799_c(int i, int j, int k);

    public abstract BiomeGenBase func_72807_a(int i, int j);

    public abstract int func_72800_K();

    public abstract boolean func_72806_N();

    public abstract boolean func_72797_t(int i, int j, int k);
}
