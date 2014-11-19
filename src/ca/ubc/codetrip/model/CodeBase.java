package ca.ubc.codetrip.model;

import java.util.ArrayList;
import java.util.List;

public class CodeBase {
	
	public CodeBase() {
	}
	
	public  List<Town> listOfTowns = new ArrayList<Town>();
	public String name = "";
	
	
	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return name;
	}

	public void setListOfTowns(List<Town> townList) {
		this.listOfTowns = townList;
		
	}
}
