package xyz.ivorydev.airclient.mod.impl;

import xyz.ivorydev.airclient.mod.Category;
import xyz.ivorydev.airclient.mod.Mod;

public class TestMod extends Mod {

	public TestMod() {
		super("Test Mod", "Mod for Developers", Category.OTHER);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		System.out.println("THIS MOD IS ONNNNNNNNN!!!!!");
	}
	
	
	
}
