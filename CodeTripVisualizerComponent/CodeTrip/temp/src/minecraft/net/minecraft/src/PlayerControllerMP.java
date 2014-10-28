// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EnumGameType, WorldClient, EntityPlayer, EntityClientPlayerMP, 
//            Block, World, ItemStack, Packet14BlockDig, 
//            NetClientHandler, StepSound, SoundManager, InventoryPlayer, 
//            Packet16BlockItemSwitch, Vec3, ItemBlock, Packet15Place, 
//            Packet7UseEntity, Entity, Container, Packet102WindowClick, 
//            Packet108EnchantItem, Packet107CreativeSetSlot

public class PlayerControllerMP
{

    private final Minecraft field_78776_a;
    private final NetClientHandler field_78774_b;
    private int field_78775_c;
    private int field_78772_d;
    private int field_78773_e;
    private float field_78770_f;
    private float field_78771_g;
    private float field_78780_h;
    private int field_78781_i;
    private boolean field_78778_j;
    private EnumGameType field_78779_k;
    private int field_78777_l;

    public PlayerControllerMP(Minecraft p_i3111_1_, NetClientHandler p_i3111_2_)
    {
        field_78775_c = -1;
        field_78772_d = -1;
        field_78773_e = -1;
        field_78770_f = 0.0F;
        field_78771_g = 0.0F;
        field_78780_h = 0.0F;
        field_78781_i = 0;
        field_78778_j = false;
        field_78779_k = EnumGameType.SURVIVAL;
        field_78777_l = 0;
        field_78776_a = p_i3111_1_;
        field_78774_b = p_i3111_2_;
    }

    public static void func_78744_a(Minecraft p_78744_0_, PlayerControllerMP p_78744_1_, int p_78744_2_, int p_78744_3_, int p_78744_4_, int p_78744_5_)
    {
        if(!p_78744_0_.field_71441_e.func_72886_a(p_78744_0_.field_71439_g, p_78744_2_, p_78744_3_, p_78744_4_, p_78744_5_))
        {
            p_78744_1_.func_78751_a(p_78744_2_, p_78744_3_, p_78744_4_, p_78744_5_);
        }
    }

    public void func_78748_a(EntityPlayer p_78748_1_)
    {
        field_78779_k.func_77147_a(p_78748_1_.field_71075_bZ);
    }

    public boolean func_78747_a()
    {
        return false;
    }

    public void func_78746_a(EnumGameType p_78746_1_)
    {
        field_78779_k = p_78746_1_;
        field_78779_k.func_77147_a(field_78776_a.field_71439_g.field_71075_bZ);
    }

    public void func_78745_b(EntityPlayer p_78745_1_)
    {
        p_78745_1_.field_70177_z = -180F;
    }

    public boolean func_78755_b()
    {
        return field_78779_k.func_77144_e();
    }

    public boolean func_78751_a(int p_78751_1_, int p_78751_2_, int p_78751_3_, int p_78751_4_)
    {
        if(field_78779_k.func_77150_c())
        {
            return false;
        }
        WorldClient worldclient = field_78776_a.field_71441_e;
        Block block = Block.field_71973_m[worldclient.func_72798_a(p_78751_1_, p_78751_2_, p_78751_3_)];
        if(block == null)
        {
            return false;
        }
        worldclient.func_72926_e(2001, p_78751_1_, p_78751_2_, p_78751_3_, block.field_71990_ca + (worldclient.func_72805_g(p_78751_1_, p_78751_2_, p_78751_3_) << 12));
        int i = worldclient.func_72805_g(p_78751_1_, p_78751_2_, p_78751_3_);
        boolean flag = worldclient.func_72859_e(p_78751_1_, p_78751_2_, p_78751_3_, 0);
        if(flag)
        {
            block.func_71898_d(worldclient, p_78751_1_, p_78751_2_, p_78751_3_, i);
        }
        if(!field_78779_k.func_77145_d())
        {
            ItemStack itemstack = field_78776_a.field_71439_g.func_71045_bC();
            if(itemstack != null)
            {
                itemstack.func_77941_a(worldclient, block.field_71990_ca, p_78751_1_, p_78751_2_, p_78751_3_, field_78776_a.field_71439_g);
                if(itemstack.field_77994_a == 0)
                {
                    field_78776_a.field_71439_g.func_71028_bD();
                }
            }
        }
        return flag;
    }

