package ca.ubc.codetrip.test;

import static org.junit.Assert.*;

import ca.ubc.codetrip.model.Building;

import org.junit.Before;
import org.junit.Test;



public class BuildingTest {
	
	Building building;
	
	@Before
	public void testBuilding () {
		building = new Building();
	}
	
	@Test
	public void getBuildingMaxHeight () {
		assertEquals(100, Building.getMaxHeight());
	}
	
	@Test
	public void getBuildingHeight () {
		// building should not be higher than max height
		assertFalse(Building.getHeight() > Building.getMaxHeight());
	}
	
	@Test
	public void addFunctionRatio () {
		building.setTotalNCSS(20);
		building.calculateFunctionRatio(10);
		// check that the function ratio is actually inserted correctly
		assertTrue(building.getFunctionRatios().get(0) == 0.5);
	}
	
}
