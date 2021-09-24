package xyz.ivorydev.airclient.hud;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import xyz.ivorydev.airclient.Air;
import xyz.ivorydev.airclient.hud.mod.HudMod;
import xyz.ivorydev.airclient.ui.clickgui.ClickGUI;

public class HUDConfigScreen extends GuiScreen {

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(new GuiButton(6340, this.width / 2 - 50, this.height / 2 - 10, 100, 20, "Mods"));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		for (HudMod m : Air.INSTANCE.hudManager.hudMods) {
			if (m.isEnabled()) {
				m.renderDummy(mouseX, mouseY);
			}
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		switch (button.id) {
		case 6340:
			mc.displayGuiScreen(new ClickGUI());
		}
	}
}
