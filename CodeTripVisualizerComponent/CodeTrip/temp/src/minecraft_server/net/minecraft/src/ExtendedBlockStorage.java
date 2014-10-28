// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            NibbleArray, Block

public class ExtendedBlockStorage
{

    private int field_76684_a;
    private int field_76682_b;
    private int field_76683_c;
    private byte field_76680_d[];
    private NibbleArray field_76681_e;
    private NibbleArray field_76678_f;
    private NibbleArray field_76679_g;
    private NibbleArray field_76685_h;

    public ExtendedBlockStorage(int p_i3773_1_)
    {
        field_76684_a = p_i3773_1_;
        field_76680_d = new byte[4096];
        field_76678_f = new NibbleArray(field_76680_d.length, 4);
        field_76685_h = new NibbleArray(field_76680_d.length, 4);
        field_76679_g = new NibbleArray(field_76680_d.length, 4);
    }

    public int func_76656_a(int p_76656_1_, int p_76656_2_, int p_76656_3_)
    {
        int i = field_76680_d[p_76656_2_ << 8 | p_76656_3_ << 4 | p_76656_1_] & 0xff;
        if(field_76681_e != null)
        {
            return field_76681_e.func_76582_a(p_76656_1_, p_76656_2_, p_76656_3_) << 8 | i;
        } else
        {
            return i;
        }
    }

    public void func_76655_a(int p_76655_1_, int p_76655_2_, int p_76655_3_, int p_76655_4_)
    {
        int i = field_76680_d[p_76655_2_ << 8 | p_76655_3_ << 4 | p_76655_1_] & 0xff;
        if(field_76681_e != null)
        {
            i = field_76681_e.func_76582_a(p_76655_1_, p_76655_2_, p_76655_3_) << 8 | i;
        }
        if(i == 0 && p_76655_4_ != 0)
        {
            field_76682_b++;
            if(Block.field_71973_m[p_76655_4_] != null && Block.field_71973_m[p_76655_4_].func_71881_r())
            {
                field_76683_c++;
            }
        } else
        if(i != 0 && p_76655_4_ == 0)
        {
            field_76682_b--;
            if(Block.field_71973_m[i] != null && Block.field_71973_m[i].func_71881_r())
            {
                field_76683_c--;
            }
        } else
        if(Block.field_71973_m[i] != null && Block.field_71973_m[i].func_71881_r() && (Block.field_71973_m[p_76655_4_] == null || !Block.field_71973_m[p_76655_4_].func_71881_r()))
        {
            field_76683_c--;
        } else
        if((Block.field_71973_m[i] == null || !Block.field_71973_m[i].func_71881_r()) && Block.field_71973_m[p_76655_4_] != null && Block.field_71973_m[p_76655_4_].func_71881_r())
        {
            field_76683_c++;
        }
        field_76680_d[p_76655_2_ << 8 | p_76655_3_ << 4 | p_76655_1_] = (byte)(p_76655_4_ & 0xff);
        if(p_76655_4_ > 255)
        {
            if(field_76681_e == null)
            {
                field_76681_e = new NibbleArray(field_76680_d.length, 4);
            }
            field_76681_e.func_76581_a(p_76655_1_, p_76655_2_, p_76655_3_, (p_76655_4_ & 0xf00) >> 8);
        } else
        if(field_76681_e != null)
        {
            field_76681_e.func_76581_a(p_76655_1_, p_76655_2_, p_76655_3_, 0);
        }
    }

    public int func_76665_b(int p_76665_1_, int p_76665_2_, int p_76665_3_)
    {
        return field_76678_f.func_76582_a(p_76665_1_, p_76665_2_, p_76665_3_);
    }

    public void func_76654_b(int p_76654_1_, int p_76654_2_, int p_76654_3_, int p_76654_4_)
    {
        field_76678_f.func_76581_a(p_76654_1_, p_76654_2_, p_76654_3_, p_76654_4_);
    }

    public boolean func_76663_a()
    {
        return field_76682_b == 0;
    }

    public boolean func_76675_b()
    {
        return field_76683_c > 0;
    }

    public int func_76662_d()
    {
        return field_76684_a;
    }

    public void func_76657_c(int p_76657_1_, int p_76657_2_, int p_76657_3_, int p_76657_4_)
    {
        field_76685_h.func_76581_a(p_76657_1_, p_76657_2_, p_76657_3_, p_76657_4_);
    }

    public int func_76670_c(int p_76670_1_, int p_76670_2_, int p_76670_3_)
    {
        return field_76685_h.func_76582_a(p_76670_1_, p_76670_2_, p_76670_3_);
    }

    public void func_76677_d(int p_76677_1_, int p_76677_2_, int p_76677_3_, int p_76677_4_)
    {
        field_76679_g.func_76581_a(p_76677_1_, p_76677_2_, p_76677_3_, p_76677_4_);
    }

    public int func_76674_d(int p_76674_1_, int p_76674_2_, int p_76674_3_)
    {
        return field_76679_g.func_76582_a(p_76674_1_, p_76674_2_, p_76674_3_);
    }

    public void func_76672_e()
    {
        field_76682_b = 0;
        field_76683_c = 0;
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                for(int k = 0; k < 16; k++)
                {
                    int l = func_76656_a(i, j, k);
                    if(l <= 0)
                    {
                        continue;
                    }
                    if(Block.field_71973_m[l] == null)
                    {
                        field_76680_d[j << 8 | k << 4 | i] = 0;
                        if(field_76681_e != null)
                        {
                            field_76681_e.func_76581_a(i, j, k, 0);
                        }
                        continue;
                    }
                    field_76682_b++;
                    if(Block.field_71973_m[l].func_71881_r())
                    {
                        field_76683_c++;
                    }
                }

            }

        }

    }

    public byte[] func_76658_g()
    {
        return field_76680_d;
    }

    public NibbleArray func_76660_i()
    {
        return field_76681_e;
    }

    public NibbleArray func_76669_j()
    {
        return field_76678_f;
    }

    public NibbleArray func_76661_k()
    {
        return field_76679_g;
    }

    public NibbleArray func_76671_l()
    {
        return field_76685_h;
    }

    public void func_76664_a(byte p_76664_1_[])
    {
        field_76680_d = p_76664_1_;
    }

    public void func_76673_a(NibbleArray p_76673_1_)
    {
        field_76681_e = p_76673_1_;
    }

    public void func_76668_b(NibbleArray p_76668_1_)
    {
        field_76678_f = p_76668_1_;
    }

    public void func_76659_c(NibbleArray p_76659_1_)
    {
        field_76679_g = p_76659_1_;
    }

    public void func_76666_d(NibbleArray p_76666_1_)
    {
        field_76685_h = p_76666_1_;
    }
}
