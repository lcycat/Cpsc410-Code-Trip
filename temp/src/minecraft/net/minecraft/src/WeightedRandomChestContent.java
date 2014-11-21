// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WeightedRandomItem, WeightedRandom, Item, TileEntityChest, 
//            ItemStack, TileEntityDispenser

public class WeightedRandomChestContent extends WeightedRandomItem
{

    private int field_76297_b;
    private int field_76298_c;
    private int field_76295_d;
    private int field_76296_e;

    public WeightedRandomChestContent(int p_i3424_1_, int p_i3424_2_, int p_i3424_3_, int p_i3424_4_, int p_i3424_5_)
    {
        super(p_i3424_5_);
        field_76297_b = p_i3424_1_;
        field_76298_c = p_i3424_2_;
        field_76295_d = p_i3424_3_;
        field_76296_e = p_i3424_4_;
    }

    public static void func_76293_a(Random p_76293_0_, WeightedRandomChestContent p_76293_1_[], TileEntityChest p_76293_2_, int p_76293_3_)
    {
        for(int i = 0; i < p_76293_3_; i++)
        {
            WeightedRandomChestContent weightedrandomchestcontent = (WeightedRandomChestContent)WeightedRandom.func_76274_a(p_76293_0_, p_76293_1_);
            int j = weightedrandomchestcontent.field_76295_d + p_76293_0_.nextInt((weightedrandomchestcontent.field_76296_e - weightedrandomchestcontent.field_76295_d) + 1);
            if(Item.field_77698_e[weightedrandomchestcontent.field_76297_b].func_77639_j() >= j)
            {
                p_76293_2_.func_70299_a(p_76293_0_.nextInt(p_76293_2_.func_70302_i_()), new ItemStack(weightedrandomchestcontent.field_76297_b, j, weightedrandomchestcontent.field_76298_c));
                continue;
            }
            for(int k = 0; k < j; k++)
            {
                p_76293_2_.func_70299_a(p_76293_0_.nextInt(p_76293_2_.func_70302_i_()), new ItemStack(weightedrandomchestcontent.field_76297_b, 1, weightedrandomchestcontent.field_76298_c));
            }

        }

    }

    public static void func_76294_a(Random p_76294_0_, WeightedRandomChestContent p_76294_1_[], TileEntityDispenser p_76294_2_, int p_76294_3_)
    {
        for(int i = 0; i < p_76294_3_; i++)
        {
            WeightedRandomChestContent weightedrandomchestcontent = (WeightedRandomChestContent)WeightedRandom.func_76274_a(p_76294_0_, p_76294_1_);
            int j = weightedrandomchestcontent.field_76295_d + p_76294_0_.nextInt((weightedrandomchestcontent.field_76296_e - weightedrandomchestcontent.field_76295_d) + 1);
            if(Item.field_77698_e[weightedrandomchestcontent.field_76297_b].func_77639_j() >= j)
            {
                p_76294_2_.func_70299_a(p_76294_0_.nextInt(p_76294_2_.func_70302_i_()), new ItemStack(weightedrandomchestcontent.field_76297_b, j, weightedrandomchestcontent.field_76298_c));
                continue;
            }
            for(int k = 0; k < j; k++)
            {
                p_76294_2_.func_70299_a(p_76294_0_.nextInt(p_76294_2_.func_70302_i_()), new ItemStack(weightedrandomchestcontent.field_76297_b, 1, weightedrandomchestcontent.field_76298_c));
            }

        }

    }
}
