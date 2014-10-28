package net.minecraft.src;

import java.util.List;
import java.util.concurrent.Callable;

class CallableLvl1 implements Callable
{
    final World field_77485_a;

    CallableLvl1(World par1World)
    {
        field_77485_a = par1World;
    }

    public String func_77484_a()
    {
        return (new StringBuilder()).append(field_77485_a.loadedEntityList.size()).append(" total; ").append(field_77485_a.loadedEntityList.toString()).toString();
    }

    public Object call()
    {
        return func_77484_a();
    }
}
