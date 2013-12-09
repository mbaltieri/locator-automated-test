package co.uk.team4.locator.test;

import android.content.Intent;
import android.os.Debug;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import co.uk.team4.locator.*;
import co.uk.team4.locator.R;

public class PhotoActivityTest extends ActivityUnitTestCase<PhotoActivity> {
	private Intent intent;
	private PhotoActivity activity;
	
	public PhotoActivityTest() {
	    super(PhotoActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
	    super.setUp();
	    intent = new Intent(getInstrumentation().getTargetContext(), PhotoActivity.class);
	    startActivity(intent, null, null);
	    activity = getActivity();
	}
	  public void testLayoutPhoto() {
		    // Verifies the button and text field exist
		    assertNotNull(activity.findViewById(R.id.btnIntend));
		    // Verifies the text of the button
		    
		    Button view = (Button) activity.findViewById(R.id.btnIntend);
		    assertEquals("Incorrect label of the button", "Take Picture", view.getText());
		  }
	
	public void testCameraLaunch() {
		getInstrumentation().callActivityOnStart(activity);
		final Button launchNextButton = (Button) getActivity().findViewById(R.id.btnIntend);
		launchNextButton.performClick();
		
		final Intent launchIntent = getStartedActivityIntent();
		assertNotNull("Intent was null", launchIntent);
	}
	
	@Override
	protected void tearDown() throws Exception {
        super.tearDown();
	}
}
