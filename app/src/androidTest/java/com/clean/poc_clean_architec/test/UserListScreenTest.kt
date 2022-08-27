package com.clean.poc_clean_architec.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.clean.poc_clean_architec.R
import cucumber.api.java.en.Then
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UserListScreenTest {


    @Then("^I should see the user list ui")
    fun i_should_see_the_user_list_ui() {

        onView(withId(R.id.myRecyclerView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

}
