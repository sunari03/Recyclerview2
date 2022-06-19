package com.sunari.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                TODO("Not yet implemented")
            }

        })
    }

}