// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenClay, WorldGenSand, Block, WorldGenMinable, 
//            WorldGenFlowers, BlockFlower, WorldGenBigMushroom, WorldGenReed, 
//            WorldGenCactus, WorldGenWaterlily, World, WorldGenerator, 
//            BiomeGenBase, WorldGenDeadBush, BlockDeadBush, WorldGenPumpkin, 
//            WorldGenLiquids

public class BiomeDecorator
{

    protected World field_76815_a;
    protected Random field_76813_b;
    protected int field_76814_c;
    protected int field_76811_d;
    protected BiomeGenBase field_76812_e;
    protected WorldGenerator field_76809_f;
    protected WorldGenerator field_76810_g;
    protected WorldGenerator field_76822_h;
    protected WorldGenerator field_76823_i;
    protected WorldGenerator field_76820_j;
    protected WorldGenerator field_76821_k;
    protected WorldGenerator field_76818_l;
    protected WorldGenerator field_76819_m;
    protected WorldGenerator field_76816_n;
    protected WorldGenerator field_76817_o;
    protected WorldGenerator field_76831_p;
    protected WorldGenerator field_76830_q;
    protected WorldGenerator field_76829_r;
    protected WorldGenerator field_76828_s;
    protected WorldGenerator field_76827_t;
    protected WorldGenerator field_76826_u;
    protected WorldGenerator field_76825_v;
    protected WorldGenerator field_76824_w;
    protected WorldGenerator field_76834_x;
    protected int field_76833_y;
    protected int field_76832_z;
    protected int field_76802_A;
    protected int field_76803_B;
    protected int field_76804_C;
    protected int field_76798_D;
    protected int field_76799_E;
    protected int field_76800_F;
    protected int field_76801_G;
    protected int field_76805_H;
    protected int field_76806_I;
    protected int field_76807_J;
    public boolean field_76808_K;

    public BiomeDecorator(BiomeGenBase p_i3750_1_)
    {
        field_76809_f = new WorldGenClay(4);
        field_76810_g = new WorldGenSand(7, Block.field_71939_E.field_71990_ca);
        field_76822_h = new WorldGenSand(6, Block.field_71940_F.field_71990_ca);
        field_76823_i = new WorldGenMinable(Block.field_71979_v.field_71990_ca, 32);
        field_76820_j = new WorldGenMinable(Block.field_71940_F.field_71990_ca, 32);
        field_76821_k = new WorldGenMinable(Block.field_71950_I.field_71990_ca, 16);
        field_76818_l = new WorldGenMinable(Block.field_71949_H.field_71990_ca, 8);
        field_76819_m = new WorldGenMinable(Block.field_71941_G.field_71990_ca, 8);
        field_76816_n = new WorldGenMinable(Block.field_72047_aN.field_71990_ca, 7);
        field_76817_o = new WorldGenMinable(Block.field_72073_aw.field_71990_ca, 7);
        field_76831_p = new WorldGenMinable(Block.field_71947_N.field_71990_ca, 6);
        field_76830_q = new WorldGenFlowers(Block.field_72097_ad.field_71990_ca);
        field_76829_r = new WorldGenFlowers(Block.field_72107_ae.field_71990_ca);
        field_76828_s = new WorldGenFlowers(Block.field_72109_af.field_71990_ca);
        field_76827_t = new WorldGenFlowers(Block.field_72103_ag.field_71990_ca);
        field_76826_u = new WorldGenBigMushroom();
        field_76825_v = new WorldGenReed();
        field_76824_w = new WorldGenCactus();
        field_76834_x = new WorldGenWaterlily();
        field_76833_y = 0;
        field_76832_z = 0;
        field_76802_A = 2;
        field_76803_B = 1;
        field_76804_C = 0;
        field_76798_D = 0;
        field_76799_E = 0;
        field_76800_F = 0;
        field_76801_G = 1;
        field_76805_H = 3;
        field_76806_I = 1;
        field_76807_J = 0;
        field_76808_K = true;
        field_76812_e = p_i3750_1_;
    }

    public void func_76796_a(World p_76796_1_, Random p_76796_2_, int p_76796_3_, int p_76796_4_)
    {
        if(field_76815_a != null)
        {
            throw new RuntimeException("Already decorating!!");
        } else
        {
            field_76815_a = p_76796_1_;
            field_76813_b = p_76796_2_;
            field_76814_c = p_76796_3_;
            field_76811_d = p_76796_4_;
            func_76794_a();
            field_76815_a = null;
            field_76813_b = null;
            return;
        }
    }

