// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            MaterialTransparent, MapColor, MaterialLiquid, MaterialLogic, 
//            MaterialPortal, MaterialWeb

public class Material
{

    public static final Material field_76249_a;
    public static final Material field_76247_b;
    public static final Material field_76248_c;
    public static final Material field_76245_d;
    public static final Material field_76246_e;
    public static final Material field_76243_f;
    public static final Material field_76244_g;
    public static final Material field_76256_h;
    public static final Material field_76257_i;
    public static final Material field_76254_j;
    public static final Material field_76255_k;
    public static final Material field_76252_l;
    public static final Material field_76253_m;
    public static final Material field_76250_n;
    public static final Material field_76251_o;
    public static final Material field_76265_p;
    public static final Material field_76264_q;
    public static final Material field_76263_r;
    public static final Material field_76262_s;
    public static final Material field_76261_t;
    public static final Material field_76260_u;
    public static final Material field_76259_v;
    public static final Material field_76258_w;
    public static final Material field_76268_x;
    public static final Material field_76267_y;
    public static final Material field_76266_z;
    public static final Material field_76236_A;
    public static final Material field_76237_B;
    public static final Material field_76238_C;
    public static final Material field_76232_D;
    public static final Material field_76233_E;
    private boolean field_76235_G;
    private boolean field_76239_H;
    private boolean field_76240_I;
    public final MapColor field_76234_F;
    private boolean field_76241_J;
    private int field_76242_K;

    public Material(MapColor p_i3882_1_)
    {
        field_76241_J = true;
        field_76234_F = p_i3882_1_;
    }

    public boolean func_76224_d()
    {
        return false;
    }

    public boolean func_76220_a()
    {
        return true;
    }

    public boolean func_76228_b()
    {
        return true;
    }

    public boolean func_76230_c()
    {
        return true;
    }

    private Material func_76223_p()
    {
        field_76240_I = true;
        return this;
    }

    protected Material func_76221_f()
    {
        field_76241_J = false;
        return this;
    }

    protected Material func_76226_g()
    {
        field_76235_G = true;
        return this;
    }

    public boolean func_76217_h()
    {
        return field_76235_G;
    }

    public Material func_76231_i()
    {
        field_76239_H = true;
        return this;
    }

    public boolean func_76222_j()
    {
        return field_76239_H;
    }

    public boolean func_76218_k()
    {
        if(field_76240_I)
        {
            return false;
        } else
        {
            return func_76230_c();
        }
    }

    public boolean func_76229_l()
    {
        return field_76241_J;
    }

    public int func_76227_m()
    {
        return field_76242_K;
    }

    protected Material func_76219_n()
    {
        field_76242_K = 1;
        return this;
    }

    protected Material func_76225_o()
    {
        field_76242_K = 2;
        return this;
    }

    static 
    {
        field_76249_a = new MaterialTransparent(MapColor.field_76279_b);
        field_76247_b = new Material(MapColor.field_76280_c);
        field_76248_c = new Material(MapColor.field_76284_l);
        field_76245_d = (new Material(MapColor.field_76283_o)).func_76226_g();
        field_76246_e = (new Material(MapColor.field_76285_m)).func_76221_f();
        field_76243_f = (new Material(MapColor.field_76288_h)).func_76221_f();
        field_76244_g = (new MaterialLiquid(MapColor.field_76282_n)).func_76219_n();
        field_76256_h = (new MaterialLiquid(MapColor.field_76275_f)).func_76219_n();
        field_76257_i = (new Material(MapColor.field_76289_i)).func_76226_g().func_76223_p().func_76219_n();
        field_76254_j = (new MaterialLogic(MapColor.field_76289_i)).func_76219_n();
        field_76255_k = (new MaterialLogic(MapColor.field_76289_i)).func_76226_g().func_76219_n().func_76231_i();
        field_76252_l = new Material(MapColor.field_76278_e);
        field_76253_m = (new Material(MapColor.field_76278_e)).func_76226_g();
        field_76250_n = (new MaterialTransparent(MapColor.field_76279_b)).func_76219_n();
        field_76251_o = new Material(MapColor.field_76277_d);
        field_76265_p = (new MaterialLogic(MapColor.field_76279_b)).func_76219_n();
        field_76264_q = (new Material(MapColor.field_76279_b)).func_76223_p();
        field_76263_r = new Material(MapColor.field_76279_b);
        field_76262_s = (new Material(MapColor.field_76275_f)).func_76226_g().func_76223_p();
        field_76261_t = (new Material(MapColor.field_76289_i)).func_76219_n();
        field_76260_u = (new Material(MapColor.field_76276_g)).func_76223_p();
        field_76259_v = (new MaterialLogic(MapColor.field_76286_j)).func_76231_i().func_76223_p().func_76221_f().func_76219_n();
        field_76258_w = (new Material(MapColor.field_76286_j)).func_76221_f();
        field_76268_x = (new Material(MapColor.field_76289_i)).func_76223_p().func_76219_n();
        field_76267_y = new Material(MapColor.field_76287_k);
        field_76266_z = (new Material(MapColor.field_76289_i)).func_76219_n();
        field_76236_A = (new Material(MapColor.field_76289_i)).func_76219_n();
        field_76237_B = (new MaterialPortal(MapColor.field_76279_b)).func_76225_o();
        field_76238_C = (new Material(MapColor.field_76279_b)).func_76219_n();
        field_76232_D = (new MaterialWeb(MapColor.field_76278_e)).func_76221_f().func_76219_n();
        field_76233_E = (new Material(MapColor.field_76285_m)).func_76225_o();
    }
}
