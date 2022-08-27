package com.clean.poc_clean_architec.test

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CommonUtilSteps {

    @Then("^I should not see the keyboard")
    fun I_should_not_see_the_keyboard() {
        Espresso.pressBack()
    }

    @And("^I wait for ([^\"]*) (second)$")
    fun I_wait(number: String, units: String) {
        var value = 0
        val count = number.toInt()
        if (units.startsWith("second")) {
            value = count * 1000
        }
        CommonUITestUtils.pause(value)
    }

    @Then("^I should see the \"([^\"]*)\"$")
    fun I_should_see_the(textToValidate: String) {
        onView(withText(textToValidate)).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }


}
