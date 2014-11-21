// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            TileEntity, World, EntityPlayer

public class TileEntityEnchantmentTable extends TileEntity
{

    public int field_70378_a;
    public float field_70375_b;
    public float field_70377_c;
    public float field_70373_d;
    public float field_70374_e;
    public float field_70371_f;
    public float field_70372_g;
    public float field_70380_h;
    public float field_70381_i;
    public float field_70379_j;
    private static Random field_70376_r = new Random();

    public TileEntityEnchantmentTable()
    {
    }

    public void func_70316_g()
    {
        super.func_70316_g();
        field_70372_g = field_70371_f;
        field_70381_i = field_70380_h;
        EntityPlayer entityplayer = field_70331_k.func_72977_a((float)field_70329_l + 0.5F, (float)field_70330_m + 0.5F, (float)field_70327_n + 0.5F, 3D);
        if(entityplayer != null)
        {
            double d = entityplayer.field_70165_t - (double)((float)field_70329_l + 0.5F);
            double d1 = entityplayer.field_70161_v - (double)((float)field_70327_n + 0.5F);
            field_70379_j = (float)Math.atan2(d1, d);
            field_70371_f += 0.1F;
            if(field_70371_f < 0.5F || field_70376_r.nextInt(40) == 0)
            {
                float f3 = field_70373_d;
                do
                {
                    field_70373_d += field_70376_r.nextInt(4) - field_70376_r.nextInt(4);
                } while(f3 == field_70373_d);
            }
        } else
        {
            field_70379_j += 0.02F;
            field_70371_f -= 0.1F;
        }
        for(; field_70380_h >= 3.141593F; field_70380_h -= 6.283185F) { }
        for(; field_70380_h < -3.141593F; field_70380_h += 6.283185F) { }
        for(; field_70379_j >= 3.141593F; field_70379_j -= 6.283185F) { }
        for(; field_70379_j < -3.141593F; field_70379_j += 6.283185F) { }
        float f;
        for(f = field_70379_j - field_70380_h; f >= 3.141593F; f -= 6.283185F) { }
        for(; f < -3.141593F; f += 6.283185F) { }
        field_70380_h += f * 0.4F;
        if(field_70371_f < 0.0F)
        {
            field_70371_f = 0.0F;
        }
        if(field_70371_f > 1.0F)
        {
            field_70371_f = 1.0F;
        }
        field_70378_a++;
        field_70377_c = field_70375_b;
        float f1 = (field_70373_d - field_70375_b) * 0.4F;
        float f2 = 0.2F;
        if(f1 < -f2)
        {
            f1 = -f2;
        }
        if(f1 > f2)
        {
            f1 = f2;
        }
        field_70374_e += (f1 - field_70374_e) * 0.9F;
        field_70375_b += field_70374_e;
    }

}
