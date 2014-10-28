// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, ItemStack, BlockHalfSlab, EntityPlayer, 
//            World, StepSound

public class ItemSlab extends ItemBlock
{

    private final boolean field_77891_a;
    private final BlockHalfSlab field_77889_b;
    private final BlockHalfSlab field_77890_c;

    public ItemSlab(int p_i3689_1_, BlockHalfSlab p_i3689_2_, BlockHalfSlab p_i3689_3_, boolean p_i3689_4_)
    {
        super(p_i3689_1_);
        field_77889_b = p_i3689_2_;
        field_77890_c = p_i3689_3_;
        field_77891_a = p_i3689_4_;
        func_77656_e(0);
        func_77627_a(true);
    }

    public int func_77647_b(int p_77647_1_)
    {
        return p_77647_1_;
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        return field_77889_b.func_72240_d(p_77667_1_.func_77960_j());
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, 
            float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(field_77891_a)
        {
            return super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
        }
        if(p_77648_1_.field_77994_a == 0)
        {
            return false;
        }
        if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_))
        {
            return false;
        }
        int i = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
        int j = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
        int k = j & 7;
        boolean flag = (j & 8) != 0;
        if((p_77648_7_ == 1 && !flag || p_77648_7_ == 0 && flag) && i == field_77889_b.field_71990_ca && k == p_77648_1_.func_77960_j())
        {
            if(p_77648_3_.func_72855_b(field_77890_c.func_71872_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) && p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, field_77890_c.field_71990_ca, k))
            {
                p_77648_3_.func_72908_a((float)p_77648_4_ + 0.5F, (float)p_77648_5_ + 0.5F, (float)p_77648_6_ + 0.5F, field_77890_c.field_72020_cn.func_72675_d(), (field_77890_c.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, field_77890_c.field_72020_cn.func_72678_c() * 0.8F);
                p_77648_1_.field_77994_a--;
            }
            return true;
        }
        if(func_77888_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_))
        {
            return true;
        } else
        {
            return super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
        }
    }

    private boolean func_77888_a(ItemStack p_77888_1_, EntityPlayer p_77888_2_, World p_77888_3_, int p_77888_4_, int p_77888_5_, int p_77888_6_, int p_77888_7_)
    {
        if(p_77888_7_ == 0)
        {
            p_77888_5_--;
        }
        if(p_77888_7_ == 1)
        {
            p_77888_5_++;
        }
        if(p_77888_7_ == 2)
        {
            p_77888_6_--;
        }
        if(p_77888_7_ == 3)
        {
            p_77888_6_++;
        }
        if(p_77888_7_ == 4)
        {
            p_77888_4_--;
        }
        if(p_77888_7_ == 5)
        {
            p_77888_4_++;
        }
        int i = p_77888_3_.func_72798_a(p_77888_4_, p_77888_5_, p_77888_6_);
        int j = p_77888_3_.func_72805_g(p_77888_4_, p_77888_5_, p_77888_6_);
        int k = j & 7;
        if(i == field_77889_b.field_71990_ca && k == p_77888_1_.func_77960_j())
        {
            if(p_77888_3_.func_72855_b(field_77890_c.func_71872_e(p_77888_3_, p_77888_4_, p_77888_5_, p_77888_6_)) && p_77888_3_.func_72832_d(p_77888_4_, p_77888_5_, p_77888_6_, field_77890_c.field_71990_ca, k))
            {
                p_77888_3_.func_72908_a((float)p_77888_4_ + 0.5F, (float)p_77888_5_ + 0.5F, (float)p_77888_6_ + 0.5F, field_77890_c.field_72020_cn.func_72675_d(), (field_77890_c.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, field_77890_c.field_72020_cn.func_72678_c() * 0.8F);
                p_77888_1_.field_77994_a--;
            }
            return true;
        } else
        {
            return false;
        }
    }
}
