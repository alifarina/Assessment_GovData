package com.book.govdatafr.departmentDetail;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.book.govdatafr.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class DepartmentDetailActivityTest {

    @Rule
    public ActivityScenarioRule<DepartmentDetailActivity> activityActivityScenarioRule = new ActivityScenarioRule<>(DepartmentDetailActivity.class);

    /**
     * test on a button click to go back screen
     */
    @Test
    public void clickAndGoBack(){
        Espresso.onView(withId(R.id.goBack)).perform(click());
    }

}