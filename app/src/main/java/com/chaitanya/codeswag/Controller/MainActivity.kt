package com.chaitanya.codeswag.Controller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaitanya.codeswag.Adapters.CategoryRecycleAdapter
import com.chaitanya.codeswag.R
import com.chaitanya.codeswag.Services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories)
        findViewById<RecyclerView>(R.id.categoryListView).adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.categoryListView).layoutManager = layoutManager

        findViewById<RecyclerView>(R.id.categoryListView).setHasFixedSize(true)
    }
}
