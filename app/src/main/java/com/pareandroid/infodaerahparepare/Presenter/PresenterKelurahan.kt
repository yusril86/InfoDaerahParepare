package com.pareandroid.infodaerahparepare.Presenter

import com.pareandroid.infodaerahparepare.Api.ApiInterface
import com.pareandroid.infodaerahparepare.Api.Config
import com.pareandroid.infodaerahparepare.Model.KecamatanResponse
import com.pareandroid.infodaerahparepare.Model.KelurahanItem
import com.pareandroid.infodaerahparepare.Model.KelurahanOnresponse
import com.pareandroid.infodaerahparepare.View.ViewKelurahan
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterKelurahan(private val view : ViewKelurahan) {



    fun filterkelura(id: Int?) {
        view.onShowLoading()

        val filterKelurahan =
            Config.providesHttpAdapter().create(ApiInterface::class.java)
        filterKelurahan.getFilterKelurahan(id).enqueue(object :Callback<KelurahanOnresponse>{
            override fun onFailure(call: Call<KelurahanOnresponse>, t: Throwable) {
                view.onShowLoading()
                view.onFailure(t)
            }

            override fun onResponse(
                call: Call<KelurahanOnresponse>,
                response: Response<KelurahanOnresponse>
            ) {
                view.onHideLoading()
                view.onResponse(response.body()?.kelurahan ?: emptyList())
            }
        })
        }
    }