package net.minecraft.src;

import java.util.concurrent.Callable;

class CallableLvl3 implements Callable
{
    /** Gets loaded Entities. */
    final World worldLvl3;

    CallableLvl3(World par1World)
    {
        worldLvl3 = par1World;
    }

    public String func_77439_a()
    {
        return worldLvl3.chunkProvider.makeString();
    }

    public Object call()
    {
        return func_77439_a();
    }
}
