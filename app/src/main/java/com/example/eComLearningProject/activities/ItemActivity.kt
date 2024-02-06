package com.example.eComLearningProject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import com.example.eComLearningProject.R

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.itemTitle)
        val text: TextView = findViewById(R.id.itemText)
        val image: ImageFilterView = findViewById(R.id.itemImage)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        image.setImageResource(intent.getIntExtra("itemImageId", R.drawable.placeholder))
    }
}