    protected void func_76794_a()
    {
        func_76797_b();
        for(int i = 0; i < field_76805_H; i++)
        {
            int i1 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int k5 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76810_g.func_76484_a(field_76815_a, field_76813_b, i1, field_76815_a.func_72825_h(i1, k5), k5);
        }

        for(int j = 0; j < field_76806_I; j++)
        {
            int j1 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int l5 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76809_f.func_76484_a(field_76815_a, field_76813_b, j1, field_76815_a.func_72825_h(j1, l5), l5);
        }

        for(int k = 0; k < field_76801_G; k++)
        {
            int k1 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int i6 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76810_g.func_76484_a(field_76815_a, field_76813_b, k1, field_76815_a.func_72825_h(k1, i6), i6);
        }

        int l = field_76832_z;
        if(field_76813_b.nextInt(10) == 0)
        {
            l++;
        }
        for(int l1 = 0; l1 < l; l1++)
        {
            int j6 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int k10 = field_76811_d + field_76813_b.nextInt(16) + 8;
            WorldGenerator worldgenerator = field_76812_e.func_76740_a(field_76813_b);
            worldgenerator.func_76487_a(1.0D, 1.0D, 1.0D);
            worldgenerator.func_76484_a(field_76815_a, field_76813_b, j6, field_76815_a.func_72976_f(j6, k10), k10);
        }

        for(int i2 = 0; i2 < field_76807_J; i2++)
        {
            int k6 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int l10 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76826_u.func_76484_a(field_76815_a, field_76813_b, k6, field_76815_a.func_72976_f(k6, l10), l10);
        }

        for(int j2 = 0; j2 < field_76802_A; j2++)
        {
            int l6 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int i11 = field_76813_b.nextInt(128);
            int l14 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76830_q.func_76484_a(field_76815_a, field_76813_b, l6, i11, l14);
            if(field_76813_b.nextInt(4) == 0)
            {
                int i7 = field_76814_c + field_76813_b.nextInt(16) + 8;
                int j11 = field_76813_b.nextInt(128);
                int i15 = field_76811_d + field_76813_b.nextInt(16) + 8;
                field_76829_r.func_76484_a(field_76815_a, field_76813_b, i7, j11, i15);
            }
        }

        for(int k2 = 0; k2 < field_76803_B; k2++)
        {
            int j7 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int k11 = field_76813_b.nextInt(128);
            int j15 = field_76811_d + field_76813_b.nextInt(16) + 8;
            WorldGenerator worldgenerator1 = field_76812_e.func_76730_b(field_76813_b);
            worldgenerator1.func_76484_a(field_76815_a, field_76813_b, j7, k11, j15);
        }

        for(int l2 = 0; l2 < field_76804_C; l2++)
        {
            int k7 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int l11 = field_76813_b.nextInt(128);
            int k15 = field_76811_d + field_76813_b.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.field_71961_Y.field_71990_ca)).func_76484_a(field_76815_a, field_76813_b, k7, l11, k15);
        }

        for(int i3 = 0; i3 < field_76833_y; i3++)
        {
            int l7 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int i12 = field_76811_d + field_76813_b.nextInt(16) + 8;
            int l15;
            for(l15 = field_76813_b.nextInt(128); l15 > 0 && field_76815_a.func_72798_a(l7, l15 - 1, i12) == 0; l15--) { }
            field_76834_x.func_76484_a(field_76815_a, field_76813_b, l7, l15, i12);
        }

        for(int j3 = 0; j3 < field_76798_D; j3++)
        {
            if(field_76813_b.nextInt(4) == 0)
            {
                int i8 = field_76814_c + field_76813_b.nextInt(16) + 8;
                int j12 = field_76811_d + field_76813_b.nextInt(16) + 8;
                int i16 = field_76815_a.func_72976_f(i8, j12);
                field_76828_s.func_76484_a(field_76815_a, field_76813_b, i8, i16, j12);
            }
            if(field_76813_b.nextInt(8) == 0)
            {
                int j8 = field_76814_c + field_76813_b.nextInt(16) + 8;
                int k12 = field_76811_d + field_76813_b.nextInt(16) + 8;
                int j16 = field_76813_b.nextInt(128);
                field_76827_t.func_76484_a(field_76815_a, field_76813_b, j8, j16, k12);
            }
        }

        if(field_76813_b.nextInt(4) == 0)
        {
            int k3 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int k8 = field_76813_b.nextInt(128);
            int l12 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76828_s.func_76484_a(field_76815_a, field_76813_b, k3, k8, l12);
        }
        if(field_76813_b.nextInt(8) == 0)
        {
            int l3 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int l8 = field_76813_b.nextInt(128);
            int i13 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76827_t.func_76484_a(field_76815_a, field_76813_b, l3, l8, i13);
        }
        for(int i4 = 0; i4 < field_76799_E; i4++)
        {
            int i9 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int j13 = field_76811_d + field_76813_b.nextInt(16) + 8;
            int k16 = field_76813_b.nextInt(128);
            field_76825_v.func_76484_a(field_76815_a, field_76813_b, i9, k16, j13);
        }

        for(int j4 = 0; j4 < 10; j4++)
        {
            int j9 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int k13 = field_76813_b.nextInt(128);
            int l16 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76825_v.func_76484_a(field_76815_a, field_76813_b, j9, k13, l16);
        }

        if(field_76813_b.nextInt(32) == 0)
        {
            int k4 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int k9 = field_76813_b.nextInt(128);
            int l13 = field_76811_d + field_76813_b.nextInt(16) + 8;
            (new WorldGenPumpkin()).func_76484_a(field_76815_a, field_76813_b, k4, k9, l13);
        }
        for(int l4 = 0; l4 < field_76800_F; l4++)
        {
            int l9 = field_76814_c + field_76813_b.nextInt(16) + 8;
            int i14 = field_76813_b.nextInt(128);
            int i17 = field_76811_d + field_76813_b.nextInt(16) + 8;
            field_76824_w.func_76484_a(field_76815_a, field_76813_b, l9, i14, i17);
        }

        if(field_76808_K)
        {
            for(int i5 = 0; i5 < 50; i5++)
            {
                int i10 = field_76814_c + field_76813_b.nextInt(16) + 8;
                int j14 = field_76813_b.nextInt(field_76813_b.nextInt(120) + 8);
                int j17 = field_76811_d + field_76813_b.nextInt(16) + 8;
                (new WorldGenLiquids(Block.field_71942_A.field_71990_ca)).func_76484_a(field_76815_a, field_76813_b, i10, j14, j17);
            }

            for(int j5 = 0; j5 < 20; j5++)
            {
                int j10 = field_76814_c + field_76813_b.nextInt(16) + 8;
                int k14 = field_76813_b.nextInt(field_76813_b.nextInt(field_76813_b.nextInt(112) + 8) + 8);
                int k17 = field_76811_d + field_76813_b.nextInt(16) + 8;
                (new WorldGenLiquids(Block.field_71944_C.field_71990_ca)).func_76484_a(field_76815_a, field_76813_b, j10, k14, k17);
            }

        }
    }

    protected void func_76795_a(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_)
    {
        for(int i = 0; i < p_76795_1_; i++)
        {
            int j = field_76814_c + field_76813_b.nextInt(16);
            int k = field_76813_b.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
            int l = field_76811_d + field_76813_b.nextInt(16);
            p_76795_2_.func_76484_a(field_76815_a, field_76813_b, j, k, l);
        }

    }

    protected void func_76793_b(int p_76793_1_, WorldGenerator p_76793_2_, int p_76793_3_, int p_76793_4_)
    {
        for(int i = 0; i < p_76793_1_; i++)
        {
            int j = field_76814_c + field_76813_b.nextInt(16);
            int k = field_76813_b.nextInt(p_76793_4_) + field_76813_b.nextInt(p_76793_4_) + (p_76793_3_ - p_76793_4_);
            int l = field_76811_d + field_76813_b.nextInt(16);
            p_76793_2_.func_76484_a(field_76815_a, field_76813_b, j, k, l);
        }

    }

    protected void func_76797_b()
    {
        func_76795_a(20, field_76823_i, 0, 128);
        func_76795_a(10, field_76820_j, 0, 128);
        func_76795_a(20, field_76821_k, 0, 128);
        func_76795_a(20, field_76818_l, 0, 64);
        func_76795_a(2, field_76819_m, 0, 32);
        func_76795_a(8, field_76816_n, 0, 16);
        func_76795_a(1, field_76817_o, 0, 16);
        func_76793_b(1, field_76831_p, 16, 16);
    }
}
