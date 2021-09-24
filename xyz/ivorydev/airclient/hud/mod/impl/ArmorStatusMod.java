package xyz.ivorydev.airclient.hud.mod.impl;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import xyz.ivorydev.airclient.hud.mod.HudMod;

public class ArmorStatusMod extends HudMod {


	public ArmorStatusMod() {
		super("Armor Status", 300, 300);
	}
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 64;
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 64;
	}
	@Override
	public void draw() {
		
		for (int i = 0; i < mc.thePlayer.inventory.armorInventory.length; i++) {
			ItemStack item = mc.thePlayer.inventory.armorInventory[i];
			renderItemStack(i, item);
		}
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		renderItemStack(3, new ItemStack(Items.leather_helmet));
		renderItemStack(2, new ItemStack(Items.leather_chestplate));
		renderItemStack(1, new ItemStack(Items.leather_leggings));
		renderItemStack(0, new ItemStack(Items.leather_boots));
	}

	private void renderItemStack(int i, ItemStack is) {
		
		if (is == null) {
			return;
		}
		
		GL11.glPushMatrix();
		int yAdd = (-16 * 1) + 48;
		if (is.getItem().isDamageable()) {
			double damage = ((is.getMaxDamage() - is.getItemDamage())) / (double) is.getMaxDamage() * 100;
			fr.drawString(String.format("%.2f%%", damage), getX() + 20, getY() + yAdd + 5, -1);
		}
		
		RenderHelper.enableGUIStandardItemLighting();
		mc.getRenderItem().renderItemAndEffectIntoGUI(is, getX(), getY() + yAdd);
		GL11.glPopMatrix();
		
	}

}
