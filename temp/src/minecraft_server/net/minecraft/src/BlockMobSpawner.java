// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, TileEntityMobSpawner, World, 
//            TileEntity

public class BlockMobSpawner extends BlockContainer
{

    protected BlockMobSpawner(int p_i3970_1_, int p_i3970_2_)
    {
        super(p_i3970_1_, p_i3970_2_, Material.field_76246_e);
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityMobSpawner();
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return 0;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, p_71914_7_);
        int i = 15 + p_71914_1_.field_73012_v.nextInt(15) + p_71914_1_.field_73012_v.nextInt(15);
        func_71923_g(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, i);
    }

    public boolean func_71926_d()
    {
        return false;
    }
}
