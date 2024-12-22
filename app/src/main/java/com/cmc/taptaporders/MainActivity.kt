package com.cmc.taptaporders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cmc.taptaporders.ui.MainContent
import com.cmc.taptaporders.ui.theme.TapTaOrdersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TapTaOrdersTheme {
                MainContent()
            }
        }
    }
}

