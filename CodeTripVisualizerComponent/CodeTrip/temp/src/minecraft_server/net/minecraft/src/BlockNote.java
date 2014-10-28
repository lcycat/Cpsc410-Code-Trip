// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, CreativeTabs, World, 
//            TileEntityNote, EntityPlayer, TileEntity

public class BlockNote extends BlockContainer
{

    public BlockNote(int p_i3972_1_)
    {
        super(p_i3972_1_, 74, Material.field_76245_d);
        func_71849_a(CreativeTabs.field_78028_d);
    }

    public int func_71851_a(int p_71851_1_)
    {
        return field_72059_bZ;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(p_71863_5_ > 0)
        {
            boolean flag = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_);
            TileEntityNote tileentitynote = (TileEntityNote)p_71863_1_.func_72796_p(p_71863_2_, p_71863_3_, p_71863_4_);
            if(tileentitynote != null && tileentitynote.field_70415_b != flag)
            {
                if(flag)
                {
                    tileentitynote.func_70414_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
                }
                tileentitynote.field_70415_b = flag;
            }
        }
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_1_.field_72995_K)
        {
            return true;
        }
        TileEntityNote tileentitynote = (TileEntityNote)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
        if(tileentitynote != null)
        {
            tileentitynote.func_70413_a();
            tileentitynote.func_70414_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
        }
        return true;
    }

    public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_)
    {
        if(p_71921_1_.field_72995_K)
        {
            return;
        }
        TileEntityNote tileentitynote = (TileEntityNote)p_71921_1_.func_72796_p(p_71921_2_, p_71921_3_, p_71921_4_);
        if(tileentitynote != null)
        {
            tileentitynote.func_70414_a(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_);
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityNote();
    }

    public void func_71883_b(World p_71883_1_, int p_71883_2_, int p_71883_3_, int p_71883_4_, int p_71883_5_, int p_71883_6_)
    {
        float f = (float)Math.pow(2D, (double)(p_71883_6_ - 12) / 12D);
        String s = "harp";
        if(p_71883_5_ == 1)
        {
            s = "bd";
        }
        if(p_71883_5_ == 2)
        {
            s = "snare";
        }
        if(p_71883_5_ == 3)
        {
            s = "hat";
        }
        if(p_71883_5_ == 4)
        {
            s = "bassattack";
        }
        p_71883_1_.func_72908_a((double)p_71883_2_ + 0.5D, (double)p_71883_3_ + 0.5D, (double)p_71883_4_ + 0.5D, (new StringBuilder()).append("note.").append(s).toString(), 3F, f);
        p_71883_1_.func_72869_a("note", (double)p_71883_2_ + 0.5D, (double)p_71883_3_ + 1.2D, (double)p_71883_4_ + 0.5D, (double)p_71883_6_ / 24D, 0.0D, 0.0D);
    }
}
