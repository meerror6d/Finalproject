
package com.example.mry_cardiac_recorder;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.mry_cardiac_recorder.R;
import com.example.mry_cardiac_recorder.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class RecordUITest {

    @Rule
    public ActivityScenarioRule<record> activityRule = new ActivityScenarioRule<>(record.class);

    @Test
    public void testRecyclerViewDisplayed() {
        // Check if RecyclerView is displayed
        Espresso.onView(withId(R.id.recyclarView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testAddButton() {
        // Click on the Add button
        Espresso.onView(withId(R.id.AddBUttonId))
                .perform(ViewActions.click());

        // Add assertions or perform additional actions based on the button click
    }
}