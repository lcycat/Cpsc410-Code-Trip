package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;



public class CodeBase {
	public  List<Town> Towns = new ArrayList<Town>();
	public String name = "";
	
	public CodeBase(){
		
	}
	
    public CodeBase(String n){
		this.name = n;
	}
	

	
	public void addTown(Town t){
		this.Towns.add(t);
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	
	public List<Town> getTown(){
		return Towns;
	}
	
	public String getName(){
		return name;
	}
	public void setListOfTowns(List<Town> listOfTowns) {
		this.Towns = listOfTowns;
	}
		
	

}

