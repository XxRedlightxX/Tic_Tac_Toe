package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.TextView

class Tic_Tac_Toc : AppCompatActivity(), OnClickListener {

    lateinit var txt_resutlat : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toc)

        txt_resutlat = findViewById(R.id.txt_resultat)
        var extras = intent.extras

        var nom = extras?.getString("nom")

        txt_resutlat.text = nom


    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}