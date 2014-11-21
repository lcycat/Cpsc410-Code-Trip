// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class MapColor
{

    public static final MapColor field_76281_a[] = new MapColor[16];
    public static final MapColor field_76279_b = new MapColor(0, 0);
    public static final MapColor field_76280_c = new MapColor(1, 0x7fb238);
    public static final MapColor field_76277_d = new MapColor(2, 0xf7e9a3);
    public static final MapColor field_76278_e = new MapColor(3, 0xa7a7a7);
    public static final MapColor field_76275_f = new MapColor(4, 0xff0000);
    public static final MapColor field_76276_g = new MapColor(5, 0xa0a0ff);
    public static final MapColor field_76288_h = new MapColor(6, 0xa7a7a7);
    public static final MapColor field_76289_i = new MapColor(7, 31744);
    public static final MapColor field_76286_j = new MapColor(8, 0xffffff);
    public static final MapColor field_76287_k = new MapColor(9, 0xa4a8b8);
    public static final MapColor field_76284_l = new MapColor(10, 0xb76a2f);
    public static final MapColor field_76285_m = new MapColor(11, 0x707070);
    public static final MapColor field_76282_n = new MapColor(12, 0x4040ff);
    public static final MapColor field_76283_o = new MapColor(13, 0x685332);
    public final int field_76291_p;
    public final int field_76290_q;

    private MapColor(int p_i3883_1_, int p_i3883_2_)
    {
        field_76290_q = p_i3883_1_;
        field_76291_p = p_i3883_2_;
        field_76281_a[p_i3883_1_] = this;
    }

}
