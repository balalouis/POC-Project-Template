package com.clean.poc_clean_architec.test

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.clean.poc_clean_architec.R
import com.clean.poc_clean_architec.login.presentation.SingleActivity
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LoginScreenTest {

    @When("^Launch the single activity")
    fun launch_the_single_activity() {
        ActivityScenario.launch(SingleActivity::class.java)
    }

    @Then("^I should see the login ui")
    fun i_should_see_the_login_ui() {

        onView(withId(R.id.ivAppIcon))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.tvAppName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.et_username_login))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.et_password_login))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.btnLogin))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.tv_new_to_app))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @When("^I enter the username \"([^\"]*)\"$")
    fun i_enter_the_username(userName: String) {
        onView(withId(R.id.et_username_login)).perform(clearText())
        onView(withId(R.id.et_username_login)).perform(typeText(userName), ViewActions.click())
    }

    @When("^I enter the password \"([^\"]*)\"$")
    fun i_enter_the_password(password: String) {
        onView(withId(R.id.et_password_login)).perform(clearText())
        onView(withId(R.id.et_password_login)).perform(typeText(password), ViewActions.click())
    }

    @Then("^I should able to see the entered input \"([^\"]*)\" and \"([^\"]*)\"$")
    fun i_should_able_to_see_the_entered_input(userName: String, password: String) {
        onView(ViewMatchers.withText(userName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withText(password))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @When("^I press login button$")
    fun i_press_login_button() {
        onView(withId(R.id.btnLogin)).perform(ViewActions.click())
    }

    @When("^I press register button$")
    fun i_press_register_button_from_login_screen() {
        onView(withId(R.id.tv_new_to_app)).perform(ViewActions.click())
    }

}
