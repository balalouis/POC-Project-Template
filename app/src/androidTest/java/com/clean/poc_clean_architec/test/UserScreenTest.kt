package com.clean.poc_clean_architec.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.clean.poc_clean_architec.R
import com.clean.poc_clean_architec.user_list.presentation.UserListAdapter
import cucumber.api.java.en.Then
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UserScreenTest {

    @Then("^I should see the user list ui")
    fun i_should_see_the_user_list_ui() {
        onView(withId(R.id.myRecyclerView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Then("^I tap on second item in list")
    fun i_tap_on_second_item_in_list() {
        onView(withId(R.id.myRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<UserListAdapter.UserListViewHolder>(
                    2,
                    click()
                )
            )
    }

    @Then("^I should see the user detail ui")
    fun i_should_see_the_user_detail_ui() {
        onView(withId(R.id.ivUserImage))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.tvFirstName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.tvLastName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.tvEmail))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}
