package com.example.mry_cardiac_recorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@LargeTest

public class RecordUITest  {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAddButton() {

        /*
        add
         */
        onView(withId(R.id.AddBUttonId)).perform(click());
        onView(withId(R.id.dateValue)).perform(ViewActions.typeText("12/10/2021"));
        onView(withId(R.id.timeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.systolicValue)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolicValue)).perform(ViewActions.typeText("90"));
        // pressBack();
        onView(withId(R.id.heartRateValue)).perform(ViewActions.typeText("80"));
        pressBack();
        onView(withId(R.id.commentValue)).perform(ViewActions.typeText("UI test data insert"));
        pressBack();
        onView(withId(R.id.addButton)).perform(click());




        /*
        To view
        */
        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.recyclarView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        pressBack();

        /*
        To update
         */
        // Match the text in an item below the fold and check that it's displayed.
        onView(withId(R.id.recyclarView)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, uitest.clickChildViewWithId(R.id.Edit_buttonId)));
        onView(withId(R.id.UdateValue)).perform(ViewActions.clearText());
        onView(withId(R.id.UdateValue)).perform(ViewActions.typeText("11/10/2021"));
        onView(withId(R.id.UtimeValue)).perform(ViewActions.clearText());
        onView(withId(R.id.UtimeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.UsystolicValue)).perform(ViewActions.clearText());
        onView(withId(R.id.UsystolicValue)).perform(ViewActions.typeText("110"));
        onView(withId(R.id.UdiastolicValue)).perform(ViewActions.clearText());
        onView(withId(R.id.UdiastolicValue)).perform(ViewActions.typeText("80"));
        // pressBack();
        onView(withId(R.id.UheartRateValue)).perform(ViewActions.clearText());
        onView(withId(R.id.UheartRateValue)).perform(ViewActions.typeText("70"));
        pressBack();
        onView(withId(R.id.UcommentValue)).perform(ViewActions.clearText());
        onView(withId(R.id.UcommentValue)).perform(ViewActions.typeText("Updated"));
        pressBack();
        onView(withId(R.id.UpdateButtonId)).perform(click());

        /*
        To delete
        */

        onView(withId(R.id.recyclarView)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, uitest.clickChildViewWithId(R.id.DeleteBUttonId)));

        RecordList.mcl.clear();

        new Utils().equals(InstrumentationRegistry.getInstrumentation().getContext());

    }

}
