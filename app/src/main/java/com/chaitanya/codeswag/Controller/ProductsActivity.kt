package com.chaitanya.codeswag.Controller

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaitanya.codeswag.Adapters.ProductsAdapter
import com.chaitanya.codeswag.R
import com.chaitanya.codeswag.Services.DataService
import com.chaitanya.codeswag.Utilities.EXTRA_CATEGORY
import com.chaitanya.codeswag.Utilities.EXTRA_PRODUCT

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY).toString()

        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) { product ->
            val itemIntent = Intent(this, ItemActivity::class.java)
            itemIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(itemIntent)
        }
        findViewById<RecyclerView>(R.id.productsListView).adapter = adapter

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        findViewById<RecyclerView>(R.id.productsListView).layoutManager = layoutManager

    }
}