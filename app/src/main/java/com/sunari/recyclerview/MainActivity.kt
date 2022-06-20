package com.sunari.recyclerview

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.sunari.recyclerview.adapter.AdapterTeamBola
import com.sunari.recyclerview.databinding.ActivityMainBinding
import com.sunari.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Keny Dalgish", R.drawable.keny, "Pemain", "2.00 m", "Belgia","13 Mei 1992"))
        listPemain.add(Pemain("Mohammad saleh", R.drawable.mohaleh, "Pemain", "1.00 m", "Australia","11 April 1993"))
        listPemain.add(Pemain("Ray Clemence", R.drawable.ray, "Kiper", "2.00 m", "Inggris","05 Agustus 1958"))
        listPemain.add(Pemain("Steven Gerrad", R.drawable.stiven, "Pemain", "2.00 m", "Inggris","30 Mei 1980"))
        listPemain.add(Pemain("Virgil van Dijk", R.drawable.virgil, "Pemain", "2.00 m", "Belanda","08 Juli 1991"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener {
            override fun datailData(item: Pemain?) {
               Dialog(this@MainActivity).apply {
                   requestWindowFeature(Window.FEATURE_NO_TITLE)
                   setCancelable(true)
                   setContentView(R.layout.detail_data_pemain)
                   val image = this.findViewById<ImageView>(R.id.image_Pemain)
                   val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                   val Posisi = this.findViewById<TextView>(R.id.txtPosisi)
                   val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                   val tempatlahir= this.findViewById<TextView>(R.id.txtTempatLahir)
                   val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                   val btn = this.findViewById<Button>(R.id.btnClose)

                   image.setImageResource(item?.foto ?:0)
                   nama.text = "${item?.nama}"
                   Posisi.text = "${item?.posisi}"
                   tinggi.text = "${item?.tinggi}"
                   tempatlahir.text = "${item?.tempatlahir}"
                   tgllahir.text = "${item?.tgllahir}"

                   btn.setOnClickListener {
                       this.dismiss()
                   }


               }.show()
            }

        })
    }

}