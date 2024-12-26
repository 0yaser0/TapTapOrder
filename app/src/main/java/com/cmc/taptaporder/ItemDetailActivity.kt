package com.cmc.taptaporder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val itemImage: ImageView = findViewById(R.id.detail_item_image)
        val itemTitle: TextView = findViewById(R.id.detail_item_title)
        val itemDescription: TextView = findViewById(R.id.detail_item_description)
        val chipGroup: ChipGroup = findViewById(R.id.tags_group)
        val addToCartButton: Button = findViewById(R.id.add_to_cart_button)

        val imageRes = intent.getIntExtra("itemImage", R.drawable.plate)
        val title = intent.getStringExtra("itemTitle") ?: "Unknown Item"
        val description = intent.getStringExtra("itemDescription") ?: "No description available."
        val tags = intent.getStringArrayExtra("itemTags")
        val price = intent.getDoubleExtra("itemPrice", 0.0)

        itemImage.setImageResource(imageRes)
        itemTitle.text = title
        itemDescription.text = description

        tags?.forEach { tag ->
            val chip = Chip(this).apply {
                text = tag
                isClickable = false
                isCheckable = false
            }
            chipGroup.addView(chip)
        }

        addToCartButton.setOnClickListener {
            Toast.makeText(this, "$title added to your cart for $price DH!", Toast.LENGTH_SHORT).show()
        }
    }
}