    public void func_78743_b(int p_78743_1_, int p_78743_2_, int p_78743_3_, int p_78743_4_)
    {
        if(field_78779_k.func_77150_c())
        {
            return;
        }
        if(field_78779_k.func_77145_d())
        {
            field_78774_b.func_72552_c(new Packet14BlockDig(0, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_));
            func_78744_a(field_78776_a, this, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_);
            field_78781_i = 5;
        } else
        if(!field_78778_j || p_78743_1_ != field_78775_c || p_78743_2_ != field_78772_d || p_78743_3_ != field_78773_e)
        {
            field_78774_b.func_72552_c(new Packet14BlockDig(0, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_));
            int i = field_78776_a.field_71441_e.func_72798_a(p_78743_1_, p_78743_2_, p_78743_3_);
            if(i > 0 && field_78770_f == 0.0F)
            {
                Block.field_71973_m[i].func_71921_a(field_78776_a.field_71441_e, p_78743_1_, p_78743_2_, p_78743_3_, field_78776_a.field_71439_g);
            }
            if(i > 0 && Block.field_71973_m[i].func_71908_a(field_78776_a.field_71439_g, field_78776_a.field_71439_g.field_70170_p, p_78743_1_, p_78743_2_, p_78743_3_) >= 1.0F)
            {
                func_78751_a(p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_);
            } else
            {
                field_78778_j = true;
                field_78775_c = p_78743_1_;
                field_78772_d = p_78743_2_;
                field_78773_e = p_78743_3_;
                field_78770_f = 0.0F;
                field_78771_g = 0.0F;
                field_78780_h = 0.0F;
                field_78776_a.field_71441_e.func_72888_f(field_78776_a.field_71439_g.field_70157_k, field_78775_c, field_78772_d, field_78773_e, (int)(field_78770_f * 10F) - 1);
            }
        }
    }

    public void func_78767_c()
    {
        if(field_78778_j)
        {
            field_78774_b.func_72552_c(new Packet14BlockDig(1, field_78775_c, field_78772_d, field_78773_e, -1));
        }
        field_78778_j = false;
        field_78770_f = 0.0F;
        field_78776_a.field_71441_e.func_72888_f(field_78776_a.field_71439_g.field_70157_k, field_78775_c, field_78772_d, field_78773_e, -1);
    }

