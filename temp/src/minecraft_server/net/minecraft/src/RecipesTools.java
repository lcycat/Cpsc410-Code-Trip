// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Item, ItemStack, CraftingManager

public class RecipesTools
{

    private String field_77588_a[][] = {
        {
            "XXX", " # ", " # "
        }, {
            "X", "#", "#"
        }, {
            "XX", "X#", " #"
        }, {
            "XX", " #", " #"
        }
    };
    private Object field_77587_b[][];

    public RecipesTools()
    {
        field_77587_b = (new Object[][] {
            new Object[] {
                Block.field_71988_x, Block.field_71978_w, Item.field_77703_o, Item.field_77702_n, Item.field_77717_p
            }, new Object[] {
                Item.field_77713_t, Item.field_77720_x, Item.field_77696_g, Item.field_77674_B, Item.field_77681_I
            }, new Object[] {
                Item.field_77714_s, Item.field_77710_w, Item.field_77695_f, Item.field_77673_A, Item.field_77680_H
            }, new Object[] {
                Item.field_77712_u, Item.field_77719_y, Item.field_77708_h, Item.field_77675_C, Item.field_77682_J
            }, new Object[] {
                Item.field_77678_N, Item.field_77679_O, Item.field_77689_P, Item.field_77688_Q, Item.field_77691_R
            }
        });
    }

    public void func_77586_a(CraftingManager p_77586_1_)
    {
        for(int i = 0; i < field_77587_b[0].length; i++)
        {
            Object obj = field_77587_b[0][i];
            for(int j = 0; j < field_77587_b.length - 1; j++)
            {
                Item item = (Item)field_77587_b[j + 1][i];
                p_77586_1_.func_77595_a(new ItemStack(item), new Object[] {
                    field_77588_a[j], Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), obj
                });
            }

        }

        p_77586_1_.func_77595_a(new ItemStack(Item.field_77745_be), new Object[] {
            " #", "# ", Character.valueOf('#'), Item.field_77703_o
        });
    }
}
