// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            WorldChunkManagerHell, BiomeGenBase, WorldChunkManager, ChunkProviderFlat, 
//            World, WorldInfo, ChunkProviderGenerate, IChunkProvider

public class WorldType
{

    public static final WorldType field_77139_a[] = new WorldType[16];
    public static final WorldType field_77137_b = (new WorldType(0, "default", 1)).func_77129_f();
    public static final WorldType field_77138_c = new WorldType(1, "flat");
    public static final WorldType field_77135_d = new WorldType(2, "largeBiomes");
    public static final WorldType field_77136_e = (new WorldType(8, "default_1_1", 0)).func_77124_a(false);
    private final String field_77133_f;
    private final int field_77134_g;
    private boolean field_77140_h;
    private boolean field_77141_i;

    public WorldType(int p_i3737_1_, String p_i3737_2_)
    {
        this(p_i3737_1_, p_i3737_2_, 0);
    }

    public WorldType(int p_i3738_1_, String p_i3738_2_, int p_i3738_3_)
    {
        field_77133_f = p_i3738_2_;
        field_77134_g = p_i3738_3_;
        field_77140_h = true;
        field_77139_a[p_i3738_1_] = this;
    }

    public String func_77127_a()
    {
        return field_77133_f;
    }

    public String func_77128_b()
    {
        return (new StringBuilder()).append("generator.").append(field_77133_f).toString();
    }

    public int func_77131_c()
    {
        return field_77134_g;
    }

    public WorldType func_77132_a(int p_77132_1_)
    {
        if(this == field_77137_b && p_77132_1_ == 0)
        {
            return field_77136_e;
        } else
        {
            return this;
        }
    }

    private WorldType func_77124_a(boolean p_77124_1_)
    {
        field_77140_h = p_77124_1_;
        return this;
    }

    public boolean func_77126_d()
    {
        return field_77140_h;
    }

    private WorldType func_77129_f()
    {
        field_77141_i = true;
        return this;
    }

    public boolean func_77125_e()
    {
        return field_77141_i;
    }

    public static WorldType func_77130_a(String p_77130_0_)
    {
        WorldType aworldtype[] = field_77139_a;
        int i = aworldtype.length;
        for(int j = 0; j < i; j++)
        {
            WorldType worldtype = aworldtype[j];
            if(worldtype != null && worldtype.field_77133_f.equalsIgnoreCase(p_77130_0_))
            {
                return worldtype;
            }
        }

        return null;
    }

    public WorldChunkManager getChunkManager(World world)
    {
        if(this == field_77138_c)
        {
            return new WorldChunkManagerHell(BiomeGenBase.field_76772_c, 0.5F, 0.5F);
        } else
        {
            return new WorldChunkManager(world);
        }
    }

    public IChunkProvider getChunkGenerator(World world)
    {
        if(this == field_77138_c)
        {
            return new ChunkProviderFlat(world, world.func_72905_C(), world.func_72912_H().func_76089_r());
        } else
        {
            return new ChunkProviderGenerate(world, world.func_72905_C(), world.func_72912_H().func_76089_r());
        }
    }

    public int getSeaLevel(World world)
    {
        return this == field_77138_c ? 4 : 64;
    }

    public boolean hasVoidParticles(boolean flag)
    {
        return this != field_77138_c && !flag;
    }

    public double voidFadeMagnitude()
    {
        return this == field_77138_c ? 1.0D : 0.03125D;
    }

}
