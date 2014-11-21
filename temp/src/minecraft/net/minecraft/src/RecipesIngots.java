// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, ItemStack, Item, CraftingManager

public class RecipesIngots
{

    private Object field_77591_a[][];

    public RecipesIngots()
    {
        field_77591_a = (new Object[][] {
            new Object[] {
                Block.field_72105_ah, new ItemStack(Item.field_77717_p, 9)
            }, new Object[] {
                Block.field_72083_ai, new ItemStack(Item.field_77703_o, 9)
            }, new Object[] {
                Block.field_72071_ax, new ItemStack(Item.field_77702_n, 9)
            }, new Object[] {
                Block.field_72076_bV, new ItemStack(Item.field_77817_bH, 9)
            }, new Object[] {
                Block.field_71948_O, new ItemStack(Item.field_77756_aW, 9, 4)
            }
        });
    }

    public void func_77590_a(CraftingManager p_77590_1_)
    {
        Object aobj[][] = field_77591_a;
        int i = aobj.length;
        for(int j = 0; j < i; j++)
        {
            Object aobj1[] = aobj[j];
            Block block = (Block)aobj1[0];
            ItemStack itemstack = (ItemStack)aobj1[1];
            p_77590_1_.func_77595_a(new ItemStack(block), new Object[] {
                "###", "###", "###", Character.valueOf('#'), itemstack
            });
            p_77590_1_.func_77595_a(itemstack, new Object[] {
                "#", Character.valueOf('#'), block
            });
        }

        p_77590_1_.func_77595_a(new ItemStack(Item.field_77717_p), new Object[] {
            "###", "###", "###", Character.valueOf('#'), Item.field_77733_bq
        });
        p_77590_1_.func_77595_a(new ItemStack(Item.field_77733_bq, 9), new Object[] {
            "#", Character.valueOf('#'), Item.field_77717_p
        });
    }
}
