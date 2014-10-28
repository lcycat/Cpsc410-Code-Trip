// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            World, WorldInfo, WorldType, Block, 
//            BlockGrass, MathHelper, Vec3, Vec3Pool, 
//            WorldProviderHell, WorldProviderSurface, WorldProviderEnd, WorldChunkManager, 
//            IChunkProvider, ChunkCoordinates

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

    public int func_76559_b(long p_76559_1_, float p_76559_3_)
    {
        return (int)(p_76559_1_ / 24000L) % 8;
    }

    public boolean func_76569_d()
    {
        return true;
    }

    public float[] func_76560_a(float p_76560_1_, float p_76560_2_)
    {
        float f = 0.4F;
        float f1 = MathHelper.func_76134_b(p_76560_1_ * 3.141593F * 2.0F) - 0.0F;
        float f2 = -0F;
        if(f1 >= f2 - f && f1 <= f2 + f)
        {
            float f3 = ((f1 - f2) / f) * 0.5F + 0.5F;
            float f4 = 1.0F - (1.0F - MathHelper.func_76126_a(f3 * 3.141593F)) * 0.99F;
            f4 *= f4;
            field_76580_h[0] = f3 * 0.3F + 0.7F;
            field_76580_h[1] = f3 * f3 * 0.7F + 0.2F;
            field_76580_h[2] = f3 * f3 * 0.0F + 0.2F;
            field_76580_h[3] = f4;
            return field_76580_h;
        } else
        {
            return null;
        }
    }

    public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_)
    {
        float f = MathHelper.func_76134_b(p_76562_1_ * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f < 0.0F)
        {
            f = 0.0F;
        }
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        float f1 = 0.7529412F;
        float f2 = 0.8470588F;
        float f3 = 1.0F;
        f1 *= f * 0.94F + 0.06F;
        f2 *= f * 0.94F + 0.06F;
        f3 *= f * 0.91F + 0.09F;
        return Vec3.func_72437_a().func_72345_a(f1, f2, f3);
    }

    public boolean func_76567_e()
    {
        return true;
    }

    public static WorldProvider func_76570_a(int p_76570_0_)
    {
        if(p_76570_0_ == -1)
        {
            return new WorldProviderHell();
        }
        if(p_76570_0_ == 0)
        {
            return new WorldProviderSurface();
        }
        if(p_76570_0_ == 1)
        {
            return new WorldProviderEnd();
        } else
        {
            return null;
        }
    }

    public float func_76571_f()
    {
        return 128F;
    }

    public boolean func_76561_g()
    {
        return true;
    }

    public ChunkCoordinates func_76554_h()
    {
        return null;
    }

    public int func_76557_i()
    {
        return field_76577_b.getSeaLevel(field_76579_a);
    }

    public boolean func_76564_j()
    {
        return field_76577_b.hasVoidParticles(field_76576_e);
    }

    public double func_76565_k()
    {
        return field_76577_b.voidFadeMagnitude();
    }

    public boolean func_76568_b(int p_76568_1_, int p_76568_2_)
    {
        return false;
    }
}
