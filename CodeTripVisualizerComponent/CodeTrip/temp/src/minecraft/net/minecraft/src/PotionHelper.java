// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            PotionEffect, Potion

public class PotionHelper
{

    public static final String field_77924_a = null;
    public static final String field_77922_b = "-0+1-2-3&4-4+13";
    public static final String field_77923_c = "+0-1-2-3&4-4+13";
    public static final String field_77920_d = "-0-1+2-3&4-4+13";
    public static final String field_77921_e = "-0+3-4+13";
    public static final String field_77918_f = "+0-1+2-3&4-4+13";
    public static final String field_77919_g = "+0-1-2+3&4-4+13";
    public static final String field_77931_h = "+0+1-2-3&4-4+13";
    public static final String field_77932_i = "-5+6-7";
    public static final String field_77929_j = "+5-6-7";
    public static final String field_77930_k = "+14&13-13";
    private static final HashMap field_77927_l;
    private static final HashMap field_77928_m;
    private static final HashMap field_77925_n = new HashMap();
    private static final String field_77926_o[] = {
        "potion.prefix.mundane", "potion.prefix.uninteresting", "potion.prefix.bland", "potion.prefix.clear", "potion.prefix.milky", "potion.prefix.diffuse", "potion.prefix.artless", "potion.prefix.thin", "potion.prefix.awkward", "potion.prefix.flat", 
        "potion.prefix.bulky", "potion.prefix.bungling", "potion.prefix.buttered", "potion.prefix.smooth", "potion.prefix.suave", "potion.prefix.debonair", "potion.prefix.thick", "potion.prefix.elegant", "potion.prefix.fancy", "potion.prefix.charming", 
        "potion.prefix.dashing", "potion.prefix.refined", "potion.prefix.cordial", "potion.prefix.sparkling", "potion.prefix.potent", "potion.prefix.foul", "potion.prefix.odorless", "potion.prefix.rank", "potion.prefix.harsh", "potion.prefix.acrid", 
        "potion.prefix.gross", "potion.prefix.stinky"
    };

    public static boolean func_77914_a(int p_77914_0_, int p_77914_1_)
    {
        return (p_77914_0_ & 1 << p_77914_1_) != 0;
    }

    private static int func_77910_c(int p_77910_0_, int p_77910_1_)
    {
        return func_77914_a(p_77910_0_, p_77910_1_) ? 1 : 0;
    }

    private static int func_77916_d(int p_77916_0_, int p_77916_1_)
    {
        return func_77914_a(p_77916_0_, p_77916_1_) ? 0 : 1;
    }

    public static int func_77909_a(int p_77909_0_)
    {
        return func_77908_a(p_77909_0_, 5, 4, 3, 2, 1);
    }

    public static int func_77911_a(Collection p_77911_0_)
    {
        int i = 0x385dc6;
        if(p_77911_0_ == null || p_77911_0_.isEmpty())
        {
            return i;
        }
        float f = 0.0F;
        float f1 = 0.0F;
        float f2 = 0.0F;
        float f3 = 0.0F;
        for(Iterator iterator = p_77911_0_.iterator(); iterator.hasNext();)
        {
            PotionEffect potioneffect = (PotionEffect)iterator.next();
            int j = Potion.field_76425_a[potioneffect.func_76456_a()].func_76401_j();
            int k = 0;
            while(k <= potioneffect.func_76458_c()) 
            {
                f += (float)(j >> 16 & 0xff) / 255F;
                f1 += (float)(j >> 8 & 0xff) / 255F;
                f2 += (float)(j >> 0 & 0xff) / 255F;
                f3++;
                k++;
            }
        }

        f = (f / f3) * 255F;
        f1 = (f1 / f3) * 255F;
        f2 = (f2 / f3) * 255F;
        return (int)f << 16 | (int)f1 << 8 | (int)f2;
    }

