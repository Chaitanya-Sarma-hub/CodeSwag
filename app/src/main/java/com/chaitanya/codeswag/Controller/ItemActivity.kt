package com.chaitanya.codeswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.chaitanya.codeswag.Model.Product
import com.chaitanya.codeswag.R
import com.chaitanya.codeswag.Utilities.EXTRA_PRODUCT

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val item = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        findViewById<TextView>(R.id.productName).text = item!!.title
        findViewById<TextView>(R.id.productPrice).text = item.price

        val resourceId = this.resources.getIdentifier(item.image, "drawable", this.packageName)
        println(resourceId)
        findViewById<ImageView>(R.id.productImage).setImageResource(resourceId)

        findViewById<TextView>(R.id.descriptionText).text = "In the ProductDetailActvity onCreate() method, retrieve from the intent the extra that is of type Product. Get the resource id from the image name like we have done several times, and set the image as well as product name and price."
    }

    fun addToCart(view: View) {
        val toast = Toast.makeText(this, "Successfully added to Cart", Toast.LENGTH_SHORT)
        toast.show()
    }
}