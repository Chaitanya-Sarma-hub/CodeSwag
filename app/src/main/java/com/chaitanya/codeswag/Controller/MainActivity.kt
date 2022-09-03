package com.chaitanya.codeswag.Controller

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaitanya.codeswag.Adapters.CategoryRecycleAdapter
import com.chaitanya.codeswag.R
import com.chaitanya.codeswag.Services.DataService
import com.chaitanya.codeswag.Utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productsIntent = Intent(this, ProductsActivity::class.java)
            productsIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productsIntent)
        }
        findViewById<RecyclerView>(R.id.categoryListView).adapter = adapter

        val layoutManager = GridLayoutManager(this, 2)
        findViewById<RecyclerView>(R.id.categoryListView).layoutManager = layoutManager

        findViewById<RecyclerView>(R.id.categoryListView).setHasFixedSize(true)

    }
}
