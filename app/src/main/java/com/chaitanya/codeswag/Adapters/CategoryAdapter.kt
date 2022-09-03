package com.chaitanya.codeswag.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.chaitanya.codeswag.Model.Category
import com.chaitanya.codeswag.R

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getCount(): Int {
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("CutPasteId", "ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)

        val category = categories[position]
        categoryView.findViewById<TextView>(R.id.categoryName).text = category.title

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryView.findViewById<ImageView>(R.id.categoryImage).setImageResource(resourceId)

        return categoryView
    }

    private class viewHolder {
        var categoryName: ImageView? = null
        var categoryImage: TextView? = null
    }
}