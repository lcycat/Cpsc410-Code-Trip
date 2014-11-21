// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityRainFX, World

public class EntitySplashFX extends EntityRainFX
{

    public EntitySplashFX(World p_i3163_1_, double p_i3163_2_, double p_i3163_4_, double p_i3163_6_, 
            double p_i3163_8_, double p_i3163_10_, double p_i3163_12_)
    {
        super(p_i3163_1_, p_i3163_2_, p_i3163_4_, p_i3163_6_);
        field_70545_g = 0.04F;
        func_70536_a(func_70540_h() + 1);
        if(p_i3163_10_ == 0.0D && (p_i3163_8_ != 0.0D || p_i3163_12_ != 0.0D))
        {
            field_70159_w = p_i3163_8_;
            field_70181_x = p_i3163_10_ + 0.10000000000000001D;
            field_70179_y = p_i3163_12_;
        }
    }
}
