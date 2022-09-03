package com.chaitanya.codeswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.chaitanya.codeswag.Adapters.CategoryAdapter
import com.chaitanya.codeswag.R
import com.chaitanya.codeswag.Services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        findViewById<ListView>(R.id.categoryListView).adapter = adapter


    }
}
