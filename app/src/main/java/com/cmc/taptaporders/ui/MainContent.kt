package com.cmc.taptaporders.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cmc.taptaporders.ui.components.MyToolbar
import com.cmc.taptaporders.ui.components.CategorieMenuItem
import com.cmc.taptaporders.data.local.models.CategorieItem
import com.cmc.taptaporders.ui.components.GetTicket
import com.cmc.taptaporders.ui.components.SearchBarCall
import com.cmc.taptaporders.ui.components.TotalPrice
import com.cmc.taptaporders.ui.theme.TapTaOrdersTheme
import com.example.taptaorders.R

@Composable
fun MainContent() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column {
                MyToolbar()
                SearchBarCall()
            }
        },
        content = { paddingValues ->
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {

                    val categorieList = listOf(
                        CategorieItem(R.drawable.burger, "Burger", "bnin"),
                        CategorieItem(R.drawable.burger, "Burger", "nadi"),
                        CategorieItem(R.drawable.burger, "Burger", "nadi"),
                        CategorieItem(R.drawable.burger, "Burger", "nadi"),
                        CategorieItem(R.drawable.burger, "Burger", "nadi"),
                        CategorieItem(R.drawable.burger, "Burger", "nadi"),
                        CategorieItem(R.drawable.burger, "Burger", "nadi"),
                        CategorieItem(R.drawable.burger, "Burger", "nadi"),
                        CategorieItem(R.drawable.burger, "Burger", "nadi"),
                        CategorieItem(R.drawable.burger, "Tacos", "harban")
                    )

                    items(categorieList) { food ->
                        CategorieMenuItem(
                            imageResId = food.path,
                            title = food.title,
                            description = food.desc,
                            onClick = {}
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TotalPrice()
                        GetTicket()
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    TapTaOrdersTheme {
        MainContent()
    }
}