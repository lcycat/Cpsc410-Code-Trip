// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, MathHelper, World

public class WorldGenBigTree extends WorldGenerator
{

    static final byte field_76507_a[] = {
        2, 0, 0, 1, 2, 1
    };
    Random field_76505_b;
    World field_76506_c;
    int field_76503_d[] = {
        0, 0, 0
    };
    int field_76504_e;
    int field_76501_f;
    double field_76502_g;
    double field_76514_h;
    double field_76515_i;
    double field_76512_j;
    double field_76513_k;
    int field_76510_l;
    int field_76511_m;
    int field_76508_n;
    int field_76509_o[][];

    public WorldGenBigTree(boolean p_i3784_1_)
    {
        super(p_i3784_1_);
        field_76505_b = new Random();
        field_76504_e = 0;
        field_76502_g = 0.61799999999999999D;
        field_76514_h = 1.0D;
        field_76515_i = 0.38100000000000001D;
        field_76512_j = 1.0D;
        field_76513_k = 1.0D;
        field_76510_l = 1;
        field_76511_m = 12;
        field_76508_n = 4;
    }

    void func_76489_a()
    {
        field_76501_f = (int)((double)field_76504_e * field_76502_g);
        if(field_76501_f >= field_76504_e)
        {
            field_76501_f = field_76504_e - 1;
        }
        int i = (int)(1.3819999999999999D + Math.pow((field_76513_k * (double)field_76504_e) / 13D, 2D));
        if(i < 1)
        {
            i = 1;
        }
        int ai[][] = new int[i * field_76504_e][4];
        int j = (field_76503_d[1] + field_76504_e) - field_76508_n;
        int k = 1;
        int l = field_76503_d[1] + field_76501_f;
        int i1 = j - field_76503_d[1];
        ai[0][0] = field_76503_d[0];
        ai[0][1] = j;
        ai[0][2] = field_76503_d[2];
        ai[0][3] = l;
        j--;
        while(i1 >= 0) 
        {
            int j1 = 0;
            float f = func_76490_a(i1);
            if(f < 0.0F)
            {
                j--;
                i1--;
            } else
            {
                double d = 0.5D;
                for(; j1 < i; j1++)
                {
                    double d1 = field_76512_j * ((double)f * ((double)field_76505_b.nextFloat() + 0.32800000000000001D));
                    double d2 = (double)field_76505_b.nextFloat() * 2D * 3.1415899999999999D;
                    int k1 = MathHelper.func_76128_c(d1 * Math.sin(d2) + (double)field_76503_d[0] + d);
                    int l1 = MathHelper.func_76128_c(d1 * Math.cos(d2) + (double)field_76503_d[2] + d);
                    int ai1[] = {
                        k1, j, l1
                    };
                    int ai2[] = {
                        k1, j + field_76508_n, l1
                    };
                    if(func_76496_a(ai1, ai2) != -1)
                    {
                        continue;
                    }
                    int ai3[] = {
                        field_76503_d[0], field_76503_d[1], field_76503_d[2]
                    };
                    double d3 = Math.sqrt(Math.pow(Math.abs(field_76503_d[0] - ai1[0]), 2D) + Math.pow(Math.abs(field_76503_d[2] - ai1[2]), 2D));
                    double d4 = d3 * field_76515_i;
                    if((double)ai1[1] - d4 > (double)l)
                    {
                        ai3[1] = l;
                    } else
                    {
                        ai3[1] = (int)((double)ai1[1] - d4);
                    }
                    if(func_76496_a(ai3, ai1) == -1)
                    {
                        ai[k][0] = k1;
                        ai[k][1] = j;
                        ai[k][2] = l1;
                        ai[k][3] = ai3[1];
                        k++;
                    }
                }

                j--;
                i1--;
            }
        }
        field_76509_o = new int[k][4];
        System.arraycopy(ai, 0, field_76509_o, 0, k);
    }

