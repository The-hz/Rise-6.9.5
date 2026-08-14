package com.alan.clients.script.api;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GameSettingsAPI extends API {
    public GameSettingsAPI() {
    }

    public boolean isKeyBindForwardDown() {
        return MC.gameSettings.keyBindForward.isKeyDown();
    }

    public boolean isKeyBindBackDown() {
        return MC.gameSettings.keyBindBack.isKeyDown();
    }

    public boolean isKeyBindLeftDown() {
        return MC.gameSettings.keyBindLeft.isKeyDown();
    }

    public boolean isKeyBindRightDown() {
        return MC.gameSettings.keyBindRight.isKeyDown();
    }

    public boolean isKeyBindJumpDown() {
        return MC.gameSettings.keyBindJump.isKeyDown();
    }

    public boolean isKeyBindSneakDown() {
        return MC.gameSettings.keyBindSneak.isKeyDown();
    }

    public boolean isKeyBindAttackDown() {
        return MC.gameSettings.cgK.isKeyDown();
    }

    public boolean isKeyBindUseItemDown() {
        return MC.gameSettings.cgI.isKeyDown();
    }

    public boolean isKeyBindDropDown() {
        return MC.gameSettings.keyBindDrop.isKeyDown();
    }

    public boolean isKeyBindInventoryDown() {
        return MC.gameSettings.keyBindInventory.isKeyDown();
    }

    public boolean isKeyBindChatDown() {
        return MC.gameSettings.keyBindChat.isKeyDown();
    }

    public boolean isKeyBindPlayerListDown() {
        return MC.gameSettings.keyBindPlayerList.isKeyDown();
    }

    public boolean isKeyBindCommandDown() {
        return MC.gameSettings.cgO.isKeyDown();
    }

    public boolean isKeyBindScreenshotDown() {
        return MC.gameSettings.cgP.isKeyDown();
    }

    public boolean isKeyBindTogglePerspectiveDown() {
        return MC.gameSettings.cgQ.isKeyDown();
    }

    public boolean isKeyBindSmoothCameraDown() {
        return MC.gameSettings.cgR.isKeyDown();
    }

    public boolean isKeyBindFullscreenDown() {
        return MC.gameSettings.cgS.isKeyDown();
    }

    public boolean isKeyBindSpectatorOutlinesDown() {
        return MC.gameSettings.keyBindSpectatorOutlines.isKeyDown();
    }

    public void setKeyBindForward(boolean var1) {
        MC.gameSettings.keyBindForward.setPressed(var1);
    }

    public void setKeyBindBack(boolean var1) {
        MC.gameSettings.keyBindBack.setPressed(var1);
    }

    public void setKeyBindLeft(boolean var1) {
        MC.gameSettings.keyBindLeft.setPressed(var1);
    }

    public void setKeyBindRight(boolean var1) {
        MC.gameSettings.keyBindRight.setPressed(var1);
    }

    public void setKeyBindJump(boolean var1) {
        MC.gameSettings.keyBindJump.setPressed(var1);
    }

    public void setKeyBindSneak(boolean var1) {
        MC.gameSettings.keyBindSneak.setPressed(var1);
    }

    public void setKeyBindAttack(boolean var1) {
        MC.gameSettings.cgK.setPressed(var1);
    }

    public void setKeyBindUseItem(boolean var1) {
        MC.gameSettings.cgI.setPressed(var1);
    }

    public void setKeyBindDrop(boolean var1) {
        MC.gameSettings.keyBindDrop.setPressed(var1);
    }

    public void setKeyBindInventory(boolean var1) {
        MC.gameSettings.keyBindInventory.setPressed(var1);
    }

    public void setKeyBindChat(boolean var1) {
        MC.gameSettings.keyBindChat.setPressed(var1);
    }

    public void setKeyBindPlayerList(boolean var1) {
        MC.gameSettings.keyBindPlayerList.setPressed(var1);
    }

    public void setKeyBindCommand(boolean var1) {
        MC.gameSettings.cgO.setPressed(var1);
    }

    public void setKeyBindScreenshot(boolean var1) {
        MC.gameSettings.cgP.setPressed(var1);
    }

    public void setKeyBindTogglePerspective(boolean var1) {
        MC.gameSettings.cgQ.setPressed(var1);
    }

    public void setKeyBindSmoothCamera(boolean var1) {
        MC.gameSettings.cgR.setPressed(var1);
    }

    public void setKeyBindFullscreen(boolean var1) {
        MC.gameSettings.cgS.setPressed(var1);
    }

    public void setKeyBindSpectatorOutlines(boolean var1) {
        MC.gameSettings.keyBindSpectatorOutlines.setPressed(var1);
    }

    public boolean isKeyDown(int var1) {
        return Keyboard.isKeyDown(var1);
    }

    public boolean isMouseDown(int var1) {
        return Mouse.isButtonDown(var1);
    }
}