    public void func_78759_c(int p_78759_1_, int p_78759_2_, int p_78759_3_, int p_78759_4_)
    {
        func_78750_j();
        if(field_78781_i > 0)
        {
            field_78781_i--;
            return;
        }
        if(field_78779_k.func_77145_d())
        {
            field_78781_i = 5;
            field_78774_b.func_72552_c(new Packet14BlockDig(0, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_));
            func_78744_a(field_78776_a, this, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
            return;
        }
        if(p_78759_1_ == field_78775_c && p_78759_2_ == field_78772_d && p_78759_3_ == field_78773_e)
        {
            int i = field_78776_a.field_71441_e.func_72798_a(p_78759_1_, p_78759_2_, p_78759_3_);
            if(i == 0)
            {
                field_78778_j = false;
                return;
            }
            Block block = Block.field_71973_m[i];
            field_78770_f += block.func_71908_a(field_78776_a.field_71439_g, field_78776_a.field_71439_g.field_70170_p, p_78759_1_, p_78759_2_, p_78759_3_);
            if(field_78780_h % 4F == 0.0F && block != null)
            {
                field_78776_a.field_71416_A.func_77364_b(block.field_72020_cn.func_72675_d(), (float)p_78759_1_ + 0.5F, (float)p_78759_2_ + 0.5F, (float)p_78759_3_ + 0.5F, (block.field_72020_cn.func_72677_b() + 1.0F) / 8F, block.field_72020_cn.func_72678_c() * 0.5F);
            }
            field_78780_h++;
            if(field_78770_f >= 1.0F)
            {
                field_78778_j = false;
                field_78774_b.func_72552_c(new Packet14BlockDig(2, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_));
                func_78751_a(p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
                field_78770_f = 0.0F;
                field_78771_g = 0.0F;
                field_78780_h = 0.0F;
                field_78781_i = 5;
            }
            field_78776_a.field_71441_e.func_72888_f(field_78776_a.field_71439_g.field_70157_k, field_78775_c, field_78772_d, field_78773_e, (int)(field_78770_f * 10F) - 1);
        } else
        {
            func_78743_b(p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
        }
    }

    public float func_78757_d()
    {
        return !field_78779_k.func_77145_d() ? 4.5F : 5F;
    }

    public void func_78765_e()
    {
        func_78750_j();
        field_78771_g = field_78770_f;
        field_78776_a.field_71416_A.func_77371_c();
    }

    private void func_78750_j()
    {
        int i = field_78776_a.field_71439_g.field_71071_by.field_70461_c;
        if(i != field_78777_l)
        {
            field_78777_l = i;
            field_78774_b.func_72552_c(new Packet16BlockItemSwitch(field_78777_l));
        }
    }

    public boolean func_78760_a(EntityPlayer p_78760_1_, World p_78760_2_, ItemStack p_78760_3_, int p_78760_4_, int p_78760_5_, int p_78760_6_, int p_78760_7_, 
            Vec3 p_78760_8_)
    {
        func_78750_j();
        float f = (float)p_78760_8_.field_72450_a - (float)p_78760_4_;
        float f1 = (float)p_78760_8_.field_72448_b - (float)p_78760_5_;
        float f2 = (float)p_78760_8_.field_72449_c - (float)p_78760_6_;
        boolean flag = false;
        int i = p_78760_2_.func_72798_a(p_78760_4_, p_78760_5_, p_78760_6_);
        if(i > 0 && Block.field_71973_m[i].func_71903_a(p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_1_, p_78760_7_, f, f1, f2))
        {
            flag = true;
        }
        if(!flag && p_78760_3_ != null && (p_78760_3_.func_77973_b() instanceof ItemBlock))
        {
            ItemBlock itemblock = (ItemBlock)p_78760_3_.func_77973_b();
            if(!itemblock.func_77884_a(p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, p_78760_1_, p_78760_3_))
            {
                return false;
            }
        }
        field_78774_b.func_72552_c(new Packet15Place(p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, p_78760_1_.field_71071_by.func_70448_g(), f, f1, f2));
        if(flag)
        {
            return true;
        }
        if(p_78760_3_ == null)
        {
            return false;
        }
        if(field_78779_k.func_77145_d())
        {
            int j = p_78760_3_.func_77960_j();
            int k = p_78760_3_.field_77994_a;
            boolean flag1 = p_78760_3_.func_77943_a(p_78760_1_, p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, f, f1, f2);
            p_78760_3_.func_77964_b(j);
            p_78760_3_.field_77994_a = k;
            return flag1;
        } else
        {
            return p_78760_3_.func_77943_a(p_78760_1_, p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, f, f1, f2);
        }
    }

    public boolean func_78769_a(EntityPlayer p_78769_1_, World p_78769_2_, ItemStack p_78769_3_)
    {
        func_78750_j();
        field_78774_b.func_72552_c(new Packet15Place(-1, -1, -1, 255, p_78769_1_.field_71071_by.func_70448_g(), 0.0F, 0.0F, 0.0F));
        int i = p_78769_3_.field_77994_a;
        ItemStack itemstack = p_78769_3_.func_77957_a(p_78769_2_, p_78769_1_);
        if(itemstack != p_78769_3_ || itemstack != null && itemstack.field_77994_a != i)
        {
            p_78769_1_.field_71071_by.field_70462_a[p_78769_1_.field_71071_by.field_70461_c] = itemstack;
            if(itemstack.field_77994_a == 0)
            {
                p_78769_1_.field_71071_by.field_70462_a[p_78769_1_.field_71071_by.field_70461_c] = null;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public EntityClientPlayerMP func_78754_a(World p_78754_1_)
    {
        return new EntityClientPlayerMP(field_78776_a, p_78754_1_, field_78776_a.field_71449_j, field_78774_b);
    }

    public void func_78764_a(EntityPlayer p_78764_1_, Entity p_78764_2_)
    {
        func_78750_j();
        field_78774_b.func_72552_c(new Packet7UseEntity(p_78764_1_.field_70157_k, p_78764_2_.field_70157_k, 1));
        p_78764_1_.func_71059_n(p_78764_2_);
    }

    public boolean func_78768_b(EntityPlayer p_78768_1_, Entity p_78768_2_)
    {
        func_78750_j();
        field_78774_b.func_72552_c(new Packet7UseEntity(p_78768_1_.field_70157_k, p_78768_2_.field_70157_k, 0));
        return p_78768_1_.func_70998_m(p_78768_2_);
    }

    public ItemStack func_78753_a(int p_78753_1_, int p_78753_2_, int p_78753_3_, boolean p_78753_4_, EntityPlayer p_78753_5_)
    {
        short word0 = p_78753_5_.field_71070_bA.func_75136_a(p_78753_5_.field_71071_by);
        ItemStack itemstack = p_78753_5_.field_71070_bA.func_75144_a(p_78753_2_, p_78753_3_, p_78753_4_, p_78753_5_);
        field_78774_b.func_72552_c(new Packet102WindowClick(p_78753_1_, p_78753_2_, p_78753_3_, p_78753_4_, itemstack, word0));
        return itemstack;
    }

    public void func_78756_a(int p_78756_1_, int p_78756_2_)
    {
        field_78774_b.func_72552_c(new Packet108EnchantItem(p_78756_1_, p_78756_2_));
    }

    public void func_78761_a(ItemStack p_78761_1_, int p_78761_2_)
    {
        if(field_78779_k.func_77145_d())
        {
            field_78774_b.func_72552_c(new Packet107CreativeSetSlot(p_78761_2_, p_78761_1_));
        }
    }

    public void func_78752_a(ItemStack p_78752_1_)
    {
        if(field_78779_k.func_77145_d() && p_78752_1_ != null)
        {
            field_78774_b.func_72552_c(new Packet107CreativeSetSlot(-1, p_78752_1_));
        }
    }

    public void func_78766_c(EntityPlayer p_78766_1_)
    {
        func_78750_j();
        field_78774_b.func_72552_c(new Packet14BlockDig(5, 0, 0, 0, 255));
        p_78766_1_.func_71034_by();
    }

    public boolean func_78763_f()
    {
        return true;
    }

    public boolean func_78762_g()
    {
        return !field_78779_k.func_77145_d();
    }

    public boolean func_78758_h()
    {
        return field_78779_k.func_77145_d();
    }

    public boolean func_78749_i()
    {
        return field_78779_k.func_77145_d();
    }
}
