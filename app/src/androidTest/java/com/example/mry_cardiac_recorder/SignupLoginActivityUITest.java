package com.example.mry_cardiac_recorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
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
public class SignupLoginActivityUITest {

    @Rule
    public ActivityScenarioRule<signup_login> activityScenarioRule =
            new ActivityScenarioRule<>(signup_login.class);

    @Test
    public void testLoginSignup() {

        // Check if login/signup page is displayed after splash screen
        Espresso.onView(ViewMatchers.withId(R.id.SignupActivity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));


        // Perform actions on login/signup page
        Espresso.onView(ViewMatchers.withId(R.id.fullname))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("Sornaly"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.email))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("sadiasornaly2@gmail.com"), ViewActions.closeSoftKeyboard());
        //Espresso.onView(ViewMatchers.withId(R.id.email)).perform(ViewActions.typeText("sadiasornaly2@gmail.com"));


        Espresso.onView(ViewMatchers.withId(R.id.number)).perform(typeText("01726632220"));

        Espresso.onView(ViewMatchers.withId(R.id.password))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("meerror6d"), ViewActions.closeSoftKeyboard());

        //Espresso.onView(ViewMatchers.withId(R.id.password)).perform(ViewActions.typeText("meerror6d"));

        Espresso.onView(ViewMatchers.withId(R.id.signup)).perform(ViewActions.click());

        // Add assertions to verify login/signup functionality
        // For example, check if a certain element is displayed after login/signup
        //Espresso.onView(ViewMatchers.withId(R.id.recordfile)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testsignup_login(){

        onView(withId(R.id.login2)).perform(click());

        onView(withId(R.id.LoginActivity)).check(matches(isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.email2))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("sadiasornaly2@gmail.com"), ViewActions.closeSoftKeyboard());

        //onView(withId(R.id.email)).check(matches(isDisplayed()));

        //onView(withId(R.id.number)).check(matches(isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.password2))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("meerror6d"), ViewActions.closeSoftKeyboard());
        //onView(withId(R.id.password)).check(matches(isDisplayed()));

        onView(withId(R.id.login)).check(matches(isDisplayed()));

        onView(withId(R.id.login)).perform(click());

    }
}
