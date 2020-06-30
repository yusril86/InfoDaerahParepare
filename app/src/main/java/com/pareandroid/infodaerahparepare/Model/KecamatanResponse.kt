package com.pareandroid.infodaerahparepare.Model

import com.google.gson.annotations.SerializedName

data class KecamatanResponse(

	@field:SerializedName("kecamatan")
	val kecamatan: List<KecamatanItem>
)

data class KecamatanItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id_kota")
	val idKota: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
