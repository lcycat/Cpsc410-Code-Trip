// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, StructureMineshaftPieces, Block, 
//            World, TileEntityMobSpawner

public class ComponentMineshaftCorridor extends StructureComponent
{

    private final boolean field_74958_a;
    private final boolean field_74956_b;
    private boolean field_74957_c;
    private int field_74955_d;

    public ComponentMineshaftCorridor(int p_i3807_1_, Random p_i3807_2_, StructureBoundingBox p_i3807_3_, int p_i3807_4_)
    {
        super(p_i3807_1_);
        field_74885_f = p_i3807_4_;
        field_74887_e = p_i3807_3_;
        field_74958_a = p_i3807_2_.nextInt(3) == 0;
        field_74956_b = !field_74958_a && p_i3807_2_.nextInt(23) == 0;
        if(field_74885_f == 2 || field_74885_f == 0)
        {
            field_74955_d = p_i3807_3_.func_78880_d() / 5;
        } else
        {
            field_74955_d = p_i3807_3_.func_78883_b() / 5;
        }
    }

    public static StructureBoundingBox func_74954_a(List p_74954_0_, Random p_74954_1_, int p_74954_2_, int p_74954_3_, int p_74954_4_, int p_74954_5_)
    {
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(p_74954_2_, p_74954_3_, p_74954_4_, p_74954_2_, p_74954_3_ + 2, p_74954_4_);
        int i = p_74954_1_.nextInt(3) + 2;
        do
        {
            if(i <= 0)
            {
                break;
            }
            int j = i * 5;
            switch(p_74954_5_)
            {
            case 2: // '\002'
                structureboundingbox.field_78893_d = p_74954_2_ + 2;
                structureboundingbox.field_78896_c = p_74954_4_ - (j - 1);
                break;

            case 0: // '\0'
                structureboundingbox.field_78893_d = p_74954_2_ + 2;
                structureboundingbox.field_78892_f = p_74954_4_ + (j - 1);
                break;

            case 1: // '\001'
                structureboundingbox.field_78897_a = p_74954_2_ - (j - 1);
                structureboundingbox.field_78892_f = p_74954_4_ + 2;
                break;

            case 3: // '\003'
                structureboundingbox.field_78893_d = p_74954_2_ + (j - 1);
                structureboundingbox.field_78892_f = p_74954_4_ + 2;
                break;
            }
            if(StructureComponent.func_74883_a(p_74954_0_, structureboundingbox) == null)
            {
                break;
            }
            i--;
        } while(true);
        if(i > 0)
        {
            return structureboundingbox;
        } else
        {
            return null;
        }
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        int i = func_74877_c();
        int j = p_74861_3_.nextInt(4);
        switch(field_74885_f)
        {
        case 2: // '\002'
            if(j <= 1)
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78896_c - 1, field_74885_f, i);
            } else
            if(j == 2)
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78896_c, 1, i);
            } else
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78896_c, 3, i);
            }
            break;

        case 0: // '\0'
            if(j <= 1)
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78892_f + 1, field_74885_f, i);
            } else
            if(j == 2)
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78892_f - 3, 1, i);
            } else
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78892_f - 3, 3, i);
            }
            break;

        case 1: // '\001'
            if(j <= 1)
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78896_c, field_74885_f, i);
            } else
            if(j == 2)
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78896_c - 1, 2, i);
            } else
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78892_f + 1, 0, i);
            }
            break;

        case 3: // '\003'
            if(j <= 1)
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78896_c, field_74885_f, i);
            } else
            if(j == 2)
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d - 3, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78896_c - 1, 2, i);
            } else
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d - 3, (field_74887_e.field_78895_b - 1) + p_74861_3_.nextInt(3), field_74887_e.field_78892_f + 1, 0, i);
            }
            break;
        }
        if(i < 8)
        {
            if(field_74885_f == 2 || field_74885_f == 0)
            {
                for(int k = field_74887_e.field_78896_c + 3; k + 3 <= field_74887_e.field_78892_f; k += 5)
                {
                    int i1 = p_74861_3_.nextInt(5);
                    if(i1 == 0)
                    {
                        StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b, k, 1, i + 1);
                    } else
                    if(i1 == 1)
                    {
                        StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b, k, 3, i + 1);
                    }
                }

            } else
            {
                for(int l = field_74887_e.field_78897_a + 3; l + 3 <= field_74887_e.field_78893_d; l += 5)
                {
                    int j1 = p_74861_3_.nextInt(5);
                    if(j1 == 0)
                    {
                        StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, l, field_74887_e.field_78895_b, field_74887_e.field_78896_c - 1, 2, i + 1);
                        continue;
                    }
                    if(j1 == 1)
                    {
                        StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, l, field_74887_e.field_78895_b, field_74887_e.field_78892_f + 1, 0, i + 1);
                    }
                }

            }
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        int i = field_74955_d * 5 - 1;
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 1, i, 0, 0, false);
        func_74880_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.8F, 0, 2, 0, 2, 2, i, 0, 0, false);
        if(field_74956_b)
        {
            func_74880_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.6F, 0, 0, 0, 2, 1, i, Block.field_71955_W.field_71990_ca, 0, false);
        }
        for(int j = 0; j < field_74955_d; j++)
        {
            int i1 = 2 + j * 5;
            func_74884_a(p_74875_1_, p_74875_3_, 0, 0, i1, 0, 1, i1, Block.field_72031_aZ.field_71990_ca, 0, false);
            func_74884_a(p_74875_1_, p_74875_3_, 2, 0, i1, 2, 1, i1, Block.field_72031_aZ.field_71990_ca, 0, false);
            if(p_74875_2_.nextInt(4) == 0)
            {
                func_74884_a(p_74875_1_, p_74875_3_, 0, 2, i1, 0, 2, i1, Block.field_71988_x.field_71990_ca, 0, false);
                func_74884_a(p_74875_1_, p_74875_3_, 2, 2, i1, 2, 2, i1, Block.field_71988_x.field_71990_ca, 0, false);
            } else
            {
                func_74884_a(p_74875_1_, p_74875_3_, 0, 2, i1, 2, 2, i1, Block.field_71988_x.field_71990_ca, 0, false);
            }
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, i1 - 1, Block.field_71955_W.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, i1 - 1, Block.field_71955_W.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, i1 + 1, Block.field_71955_W.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, i1 + 1, Block.field_71955_W.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, i1 - 2, Block.field_71955_W.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, i1 - 2, Block.field_71955_W.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, i1 + 2, Block.field_71955_W.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, i1 + 2, Block.field_71955_W.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, i1 - 1, Block.field_72069_aq.field_71990_ca, 0);
            func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, i1 + 1, Block.field_72069_aq.field_71990_ca, 0);
            if(p_74875_2_.nextInt(100) == 0)
            {
                func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 0, i1 - 1, StructureMineshaftPieces.func_78816_a(), 3 + p_74875_2_.nextInt(4));
            }
            if(p_74875_2_.nextInt(100) == 0)
            {
                func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 0, 0, i1 + 1, StructureMineshaftPieces.func_78816_a(), 3 + p_74875_2_.nextInt(4));
            }
            if(!field_74956_b || field_74957_c)
            {
                continue;
            }
            int l1 = func_74862_a(0);
            int j2 = (i1 - 1) + p_74875_2_.nextInt(3);
            int k2 = func_74865_a(1, j2);
            j2 = func_74873_b(1, j2);
            if(!p_74875_3_.func_78890_b(k2, l1, j2))
            {
                continue;
            }
            field_74957_c = true;
            p_74875_1_.func_72859_e(k2, l1, j2, Block.field_72065_as.field_71990_ca);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.func_72796_p(k2, l1, j2);
            if(tileentitymobspawner != null)
            {
                tileentitymobspawner.func_70385_a("CaveSpider");
            }
        }

        for(int k = 0; k <= 2; k++)
        {
            for(int j1 = 0; j1 <= i; j1++)
            {
                int i2 = func_74866_a(p_74875_1_, k, -1, j1, p_74875_3_);
                if(i2 == 0)
                {
                    func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, k, -1, j1, p_74875_3_);
                }
            }

        }

        if(field_74958_a)
        {
            for(int l = 0; l <= i; l++)
            {
                int k1 = func_74866_a(p_74875_1_, 1, -1, l, p_74875_3_);
                if(k1 > 0 && Block.field_71970_n[k1])
                {
                    func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.7F, 1, 0, l, Block.field_72056_aG.field_71990_ca, func_74863_c(Block.field_72056_aG.field_71990_ca, 0));
                }
            }

        }
        return true;
    }
}
