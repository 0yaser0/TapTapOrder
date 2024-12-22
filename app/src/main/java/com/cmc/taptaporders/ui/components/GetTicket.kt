package com.cmc.taptaporders.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.cmc.taptaporders.ui.theme.TapTaOrdersTheme

@Composable
fun GetTicket() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val boxHeight = screenHeight * 0.12f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .height(boxHeight),
        contentAlignment = Alignment.BottomCenter
    ) {
        GetTicketButton()
    }
}

@Composable
fun GetTicketButton() {
    Button(
        onClick = { /* Handle button click */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00AAFF)),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp)
    ) {
        Text(
            text = "Get Ticket",
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp),
        )
    }
}
@Composable
fun TotalPrice() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Total Price",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
        Text(
            text = "500dh",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyBoxPreview() {
    TapTaOrdersTheme {
        GetTicket()
    }
}
