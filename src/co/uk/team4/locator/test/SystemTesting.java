package co.uk.team4.locator.test;

import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;
import co.uk.team4.locator.MainActivity;

public class SystemTesting extends ActivityInstrumentationTestCase2<MainActivity> {
	Solo solo;
	
	public SystemTesting() {
	    super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
	    super.setUp();
	    solo=new Solo(getInstrumentation(),getActivity());
	    assertNotNull("activity should be launched successfully", getActivity());
	}
	
	public void testSystemTesting(){
		solo.clickOnButton("Begin");
	    solo.clickOnButton("Check-in");
	    solo.clickOnButton("Take Picture");
	}
	
	@Override
	protected void tearDown() throws Exception {
        super.tearDown();
	}
}