    void func_76492_a(int p_76492_1_, int p_76492_2_, int p_76492_3_, float p_76492_4_, byte p_76492_5_, int p_76492_6_)
    {
        int i = (int)((double)p_76492_4_ + 0.61799999999999999D);
        byte byte0 = field_76507_a[p_76492_5_];
        byte byte1 = field_76507_a[p_76492_5_ + 3];
        int ai[] = {
            p_76492_1_, p_76492_2_, p_76492_3_
        };
        int ai1[] = {
            0, 0, 0
        };
        int j = -i;
        int k = -i;
        ai1[p_76492_5_] = ai[p_76492_5_];
        for(; j <= i; j++)
        {
            ai1[byte0] = ai[byte0] + j;
            for(int l = -i; l <= i;)
            {
                double d = Math.pow((double)Math.abs(j) + 0.5D, 2D) + Math.pow((double)Math.abs(l) + 0.5D, 2D);
                if(d > (double)(p_76492_4_ * p_76492_4_))
                {
                    l++;
                } else
                {
                    ai1[byte1] = ai[byte1] + l;
                    int i1 = field_76506_c.func_72798_a(ai1[0], ai1[1], ai1[2]);
                    if(i1 != 0 && i1 != 18)
                    {
                        l++;
                    } else
                    {
                        func_76485_a(field_76506_c, ai1[0], ai1[1], ai1[2], p_76492_6_, 0);
                        l++;
                    }
                }
            }

        }

    }

    float func_76490_a(int p_76490_1_)
    {
        if((double)p_76490_1_ < (double)(float)field_76504_e * 0.29999999999999999D)
        {
            return -1.618F;
        }
        float f = (float)field_76504_e / 2.0F;
        float f1 = (float)field_76504_e / 2.0F - (float)p_76490_1_;
        float f2;
        if(f1 == 0.0F)
        {
            f2 = f;
        } else
        if(Math.abs(f1) >= f)
        {
            f2 = 0.0F;
        } else
        {
            f2 = (float)Math.sqrt(Math.pow(Math.abs(f), 2D) - Math.pow(Math.abs(f1), 2D));
        }
        f2 *= 0.5F;
        return f2;
    }

    float func_76495_b(int p_76495_1_)
    {
        if(p_76495_1_ < 0 || p_76495_1_ >= field_76508_n)
        {
            return -1F;
        }
        return p_76495_1_ != 0 && p_76495_1_ != field_76508_n - 1 ? 3F : 2.0F;
    }

    void func_76491_a(int p_76491_1_, int p_76491_2_, int p_76491_3_)
    {
        int i = p_76491_2_;
        for(int j = p_76491_2_ + field_76508_n; i < j; i++)
        {
            float f = func_76495_b(i - p_76491_2_);
            func_76492_a(p_76491_1_, i, p_76491_3_, f, (byte)1, 18);
        }

    }

    void func_76500_a(int p_76500_1_[], int p_76500_2_[], int p_76500_3_)
    {
        int ai[] = {
            0, 0, 0
        };
        byte byte0 = 0;
        int i = 0;
        for(; byte0 < 3; byte0++)
        {
            ai[byte0] = p_76500_2_[byte0] - p_76500_1_[byte0];
            if(Math.abs(ai[byte0]) > Math.abs(ai[i]))
            {
                i = byte0;
            }
        }

        if(ai[i] == 0)
        {
            return;
        }
        byte byte1 = field_76507_a[i];
        byte byte2 = field_76507_a[i + 3];
        byte byte3;
        if(ai[i] > 0)
        {
            byte3 = 1;
        } else
        {
            byte3 = -1;
        }
        double d = (double)ai[byte1] / (double)ai[i];
        double d1 = (double)ai[byte2] / (double)ai[i];
        int ai1[] = {
            0, 0, 0
        };
        int j = 0;
        for(int k = ai[i] + byte3; j != k; j += byte3)
        {
            ai1[i] = MathHelper.func_76128_c((double)(p_76500_1_[i] + j) + 0.5D);
            ai1[byte1] = MathHelper.func_76128_c((double)p_76500_1_[byte1] + (double)j * d + 0.5D);
            ai1[byte2] = MathHelper.func_76128_c((double)p_76500_1_[byte2] + (double)j * d1 + 0.5D);
            func_76485_a(field_76506_c, ai1[0], ai1[1], ai1[2], p_76500_3_, 0);
        }

    }

    void func_76498_b()
    {
        int i = 0;
        for(int j = field_76509_o.length; i < j; i++)
        {
            int k = field_76509_o[i][0];
            int l = field_76509_o[i][1];
            int i1 = field_76509_o[i][2];
            func_76491_a(k, l, i1);
        }

    }

    boolean func_76493_c(int p_76493_1_)
    {
        return (double)p_76493_1_ >= (double)field_76504_e * 0.20000000000000001D;
    }

