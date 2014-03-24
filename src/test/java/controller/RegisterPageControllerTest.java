package controller;
/** import Java classes */
import static org.junit.Assert.*;
import org.junit.Test;

/** import own classes */
import fhwedel.medienprojekt.fussball.controller.RegisterPageController;

/**
 * RegisterControllerTest
 * Tests the functionality of the Register Controller.
 * 
 * @author Ellen
 */
public class RegisterPageControllerTest {
	
	/**
	 * The HomeController should return "home" as viewName, when displayRegisterPage
	 * is executed. 
	 */
	@Test
	public void testDisplayHome() {
		RegisterPageController controller = new RegisterPageController();
		String viewName = controller.displayRegisterPage();
		assertEquals("register-page", viewName);
	}

}
