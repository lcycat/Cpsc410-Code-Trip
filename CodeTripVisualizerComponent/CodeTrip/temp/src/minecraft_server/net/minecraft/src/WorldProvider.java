// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            World, WorldInfo, WorldType, Block, 
//            BlockGrass, WorldProviderHell, WorldProviderSurface, WorldProviderEnd, 
//            WorldChunkManager, IChunkProvider, ChunkCoordinates

public abstract class WorldProvider
{

    public World field_76579_a;
    public WorldType field_76577_b;
    public WorldChunkManager field_76578_c;
    public boolean field_76575_d;
    public boolean field_76576_e;
    public float field_76573_f[];
    public int field_76574_g;
    private float field_76580_h[];

    public WorldProvider()
    {
        field_76575_d = false;
        field_76576_e = false;
        field_76573_f = new float[16];
        field_76574_g = 0;
        field_76580_h = new float[4];
    }

    public final void func_76558_a(World p_76558_1_)
    {
        field_76579_a = p_76558_1_;
        field_76577_b = p_76558_1_.func_72912_H().func_76067_t();
        func_76572_b();
        func_76556_a();
    }

    protected void func_76556_a()
    {
        float f = 0.0F;
        for(int i = 0; i <= 15; i++)
        {
            float f1 = 1.0F - (float)i / 15F;
            field_76573_f[i] = ((1.0F - f1) / (f1 * 3F + 1.0F)) * (1.0F - f) + f;
        }

    }

    protected void func_76572_b()
    {
        field_76578_c = field_76577_b.getChunkManager(field_76579_a);
    }

    public IChunkProvider func_76555_c()
    {
        return field_76577_b.getChunkGenerator(field_76579_a);
    }

    public boolean func_76566_a(int p_76566_1_, int p_76566_2_)
    {
        int i = field_76579_a.func_72922_b(p_76566_1_, p_76566_2_);
        return i == Block.field_71980_u.field_71990_ca;
    }

    public float func_76563_a(long p_76563_1_, float p_76563_3_)
    {
        int i = (int)(p_76563_1_ % 24000L);
        float f = ((float)i + p_76563_3_) / 24000F - 0.25F;
        if(f < 0.0F)
        {
            f++;
        }
        if(f > 1.0F)
        {
            f--;
        }
        float f1 = f;
        f = 1.0F - (float)((Math.cos((double)f * 3.1415926535897931D) + 1.0D) / 2D);
        f = f1 + (f - f1) / 3F;
        return f;
    }

    public boolean func_76569_d()
    {
        return true;
    }

    public boolean func_76567_e()
    {
        return true;
    }

    public static WorldProvider func_76570_a(int p_76570_0_)
    {
        return ((WorldProvider) (p_76570_0_ != -1 ? p_76570_0_ != 0 ? p_76570_0_ != 1 ? null : new WorldProviderEnd() : new WorldProviderSurface() : new WorldProviderHell()));
    }

    public ChunkCoordinates func_76554_h()
    {
        return null;
    }

    public int func_76557_i()
    {
        return field_76577_b.getSeaLevel(field_76579_a);
    }
}
