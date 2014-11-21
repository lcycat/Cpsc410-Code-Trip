// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Achievement, Item, Block

public class AchievementList
{

    public static int field_76010_a;
    public static int field_76008_b;
    public static int field_76009_c;
    public static int field_76006_d;
    public static List field_76007_e;
    public static Achievement field_76004_f;
    public static Achievement field_76005_g;
    public static Achievement field_76017_h;
    public static Achievement field_76018_i;
    public static Achievement field_76015_j;
    public static Achievement field_76016_k;
    public static Achievement field_76013_l;
    public static Achievement field_76014_m;
    public static Achievement field_76011_n;
    public static Achievement field_76012_o;
    public static Achievement field_76026_p;
    public static Achievement field_76025_q;
    public static Achievement field_76024_r;
    public static Achievement field_76023_s;
    public static Achievement field_76022_t;
    public static Achievement field_76021_u;
    public static Achievement field_76020_v;
    public static Achievement field_76019_w;
    public static Achievement field_76029_x;
    public static Achievement field_76028_y;
    public static Achievement field_76027_z;
    public static Achievement field_76001_A;
    public static Achievement field_76002_B;
    public static Achievement field_76003_C;
    public static Achievement field_75998_D;
    public static Achievement field_75999_E;
    public static Achievement field_76000_F;

    public static void func_75997_a()
    {
    }

    static 
    {
        field_76007_e = new ArrayList();
        field_76004_f = (new Achievement(0, "openInventory", 0, 0, Item.field_77760_aL, null)).func_75986_a().func_75985_c();
        field_76005_g = (new Achievement(1, "mineWood", 2, 1, Block.field_71951_J, field_76004_f)).func_75985_c();
        field_76017_h = (new Achievement(2, "buildWorkBench", 4, -1, Block.field_72060_ay, field_76005_g)).func_75985_c();
        field_76018_i = (new Achievement(3, "buildPickaxe", 4, 2, Item.field_77713_t, field_76017_h)).func_75985_c();
        field_76015_j = (new Achievement(4, "buildFurnace", 3, 4, Block.field_72052_aC, field_76018_i)).func_75985_c();
        field_76016_k = (new Achievement(5, "acquireIron", 1, 4, Item.field_77703_o, field_76015_j)).func_75985_c();
        field_76013_l = (new Achievement(6, "buildHoe", 2, -3, Item.field_77678_N, field_76017_h)).func_75985_c();
        field_76014_m = (new Achievement(7, "makeBread", -1, -3, Item.field_77684_U, field_76013_l)).func_75985_c();
        field_76011_n = (new Achievement(8, "bakeCake", 0, -5, Item.field_77746_aZ, field_76013_l)).func_75985_c();
        field_76012_o = (new Achievement(9, "buildBetterPickaxe", 6, 2, Item.field_77720_x, field_76018_i)).func_75985_c();
        field_76026_p = (new Achievement(10, "cookFish", 2, 6, Item.field_77753_aV, field_76015_j)).func_75985_c();
        field_76025_q = (new Achievement(11, "onARail", 2, 3, Block.field_72056_aG, field_76016_k)).func_75987_b().func_75985_c();
        field_76024_r = (new Achievement(12, "buildSword", 6, -1, Item.field_77715_r, field_76017_h)).func_75985_c();
        field_76023_s = (new Achievement(13, "killEnemy", 8, -1, Item.field_77755_aX, field_76024_r)).func_75985_c();
        field_76022_t = (new Achievement(14, "killCow", 7, -3, Item.field_77770_aF, field_76024_r)).func_75985_c();
        field_76021_u = (new Achievement(15, "flyPig", 8, -4, Item.field_77765_aA, field_76022_t)).func_75987_b().func_75985_c();
        field_76020_v = (new Achievement(16, "snipeSkeleton", 7, 0, Item.field_77707_k, field_76023_s)).func_75987_b().func_75985_c();
        field_76019_w = (new Achievement(17, "diamonds", -1, 5, Item.field_77702_n, field_76016_k)).func_75985_c();
        field_76029_x = (new Achievement(18, "portal", -1, 7, Block.field_72089_ap, field_76019_w)).func_75985_c();
        field_76028_y = (new Achievement(19, "ghast", -4, 8, Item.field_77732_bp, field_76029_x)).func_75987_b().func_75985_c();
        field_76027_z = (new Achievement(20, "blazeRod", 0, 9, Item.field_77731_bo, field_76029_x)).func_75985_c();
        field_76001_A = (new Achievement(21, "potion", 2, 8, Item.field_77726_bs, field_76027_z)).func_75985_c();
        field_76002_B = (new Achievement(22, "theEnd", 3, 10, Item.field_77748_bA, field_76027_z)).func_75987_b().func_75985_c();
        field_76003_C = (new Achievement(23, "theEnd2", 4, 13, Block.field_72084_bK, field_76002_B)).func_75987_b().func_75985_c();
        field_75998_D = (new Achievement(24, "enchantments", -4, 4, Block.field_72096_bE, field_76019_w)).func_75985_c();
        field_75999_E = (new Achievement(25, "overkill", -4, 1, Item.field_77718_z, field_75998_D)).func_75987_b().func_75985_c();
        field_76000_F = (new Achievement(26, "bookcase", -3, 6, Block.field_72093_an, field_75998_D)).func_75985_c();
        System.out.println((new StringBuilder()).append(field_76007_e.size()).append(" achievements").toString());
    }
}
