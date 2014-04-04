package controller;
/** import Java classes */
import static org.junit.Assert.*;
import org.junit.Test;
/** import own classes */
import fhwedel.medienprojekt.fussball.controller.ImpressumController;

/**
 * ImpressumControllerTest
 * Tests the functionality of the Impressum Controller.
 * 
 * @author Ellen
 */
public class ImpressumControllerTest {
	
	/**
	 * The ImpressumController should return "impressum" as viewName, when displayHome
	 * is executed. 
	 */
	@Test
	public void testDisplayImpressum() {
		ImpressumController controller = new ImpressumController();
		String viewName = controller.displayImpressum();
		assertEquals("impressum", viewName);
	}

}
