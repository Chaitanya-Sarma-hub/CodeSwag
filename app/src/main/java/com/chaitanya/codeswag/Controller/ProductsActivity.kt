package com.chaitanya.codeswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chaitanya.codeswag.R
import com.chaitanya.codeswag.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)

    }
}