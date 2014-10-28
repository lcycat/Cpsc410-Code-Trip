// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentScatteredFeature, Block, BlockHalfSlab, Direction, 
//            WeightedRandomChestContent, Item, World, StructureBoundingBox

public class ComponentScatteredFeatureDesertPyramid extends ComponentScatteredFeature
{

    private boolean field_74940_h[];
    private static final WeightedRandomChestContent field_74941_i[];

    public ComponentScatteredFeatureDesertPyramid(Random p_i3833_1_, int p_i3833_2_, int p_i3833_3_)
    {
        super(p_i3833_1_, p_i3833_2_, 64, p_i3833_3_, 21, 15, 21);
        field_74940_h = new boolean[4];
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        func_74884_a(p_74875_1_, p_74875_3_, 0, -4, 0, field_74939_a - 1, 0, field_74938_c - 1, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        for(int i = 1; i <= 9; i++)
        {
            func_74884_a(p_74875_1_, p_74875_3_, i, i, i, field_74939_a - 1 - i, i, field_74938_c - 1 - i, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, i + 1, i, i + 1, field_74939_a - 2 - i, i, field_74938_c - 2 - i, 0, 0, false);
        }

        for(int j = 0; j < field_74939_a; j++)
        {
            for(int l = 0; l < field_74938_c; l++)
            {
                func_74870_b(p_74875_1_, Block.field_71957_Q.field_71990_ca, 0, j, -5, l, p_74875_3_);
            }

        }

        int k = func_74863_c(Block.field_72088_bQ.field_71990_ca, 3);
        int i1 = func_74863_c(Block.field_72088_bQ.field_71990_ca, 2);
        int j1 = func_74863_c(Block.field_72088_bQ.field_71990_ca, 0);
        int k1 = func_74863_c(Block.field_72088_bQ.field_71990_ca, 1);
        int l1 = 1;
        byte byte0 = 11;
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 9, 4, Block.field_71957_Q.field_71990_ca, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 10, 1, 3, 10, 3, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, 2, 10, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, i1, 2, 10, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, j1, 0, 10, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k1, 4, 10, 2, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, field_74939_a - 5, 0, 0, field_74939_a - 1, 9, 4, Block.field_71957_Q.field_71990_ca, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74939_a - 4, 10, 1, field_74939_a - 2, 10, 3, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, field_74939_a - 3, 10, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, i1, field_74939_a - 3, 10, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, j1, field_74939_a - 5, 10, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k1, field_74939_a - 1, 10, 2, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 0, 0, 12, 4, 4, Block.field_71957_Q.field_71990_ca, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 9, 1, 0, 11, 3, 4, 0, 0, false);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 9, 1, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 9, 2, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 9, 3, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 10, 3, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 11, 3, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 11, 2, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 11, 1, 1, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 8, 3, 3, Block.field_71957_Q.field_71990_ca, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 2, 8, 2, 2, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 12, 1, 1, 16, 3, 3, Block.field_71957_Q.field_71990_ca, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 12, 1, 2, 16, 2, 2, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 4, 5, field_74939_a - 6, 4, field_74938_c - 6, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 9, 4, 9, 11, 4, 11, 0, 0, false);
        func_74872_a(p_74875_1_, p_74875_3_, 8, 1, 8, 8, 3, 8, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74872_a(p_74875_1_, p_74875_3_, 12, 1, 8, 12, 3, 8, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74872_a(p_74875_1_, p_74875_3_, 8, 1, 12, 8, 3, 12, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74872_a(p_74875_1_, p_74875_3_, 12, 1, 12, 12, 3, 12, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 5, 4, 4, 11, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74939_a - 5, 1, 5, field_74939_a - 2, 4, 11, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 7, 9, 6, 7, 11, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74939_a - 7, 7, 9, field_74939_a - 7, 7, 11, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74872_a(p_74875_1_, p_74875_3_, 5, 5, 9, 5, 7, 11, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74872_a(p_74875_1_, p_74875_3_, field_74939_a - 6, 5, 9, field_74939_a - 6, 7, 11, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74864_a(p_74875_1_, 0, 0, 5, 5, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 5, 6, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 6, 6, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, field_74939_a - 6, 5, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, field_74939_a - 6, 6, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, field_74939_a - 7, 6, 10, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 4, 4, 2, 6, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74939_a - 3, 4, 4, field_74939_a - 3, 6, 4, 0, 0, false);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, 2, 4, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, 2, 3, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, field_74939_a - 3, 4, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, field_74939_a - 3, 3, 4, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 3, 2, 2, 3, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74939_a - 3, 1, 3, field_74939_a - 2, 2, 3, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, 0, 1, 1, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, 0, field_74939_a - 2, 1, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 1, 1, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 1, field_74939_a - 2, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k1, 2, 1, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, j1, field_74939_a - 3, 1, 2, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 3, 5, 4, 3, 18, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74939_a - 5, 3, 5, field_74939_a - 5, 3, 17, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 5, 4, 2, 16, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74939_a - 6, 1, 5, field_74939_a - 5, 2, 16, 0, 0, false);
        for(int i2 = 5; i2 <= 17; i2 += 2)
        {
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 4, 1, i2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 4, 2, i2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, field_74939_a - 5, 1, i2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, field_74939_a - 5, 2, i2, p_74875_3_);
        }

        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 10, 0, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 10, 0, 8, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 9, 0, 9, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 11, 0, 9, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 8, 0, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 12, 0, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 7, 0, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 13, 0, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 9, 0, 11, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 11, 0, 11, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 10, 0, 12, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 10, 0, 13, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, byte0, 10, 0, 10, p_74875_3_);
        for(int j2 = 0; j2 <= field_74939_a - 1; j2 += field_74939_a - 1)
        {
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 2, 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 2, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 2, 3, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 3, 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 3, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 3, 3, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 4, 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, j2, 4, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 4, 3, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 5, 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 5, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 5, 3, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 6, 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, j2, 6, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 6, 3, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 7, 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 7, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, j2, 7, 3, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 8, 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 8, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, j2, 8, 3, p_74875_3_);
        }

        for(int k2 = 2; k2 <= field_74939_a - 3; k2 += field_74939_a - 3 - 2)
        {
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2 - 1, 2, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2, 2, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2 + 1, 2, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2 - 1, 3, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2, 3, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2 + 1, 3, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2 - 1, 4, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, k2, 4, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2 + 1, 4, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2 - 1, 5, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2, 5, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2 + 1, 5, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2 - 1, 6, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, k2, 6, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2 + 1, 6, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2 - 1, 7, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2, 7, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, k2 + 1, 7, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2 - 1, 8, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2, 8, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, k2 + 1, 8, 0, p_74875_3_);
        }

        func_74872_a(p_74875_1_, p_74875_3_, 8, 4, 0, 12, 6, 0, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74864_a(p_74875_1_, 0, 0, 8, 6, 0, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 12, 6, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 9, 5, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 10, 5, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, l1, 11, 5, 0, p_74875_3_);
        func_74872_a(p_74875_1_, p_74875_3_, 8, -14, 8, 12, -11, 12, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74872_a(p_74875_1_, p_74875_3_, 8, -10, 8, 12, -10, 12, Block.field_71957_Q.field_71990_ca, 1, Block.field_71957_Q.field_71990_ca, 1, false);
        func_74872_a(p_74875_1_, p_74875_3_, 8, -9, 8, 12, -9, 12, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, -8, 8, 12, -1, 12, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 9, -11, 9, 11, -1, 11, 0, 0, false);
        func_74864_a(p_74875_1_, Block.field_72044_aK.field_71990_ca, 0, 10, -11, 10, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 9, -13, 9, 11, -13, 11, Block.field_72091_am.field_71990_ca, 0, false);
        func_74864_a(p_74875_1_, 0, 0, 8, -11, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 8, -10, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 7, -10, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 7, -11, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 12, -11, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 12, -10, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 13, -10, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 13, -11, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 10, -11, 8, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 10, -10, 8, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 10, -10, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 10, -11, 7, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 10, -11, 12, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 10, -10, 12, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 10, -10, 13, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 10, -11, 13, p_74875_3_);
        for(int l2 = 0; l2 < 4; l2++)
        {
            if(!field_74940_h[l2])
            {
                int i3 = Direction.field_71583_a[l2] * 2;
                int j3 = Direction.field_71581_b[l2] * 2;
                field_74940_h[l2] = func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 10 + i3, -11, 10 + j3, field_74941_i, 2 + p_74875_2_.nextInt(5));
            }
        }

        return true;
    }

    static 
    {
        field_74941_i = (new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.field_77702_n.field_77779_bT, 0, 1, 3, 3), new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 2, 7, 15), new WeightedRandomChestContent(Item.field_77817_bH.field_77779_bT, 0, 1, 3, 2), new WeightedRandomChestContent(Item.field_77755_aX.field_77779_bT, 0, 4, 6, 20), new WeightedRandomChestContent(Item.field_77737_bm.field_77779_bT, 0, 3, 7, 16)
        });
    }
}
