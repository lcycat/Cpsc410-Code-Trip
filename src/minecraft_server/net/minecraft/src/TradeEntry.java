package net.minecraft.src;

public class TradeEntry
{
    public final int id;
    public float chance;
    public boolean buying;
    public int min;
    public int max;

    public TradeEntry(int i, float f, boolean flag, int j, int k)
    {
        min = 0;
        max = 0;
        id = i;
        chance = f;
        buying = flag;
        min = j;
        max = k;
    }

    public TradeEntry(int i, float f, boolean flag)
    {
        this(i, f, flag, 0, 0);
    }
}
