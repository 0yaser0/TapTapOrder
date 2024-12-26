package com.cmc.taptaporder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PaymentAdapter(
    private val items: List<PaymentItem>, // Pass the list of PaymentItem objects
    private val onQuantityChanged: (PaymentItem) -> Unit // Callback for quantity change
) : RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    class PaymentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemTitle: TextView = view.findViewById(R.id.item_title)
        val itemPrice: TextView = view.findViewById(R.id.item_price)
        val itemQuantity: TextView = view.findViewById(R.id.quantity_text)
        val incrementButton: Button = view.findViewById(R.id.button_increment)
        val decrementButton: Button = view.findViewById(R.id.button_decrement)

        init {
            if (itemImage == null) println("itemImage is null")
            if (itemTitle == null) println("itemTitle is null")
            if (itemPrice == null) println("itemPrice is null")
            if (itemQuantity == null) println("itemQuantity is null")
            if (incrementButton == null) println("incrementButton is null")
            if (decrementButton == null) println("decrementButton is null")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment, parent, false)
        return PaymentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val item = items[position]

        // Bind item data to the view
        holder.itemImage.setImageResource(item.imageRes)
        holder.itemTitle.text = item.title
        holder.itemPrice.text = "${item.price * item.quantity} DH"
        holder.itemQuantity.text = item.quantity.toString()

        // Increment button functionality
        holder.incrementButton.setOnClickListener {
            if (item.quantity < 99) { // Maximum quantity limit
                item.quantity += 1
                holder.itemQuantity.text = item.quantity.toString()
                holder.itemPrice.text = "${item.price * item.quantity} DH"
                onQuantityChanged(item)
            }
        }

        // Decrement button functionality
        holder.decrementButton.setOnClickListener {
            if (item.quantity > 1) { // Minimum quantity limit
                item.quantity -= 1
                holder.itemQuantity.text = item.quantity.toString()
                holder.itemPrice.text = "${item.price * item.quantity} DH"
                onQuantityChanged(item)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
