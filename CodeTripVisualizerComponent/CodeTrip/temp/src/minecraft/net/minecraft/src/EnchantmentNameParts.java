// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

public class EnchantmentNameParts
{

    public static final EnchantmentNameParts field_78061_a = new EnchantmentNameParts();
    private Random field_78059_b;
    private String field_78060_c[];

    private EnchantmentNameParts()
    {
        field_78059_b = new Random();
        field_78060_c = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale ".split(" ");
    }

    public String func_78057_a()
    {
        int i = field_78059_b.nextInt(2) + 3;
        String s = "";
        for(int j = 0; j < i; j++)
        {
            if(j > 0)
            {
                s = (new StringBuilder()).append(s).append(" ").toString();
            }
            s = (new StringBuilder()).append(s).append(field_78060_c[field_78059_b.nextInt(field_78060_c.length)]).toString();
        }

        return s;
    }

    public void func_78058_a(long p_78058_1_)
    {
        field_78059_b.setSeed(p_78058_1_);
    }

}
