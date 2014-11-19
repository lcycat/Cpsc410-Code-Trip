package ca.ubc.codetrip.model;

import java.util.ArrayList;
import java.util.List;

public class Town {
	
	public Town () {
	}
	
	
	private String name;
	private List<Building> listOfBuildings = new ArrayList<Building>();
	private List<Town> dependenciesTowns = new ArrayList<Town>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Building> getListOfBuildings() {
		return listOfBuildings;
	}
	public void setListOfBuildings(List<Building> listOfBuildings) {
		this.listOfBuildings = listOfBuildings;
	}
	public List<Town> getDependenciesTowns() {
		return dependenciesTowns;
	}
	public void setDependenciesTowns(List<Town> dependenciesTowns) {
		this.dependenciesTowns = dependenciesTowns;
	}
	
	
	


}
