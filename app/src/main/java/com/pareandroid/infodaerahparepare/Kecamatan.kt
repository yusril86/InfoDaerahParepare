package com.pareandroid.infodaerahparepare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.pareandroid.infodaerahparepare.Adapter.KecamanAdapter
import com.pareandroid.infodaerahparepare.Model.KecamatanItem
import com.pareandroid.infodaerahparepare.Presenter.PresenterKecamatan
import com.pareandroid.infodaerahparepare.Presenter.PresenterKelurahan
import com.pareandroid.infodaerahparepare.View.ViewKecamatan
import com.pareandroid.infodaerahparepare.View.ViewKelurahan

class Kecamatan : AppCompatActivity(),ViewKecamatan {
    private lateinit var progressBar: ProgressBar
    private  lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kecamatan)

        progressBar = findViewById<ProgressBar>(R.id.pb_kecamatan)
        recyclerView = findViewById<RecyclerView>(R.id.rv_list_kecamatan)

        val presenter = PresenterKecamatan(this)
        presenter.getDataKelurahan()
    }

    override fun onShowLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onResponse(result: List<KecamatanItem>) {
        recyclerView.adapter = KecamanAdapter(result)
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }

    override fun onHideLoading() {
       progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onFailure(error: Throwable) {
        Log.e(Kecamatan::class.java.simpleName,"${error.printStackTrace()}")
    }

    /*override fun onShowLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onResponse(result: List<KecamatanItem>) {
        recyclerView.adapter = KecamanAdapter(result)
    }


    override fun onHideLoading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onFailure(error: Throwable) {
        Log.e(Kecamatan::class.java.simpleName,"${error.printStackTrace()}")
    }*/
}
