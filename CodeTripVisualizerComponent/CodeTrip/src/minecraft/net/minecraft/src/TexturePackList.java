package net.minecraft.src;

import java.io.File;
import java.util.*;
import net.minecraft.client.Minecraft;

public class TexturePackList
{
    private static final TexturePackBase field_77314_a = new TexturePackDefault();

    /** The Minecraft instance. */
    private final Minecraft mc;

    /** The directory the texture packs will be loaded from. */
    private final File texturePackDir;

    /** Folder for the multi-player texturepacks. Returns File. */
    private final File mpTexturePackFolder;

    /** The list of the available texture packs. */
    private List availableTexturePacks;
    private Map field_77308_f;

    /** The TexturePack that will be used. */
    private TexturePackBase selectedTexturePack;
    private boolean field_77315_h;

    public TexturePackList(File par1File, Minecraft par2Minecraft)
    {
        availableTexturePacks = new ArrayList();
        field_77308_f = new HashMap();
        mc = par2Minecraft;
        texturePackDir = new File(par1File, "texturepacks");
        mpTexturePackFolder = new File(par1File, "texturepacks-mp-cache");
        func_77307_h();
        updateAvaliableTexturePacks();
    }

    private void func_77307_h()
    {
        if (!texturePackDir.isDirectory())
        {
            texturePackDir.delete();
            texturePackDir.mkdirs();
        }

        if (!mpTexturePackFolder.isDirectory())
        {
            mpTexturePackFolder.delete();
            mpTexturePackFolder.mkdirs();
        }
    }

    /**
     * Sets the new TexturePack to be used, returning true if it has actually changed, false if nothing changed.
     */
    public boolean setTexturePack(TexturePackBase par1TexturePackBase)
    {
        if (par1TexturePackBase == selectedTexturePack)
        {
            return false;
        }
        else
        {
            field_77315_h = false;
            selectedTexturePack = par1TexturePackBase;
            mc.gameSettings.skin = par1TexturePackBase.func_77538_c();
            mc.gameSettings.saveOptions();
            return true;
        }
    }

    /**
     * filename must end in .zip
     */
    public void requestDownloadOfTexture(String par1Str)
    {
        String s = par1Str.substring(par1Str.lastIndexOf("/") + 1);

        if (s.contains("?"))
        {
            s = s.substring(0, s.indexOf("?"));
        }

        if (!s.endsWith(".zip"))
        {
            return;
        }
        else
        {
            File file = new File(mpTexturePackFolder, s);
            downloadTexture(par1Str, file);
            return;
        }
    }

    private void downloadTexture(String par1Str, File par2File)
    {
        HashMap hashmap = new HashMap();
        GuiProgress guiprogress = new GuiProgress();
        hashmap.put("X-Minecraft-Username", mc.session.username);
        hashmap.put("X-Minecraft-Version", "1.3.1");
        hashmap.put("X-Minecraft-Supported-Resolutions", "16");
        field_77315_h = true;
        mc.displayGuiScreen(guiprogress);
        HttpUtil.downloadTexturePack(par2File, par1Str, new TexturePackDownloadSuccess(this), hashmap, 0x989680, guiprogress);
    }

    public boolean func_77295_a()
    {
        return field_77315_h;
    }

    public void func_77304_b()
    {
        field_77315_h = false;
        updateAvaliableTexturePacks();
        mc.func_71395_y();
    }

    /**
     * check the texture packs the client has installed
     */
    public void updateAvaliableTexturePacks()
    {
        ArrayList arraylist = new ArrayList();
        selectedTexturePack = field_77314_a;
        arraylist.add(field_77314_a);
        Iterator iterator = func_77299_i().iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            File file = (File)iterator.next();
            String s = func_77302_a(file);

            if (s != null)
            {
                Object obj = (TexturePackBase)field_77308_f.get(s);

                if (obj == null)
                {
                    obj = file.isDirectory() ? ((Object)(new TexturePackFolder(s, file))) : ((Object)(new TexturePackCustom(s, file)));
                    field_77308_f.put(s, obj);
                }

                if (((TexturePackBase)(obj)).func_77538_c().equals(mc.gameSettings.skin))
                {
                    selectedTexturePack = ((TexturePackBase)(obj));
                }

                arraylist.add(obj);
            }
        }
        while (true);

        availableTexturePacks.removeAll(arraylist);
        TexturePackBase texturepackbase;

        for (Iterator iterator1 = availableTexturePacks.iterator(); iterator1.hasNext(); field_77308_f.remove(texturepackbase.func_77536_b()))
        {
            texturepackbase = (TexturePackBase)iterator1.next();
            texturepackbase.func_77533_a(mc.renderEngine);
        }

        availableTexturePacks = arraylist;
    }

    private String func_77302_a(File par1File)
    {
        if (par1File.isFile() && par1File.getName().toLowerCase().endsWith(".zip"))
        {
            return (new StringBuilder()).append(par1File.getName()).append(":").append(par1File.length()).append(":").append(par1File.lastModified()).toString();
        }

        if (par1File.isDirectory() && (new File(par1File, "pack.txt")).exists())
        {
            return (new StringBuilder()).append(par1File.getName()).append(":folder:").append(par1File.lastModified()).toString();
        }
        else
        {
            return null;
        }
    }

    private List func_77299_i()
    {
        if (texturePackDir.exists() && texturePackDir.isDirectory())
        {
            return Arrays.asList(texturePackDir.listFiles());
        }
        else
        {
            return Collections.emptyList();
        }
    }

    /**
     * Returns a list of the available texture packs.
     */
    public List availableTexturePacks()
    {
        return Collections.unmodifiableList(availableTexturePacks);
    }

    public TexturePackBase func_77292_e()
    {
        return selectedTexturePack;
    }

    public boolean func_77300_f()
    {
        if (!mc.gameSettings.serverTextures)
        {
            return false;
        }

        ServerData serverdata = mc.getServerData();

        if (serverdata == null)
        {
            return true;
        }
        else
        {
            return serverdata.func_78840_c();
        }
    }

    public boolean getAcceptsTextures()
    {
        if (!mc.gameSettings.serverTextures)
        {
            return false;
        }

        ServerData serverdata = mc.getServerData();

        if (serverdata == null)
        {
            return false;
        }
        else
        {
            return serverdata.getAcceptsTextures();
        }
    }

    static boolean func_77301_a(TexturePackList par0TexturePackList)
    {
        return par0TexturePackList.field_77315_h;
    }

    static TexturePackBase func_77303_a(TexturePackList par0TexturePackList, TexturePackBase par1TexturePackBase)
    {
        return par0TexturePackList.selectedTexturePack = par1TexturePackBase;
    }

    static String func_77291_a(TexturePackList par0TexturePackList, File par1File)
    {
        return par0TexturePackList.func_77302_a(par1File);
    }

    static Minecraft getMinecraft(TexturePackList par0TexturePackList)
    {
        return par0TexturePackList.mc;
    }
}
