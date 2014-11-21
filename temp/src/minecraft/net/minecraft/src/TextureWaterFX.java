// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TextureFX, Block

public class TextureWaterFX extends TextureFX
{

    protected float field_76855_g[];
    protected float field_76858_h[];
    protected float field_76859_i[];
    protected float field_76856_j[];
    private int field_76857_k;

    public TextureWaterFX()
    {
        super(Block.field_71942_A.field_72059_bZ);
        field_76855_g = new float[256];
        field_76858_h = new float[256];
        field_76859_i = new float[256];
        field_76856_j = new float[256];
        field_76857_k = 0;
    }

    public void func_76846_a()
    {
        field_76857_k++;
        for(int i = 0; i < 16; i++)
        {
            for(int k = 0; k < 16; k++)
            {
                float f = 0.0F;
                for(int j1 = i - 1; j1 <= i + 1; j1++)
                {
                    int k1 = j1 & 0xf;
                    int i2 = k & 0xf;
                    f += field_76855_g[k1 + i2 * 16];
                }

                field_76858_h[i + k * 16] = f / 3.3F + field_76859_i[i + k * 16] * 0.8F;
            }

        }

        for(int j = 0; j < 16; j++)
        {
            for(int l = 0; l < 16; l++)
            {
                field_76859_i[j + l * 16] += field_76856_j[j + l * 16] * 0.05F;
                if(field_76859_i[j + l * 16] < 0.0F)
                {
                    field_76859_i[j + l * 16] = 0.0F;
                }
                field_76856_j[j + l * 16] -= 0.1F;
                if(Math.random() < 0.050000000000000003D)
                {
                    field_76856_j[j + l * 16] = 0.5F;
                }
            }

        }

        float af[] = field_76858_h;
        field_76858_h = field_76855_g;
        field_76855_g = af;
        for(int i1 = 0; i1 < 256; i1++)
        {
            float f1 = field_76855_g[i1];
            if(f1 > 1.0F)
            {
                f1 = 1.0F;
            }
            if(f1 < 0.0F)
            {
                f1 = 0.0F;
            }
            float f2 = f1 * f1;
            int l1 = (int)(32F + f2 * 32F);
            int j2 = (int)(50F + f2 * 64F);
            int k2 = 255;
            int l2 = (int)(146F + f2 * 50F);
            if(field_76851_c)
            {
                int i3 = (l1 * 30 + j2 * 59 + k2 * 11) / 100;
                int j3 = (l1 * 30 + j2 * 70) / 100;
                int k3 = (l1 * 30 + k2 * 70) / 100;
                l1 = i3;
                j2 = j3;
                k2 = k3;
            }
            field_76852_a[i1 * 4 + 0] = (byte)l1;
            field_76852_a[i1 * 4 + 1] = (byte)j2;
            field_76852_a[i1 * 4 + 2] = (byte)k2;
            field_76852_a[i1 * 4 + 3] = (byte)l2;
        }

    }
}
