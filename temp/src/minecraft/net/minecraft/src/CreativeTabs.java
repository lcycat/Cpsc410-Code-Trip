// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            StringTranslate, Item, CreativeTabBlock, CreativeTabDeco, 
//            CreativeTabRedstone, CreativeTabTransport, CreativeTabMisc, CreativeTabSearch, 
//            CreativeTabFood, CreativeTabTools, CreativeTabCombat, CreativeTabBrewing, 
//            CreativeTabMaterial, CreativeTabInventory

public class CreativeTabs
{

    public static final CreativeTabs field_78032_a[] = new CreativeTabs[12];
    public static final CreativeTabs field_78030_b = new CreativeTabBlock(0, "buildingBlocks");
    public static final CreativeTabs field_78031_c = new CreativeTabDeco(1, "decorations");
    public static final CreativeTabs field_78028_d = new CreativeTabRedstone(2, "redstone");
    public static final CreativeTabs field_78029_e = new CreativeTabTransport(3, "transportation");
    public static final CreativeTabs field_78026_f = new CreativeTabMisc(4, "misc");
    public static final CreativeTabs field_78027_g = (new CreativeTabSearch(5, "search")).func_78025_a("search.png");
    public static final CreativeTabs field_78039_h = new CreativeTabFood(6, "food");
    public static final CreativeTabs field_78040_i = new CreativeTabTools(7, "tools");
    public static final CreativeTabs field_78037_j = new CreativeTabCombat(8, "combat");
    public static final CreativeTabs field_78038_k = new CreativeTabBrewing(9, "brewing");
    public static final CreativeTabs field_78035_l = new CreativeTabMaterial(10, "materials");
    public static final CreativeTabs field_78036_m = (new CreativeTabInventory(11, "inventory")).func_78025_a("survival_inv.png").func_78022_j().func_78014_h();
    private final int field_78033_n;
    private final String field_78034_o;
    private String field_78043_p;
    private boolean field_78042_q;
    private boolean field_78041_r;

    public CreativeTabs(int p_i3642_1_, String p_i3642_2_)
    {
        field_78043_p = "list_items.png";
        field_78042_q = true;
        field_78041_r = true;
        field_78033_n = p_i3642_1_;
        field_78034_o = p_i3642_2_;
        field_78032_a[p_i3642_1_] = this;
    }

    public int func_78021_a()
    {
        return field_78033_n;
    }

    public String func_78013_b()
    {
        return field_78034_o;
    }

    public String func_78024_c()
    {
        return StringTranslate.func_74808_a().func_74805_b((new StringBuilder()).append("itemGroup.").append(func_78013_b()).toString());
    }

    public Item func_78016_d()
    {
        return Item.field_77698_e[func_78012_e()];
    }

    public int func_78012_e()
    {
        return 1;
    }

    public String func_78015_f()
    {
        return field_78043_p;
    }

    public CreativeTabs func_78025_a(String p_78025_1_)
    {
        field_78043_p = p_78025_1_;
        return this;
    }

    public boolean func_78019_g()
    {
        return field_78041_r;
    }

    public CreativeTabs func_78014_h()
    {
        field_78041_r = false;
        return this;
    }

    public boolean func_78017_i()
    {
        return field_78042_q;
    }

    public CreativeTabs func_78022_j()
    {
        field_78042_q = false;
        return this;
    }

    public int func_78020_k()
    {
        return field_78033_n % 6;
    }

    public boolean func_78023_l()
    {
        return field_78033_n < 6;
    }

    public void func_78018_a(List p_78018_1_)
    {
        Item aitem[] = Item.field_77698_e;
        int i = aitem.length;
        for(int j = 0; j < i; j++)
        {
            Item item = aitem[j];
            if(item != null && item.func_77640_w() == this)
            {
                item.func_77633_a(item.field_77779_bT, this, p_78018_1_);
            }
        }

    }

}
