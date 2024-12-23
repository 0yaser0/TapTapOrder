package com.cmc.taptaporders

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmc.taptaporders.ui.theme.TapTaOrdersTheme
import com.example.taptaorders.R

class Classe : Activity(R.color.white) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TapTaOrdersTheme {
                Column {
                    ShowText("Hello From jetpack",
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color.Red)
                    )

                    ViewDkchi()
                }
            }
        }

    }

    @Composable
    fun ShowText(content: String, modifier: Modifier) {
        Text(
            text = content,
            modifier = modifier
        )
    }

    @Preview
    @Composable
    fun ViewDkchi() {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .width(200.dp)
                .height(100.dp)
        ) {
            ShowText("jetpack From Hello",
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Red)
            )

        }
    }
}

