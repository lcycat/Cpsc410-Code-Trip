// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            StatBase, ItemStack, AchievementList, StatCollector, 
//            IStatStringFormat, Item, Block

public class Achievement extends StatBase
{

    public final int field_75993_a;
    public final int field_75991_b;
    public final Achievement field_75992_c;
    private final String field_75996_k;
    private IStatStringFormat field_75994_l;
    public final ItemStack field_75990_d;
    private boolean field_75995_m;

    public Achievement(int p_i3409_1_, String p_i3409_2_, int p_i3409_3_, int p_i3409_4_, Item p_i3409_5_, Achievement p_i3409_6_)
    {
        this(p_i3409_1_, p_i3409_2_, p_i3409_3_, p_i3409_4_, new ItemStack(p_i3409_5_), p_i3409_6_);
    }

    public Achievement(int p_i3410_1_, String p_i3410_2_, int p_i3410_3_, int p_i3410_4_, Block p_i3410_5_, Achievement p_i3410_6_)
    {
        this(p_i3410_1_, p_i3410_2_, p_i3410_3_, p_i3410_4_, new ItemStack(p_i3410_5_), p_i3410_6_);
    }

    public Achievement(int p_i3411_1_, String p_i3411_2_, int p_i3411_3_, int p_i3411_4_, ItemStack p_i3411_5_, Achievement p_i3411_6_)
    {
        super(0x500000 + p_i3411_1_, (new StringBuilder()).append("achievement.").append(p_i3411_2_).toString());
        field_75990_d = p_i3411_5_;
        field_75996_k = (new StringBuilder()).append("achievement.").append(p_i3411_2_).append(".desc").toString();
        field_75993_a = p_i3411_3_;
        field_75991_b = p_i3411_4_;
        if(p_i3411_3_ < AchievementList.field_76010_a)
        {
            AchievementList.field_76010_a = p_i3411_3_;
        }
        if(p_i3411_4_ < AchievementList.field_76008_b)
        {
            AchievementList.field_76008_b = p_i3411_4_;
        }
        if(p_i3411_3_ > AchievementList.field_76009_c)
        {
            AchievementList.field_76009_c = p_i3411_3_;
        }
        if(p_i3411_4_ > AchievementList.field_76006_d)
        {
            AchievementList.field_76006_d = p_i3411_4_;
        }
        field_75992_c = p_i3411_6_;
    }

    public Achievement func_75986_a()
    {
        field_75972_f = true;
        return this;
    }

    public Achievement func_75987_b()
    {
        field_75995_m = true;
        return this;
    }

    public Achievement func_75985_c()
    {
        super.func_75971_g();
        AchievementList.field_76007_e.add(this);
        return this;
    }

    public boolean func_75967_d()
    {
        return true;
    }

    public String func_75989_e()
    {
        if(field_75994_l != null)
        {
            return field_75994_l.func_74535_a(StatCollector.func_74838_a(field_75996_k));
        } else
        {
            return StatCollector.func_74838_a(field_75996_k);
        }
    }

    public Achievement func_75988_a(IStatStringFormat p_75988_1_)
    {
        field_75994_l = p_75988_1_;
        return this;
    }

    public boolean func_75984_f()
    {
        return field_75995_m;
    }

    public StatBase func_75971_g()
    {
        return func_75985_c();
    }

    public StatBase func_75966_h()
    {
        return func_75986_a();
    }
}
