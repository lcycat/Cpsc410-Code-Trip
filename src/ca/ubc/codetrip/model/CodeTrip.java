package ca.ubc.codetrip.model;


public class CodeTrip {

	public CodeTrip() {
	}
	
	public static String directory;
	
	public static void main(String [] args) throws InterruptedException {
		CodeParser cp = new CodeParser();
		directory = cp.codeParse();
		
		XMLParser xp = new XMLParser();
		xp.parseXMLFile(directory);
	}
	
}
