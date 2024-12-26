package com.cmc.taptaporder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val items: List<Item>,
    private val onAddToCart: (PaymentItem) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemTitle: TextView = view.findViewById(R.id.item_title)
        val itemDescription: TextView = view.findViewById(R.id.item_description)
        val itemPrice: TextView = view.findViewById(R.id.item_price)
        val addToCartButton: Button = view.findViewById(R.id.add_to_cart_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.itemImage.setImageResource(item.imageRes)
        holder.itemTitle.text = item.title
        holder.itemDescription.text = item.description
        holder.itemPrice.text = String.format("%.2f DH", item.price)

        holder.addToCartButton.setOnClickListener {
            val paymentItem = PaymentItem(
                id = item.id,
                title = item.title,
                description = item.description,
                imageRes = item.imageRes,
                price = item.price,
                quantity = 1
            )
            onAddToCart(paymentItem)
        }
    }

    override fun getItemCount(): Int = items.size
}
