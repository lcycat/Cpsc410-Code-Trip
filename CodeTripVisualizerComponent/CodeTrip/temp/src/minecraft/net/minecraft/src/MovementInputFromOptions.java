// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            MovementInput, GameSettings, KeyBinding

public class MovementInputFromOptions extends MovementInput
{

    private GameSettings field_78903_e;

    public MovementInputFromOptions(GameSettings p_i3115_1_)
    {
        field_78903_e = p_i3115_1_;
    }

    public void func_78898_a()
    {
        field_78902_a = 0.0F;
        field_78900_b = 0.0F;
        if(field_78903_e.field_74351_w.field_74513_e)
        {
            field_78900_b++;
        }
        if(field_78903_e.field_74368_y.field_74513_e)
        {
            field_78900_b--;
        }
        if(field_78903_e.field_74370_x.field_74513_e)
        {
            field_78902_a++;
        }
        if(field_78903_e.field_74366_z.field_74513_e)
        {
            field_78902_a--;
        }
        field_78901_c = field_78903_e.field_74314_A.field_74513_e;
        field_78899_d = field_78903_e.field_74311_E.field_74513_e;
        if(field_78899_d)
        {
            field_78902_a *= 0.29999999999999999D;
            field_78900_b *= 0.29999999999999999D;
        }
    }
}
