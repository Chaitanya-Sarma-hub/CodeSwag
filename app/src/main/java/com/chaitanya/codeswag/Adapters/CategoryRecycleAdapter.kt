package com.chaitanya.codeswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.chaitanya.codeswag.Model.Category
import com.chaitanya.codeswag.R

class CategoryRecycleAdapter(private val context: Context, private val categories: List<Category>, private val itemClick: (Category) -> Unit): Adapter<CategoryRecycleAdapter.Holder>() {

    inner class Holder(itemView: View, val itemclick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)!!
        private val categoryName = itemView.findViewById<TextView>(R.id.categoryName)!!

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
            itemView.setOnClickListener { itemclick(category) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position], context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

}