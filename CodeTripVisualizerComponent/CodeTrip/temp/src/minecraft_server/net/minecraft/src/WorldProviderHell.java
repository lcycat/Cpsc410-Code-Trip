// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            WorldProvider, WorldChunkManagerHell, BiomeGenBase, ChunkProviderHell, 
//            World, IChunkProvider

public class WorldProviderHell extends WorldProvider
{

    public WorldProviderHell()
    {
    }

    public void func_76572_b()
    {
        field_76578_c = new WorldChunkManagerHell(BiomeGenBase.field_76778_j, 1.0F, 0.0F);
        field_76575_d = true;
        field_76576_e = true;
        field_76574_g = -1;
    }

    protected void func_76556_a()
    {
        float f = 0.1F;
        for(int i = 0; i <= 15; i++)
        {
            float f1 = 1.0F - (float)i / 15F;
            field_76573_f[i] = ((1.0F - f1) / (f1 * 3F + 1.0F)) * (1.0F - f) + f;
        }

    }

    public IChunkProvider func_76555_c()
    {
        return new ChunkProviderHell(field_76579_a, field_76579_a.func_72905_C());
    }

    public boolean func_76569_d()
    {
        return false;
    }

    public boolean func_76566_a(int p_76566_1_, int p_76566_2_)
    {
        return false;
    }

    public float func_76563_a(long p_76563_1_, float p_76563_3_)
    {
        return 0.5F;
    }

    public boolean func_76567_e()
    {
        return false;
    }
}
