package controller;
/** import Java classes */
import static org.junit.Assert.*;

import org.junit.Test;

import fhwedel.medienprojekt.fussball.controller.AboutUsController;
/** import own classes */
import fhwedel.medienprojekt.fussball.controller.HomeController;

/**
 * AboutUsControllerTest
 * Tests the functionality of the About-Us Controller.
 * 
 * @author Ellen Schwartau Minf9888
 */
public class AboutUsControllerTest {
	
	/**
	 * AboutUsController sollte den ViewName der About-Us JSP
	 * zurückliefern. 
	 */
	@Test
	public void testDisplayAboutUs() {
		AboutUsController controller = new AboutUsController();
		String viewName = controller.displayAboutUs();
		assertEquals(Constants.viewNameAboutUs, viewName);
	}

}
