package com.pareandroid.infodaerahparepare.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.pareandroid.infodaerahparepare.Adapter.KecamanAdapter
import com.pareandroid.infodaerahparepare.Kecamatan
import com.pareandroid.infodaerahparepare.Model.KecamatanItem
import com.pareandroid.infodaerahparepare.Presenter.PresenterKecamatan
import com.pareandroid.infodaerahparepare.R
import com.pareandroid.infodaerahparepare.View.ViewKecamatan
import kotlinx.android.synthetic.main.fragment_frgament_kecamatan.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class FrgamentKecamatan : Fragment(),ViewKecamatan{
  /*  private lateinit var progressBar: ProgressBar
    private  lateinit var recyclerView: RecyclerView*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frgament_kecamatan, container, false)

        return view
    }

    override fun onShowLoading() {
        pb_kecamatan1.visibility= View.VISIBLE
    }

    override fun onResponse(result: List<KecamatanItem>) {
       rv_list_kecamatan.adapter= KecamanAdapter(result)
        rv_list_kecamatan.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }

    override fun onHideLoading() {
        pb_kecamatan1.visibility =View.GONE
        rv_list_kecamatan.visibility = View.VISIBLE
    }

    override fun onFailure(error: Throwable) {
        Log.e(Kecamatan::class.java.simpleName,"${error.printStackTrace()}")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val presenter = PresenterKecamatan(this)
        presenter.getDataKelurahan()
    }

}
