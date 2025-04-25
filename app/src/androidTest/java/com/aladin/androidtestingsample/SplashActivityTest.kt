package com.aladin.androidtestingsample

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.aladin.androidtestingsample.scope.createScope
import com.aladin.androidtestingsample.scopes.MainActivityActScope
import com.aladin.androidtestingsample.scopes.MainActivityArrangeScope
import com.aladin.androidtestingsample.scopes.MainActivityAssertScope
import com.aladin.androidtestingsample.splash.presentation.SplashActivity
import org.junit.Rule
import org.junit.Test

class SplashActivityTest {
    @get: Rule
    val activityRule = ActivityScenarioRule(SplashActivity::class.java)

    private val testScope = createScope<MainActivityArrangeScope, MainActivityActScope, MainActivityAssertScope>()

    @Test
    fun firstTestCase() = testScope.launch {
        arrange {
            //mocks and previous setup goes here
        }
        act {
            onTextClick()
        }
        assert {
            assertTextIsDisplayed()
        }
    }

}