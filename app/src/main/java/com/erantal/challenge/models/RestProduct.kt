package com.erantal.challenge.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RestProduct : Serializable {
    @SerializedName("id")
    var id: Long? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("sku")
    var sku: String? = null

    @SerializedName("unit_photo_filename")
    var unit_photo_filename: String? = null

    @SerializedName("pack_photo_file")
    var pack_photo_file: String? = null

    @SerializedName("unit_photo_hq_url")
    var unit_photo_hq_url: String? = null

    @SerializedName("pack_photo_hq_url")
    var pack_photo_hq_url: String? = null

    @SerializedName("unit_barcode")
    var unit_barcode: String? = null

    @SerializedName("pack_barcode")
    var pack_barcode: String? = null

    @SerializedName("available")
    var available: Boolean? = null

    @SerializedName("updated_at_iso8601")
    var updated_at_iso8601: String? = null

    @SerializedName("case_orderable")
    var case_orderable: Boolean? = null

    @SerializedName("weight_orderable")
    var weight_orderable: Boolean? = null

    @SerializedName("weight_photo_filename")
    var weight_photo_filename: String? = null

    @SerializedName("weight_photo_hq_url")
    var weight_photo_hq_url: String? = null

    @SerializedName("unit_price")
    var unit_price: Long? = null

    @SerializedName("case_price")
    var case_price: Long? = null

    @SerializedName("weight_price")
    var weight_price: Long? = null

    @SerializedName("items_per_unit")
    var items_per_unit: Long? = null

    @SerializedName("units_per_case")
    var units_per_case: Long? = null

    @SerializedName("grouped_by_category_name")
    var grouped_by_category_name: String? = null

    @SerializedName("categories")
    var categories: ArrayList<RestCategory>? = null

}