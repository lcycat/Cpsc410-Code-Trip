// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, Block, ItemStack, CraftingManager

public class RecipesArmor
{

    private String field_77611_a[][] = {
        {
            "XXX", "X X"
        }, {
            "X X", "XXX", "XXX"
        }, {
            "XXX", "X X", "X X"
        }, {
            "X X", "X X"
        }
    };
    private Object field_77610_b[][];

    public RecipesArmor()
    {
        field_77610_b = (new Object[][] {
            new Object[] {
                Item.field_77770_aF, Block.field_72067_ar, Item.field_77703_o, Item.field_77702_n, Item.field_77717_p
            }, new Object[] {
                Item.field_77687_V, Item.field_77694_Z, Item.field_77812_ad, Item.field_77820_ah, Item.field_77796_al
            }, new Object[] {
                Item.field_77686_W, Item.field_77814_aa, Item.field_77822_ae, Item.field_77798_ai, Item.field_77806_am
            }, new Object[] {
                Item.field_77693_X, Item.field_77816_ab, Item.field_77824_af, Item.field_77800_aj, Item.field_77808_an
            }, new Object[] {
                Item.field_77692_Y, Item.field_77810_ac, Item.field_77818_ag, Item.field_77794_ak, Item.field_77802_ao
            }
        });
    }

    public void func_77609_a(CraftingManager p_77609_1_)
    {
        for(int i = 0; i < field_77610_b[0].length; i++)
        {
            Object obj = field_77610_b[0][i];
            for(int j = 0; j < field_77610_b.length - 1; j++)
            {
                Item item = (Item)field_77610_b[j + 1][i];
                p_77609_1_.func_77595_a(new ItemStack(item), new Object[] {
                    field_77611_a[j], Character.valueOf('X'), obj
                });
            }

        }

    }
}
