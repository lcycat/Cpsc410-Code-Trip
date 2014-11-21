// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntityRenderer, RenderEngine, TileEntity, World, 
//            FontRenderer

public abstract class TileEntitySpecialRenderer
{

    protected TileEntityRenderer field_76898_b;

    public TileEntitySpecialRenderer()
    {
    }

    public abstract void func_76894_a(TileEntity tileentity, double d, double d1, double d2, 
            float f);

    protected void func_76897_a(String p_76897_1_)
    {
        RenderEngine renderengine = field_76898_b.field_76960_e;
        if(renderengine != null)
        {
            renderengine.func_78342_b(renderengine.func_78341_b(p_76897_1_));
        }
    }

    public void func_76893_a(TileEntityRenderer p_76893_1_)
    {
        field_76898_b = p_76893_1_;
    }

    public void func_76896_a(World world)
    {
    }

    public FontRenderer func_76895_b()
    {
        return field_76898_b.func_76954_a();
    }
}
