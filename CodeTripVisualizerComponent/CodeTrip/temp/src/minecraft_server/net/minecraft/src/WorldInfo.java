// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            WorldType, NBTTagCompound, EnumGameType, WorldSettings

public class WorldInfo
{

    private long field_76100_a;
    private WorldType field_76098_b;
    private int field_76099_c;
    private int field_76096_d;
    private int field_76097_e;
    private long field_76094_f;
    private long field_76095_g;
    private long field_76107_h;
    private NBTTagCompound field_76108_i;
    private int field_76105_j;
    private String field_76106_k;
    private int field_76103_l;
    private boolean field_76104_m;
    private int field_76101_n;
    private boolean field_76102_o;
    private int field_76114_p;
    private EnumGameType field_76113_q;
    private boolean field_76112_r;
    private boolean field_76111_s;
    private boolean field_76110_t;
    private boolean field_76109_u;

    protected WorldInfo()
    {
        field_76098_b = WorldType.field_77137_b;
    }

    public WorldInfo(NBTTagCompound p_i3914_1_)
    {
        field_76098_b = WorldType.field_77137_b;
        field_76100_a = p_i3914_1_.func_74763_f("RandomSeed");
        if(p_i3914_1_.func_74764_b("generatorName"))
        {
            String s = p_i3914_1_.func_74779_i("generatorName");
            field_76098_b = WorldType.func_77130_a(s);
            if(field_76098_b == null)
            {
                field_76098_b = WorldType.field_77137_b;
            } else
            if(field_76098_b.func_77125_e())
            {
                int i = 0;
                if(p_i3914_1_.func_74764_b("generatorVersion"))
                {
                    i = p_i3914_1_.func_74762_e("generatorVersion");
                }
                field_76098_b = field_76098_b.func_77132_a(i);
            }
        }
        field_76113_q = EnumGameType.func_77146_a(p_i3914_1_.func_74762_e("GameType"));
        if(p_i3914_1_.func_74764_b("MapFeatures"))
        {
            field_76112_r = p_i3914_1_.func_74767_n("MapFeatures");
        } else
        {
            field_76112_r = true;
        }
        field_76099_c = p_i3914_1_.func_74762_e("SpawnX");
        field_76096_d = p_i3914_1_.func_74762_e("SpawnY");
        field_76097_e = p_i3914_1_.func_74762_e("SpawnZ");
        field_76094_f = p_i3914_1_.func_74763_f("Time");
        field_76095_g = p_i3914_1_.func_74763_f("LastPlayed");
        field_76107_h = p_i3914_1_.func_74763_f("SizeOnDisk");
        field_76106_k = p_i3914_1_.func_74779_i("LevelName");
        field_76103_l = p_i3914_1_.func_74762_e("version");
        field_76101_n = p_i3914_1_.func_74762_e("rainTime");
        field_76104_m = p_i3914_1_.func_74767_n("raining");
        field_76114_p = p_i3914_1_.func_74762_e("thunderTime");
        field_76102_o = p_i3914_1_.func_74767_n("thundering");
        field_76111_s = p_i3914_1_.func_74767_n("hardcore");
        if(p_i3914_1_.func_74764_b("initialized"))
        {
            field_76109_u = p_i3914_1_.func_74767_n("initialized");
        } else
        {
            field_76109_u = true;
        }
        if(p_i3914_1_.func_74764_b("allowCommands"))
        {
            field_76110_t = p_i3914_1_.func_74767_n("allowCommands");
        } else
        {
            field_76110_t = field_76113_q == EnumGameType.CREATIVE;
        }
        if(p_i3914_1_.func_74764_b("Player"))
        {
            field_76108_i = p_i3914_1_.func_74775_l("Player");
            field_76105_j = field_76108_i.func_74762_e("Dimension");
        }
    }

    public WorldInfo(WorldSettings p_i3915_1_, String p_i3915_2_)
    {
        field_76098_b = WorldType.field_77137_b;
        field_76100_a = p_i3915_1_.func_77160_d();
        field_76113_q = p_i3915_1_.func_77162_e();
        field_76112_r = p_i3915_1_.func_77164_g();
        field_76106_k = p_i3915_2_;
        field_76111_s = p_i3915_1_.func_77158_f();
        field_76098_b = p_i3915_1_.func_77165_h();
        field_76110_t = p_i3915_1_.func_77163_i();
        field_76109_u = false;
    }

    public WorldInfo(WorldInfo p_i3916_1_)
    {
        field_76098_b = WorldType.field_77137_b;
        field_76100_a = p_i3916_1_.field_76100_a;
        field_76098_b = p_i3916_1_.field_76098_b;
        field_76113_q = p_i3916_1_.field_76113_q;
        field_76112_r = p_i3916_1_.field_76112_r;
        field_76099_c = p_i3916_1_.field_76099_c;
        field_76096_d = p_i3916_1_.field_76096_d;
        field_76097_e = p_i3916_1_.field_76097_e;
        field_76094_f = p_i3916_1_.field_76094_f;
        field_76095_g = p_i3916_1_.field_76095_g;
        field_76107_h = p_i3916_1_.field_76107_h;
        field_76108_i = p_i3916_1_.field_76108_i;
        field_76105_j = p_i3916_1_.field_76105_j;
        field_76106_k = p_i3916_1_.field_76106_k;
        field_76103_l = p_i3916_1_.field_76103_l;
        field_76101_n = p_i3916_1_.field_76101_n;
        field_76104_m = p_i3916_1_.field_76104_m;
        field_76114_p = p_i3916_1_.field_76114_p;
        field_76102_o = p_i3916_1_.field_76102_o;
        field_76111_s = p_i3916_1_.field_76111_s;
        field_76110_t = p_i3916_1_.field_76110_t;
        field_76109_u = p_i3916_1_.field_76109_u;
    }

