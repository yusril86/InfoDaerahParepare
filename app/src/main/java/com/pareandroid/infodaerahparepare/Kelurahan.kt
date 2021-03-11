package com.pareandroid.infodaerahparepare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pareandroid.infodaerahparepare.Adapter.KecamanAdapter
import com.pareandroid.infodaerahparepare.Adapter.KelurahanAdapter
import com.pareandroid.infodaerahparepare.Model.KecamatanItem
import com.pareandroid.infodaerahparepare.Model.KecamatanResponse
import com.pareandroid.infodaerahparepare.Model.KelurahanItem
import com.pareandroid.infodaerahparepare.Model.KelurahanOnresponse
import com.pareandroid.infodaerahparepare.Presenter.PresenterKelurahan
import com.pareandroid.infodaerahparepare.View.ViewKelurahan
import com.pareandroid.infodaerahparepare.fragment.About
import com.pareandroid.infodaerahparepare.fragment.FrgamentKecamatan
import kotlinx.android.synthetic.main.activity_kelurahan.*

class Kelurahan : AppCompatActivity(),ViewKelurahan,BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var progressBar :ProgressBar
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelurahan)
        val id:Int?
//        val kecamatan:String
        id = intent.getIntExtra("idKecamatan",0)
        val kecamatan = intent.getStringExtra("namaKecamatan")

        progressBar = findViewById<ProgressBar>(R.id.pb_kelurahan)
        recyclerView = findViewById<RecyclerView>(R.id.rv_list)

        val presenter = PresenterKelurahan(this)
        presenter.filterkelura(id)

        tv_kelurahan.setText(kecamatan)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

    }

    override fun onShowLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onResponse(result: List<KelurahanItem>) {
        recyclerView.adapter = KelurahanAdapter(result)
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

    }


    override fun onHideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun onFailure(error: Throwable) {
        Log.e(Kelurahan::class.java.simpleName,"${error.printStackTrace()}")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Daerah -> {
                val intent = Intent(this,FrgamentKecamatan::class.java)
                startActivity(intent)
                return true
            }
            /*R.id.profil->{
                val intent = Intent(this,About::class.java)
                startActivity(intent)
                return true
            }*/

        }
        return false
    }
}
