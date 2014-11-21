package net.minecraft.src;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;

public class mod_codeTrip extends BaseMod{
	public static Block codebase1;
	public static Block codebase2;

	
	
	@Override
	public String getVersion() {
		
		return "1.0.0";
	}

	@Override
	public void load() {
		Minecraft mc = ModLoader.getMinecraftInstance();
		
		//load codebase1
		
		
		codebase1 = new codebase1Block(176, ModLoader.addOverride("/terrain.png", "/CODEBASE1.png"), Material.rock);
		ModLoader.registerBlock(codebase1);
		ModLoader.addName(codebase1, "CODEBASE1");
		ModLoader.addRecipe(new ItemStack(codebase1, 1), new Object[]
				{
				         " D ",
				         " D ",
				         Character.valueOf('D'), Block.dirt,
				         Character.valueOf('S'), Block.sand
				});
		
	   //load codebase2
		codebase2 = new codebase2Block(177, ModLoader.addOverride("/terrain.png", "/CODEBASE2.png"), Material.rock);
		ModLoader.registerBlock(codebase2);
		ModLoader.addName(codebase2, "CODEBASE2");
		ModLoader.addRecipe(new ItemStack(codebase2, 1), new Object[]
				{
				         " D ",
				         " D ",
				         " D ",
				         Character.valueOf('D'), Block.dirt,
				         Character.valueOf('S'), Block.sand
				});
		//add codebase1 and codebase2 to the player's inventory
		if(mc.thePlayer !=null){
		mc.thePlayer.inventory.setInventorySlotContents(1, new ItemStack(mod_codeTrip.codebase1,1,0));
	    mc.thePlayer.inventory.setInventorySlotContents(2, new ItemStack(mod_codeTrip.codebase2,1,0));
		}
		
		//Analysis codebases and create the xml file
        String currDir = System.getProperty("user.dir");
		runParser(currDir, "CodeBases/CodeBase1");
		runParser(currDir, "CodeBases/CodeBase2");
		
		
		
		
	}
	
private void runParser(String dir, String path){
	CodeParser cp = new CodeParser();
	try {
		String pathNCSSxml = cp.parseToNCSS(dir, path);
		
        String pathFindBugsXML = cp.parseToFindBugs(dir, path);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	try {
		String pathJDepxml = cp.parseToJDepend(dir, path);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}


}
