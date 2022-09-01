package com.chaitanya.codeswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import com.chaitanya.codeswag.Model.Category
import com.chaitanya.codeswag.R
import com.chaitanya.codeswag.Services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataService.categories)

        findViewById<ListView>(R.id.categoryListView).adapter = adapter
    }
}
