package xyz.ivorydev.airclient.hud.mod.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.Gui;
import xyz.ivorydev.airclient.hud.mod.HudMod;



public class CPSMod extends HudMod {

	public static List<Long> clicks = new ArrayList<>();
	private boolean wasPressed;
	private long lastPressed;
	
	public CPSMod() {
		super("CPS Mod", 400, 400);
	}
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return fr.FONT_HEIGHT;
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return fr.getStringWidth("CPS: 00") + 10;
	}
	@Override
	public void draw() {
		final boolean pressed = Mouse.isButtonDown(0);
		if (pressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis();
			this.wasPressed = pressed;
			if (pressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString("CPS: " + getCPS(), 400, 400, -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString("CPS: 69420", 400, 400, -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	private int getCPS() {
		final long time = System.currentTimeMillis();
		this.clicks.removeIf(aLong -> aLong + 1000 < time);
		return this.clicks.size();
	}
	
	private boolean isKeyDown() {
		return mc.gameSettings.keyBindAttack.isKeyDown();
	}
}
