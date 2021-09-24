package xyz.ivorydev.airclient.hud.mod.impl;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.Color;
import java.awt.color.*;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;
import xyz.ivorydev.airclient.hud.mod.HudMod;

public class Keystrokes extends HudMod {

	public Keystrokes() {
		super("Keystrokes", 500, 100);
	}
	
	public static enum KeystrokesMode {
		
		WASD(Key.W, Key.A, Key.S, Key.D),
		WASD_JUMP(Key.W, Key.A, Key.S, Key.D, Key.Jump1),
		WASD_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB),
		WASD_JUMP_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB, Key.Jump2);
		
		private final Key[] keys;
		private int w, h;
		private KeystrokesMode(Key... keysIn) {
			this.keys = keysIn;
			for (Key key : keys) {
				this.w = Math.max(this.w, key.getX() + key.getWidth());
				this.h = Math.max(this.h, key.getY() + key.getHeight());
			}
		}
		
		public int getHeight() {
			return h;
		}
		
		public int getWidth() {
			return w;
		}
		
		public Key[] getKeys() {
			return keys;
		}
	}
	
	public static class Key {
		private static Minecraft mc = Minecraft.getMinecraft();
		
		private static final Key W = new Key("W", mc.gameSettings.keyBindForward, 21, 1, 18, 18);
		private static final Key A = new Key("A", mc.gameSettings.keyBindLeft, 1, 21, 18, 18);
		private static final Key S = new Key("S", mc.gameSettings.keyBindBack, 21, 21, 18, 18);
		private static final Key D = new Key("D", mc.gameSettings.keyBindRight, 41, 21, 18, 18);
		
		private static final Key LMB = new Key("LMB", mc.gameSettings.keyBindAttack, 1, 41, 28, 18);
		private static final Key RMB = new Key("RMB", mc.gameSettings.keyBindUseItem, 31, 41, 28, 18);
		
		private static final Key Jump1 = new Key("----", mc.gameSettings.keyBindJump, 1, 41, 58, 18);
		private static final Key Jump2 = new Key("----", mc.gameSettings.keyBindJump, 1, 61, 58, 18);
		
		private final String name;
		private final KeyBinding keyBind;
		private final int x, y, w, h;
		
		public Key(String name, KeyBinding keyBind, int x, int y, int w, int h) {
			this.name = name;
			this.keyBind = keyBind;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
		
		public boolean isDown() {
			return keyBind.isKeyDown();
		}
		
		public int getHeight() {
			return h;
		}
		
		public int getWidth() {
			return w;
		}
		
		public String getName() {
			return name;
		}
		
		public int getY() {
			return y;
		}
		
		public int getX() {
			return x;
		}
		
		
	}
	
	private KeystrokesMode mode = KeystrokesMode.WASD_JUMP_MOUSE;
	
	@Override
	public int getWidth() {
		return 58;
	}
	
	@Override
	public int getHeight() {
		return 18;
	}
	
	@Override
	public void draw() {
		int h = mode.h;
		int w = mode.w;
		Gui.drawRect(x + 21, y + 1, x + 39, y + 19,
	            !mc.gameSettings.keyBindForward.isKeyDown() ? Integer.MIN_VALUE : Integer.MAX_VALUE);
	    Gui.drawRect(x + 21, y + 21, x + 40 - 1, y + 40 - 1,
	            !mc.gameSettings.keyBindBack.isKeyDown() ? Integer.MIN_VALUE : Integer.MAX_VALUE);
	    Gui.drawRect(x + 1, y + 20 + 1, x + 20 - 1, y + 40 - 1,
	            !mc.gameSettings.keyBindLeft.isKeyDown() ? Integer.MIN_VALUE : Integer.MAX_VALUE);
	    Gui.drawRect(x + 40 + 1, y + 20 + 1, x + 60 - 1, y + 40 - 1,
	            !mc.gameSettings.keyBindRight.isKeyDown() ? Integer.MIN_VALUE : Integer.MAX_VALUE);
	        h = 80;
	        // buttons
	        Gui.drawRect(x + 1, y + h - 39, x + 29 - 1, y + h - 21,
	                !Mouse.isButtonDown(0) ? Integer.MIN_VALUE : Integer.MAX_VALUE);
	        Gui.drawRect(x + 29 + 1, y + h - 39, x + w - 1, y + h, -21);
	    
	        Gui.drawRect(x + 1, y + h - 19, x + w - 1, y + h, - 1);
	    
	    	
	   new Gui().drawCenteredString(fr, Keyboard.getKeyName(mc.gameSettings.keyBindForward.getKeyCode()),
	        x + 21 + (39 / 4.15f), y + 1 + (19 / 4.15f), -1);
	   new Gui().drawCenteredString(fr, Keyboard.getKeyName(mc.gameSettings.keyBindBack.getKeyCode()),
	        x + 21 + (39 / 4.15f), y + 21 + (19 / 4.15f), -1);
	   new Gui().drawCenteredString(fr, Keyboard.getKeyName(mc.gameSettings.keyBindLeft.getKeyCode()),
	        x + 1 + (39 / 4.15f), y + 21 + (19 / 4.15f), -1);
	   new Gui().drawCenteredString(fr, Keyboard.getKeyName(mc.gameSettings.keyBindRight.getKeyCode()),
	        x + 41 + (39 / 4.15f), y + 21 + (19 / 4.15f), -1);

	    new Gui().drawCenteredString(fr, "LMB", x + 5 + (39 / 4.15f), y + 21 + (19 / 4.15f) + 20, -1);
	    new Gui().drawCenteredString(fr, "RMB", x + 36 + (39 / 4.15f), y + 21 + (19 / 4.15f) + 20, -1);
	}
	


	@Override
	public void renderDummy(int mouseX, int mouseY) {
		GL11.glPushMatrix();
		
		for (Key key : mode.getKeys()) {
			int textWidth = fr.getStringWidth(key.getName());
			
			Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getX() + key.getWidth(), getY() + key.getY() + key.getHeight(), key.isDown() ? new Color(255, 255, 255, 102).getRGB() : new Color(0, 0, 0, 120).getRGB());
			fr.drawStringWithShadow(key.getName(), getX() + key.getX() + key.getWidth() / 2 - textWidth / 2, getY() + key.getY() + key.getHeight() / 2 - 4, key.isDown() ? new Color(0, 0, 0, 255).getRGB() : -1);
		}
		
		GL11.glPopMatrix();
		super.renderDummy(mouseX, mouseY);
	}
	
	
	


}
