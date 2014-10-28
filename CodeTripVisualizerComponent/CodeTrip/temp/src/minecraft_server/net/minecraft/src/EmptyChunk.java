// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Chunk, World, EnumSkyBlock, Entity, 
//            TileEntity, AxisAlignedBB

public class EmptyChunk extends Chunk
{

    public EmptyChunk(World p_i3770_1_, int p_i3770_2_, int p_i3770_3_)
    {
        super(p_i3770_1_, p_i3770_2_, p_i3770_3_);
    }

    public boolean func_76600_a(int p_76600_1_, int p_76600_2_)
    {
        return p_76600_1_ == field_76635_g && p_76600_2_ == field_76647_h;
    }

    public int func_76611_b(int p_76611_1_, int p_76611_2_)
    {
        return 0;
    }

    public void func_76603_b()
    {
    }

    public int func_76610_a(int p_76610_1_, int p_76610_2_, int p_76610_3_)
    {
        return 0;
    }

    public int func_76596_b(int p_76596_1_, int p_76596_2_, int p_76596_3_)
    {
        return 255;
    }

    public boolean func_76592_a(int p_76592_1_, int p_76592_2_, int p_76592_3_, int i, int j)
    {
        return true;
    }

    public boolean func_76598_a(int p_76598_1_, int p_76598_2_, int p_76598_3_, int i)
    {
        return true;
    }

    public int func_76628_c(int p_76628_1_, int p_76628_2_, int p_76628_3_)
    {
        return 0;
    }

    public boolean func_76589_b(int p_76589_1_, int p_76589_2_, int p_76589_3_, int i)
    {
        return false;
    }

    public int func_76614_a(EnumSkyBlock p_76614_1_, int p_76614_2_, int p_76614_3_, int i)
    {
        return 0;
    }

    public void func_76633_a(EnumSkyBlock enumskyblock, int i, int j, int k, int l)
    {
    }

    public int func_76629_c(int p_76629_1_, int p_76629_2_, int p_76629_3_, int i)
    {
        return 0;
    }

    public void func_76612_a(Entity entity)
    {
    }

    public void func_76622_b(Entity entity)
    {
    }

    public void func_76608_a(Entity entity, int i)
    {
    }

    public boolean func_76619_d(int p_76619_1_, int p_76619_2_, int p_76619_3_)
    {
        return false;
    }

    public TileEntity func_76597_e(int p_76597_1_, int p_76597_2_, int p_76597_3_)
    {
        return null;
    }

    public void func_76620_a(TileEntity tileentity)
    {
    }

    public void func_76604_a(int i, int j, int k, TileEntity tileentity)
    {
    }

    public void func_76627_f(int i, int j, int k)
    {
    }

    public void func_76631_c()
    {
    }

    public void func_76623_d()
    {
    }

    public void func_76630_e()
    {
    }

    public void func_76588_a(Entity entity, AxisAlignedBB axisalignedbb, List list)
    {
    }

    public void func_76618_a(Class class1, AxisAlignedBB axisalignedbb, List list)
    {
    }

    public boolean func_76601_a(boolean p_76601_1_)
    {
        return false;
    }

    public Random func_76617_a(long p_76617_1_)
    {
        return new Random(field_76637_e.func_72905_C() + (long)(field_76635_g * field_76635_g * 0x4c1906) + (long)(field_76635_g * 0x5ac0db) + (long)(field_76647_h * field_76647_h) * 0x4307a7L + (long)(field_76647_h * 0x5f24f) ^ p_76617_1_);
    }

    public boolean func_76621_g()
    {
        return true;
    }

    public boolean func_76606_c(int p_76606_1_, int p_76606_2_)
    {
        return true;
    }
}
