package net.minecraft.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;





public class Town {
	public  List<Building> ownBuildings = new ArrayList<Building>();	
	public  List<Town> linkedTowns = new ArrayList<Town>();
	public String name = "";
	private int stationX = 0;
	private int stationY = 0;
	
	public Town(){
		
	}
	
	public void addBuilding(Building b){
		this.ownBuildings.add(b);
	}
	
	public void addLinkedTown(Town t){
		this.linkedTowns.add(t);
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public List<Building> getBuilding(){
		return ownBuildings;
	}
	
	public List<Town> getLinkedTown(){
		return linkedTowns;
	}
	
	public String getName(){
		return name;
	}
	
	public void setStationX(int x){
		this.stationX = x;
	}
	
	public void setStationY(int y){
		this.stationY = y;
	}
	
	public int getStationX(){
		return stationX;
	}
	
	public int getStationY(){
		return stationY;
	}
	
	public void setListOfBuildings(List<Building> listOfBuildings) {
		this.ownBuildings = listOfBuildings;
	}
	
	public void setDependenciesTowns(List<Town> dependenciesTowns) {
		this. linkedTowns = dependenciesTowns;
	}

}

