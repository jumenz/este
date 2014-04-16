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

/** externe Klassen */
import static org.junit.Assert.*;
import org.junit.Test;
/** import own classes */
import fhwedel.medienprojekt.fussball.controller.HomeController;

/**
 * HomeControllerTest
 * Testet die Funktionalität des HomeControllers.
 */
public class HomeControllerTest {
	
	/**
	 * Testet den zurückgegebenen ViewName. 
	 */
	@Test
	public void testDisplayHome() {
		HomeController controller = new HomeController();
		String viewName = controller.displayHome();
		assertEquals(Constants.viewNameHome, viewName);
	}

}
