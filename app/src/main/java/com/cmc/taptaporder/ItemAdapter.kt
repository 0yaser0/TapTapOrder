package com.cmc.taptaporder

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private val context: Context,
    private val items: List<Item>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemTitle: TextView = view.findViewById(R.id.item_title)
        val itemDescription: TextView = view.findViewById(R.id.item_description)
        val itemArrow: ImageView = view.findViewById(R.id.item_arrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.itemImage.setImageResource(item.imageRes)
        holder.itemTitle.text = item.title
        holder.itemDescription.text = item.description
        holder.itemArrow.setOnClickListener {
            val intent = Intent(context, ItemDetailActivity::class.java).apply {
                putExtra("itemImage", item.imageRes)
                putExtra("itemTitle", item.title)
                putExtra("itemDescription", item.description)
                putExtra("itemPrice", item.price)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}
