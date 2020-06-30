package com.pareandroid.infodaerahparepare.Api

import com.pareandroid.infodaerahparepare.Model.KecamatanResponse
import com.pareandroid.infodaerahparepare.Model.KelurahanOnresponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("kecamatan?id_kota=7372")
    fun getKelurahan():Call<KelurahanOnresponse>

    @GET("kecamatan?id_kota=7372")
    fun getKecamatan() : Call<KecamatanResponse>

    @GET("kelurahan")
    fun getFilterKelurahan(@Query("id_kecamatan")id :Int?) : Call<KelurahanOnresponse>
}