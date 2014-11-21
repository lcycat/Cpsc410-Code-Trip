// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            RecipesTools, RecipesWeapons, RecipesIngots, RecipesFood, 
//            RecipesCrafting, RecipesArmor, RecipesDyes, ItemStack, 
//            Item, Block, RecipeSorter, ShapedRecipes, 
//            ShapelessRecipes, InventoryCrafting, IRecipe

public class CraftingManager
{

    private static final CraftingManager field_77598_a = new CraftingManager();
    private List field_77597_b;

    public static final CraftingManager func_77594_a()
    {
        return field_77598_a;
    }

    private CraftingManager()
    {
        field_77597_b = new ArrayList();
        (new RecipesTools()).func_77586_a(this);
        (new RecipesWeapons()).func_77583_a(this);
        (new RecipesIngots()).func_77590_a(this);
        (new RecipesFood()).func_77608_a(this);
        (new RecipesCrafting()).func_77589_a(this);
        (new RecipesArmor()).func_77609_a(this);
        (new RecipesDyes()).func_77607_a(this);
        func_77595_a(new ItemStack(Item.field_77759_aK, 3), new Object[] {
            "###", Character.valueOf('#'), Item.field_77758_aJ
        });
        func_77596_b(new ItemStack(Item.field_77760_aL, 1), new Object[] {
            Item.field_77759_aK, Item.field_77759_aK, Item.field_77759_aK, Item.field_77770_aF
        });
        func_77596_b(new ItemStack(Item.field_77821_bF, 1), new Object[] {
            Item.field_77760_aL, new ItemStack(Item.field_77756_aW, 1, 0), Item.field_77676_L
        });
        func_77595_a(new ItemStack(Block.field_72031_aZ, 2), new Object[] {
            "###", "###", Character.valueOf('#'), Item.field_77669_D
        });
        func_77595_a(new ItemStack(Block.field_72098_bB, 6), new Object[] {
            "###", "###", Character.valueOf('#'), Block.field_72033_bA
        });
        func_77595_a(new ItemStack(Block.field_71993_bv, 1), new Object[] {
            "#W#", "#W#", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('W'), Block.field_71988_x
        });
        func_77595_a(new ItemStack(Block.field_72032_aY, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77702_n
        });
        func_77595_a(new ItemStack(Block.field_71960_R, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77767_aC
        });
        func_77595_a(new ItemStack(Block.field_72093_an, 1), new Object[] {
            "###", "XXX", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77760_aL
        });
        func_77595_a(new ItemStack(Block.field_72039_aU, 1), new Object[] {
            "##", "##", Character.valueOf('#'), Item.field_77768_aD
        });
        func_77595_a(new ItemStack(Block.field_72041_aW, 1), new Object[] {
            "##", "##", Character.valueOf('#'), Item.field_77757_aI
        });
        func_77595_a(new ItemStack(Block.field_72081_al, 1), new Object[] {
            "##", "##", Character.valueOf('#'), Item.field_77772_aH
        });
        func_77595_a(new ItemStack(Block.field_72014_bd, 1), new Object[] {
            "##", "##", Character.valueOf('#'), Item.field_77751_aT
        });
        func_77595_a(new ItemStack(Block.field_72101_ab, 1), new Object[] {
            "##", "##", Character.valueOf('#'), Item.field_77683_K
        });
        func_77595_a(new ItemStack(Block.field_72091_am, 1), new Object[] {
            "X#X", "#X#", "X#X", Character.valueOf('X'), Item.field_77677_M, Character.valueOf('#'), Block.field_71939_E
        });
        func_77595_a(new ItemStack(Block.field_72079_ak, 6, 3), new Object[] {
            "###", Character.valueOf('#'), Block.field_71978_w
        });
        func_77595_a(new ItemStack(Block.field_72079_ak, 6, 0), new Object[] {
            "###", Character.valueOf('#'), Block.field_71981_t
        });
        func_77595_a(new ItemStack(Block.field_72079_ak, 6, 1), new Object[] {
            "###", Character.valueOf('#'), Block.field_71957_Q
        });
        func_77595_a(new ItemStack(Block.field_72079_ak, 6, 4), new Object[] {
            "###", Character.valueOf('#'), Block.field_72081_al
        });
        func_77595_a(new ItemStack(Block.field_72079_ak, 6, 5), new Object[] {
            "###", Character.valueOf('#'), Block.field_72007_bm
        });
        func_77595_a(new ItemStack(Block.field_72092_bO, 6, 0), new Object[] {
            "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 0)
        });
        func_77595_a(new ItemStack(Block.field_72092_bO, 6, 2), new Object[] {
            "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 2)
        });
        func_77595_a(new ItemStack(Block.field_72092_bO, 6, 1), new Object[] {
            "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 1)
        });
        func_77595_a(new ItemStack(Block.field_72092_bO, 6, 3), new Object[] {
            "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 3)
        });
        func_77595_a(new ItemStack(Block.field_72055_aF, 3), new Object[] {
            "# #", "###", "# #", Character.valueOf('#'), Item.field_77669_D
        });
        func_77595_a(new ItemStack(Item.field_77790_av, 1), new Object[] {
            "##", "##", "##", Character.valueOf('#'), Block.field_71988_x
        });
        func_77595_a(new ItemStack(Block.field_72005_bk, 2), new Object[] {
            "###", "###", Character.valueOf('#'), Block.field_71988_x
        });
        func_77595_a(new ItemStack(Item.field_77766_aB, 1), new Object[] {
            "##", "##", "##", Character.valueOf('#'), Item.field_77703_o
        });
        func_77595_a(new ItemStack(Item.field_77792_au, 3), new Object[] {
            "###", "###", " X ", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77669_D
        });
        func_77595_a(new ItemStack(Item.field_77746_aZ, 1), new Object[] {
            "AAA", "BEB", "CCC", Character.valueOf('A'), Item.field_77771_aG, Character.valueOf('B'), Item.field_77747_aY, Character.valueOf('C'), Item.field_77685_T, Character.valueOf('E'), 
            Item.field_77764_aP
        });
        func_77595_a(new ItemStack(Item.field_77747_aY, 1), new Object[] {
            "#", Character.valueOf('#'), Item.field_77758_aJ
        });
        func_77595_a(new ItemStack(Block.field_71988_x, 4, 0), new Object[] {
            "#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 0)
        });
        func_77595_a(new ItemStack(Block.field_71988_x, 4, 1), new Object[] {
            "#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 1)
        });
        func_77595_a(new ItemStack(Block.field_71988_x, 4, 2), new Object[] {
            "#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 2)
        });
        func_77595_a(new ItemStack(Block.field_71988_x, 4, 3), new Object[] {
            "#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 3)
        });
        func_77595_a(new ItemStack(Item.field_77669_D, 4), new Object[] {
            "#", "#", Character.valueOf('#'), Block.field_71988_x
        });
        func_77595_a(new ItemStack(Block.field_72069_aq, 4), new Object[] {
            "X", "#", Character.valueOf('X'), Item.field_77705_m, Character.valueOf('#'), Item.field_77669_D
        });
        func_77595_a(new ItemStack(Block.field_72069_aq, 4), new Object[] {
            "X", "#", Character.valueOf('X'), new ItemStack(Item.field_77705_m, 1, 1), Character.valueOf('#'), Item.field_77669_D
        });
        func_77595_a(new ItemStack(Item.field_77670_E, 4), new Object[] {
            "# #", " # ", Character.valueOf('#'), Block.field_71988_x
        });
        func_77595_a(new ItemStack(Item.field_77729_bt, 3), new Object[] {
            "# #", " # ", Character.valueOf('#'), Block.field_71946_M
        });
        func_77595_a(new ItemStack(Block.field_72056_aG, 16), new Object[] {
            "X X", "X#X", "X X", Character.valueOf('X'), Item.field_77703_o, Character.valueOf('#'), Item.field_77669_D
        });
        func_77595_a(new ItemStack(Block.field_71954_T, 6), new Object[] {
            "X X", "X#X", "XRX", Character.valueOf('X'), Item.field_77717_p, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('#'), Item.field_77669_D
        });
        func_77595_a(new ItemStack(Block.field_71953_U, 6), new Object[] {
            "X X", "X#X", "XRX", Character.valueOf('X'), Item.field_77703_o, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('#'), Block.field_72044_aK
        });
        func_77595_a(new ItemStack(Item.field_77773_az, 1), new Object[] {
            "# #", "###", Character.valueOf('#'), Item.field_77703_o
        });
        func_77595_a(new ItemStack(Item.field_77721_bz, 1), new Object[] {
            "# #", "# #", "###", Character.valueOf('#'), Item.field_77703_o
        });
        func_77595_a(new ItemStack(Item.field_77724_by, 1), new Object[] {
            " B ", "###", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('B'), Item.field_77731_bo
        });
        func_77595_a(new ItemStack(Block.field_72008_bf, 1), new Object[] {
            "A", "B", Character.valueOf('A'), Block.field_72061_ba, Character.valueOf('B'), Block.field_72069_aq
        });
        func_77595_a(new ItemStack(Item.field_77762_aN, 1), new Object[] {
            "A", "B", Character.valueOf('A'), Block.field_72077_au, Character.valueOf('B'), Item.field_77773_az
        });
        func_77595_a(new ItemStack(Item.field_77763_aO, 1), new Object[] {
            "A", "B", Character.valueOf('A'), Block.field_72051_aB, Character.valueOf('B'), Item.field_77773_az
        });
        func_77595_a(new ItemStack(Item.field_77769_aE, 1), new Object[] {
            "# #", "###", Character.valueOf('#'), Block.field_71988_x
        });
        func_77595_a(new ItemStack(Item.field_77788_aw, 1), new Object[] {
            "# #", " # ", Character.valueOf('#'), Item.field_77703_o
        });
        func_77595_a(new ItemStack(Item.field_77709_i, 1), new Object[] {
            "A ", " B", Character.valueOf('A'), Item.field_77703_o, Character.valueOf('B'), Item.field_77804_ap
        });
        func_77595_a(new ItemStack(Item.field_77684_U, 1), new Object[] {
            "###", Character.valueOf('#'), Item.field_77685_T
        });
        func_77595_a(new ItemStack(Block.field_72063_at, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 0)
        });
        func_77595_a(new ItemStack(Block.field_72072_bX, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 2)
        });
        func_77595_a(new ItemStack(Block.field_72074_bW, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 1)
        });
        func_77595_a(new ItemStack(Block.field_72070_bY, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 3)
        });
        func_77595_a(new ItemStack(Item.field_77749_aR, 1), new Object[] {
            "  #", " #X", "# X", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Item.field_77683_K
        });
        func_77595_a(new ItemStack(Block.field_72057_aH, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), Block.field_71978_w
        });
        func_77595_a(new ItemStack(Block.field_71992_bw, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), Block.field_72081_al
        });
        func_77595_a(new ItemStack(Block.field_71995_bx, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), Block.field_72007_bm
        });
        func_77595_a(new ItemStack(Block.field_72100_bC, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), Block.field_72033_bA
        });
        func_77595_a(new ItemStack(Block.field_72088_bQ, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), Block.field_71957_Q
        });
        func_77595_a(new ItemStack(Item.field_77780_as, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Block.field_72101_ab
        });
        func_77595_a(new ItemStack(Item.field_77778_at, 1, 0), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Item.field_77733_bq, Character.valueOf('X'), Item.field_77706_j
        });
        func_77595_a(new ItemStack(Item.field_77778_at, 1, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Block.field_72105_ah, Character.valueOf('X'), Item.field_77706_j
        });
        func_77595_a(new ItemStack(Block.field_72043_aJ, 1), new Object[] {
            "X", "#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77669_D
        });
        func_77595_a(new ItemStack(Block.field_72064_bT, 2), new Object[] {
            "I", "S", "#", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('S'), Item.field_77669_D, Character.valueOf('I'), Item.field_77703_o
        });
        func_77595_a(new ItemStack(Block.field_72035_aQ, 1), new Object[] {
            "X", "#", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Item.field_77767_aC
        });
        func_77595_a(new ItemStack(Item.field_77742_bb, 1), new Object[] {
            "#X#", "III", Character.valueOf('#'), Block.field_72035_aQ, Character.valueOf('X'), Item.field_77767_aC, Character.valueOf('I'), Block.field_71981_t
        });
        func_77595_a(new ItemStack(Item.field_77752_aS, 1), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), Item.field_77717_p, Character.valueOf('X'), Item.field_77767_aC
        });
        func_77595_a(new ItemStack(Item.field_77750_aQ, 1), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), Item.field_77703_o, Character.valueOf('X'), Item.field_77767_aC
        });
        func_77595_a(new ItemStack(Item.field_77744_bd, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Item.field_77759_aK, Character.valueOf('X'), Item.field_77750_aQ
        });
        func_77595_a(new ItemStack(Block.field_72034_aR, 1), new Object[] {
            "#", "#", Character.valueOf('#'), Block.field_71981_t
        });
        func_77595_a(new ItemStack(Block.field_72044_aK, 1), new Object[] {
            "##", Character.valueOf('#'), Block.field_71981_t
        });
        func_77595_a(new ItemStack(Block.field_72046_aM, 1), new Object[] {
            "##", Character.valueOf('#'), Block.field_71988_x
        });
        func_77595_a(new ItemStack(Block.field_71958_P, 1), new Object[] {
            "###", "#X#", "#R#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77707_k, Character.valueOf('R'), Item.field_77767_aC
        });
        func_77595_a(new ItemStack(Block.field_71963_Z, 1), new Object[] {
            "TTT", "#X#", "#R#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77703_o, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('T'), 
            Block.field_71988_x
        });
        func_77595_a(new ItemStack(Block.field_71956_V, 1), new Object[] {
            "S", "P", Character.valueOf('S'), Item.field_77761_aM, Character.valueOf('P'), Block.field_71963_Z
        });
        func_77595_a(new ItemStack(Item.field_77776_ba, 1), new Object[] {
            "###", "XXX", Character.valueOf('#'), Block.field_72101_ab, Character.valueOf('X'), Block.field_71988_x
        });
        func_77595_a(new ItemStack(Block.field_72096_bE, 1), new Object[] {
            " B ", "D#D", "###", Character.valueOf('#'), Block.field_72089_ap, Character.valueOf('B'), Item.field_77760_aL, Character.valueOf('D'), Item.field_77702_n
        });
        func_77596_b(new ItemStack(Item.field_77748_bA, 1), new Object[] {
            Item.field_77730_bn, Item.field_77722_bw
        });
        func_77596_b(new ItemStack(Item.field_77811_bE, 3), new Object[] {
            Item.field_77677_M, Item.field_77722_bw, Item.field_77705_m
        });
        func_77596_b(new ItemStack(Item.field_77811_bE, 3), new Object[] {
            Item.field_77677_M, Item.field_77722_bw, new ItemStack(Item.field_77705_m, 1, 1)
        });
        Collections.sort(field_77597_b, new RecipeSorter(this));
        System.out.println((new StringBuilder()).append(field_77597_b.size()).append(" recipes").toString());
    }

    void func_77595_a(ItemStack p_77595_1_, Object p_77595_2_[])
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;
        if(p_77595_2_[i] instanceof String[])
        {
            String as[] = (String[])p_77595_2_[i++];
            String as1[] = as;
            int l = as1.length;
            for(int j1 = 0; j1 < l; j1++)
            {
                String s2 = as1[j1];
                String s3 = s2;
                k++;
                j = s3.length();
                s = (new StringBuilder()).append(s).append(s3).toString();
            }

        } else
        {
            while(p_77595_2_[i] instanceof String) 
            {
                String s1 = (String)p_77595_2_[i++];
                k++;
                j = s1.length();
                s = (new StringBuilder()).append(s).append(s1).toString();
            }
        }
        HashMap hashmap = new HashMap();
        for(; i < p_77595_2_.length; i += 2)
        {
            Character character = (Character)p_77595_2_[i];
            ItemStack itemstack = null;
            if(p_77595_2_[i + 1] instanceof Item)
            {
                itemstack = new ItemStack((Item)p_77595_2_[i + 1]);
            } else
            if(p_77595_2_[i + 1] instanceof Block)
            {
                itemstack = new ItemStack((Block)p_77595_2_[i + 1], 1, -1);
            } else
            if(p_77595_2_[i + 1] instanceof ItemStack)
            {
                itemstack = (ItemStack)p_77595_2_[i + 1];
            }
            hashmap.put(character, itemstack);
        }

        ItemStack aitemstack[] = new ItemStack[j * k];
        for(int i1 = 0; i1 < j * k; i1++)
        {
            char c = s.charAt(i1);
            if(hashmap.containsKey(Character.valueOf(c)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c))).func_77946_l();
            } else
            {
                aitemstack[i1] = null;
            }
        }

        field_77597_b.add(new ShapedRecipes(j, k, aitemstack, p_77595_1_));
    }

    void func_77596_b(ItemStack p_77596_1_, Object p_77596_2_[])
    {
        ArrayList arraylist = new ArrayList();
        Object aobj[] = p_77596_2_;
        int i = aobj.length;
        for(int j = 0; j < i; j++)
        {
            Object obj = aobj[j];
            if(obj instanceof ItemStack)
            {
                arraylist.add(((ItemStack)obj).func_77946_l());
                continue;
            }
            if(obj instanceof Item)
            {
                arraylist.add(new ItemStack((Item)obj));
                continue;
            }
            if(obj instanceof Block)
            {
                arraylist.add(new ItemStack((Block)obj));
            } else
            {
                throw new RuntimeException("Invalid shapeless recipy!");
            }
        }

        field_77597_b.add(new ShapelessRecipes(p_77596_1_, arraylist));
    }

    public ItemStack func_77593_a(InventoryCrafting p_77593_1_)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        for(int j = 0; j < p_77593_1_.func_70302_i_(); j++)
        {
            ItemStack itemstack2 = p_77593_1_.func_70301_a(j);
            if(itemstack2 == null)
            {
                continue;
            }
            if(i == 0)
            {
                itemstack = itemstack2;
            }
            if(i == 1)
            {
                itemstack1 = itemstack2;
            }
            i++;
        }

        if(i == 2 && itemstack.field_77993_c == itemstack1.field_77993_c && itemstack.field_77994_a == 1 && itemstack1.field_77994_a == 1 && Item.field_77698_e[itemstack.field_77993_c].func_77645_m())
        {
            Item item = Item.field_77698_e[itemstack.field_77993_c];
            int k = item.func_77612_l() - itemstack.func_77952_i();
            int l = item.func_77612_l() - itemstack1.func_77952_i();
            int i1 = k + l + (item.func_77612_l() * 10) / 100;
            int j1 = item.func_77612_l() - i1;
            if(j1 < 0)
            {
                j1 = 0;
            }
            return new ItemStack(itemstack.field_77993_c, 1, j1);
        }
        for(Iterator iterator = field_77597_b.iterator(); iterator.hasNext();)
        {
            IRecipe irecipe = (IRecipe)iterator.next();
            if(irecipe.func_77569_a(p_77593_1_))
            {
                return irecipe.func_77572_b(p_77593_1_);
            }
        }

        return null;
    }

    public List func_77592_b()
    {
        return field_77597_b;
    }

}
