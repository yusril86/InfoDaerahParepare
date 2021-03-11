package com.pareandroid.infodaerahparepare.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pareandroid.infodaerahparepare.Kecamatan
import com.pareandroid.infodaerahparepare.Kelurahan
import com.pareandroid.infodaerahparepare.Model.KecamatanItem
import com.pareandroid.infodaerahparepare.R
import kotlinx.android.synthetic.main.item_list.view.*

class KecamanAdapter(private val listData : List<KecamatanItem>) : RecyclerView.Adapter<KecamanAdapter.itemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
       return itemViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
       )
    }

    override fun getItemCount(): Int {
      return listData.count()
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val kecamatan = listData[position]

        holder.itemView.tv_namaKelurahan.text = kecamatan.nama

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, Kelurahan::class.java)
            intent.putExtra("idKecamatan",kecamatan.id)
            intent.putExtra("namaKecamatan",kecamatan.nama)
            holder.itemView.context.startActivity(intent)
        }
    }

    inner class itemViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
//        var  nama : TextView  = itemView.findViewById<TextView>(R.id.tv_namaKelurahan)
    }
}