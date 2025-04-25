package com.aladin.androidtestingsample.scopes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.aladin.androidtestingsample.contract.ActScope

class MainActivityActScope: ActScope {
    fun onTextClick() {
        onView(withText("Hello World!")).perform(click())
    }
}