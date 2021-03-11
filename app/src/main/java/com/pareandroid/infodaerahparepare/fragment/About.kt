package com.pareandroid.infodaerahparepare.fragment

import android.Manifest.permission.CALL_PHONE
import android.content.Context
import android.content.Intent
import android.content.Intent.*
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat

import com.pareandroid.infodaerahparepare.R
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*
import java.util.jar.Manifest

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [About.newInstance] factory method to
 * create an instance of this fragment.
 */
class About : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_about, container, false)

       view.bg_telp.setOnClickListener(View.OnClickListener {
           val  nomor = tv_notelp.text
            val intentCall = Intent(ACTION_DIAL)
            intentCall.data = Uri.parse("tel:$nomor")
//            if (intentCall.resolveActivity(context!!.packageManager)!= null){
                startActivity(intentCall)
//            }
        })

        view.bg_wa.setOnClickListener(View.OnClickListener {
//            val Uri = Uri.parse("smsto:" + tv_wa.text)
//            val intentWa = Intent(Intent.ACTION_SENDTO,Uri)
//            intentWa.setPackage("com.whatsapp")
//            startActivity(intentWa)
            var mBundle = Bundle()
//            mBundle.putInt("idKecamatan", kecamatan!!.id!!)
//            mBundle.putString("namaKecamatan",kecamatan.nama)
            var fragmentlurah = FragmentKelurahan()
//            fragmentlurah.arguments = mBundle
            fragmentlurah
                .fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container_about,fragmentlurah)
        })


        view.bg_gmail.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("Email")
            val email = arrayOf("yusril886@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL,email)
            intent.putExtra(Intent.EXTRA_SUBJECT,"")
            intent.putExtra(Intent.EXTRA_TEXT,"")
            intent.type= "message/rfc822"
            val a = Intent.createChooser(intent,"Launch Email")
            startActivity(a)
        })

        return view
    }



}
