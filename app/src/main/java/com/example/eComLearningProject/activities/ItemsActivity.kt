package com.example.eComLearningProject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eComLearningProject.R
import com.example.eComLearningProject.elements.Item
import com.example.eComLearningProject.elements.adapters.ItemsAdapter

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf(
            Item(0, "sofa", "Sofa", getString(R.string.item_desc_default), getString(R.string.item_text_default),259.99),
            Item(1, "lamp", "Lamp", getString(R.string.item_desc_default), getString(R.string.item_text_default),99.99),
            Item(2, "bed", "Bed", getString(R.string.item_desc_default), getString(R.string.item_text_default),399.99),
            Item(3, "table", "Coffee Table", getString(R.string.item_desc_default), getString(R.string.item_text_default),129.99)
        )

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}