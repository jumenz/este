package controller;
/** import Java classes */
import static org.junit.Assert.*;
import org.junit.Test;
/** import own classes */
import fhwedel.medienprojekt.fussball.controller.LoginPageController;

/**
 * HomeControllerTest
 * Tests the functionality of the Home Controller.
 * 
 * @author Ellen
 */
public class LoginPageControllerTest {
	
	/**
	 * The LoginPageController should return "login" as viewName, when displayLoginPage
	 * is executed. 
	 */
	@Test
	public void testDisplayHome() {
		LoginPageController controller = new LoginPageController();
		String viewName = controller.displayLoginPage();
		assertEquals("login", viewName);
	}

}