    public static int func_77915_a(int p_77915_0_, boolean p_77915_1_)
    {
        if(!p_77915_1_)
        {
            if(field_77925_n.containsKey(Integer.valueOf(p_77915_0_)))
            {
                return ((Integer)field_77925_n.get(Integer.valueOf(p_77915_0_))).intValue();
            } else
            {
                int i = func_77911_a(func_77917_b(p_77915_0_, false));
                field_77925_n.put(Integer.valueOf(p_77915_0_), Integer.valueOf(i));
                return i;
            }
        } else
        {
            return func_77911_a(func_77917_b(p_77915_0_, p_77915_1_));
        }
    }

    public static String func_77905_c(int p_77905_0_)
    {
        int i = func_77909_a(p_77905_0_);
        return field_77926_o[i];
    }

    private static int func_77904_a(boolean p_77904_0_, boolean p_77904_1_, boolean p_77904_2_, int p_77904_3_, int p_77904_4_, int p_77904_5_, int p_77904_6_)
    {
        int i = 0;
        if(p_77904_0_)
        {
            i = func_77916_d(p_77904_6_, p_77904_4_);
        } else
        if(p_77904_3_ != -1)
        {
            if(p_77904_3_ == 0 && func_77907_h(p_77904_6_) == p_77904_4_)
            {
                i = 1;
            } else
            if(p_77904_3_ == 1 && func_77907_h(p_77904_6_) > p_77904_4_)
            {
                i = 1;
            } else
            if(p_77904_3_ == 2 && func_77907_h(p_77904_6_) < p_77904_4_)
            {
                i = 1;
            }
        } else
        {
            i = func_77910_c(p_77904_6_, p_77904_4_);
        }
        if(p_77904_1_)
        {
            i *= p_77904_5_;
        }
        if(p_77904_2_)
        {
            i *= -1;
        }
        return i;
    }

    private static int func_77907_h(int p_77907_0_)
    {
        int i;
        for(i = 0; p_77907_0_ > 0; i++)
        {
            p_77907_0_ &= p_77907_0_ - 1;
        }

        return i;
    }

    private static int func_77912_a(String p_77912_0_, int p_77912_1_, int p_77912_2_, int p_77912_3_)
    {
        if(p_77912_1_ >= p_77912_0_.length() || p_77912_2_ < 0 || p_77912_1_ >= p_77912_2_)
        {
            return 0;
        }
        int i = p_77912_0_.indexOf('|', p_77912_1_);
        if(i >= 0 && i < p_77912_2_)
        {
            int j = func_77912_a(p_77912_0_, p_77912_1_, i - 1, p_77912_3_);
            if(j > 0)
            {
                return j;
            }
            int l = func_77912_a(p_77912_0_, i + 1, p_77912_2_, p_77912_3_);
            if(l > 0)
            {
                return l;
            } else
            {
                return 0;
            }
        }
        int k = p_77912_0_.indexOf('&', p_77912_1_);
        if(k >= 0 && k < p_77912_2_)
        {
            int i1 = func_77912_a(p_77912_0_, p_77912_1_, k - 1, p_77912_3_);
            if(i1 <= 0)
            {
                return 0;
            }
            int j1 = func_77912_a(p_77912_0_, k + 1, p_77912_2_, p_77912_3_);
            if(j1 <= 0)
            {
                return 0;
            }
            if(i1 > j1)
            {
                return i1;
            } else
            {
                return j1;
            }
        }
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        byte byte0 = -1;
        int k1 = 0;
        int l1 = 0;
        int i2 = 0;
        for(int j2 = p_77912_1_; j2 < p_77912_2_; j2++)
        {
            char c = p_77912_0_.charAt(j2);
            if(c >= '0' && c <= '9')
            {
                if(flag)
                {
                    l1 = c - 48;
                    flag1 = true;
                } else
                {
                    k1 *= 10;
                    k1 += c - 48;
                    flag2 = true;
                }
                continue;
            }
            if(c == '*')
            {
                flag = true;
                continue;
            }
            if(c == '!')
            {
                if(flag2)
                {
                    i2 += func_77904_a(flag3, flag1, flag4, byte0, k1, l1, p_77912_3_);
                    flag2 = flag1 = flag = flag4 = flag3 = false;
                    k1 = l1 = 0;
                    byte0 = -1;
                }
                flag3 = true;
                continue;
            }
            if(c == '-')
            {
                if(flag2)
                {
                    i2 += func_77904_a(flag3, flag1, flag4, byte0, k1, l1, p_77912_3_);
                    flag2 = flag1 = flag = flag4 = flag3 = false;
                    k1 = l1 = 0;
                    byte0 = -1;
                }
                flag4 = true;
                continue;
            }
            if(c == '=' || c == '<' || c == '>')
            {
                if(flag2)
                {
                    i2 += func_77904_a(flag3, flag1, flag4, byte0, k1, l1, p_77912_3_);
                    flag2 = flag1 = flag = flag4 = flag3 = false;
                    k1 = l1 = 0;
                    byte0 = -1;
                }
                if(c == '=')
                {
                    byte0 = 0;
                    continue;
                }
                if(c == '<')
                {
                    byte0 = 2;
                    continue;
                }
                if(c == '>')
                {
                    byte0 = 1;
                }
                continue;
            }
            if(c == '+' && flag2)
            {
                i2 += func_77904_a(flag3, flag1, flag4, byte0, k1, l1, p_77912_3_);
                flag2 = flag1 = flag = flag4 = flag3 = false;
                k1 = l1 = 0;
                byte0 = -1;
            }
        }

        if(flag2)
        {
            i2 += func_77904_a(flag3, flag1, flag4, byte0, k1, l1, p_77912_3_);
        }
        return i2;
    }

