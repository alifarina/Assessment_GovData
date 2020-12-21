package com.book.govdatafr.departmentList;


import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.book.govdatafr.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class DepartmentListActivityTest {

    @Rule
    public ActivityScenarioRule<DepartmentListActivity> activityActivityTestRule
            = new ActivityScenarioRule<>(DepartmentListActivity.class);

    /**
     * test to click on item
     */
    @Test
    public void clickOnListItem(){
        onView(withId(R.id.list_view))
                .perform( RecyclerViewActions.actionOnItemAtPosition(0, click()) );

    }

}
