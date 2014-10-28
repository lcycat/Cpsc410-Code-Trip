// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIWatchClosest, EntityPlayer, EntityVillager

public class EntityAILookAtTradePlayer extends EntityAIWatchClosest
{

    private final EntityVillager field_75335_b;

    public EntityAILookAtTradePlayer(EntityVillager p_i3474_1_)
    {
        super(p_i3474_1_, net.minecraft.src.EntityPlayer.class, 8F);
        field_75335_b = p_i3474_1_;
    }

    public boolean func_75250_a()
    {
        if(field_75335_b.func_70940_q())
        {
            field_75334_a = field_75335_b.func_70931_l_();
            return true;
        } else
        {
            return false;
        }
    }
}
