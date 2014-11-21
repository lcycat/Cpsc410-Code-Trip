// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemInWorldManager, World, EntityPlayerMP, Packet70GameEvent, 
//            NetServerHandler, EntityPlayer, ItemStack

public class DemoWorldManager extends ItemInWorldManager
{

    private boolean field_73105_c;
    private boolean field_73103_d;
    private int field_73104_e;
    private int field_73102_f;

    public DemoWorldManager(World p_i3387_1_)
    {
        super(p_i3387_1_);
        field_73105_c = false;
        field_73103_d = false;
        field_73104_e = 0;
        field_73102_f = 0;
    }

    public void func_73075_a()
    {
        super.func_73075_a();
        field_73102_f++;
        long l = field_73092_a.func_72820_D();
        long l1 = l / 24000L + 1L;
        if(!field_73105_c && field_73102_f > 20)
        {
            field_73105_c = true;
            field_73090_b.field_71135_a.func_72567_b(new Packet70GameEvent(5, 0));
        }
        field_73103_d = l > 0x1d6b4L;
        if(field_73103_d)
        {
            field_73104_e++;
        }
        if(l % 24000L == 500L)
        {
            if(l1 <= 6L)
            {
                field_73090_b.func_70006_a(field_73090_b.func_70004_a((new StringBuilder()).append("demo.day.").append(l1).toString(), new Object[0]));
            }
        } else
        if(l1 == 1L)
        {
            if(l == 100L)
            {
                field_73090_b.field_71135_a.func_72567_b(new Packet70GameEvent(5, 101));
            } else
            if(l == 175L)
            {
                field_73090_b.field_71135_a.func_72567_b(new Packet70GameEvent(5, 102));
            } else
            if(l == 250L)
            {
                field_73090_b.field_71135_a.func_72567_b(new Packet70GameEvent(5, 103));
            }
        } else
        if(l1 == 5L && l % 24000L == 22000L)
        {
            field_73090_b.func_70006_a(field_73090_b.func_70004_a("demo.day.warning", new Object[0]));
        }
    }

    private void func_73101_e()
    {
        if(field_73104_e > 100)
        {
            field_73090_b.func_70006_a(field_73090_b.func_70004_a("demo.reminder", new Object[0]));
            field_73104_e = 0;
        }
    }

    public void func_73074_a(int p_73074_1_, int p_73074_2_, int p_73074_3_, int p_73074_4_)
    {
        if(field_73103_d)
        {
            func_73101_e();
            return;
        } else
        {
            super.func_73074_a(p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_);
            return;
        }
    }

    public void func_73082_a(int p_73082_1_, int p_73082_2_, int p_73082_3_)
    {
        if(field_73103_d)
        {
            return;
        } else
        {
            super.func_73082_a(p_73082_1_, p_73082_2_, p_73082_3_);
            return;
        }
    }

    public boolean func_73084_b(int p_73084_1_, int p_73084_2_, int p_73084_3_)
    {
        if(field_73103_d)
        {
            return false;
        } else
        {
            return super.func_73084_b(p_73084_1_, p_73084_2_, p_73084_3_);
        }
    }

    public boolean func_73085_a(EntityPlayer p_73085_1_, World p_73085_2_, ItemStack p_73085_3_)
    {
        if(field_73103_d)
        {
            func_73101_e();
            return false;
        } else
        {
            return super.func_73085_a(p_73085_1_, p_73085_2_, p_73085_3_);
        }
    }

    public boolean func_73078_a(EntityPlayer p_73078_1_, World p_73078_2_, ItemStack p_73078_3_, int p_73078_4_, int p_73078_5_, int p_73078_6_, int p_73078_7_, 
            float p_73078_8_, float p_73078_9_, float p_73078_10_)
    {
        if(field_73103_d)
        {
            func_73101_e();
            return false;
        } else
        {
            return super.func_73078_a(p_73078_1_, p_73078_2_, p_73078_3_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
        }
    }
}
