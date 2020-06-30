package com.pareandroid.infodaerahparepare.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pareandroid.infodaerahparepare.Model.KelurahanItem
import com.pareandroid.infodaerahparepare.R
import kotlinx.android.synthetic.main.item_list.view.*

class KelurahanAdapter(private val hasil : List<KelurahanItem>): RecyclerView.Adapter<KelurahanAdapter.itemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        return itemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return hasil.count()
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
//        holder.bind(hasil[holder.adapterPosition])
        val lurah = hasil[position]

        holder.itemView.tv_namaKelurahan.text = lurah.nama
       /* holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.contex  t,Kecamatan::class.java)
            intent.putExtra("idKecamatan",lurah.idKecamatan)
        }*/

    }

    inner class itemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nama :TextView = itemView.findViewById(R.id.tv_namaKelurahan)


//        fun bind(hasils: KelurahanItem){
//            with(itemView){
//                val namaKelurahan = findViewById<TextView>(R.id.tv_namaKelurahan)
//                namaKelurahan.text = hasils.nama
//            }
//        }
    }

}