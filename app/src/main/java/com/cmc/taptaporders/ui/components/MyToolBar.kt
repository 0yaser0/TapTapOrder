package com.cmc.taptaporders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.taptaorders.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar() {
    TopAppBar(
        modifier = Modifier.padding(horizontal = 0.dp),
        title = {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF0F2032),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.more_sugar)
                        )
                    ) { append("T") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF000000),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.more_sugar)
                        )
                    ) { append("ap") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF0F2032),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.more_sugar)
                        )
                    ) { append("T") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF000000),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.more_sugar)
                        )
                    ) { append("ap") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF0491E9),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle(R.font.more_sugar)
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