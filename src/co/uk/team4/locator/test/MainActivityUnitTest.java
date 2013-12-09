package co.uk.team4.locator.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.TextView;
import android.widget.Button;

import co.uk.team4.locator.LocationUploadService;
import co.uk.team4.locator.MapActivity;
import co.uk.team4.locator.MainActivity;
import co.uk.team4.locator.R;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.plus.PlusClient;
import com.jayway.android.robotium.solo.Solo;


//public class MainActivityUnitTest extends AndroidTestCase {
public class MainActivityUnitTest extends  ActivityUnitTestCase<MainActivity>{ //ActivityInstrumentationTestCase2<MainActivity>{
	public static final boolean DEBUG = true;
	Intent intent;
	private PlusClient mPlusClient;
	private Solo solo;
	private MainActivity activity;
	private LocationUploadService activity2;
	
	private int buttonId;
	private boolean actual;
	
	//private MainActivity activity;

	public MainActivityUnitTest() {
	    super(MainActivity.class);
	    if (DEBUG) {
			Debug.waitingForDebugger();
		}
	}
	
	
	@Override
	protected void setUp() throws Exception {
	    super.setUp();
	    intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
	    assertNotNull(intent);
	    startActivity(intent, null, null);
	    activity = getActivity();
	}
	
	  // Sanity check for the layout
	  public void testLayoutExists() {
	    // Verifies the button and text field exist
	    assertNotNull(activity.findViewById(R.id.begin_button));
	    assertNotNull(activity.findViewById(R.id.revoke_access_button));
	    // Verifies the text of the button
	    
	    Button view = (Button) activity.findViewById(R.id.begin_button);
	    assertEquals("Incorrect label of the button", "Begin", view.getText());
	    view = (Button) activity.findViewById(R.id.revoke_access_button);
	    assertEquals("Incorrect label of the button", "Revoke access", view.getText());
	  }
	
	public void testMapLaunch() throws InterruptedException {
		getInstrumentation().callActivityOnStart(activity);
		final SignInButton singInButton = (SignInButton) activity.findViewById(R.id.sign_in_button);
		final Button beginButton = (Button) activity.findViewById(R.id.begin_button);
		singInButton.performClick();
		beginButton.performClick();
		final Intent launchIntent = getStartedActivityIntent();
		assertNotNull("Intent was null", launchIntent);
		assertTrue(isFinishCalled());
	}
	
	public void testRevokeLaunch() {
		getInstrumentation().callActivityOnStart(activity);
		final Button beginButton = (Button) getActivity().findViewById(R.id.begin_button);
		final Button revokeButton = (Button) getActivity().findViewById(R.id.revoke_access_button);
		revokeButton.performClick();
		
		assertFalse(beginButton.isEnabled());
		assertFalse(revokeButton.isEnabled());
	}
	
	@Override
	protected void tearDown() throws Exception {
        super.tearDown();
	}
}
