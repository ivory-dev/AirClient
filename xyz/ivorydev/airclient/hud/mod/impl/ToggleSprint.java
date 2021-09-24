package xyz.ivorydev.airclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import xyz.ivorydev.airclient.event.EventTarget;
import xyz.ivorydev.airclient.event.impl.EventUpdate;
import xyz.ivorydev.airclient.hud.mod.HudMod;

public class ToggleSprint extends HudMod {

	public ToggleSprint() {
		super("Toggle Sprint", 5, 5);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (this.isEnabled() 
			&& !mc.thePlayer.isBlocking() 
			&& !mc.thePlayer.isSneaking() 
			&& (mc.thePlayer.motionX != 0 && mc.thePlayer.motionZ != 0) 
			&& !mc.thePlayer.isCollidedHorizontally
			&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
			&& !mc.thePlayer.isPotionActive(Potion.confusion)
			&& !mc.gameSettings.keyBindBack.isKeyDown()) {
			mc.thePlayer.setSprinting(true);
		}
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString("§aToggleSprint", getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString("§aToggleSprint", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("§aToggleSprint");
	}
	
}
