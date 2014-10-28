// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EnumGameType, EntityPlayerMP, World, Block, 
//            Packet53BlockChange, NetServerHandler, ItemStack, EntityPlayer, 
//            InventoryPlayer, WorldServer

public class ItemInWorldManager
{

    public World field_73092_a;
    public EntityPlayerMP field_73090_b;
    private EnumGameType field_73091_c;
    private boolean field_73088_d;
    private int field_73089_e;
    private int field_73086_f;
    private int field_73087_g;
    private int field_73099_h;
    private int field_73100_i;
    private boolean field_73097_j;
    private int field_73098_k;
    private int field_73095_l;
    private int field_73096_m;
    private int field_73093_n;
    private int field_73094_o;

    public ItemInWorldManager(World p_i3397_1_)
    {
        field_73091_c = EnumGameType.NOT_SET;
        field_73094_o = -1;
        field_73092_a = p_i3397_1_;
    }

    public void func_73076_a(EnumGameType p_73076_1_)
    {
        field_73091_c = p_73076_1_;
        p_73076_1_.func_77147_a(field_73090_b.field_71075_bZ);
        field_73090_b.func_71016_p();
    }

    public EnumGameType func_73081_b()
    {
        return field_73091_c;
    }

    public boolean func_73083_d()
    {
        return field_73091_c.func_77145_d();
    }

    public void func_73077_b(EnumGameType p_73077_1_)
    {
        if(field_73091_c == EnumGameType.NOT_SET)
        {
            field_73091_c = p_73077_1_;
        }
        func_73076_a(field_73091_c);
    }

    public void func_73075_a()
    {
        field_73100_i++;
        if(field_73097_j)
        {
            int i = field_73100_i - field_73093_n;
            int k = field_73092_a.func_72798_a(field_73098_k, field_73095_l, field_73096_m);
            if(k == 0)
            {
                field_73097_j = false;
            } else
            {
                Block block1 = Block.field_71973_m[k];
                float f = block1.func_71908_a(field_73090_b, field_73090_b.field_70170_p, field_73098_k, field_73095_l, field_73096_m) * (float)(i + 1);
                int i1 = (int)(f * 10F);
                if(i1 != field_73094_o)
                {
                    field_73092_a.func_72888_f(field_73090_b.field_70157_k, field_73098_k, field_73095_l, field_73096_m, i1);
                    field_73094_o = i1;
                }
                if(f >= 1.0F)
                {
                    field_73097_j = false;
                    func_73084_b(field_73098_k, field_73095_l, field_73096_m);
                }
            }
        } else
        if(field_73088_d)
        {
            int j = field_73092_a.func_72798_a(field_73086_f, field_73087_g, field_73099_h);
            Block block = Block.field_71973_m[j];
            if(block == null)
            {
                field_73092_a.func_72888_f(field_73090_b.field_70157_k, field_73086_f, field_73087_g, field_73099_h, -1);
                field_73094_o = -1;
                field_73088_d = false;
            } else
            {
                int l = field_73100_i - field_73089_e;
                float f1 = block.func_71908_a(field_73090_b, field_73090_b.field_70170_p, field_73086_f, field_73087_g, field_73099_h) * (float)(l + 1);
                int j1 = (int)(f1 * 10F);
                if(j1 != field_73094_o)
                {
                    field_73092_a.func_72888_f(field_73090_b.field_70157_k, field_73086_f, field_73087_g, field_73099_h, j1);
                    field_73094_o = j1;
                }
            }
        }
    }

    public void func_73074_a(int p_73074_1_, int p_73074_2_, int p_73074_3_, int p_73074_4_)
    {
        if(field_73091_c.func_77150_c())
        {
            return;
        }
        if(func_73083_d())
        {
            if(!field_73092_a.func_72886_a(null, p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_))
            {
                func_73084_b(p_73074_1_, p_73074_2_, p_73074_3_);
            }
            return;
        }
        field_73092_a.func_72886_a(field_73090_b, p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_);
        field_73089_e = field_73100_i;
        float f = 1.0F;
        int i = field_73092_a.func_72798_a(p_73074_1_, p_73074_2_, p_73074_3_);
        if(i > 0)
        {
            Block.field_71973_m[i].func_71921_a(field_73092_a, p_73074_1_, p_73074_2_, p_73074_3_, field_73090_b);
            f = Block.field_71973_m[i].func_71908_a(field_73090_b, field_73090_b.field_70170_p, p_73074_1_, p_73074_2_, p_73074_3_);
        }
        if(i > 0 && f >= 1.0F)
        {
            func_73084_b(p_73074_1_, p_73074_2_, p_73074_3_);
        } else
        {
            field_73088_d = true;
            field_73086_f = p_73074_1_;
            field_73087_g = p_73074_2_;
            field_73099_h = p_73074_3_;
            int j = (int)(f * 10F);
            field_73092_a.func_72888_f(field_73090_b.field_70157_k, p_73074_1_, p_73074_2_, p_73074_3_, j);
            field_73094_o = j;
        }
    }

