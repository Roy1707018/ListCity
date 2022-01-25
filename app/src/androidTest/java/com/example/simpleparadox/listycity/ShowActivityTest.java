package com.example.simpleparadox.listycity;

import static junit.framework.TestCase.assertTrue;

import android.widget.EditText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for MainActivity. All the UI tests are written here. Robotium test framework is
 used
 */
@RunWith(AndroidJUnit4.class)

public class ShowActivityTest {
    private Solo solo;
    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);
    /**
     * Runs before all tests and creates solo instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }
    @Test
    public void switchActivity(){
        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button

        //Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "KHULNA");
        solo.clickOnButton("CONFIRM"); //Select CONFIRM Button

        solo.clickOnText("KHULNA");
        solo.assertCurrentActivity("Can't load ShowActivity", ShowActivity.class);
        assertTrue(solo.waitForText("KHULNA", 1, 2000));
        solo.clickOnButton("Back"); //Select ClEAR ALL
        solo.assertCurrentActivity("Can't return MainActivity", MainActivity.class);
        assertTrue(solo.waitForText("KHULNA", 1, 2000));
    }
    /**
     * Close activity after each test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception{
        solo.waitForActivity("showActivityTest", 2000);
        solo.finishOpenedActivities();

    }

}
