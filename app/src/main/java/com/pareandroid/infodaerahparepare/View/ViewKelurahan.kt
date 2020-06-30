package com.pareandroid.infodaerahparepare.View

import com.pareandroid.infodaerahparepare.Model.KecamatanItem
import com.pareandroid.infodaerahparepare.Model.KelurahanItem
import com.pareandroid.infodaerahparepare.Model.KelurahanOnresponse

interface ViewKelurahan {
    fun onShowLoading()
    fun onResponse(result: List<KelurahanItem>)
    fun onHideLoading()
    fun onFailure(error: Throwable)
}