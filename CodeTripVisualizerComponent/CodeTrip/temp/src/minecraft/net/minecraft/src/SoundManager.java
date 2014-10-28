// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.Random;
import net.minecraft.client.Minecraft;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

// Referenced classes of package net.minecraft.src:
//            SoundPool, GameSettings, CodecMus, EntityLiving, 
//            MathHelper, World, SoundPoolEntry

public class SoundManager
{

    private static SoundSystem field_77381_a;
    private SoundPool field_77379_b;
    private SoundPool field_77380_c;
    private SoundPool field_77377_d;
    private SoundPool cave;
    private int field_77378_e;
    private GameSettings field_77375_f;
    private static boolean field_77376_g = false;
    private Random field_77382_h;
    private Minecraft mc;
    private static final int MUSINTERVAL = 6000;
    private int field_77383_i;

    public SoundManager()
    {
        mc = Minecraft.func_71410_x();
        field_77379_b = new SoundPool();
        field_77380_c = new SoundPool();
        field_77377_d = new SoundPool();
        cave = new SoundPool();
        field_77378_e = 0;
        field_77382_h = new Random();
        field_77383_i = field_77382_h.nextInt(6000);
    }

    public void func_77373_a(GameSettings p_77373_1_)
    {
        field_77380_c.field_77463_b = false;
        field_77375_f = p_77373_1_;
        if(!field_77376_g && (p_77373_1_ == null || p_77373_1_.field_74340_b != 0.0F || p_77373_1_.field_74342_a != 0.0F))
        {
            func_77363_d();
        }
        loadModAudio("minecraft/resources/mod/sound", field_77379_b);
        loadModAudio("minecraft/resources/mod/streaming", field_77380_c);
        loadModAudio("minecraft/resources/mod/music", field_77377_d);
        loadModAudio("minecraft/resources/mod/cavemusic", cave);
    }

