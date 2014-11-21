// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack, Block, BlockCloth, Item, 
//            CraftingManager

public class RecipesDyes
{

    public RecipesDyes()
    {
    }

    public void func_77607_a(CraftingManager p_77607_1_)
    {
        for(int i = 0; i < 16; i++)
        {
            p_77607_1_.func_77596_b(new ItemStack(Block.field_72101_ab, 1, BlockCloth.func_72239_d(i)), new Object[] {
                new ItemStack(Item.field_77756_aW, 1, i), new ItemStack(Item.field_77698_e[Block.field_72101_ab.field_71990_ca], 1, 0)
            });
        }

        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 11), new Object[] {
            Block.field_72097_ad
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 1), new Object[] {
            Block.field_72107_ae
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 3, 15), new Object[] {
            Item.field_77755_aX
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 9), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 1), new ItemStack(Item.field_77756_aW, 1, 15)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 14), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 1), new ItemStack(Item.field_77756_aW, 1, 11)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 10), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 2), new ItemStack(Item.field_77756_aW, 1, 15)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 8), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 0), new ItemStack(Item.field_77756_aW, 1, 15)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 7), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 8), new ItemStack(Item.field_77756_aW, 1, 15)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 3, 7), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 0), new ItemStack(Item.field_77756_aW, 1, 15), new ItemStack(Item.field_77756_aW, 1, 15)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 12), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 4), new ItemStack(Item.field_77756_aW, 1, 15)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 6), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 4), new ItemStack(Item.field_77756_aW, 1, 2)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 5), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 4), new ItemStack(Item.field_77756_aW, 1, 1)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 2, 13), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 5), new ItemStack(Item.field_77756_aW, 1, 9)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 3, 13), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 4), new ItemStack(Item.field_77756_aW, 1, 1), new ItemStack(Item.field_77756_aW, 1, 9)
        });
        p_77607_1_.func_77596_b(new ItemStack(Item.field_77756_aW, 4, 13), new Object[] {
            new ItemStack(Item.field_77756_aW, 1, 4), new ItemStack(Item.field_77756_aW, 1, 1), new ItemStack(Item.field_77756_aW, 1, 1), new ItemStack(Item.field_77756_aW, 1, 15)
        });
    }
}