    void func_76499_c()
    {
        int i = field_76503_d[0];
        int j = field_76503_d[1];
        int k = field_76503_d[1] + field_76501_f;
        int l = field_76503_d[2];
        int ai[] = {
            i, j, l
        };
        int ai1[] = {
            i, k, l
        };
        func_76500_a(ai, ai1, 17);
        if(field_76510_l == 2)
        {
            ai[0]++;
            ai1[0]++;
            func_76500_a(ai, ai1, 17);
            ai[2]++;
            ai1[2]++;
            func_76500_a(ai, ai1, 17);
            ai[0]--;
            ai1[0]--;
            func_76500_a(ai, ai1, 17);
        }
    }

    void func_76494_d()
    {
        int i = 0;
        int j = field_76509_o.length;
        int ai[] = {
            field_76503_d[0], field_76503_d[1], field_76503_d[2]
        };
        for(; i < j; i++)
        {
            int ai1[] = field_76509_o[i];
            int ai2[] = {
                ai1[0], ai1[1], ai1[2]
            };
            ai[1] = ai1[3];
            int k = ai[1] - field_76503_d[1];
            if(func_76493_c(k))
            {
                func_76500_a(ai, ai2, 17);
            }
        }

    }

    int func_76496_a(int p_76496_1_[], int p_76496_2_[])
    {
        int ai[] = {
            0, 0, 0
        };
        byte byte0 = 0;
        int i = 0;
        for(; byte0 < 3; byte0++)
        {
            ai[byte0] = p_76496_2_[byte0] - p_76496_1_[byte0];
            if(Math.abs(ai[byte0]) > Math.abs(ai[i]))
            {
                i = byte0;
            }
        }

        if(ai[i] == 0)
        {
            return -1;
        }
        byte byte1 = field_76507_a[i];
        byte byte2 = field_76507_a[i + 3];
        byte byte3;
        if(ai[i] > 0)
        {
            byte3 = 1;
        } else
        {
            byte3 = -1;
        }
        double d = (double)ai[byte1] / (double)ai[i];
        double d1 = (double)ai[byte2] / (double)ai[i];
        int ai1[] = {
            0, 0, 0
        };
        int j = 0;
        int k = ai[i] + byte3;
        do
        {
            if(j == k)
            {
                break;
            }
            ai1[i] = p_76496_1_[i] + j;
            ai1[byte1] = MathHelper.func_76128_c((double)p_76496_1_[byte1] + (double)j * d);
            ai1[byte2] = MathHelper.func_76128_c((double)p_76496_1_[byte2] + (double)j * d1);
            int l = field_76506_c.func_72798_a(ai1[0], ai1[1], ai1[2]);
            if(l != 0 && l != 18)
            {
                break;
            }
            j += byte3;
        } while(true);
        if(j == k)
        {
            return -1;
        } else
        {
            return Math.abs(j);
        }
    }

    boolean func_76497_e()
    {
        int ai[] = {
            field_76503_d[0], field_76503_d[1], field_76503_d[2]
        };
        int ai1[] = {
            field_76503_d[0], (field_76503_d[1] + field_76504_e) - 1, field_76503_d[2]
        };
        int i = field_76506_c.func_72798_a(field_76503_d[0], field_76503_d[1] - 1, field_76503_d[2]);
        if(i != 2 && i != 3)
        {
            return false;
        }
        int j = func_76496_a(ai, ai1);
        if(j == -1)
        {
            return true;
        }
        if(j < 6)
        {
            return false;
        } else
        {
            field_76504_e = j;
            return true;
        }
    }

    public void func_76487_a(double p_76487_1_, double p_76487_3_, double p_76487_5_)
    {
        field_76511_m = (int)(p_76487_1_ * 12D);
        if(p_76487_1_ > 0.5D)
        {
            field_76508_n = 5;
        }
        field_76512_j = p_76487_3_;
        field_76513_k = p_76487_5_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        field_76506_c = p_76484_1_;
        long l = p_76484_2_.nextLong();
        field_76505_b.setSeed(l);
        field_76503_d[0] = p_76484_3_;
        field_76503_d[1] = p_76484_4_;
        field_76503_d[2] = p_76484_5_;
        if(field_76504_e == 0)
        {
            field_76504_e = 5 + field_76505_b.nextInt(field_76511_m);
        }
        if(!func_76497_e())
        {
            return false;
        } else
        {
            func_76489_a();
            func_76498_b();
            func_76499_c();
            func_76494_d();
            return true;
        }
    }

}
