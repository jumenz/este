/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package controller;

import static org.junit.Assert.*;
import org.junit.Test;

import fhwedel.medienprojekt.fussball.controller.LinksController;

/**
 * LinksControllerTest
 * Testet die Funktionalität des Controllers der Link-Seite.
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
