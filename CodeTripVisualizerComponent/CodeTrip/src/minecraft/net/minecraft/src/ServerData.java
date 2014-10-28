package net.minecraft.src;

public class ServerData
{
    public String serverName;
    public String serverIP;
    public String field_78846_c;
    public String field_78843_d;
    public long field_78844_e;
    public boolean field_78841_f;
    private boolean field_78842_g;
    private boolean acceptsTextures;

    public ServerData(String par1Str, String par2Str)
    {
        field_78841_f = false;
        field_78842_g = true;
        acceptsTextures = false;
        serverName = par1Str;
        serverIP = par2Str;
    }

    public NBTTagCompound func_78836_a()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setString("name", serverName);
        nbttagcompound.setString("ip", serverIP);

        if (!field_78842_g)
        {
            nbttagcompound.setBoolean("acceptTextures", acceptsTextures);
        }

        return nbttagcompound;
    }

    public boolean getAcceptsTextures()
    {
        return acceptsTextures;
    }

    public boolean func_78840_c()
    {
        return field_78842_g;
    }

    public void setAcceptsTextures(boolean par1)
    {
        acceptsTextures = par1;
        field_78842_g = false;
    }

    /**
     * Takes an NBTTagCompound with 'name' and 'ip' keys, returns a ServerData instance.
     */
    public static ServerData getServerDataFromNBTCompound(NBTTagCompound par0NBTTagCompound)
    {
        ServerData serverdata = new ServerData(par0NBTTagCompound.getString("name"), par0NBTTagCompound.getString("ip"));

        if (par0NBTTagCompound.hasKey("acceptTextures"))
        {
            serverdata.setAcceptsTextures(par0NBTTagCompound.getBoolean("acceptTextures"));
        }

        return serverdata;
    }
}
