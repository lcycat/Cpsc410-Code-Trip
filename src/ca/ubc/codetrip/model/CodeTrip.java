package ca.ubc.codetrip.model;

import java.io.IOException;
import java.util.Scanner;

public class CodeTrip {

	public CodeTrip() {
	}
	
	public static String pathNCSSxml;
	public static String pathJDepxml;
    public static String pathFindBugsXML;
    public static CodeBase codebase;
    
	
	public static void main(String [] args) throws InterruptedException, IOException {
		
		//Prompt user to enter full path of code base
		Scanner input = new Scanner(System.in);
		System.out.println("Enter absolute path of code base: ");
		String pathCodeBase = input.nextLine();
		input.close();
		
		String currDir = System.getProperty("user.dir");
		
		// Temp value
		pathCodeBase = currDir + "/lib/JavaGame-master";
		
		
		CodeParser cp = new CodeParser();
		pathNCSSxml = cp.parseToNCSS(currDir, pathCodeBase);
		pathJDepxml = cp.parseToJDepend(currDir, pathCodeBase);
        pathFindBugsXML = cp.parseToFindBugs(currDir, pathCodeBase);
		
        // Call the Parser to parse the output XML Files
        // Creates and populates the CodeBase
		XMLParser xp = new XMLParser();
		codebase = new CodeBase();
		codebase = xp.runParsing(codebase, pathNCSSxml, pathFindBugsXML, pathJDepxml);
		
	}
	
}
