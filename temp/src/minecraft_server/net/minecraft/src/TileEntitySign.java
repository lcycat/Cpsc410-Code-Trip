// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, NBTTagCompound, Packet130UpdateSign, Packet

public class TileEntitySign extends TileEntity
{

    public String field_70412_a[] = {
        "", "", "", ""
    };
    public int field_70410_b;
    private boolean field_70411_c;

    public TileEntitySign()
    {
        field_70410_b = -1;
        field_70411_c = true;
    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        p_70310_1_.func_74778_a("Text1", field_70412_a[0]);
        p_70310_1_.func_74778_a("Text2", field_70412_a[1]);
        p_70310_1_.func_74778_a("Text3", field_70412_a[2]);
        p_70310_1_.func_74778_a("Text4", field_70412_a[3]);
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        field_70411_c = false;
        super.func_70307_a(p_70307_1_);
        for(int i = 0; i < 4; i++)
        {
            field_70412_a[i] = p_70307_1_.func_74779_i((new StringBuilder()).append("Text").append(i + 1).toString());
            if(field_70412_a[i].length() > 15)
            {
                field_70412_a[i] = field_70412_a[i].substring(0, 15);
            }
        }

    }

    public Packet func_70319_e()
    {
        String as[] = new String[4];
        System.arraycopy(field_70412_a, 0, as, 0, 4);
        return new Packet130UpdateSign(field_70329_l, field_70330_m, field_70327_n, as);
    }

    public boolean func_70409_a()
    {
        return field_70411_c;
    }
}
