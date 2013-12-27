package controller;
/** import Java classes */
import static org.junit.Assert.*;
import org.junit.Test;
/** import own classes */
import fhwedel.medienprojekt.fussball.controller.HomeController;

/**
 * AboutUsControllerTest
 * Tests the functionality of the About-Us Controller.
 * 
 * @author Ellen
 */
public class AboutUsControllerTest {
	
	/**
	 * The HomeController should return "home" as viewName, when displayHome
	 * is executed. 
	 */
	@Test
	public void testDisplayHome() {
		HomeController controller = new HomeController();
		String viewName = controller.displayHome();
		assertEquals("home", viewName);
	}

}
