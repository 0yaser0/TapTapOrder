package com.cmc.taptaporders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmc.taptaporders.ui.theme.TapTaOrdersTheme
import com.example.taptaorders.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TapTaOrdersTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyToolbar() }
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.taptaporder),
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        },
        actions = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_dark_mode),
                    contentDescription = stringResource(R.string.dark_mode_icon),
                    modifier = Modifier
                        .size(24.dp)
                        .padding(horizontal = 20.dp)
                )
                Image(
                    painter = painterResource(R.drawable.ic_recipes),
                    contentDescription = stringResource(R.string.recipes_icon),
                    modifier = Modifier
                        .size(24.dp)
                        .padding(horizontal = 20.dp)
                )
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MyToolbarPreview() {
    TapTaOrdersTheme {
        MyToolbar()
    }
}
