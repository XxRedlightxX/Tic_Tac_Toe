package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var nom : EditText
    lateinit var btn_confirmer : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nom = findViewById(R.id.txt_nom)
        btn_confirmer = findViewById(R.id.btn_confirmer)


        btn_confirmer.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_confirmer -> {
                var nom = nom.text.toString()

                var intention : Intent = Intent(this, Tic_Tac_Toc::class.java)
                intention.putExtra("nom", nom)

                startActivity(intention)
            }
        }

    }
}