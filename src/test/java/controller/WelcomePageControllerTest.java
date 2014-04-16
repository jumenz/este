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
import fhwedel.medienprojekt.fussball.controller.WelcomePageController;

/**
 * WelcomePageControllerTest
 */
public class WelcomePageControllerTest {
	
	/**
	 * Testet den zurückgegebenen ViewName. 
	 */
	@Test
	public void testDisplayWelcomePage() {
		WelcomePageController controller = new WelcomePageController();
		String viewName = controller.displayWelcomePage();
		assertEquals("welcome", viewName);
	}

}
