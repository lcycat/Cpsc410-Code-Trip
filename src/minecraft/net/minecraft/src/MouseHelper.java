package net.minecraft.src;

import java.awt.Component;
import org.lwjgl.input.Mouse;

public class MouseHelper
{
    private Component windowComponent;

    /** Mouse delta X this frame */
    public int deltaX;

    /** Mouse delta Y this frame */
    public int deltaY;

    public MouseHelper(Component par1Component)
    {
        windowComponent = par1Component;
    }

    /**
     * Grabs the mouse cursor it doesn't move and isn't seen.
     */
    public void grabMouseCursor()
    {
        Mouse.setGrabbed(true);
        deltaX = 0;
        deltaY = 0;
    }

    /**
     * Ungrabs the mouse cursor so it can be moved and set it to the center of the screen
     */
    public void ungrabMouseCursor()
    {
        Mouse.setCursorPosition(windowComponent.getWidth() / 2, windowComponent.getHeight() / 2);
        Mouse.setGrabbed(false);
    }

    public void mouseXYChange()
    {
        deltaX = Mouse.getDX();
        deltaY = Mouse.getDY();
    }
}
