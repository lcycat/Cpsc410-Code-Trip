package net.minecraft.src;

import java.util.List;

public class CreativeTabs
{
    public static final CreativeTabs creativeTabArray[] = new CreativeTabs[12];
    public static final CreativeTabs tabBlock = new CreativeTabBlock(0, "buildingBlocks");
    public static final CreativeTabs tabDeco = new CreativeTabDeco(1, "decorations");
    public static final CreativeTabs tabRedstone = new CreativeTabRedstone(2, "redstone");
    public static final CreativeTabs tabTransport = new CreativeTabTransport(3, "transportation");
    public static final CreativeTabs tabMisc = new CreativeTabMisc(4, "misc");
    public static final CreativeTabs tabAllSearch = (new CreativeTabSearch(5, "search")).setBackgroundImageName("search.png");
    public static final CreativeTabs tabFood = new CreativeTabFood(6, "food");
    public static final CreativeTabs tabTools = new CreativeTabTools(7, "tools");
    public static final CreativeTabs tabCombat = new CreativeTabCombat(8, "combat");
    public static final CreativeTabs tabBrewing = new CreativeTabBrewing(9, "brewing");
    public static final CreativeTabs tabMaterials = new CreativeTabMaterial(10, "materials");
    public static final CreativeTabs tabInventory = (new CreativeTabInventory(11, "inventory")).setBackgroundImageName("survival_inv.png").setNoScrollbar().setNoTitle();
    private final int tabIndex;
    private final String tabLabel;

    /** Texture to use. */
    private String backgroundImageName;
    private boolean hasScrollbar;

    /** Whether to draw the title in the foreground of the creative GUI */
    private boolean drawTitle;

    public CreativeTabs(int par1, String par2Str)
    {
        backgroundImageName = "list_items.png";
        hasScrollbar = true;
        drawTitle = true;
        tabIndex = par1;
        tabLabel = par2Str;
        creativeTabArray[par1] = this;
    }

    public int getTabIndex()
    {
        return tabIndex;
    }

    public String getTabLabel()
    {
        return tabLabel;
    }

    /**
     * Gets the translated Label.
     */
    public String getTranslatedTabLabel()
    {
        return StringTranslate.getInstance().translateKey((new StringBuilder()).append("itemGroup.").append(getTabLabel()).toString());
    }

    public Item getTabIconItem()
    {
        return Item.itemsList[getTabIconItemIndex()];
    }

    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex()
    {
        return 1;
    }

    public String getBackgroundImageName()
    {
        return backgroundImageName;
    }

    public CreativeTabs setBackgroundImageName(String par1Str)
    {
        backgroundImageName = par1Str;
        return this;
    }

    public boolean drawInForegroundOfTab()
    {
        return drawTitle;
    }

    public CreativeTabs setNoTitle()
    {
        drawTitle = false;
        return this;
    }

    public boolean shouldHidePlayerInventory()
    {
        return hasScrollbar;
    }

    public CreativeTabs setNoScrollbar()
    {
        hasScrollbar = false;
        return this;
    }

    /**
     * returns index % 6
     */
    public int getTabColumn()
    {
        return tabIndex % 6;
    }

    /**
     * returns tabIndex < 6
     */
    public boolean isTabInFirstRow()
    {
        return tabIndex < 6;
    }

    /**
     * only shows items which have tabToDisplayOn == this
     */
    public void displayAllReleventItems(List par1List)
    {
        Item aitem[] = Item.itemsList;
        int i = aitem.length;

        for (int j = 0; j < i; j++)
        {
            Item item = aitem[j];

            if (item != null && item.getCreativeTab() == this)
            {
                item.getSubItems(item.shiftedIndex, this, par1List);
            }
        }
    }
}
