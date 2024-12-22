package com.cmc.taptaporders

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.cmc.taptaporders.utils.StatusBarUtils

@Suppress("DEPRECATION")
open class Activity(private val statusBarColor: Int) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()
        setColorStatusBar(statusBarColor)
    }

    private fun setColorStatusBar(colorResId: Int) {
        StatusBarUtils.setStatusBarColor(window, colorResId)
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

}

