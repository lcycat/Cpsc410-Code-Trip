package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class mod_codeTrip extends BaseMod{
	public static Block test;
	
	@Override
	public String getVersion() {
		
		return "1.0.0";
	}

	@Override
	public void load() {
		ModLoader.generateSampleBuilding();
		
		//use to test the load of mod, no use now.Delete later
		test = new testBlock(176, ModLoader.addOverride("/terrain.png", "/diracore.png"), Material.rock);
		ModLoader.registerBlock(test);
		ModLoader.addName(test, "TESTBLOCK");
		ModLoader.addRecipe(new ItemStack(test, 1), new Object[]
				{
				         " D ",
				         "DSD",
				         " D ",
				         Character.valueOf('D'), Block.dirt,
				         Character.valueOf('S'), Block.sand
				});
	}
	

    @Override
    public void generateBuildings(World world, Random rand, int i, int j, List<Building> Buildings)
   {
         
         //int y = world.getTopSolidOrLiquidBlock(x, z); 
    	 //distance between building and building
    	 int distanceBTW = 15;
         int size   = 4;
         int height = 10;
         int func = 0;
         int bugs = 0;
       
        if(i%4==0){
        	
        	height = 20 ;
        	size = 8;
            func = 3;
            bugs = 5;
            
        /*
        height = Buildings.get(0).getHeight();
        size = Buildings.get(0).getMaxNCSS();
        func = Buildings.get(0).getNumberOfFunctions();
        bugs = Buildings.get(0).getBugs();
        */

        }
        if(i%3==0){
        	height = 40 ;
        	size = 10;
        	func = 5;
        	bugs = 10;
        	/*
            height = Buildings.get(1).getHeight();
            size = Buildings.get(1).getMaxNCSS();
            func = Buildings.get(1).getNumberOfFunctions();
            */
            }
        if(i%5==0){
        	height = 15 ;
        	size = 5;
        	func = 2;
        	bugs = 1;
            //height = Buildings.get(2).getHeight();
        	/*
            size = Buildings.get(2).getMaxNCSS();
            func = Buildings.get(2).getNumberOfFunctions();
            */
            }
      
      // build building
        int x = i-size;
        int z = j-size;
    	for(int a = 0;a < 2*size;a++)
    	    {
			    z=j-size;
			    		for(int b = 0;b <2* size;b++)
			    	    {
			    			  int y = world.getTopSolidOrLiquidBlock(x, z);
			
					    		for(int c = 0;c < height;c++)
					    	    {
					    		world.setBlock(x, y, z, Block.stone.blockID);
					    	    y=y+1; 
					    	    }
					    		for(int c = 0;c < func ;c++)
					    	    {
					    		world.setBlock(x, y, z, Block.blockGold.blockID);
					    	    y=y+1; 
					    	    }	
			    		     z++;  	    
			    	    }
			    x++;
    	    }
     //build fence between chucks
        x = i - distanceBTW;
        z = j - distanceBTW;
		    		for(int b = 0;b < 32;b++)
		    	    {
		    			  int y = world.getTopSolidOrLiquidBlock(x, z);
		
				    		world.setBlock(x, y, z, Block.fenceIron.blockID);
			    		
		    		     z++;  	    
		    	    }
		
	     x = i + distanceBTW;
	     z = j - distanceBTW;
			       for(int b = 0;b < 32;b++)
			       {
			    		int y = world.getTopSolidOrLiquidBlock(x, z);
			
					    world.setBlock(x, y, z, Block.fenceIron.blockID);
				    		
			    		 z++;  	    
			    	}
			       x = i - distanceBTW;
			       z = j + distanceBTW;
			       for(int b = 0;b < 32;b++)
			       {
			    		int y = world.getTopSolidOrLiquidBlock(x, z);
			
					    world.setBlock(x, y, z, Block.fenceIron.blockID);
				    		
			    		 x++;  	    
			    	}
			       x = i - distanceBTW;
			       z = j - distanceBTW;
			       for(int b = 0;b < 32;b++)
			       {
			    		int y = world.getTopSolidOrLiquidBlock(x, z);
			
					    world.setBlock(x, y, z, Block.fenceIron.blockID);
				    		
			    		 x++;  	    
			    	}
			       
	  //randomly distribute lava/diamond on buildings to represent bugs
			       for(int f = 0 ; f < bugs ; f++){
			    	   x = i + size*(rand.nextInt(2)-1);
			    	   z = j + size*(rand.nextInt(2)-1);
			    	   world.setBlock(x, rand.nextInt(height-1), z, Block.lavaStill.blockID);
			       }
			    	   

    	
   }
    


}
