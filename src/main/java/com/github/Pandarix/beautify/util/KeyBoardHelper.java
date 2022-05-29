package com.github.Pandarix.beautify.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KeyBoardHelper {
    private static final long WINDOW = Minecraft.getInstance().getWindow().getWindow();

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingShift() {
        return InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingControl() {
        return InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_CONTROL) || InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_CONTROL);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingSpace() {
        return InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_SPACE);
    }
}