    public void func_73082_a(int p_73082_1_, int p_73082_2_, int p_73082_3_)
    {
        if(p_73082_1_ == field_73086_f && p_73082_2_ == field_73087_g && p_73082_3_ == field_73099_h)
        {
            int i = field_73100_i - field_73089_e;
            int j = field_73092_a.func_72798_a(p_73082_1_, p_73082_2_, p_73082_3_);
            if(j != 0)
            {
                Block block = Block.field_71973_m[j];
                float f = block.func_71908_a(field_73090_b, field_73090_b.field_70170_p, p_73082_1_, p_73082_2_, p_73082_3_) * (float)(i + 1);
                if(f >= 0.7F)
                {
                    field_73088_d = false;
                    field_73092_a.func_72888_f(field_73090_b.field_70157_k, p_73082_1_, p_73082_2_, p_73082_3_, -1);
                    func_73084_b(p_73082_1_, p_73082_2_, p_73082_3_);
                } else
                if(!field_73097_j)
                {
                    field_73088_d = false;
                    field_73097_j = true;
                    field_73098_k = p_73082_1_;
                    field_73095_l = p_73082_2_;
                    field_73096_m = p_73082_3_;
                    field_73093_n = field_73089_e;
                }
            }
        }
    }

    public void func_73073_c(int p_73073_1_, int p_73073_2_, int p_73073_3_)
    {
        field_73088_d = false;
        field_73092_a.func_72888_f(field_73090_b.field_70157_k, field_73086_f, field_73087_g, field_73099_h, -1);
    }

    private boolean func_73079_d(int p_73079_1_, int p_73079_2_, int p_73079_3_)
    {
        Block block = Block.field_71973_m[field_73092_a.func_72798_a(p_73079_1_, p_73079_2_, p_73079_3_)];
        int i = field_73092_a.func_72805_g(p_73079_1_, p_73079_2_, p_73079_3_);
        if(block != null)
        {
            block.func_71846_a(field_73092_a, p_73079_1_, p_73079_2_, p_73079_3_, i, field_73090_b);
        }
        boolean flag = field_73092_a.func_72859_e(p_73079_1_, p_73079_2_, p_73079_3_, 0);
        if(block != null && flag)
        {
            block.func_71898_d(field_73092_a, p_73079_1_, p_73079_2_, p_73079_3_, i);
        }
        return flag;
    }

    public boolean func_73084_b(int p_73084_1_, int p_73084_2_, int p_73084_3_)
    {
        if(field_73091_c.func_77150_c())
        {
            return false;
        }
        int i = field_73092_a.func_72798_a(p_73084_1_, p_73084_2_, p_73084_3_);
        int j = field_73092_a.func_72805_g(p_73084_1_, p_73084_2_, p_73084_3_);
        field_73092_a.func_72889_a(field_73090_b, 2001, p_73084_1_, p_73084_2_, p_73084_3_, i + (field_73092_a.func_72805_g(p_73084_1_, p_73084_2_, p_73084_3_) << 12));
        boolean flag = func_73079_d(p_73084_1_, p_73084_2_, p_73084_3_);
        if(func_73083_d())
        {
            field_73090_b.field_71135_a.func_72567_b(new Packet53BlockChange(p_73084_1_, p_73084_2_, p_73084_3_, field_73092_a));
        } else
        {
            ItemStack itemstack = field_73090_b.func_71045_bC();
            boolean flag1 = field_73090_b.func_71062_b(Block.field_71973_m[i]);
            if(itemstack != null)
            {
                itemstack.func_77941_a(field_73092_a, i, p_73084_1_, p_73084_2_, p_73084_3_, field_73090_b);
                if(itemstack.field_77994_a == 0)
                {
                    field_73090_b.func_71028_bD();
                }
            }
            if(flag && flag1)
            {
                Block.field_71973_m[i].func_71893_a(field_73092_a, field_73090_b, p_73084_1_, p_73084_2_, p_73084_3_, j);
            }
        }
        return flag;
    }

    public boolean func_73085_a(EntityPlayer p_73085_1_, World p_73085_2_, ItemStack p_73085_3_)
    {
        int i = p_73085_3_.field_77994_a;
        int j = p_73085_3_.func_77960_j();
        ItemStack itemstack = p_73085_3_.func_77957_a(p_73085_2_, p_73085_1_);
        if(itemstack != p_73085_3_ || itemstack != null && itemstack.field_77994_a != i || itemstack != null && itemstack.func_77988_m() > 0)
        {
            p_73085_1_.field_71071_by.field_70462_a[p_73085_1_.field_71071_by.field_70461_c] = itemstack;
            if(func_73083_d())
            {
                itemstack.field_77994_a = i;
                itemstack.func_77964_b(j);
            }
            if(itemstack.field_77994_a == 0)
            {
                p_73085_1_.field_71071_by.field_70462_a[p_73085_1_.field_71071_by.field_70461_c] = null;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean func_73078_a(EntityPlayer p_73078_1_, World p_73078_2_, ItemStack p_73078_3_, int p_73078_4_, int p_73078_5_, int p_73078_6_, int p_73078_7_, 
            float p_73078_8_, float p_73078_9_, float p_73078_10_)
    {
        int i = p_73078_2_.func_72798_a(p_73078_4_, p_73078_5_, p_73078_6_);
        if(i > 0 && Block.field_71973_m[i].func_71903_a(p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_1_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_))
        {
            return true;
        }
        if(p_73078_3_ == null)
        {
            return false;
        }
        if(func_73083_d())
        {
            int j = p_73078_3_.func_77960_j();
            int k = p_73078_3_.field_77994_a;
            boolean flag = p_73078_3_.func_77943_a(p_73078_1_, p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
            p_73078_3_.func_77964_b(j);
            p_73078_3_.field_77994_a = k;
            return flag;
        } else
        {
            return p_73078_3_.func_77943_a(p_73078_1_, p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
        }
    }

    public void func_73080_a(WorldServer p_73080_1_)
    {
        field_73092_a = p_73080_1_;
    }
}
