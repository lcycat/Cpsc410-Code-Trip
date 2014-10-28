// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class StructureBoundingBox
{

    public int field_78897_a;
    public int field_78895_b;
    public int field_78896_c;
    public int field_78893_d;
    public int field_78894_e;
    public int field_78892_f;

    public StructureBoundingBox()
    {
    }

    public static StructureBoundingBox func_78887_a()
    {
        return new StructureBoundingBox(0x7fffffff, 0x7fffffff, 0x7fffffff, 0x80000000, 0x80000000, 0x80000000);
    }

    public static StructureBoundingBox func_78889_a(int p_78889_0_, int p_78889_1_, int p_78889_2_, int p_78889_3_, int p_78889_4_, int p_78889_5_, int p_78889_6_, int p_78889_7_, 
            int p_78889_8_, int p_78889_9_)
    {
        switch(p_78889_9_)
        {
        default:
            return new StructureBoundingBox(p_78889_0_ + p_78889_3_, p_78889_1_ + p_78889_4_, p_78889_2_ + p_78889_5_, ((p_78889_0_ + p_78889_6_) - 1) + p_78889_3_, ((p_78889_1_ + p_78889_7_) - 1) + p_78889_4_, ((p_78889_2_ + p_78889_8_) - 1) + p_78889_5_);

        case 2: // '\002'
            return new StructureBoundingBox(p_78889_0_ + p_78889_3_, p_78889_1_ + p_78889_4_, (p_78889_2_ - p_78889_8_) + 1 + p_78889_5_, ((p_78889_0_ + p_78889_6_) - 1) + p_78889_3_, ((p_78889_1_ + p_78889_7_) - 1) + p_78889_4_, p_78889_2_ + p_78889_5_);

        case 0: // '\0'
            return new StructureBoundingBox(p_78889_0_ + p_78889_3_, p_78889_1_ + p_78889_4_, p_78889_2_ + p_78889_5_, ((p_78889_0_ + p_78889_6_) - 1) + p_78889_3_, ((p_78889_1_ + p_78889_7_) - 1) + p_78889_4_, ((p_78889_2_ + p_78889_8_) - 1) + p_78889_5_);

        case 1: // '\001'
            return new StructureBoundingBox((p_78889_0_ - p_78889_8_) + 1 + p_78889_5_, p_78889_1_ + p_78889_4_, p_78889_2_ + p_78889_3_, p_78889_0_ + p_78889_5_, ((p_78889_1_ + p_78889_7_) - 1) + p_78889_4_, ((p_78889_2_ + p_78889_6_) - 1) + p_78889_3_);

        case 3: // '\003'
            return new StructureBoundingBox(p_78889_0_ + p_78889_5_, p_78889_1_ + p_78889_4_, p_78889_2_ + p_78889_3_, ((p_78889_0_ + p_78889_8_) - 1) + p_78889_5_, ((p_78889_1_ + p_78889_7_) - 1) + p_78889_4_, ((p_78889_2_ + p_78889_6_) - 1) + p_78889_3_);
        }
    }

    public StructureBoundingBox(StructureBoundingBox p_i3804_1_)
    {
        field_78897_a = p_i3804_1_.field_78897_a;
        field_78895_b = p_i3804_1_.field_78895_b;
        field_78896_c = p_i3804_1_.field_78896_c;
        field_78893_d = p_i3804_1_.field_78893_d;
        field_78894_e = p_i3804_1_.field_78894_e;
        field_78892_f = p_i3804_1_.field_78892_f;
    }

    public StructureBoundingBox(int p_i3805_1_, int p_i3805_2_, int p_i3805_3_, int p_i3805_4_, int p_i3805_5_, int p_i3805_6_)
    {
        field_78897_a = p_i3805_1_;
        field_78895_b = p_i3805_2_;
        field_78896_c = p_i3805_3_;
        field_78893_d = p_i3805_4_;
        field_78894_e = p_i3805_5_;
        field_78892_f = p_i3805_6_;
    }

    public StructureBoundingBox(int p_i3806_1_, int p_i3806_2_, int p_i3806_3_, int p_i3806_4_)
    {
        field_78897_a = p_i3806_1_;
        field_78896_c = p_i3806_2_;
        field_78893_d = p_i3806_3_;
        field_78892_f = p_i3806_4_;
        field_78895_b = 1;
        field_78894_e = 512;
    }

    public boolean func_78884_a(StructureBoundingBox p_78884_1_)
    {
        return field_78893_d >= p_78884_1_.field_78897_a && field_78897_a <= p_78884_1_.field_78893_d && field_78892_f >= p_78884_1_.field_78896_c && field_78896_c <= p_78884_1_.field_78892_f && field_78894_e >= p_78884_1_.field_78895_b && field_78895_b <= p_78884_1_.field_78894_e;
    }

    public boolean func_78885_a(int p_78885_1_, int p_78885_2_, int p_78885_3_, int p_78885_4_)
    {
        return field_78893_d >= p_78885_1_ && field_78897_a <= p_78885_3_ && field_78892_f >= p_78885_2_ && field_78896_c <= p_78885_4_;
    }

    public void func_78888_b(StructureBoundingBox p_78888_1_)
    {
        field_78897_a = Math.min(field_78897_a, p_78888_1_.field_78897_a);
        field_78895_b = Math.min(field_78895_b, p_78888_1_.field_78895_b);
        field_78896_c = Math.min(field_78896_c, p_78888_1_.field_78896_c);
        field_78893_d = Math.max(field_78893_d, p_78888_1_.field_78893_d);
        field_78894_e = Math.max(field_78894_e, p_78888_1_.field_78894_e);
        field_78892_f = Math.max(field_78892_f, p_78888_1_.field_78892_f);
    }

    public void func_78886_a(int p_78886_1_, int p_78886_2_, int p_78886_3_)
    {
        field_78897_a += p_78886_1_;
        field_78895_b += p_78886_2_;
        field_78896_c += p_78886_3_;
        field_78893_d += p_78886_1_;
        field_78894_e += p_78886_2_;
        field_78892_f += p_78886_3_;
    }

    public boolean func_78890_b(int p_78890_1_, int p_78890_2_, int p_78890_3_)
    {
        return p_78890_1_ >= field_78897_a && p_78890_1_ <= field_78893_d && p_78890_3_ >= field_78896_c && p_78890_3_ <= field_78892_f && p_78890_2_ >= field_78895_b && p_78890_2_ <= field_78894_e;
    }

    public int func_78883_b()
    {
        return (field_78893_d - field_78897_a) + 1;
    }

    public int func_78882_c()
    {
        return (field_78894_e - field_78895_b) + 1;
    }

    public int func_78880_d()
    {
        return (field_78892_f - field_78896_c) + 1;
    }

    public int func_78881_e()
    {
        return field_78897_a + ((field_78893_d - field_78897_a) + 1) / 2;
    }

    public int func_78879_f()
    {
        return field_78895_b + ((field_78894_e - field_78895_b) + 1) / 2;
    }

    public int func_78891_g()
    {
        return field_78896_c + ((field_78892_f - field_78896_c) + 1) / 2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("(").append(field_78897_a).append(", ").append(field_78895_b).append(", ").append(field_78896_c).append("; ").append(field_78893_d).append(", ").append(field_78894_e).append(", ").append(field_78892_f).append(")").toString();
    }
}
