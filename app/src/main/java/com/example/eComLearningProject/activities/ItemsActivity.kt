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
            Item(0, "sofa", "Sofa", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit",259.99),
            Item(1, "lamp", "Lamp", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit",99.99),
            Item(2, "bed", "Bed", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit",399.99),
            Item(3, "table", "Coffee Table", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit",129.99)
        )

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}