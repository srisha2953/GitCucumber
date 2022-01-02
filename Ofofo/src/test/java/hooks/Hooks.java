package hooks;

import Automation.Ofofo.Base;
import io.cucumber.java.After;

public class Hooks extends Base {

	@After("@SeleniumTest")
	public void closeBrowser()
	{
		
		driver.close();
	}
}
