// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ICamera, ClippingHelperImpl, ClippingHelper, AxisAlignedBB

public class Frustrum
    implements ICamera
{

    private ClippingHelper field_78552_a;
    private double field_78550_b;
    private double field_78551_c;
    private double field_78549_d;

    public Frustrum()
    {
        field_78552_a = ClippingHelperImpl.func_78558_a();
    }

    public void func_78547_a(double p_78547_1_, double p_78547_3_, double p_78547_5_)
    {
        field_78550_b = p_78547_1_;
        field_78551_c = p_78547_3_;
        field_78549_d = p_78547_5_;
    }

    public boolean func_78548_b(double p_78548_1_, double p_78548_3_, double p_78548_5_, double p_78548_7_, double p_78548_9_, double p_78548_11_)
    {
        return field_78552_a.func_78553_b(p_78548_1_ - field_78550_b, p_78548_3_ - field_78551_c, p_78548_5_ - field_78549_d, p_78548_7_ - field_78550_b, p_78548_9_ - field_78551_c, p_78548_11_ - field_78549_d);
    }

    public boolean func_78546_a(AxisAlignedBB p_78546_1_)
    {
        return func_78548_b(p_78546_1_.field_72340_a, p_78546_1_.field_72338_b, p_78546_1_.field_72339_c, p_78546_1_.field_72336_d, p_78546_1_.field_72337_e, p_78546_1_.field_72334_f);
    }
}
