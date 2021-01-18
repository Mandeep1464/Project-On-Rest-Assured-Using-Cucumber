package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void init() {
		System.out.println("Before invoke hooks");
	}
	@After
	public void closeUp() {
		System.out.println("After invoke hooks");
	}

}
