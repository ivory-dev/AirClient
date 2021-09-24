package xyz.ivorydev.airclient.mod;

import java.util.ArrayList;

import xyz.ivorydev.airclient.hud.mod.impl.ToggleSprint;
import xyz.ivorydev.airclient.mod.impl.*;

public class ModManager {

	public TestMod testMod;
	public ToggleSprint toggleSprint;
	
	public ArrayList<Mod> mods;
	
	public ModManager() {
		mods = new ArrayList<>();
		
		// Other
		mods.add(testMod = new TestMod());
		
		// Cosmetic
	}
}
