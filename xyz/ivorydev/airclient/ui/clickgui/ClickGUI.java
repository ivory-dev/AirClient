package xyz.ivorydev.airclient.ui.clickgui;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import xyz.ivorydev.airclient.Air;
import xyz.ivorydev.airclient.ui.clickgui.component.ModButton;

public class ClickGUI extends GuiScreen {

	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	@Override
	public void initGui() {
		super.initGui();
		// TODO // yeah um targethud idk
		this.modButtons.add(new ModButton(110, 50, 60, mc.fontRendererObj.FONT_HEIGHT + 20, Air.INSTANCE.hudManager.fpsMod));
		this.modButtons.add(new ModButton(180, 50, 90, mc.fontRendererObj.FONT_HEIGHT + 20, Air.INSTANCE.hudManager.keystrokes));
		this.modButtons.add(new ModButton(280, 50, 110, mc.fontRendererObj.FONT_HEIGHT + 20, Air.INSTANCE.hudManager.toggleSprint));
		this.modButtons.add(new ModButton(230, 110, 90, mc.fontRendererObj.FONT_HEIGHT + 20, Air.INSTANCE.hudManager.coordinatesMod));
		this.modButtons.add(new ModButton(110, 110, 110, mc.fontRendererObj.FONT_HEIGHT + 20, Air.INSTANCE.hudManager.cpsMod));
		this.modButtons.add(new ModButton(340, 110, 110, mc.fontRendererObj.FONT_HEIGHT + 20, Air.INSTANCE.hudManager.rainbowOverlay));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		ScaledResolution sr = new ScaledResolution(mc);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
	    int width = gd.getDisplayMode().getWidth();
	    int height = gd.getDisplayMode().getHeight();
	    
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		// RoundedUtils.drawSmoothRoundedRect(200, 40, 200, 40, 10, new Color(255, 255, 255, 0).getRGB());
		Gui.drawRect(200, 400, sr.getScaledWidth(), sr.getScaledHeight(), -1);
		for (ModButton m : modButtons) {
			m.draw();
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
		for (ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}
}
