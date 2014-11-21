// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            TexturePackBase, GameSettings, GuiProgress, Session, 
//            TexturePackDownloadSuccess, HttpUtil, TexturePackFolder, TexturePackCustom, 
//            ServerData, TexturePackDefault

public class TexturePackList
{

    private static final TexturePackBase field_77314_a = new TexturePackDefault();
    private final Minecraft field_77312_b;
    private final File field_77313_c;
    private final File field_77310_d;
    private List field_77311_e;
    private Map field_77308_f;
    private TexturePackBase field_77309_g;
    private boolean field_77315_h;

    public TexturePackList(File p_i3025_1_, Minecraft p_i3025_2_)
    {
        field_77311_e = new ArrayList();
        field_77308_f = new HashMap();
        field_77312_b = p_i3025_2_;
        field_77313_c = new File(p_i3025_1_, "texturepacks");
        field_77310_d = new File(p_i3025_1_, "texturepacks-mp-cache");
        func_77307_h();
        func_77305_c();
    }

    private void func_77307_h()
    {
        if(!field_77313_c.isDirectory())
        {
            field_77313_c.delete();
            field_77313_c.mkdirs();
        }
        if(!field_77310_d.isDirectory())
        {
            field_77310_d.delete();
            field_77310_d.mkdirs();
        }
    }

    public boolean func_77294_a(TexturePackBase p_77294_1_)
    {
        if(p_77294_1_ == field_77309_g)
        {
            return false;
        } else
        {
            field_77315_h = false;
            field_77309_g = p_77294_1_;
            field_77312_b.field_71474_y.field_74346_m = p_77294_1_.func_77538_c();
            field_77312_b.field_71474_y.func_74303_b();
            return true;
        }
    }

    public void func_77296_a(String p_77296_1_)
    {
        String s = p_77296_1_.substring(p_77296_1_.lastIndexOf("/") + 1);
        if(s.contains("?"))
        {
            s = s.substring(0, s.indexOf("?"));
        }
        if(!s.endsWith(".zip"))
        {
            return;
        } else
        {
            File file = new File(field_77310_d, s);
            func_77297_a(p_77296_1_, file);
            return;
        }
    }

    private void func_77297_a(String p_77297_1_, File p_77297_2_)
    {
        HashMap hashmap = new HashMap();
        GuiProgress guiprogress = new GuiProgress();
        hashmap.put("X-Minecraft-Username", field_77312_b.field_71449_j.field_74286_b);
        hashmap.put("X-Minecraft-Version", "1.3.1");
        hashmap.put("X-Minecraft-Supported-Resolutions", "16");
        field_77315_h = true;
        field_77312_b.func_71373_a(guiprogress);
        HttpUtil.func_76182_a(p_77297_2_, p_77297_1_, new TexturePackDownloadSuccess(this), hashmap, 0x989680, guiprogress);
    }

    public boolean func_77295_a()
    {
        return field_77315_h;
    }

    public void func_77304_b()
    {
        field_77315_h = false;
        func_77305_c();
        field_77312_b.func_71395_y();
    }

    public void func_77305_c()
    {
        ArrayList arraylist = new ArrayList();
        field_77309_g = field_77314_a;
        arraylist.add(field_77314_a);
        Iterator iterator = func_77299_i().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            File file = (File)iterator.next();
            String s = func_77302_a(file);
            if(s != null)
            {
                Object obj = (TexturePackBase)field_77308_f.get(s);
                if(obj == null)
                {
                    obj = file.isDirectory() ? ((Object) (new TexturePackFolder(s, file))) : ((Object) (new TexturePackCustom(s, file)));
                    field_77308_f.put(s, obj);
                }
                if(((TexturePackBase) (obj)).func_77538_c().equals(field_77312_b.field_71474_y.field_74346_m))
                {
                    field_77309_g = ((TexturePackBase) (obj));
                }
                arraylist.add(obj);
            }
        } while(true);
        field_77311_e.removeAll(arraylist);
        TexturePackBase texturepackbase;
        for(Iterator iterator1 = field_77311_e.iterator(); iterator1.hasNext(); field_77308_f.remove(texturepackbase.func_77536_b()))
        {
            texturepackbase = (TexturePackBase)iterator1.next();
            texturepackbase.func_77533_a(field_77312_b.field_71446_o);
        }

        field_77311_e = arraylist;
    }

    private String func_77302_a(File p_77302_1_)
    {
        if(p_77302_1_.isFile() && p_77302_1_.getName().toLowerCase().endsWith(".zip"))
        {
            return (new StringBuilder()).append(p_77302_1_.getName()).append(":").append(p_77302_1_.length()).append(":").append(p_77302_1_.lastModified()).toString();
        }
        if(p_77302_1_.isDirectory() && (new File(p_77302_1_, "pack.txt")).exists())
        {
            return (new StringBuilder()).append(p_77302_1_.getName()).append(":folder:").append(p_77302_1_.lastModified()).toString();
        } else
        {
            return null;
        }
    }

    private List func_77299_i()
    {
        if(field_77313_c.exists() && field_77313_c.isDirectory())
        {
            return Arrays.asList(field_77313_c.listFiles());
        } else
        {
            return Collections.emptyList();
        }
    }

    public List func_77293_d()
    {
        return Collections.unmodifiableList(field_77311_e);
    }

    public TexturePackBase func_77292_e()
    {
        return field_77309_g;
    }

    public boolean func_77300_f()
    {
        if(!field_77312_b.field_71474_y.field_74356_s)
        {
            return false;
        }
        ServerData serverdata = field_77312_b.func_71362_z();
        if(serverdata == null)
        {
            return true;
        } else
        {
            return serverdata.func_78840_c();
        }
    }

    public boolean func_77298_g()
    {
        if(!field_77312_b.field_71474_y.field_74356_s)
        {
            return false;
        }
        ServerData serverdata = field_77312_b.func_71362_z();
        if(serverdata == null)
        {
            return false;
        } else
        {
            return serverdata.func_78839_b();
        }
    }

    static boolean func_77301_a(TexturePackList p_77301_0_)
    {
        return p_77301_0_.field_77315_h;
    }

    static TexturePackBase func_77303_a(TexturePackList p_77303_0_, TexturePackBase p_77303_1_)
    {
        return p_77303_0_.field_77309_g = p_77303_1_;
    }

    static String func_77291_a(TexturePackList p_77291_0_, File p_77291_1_)
    {
        return p_77291_0_.func_77302_a(p_77291_1_);
    }

    static Minecraft func_77306_b(TexturePackList p_77306_0_)
    {
        return p_77306_0_.field_77312_b;
    }

}
