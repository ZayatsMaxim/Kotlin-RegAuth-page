package com.example.eComLearningProject.elements.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eComLearningProject.activities.ItemActivity
import com.example.eComLearningProject.R
import com.example.eComLearningProject.elements.Item

class ItemsAdapter(var items: List<Item>, var context: Context) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.itemListImage)
        val title: TextView = view.findViewById(R.id.itemListTitle)
        val desc: TextView = view.findViewById(R.id.itemListDesc)
        val price: TextView = view.findViewById(R.id.itemListPrice)
        val buyButton: Button = view.findViewById(R.id.itemListButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.desc.text = items[position].desc
        holder.price.text = items[position].price.toString() + "$"

        val imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)

        holder.buyButton.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java)

            intent.putExtra("itemTitle", items[position].title)
            intent.putExtra("itemText", items[position].text)
            intent.putExtra("itemImageId", context.resources.getIdentifier(
                items[position].image,
                "drawable",
                context.packageName
            ))

            context.startActivity(intent)
        }
    }

}