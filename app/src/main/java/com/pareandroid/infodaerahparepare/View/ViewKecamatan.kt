package com.pareandroid.infodaerahparepare.View

import com.pareandroid.infodaerahparepare.Model.KecamatanItem
import com.pareandroid.infodaerahparepare.Model.KecamatanResponse

interface ViewKecamatan {
    fun onShowLoading()
    fun onResponse(result: List<KecamatanItem>)
    fun onHideLoading()
    fun onFailure(error: Throwable)
}