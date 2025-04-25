package com.aladin.androidtestingsample.scopes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.aladin.androidtestingsample.contract.AssertScope

class MainActivityAssertScope: AssertScope {
    fun assertTextIsDisplayed() {
        onView(withText("Hello World!")).check(matches(isDisplayed()))
    }
}