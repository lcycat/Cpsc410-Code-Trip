package ca.ubc.cpsc410.codetrip;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLParser {
	
	public XMLParser(){
	}
	
	public List<Building> parseXMLFile (String fileDirectory)
	{
		List<Building> listOfBuildings = new ArrayList<Building>();
		
		try {
			//String pathLib =  System.getProperty("user.dir") + "/lib";
			//String pathXML = pathLib + "/TESTFINAL.xml";
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
					
					// get the Class name
					String x = eElement.getElementsByTagName("name").item(0).getTextContent();
					String[] pieces = x.split("\\.");
					
					// the Main method is only split into two pieces so need to check for this
					String name;
					if (pieces[1].equals("Main")) {
						 name = pieces[1];
					}
					else {
						 name = pieces[2];
					}
					
					// check if we already created this building
					if (listOfBuildings.size() != 0) {
						Building previousBuilding = listOfBuildings.get(listOfBuildings.size() - 1);
						if (!previousBuilding.getName().equals(name)) {
							Building building = new Building();
							building.setName(name);
							
							System.out.println("namesaved: " + name);
							
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
							
						}
					}
					if (listOfBuildings.size() == 0) {
						Building building = new Building();
						building.setName(name);
						System.out.println("namesaved: " + name);
						
						maxNCSS = Integer.parseInt(eElement.getElementsByTagName("ncss").item(0).getTextContent());
						building.setTotalNCSS(Integer.parseInt(eElement.getElementsByTagName("ncss").item(0).getTextContent()));							
						System.out.println("Class NCSS : " + eElement.getElementsByTagName("ncss").item(0).getTextContent());

						building.setNumberOfFunctions(Integer.parseInt(eElement.getElementsByTagName("functions").item(0).getTextContent()));
						System.out.println("Number of Functions: " + eElement.getElementsByTagName("functions").item(0).getTextContent());
						
						System.out.println();
						
						listOfBuildings.add(building);
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
					Building building = findClassName(listOfBuildings, name);
					
					int functionNCSS = Integer.parseInt(eElement.getElementsByTagName("ncss").item(0).getTextContent());
					building.calculateFunctionRatio(functionNCSS);
				
					System.out.println("Function NCSS : " + eElement.getElementsByTagName("ncss").item(0).getTextContent());
					System.out.println();
				}
			}
			
		} catch (Exception e) {
			//TODO catch block
			e.printStackTrace();
		    }
		
		return listOfBuildings;
	}
	
	
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
	private static Building findClassName(List<Building> buildingList, String name) {
		for (Building object : buildingList) {
			if (object.getName().equals(name)) {
				return object;
			}
		}
		return null;
	}
}
