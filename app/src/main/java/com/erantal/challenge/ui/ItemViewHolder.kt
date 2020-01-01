package com.erantal.challenge.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erantal.challenge.AppConstants.CENTS_IN_DOLLAR
import com.erantal.challenge.R
import com.erantal.challenge.models.RestOrderInformation
import kotlinx.android.synthetic.main.item_product_row.view.*


class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view: View = v
    private var orderInformation: RestOrderInformation? = null

    fun bindItem(orderInformation: RestOrderInformation) {
        this.orderInformation = orderInformation
        view.product_name.text = orderInformation.product?.name
        Glide.with(view.context)
            .load(orderInformation.getProductImage())
            .placeholder(R.drawable.placeholder)
            .into(view.product_image)

        val price = view.resources.getString(R.string.product_price_template, orderInformation.getPrice(), orderInformation.packaging_type.toString().capitalize())
        view.product_price.text = price
        view.sub_total.text = view.resources.getString(R.string.price_template, orderInformation.sub_total?.div(CENTS_IN_DOLLAR))
        view.quantity.text = orderInformation.quantity.toString()
        view.substitutable.visibility = when (orderInformation.substitutable) {
            true -> View.VISIBLE
            false -> View.GONE
            else -> View.GONE
        }
    }
}