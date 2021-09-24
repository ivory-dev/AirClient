package xyz.ivorydev.airclient.hud.mod;

import java.util.ArrayList;

import xyz.ivorydev.airclient.hud.mod.impl.ArmorStatusMod;
import xyz.ivorydev.airclient.hud.mod.impl.CPSMod;
import xyz.ivorydev.airclient.hud.mod.impl.CoordinatesMod;
import xyz.ivorydev.airclient.hud.mod.impl.FPSMod;
import xyz.ivorydev.airclient.hud.mod.impl.Keystrokes;
import xyz.ivorydev.airclient.hud.mod.impl.RainbowOverlay;
import xyz.ivorydev.airclient.hud.mod.impl.ToggleSprint;

public class HudManager {

	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public ArmorStatusMod armorStatus;
	public FPSMod fpsMod;
	public Keystrokes keystrokes;
	public ToggleSprint toggleSprint;
	public CoordinatesMod coordinatesMod;
	public CPSMod cpsMod;
	public RainbowOverlay rainbowOverlay;
	
	public HudManager() {
		hudMods.add(coordinatesMod = new CoordinatesMod());
		hudMods.add(fpsMod = new FPSMod());
		hudMods.add(keystrokes = new Keystrokes());
		hudMods.add(toggleSprint = new ToggleSprint());
		hudMods.add(armorStatus = new ArmorStatusMod());
		hudMods.add(cpsMod = new CPSMod());
		hudMods.add(rainbowOverlay = new RainbowOverlay());
	}
	
	public void renderMods() {
		for (HudMod m : hudMods) {
			if (m.isEnabled()) {
				m.draw();
			}
		}
	}
}