    public NBTTagCompound func_76066_a()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        func_76064_a(nbttagcompound, field_76108_i);
        return nbttagcompound;
    }

    public NBTTagCompound func_76082_a(NBTTagCompound p_76082_1_)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        func_76064_a(nbttagcompound, p_76082_1_);
        return nbttagcompound;
    }

    private void func_76064_a(NBTTagCompound p_76064_1_, NBTTagCompound p_76064_2_)
    {
        p_76064_1_.func_74772_a("RandomSeed", field_76100_a);
        p_76064_1_.func_74778_a("generatorName", field_76098_b.func_77127_a());
        p_76064_1_.func_74768_a("generatorVersion", field_76098_b.func_77131_c());
        p_76064_1_.func_74768_a("GameType", field_76113_q.func_77148_a());
        p_76064_1_.func_74757_a("MapFeatures", field_76112_r);
        p_76064_1_.func_74768_a("SpawnX", field_76099_c);
        p_76064_1_.func_74768_a("SpawnY", field_76096_d);
        p_76064_1_.func_74768_a("SpawnZ", field_76097_e);
        p_76064_1_.func_74772_a("Time", field_76094_f);
        p_76064_1_.func_74772_a("SizeOnDisk", field_76107_h);
        p_76064_1_.func_74772_a("LastPlayed", System.currentTimeMillis());
        p_76064_1_.func_74778_a("LevelName", field_76106_k);
        p_76064_1_.func_74768_a("version", field_76103_l);
        p_76064_1_.func_74768_a("rainTime", field_76101_n);
        p_76064_1_.func_74757_a("raining", field_76104_m);
        p_76064_1_.func_74768_a("thunderTime", field_76114_p);
        p_76064_1_.func_74757_a("thundering", field_76102_o);
        p_76064_1_.func_74757_a("hardcore", field_76111_s);
        p_76064_1_.func_74757_a("allowCommands", field_76110_t);
        p_76064_1_.func_74757_a("initialized", field_76109_u);
        if(p_76064_2_ != null)
        {
            p_76064_1_.func_74766_a("Player", p_76064_2_);
        }
    }

    public long func_76063_b()
    {
        return field_76100_a;
    }

    public int func_76079_c()
    {
        return field_76099_c;
    }

    public int func_76075_d()
    {
        return field_76096_d;
    }

    public int func_76074_e()
    {
        return field_76097_e;
    }

    public long func_76073_f()
    {
        return field_76094_f;
    }

    public NBTTagCompound func_76072_h()
    {
        return field_76108_i;
    }

    public int func_76076_i()
    {
        return field_76105_j;
    }

    public void func_76068_b(long p_76068_1_)
    {
        field_76094_f = p_76068_1_;
    }

    public void func_76081_a(int p_76081_1_, int p_76081_2_, int p_76081_3_)
    {
        field_76099_c = p_76081_1_;
        field_76096_d = p_76081_2_;
        field_76097_e = p_76081_3_;
    }

    public String func_76065_j()
    {
        return field_76106_k;
    }

    public void func_76062_a(String p_76062_1_)
    {
        field_76106_k = p_76062_1_;
    }

    public int func_76088_k()
    {
        return field_76103_l;
    }

    public void func_76078_e(int p_76078_1_)
    {
        field_76103_l = p_76078_1_;
    }

    public boolean func_76061_m()
    {
        return field_76102_o;
    }

    public void func_76069_a(boolean p_76069_1_)
    {
        field_76102_o = p_76069_1_;
    }

    public int func_76071_n()
    {
        return field_76114_p;
    }

    public void func_76090_f(int p_76090_1_)
    {
        field_76114_p = p_76090_1_;
    }

    public boolean func_76059_o()
    {
        return field_76104_m;
    }

    public void func_76084_b(boolean p_76084_1_)
    {
        field_76104_m = p_76084_1_;
    }

    public int func_76083_p()
    {
        return field_76101_n;
    }

    public void func_76080_g(int p_76080_1_)
    {
        field_76101_n = p_76080_1_;
    }

    public EnumGameType func_76077_q()
    {
        return field_76113_q;
    }

    public boolean func_76089_r()
    {
        return field_76112_r;
    }

    public void func_76060_a(EnumGameType p_76060_1_)
    {
        field_76113_q = p_76060_1_;
    }

    public boolean func_76093_s()
    {
        return field_76111_s;
    }

    public WorldType func_76067_t()
    {
        return field_76098_b;
    }

    public void func_76085_a(WorldType p_76085_1_)
    {
        field_76098_b = p_76085_1_;
    }

    public boolean func_76086_u()
    {
        return field_76110_t;
    }

    public boolean func_76070_v()
    {
        return field_76109_u;
    }

    public void func_76091_d(boolean p_76091_1_)
    {
        field_76109_u = p_76091_1_;
    }
}
