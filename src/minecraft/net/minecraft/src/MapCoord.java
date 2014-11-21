package net.minecraft.src;

public class MapCoord
{
    public byte iconSize;
    public byte centerX;
    public byte centerZ;
    public byte iconRotation;
    final MapData data;

    public MapCoord(MapData par1MapData, byte par2, byte par3, byte par4, byte par5)
    {
        data = par1MapData;
        iconSize = par2;
        centerX = par3;
        centerZ = par4;
        iconRotation = par5;
    }
}
