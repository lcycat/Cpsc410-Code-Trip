package net.minecraft.src;
import java.util.ArrayList;
import java.util.List;


public class Building {
	
	
	
	public final static int MAX_HEIGHT = 100;
	
	public String name = "";
	public int maxNCSS = 1 ;
	public int height = 2;
	public int numberOfFunctions =2;
	public int totalNCSS = 2;
	public int bugs = 2;
	public List<Double> functionRatios = new ArrayList<Double>();
	
	public Building () {

		
		
	}
	
	public int getMaxNCSS() {
		return maxNCSS;
	}

	public void setMaxNCSS(int maxNCSS) {
		this.maxNCSS = maxNCSS;
	}

	public String getName() {
		return name;
	}
	

	public static int getMaxHeight() {
		return MAX_HEIGHT;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfFunctions() {
		return numberOfFunctions;
	}

	public void setNumberOfFunctions(int numberOfFunctions) {
		this.numberOfFunctions = numberOfFunctions;
	}

	public int getTotalNCSS() {
		return totalNCSS;
	}

	public void setTotalNCSS(int totalNCSS) {
		this.totalNCSS = totalNCSS;
	}
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getBugs() {
		return bugs;
	}

	public void setBugs(int bugs) {
		this.bugs = bugs;
	}
	public void calculateFunctionRatio (int functionNCSS) {
		double ratio = functionNCSS/(double)totalNCSS;
		
		//convert to three decimals
		ratio = Math.round(ratio*1000.0)/1000.0;
		functionRatios.add(ratio);
	}
	
}