    public static List func_77917_b(int p_77917_0_, boolean p_77917_1_)
    {
        ArrayList arraylist = null;
        Potion apotion[] = Potion.field_76425_a;
        int i = apotion.length;
        for(int j = 0; j < i; j++)
        {
            Potion potion = apotion[j];
            if(potion == null || potion.func_76395_i() && !p_77917_1_)
            {
                continue;
            }
            String s = (String)field_77927_l.get(Integer.valueOf(potion.func_76396_c()));
            if(s == null)
            {
                continue;
            }
            int k = func_77912_a(s, 0, s.length(), p_77917_0_);
            if(k <= 0)
            {
                continue;
            }
            int l = 0;
            String s1 = (String)field_77928_m.get(Integer.valueOf(potion.func_76396_c()));
            if(s1 != null)
            {
                l = func_77912_a(s1, 0, s1.length(), p_77917_0_);
                if(l < 0)
                {
                    l = 0;
                }
            }
            if(potion.func_76403_b())
            {
                k = 1;
            } else
            {
                k = 1200 * (k * 3 + (k - 1) * 2);
                k >>= l;
                k = (int)Math.round((double)k * potion.func_76388_g());
                if((p_77917_0_ & 0x4000) != 0)
                {
                    k = (int)Math.round((double)k * 0.75D + 0.5D);
                }
            }
            if(arraylist == null)
            {
                arraylist = new ArrayList();
            }
            arraylist.add(new PotionEffect(potion.func_76396_c(), k, l));
        }

        return arraylist;
    }

    private static int func_77906_a(int p_77906_0_, int p_77906_1_, boolean p_77906_2_, boolean p_77906_3_, boolean p_77906_4_)
    {
        if(p_77906_4_)
        {
            if(!func_77914_a(p_77906_0_, p_77906_1_))
            {
                return 0;
            }
        } else
        if(p_77906_2_)
        {
            p_77906_0_ &= ~(1 << p_77906_1_);
        } else
        if(p_77906_3_)
        {
            if((p_77906_0_ & 1 << p_77906_1_) == 0)
            {
                p_77906_0_ |= 1 << p_77906_1_;
            } else
            {
                p_77906_0_ &= ~(1 << p_77906_1_);
            }
        } else
        {
            p_77906_0_ |= 1 << p_77906_1_;
        }
        return p_77906_0_;
    }

