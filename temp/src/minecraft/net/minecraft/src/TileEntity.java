// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            NBTTagCompound, World, Block, TileEntityFurnace, 
//            TileEntityChest, TileEntityEnderChest, TileEntityRecordPlayer, TileEntityDispenser, 
//            TileEntitySign, TileEntityMobSpawner, TileEntityNote, TileEntityPiston, 
//            TileEntityBrewingStand, TileEntityEnchantmentTable, TileEntityEndPortal, Packet

public class TileEntity
{

    private static Map field_70326_a = new HashMap();
    private static Map field_70323_b = new HashMap();
    protected World field_70331_k;
    public int field_70329_l;
    public int field_70330_m;
    public int field_70327_n;
    protected boolean field_70328_o;
    public int field_70325_p;
    public Block field_70324_q;

    public TileEntity()
    {
        field_70325_p = -1;
    }

    private static void func_70306_a(Class p_70306_0_, String p_70306_1_)
    {
        if(field_70326_a.containsKey(p_70306_1_))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate id: ").append(p_70306_1_).toString());
        } else
        {
            field_70326_a.put(p_70306_1_, p_70306_0_);
            field_70323_b.put(p_70306_0_, p_70306_1_);
            return;
        }
    }

    public World func_70314_l()
    {
        return field_70331_k;
    }

    public void func_70308_a(World p_70308_1_)
    {
        field_70331_k = p_70308_1_;
    }

    public boolean func_70309_m()
    {
        return field_70331_k != null;
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        field_70329_l = p_70307_1_.func_74762_e("x");
        field_70330_m = p_70307_1_.func_74762_e("y");
        field_70327_n = p_70307_1_.func_74762_e("z");
    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        String s = (String)field_70323_b.get(getClass());
        if(s == null)
        {
            throw new RuntimeException((new StringBuilder()).append(getClass()).append(" is missing a mapping! This is a bug!").toString());
        } else
        {
            p_70310_1_.func_74778_a("id", s);
            p_70310_1_.func_74768_a("x", field_70329_l);
            p_70310_1_.func_74768_a("y", field_70330_m);
            p_70310_1_.func_74768_a("z", field_70327_n);
            return;
        }
    }

    public void func_70316_g()
    {
    }

    public static TileEntity func_70317_c(NBTTagCompound p_70317_0_)
    {
        TileEntity tileentity = null;
        try
        {
            Class class1 = (Class)field_70326_a.get(p_70317_0_.func_74779_i("id"));
            if(class1 != null)
            {
                tileentity = (TileEntity)class1.newInstance();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(tileentity != null)
        {
            tileentity.func_70307_a(p_70317_0_);
        } else
        {
            System.out.println((new StringBuilder()).append("Skipping TileEntity with id ").append(p_70317_0_.func_74779_i("id")).toString());
        }
        return tileentity;
    }

    public int func_70322_n()
    {
        if(field_70325_p == -1)
        {
            field_70325_p = field_70331_k.func_72805_g(field_70329_l, field_70330_m, field_70327_n);
        }
        return field_70325_p;
    }

    public void func_70296_d()
    {
        if(field_70331_k != null)
        {
            field_70325_p = field_70331_k.func_72805_g(field_70329_l, field_70330_m, field_70327_n);
            field_70331_k.func_72944_b(field_70329_l, field_70330_m, field_70327_n, this);
        }
    }

    public double func_70318_a(double p_70318_1_, double p_70318_3_, double p_70318_5_)
    {
        double d = ((double)field_70329_l + 0.5D) - p_70318_1_;
        double d1 = ((double)field_70330_m + 0.5D) - p_70318_3_;
        double d2 = ((double)field_70327_n + 0.5D) - p_70318_5_;
        return d * d + d1 * d1 + d2 * d2;
    }

    public Block func_70311_o()
    {
        if(field_70324_q == null)
        {
            field_70324_q = Block.field_71973_m[field_70331_k.func_72798_a(field_70329_l, field_70330_m, field_70327_n)];
        }
        return field_70324_q;
    }

    public Packet func_70319_e()
    {
        return null;
    }

    public boolean func_70320_p()
    {
        return field_70328_o;
    }

    public void func_70313_j()
    {
        field_70328_o = true;
    }

    public void func_70312_q()
    {
        field_70328_o = false;
    }

    public void func_70315_b(int i, int j)
    {
    }

    public void func_70321_h()
    {
        field_70324_q = null;
        field_70325_p = -1;
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static 
    {
        func_70306_a(net.minecraft.src.TileEntityFurnace.class, "Furnace");
        func_70306_a(net.minecraft.src.TileEntityChest.class, "Chest");
        func_70306_a(net.minecraft.src.TileEntityEnderChest.class, "EnderChest");
        func_70306_a(net.minecraft.src.TileEntityRecordPlayer.class, "RecordPlayer");
        func_70306_a(net.minecraft.src.TileEntityDispenser.class, "Trap");
        func_70306_a(net.minecraft.src.TileEntitySign.class, "Sign");
        func_70306_a(net.minecraft.src.TileEntityMobSpawner.class, "MobSpawner");
        func_70306_a(net.minecraft.src.TileEntityNote.class, "Music");
        func_70306_a(net.minecraft.src.TileEntityPiston.class, "Piston");
        func_70306_a(net.minecraft.src.TileEntityBrewingStand.class, "Cauldron");
        func_70306_a(net.minecraft.src.TileEntityEnchantmentTable.class, "EnchantTable");
        func_70306_a(net.minecraft.src.TileEntityEndPortal.class, "Airportal");
    }
}