    private static void loadModAudio(String s, SoundPool soundpool)
    {
        File file = Minecraft.func_71394_a(s);
        try
        {
            walkFolder(file, file, soundpool);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private static void walkFolder(File file, File file1, SoundPool soundpool)
        throws IOException
    {
        if(file1.exists() || file1.mkdirs())
        {
            File afile[] = file1.listFiles();
            if(afile == null || afile.length == 0)
            {
                return;
            }
            for(int i = 0; i < afile.length; i++)
            {
                if(afile[i].getName().startsWith("."))
                {
                    continue;
                }
                if(afile[i].isDirectory())
                {
                    walkFolder(file, afile[i], soundpool);
                    continue;
                }
                if(afile[i].isFile())
                {
                    String s = afile[i].getPath().substring(file.getPath().length() + 1).replace('\\', '/');
                    soundpool.func_77459_a(s, afile[i]);
                }
            }

        }
    }

    private void func_77363_d()
    {
        try
        {
            float f = field_77375_f.field_74340_b;
            float f1 = field_77375_f.field_74342_a;
            field_77375_f.field_74340_b = 0.0F;
            field_77375_f.field_74342_a = 0.0F;
            field_77375_f.func_74303_b();
            SoundSystemConfig.addLibrary(paulscode.sound.libraries.LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", paulscode.sound.codecs.CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", net.minecraft.src.CodecMus.class);
            SoundSystemConfig.setCodec("wav", paulscode.sound.codecs.CodecWav.class);
            try
            {
                Class class1 = Class.forName("paulscode.sound.codecs.CodecIBXM");
                SoundSystemConfig.setCodec("xm", class1);
                SoundSystemConfig.setCodec("s3m", class1);
                SoundSystemConfig.setCodec("mod", class1);
            }
            catch(ClassNotFoundException classnotfoundexception) { }
            field_77381_a = new SoundSystem();
            field_77375_f.field_74340_b = f;
            field_77375_f.field_74342_a = f1;
            field_77375_f.func_74303_b();
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        field_77376_g = true;
    }

    public void func_77367_a()
    {
        if(!field_77376_g && (field_77375_f.field_74340_b != 0.0F || field_77375_f.field_74342_a != 0.0F))
        {
            func_77363_d();
        }
        if(field_77376_g)
        {
            if(field_77375_f.field_74342_a == 0.0F)
            {
                field_77381_a.stop("BgMusic");
            } else
            {
                field_77381_a.setVolume("BgMusic", field_77375_f.field_74342_a);
            }
        }
    }

    public void func_77370_b()
    {
        if(field_77376_g)
        {
            field_77381_a.cleanup();
        }
    }

    public void func_77372_a(String p_77372_1_, File p_77372_2_)
    {
        field_77379_b.func_77459_a(p_77372_1_, p_77372_2_);
    }

    public void func_77374_b(String p_77374_1_, File p_77374_2_)
    {
        field_77380_c.func_77459_a(p_77374_1_, p_77374_2_);
    }

    public void func_77365_c(String p_77365_1_, File p_77365_2_)
    {
        field_77377_d.func_77459_a(p_77365_1_, p_77365_2_);
    }

    public void func_77371_c()
    {
        if(!field_77376_g || field_77375_f.field_74342_a == 0.0F)
        {
            return;
        }
        if(!field_77381_a.playing("BgMusic") && !field_77381_a.playing("streaming"))
        {
            if(field_77383_i > 0)
            {
                field_77383_i--;
                return;
            }
            SoundPoolEntry soundpoolentry;
            if(mc != null && mc.field_71451_h != null && !mc.field_71451_h.field_70170_p.func_72937_j(MathHelper.func_76140_b(mc.field_71451_h.field_70165_t), MathHelper.func_76140_b(mc.field_71451_h.field_70163_u), MathHelper.func_76140_b(mc.field_71451_h.field_70161_v)))
            {
                soundpoolentry = cave.func_77460_a();
            } else
            {
                soundpoolentry = field_77377_d.func_77460_a();
            }
            if(soundpoolentry != null)
            {
                field_77383_i = field_77382_h.nextInt(6000) + 6000;
                field_77381_a.backgroundMusic("BgMusic", soundpoolentry.field_77384_b, soundpoolentry.field_77385_a, false);
                field_77381_a.setVolume("BgMusic", field_77375_f.field_74342_a);
                field_77381_a.play("BgMusic");
            }
        }
    }

    public void func_77369_a(EntityLiving p_77369_1_, float p_77369_2_)
    {
        if(!field_77376_g || field_77375_f.field_74340_b == 0.0F)
        {
            return;
        }
        if(p_77369_1_ == null)
        {
            return;
        } else
        {
            float f = p_77369_1_.field_70126_B + (p_77369_1_.field_70177_z - p_77369_1_.field_70126_B) * p_77369_2_;
            double d = p_77369_1_.field_70169_q + (p_77369_1_.field_70165_t - p_77369_1_.field_70169_q) * (double)p_77369_2_;
            double d1 = p_77369_1_.field_70167_r + (p_77369_1_.field_70163_u - p_77369_1_.field_70167_r) * (double)p_77369_2_;
            double d2 = p_77369_1_.field_70166_s + (p_77369_1_.field_70161_v - p_77369_1_.field_70166_s) * (double)p_77369_2_;
            float f1 = MathHelper.func_76134_b(-f * 0.01745329F - 3.141593F);
            float f2 = MathHelper.func_76126_a(-f * 0.01745329F - 3.141593F);
            float f3 = -f2;
            float f4 = 0.0F;
            float f5 = -f1;
            float f6 = 0.0F;
            float f7 = 1.0F;
            float f8 = 0.0F;
            field_77381_a.setListenerPosition((float)d, (float)d1, (float)d2);
            field_77381_a.setListenerOrientation(f3, f4, f5, f6, f7, f8);
            return;
        }
    }

    public void func_77368_a(String p_77368_1_, float p_77368_2_, float p_77368_3_, float p_77368_4_, float p_77368_5_, float p_77368_6_)
    {
        if(!field_77376_g || field_77375_f.field_74340_b == 0.0F && p_77368_1_ != null)
        {
            return;
        }
        String s = "streaming";
        if(field_77381_a.playing("streaming"))
        {
            field_77381_a.stop("streaming");
        }
        if(p_77368_1_ == null)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = field_77380_c.func_77458_a(p_77368_1_);
        if(soundpoolentry != null && p_77368_5_ > 0.0F)
        {
            if(field_77381_a.playing("BgMusic"))
            {
                field_77381_a.stop("BgMusic");
            }
            float f = 16F;
            field_77381_a.newStreamingSource(true, s, soundpoolentry.field_77384_b, soundpoolentry.field_77385_a, false, p_77368_2_, p_77368_3_, p_77368_4_, 2, f * 4F);
            field_77381_a.setVolume(s, 0.5F * field_77375_f.field_74340_b);
            field_77381_a.play(s);
        }
    }

    public void func_77364_b(String p_77364_1_, float p_77364_2_, float p_77364_3_, float p_77364_4_, float p_77364_5_, float p_77364_6_)
    {
        if(!field_77376_g || field_77375_f.field_74340_b == 0.0F)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = field_77379_b.func_77458_a(p_77364_1_);
        if(soundpoolentry != null && p_77364_5_ > 0.0F)
        {
            field_77378_e = (field_77378_e + 1) % 256;
            String s = (new StringBuilder()).append("sound_").append(field_77378_e).toString();
            float f = 16F;
            if(p_77364_5_ > 1.0F)
            {
                f *= p_77364_5_;
            }
            field_77381_a.newSource(p_77364_5_ > 1.0F, s, soundpoolentry.field_77384_b, soundpoolentry.field_77385_a, false, p_77364_2_, p_77364_3_, p_77364_4_, 2, f);
            field_77381_a.setPitch(s, p_77364_6_);
            if(p_77364_5_ > 1.0F)
            {
                p_77364_5_ = 1.0F;
            }
            field_77381_a.setVolume(s, p_77364_5_ * field_77375_f.field_74340_b);
            field_77381_a.play(s);
        }
    }

    public void func_77366_a(String p_77366_1_, float p_77366_2_, float p_77366_3_)
    {
        if(!field_77376_g || field_77375_f.field_74340_b == 0.0F)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = field_77379_b.func_77458_a(p_77366_1_);
        if(soundpoolentry != null)
        {
            field_77378_e = (field_77378_e + 1) % 256;
            String s = (new StringBuilder()).append("sound_").append(field_77378_e).toString();
            field_77381_a.newSource(false, s, soundpoolentry.field_77384_b, soundpoolentry.field_77385_a, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
            if(p_77366_2_ > 1.0F)
            {
                p_77366_2_ = 1.0F;
            }
            p_77366_2_ *= 0.25F;
            field_77381_a.setPitch(s, p_77366_3_);
            field_77381_a.setVolume(s, p_77366_2_ * field_77375_f.field_74340_b);
            field_77381_a.play(s);
        }
    }

}
