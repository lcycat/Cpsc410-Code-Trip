// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Vector;
import javax.swing.JList;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            IUpdatePlayerListBox, ServerConfigurationManager, EntityPlayerMP

public class PlayerListBox extends JList
    implements IUpdatePlayerListBox
{

    private MinecraftServer field_79012_a;
    private int field_79011_b;

    public PlayerListBox(MinecraftServer p_i4105_1_)
    {
        field_79011_b = 0;
        field_79012_a = p_i4105_1_;
        p_i4105_1_.func_79000_a(this);
    }

    public void func_73660_a()
    {
        if(field_79011_b++ % 20 == 0)
        {
            Vector vector = new Vector();
            for(int i = 0; i < field_79012_a.func_71203_ab().field_72404_b.size(); i++)
            {
                vector.add(((EntityPlayerMP)field_79012_a.func_71203_ab().field_72404_b.get(i)).field_71092_bJ);
            }

            setListData(vector);
        }
    }
}
