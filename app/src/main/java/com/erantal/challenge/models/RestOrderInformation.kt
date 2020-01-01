package com.erantal.challenge.models

import com.erantal.challenge.AppConstants.CENTS_IN_DOLLAR
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RestOrderInformation : Serializable {
    enum class PackagingType {
        unit,
        case,
        weight
    }

    @SerializedName("id")
    var id: Long? = null

    @SerializedName("quantity")
    var quantity: Long? = null

    @SerializedName("product_id")
    var product_id: Long? = null

    @SerializedName("sub_total")
    var sub_total: Long? = null

    @SerializedName("order_id")
    var order_id: Long? = null

    @SerializedName("packaging_type")
    var packaging_type: PackagingType? = null

    @SerializedName("substitutable")
    var substitutable: Boolean? = null

    @SerializedName("product")
    var product: RestProduct? = null

    fun getPrice(): Double? {
        return when (packaging_type) {
            PackagingType.unit -> {
                (product?.unit_price?.div(CENTS_IN_DOLLAR))
            }
            PackagingType.case -> {
                (product?.case_price?.div(CENTS_IN_DOLLAR))
            }
            PackagingType.weight -> {
                (product?.weight_price?.div(CENTS_IN_DOLLAR))
            }
            else -> 0.0
        }
    }

    fun getProductImage(): String? {
        return when (packaging_type) {
            PackagingType.unit -> {
                (product?.unit_photo_filename)
            }
            PackagingType.case -> {
                (product?.pack_photo_file)
            }
            PackagingType.weight -> {
                (product?.weight_photo_filename)
            }
            else -> product?.unit_photo_filename
        }
    }

}