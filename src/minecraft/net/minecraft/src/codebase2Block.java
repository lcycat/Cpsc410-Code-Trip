package net.minecraft.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class codebase2Block extends Block {
	 public static CodeBase codebase2 = new CodeBase();
	 public static List<Building> Buildings = new LinkedList<Building>();
	 public int blockdistance = 3;
	 public int blocksize = 8;
	 public int towndistance =7;
	 public int stationSize = 5;
	 private int fncBlock1 = Block.obsidian.blockID;
	 private int fncBlock2 = Block.blockGold.blockID;
	 private int fncBlock3 = Block.sandStone.blockID;
	 private int fncBlock4 = Block.blockEmerald.blockID;
	 private int fncBlock5 = Block.obsidian.blockID;
	 private int fncBlock6 = Block.blockDiamond.blockID;
	 private boolean done = false;
	 private int lastM = Block.sandStone.blockID;


	protected codebase2Block(int id, int textureIndex, Material mat) {
		 super(id, textureIndex, mat);
         super.setHardness(3.0f);
         super.setBlockName("codebase2");
         super.setStepSound(soundStoneFootstep);
	}
	
	
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {   	
        if(done)
        	return true;
        
		buildPlatform(world,  i,  j, k);   	   
		this.generateCodeBase(par5EntityPlayer);
		
		List<Town> towns = codebase2.getTown();
		int townNum = towns.size();
		int codeSize = (int)Math.sqrt(townNum);

		if(codeSize*codeSize<townNum){
			codeSize++;
		}
		int townSize = 0;
		int townX = i+blocksize+stationSize;
		int townY = k;
		int townCount = 0;
		int Maxsize = 0;
		
		for(int a =0; a <codeSize; a++){
			
			for(int b =0; b <codeSize; b++){
				if(townCount<townNum){
					Town t = towns.get(townCount);
					List<Building> townBuildings = t.ownBuildings;
					int buildingNumber = townBuildings.size();
				    townSize = (int)Math.sqrt(buildingNumber);
			
					if(townSize*townSize<buildingNumber){
						townSize++;
					}
					//SET THE COORDINATE OF THE STATION
					codebase2.getTown().get(townCount).setStationX(townX-blockdistance-3);
					codebase2.getTown().get(townCount).setStationY(townY-blockdistance-3);
					this.buildTown(world, townX, j, townY, t,townSize);
					
					if(Maxsize<townSize)
						Maxsize = townSize;
				    
					townY = townY+blocksize*townSize + towndistance;
					townCount++;
				}
				else{
					break;
				}
			}
		
			townX = townX+blocksize*Maxsize + towndistance;
			townY = k;
		
		}
		
		buildRail( world,j);
		done = true;
		
        return true;
    }
	
	//build a town which represent a package in code base
	
	public void buildTown(World world, int i, int j, int k, Town t,int townSize){
		List<Building> townBuildings = t.ownBuildings;
		int buildingNumber = townBuildings.size();
		int count = 0;
		
		for(int a =0; a < townSize; a++){
            
			for(int b =0; b < townSize; b++){
				if(count<buildingNumber){
			    this.buildBuilding(world, i+blocksize*a, j, k+blocksize*b, townBuildings.get(count));
			    count++;
				}
				else{
					break;
				}
			
			}
		}
		
		 //build fence between towns
		int townFence = Block.brick.blockID;
        int x = i - blockdistance;
        int z = k - blockdistance;
		    		for(int b = 0;b < townSize*blocksize +1;b++)
		    	    {
		    			  int y = world.getTopSolidOrLiquidBlock(x, z);
		
				    		world.setBlock(x, y, z, townFence);
				    		world.setBlock(x, y+1, z, townFence);
				    		world.setBlock(x, y+2, z, townFence);
			    		
		    		     z++;  	    
		    	    }
		
	     x = i + townSize*blocksize -blockdistance;
	     z = k - blockdistance;
			       for(int b = 0;b < townSize*blocksize+1;b++)
			       {
			    		int y = world.getTopSolidOrLiquidBlock(x, z);
			
			    		world.setBlock(x, y, z, townFence);
			    		world.setBlock(x, y+1, z, townFence);
			    		world.setBlock(x, y+2, z, townFence);
				    		
			    		 z++;  	    
			    	}
		x = i- blockdistance ;
		z = k + townSize*blocksize - blockdistance ;
			       for(int b = 0;b < townSize*blocksize+1;b++)
			       {
			    		int y = world.getTopSolidOrLiquidBlock(x, z);
			
			    		world.setBlock(x, y, z, townFence);
			    		world.setBlock(x, y+1, z, townFence);
			    		world.setBlock(x, y+2, z, townFence);
				    		
			    		 x++;  	    
			    	}
		x = i- blockdistance ;
	    z = k- blockdistance ;
			       for(int b = 0;b < townSize*blocksize+1;b++)
			       {
			    		int y = world.getTopSolidOrLiquidBlock(x, z);
			
			    		world.setBlock(x, y, z, townFence);
			    		world.setBlock(x, y+1, z, townFence);
			    		world.setBlock(x, y+2, z, townFence);
				    		
			    		 x++;  	    
			    	}
			 //build a train station
			    buildStation(world,i-blockdistance-stationSize,j,k-blockdistance-stationSize,t.getName());
		
	}
	
	//build a train station that linked each town
public void buildStation(World world, int i, int j, int k,String name){
	int block = Block.stairsWoodSpruce.blockID;
    int size = stationSize;
    //sign
    world.setBlockAndMetadataWithNotify(i-1, j, k+4, Block.signPost.blockID,4);
    
    if(world.blockHasTileEntity(i-1, j, k+4)){
        TileEntitySign tileentitysign = (TileEntitySign)world.getBlockTileEntity(i-1, j, k+4);
        tileentitysign.signText[0]="Welcome To The";
        tileentitysign.signText[1]="Town Of";
        tileentitysign.signText[2]=name;
        }
    
    for (int i1 = 0; i1 < size; i1++)
    {
       for (int j1 = 0; j1 < size; j1++)
       {
          //Walls 
          // i == ++ k == 0
          world.setBlockWithNotify(i+i1,j+j1,k,block);
          // i == ++ k == 4
          world.setBlockWithNotify(i+i1,j+j1,k+(size-1),block);
          // i == 0 k == ++
          world.setBlockWithNotify(i,j+j1,k+i1,block);
          // i == 4 k == ++
          world.setBlockWithNotify(i+(size-1),j+j1,k+i1,block);
          
          //Roof
          world.setBlockWithNotify(i+i1,j+(size-1),k+j1,block);


       }
    }
    //Door
    world.setBlockWithNotify(i+2,j,k,0);
    world.setBlockWithNotify(i+2,j+1,k,0);
    
    world.setBlockWithNotify(i+2,j,k+4,0);
    world.setBlockWithNotify(i+2,j+1,k+4,0);
    
    world.setBlockWithNotify(i+4,j,k+2,0);
    world.setBlockWithNotify(i+4,j+1,k+2,0);
    
    world.setBlockWithNotify(i,j,k+2,0);
    world.setBlockWithNotify(i,j+1,k+2,0);

    //Windows
    int offset = size % 2 == 0 ? (size / 2) - 1 : (size / 2);
    world.setBlockWithNotify(i,j+offset,k+offset,Block.glass.blockID);
    world.setBlockWithNotify(i+offset,j+offset,k,Block.glass.blockID);
    world.setBlockWithNotify(i+(size-1),j+offset,k+offset,Block.glass.blockID);
    world.setBlockWithNotify(i+offset,j+offset,k+(size-1),Block.glass.blockID);

}


	//build a building which represent a class in a package
public void buildBuilding(World world, int i, int j, int k, Building build){
    Random random = new Random(world.getSeed());
    long l = (random.nextLong() / 2L) * 2L + 1L;
    long l1 = (random.nextLong() / 2L) * 2L + 1L;
    random.setSeed((long)i * l + (long)j * l1 ^ world.getSeed());

   int buildingFence = Block.stoneBrick.blockID;
   int distanceBTW = blockdistance;
   int height = build.getHeight();

   if(height<=1)
	   height = 2;
   int size = build.getTotalNCSS();

   if(size>blockdistance-2)
	   size = blockdistance-2;
   int  func = build.getNumberOfFunctions();

   int  bugs = build.getBugs();

   int fncH;
   if(func==0){
	   fncH = 1;
       func = 1;
   }
   else{
   fncH = (height/func)+1;
   }
   int buildingblock = Block.blockSteel.blockID;

//build a building
 int x = i-size;
 int z = k-size;
 int y = j;
 int top = y;


	for(int a = 0;a < 2*size;a++)
	    {
		    z=k-size;
		    		for(int b = 0;b <2* size;b++)
		    	    {
		    			   y = world.getTopSolidOrLiquidBlock(x, z);
		    			  
		    			 for(int n = 0; n <func; n++){
		    				 buildingblock = chooseMaterial(n,func);
		    			   
				    		for(int c = 0;c <fncH;c++)
				    	    {
				    		world.setBlock(x, y, z, buildingblock);
				    	    y++; 
				    	    top = y;
				    	    }
				    		
				    	
				    		
		    			 }
				    	
		    		     z++;  	    
		    	    }
		    x++;
	    }


	//build a sign for the building
	world.setBlockAndMetadataWithNotify(i, top, k, Block.signPost.blockID,4);
	
	if(world.blockHasTileEntity(i,top,k)){
	    TileEntitySign tileentitysign = (TileEntitySign)world.getBlockTileEntity(i, top, k);
	    tileentitysign.signText[0]="Welcome To The";
	    tileentitysign.signText[1]="Building Of";
	    tileentitysign.signText[2]=build.getName();
		}
 
	//build base
	 x = i-blockdistance+1;
     z = k-blockdistance+1;
	     y = world.getTopSolidOrLiquidBlock(x, z)-1;
   	for(int a = 0;a < 2*(blockdistance -1);a++)
   	    {
			    z=k-blockdistance+1;
			    		for(int b = 0;b <2*(blockdistance -1);b++)
			    	    {			
					    		world.setBlock(x, y, z, Block.stoneBrick.blockID);
					    	
			    		     z++;  	    
			    	    }
			    x++;
   	    }

	 //build fence between buildings
    x = i - distanceBTW+1;
    z = k - distanceBTW+1;
	    		for(int b = 0;b < blockdistance*2;b++)
	    	    {
	    			   y = world.getTopSolidOrLiquidBlock(x, z);
	
			    		world.setBlock(x, y, z, buildingFence);
		    		
	    		     z++;  	    
	    	    }
	
     x = i + distanceBTW-1;
     z = k - distanceBTW+1;
		       for(int b = 0;b < blockdistance*2;b++)
		       {
		    		 y = world.getTopSolidOrLiquidBlock(x, z);
		
		    		 world.setBlock(x, y, z, buildingFence);
			    		
		    		 z++;  	    
		    	}
	x = i - distanceBTW+1;
    z = k + distanceBTW-1;
		       for(int b = 0;b < blockdistance*2;b++)
		       {
		    		 y = world.getTopSolidOrLiquidBlock(x, z);
		
		    		 world.setBlock(x, y, z, buildingFence);
			    		
		    		 x++;  	    
		    	}
     x = i - distanceBTW+1;
     z = k - distanceBTW+1;
		       for(int b = 0;b < blockdistance*2;b++)
		       {
		    		 y = world.getTopSolidOrLiquidBlock(x, z);
		
		    		 world.setBlock(x, y, z, buildingFence);
			    		
		    		 x++;  	    
		    	}

	
	 //randomly distribute lava/diamond on buildings to represent bugs
       for(int f = 0 ; f < bugs ; f++){
    	   x = i + size*(random.nextInt(2)-1);
    	   z = k + size*(random.nextInt(2)-1);
    	   world.setBlock(x, random.nextInt(height-1), z, Block.lavaStill.blockID);
       }

 
}

public void buildPlatform(World world, int i, int j, int k){
	int platformsize = 7;
	 int x = i-platformsize;
     int z = k-platformsize;
	 int y = j-1;
    	for(int a = 0;a < 2*platformsize;a++)
    	    {
			    z=k-platformsize;
			    		for(int b = 0;b <2* platformsize;b++)
			    	    {			
					    		world.setBlock(x, y, z, Block.wood.blockID);
					    	
			    		     z++;  	    
			    	    }
			    x++;
    	    } 
     x = i+platformsize-2;
     z = k-1;
   	 y = j-1;	
		   	for(int b = 0;b <3;b++)
		    {			
		    		world.setBlock(x, y, z, Block.blockDiamond.blockID);
		    	
			     z++;  	    
		    }
	x = i+platformsize-3;
    z = k-2;
           world.setBlock(x, y, z, Block.blockDiamond.blockID);
           x = i+platformsize-3;
           z = k+2;
                  world.setBlock(x, y, z, Block.blockDiamond.blockID);

           x = i+platformsize-4;
           z = k-3;
                  world.setBlock(x, y, z, Block.blockDiamond.blockID);
           x = i+platformsize-4;
           z = k+3;
                         world.setBlock(x, y, z, Block.blockDiamond.blockID);
                         x = i+platformsize-5;
                         z = k+3;
                                       world.setBlock(x, y, z, Block.blockDiamond.blockID);
                                       x = i+platformsize-6;
                                       z = k+3;
                                                     world.setBlock(x, y, z, Block.blockDiamond.blockID);
           for(int b = 0;b <7;b++)
              {			
                world.setBlock(x, y, z, Block.blockDiamond.blockID);
                x--;                        		    	
                z--;  	    
              }	
           for(int b = 0;b <8;b++)
           {			
             world.setBlock(x, y, z, Block.blockDiamond.blockID);                       		    	
             z++;  	    
           }	
    	
    	
    	
    	
    world.setBlockAndMetadataWithNotify(i, j+1, k, Block.signPost.blockID,4);
    TileEntitySign tileentitysign = (TileEntitySign)world.getBlockTileEntity(i, j+1, k);
    tileentitysign.signText[0]="Welcome To The";
    tileentitysign.signText[1]="World Of";
    tileentitysign.signText[2]= codebase2.getName();
}


public void buildRail(World world,int z){
	List<Town> towns = codebase2.getTown();
	for(int i = 0; i < towns.size(); i ++){
		Town t = towns.get(i);
		List<Town> linkedtowns = t.getLinkedTown();
		
		for(int j = 0; j < linkedtowns.size();j++){
			Town ltown = linkedtowns.get(j);
			//get one linked town
			for(int k = 0; k < towns.size(); k ++){
				if(towns.get(k).getName().equals(ltown.getName()))
					ltown = towns.get(k);
			}
			//get the station coor
			int x = t.getStationX();
			int y = t.getStationY();
			int x1 = ltown.getStationX();
			int y1 = ltown.getStationY();
			
            while((x-x1)!=0){
	    		world.setBlock(x, z, y, Block.railPowered.blockID);
	    		if((x-x1)<0){
	    			x++;
	    		}
	    		else{
	    			x--;
	    		}
            }
            
            while((y-y1)!=0){
	    		world.setBlock(x, z, y, Block.railPowered.blockID);
	    		if((y-y1)<0){
	    			y++;
	    		}
	    		else{
	    			y--;
	    		}
            }
			
		}
	}
	
}
public int chooseMaterial(int n,int fnc){
	int block =  Block.blockSteel.blockID;
	if(n==0){
		return block;
	}
	if((int)(fnc%n)==0){
		block = fncBlock1;
	}
	else if((int)(fnc%n)==1)
		block = fncBlock2;
	else if((int)(fnc%n)==2)
		block = fncBlock3;
	else if((int)(fnc%n)==3)
		block = fncBlock4;
	else if((int)(fnc%n)==4)
		block = fncBlock5;
	else if((int)(fnc%n)==5)
		block = fncBlock6;
	else{
		if(lastM==block){
			block = Block.sandStone.blockID;
			lastM = block;
		}
		
	}
	
	return block;
	
}

public static void generateSampleCodeBase(){
	Town t1 = new Town();
	Town t2 = new Town();
	Town t3 = new Town();
	Building buildA = new Building();
	buildA.setName("A");
	buildA.setHeight(8);
	buildA.setNumberOfFunctions(4);
	buildA.setTotalNCSS(2);
	buildA.setBugs(12);
	Building buildB = new Building();
	buildB.setName("B");
	buildB.setHeight(7);
	buildB.setNumberOfFunctions(3);
	buildB.setTotalNCSS(1);
	buildB.setBugs(4);
	Building buildC = new Building();
	buildC.setName("C");
	buildC.setHeight(12);
	buildC.setNumberOfFunctions(5);
	buildC.setTotalNCSS(3);
	buildC.setBugs(8);
	Building buildD = new Building();
	buildD.setName("D");
	buildD.setHeight(12);
	buildD.setNumberOfFunctions(2);
	buildD.setTotalNCSS(4);
	buildD.setBugs(1);
	Building buildE = new Building();
	buildE.setName("E");
	buildE.setHeight(15);
	buildE.setNumberOfFunctions(1);
	buildE.setTotalNCSS(4);
	buildE.setBugs(10);
	Building buildF = new Building();
	buildE.setName("F");
	buildE.setHeight(25);
	buildE.setNumberOfFunctions(4);
	buildE.setTotalNCSS(5);
	buildE.setBugs(7);
	Building buildG = new Building();
	buildE.setName("G");
	buildE.setHeight(15);
	buildE.setNumberOfFunctions(2);
	buildE.setTotalNCSS(5);
	buildE.setBugs(4);
	t1.addBuilding(buildF);
	t1.addBuilding(buildC);
	t1.addBuilding(buildE);
	t1.addBuilding(buildD);
	t2.addBuilding(buildC);
	t2.addBuilding(buildD);
	t2.addBuilding(buildB);
	t2.addBuilding(buildA);
	t2.addBuilding(buildD);
	t2.addBuilding(buildG);
	t3.addBuilding(buildE);
	t2.addBuilding(buildD);
	t2.addBuilding(buildG);
	t1.addLinkedTown(t2);
	t1.addLinkedTown(t3);
	t2.addLinkedTown(t3);
	t1.setName("CrazyApple");
	t2.setName("StupidOrange");
	t3.setName("SmartBerry");
	codebase2.addTown(t1);
	codebase2.addTown(t2);
	codebase2.addTown(t3);
	codebase2.setName("FruitMad");
}

public void setCodeBase(CodeBase cb){
	codebase2 = cb;
	
}

public void generateCodeBase(EntityPlayer par5EntityPlayer){
	 String currDir = System.getProperty("user.dir");
		
		// Temp value
		String pathCodeBase = currDir + "/CodeBases/CodeBase2";
		
		String pathJDepxml = pathCodeBase + "/JDepReport.xml";
		String pathFindBugsXML = pathCodeBase + "/FindBugsReport.xml";
		String pathNCSSxml = pathCodeBase + "/NCSSReport.xml";
		//test info
		par5EntityPlayer.addChatMessage("pathJDepxml:" +pathJDepxml);
		par5EntityPlayer.addChatMessage(" pathFindBugsXML:" + pathFindBugsXML);
		par5EntityPlayer.addChatMessage("pathNCSSxml:" +pathNCSSxml);
		XMLParser xp2 = new XMLParser();
		codebase2 = xp2.runParsing(pathNCSSxml, pathFindBugsXML, pathJDepxml);
		//test info
		par5EntityPlayer.addChatMessage("codebase info:" +codebase2.name);
		for(int i = 0; i<codebase2.Towns.size();i++){
		String townName = codebase2.Towns.get(i).name;
		par5EntityPlayer.addChatMessage("Town info:" +townName);
		}
    
}

}

