package xyz.ivorydev.airclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import xyz.ivorydev.airclient.hud.mod.HudMod;

public class FPSMod extends HudMod {

	public FPSMod() {
		super("FPS Mod", 100, 100);
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString("FPS: §6" + mc.getDebugFPS(), getX(), getY(), -1);
		super.draw();
	}

	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString("§f[FPS: §6" + mc.getDebugFPS() + "§f]", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("§f[FPS: §6" + mc.getDebugFPS() + "§f]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
