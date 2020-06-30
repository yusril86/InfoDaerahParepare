package com.pareandroid.infodaerahparepare.Presenter

import com.pareandroid.infodaerahparepare.Api.ApiInterface
import com.pareandroid.infodaerahparepare.Api.Config
import com.pareandroid.infodaerahparepare.Model.KecamatanResponse
import com.pareandroid.infodaerahparepare.View.ViewKecamatan
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterKecamatan(private val view : ViewKecamatan) {

    fun getDataKelurahan() {
        view.onShowLoading()

        val dataKelurahan = Config.providesHttpAdapter().create(ApiInterface::class.java)
        dataKelurahan.getKecamatan().enqueue(object : Callback<KecamatanResponse> {
            override fun onFailure(call: Call<KecamatanResponse>, t: Throwable) {
                view.onShowLoading()
                view.onFailure(t)
            }

            override fun onResponse(
                call: Call<KecamatanResponse>,
                response: Response<KecamatanResponse>
            ) {
                view.onHideLoading()
                view.onResponse(response.body()?.kecamatan ?: emptyList())
            }
        })
    }
}