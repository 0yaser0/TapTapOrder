package com.cmc.taptaporder

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle system window insets for edge-to-edge experience
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.items_recycler_view)
        val items = generateSampleItems()

        val adapter = ItemAdapter(this, items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val totalPriceTextView = findViewById<TextView>(R.id.total_price)
        val payment: ImageView = findViewById(R.id.history_Ticket)
        val getTicketButton = findViewById<com.google.android.material.button.MaterialButton>(R.id.get_ticket_button)

        getTicketButton.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }

        payment.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showItemDetails(item: Item) {
        val intent = Intent(this, ItemDetailActivity::class.java).apply {
            putExtra("itemImage", item.imageRes)
            putExtra("itemTitle", item.title)
            putExtra("itemDescription", item.description)
            putExtra("itemTags", arrayOf(item.category))
            putExtra("itemPrice", item.price)
        }
        startActivity(intent)
    }

    private fun generateSampleItems(): List<Item> {
        return listOf(
            Item(
                id = 1L,
                title = "Burger",
                description = "Anwa3 d burger likaynin",
                imageRes = R.drawable.burger,
                price = 50.00,
                category = "Fast Food"
            ),
            Item(
                id = 2L,
                title = "Pizza",
                description = "Delicious pizza",
                imageRes = R.drawable.pizza,
                price = 80.00,
                category = "Italian"
            ),
            Item(
                id = 3L,
                title = "Pasta",
                description = "Tasty pasta dishes",
                imageRes = R.drawable.pasta,
                price = 60.00,
                category = "Italian"
            ),
            Item(
                id = 1L,
                title = "Burger",
                description = "Anwa3 d burger likaynin",
                imageRes = R.drawable.burger,
                price = 50.00,
                category = "Fast Food"
            ),
            Item(
                id = 2L,
                title = "Pizza",
                description = "Delicious pizza",
                imageRes = R.drawable.pizza,
                price = 80.00,
                category = "Italian"
            ),
            Item(
                id = 3L,
                title = "Pasta",
                description = "Tasty pasta dishes",
                imageRes = R.drawable.pasta,
                price = 60.00,
                category = "Italian"
            )
        )
    }
}
