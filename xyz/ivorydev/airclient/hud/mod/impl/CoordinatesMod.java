package xyz.ivorydev.airclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import xyz.ivorydev.airclient.hud.mod.HudMod;

public class CoordinatesMod extends HudMod {

	public CoordinatesMod() {
		super("Coordinates", 100, 100);
	}
	
	@Override
	public void draw() {
		int actualWidth = getWidth() * 3;
		Gui.drawRect(getX() - 2, getY() - 2, getX() + actualWidth, getY() + fr.FONT_HEIGHT, new Color(0, 0, 0, 170).getRGB());
		fr.drawString("X: " + (int) mc.getRenderViewEntity().posX + " / Y: " + (int) mc.getRenderViewEntity().getEntityBoundingBox().minY + " / Z: " + (int) mc.getRenderViewEntity().posZ, getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		int actualWidth = getWidth() * 3;
		Gui.drawRect(getX() - 2, getY() - 2, getX() + actualWidth, getY() + fr.FONT_HEIGHT, new Color(0, 0, 0, 170).getRGB());
		fr.drawString("X: " + (int) mc.getRenderViewEntity().posX + " / Y: " + (int) mc.getRenderViewEntity().getEntityBoundingBox().minY + " / Z: " + (int) mc.getRenderViewEntity().posZ, getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}

}
