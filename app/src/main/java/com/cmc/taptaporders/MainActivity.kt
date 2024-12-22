package com.cmc.taptaporders

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cmc.taptaporders.ui.CategoryPage
import com.cmc.taptaporders.ui.theme.TapTaOrdersTheme
import com.example.taptaorders.R

class MainActivity : Activity(R.color.white) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TapTaOrdersTheme {
                CategoryPage()
            }
        }
    }
}

