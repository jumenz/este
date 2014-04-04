package controller;

import static org.junit.Assert.*;
import org.junit.Test;

import fhwedel.medienprojekt.fussball.controller.LinksController;

/**
 * LinksControllerTest
 * Tests the functionality of the Home Controller.
 * 
 * @author Ellen Schwartau Minf9888
 */
public class LinksControllerTest {
	
	/**
	 * LinksController sollte den Viewname der Links zurückgeben. 
	 */
	@Test
	public void testDisplayLinks() {
		LinksController controller = new LinksController();
		String viewName = controller.displayLinks();
		assertEquals(Constants.viewNameLinks, viewName);
	}

}
