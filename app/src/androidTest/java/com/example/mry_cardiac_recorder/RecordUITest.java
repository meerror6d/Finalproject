package com.example.mry_cardiac_recorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class RecordUITest {
    @Rule
    public ActivityScenarioRule<record> activityScenarioRule =
            new ActivityScenarioRule<>(record.class);

    @Test
    public void testRecord() {

        onView(withId(R.id.recyclarView)).check(matches(isDisplayed()));
        onView(withId(R.id.AddBUttonId)).check(matches(isDisplayed()));

        onView(withId(R.id.AddBUttonId)).perform(click());

        onView(withId(R.id.scrollview)).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.dateValue))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("06/12/2023"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.timeValue))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("12:00"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.systolicValue))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("120"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.diastolicValue))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("80"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.heartRateValue))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("82"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.commentValue))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("done"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.recordfile)).check(matches(isDisplayed()));
        //onView(withId(R.id.show)).check(matches(isDisplayed()));

    }
}
