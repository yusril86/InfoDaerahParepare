package com.pareandroid.infodaerahparepare.Model

import com.google.gson.annotations.SerializedName

data class KelurahanOnresponse(

    @SerializedName("kelurahan")
    val kelurahan : List<KelurahanItem>
)

data class KelurahanItem(

    @SerializedName("id_kecamatan")
    val idKecamatan: String? = null,

    @SerializedName("nama")
    val nama: String? = null,

    @SerializedName("id")
    val id: Long? = null
)