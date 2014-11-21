package net.minecraft.src;

import java.util.List;
import java.util.concurrent.Callable;

class CallableLvl2 implements Callable
{
    final World field_77405_a;

    CallableLvl2(World par1World)
    {
        field_77405_a = par1World;
    }

    public String func_77404_a()
    {
        return (new StringBuilder()).append(field_77405_a.playerEntities.size()).append(" total; ").append(field_77405_a.playerEntities.toString()).toString();
    }

    public Object call()
    {
        return func_77404_a();
    }
}
