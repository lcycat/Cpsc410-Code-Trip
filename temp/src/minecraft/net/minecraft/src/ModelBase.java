// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            TextureOffset, Entity, EntityLiving

public abstract class ModelBase
{

    public float field_78095_p;
    public boolean field_78093_q;
    public List field_78092_r;
    public boolean field_78091_s;
    private Map field_78094_a;
    public int field_78090_t;
    public int field_78089_u;

    public ModelBase()
    {
        field_78093_q = false;
        field_78092_r = new ArrayList();
        field_78091_s = true;
        field_78094_a = new HashMap();
        field_78090_t = 64;
        field_78089_u = 32;
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public void func_78086_a(EntityLiving entityliving, float f, float f1, float f2)
    {
    }

    protected void func_78085_a(String p_78085_1_, int p_78085_2_, int p_78085_3_)
    {
        field_78094_a.put(p_78085_1_, new TextureOffset(p_78085_2_, p_78085_3_));
    }

    public TextureOffset func_78084_a(String p_78084_1_)
    {
        return (TextureOffset)field_78094_a.get(p_78084_1_);
    }
}
