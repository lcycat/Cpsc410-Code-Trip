// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            AxisAlignedBB, AABBPool, RenderItem, Chunk, 
//            ChunkCache, IBlockAccess, RenderBlocks, Tessellator, 
//            Block, TileEntityRenderer, Entity, ICamera, 
//            World

public class WorldRenderer
{

    public World field_78924_a;
    private int field_78942_y;
    private static Tessellator field_78941_z;
    public static int field_78922_b = 0;
    public int field_78923_c;
    public int field_78920_d;
    public int field_78921_e;
    public int field_78918_f;
    public int field_78919_g;
    public int field_78931_h;
    public int field_78932_i;
    public int field_78929_j;
    public int field_78930_k;
    public boolean field_78927_l;
    public boolean field_78928_m[];
    public int field_78925_n;
    public int field_78926_o;
    public int field_78940_p;
    public boolean field_78939_q;
    public AxisAlignedBB field_78938_r;
    public int field_78937_s;
    public boolean field_78936_t;
    public boolean field_78935_u;
    public int field_78934_v;
    public boolean field_78933_w;
    private boolean field_78915_A;
    public List field_78943_x;
    private List field_78916_B;
    private int field_78917_C;

    public WorldRenderer(World p_i3196_1_, List p_i3196_2_, int p_i3196_3_, int p_i3196_4_, int p_i3196_5_, int p_i3196_6_)
    {
        field_78942_y = -1;
        field_78927_l = false;
        field_78928_m = new boolean[2];
        field_78936_t = true;
        field_78915_A = false;
        field_78943_x = new ArrayList();
        field_78924_a = p_i3196_1_;
        field_78916_B = p_i3196_2_;
        field_78942_y = p_i3196_6_;
        field_78923_c = -999;
        func_78913_a(p_i3196_3_, p_i3196_4_, p_i3196_5_);
        field_78939_q = false;
    }

    public void func_78913_a(int p_78913_1_, int p_78913_2_, int p_78913_3_)
    {
        if(p_78913_1_ == field_78923_c && p_78913_2_ == field_78920_d && p_78913_3_ == field_78921_e)
        {
            return;
        } else
        {
            func_78910_b();
            field_78923_c = p_78913_1_;
            field_78920_d = p_78913_2_;
            field_78921_e = p_78913_3_;
            field_78925_n = p_78913_1_ + 8;
            field_78926_o = p_78913_2_ + 8;
            field_78940_p = p_78913_3_ + 8;
            field_78932_i = p_78913_1_ & 0x3ff;
            field_78929_j = p_78913_2_;
            field_78930_k = p_78913_3_ & 0x3ff;
            field_78918_f = p_78913_1_ - field_78932_i;
            field_78919_g = p_78913_2_ - field_78929_j;
            field_78931_h = p_78913_3_ - field_78930_k;
            float f = 6F;
            field_78938_r = AxisAlignedBB.func_72330_a((float)p_78913_1_ - f, (float)p_78913_2_ - f, (float)p_78913_3_ - f, (float)(p_78913_1_ + 16) + f, (float)(p_78913_2_ + 16) + f, (float)(p_78913_3_ + 16) + f);
            GL11.glNewList(field_78942_y + 2, 4864);
            RenderItem.func_76980_a(AxisAlignedBB.func_72332_a().func_72299_a((float)field_78932_i - f, (float)field_78929_j - f, (float)field_78930_k - f, (float)(field_78932_i + 16) + f, (float)(field_78929_j + 16) + f, (float)(field_78930_k + 16) + f));
            GL11.glEndList();
            func_78914_f();
            return;
        }
    }

    private void func_78905_g()
    {
        GL11.glTranslatef(field_78932_i, field_78929_j, field_78930_k);
    }

