// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, CreativeTabs, ItemStack, 
//            Block, EntityLiving, World, Entity

public class ItemTool extends Item
{

    private Block field_77863_c[];
    protected float field_77864_a;
    private int field_77865_bY;
    protected EnumToolMaterial field_77862_b;

    protected ItemTool(int p_i3643_1_, int p_i3643_2_, EnumToolMaterial p_i3643_3_, Block p_i3643_4_[])
    {
        super(p_i3643_1_);
        field_77864_a = 4F;
        field_77862_b = p_i3643_3_;
        field_77863_c = p_i3643_4_;
        field_77777_bU = 1;
        func_77656_e(p_i3643_3_.func_77997_a());
        field_77864_a = p_i3643_3_.func_77998_b();
        field_77865_bY = p_i3643_2_ + p_i3643_3_.func_78000_c();
        func_77637_a(CreativeTabs.field_78040_i);
    }

    public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_)
    {
        Block ablock[] = field_77863_c;
        int i = ablock.length;
        for(int j = 0; j < i; j++)
        {
            Block block = ablock[j];
            if(block == p_77638_2_)
            {
                return field_77864_a;
            }
        }

        return 1.0F;
    }

    public boolean func_77644_a(ItemStack p_77644_1_, EntityLiving p_77644_2_, EntityLiving p_77644_3_)
    {
        p_77644_1_.func_77972_a(2, p_77644_3_);
        return true;
    }

    public boolean func_77660_a(ItemStack p_77660_1_, World p_77660_2_, int p_77660_3_, int p_77660_4_, int p_77660_5_, int p_77660_6_, EntityLiving p_77660_7_)
    {
        if((double)Block.field_71973_m[p_77660_3_].func_71934_m(p_77660_2_, p_77660_4_, p_77660_5_, p_77660_6_) != 0.0D)
        {
            p_77660_1_.func_77972_a(1, p_77660_7_);
        }
        return true;
    }

    public int func_77649_a(Entity p_77649_1_)
    {
        return field_77865_bY;
    }

    public boolean func_77662_d()
    {
        return true;
    }

    public int func_77619_b()
    {
        return field_77862_b.func_77995_e();
    }

    public String func_77861_e()
    {
        return field_77862_b.toString();
    }
}
