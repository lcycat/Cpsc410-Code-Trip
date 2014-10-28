// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, CreativeTabs, EntityPlayer, 
//            World, Block, BlockGrass, StepSound, 
//            ItemStack

public class ItemHoe extends Item
{

    protected EnumToolMaterial field_77843_a;

    public ItemHoe(int p_i3657_1_, EnumToolMaterial p_i3657_2_)
    {
        super(p_i3657_1_);
        field_77843_a = p_i3657_2_;
        field_77777_bU = 1;
        func_77656_e(p_i3657_2_.func_77997_a());
        func_77637_a(CreativeTabs.field_78040_i);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        }
        int i = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
        int j = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
        if(p_77648_7_ != 0 && j == 0 && i == Block.field_71980_u.field_71990_ca || i == Block.field_71979_v.field_71990_ca)
        {
            Block block = Block.field_72050_aA;
            p_77648_3_.func_72908_a((float)p_77648_4_ + 0.5F, (float)p_77648_5_ + 0.5F, (float)p_77648_6_ + 0.5F, block.field_72020_cn.func_72675_d(), (block.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, block.field_72020_cn.func_72678_c() * 0.8F);
            if(p_77648_3_.field_72995_K)
            {
                return true;
            } else
            {
                p_77648_3_.func_72859_e(p_77648_4_, p_77648_5_, p_77648_6_, block.field_71990_ca);
                p_77648_1_.func_77972_a(1, p_77648_2_);
                return true;
            }
        } else
        {
            return false;
        }
    }

    public String func_77842_f()
    {
        return field_77843_a.toString();
    }
}