    public static int func_77913_a(int p_77913_0_, String p_77913_1_)
    {
        boolean flag = false;
        int i = p_77913_1_.length();
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        int j = 0;
        for(int k = ((flag) ? 1 : 0); k < i; k++)
        {
            char c = p_77913_1_.charAt(k);
            if(c >= '0' && c <= '9')
            {
                j *= 10;
                j += c - 48;
                flag1 = true;
                continue;
            }
            if(c == '!')
            {
                if(flag1)
                {
                    p_77913_0_ = func_77906_a(p_77913_0_, j, flag3, flag2, flag4);
                    flag1 = flag3 = flag2 = flag4 = false;
                    j = 0;
                }
                flag2 = true;
                continue;
            }
            if(c == '-')
            {
                if(flag1)
                {
                    p_77913_0_ = func_77906_a(p_77913_0_, j, flag3, flag2, flag4);
                    flag1 = flag3 = flag2 = flag4 = false;
                    j = 0;
                }
                flag3 = true;
                continue;
            }
            if(c == '+')
            {
                if(flag1)
                {
                    p_77913_0_ = func_77906_a(p_77913_0_, j, flag3, flag2, flag4);
                    flag1 = flag3 = flag2 = flag4 = false;
                    j = 0;
                }
                continue;
            }
            if(c != '&')
            {
                continue;
            }
            if(flag1)
            {
                p_77913_0_ = func_77906_a(p_77913_0_, j, flag3, flag2, flag4);
                flag1 = flag3 = flag2 = flag4 = false;
                j = 0;
            }
            flag4 = true;
        }

        if(flag1)
        {
            p_77913_0_ = func_77906_a(p_77913_0_, j, flag3, flag2, flag4);
        }
        return p_77913_0_ & 0x7fff;
    }

    public static int func_77908_a(int p_77908_0_, int p_77908_1_, int p_77908_2_, int p_77908_3_, int p_77908_4_, int p_77908_5_)
    {
        return (func_77914_a(p_77908_0_, p_77908_1_) ? 0x10 : 0) | (func_77914_a(p_77908_0_, p_77908_2_) ? 8 : 0) | (func_77914_a(p_77908_0_, p_77908_3_) ? 4 : 0) | (func_77914_a(p_77908_0_, p_77908_4_) ? 2 : 0) | (func_77914_a(p_77908_0_, p_77908_5_) ? 1 : 0);
    }

    static 
    {
        field_77927_l = new HashMap();
        field_77928_m = new HashMap();
        field_77927_l.put(Integer.valueOf(Potion.field_76428_l.func_76396_c()), "0 & !1 & !2 & !3 & 0+6");
        field_77927_l.put(Integer.valueOf(Potion.field_76424_c.func_76396_c()), "!0 & 1 & !2 & !3 & 1+6");
        field_77927_l.put(Integer.valueOf(Potion.field_76426_n.func_76396_c()), "0 & 1 & !2 & !3 & 0+6");
        field_77927_l.put(Integer.valueOf(Potion.field_76432_h.func_76396_c()), "0 & !1 & 2 & !3");
        field_77927_l.put(Integer.valueOf(Potion.field_76436_u.func_76396_c()), "!0 & !1 & 2 & !3 & 2+6");
        field_77927_l.put(Integer.valueOf(Potion.field_76437_t.func_76396_c()), "!0 & !1 & !2 & 3 & 3+6");
        field_77927_l.put(Integer.valueOf(Potion.field_76433_i.func_76396_c()), "!0 & !1 & 2 & 3");
        field_77927_l.put(Integer.valueOf(Potion.field_76421_d.func_76396_c()), "!0 & 1 & !2 & 3 & 3+6");
        field_77927_l.put(Integer.valueOf(Potion.field_76420_g.func_76396_c()), "0 & !1 & !2 & 3 & 3+6");
        field_77928_m.put(Integer.valueOf(Potion.field_76424_c.func_76396_c()), "5");
        field_77928_m.put(Integer.valueOf(Potion.field_76422_e.func_76396_c()), "5");
        field_77928_m.put(Integer.valueOf(Potion.field_76420_g.func_76396_c()), "5");
        field_77928_m.put(Integer.valueOf(Potion.field_76428_l.func_76396_c()), "5");
        field_77928_m.put(Integer.valueOf(Potion.field_76433_i.func_76396_c()), "5");
        field_77928_m.put(Integer.valueOf(Potion.field_76432_h.func_76396_c()), "5");
        field_77928_m.put(Integer.valueOf(Potion.field_76429_m.func_76396_c()), "5");
        field_77928_m.put(Integer.valueOf(Potion.field_76436_u.func_76396_c()), "5");
    }
}
