package controller;
/** import Java classes */
import static org.junit.Assert.*;
import org.junit.Test;
/** import own classes */
import fhwedel.medienprojekt.fussball.controller.WelcomePageController;

/**
 * WelcomePageControllerTest
 * Tests the functionality of the Home Controller.
 * 
 * @author Ellen
 */
public class WelcomePageControllerTest {
	
	/**
	 * The WelcomePageController should return "welcome" as viewName, when displayHome
	 * is executed. 
	 */
	@Test
	public void testDisplayWelcomePage() {
		WelcomePageController controller = new WelcomePageController();
		String viewName = controller.displayWelcomePage();
		assertEquals("welcome", viewName);
	}

}
