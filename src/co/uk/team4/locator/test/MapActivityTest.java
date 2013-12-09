package co.uk.team4.locator.test;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.TextView;
import co.uk.team4.locator.*;


import com.jayway.android.robotium.solo.Solo;


//public class MainActivityUnitTest extends AndroidTestCase {
public class MapActivityTest extends ActivityInstrumentationTestCase2<MapActivity>{
	private Solo solo;
	
	private Intent intent;
	private MapActivity activity;
	private Activity activitytest;
	private boolean actual;

	public MapActivityTest() {
	    super(MapActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
	    super.setUp();
	    solo=new Solo(getInstrumentation(),getActivity());
	}
	
	public void testLayoutMap() {
		actual = solo.searchButton("Check-in");
		assertEquals("Submit Button not found",true, actual);
	}
	public void testPhotoLaunch() {
		solo.assertCurrentActivity("Wrong activity", MapActivity.class);
		solo.clickOnButton("Check-in");
		solo.assertCurrentActivity("Wrong activity", PhotoActivity.class);
	}
	
	@Override
	protected void tearDown() throws Exception {
        super.tearDown();
	}
}
