package ca.ubc.codetrip.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import ca.ubc.codetrip.model.XMLParser;
import ca.ubc.codetrip.model.Building;

import org.junit.Before;
import org.junit.Test;

public class XMLParserTest {
	
	List<Building> listOfBuildings = new ArrayList<Building>();
	String fileDirectory = System.getProperty("user.dir") + "/lib" + "/test.xml";
	XMLParser xp;
	
	@Before
	public void testXMLParser() {
		xp = new XMLParser();
	}
	
	// test the number of buildings created is true from a test.xml file
	@Test
	public void testListOfBuildingsSize () {
		listOfBuildings = xp.parseXMLFile(fileDirectory);
		assertTrue(listOfBuildings.size() == 3);
	}

}
