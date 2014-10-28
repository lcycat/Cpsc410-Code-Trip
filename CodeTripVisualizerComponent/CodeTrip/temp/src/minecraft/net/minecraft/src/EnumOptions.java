// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumOptions extends Enum
{

    public static final EnumOptions MUSIC;
    public static final EnumOptions SOUND;
    public static final EnumOptions INVERT_MOUSE;
    public static final EnumOptions SENSITIVITY;
    public static final EnumOptions FOV;
    public static final EnumOptions GAMMA;
    public static final EnumOptions RENDER_DISTANCE;
    public static final EnumOptions VIEW_BOBBING;
    public static final EnumOptions ANAGLYPH;
    public static final EnumOptions ADVANCED_OPENGL;
    public static final EnumOptions FRAMERATE_LIMIT;
    public static final EnumOptions DIFFICULTY;
    public static final EnumOptions GRAPHICS;
    public static final EnumOptions AMBIENT_OCCLUSION;
    public static final EnumOptions GUI_SCALE;
    public static final EnumOptions RENDER_CLOUDS;
    public static final EnumOptions PARTICLES;
    public static final EnumOptions CHAT_VISIBILITY;
    public static final EnumOptions CHAT_COLOR;
    public static final EnumOptions CHAT_LINKS;
    public static final EnumOptions CHAT_OPACITY;
    public static final EnumOptions CHAT_LINKS_PROMPT;
    public static final EnumOptions USE_SERVER_TEXTURES;
    public static final EnumOptions SNOOPER_ENABLED;
    public static final EnumOptions USE_FULLSCREEN;
    public static final EnumOptions ENABLE_VSYNC;
    private final boolean field_74385_A;
    private final boolean field_74386_B;
    private final String field_74387_C;
    private static final EnumOptions $VALUES[]; /* synthetic field */

    public static EnumOptions[] values()
    {
        return (EnumOptions[])$VALUES.clone();
    }

    public static EnumOptions valueOf(String p_valueOf_0_)
    {
        return (EnumOptions)Enum.valueOf(net.minecraft.src.EnumOptions.class, p_valueOf_0_);
    }

    public static EnumOptions func_74379_a(int p_74379_0_)
    {
        EnumOptions aenumoptions[] = values();
        int i = aenumoptions.length;
        for(int j = 0; j < i; j++)
        {
            EnumOptions enumoptions = aenumoptions[j];
            if(enumoptions.func_74381_c() == p_74379_0_)
            {
                return enumoptions;
            }
        }

        return null;
    }

    private EnumOptions(String p_i3011_1_, int p_i3011_2_, String p_i3011_3_, boolean p_i3011_4_, boolean p_i3011_5_)
    {
        super(p_i3011_1_, p_i3011_2_);
        field_74387_C = p_i3011_3_;
        field_74385_A = p_i3011_4_;
        field_74386_B = p_i3011_5_;
    }

    public boolean func_74380_a()
    {
        return field_74385_A;
    }

    public boolean func_74382_b()
    {
        return field_74386_B;
    }

    public int func_74381_c()
    {
        return ordinal();
    }

    public String func_74378_d()
    {
        return field_74387_C;
    }

    static 
    {
        MUSIC = new EnumOptions("MUSIC", 0, "options.music", true, false);
        SOUND = new EnumOptions("SOUND", 1, "options.sound", true, false);
        INVERT_MOUSE = new EnumOptions("INVERT_MOUSE", 2, "options.invertMouse", false, true);
        SENSITIVITY = new EnumOptions("SENSITIVITY", 3, "options.sensitivity", true, false);
        FOV = new EnumOptions("FOV", 4, "options.fov", true, false);
        GAMMA = new EnumOptions("GAMMA", 5, "options.gamma", true, false);
        RENDER_DISTANCE = new EnumOptions("RENDER_DISTANCE", 6, "options.renderDistance", false, false);
        VIEW_BOBBING = new EnumOptions("VIEW_BOBBING", 7, "options.viewBobbing", false, true);
        ANAGLYPH = new EnumOptions("ANAGLYPH", 8, "options.anaglyph", false, true);
        ADVANCED_OPENGL = new EnumOptions("ADVANCED_OPENGL", 9, "options.advancedOpengl", false, true);
        FRAMERATE_LIMIT = new EnumOptions("FRAMERATE_LIMIT", 10, "options.framerateLimit", false, false);
        DIFFICULTY = new EnumOptions("DIFFICULTY", 11, "options.difficulty", false, false);
        GRAPHICS = new EnumOptions("GRAPHICS", 12, "options.graphics", false, false);
        AMBIENT_OCCLUSION = new EnumOptions("AMBIENT_OCCLUSION", 13, "options.ao", false, true);
        GUI_SCALE = new EnumOptions("GUI_SCALE", 14, "options.guiScale", false, false);
        RENDER_CLOUDS = new EnumOptions("RENDER_CLOUDS", 15, "options.renderClouds", false, true);
        PARTICLES = new EnumOptions("PARTICLES", 16, "options.particles", false, false);
        CHAT_VISIBILITY = new EnumOptions("CHAT_VISIBILITY", 17, "options.chat.visibility", false, false);
        CHAT_COLOR = new EnumOptions("CHAT_COLOR", 18, "options.chat.color", false, true);
        CHAT_LINKS = new EnumOptions("CHAT_LINKS", 19, "options.chat.links", false, true);
        CHAT_OPACITY = new EnumOptions("CHAT_OPACITY", 20, "options.chat.opacity", true, false);
        CHAT_LINKS_PROMPT = new EnumOptions("CHAT_LINKS_PROMPT", 21, "options.chat.links.prompt", false, true);
        USE_SERVER_TEXTURES = new EnumOptions("USE_SERVER_TEXTURES", 22, "options.serverTextures", false, true);
        SNOOPER_ENABLED = new EnumOptions("SNOOPER_ENABLED", 23, "options.snooper", false, true);
        USE_FULLSCREEN = new EnumOptions("USE_FULLSCREEN", 24, "options.fullscreen", false, true);
        ENABLE_VSYNC = new EnumOptions("ENABLE_VSYNC", 25, "options.vsync", false, true);
        $VALUES = (new EnumOptions[] {
            MUSIC, SOUND, INVERT_MOUSE, SENSITIVITY, FOV, GAMMA, RENDER_DISTANCE, VIEW_BOBBING, ANAGLYPH, ADVANCED_OPENGL, 
            FRAMERATE_LIMIT, DIFFICULTY, GRAPHICS, AMBIENT_OCCLUSION, GUI_SCALE, RENDER_CLOUDS, PARTICLES, CHAT_VISIBILITY, CHAT_COLOR, CHAT_LINKS, 
            CHAT_OPACITY, CHAT_LINKS_PROMPT, USE_SERVER_TEXTURES, SNOOPER_ENABLED, USE_FULLSCREEN, ENABLE_VSYNC
        });
    }
}
