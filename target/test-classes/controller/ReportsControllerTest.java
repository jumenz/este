package controller;
/** import Java classes */
import static org.junit.Assert.*;
import org.junit.Test;
/** import own classes */
import fhwedel.medienprojekt.fussball.controller.ReportsController;

/**
 * ReportsControllerTest
 * Tests the functionality of the Reports Controller.
 * 
 * @author Ellen
 */
public class ReportsControllerTest {
	
	/**
	 * The ReportsController should return "reports" as viewName, when displayHome
	 * is executed. 
	 */
	@Test
	public void testDisplayHome() {
		ReportsController controller = new ReportsController();
		String viewName = controller.displayReports();
		assertEquals("reports", viewName);
	}

}
