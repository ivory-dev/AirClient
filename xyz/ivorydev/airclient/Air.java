package xyz.ivorydev.airclient;

import net.minecraft.client.Minecraft;
import xyz.ivorydev.airclient.event.EventManager;
import xyz.ivorydev.airclient.event.EventTarget;
import xyz.ivorydev.airclient.event.impl.ClientTick;
import xyz.ivorydev.airclient.hud.HUDConfigScreen;
import xyz.ivorydev.airclient.hud.mod.HudManager;
import xyz.ivorydev.airclient.mod.ModManager;
import xyz.ivorydev.airclient.ui.clickgui.ClickGUI;
import xyz.ivorydev.airclient.util.font.FontUtil;

public class Air {
	public String NAME = "Air", VERSION = "snapshot 5a", AUTHOR = "Ivory Development";
	public static Air INSTANCE = new Air();
	public Minecraft mc = Minecraft.getMinecraft();
	public EventManager eventManager;
	public ModManager modManager;
	public HudManager hudManager;
	
	public void startup() {
		eventManager = new EventManager();
		modManager = new ModManager();
		hudManager = new HudManager();
		
		System.out.println("Starting " + NAME + " " + VERSION + " by " + AUTHOR);
		
		FontUtil.bootstrap();

		eventManager.register(this);
	}
	
	public void shutdown() {
		System.out.println("Stopping " + NAME + " " + VERSION + " by " + AUTHOR);
		
		eventManager.unregister(this);
	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if (mc.gameSettings.TEST_MOD.isPressed()) {
			modManager.testMod.toggle();
		}
		if (mc.gameSettings.HUD_CONFIG.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if (mc.gameSettings.keyBindSprint.isPressed()) {
			modManager.toggleSprint.toggle();
		}
		if (mc.gameSettings.OPEN_CLICKGUI.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
	}
	
}
