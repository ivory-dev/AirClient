package xyz.ivorydev.airclient.ui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import xyz.ivorydev.airclient.Air;

public class AirClientMainMenu extends GuiScreen {


	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("mainmenu2.jpg"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
		GlStateManager.pushMatrix();
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		GlStateManager.translate(-(width/2f), -(height/2f), 0);
		
		mc.fontRendererObj.drawString(Air.INSTANCE.NAME, width / 2f - 7, 100f, new Color(188, 0, 255, 1).getRGB(), true);
		GlStateManager.popMatrix();
		mc.fontRendererObj.drawStringWithShadow(Air.INSTANCE.VERSION,  width/2f + 65, height/2f - mc.fontRendererObj.FONT_HEIGHT * 2f, new Color(0, 0, 0, 255).getRGB());
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 135, height / 2 - 40, "Singleplayer"));
		this.buttonList.add(new GuiButton(2, 135, height / 2 - 15, "Multiplayer"));
		this.buttonList.add(new GuiButton(3, 135, height / 2 + 10, "Settings"));
		this.buttonList.add(new GuiButton(4, 135, height / 2 + 35, "Rage Quit"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		} else if (button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		} else if (button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		} else if (button.id == 4) {
			mc.shutdown();
		}
		
		super.actionPerformed(button);
	}
}
