package com.erantal.challenge.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RestCategory : Serializable {
    @SerializedName("id")
    var id: Long? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("parent_id")
    var parent_id: Long? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("image_url")
    var image_url: String? = null

    @SerializedName("display_order")
    var display_order: Long? = null

    @SerializedName("image_id")
    var image_id: String? = null

    @SerializedName("hide")
    var hide: Boolean? = null

}