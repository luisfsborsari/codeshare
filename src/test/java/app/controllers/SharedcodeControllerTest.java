package app.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SharedcodeControllerTest {

	@Test public void fakeTest() {
		assertNotNull("put something real.", new SharedcodeController(null, null, null));
 	}
}
