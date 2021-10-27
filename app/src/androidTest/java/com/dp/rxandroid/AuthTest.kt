package com.dp.rxandroid

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dp.rxandroid.ui.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthTest {

    @Rule
    @JvmField
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(
        MainActivity::class.java
    )

    private val USERNAME = "pompom"
    private val PASSWORD = "123456780"

    @Test
    fun successAuth(){

        Espresso.onView(withId(R.id.username))
            .perform(ViewActions.typeText(USERNAME))

        Espresso.onView(withId(R.id.password))
            .perform(ViewActions.typeText(PASSWORD))
        // close soft keyboard
        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.login))
            .perform(ViewActions.click())
    }

}