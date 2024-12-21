package com.cmc.taptaporders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
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
                    topBar = {
                        Column {
                            MyToolbar()
                            com.cmc.taptaporders.components.SearchBar(
                                query = "",
                                onQueryChange = { },
                                onSearch = { }
                            )
                        }
                    }
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
        modifier = Modifier.padding(horizontal = 10.dp),
        title = {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF0F2032),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.dancing_script_bold)
                        )
                    ) { append("T") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF000000),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.dancing_script_bold)
                        )
                    ) { append("ap") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF0F2032),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.dancing_script_bold)
                        )
                    ) { append("T") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF000000),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.dancing_script_bold)
                        )
                    ) { append("ap") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF0491E9),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.dancing_script_bold)
                        )
                    ) { append(" Order") }
                }
            )
        },
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_dark_mode),
                    contentDescription = stringResource(R.string.dark_mode_icon),
                    modifier = Modifier
                        .size(30.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(R.drawable.ic_recipes),
                    contentDescription = stringResource(R.string.recipes_icon),
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    )
}

@Composable
fun Searchbar(){
    var query by remember { mutableStateOf("") }
    Column {
        com.cmc.taptaporders.components.SearchBar(
            query = query,
            onQueryChange = { newQuery -> query = newQuery },
            onSearch = {}
        )
    }
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
