package net.minecraft.src;

import net.minecraft.client.Minecraft;

class NetClientWebTextures extends GuiScreen
{
    final String field_74244_a;

    /** Initialises Web Textures? */
    final NetClientHandler netClientHandlerWebTextures;

    NetClientWebTextures(NetClientHandler par1NetClientHandler, String par2Str)
    {
        netClientHandlerWebTextures = par1NetClientHandler;
        field_74244_a = par2Str;
    }

    public void confirmClicked(boolean par1, int par2)
    {
        mc = Minecraft.getMinecraft();

        if (mc.getServerData() != null)
        {
            mc.getServerData().setAcceptsTextures(par1);
            ServerList.func_78852_b(mc.getServerData());
        }

        if (par1)
        {
            mc.texturePackList.requestDownloadOfTexture(field_74244_a);
        }

        mc.displayGuiScreen(null);
    }
}