    public void func_78907_a()
    {
        if(!field_78939_q)
        {
            return;
        }
        field_78939_q = false;
        int i = field_78923_c;
        int j = field_78920_d;
        int k = field_78921_e;
        int l = field_78923_c + 16;
        int i1 = field_78920_d + 16;
        int j1 = field_78921_e + 16;
        for(int k1 = 0; k1 < 2; k1++)
        {
            field_78928_m[k1] = true;
        }

        Chunk.field_76640_a = false;
        HashSet hashset = new HashSet();
        hashset.addAll(field_78943_x);
        field_78943_x.clear();
        int l1 = 1;
        ChunkCache chunkcache = new ChunkCache(field_78924_a, i - l1, j - l1, k - l1, l + l1, i1 + l1, j1 + l1);
        if(!chunkcache.func_72806_N())
        {
            field_78922_b++;
            RenderBlocks renderblocks = new RenderBlocks(chunkcache);
            field_78917_C = 0;
            int i2 = 0;
            do
            {
                if(i2 >= 2)
                {
                    break;
                }
                boolean flag = false;
                boolean flag1 = false;
                boolean flag2 = false;
                for(int j2 = j; j2 < i1; j2++)
                {
                    for(int k2 = k; k2 < j1; k2++)
                    {
                        for(int l2 = i; l2 < l; l2++)
                        {
                            int i3 = chunkcache.func_72798_a(l2, j2, k2);
                            if(i3 <= 0)
                            {
                                continue;
                            }
                            if(!flag2)
                            {
                                flag2 = true;
                                GL11.glNewList(field_78942_y + i2, 4864);
                                GL11.glPushMatrix();
                                func_78905_g();
                                float f = 1.000001F;
                                GL11.glTranslatef(-8F, -8F, -8F);
                                GL11.glScalef(f, f, f);
                                GL11.glTranslatef(8F, 8F, 8F);
                                field_78941_z.func_78382_b();
                                field_78941_z.func_78373_b(-field_78923_c, -field_78920_d, -field_78921_e);
                            }
                            Block block = Block.field_71973_m[i3];
                            if(block == null)
                            {
                                continue;
                            }
                            if(i2 == 0 && block.func_71887_s())
                            {
                                TileEntity tileentity = chunkcache.func_72796_p(l2, j2, k2);
                                if(TileEntityRenderer.field_76963_a.func_76952_a(tileentity))
                                {
                                    field_78943_x.add(tileentity);
                                }
                            }
                            int j3 = block.func_71856_s_();
                            if(j3 != i2)
                            {
                                flag = true;
                                continue;
                            }
                            if(j3 == i2)
                            {
                                flag1 |= renderblocks.func_78612_b(block, l2, j2, k2);
                            }
                        }

                    }

                }

                if(flag2)
                {
                    field_78917_C += field_78941_z.func_78381_a();
                    GL11.glPopMatrix();
                    GL11.glEndList();
                    field_78941_z.func_78373_b(0.0D, 0.0D, 0.0D);
                } else
                {
                    flag1 = false;
                }
                if(flag1)
                {
                    field_78928_m[i2] = false;
                }
                if(!flag)
                {
                    break;
                }
                i2++;
            } while(true);
        }
        HashSet hashset1 = new HashSet();
        hashset1.addAll(field_78943_x);
        hashset1.removeAll(hashset);
        field_78916_B.addAll(hashset1);
        hashset.removeAll(field_78943_x);
        field_78916_B.removeAll(hashset);
        field_78933_w = Chunk.field_76640_a;
        field_78915_A = true;
    }

    public float func_78912_a(Entity p_78912_1_)
    {
        float f = (float)(p_78912_1_.field_70165_t - (double)field_78925_n);
        float f1 = (float)(p_78912_1_.field_70163_u - (double)field_78926_o);
        float f2 = (float)(p_78912_1_.field_70161_v - (double)field_78940_p);
        return f * f + f1 * f1 + f2 * f2;
    }

    public void func_78910_b()
    {
        for(int i = 0; i < 2; i++)
        {
            field_78928_m[i] = true;
        }

        field_78927_l = false;
        field_78915_A = false;
    }

    public void func_78911_c()
    {
        func_78910_b();
        field_78924_a = null;
    }

    public int func_78909_a(int p_78909_1_)
    {
        if(!field_78927_l)
        {
            return -1;
        }
        if(!field_78928_m[p_78909_1_])
        {
            return field_78942_y + p_78909_1_;
        } else
        {
            return -1;
        }
    }

    public void func_78908_a(ICamera p_78908_1_)
    {
        field_78927_l = p_78908_1_.func_78546_a(field_78938_r);
    }

    public void func_78904_d()
    {
        GL11.glCallList(field_78942_y + 2);
    }

    public boolean func_78906_e()
    {
        if(!field_78915_A)
        {
            return false;
        } else
        {
            return field_78928_m[0] && field_78928_m[1];
        }
    }

    public void func_78914_f()
    {
        field_78939_q = true;
    }

    static 
    {
        field_78941_z = Tessellator.field_78398_a;
    }
}
