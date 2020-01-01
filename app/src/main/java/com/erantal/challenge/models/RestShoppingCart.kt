package com.erantal.challenge.models

import android.system.Int64Ref
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RestShoppingCart : Serializable {
    @SerializedName("id")
    var id: Long? = null

    @SerializedName("cart_total")
    var cart_total: Long? = null

    @SerializedName("delivery_fee")
    var delivery_fee: Long? = null

    @SerializedName("same_day_charge")
    var same_day_charge: Long? = null

    @SerializedName("created_at_iso8601")
    var created_at_iso8601: String? = null

    @SerializedName("last_time_modified_int")
    var last_time_modified_int: Long? = null

    @SerializedName("delivery_date_iso8601")
    var delivery_date_iso8601: String? = null

    @SerializedName("status")
    var status: String? = null

    @SerializedName("delivery_address")
    var delivery_address: String? = null

    @SerializedName("order_items_information")
    var order_items_information: ArrayList<RestOrderInformation>? = null

}