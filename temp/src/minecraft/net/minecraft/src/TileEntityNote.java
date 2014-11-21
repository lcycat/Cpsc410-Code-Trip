// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, NBTTagCompound, World, Material, 
//            Block

public class TileEntityNote extends TileEntity
{

    public byte field_70416_a;
    public boolean field_70415_b;

    public TileEntityNote()
    {
        field_70416_a = 0;
        field_70415_b = false;
    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        p_70310_1_.func_74774_a("note", field_70416_a);
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        super.func_70307_a(p_70307_1_);
        field_70416_a = p_70307_1_.func_74771_c("note");
        if(field_70416_a < 0)
        {
            field_70416_a = 0;
        }
        if(field_70416_a > 24)
        {
            field_70416_a = 24;
        }
    }

    public void func_70413_a()
    {
        field_70416_a = (byte)((field_70416_a + 1) % 25);
        func_70296_d();
    }

    public void func_70414_a(World p_70414_1_, int p_70414_2_, int p_70414_3_, int p_70414_4_)
    {
        if(p_70414_1_.func_72803_f(p_70414_2_, p_70414_3_ + 1, p_70414_4_) != Material.field_76249_a)
        {
            return;
        }
        Material material = p_70414_1_.func_72803_f(p_70414_2_, p_70414_3_ - 1, p_70414_4_);
        byte byte0 = 0;
        if(material == Material.field_76246_e)
        {
            byte0 = 1;
        }
        if(material == Material.field_76251_o)
        {
            byte0 = 2;
        }
        if(material == Material.field_76264_q)
        {
            byte0 = 3;
        }
        if(material == Material.field_76245_d)
        {
            byte0 = 4;
        }
        p_70414_1_.func_72965_b(p_70414_2_, p_70414_3_, p_70414_4_, Block.field_71960_R.field_71990_ca, byte0, field_70416_a);
    }
}
