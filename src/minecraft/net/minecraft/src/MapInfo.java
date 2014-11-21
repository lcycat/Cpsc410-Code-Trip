package net.minecraft.src;

import java.util.List;

public class MapInfo
{
    /** Reference for EntityPlayer object in MapInfo */
    public final EntityPlayer entityplayerObj;
    public int field_76209_b[];
    public int field_76210_c[];

    /**
     * updated by x = mod(x*11,128) +1  x-1 is used to index field_76209_b and field_76210_c
     */
    private int currentRandomNumber;
    private int ticksUntilPlayerLocationMapUpdate;
    private byte lastPlayerLocationOnMap[];

    /** reference in MapInfo to MapData object */
    final MapData mapDataObj;

    public MapInfo(MapData par1MapData, EntityPlayer par2EntityPlayer)
    {
        mapDataObj = par1MapData;
        field_76209_b = new int[128];
        field_76210_c = new int[128];
        currentRandomNumber = 0;
        ticksUntilPlayerLocationMapUpdate = 0;
        entityplayerObj = par2EntityPlayer;

        for (int i = 0; i < field_76209_b.length; i++)
        {
            field_76209_b[i] = 0;
            field_76210_c[i] = 127;
        }
    }

    /**
     * returns a 1+players*3 array, of x,y, and color . the name of this function may be partially wrong, as there is a
     * second branch to the code here
     */
    public byte[] getPlayersOnMap(ItemStack par1ItemStack)
    {
        if (--ticksUntilPlayerLocationMapUpdate < 0)
        {
            ticksUntilPlayerLocationMapUpdate = 4;
            byte abyte0[] = new byte[mapDataObj.playersVisibleOnMap.size() * 3 + 1];
            abyte0[0] = 1;

            for (int j = 0; j < mapDataObj.playersVisibleOnMap.size(); j++)
            {
                MapCoord mapcoord = (MapCoord)mapDataObj.playersVisibleOnMap.get(j);
                abyte0[j * 3 + 1] = (byte)(mapcoord.iconSize + (mapcoord.iconRotation & 0xf) * 16);
                abyte0[j * 3 + 2] = mapcoord.centerX;
                abyte0[j * 3 + 3] = mapcoord.centerZ;
            }

            boolean flag = true;

            if (lastPlayerLocationOnMap == null || lastPlayerLocationOnMap.length != abyte0.length)
            {
                flag = false;
            }
            else
            {
                int l = 0;

                do
                {
                    if (l >= abyte0.length)
                    {
                        break;
                    }

                    if (abyte0[l] != lastPlayerLocationOnMap[l])
                    {
                        flag = false;
                        break;
                    }

                    l++;
                }
                while (true);
            }

            if (!flag)
            {
                lastPlayerLocationOnMap = abyte0;
                return abyte0;
            }
        }

        for (int i = 0; i < 10; i++)
        {
            int k = (currentRandomNumber * 11) % 128;
            currentRandomNumber++;

            if (field_76209_b[k] >= 0)
            {
                int i1 = (field_76210_c[k] - field_76209_b[k]) + 1;
                int j1 = field_76209_b[k];
                byte abyte1[] = new byte[i1 + 3];
                abyte1[0] = 0;
                abyte1[1] = (byte)k;
                abyte1[2] = (byte)j1;

                for (int k1 = 0; k1 < abyte1.length - 3; k1++)
                {
                    abyte1[k1 + 3] = mapDataObj.colors[(k1 + j1) * 128 + k];
                }

                field_76210_c[k] = -1;
                field_76209_b[k] = -1;
                return abyte1;
            }
        }

        return null;
    }
}
