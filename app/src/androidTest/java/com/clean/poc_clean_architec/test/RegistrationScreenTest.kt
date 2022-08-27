package com.clean.poc_clean_architec.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.runner.RunWith
import com.clean.poc_clean_architec.R

@RunWith(AndroidJUnit4::class)
class RegistrationScreenTest {

    @Then("^I should see the register screen ui")
    fun i_should_see_the_register_screen_ui() {

        onView(ViewMatchers.withId(R.id.et_username_registration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withId(R.id.et_email))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withId(R.id.et_password_registration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withId(R.id.register_button))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @When("^I enter the username registration \"([^\"]*)\"$")
    fun i_enter_the_username_registration(userName: String) {
        onView(ViewMatchers.withId(R.id.et_username_registration)).perform(ViewActions.clearText())
        onView(ViewMatchers.withId(R.id.et_username_registration)).perform(ViewActions.typeText(userName), ViewActions.click())
    }

    @When("^I enter the email registration \"([^\"]*)\"$")
    fun i_enter_the_email_registration(userName: String) {
        onView(ViewMatchers.withId(R.id.et_email)).perform(ViewActions.clearText())
        onView(ViewMatchers.withId(R.id.et_email)).perform(ViewActions.typeText(userName), ViewActions.click())
    }

    @When("^I enter the password registration \"([^\"]*)\"$")
    fun i_enter_the_password_registration(userName: String) {
        onView(ViewMatchers.withId(R.id.et_password_registration)).perform(ViewActions.clearText())
        onView(ViewMatchers.withId(R.id.et_password_registration)).perform(ViewActions.typeText(userName), ViewActions.click())
    }

    @When("^I press register button$")
    fun i_press_login_button() {
        onView(ViewMatchers.withId(R.id.register_button)).perform(ViewActions.click())
    }
}