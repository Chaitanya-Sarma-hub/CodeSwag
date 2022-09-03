package com.chaitanya.codeswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chaitanya.codeswag.Model.Product
import com.chaitanya.codeswag.R

class ProductsAdapter(private val context: Context, private val products: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        val productName = itemView.findViewById<TextView>(R.id.productName)
        val productPrice = itemView.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(context: Context, product: Product) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage.setImageResource(resourceId)
            productName.text = product.title
            productPrice.text = product.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindProduct(context, products[position])
    }

    override fun getItemCount(): Int {
        return products.count()
    }

}