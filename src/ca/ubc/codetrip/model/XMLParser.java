package ca.ubc.codetrip.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLParser {
	
	public XMLParser(){
	}
	
	public static List<Town> listOfTowns = new ArrayList<Town>();
	
	// Function to call all the parsers and return the CodeBase  
	public CodeBase runParsing (CodeBase codeBase, String NCSS, String BugFinder, String JDepend)
	{
		this.parseNCSS(codeBase, NCSS);
		this.parseBugFinder(listOfTowns, BugFinder);
		this.parseJDepend(listOfTowns, JDepend);
		
		codeBase.setListOfTowns(listOfTowns);
		
		return codeBase;
	}
	
	// Function to parse the NCSS XML Output 
	// It will create a list the initial list of Towns aka Packages as well as the Buildings aka Classes
	// It requires a CodeBase and the file directory to access the XML
	public void parseNCSS (CodeBase codeBase, String fileDirectory)
	{
		List<Building> listOfBuildings = new ArrayList<Building>();
		
		try {
			
			// Uncomment below portion to test the parser separately without running the analyzer 
			//String pathLib =  System.getProperty("user.dir") + "/lib";
			//String pathXML = pathLib + "/NCSSTEST.xml";
			//File xmlFile = new File(pathXML);
			
			File xmlFile = new File(fileDirectory);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			int maxNCSS = 0;
		
			// Parse the class information
			NodeList nList = doc.getElementsByTagName("object");
			
			// loop through each 'object' tag in the XML file
			for (int temp = 0; temp < nList.getLength(); temp++) {
				 
				Node nNode = nList.item(temp);
				
				Element eElement = (Element) nNode;
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					System.out.println("Class Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					
					// get the Package and Class name
					String x = eElement.getElementsByTagName("name").item(0).getTextContent();
					String[] pieces = x.split("\\.");
					
					// set Code Base name
					codeBase.setName(pieces[0]);
					
					
					String pname = null;
					String name = null;
					
					// the Main method is only split into two pieces so need to check for this
					if (pieces[1].equals("Main")) {
						 name = pieces[1];
						 pname = pieces[0];
					}
					else {
						 name = pieces[2];
						 pname = pieces[0] + "." + pieces[1];
					}
					
					
					
					// check if already created this town, if not, create
					if (!townExists(listOfTowns, pname)) {
						Town town = new Town();
						town.setName(pname);
						listOfTowns.add(town);
					}
					
					
					// check if we already created this building, if not, create
					if (listOfBuildings.size() != 0) {
						Building previousBuilding = listOfBuildings.get(listOfBuildings.size() - 1);
						if (!previousBuilding.getName().equals(name)) {
							Building building = new Building();
							building.setName(name);
							
							System.out.println("Class namesaved: " + name);
							
							// check if this class's total NCSS is the highest so far
							int currentNCSS = Integer.parseInt(eElement.getElementsByTagName("ncss").item(0).getTextContent());
							if (maxNCSS < currentNCSS) {
								maxNCSS = currentNCSS;
							}
							
							building.setTotalNCSS(Integer.parseInt(eElement.getElementsByTagName("ncss").item(0).getTextContent()));							
							System.out.println("Class NCSS : " + eElement.getElementsByTagName("ncss").item(0).getTextContent());

							building.setNumberOfFunctions(Integer.parseInt(eElement.getElementsByTagName("functions").item(0).getTextContent()));
							System.out.println("Number of Functions: " + eElement.getElementsByTagName("functions").item(0).getTextContent());
							
							System.out.println();
							
							listOfBuildings.add(building);
							
							// find the town this building belongs to and add it to the town
							Town town = findTown(listOfTowns, pname);
							List<Building> townBuildings = town.getListOfBuildings();
							townBuildings.add(building);
							town.setListOfBuildings(townBuildings);
							
						}
					}
					if (listOfBuildings.size() == 0) {
						Building building = new Building();
						building.setName(name);
						System.out.println("namesaved: " + name);
						System.out.println("pname: " + pname);
						
						maxNCSS = Integer.parseInt(eElement.getElementsByTagName("ncss").item(0).getTextContent());
						building.setTotalNCSS(Integer.parseInt(eElement.getElementsByTagName("ncss").item(0).getTextContent()));							
						System.out.println("Class NCSS : " + eElement.getElementsByTagName("ncss").item(0).getTextContent());

						building.setNumberOfFunctions(Integer.parseInt(eElement.getElementsByTagName("functions").item(0).getTextContent()));
						System.out.println("Number of Functions: " + eElement.getElementsByTagName("functions").item(0).getTextContent());
						
						System.out.println();
						
						listOfBuildings.add(building);
						
						// find the town this building belongs to and add to the town
						Town town = findTown(listOfTowns, pname);
						List<Building> townBuildings = town.getListOfBuildings();
						townBuildings.add(building);
						town.setListOfBuildings(townBuildings);
					}
				}
			}
			
			setMaxNCSS(maxNCSS, listOfBuildings);
			calculateBuildingHeight(listOfBuildings, maxNCSS);
			
			
			// Parse the functions associated with the class
			NodeList nList2 = doc.getElementsByTagName("function");
			
			// loop through each 'function' tag in the XML file
			for (int temp = 0; temp <nList2.getLength(); temp++) {
				
				Node nNode = nList2.item(temp);
				
				Element eElement = (Element) nNode;
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					// get the class name, then building associated with the name
					System.out.println("Function Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					
					String x = eElement.getElementsByTagName("name").item(0).getTextContent();
					String[] pieces = x.split("\\.");
					
					// check if it is the Main function
					String name	;
					if (pieces[1].equals("Main")) {
						 name = pieces[1];
					}
					else {
						 name = pieces[2];
					}
					
					System.out.println(temp);
					Building building = findBuildingName(listOfBuildings, name);
					
					int functionNCSS = Integer.parseInt(eElement.getElementsByTagName("ncss").item(0).getTextContent());
					building.calculateFunctionRatio(functionNCSS);
				
					System.out.println("Function NCSS : " + eElement.getElementsByTagName("ncss").item(0).getTextContent());
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		    }
	}
	
	
	// Function to parse the FindBugs XML Output
	// It will add the number of bugs in the provided List<Town>
	// Requires the List<Town> and the file directory of the XML
	public void parseBugFinder (List<Town> listOfTowns, String fileDirectory)
	{
		try {
			
			//Uncomment below to test locally 
			//String pathLib =  System.getProperty("user.dir") + "/lib";
			//String pathXML = pathLib + "/findBugsTEST.xml";
			//File xmlFile = new File(pathXML);
			
			File xmlFile = new File(fileDirectory);
				
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
				
			doc.getDocumentElement().normalize();
				
		    NodeList nList = doc.getElementsByTagName("Class");

		    for (int temp = 0; temp < nList.getLength(); temp++) {

		    	Node nNode = nList.item(temp);

			   	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    	
			    	NamedNodeMap attributes = (NamedNodeMap)nNode.getAttributes();
			    	Attr attribute = (Attr)attributes.item(0);
			    		
			    	// get the package and class name
			    	String x = attribute.getValue();
			    	String[] pieces = x.split("\\.");
			    	
			    	// the Main method is only split into two pieces so need to check for this
					String name;
					String pname;
					if (pieces[1].equals("Main")) {
						 name = pieces[1];
						 pname = pieces[0];
					}
					else {
						 name = pieces[2];
						 pname = pieces[0] + "." + pieces[1];
					}
				
			    	Town town = findTown(listOfTowns, pname);
			    	
			    	List<Building> listOfBuildings = town.getListOfBuildings();
			    	Building building = findBuildingName(listOfBuildings, name);
			    	
			    	// if building exists, set the bug number
			    	if (building != null) {
			    		int bugNumber = building.getBugNumber();
			    		System.out.println("Previous Bug Number: " + bugNumber);
			    		building.setBugNumber(bugNumber+1);
			    	}
			    }
		    }
		}
		catch (Exception e) {
			//TODO catch block
			e.printStackTrace();
		  }
	}
	
	// Function to parse the JDepend XML Output
	// It will set the dependencies for the Towns 
	// Requires the List<Town> and the file directory of the XML
	 public void parseJDepend (List<Town> townList, String fileDirectory)
	 {
		try
		{
			/*String pathLib =  System.getProperty("user.dir") + "/lib";
			String pathXML = pathLib + "/JDepReportMicropolis.xml";
			File xmlFile = new File(pathXML);*/
			
			File xmlFile = new File(fileDirectory);
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize(); 
		    
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			NodeList nList = (NodeList) xpath.evaluate("JDepend/Packages/Package", doc,
			    XPathConstants.NODESET);
			
			
			for (int temp = 0; temp < nList.getLength(); temp++) {

		    	Node nNode = nList.item(temp);
		    	
		    	Element eElement = (Element) nNode;
		    	
			   	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			   		
			   		NamedNodeMap attributes = (NamedNodeMap)nNode.getAttributes();
			    	Attr attribute = (Attr)attributes.item(0);
			    	String pname = attribute.getValue();
			    	
			    	System.out.println(pname);
			    	
			    	Town townFound = findTown(townList, pname);
			    	
			    	if (townFound != null) {
			    		
			    		String x = eElement.getElementsByTagName("DependsUpon").item(0).getTextContent();
			    		String[] pieces = x.split("\\s+");
			    		
			    		for (int i = 0; i < pieces.length; i++) {
			    			
			    			if (townExists(townList, pieces[i])) {
			    				Town dependTown = new Town();
			    				dependTown = findTown(townList, pieces[i]);
			    				List<Town> dependencies = townFound.getDependenciesTowns();
			    				dependencies.add(dependTown);
			    				townFound.setDependenciesTowns(dependencies);
			    			}
			    		}
			    	}
			   	}
			}
		}
		catch (Exception e) {
		e.printStackTrace();
	  }
	}
	 
	 
	 
	    // BELOW ARE PRIVATE HELPER FUNCTIONS

		// Calculate the height of each building
		private static void calculateBuildingHeight(List<Building> listOfBuildings, int maxNCSS) {
			for (Building b : listOfBuildings) {
				int buildingNCSS = b.getTotalNCSS();
				double tempHeight = (buildingNCSS/(double)maxNCSS);
				int height = (int)Math.ceil(tempHeight*Building.getMaxHeight());
				b.setHeight(height);
			}
		}

		// Sets the maxNCSS for each Building object in the list
		private static void setMaxNCSS(int maxNCSS, List<Building> listOfBuildings) {
			for (Building b : listOfBuildings) {
				b.setMaxNCSS(maxNCSS);
			}
		}

		//Find the building with string name in a list of buildings
		private static Building findBuildingName(List<Building> buildingList, String name) {
			for (Building object : buildingList) {
				if (object.getName().equals(name)) {
					return object;
				}
			}
			return null;
		}
		
		//Determine if this town already exists
		private static boolean townExists(List<Town> townList, String name) {
			for (Town object : townList) {
				if (object.getName().equals(name)) {
					return true;
				}
			}
			return false;
		}
		
		//Find the town with this string name in a list of towns
		private static Town findTown(List<Town> townList, String name) {
			for (Town object : townList) {
				if (object.getName().equals(name)) {
					return object;
				}
			}
			return null;
		}	 
	 
}
