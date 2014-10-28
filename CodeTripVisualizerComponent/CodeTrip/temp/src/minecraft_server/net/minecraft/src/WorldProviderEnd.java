// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            WorldProvider, WorldChunkManagerHell, BiomeGenBase, ChunkProviderEnd, 
//            World, Block, Material, ChunkCoordinates, 
//            IChunkProvider

public class WorldProviderEnd extends WorldProvider
{

    public WorldProviderEnd()
    {
    }

    public void func_76572_b()
    {
        field_76578_c = new WorldChunkManagerHell(BiomeGenBase.field_76779_k, 0.5F, 0.0F);
        field_76574_g = 1;
        field_76576_e = true;
    }

    public IChunkProvider func_76555_c()
    {
        return new ChunkProviderEnd(field_76579_a, field_76579_a.func_72905_C());
    }

    public float func_76563_a(long p_76563_1_, float p_76563_3_)
    {
        return 0.0F;
    }

    public boolean func_76567_e()
    {
        return false;
    }

    public boolean func_76569_d()
    {
        return false;
    }

    public boolean func_76566_a(int p_76566_1_, int p_76566_2_)
    {
        int i = field_76579_a.func_72922_b(p_76566_1_, p_76566_2_);
        if(i == 0)
        {
            return false;
        } else
        {
            return Block.field_71973_m[i].field_72018_cp.func_76230_c();
        }
    }

    public ChunkCoordinates func_76554_h()
    {
        return new ChunkCoordinates(100, 50, 0);
    }

    public int func_76557_i()
    {
        return 50;
    }
}
