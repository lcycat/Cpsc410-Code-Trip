// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayerIsland, GenLayerFuzzyZoom, GenLayerAddIsland, GenLayerZoom, 
//            GenLayerAddSnow, GenLayerAddMushroomIsland, WorldType, GenLayerRiverInit, 
//            GenLayerRiver, GenLayerSmooth, GenLayerBiome, GenLayerHills, 
//            GenLayerShore, GenLayerSwampRivers, GenLayerRiverMix, GenLayerVoronoiZoom

public abstract class GenLayer
{

    private long field_75907_b;
    protected GenLayer field_75909_a;
    private long field_75908_c;
    private long field_75906_d;

    public static GenLayer[] func_75901_a(long p_75901_0_, WorldType p_75901_2_)
    {
        Object obj = new GenLayerIsland(1L);
        obj = new GenLayerFuzzyZoom(2000L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(1L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2001L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(2L, ((GenLayer) (obj)));
        obj = new GenLayerAddSnow(2L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2002L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(3L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2003L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(4L, ((GenLayer) (obj)));
        obj = new GenLayerAddMushroomIsland(5L, ((GenLayer) (obj)));
        byte byte0 = 4;
        if(p_75901_2_ == WorldType.field_77135_d)
        {
            byte0 = 6;
        }
        Object obj1 = obj;
        obj1 = GenLayerZoom.func_75915_a(1000L, ((GenLayer) (obj1)), 0);
        obj1 = new GenLayerRiverInit(100L, ((GenLayer) (obj1)));
        obj1 = GenLayerZoom.func_75915_a(1000L, ((GenLayer) (obj1)), byte0 + 2);
        obj1 = new GenLayerRiver(1L, ((GenLayer) (obj1)));
        obj1 = new GenLayerSmooth(1000L, ((GenLayer) (obj1)));
        Object obj2 = obj;
        obj2 = GenLayerZoom.func_75915_a(1000L, ((GenLayer) (obj2)), 0);
        obj2 = new GenLayerBiome(200L, ((GenLayer) (obj2)), p_75901_2_);
        obj2 = GenLayerZoom.func_75915_a(1000L, ((GenLayer) (obj2)), 2);
        obj2 = new GenLayerHills(1000L, ((GenLayer) (obj2)));
        for(int i = 0; i < byte0; i++)
        {
            obj2 = new GenLayerZoom(1000 + i, ((GenLayer) (obj2)));
            if(i == 0)
            {
                obj2 = new GenLayerAddIsland(3L, ((GenLayer) (obj2)));
            }
            if(i == 1)
            {
                obj2 = new GenLayerShore(1000L, ((GenLayer) (obj2)));
            }
            if(i == 1)
            {
                obj2 = new GenLayerSwampRivers(1000L, ((GenLayer) (obj2)));
            }
        }

        obj2 = new GenLayerSmooth(1000L, ((GenLayer) (obj2)));
        obj2 = new GenLayerRiverMix(100L, ((GenLayer) (obj2)), ((GenLayer) (obj1)));
        GenLayerRiverMix genlayerrivermix = ((GenLayerRiverMix) (obj2));
        GenLayerVoronoiZoom genlayervoronoizoom = new GenLayerVoronoiZoom(10L, ((GenLayer) (obj2)));
        ((GenLayer) (obj2)).func_75905_a(p_75901_0_);
        genlayervoronoizoom.func_75905_a(p_75901_0_);
        return (new GenLayer[] {
            obj2, genlayervoronoizoom, genlayerrivermix
        });
    }

    public GenLayer(long p_i3891_1_)
    {
        field_75906_d = p_i3891_1_;
        field_75906_d *= field_75906_d * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75906_d += p_i3891_1_;
        field_75906_d *= field_75906_d * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75906_d += p_i3891_1_;
        field_75906_d *= field_75906_d * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75906_d += p_i3891_1_;
    }

    public void func_75905_a(long p_75905_1_)
    {
        field_75907_b = p_75905_1_;
        if(field_75909_a != null)
        {
            field_75909_a.func_75905_a(p_75905_1_);
        }
        field_75907_b *= field_75907_b * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75907_b += field_75906_d;
        field_75907_b *= field_75907_b * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75907_b += field_75906_d;
        field_75907_b *= field_75907_b * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75907_b += field_75906_d;
    }

    public void func_75903_a(long p_75903_1_, long p_75903_3_)
    {
        field_75908_c = field_75907_b;
        field_75908_c *= field_75908_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75908_c += p_75903_1_;
        field_75908_c *= field_75908_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75908_c += p_75903_3_;
        field_75908_c *= field_75908_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75908_c += p_75903_1_;
        field_75908_c *= field_75908_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75908_c += p_75903_3_;
    }

    protected int func_75902_a(int p_75902_1_)
    {
        int i = (int)((field_75908_c >> 24) % (long)p_75902_1_);
        if(i < 0)
        {
            i += p_75902_1_;
        }
        field_75908_c *= field_75908_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_75908_c += field_75907_b;
        return i;
    }

    public abstract int[] func_75904_a(int i, int j, int k, int l);
}
