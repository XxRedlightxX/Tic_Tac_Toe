package com.example.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.TextView
import com.example.tic_tac_toe.databinding.ActivityMainBinding
import java.util.*

class Tic_Tac_Toc : AppCompatActivity(), OnClickListener {

    lateinit var txt_resutlat : TextView
    lateinit var btn1 : ImageButton
    lateinit var btn2 : ImageButton
    lateinit var btn3 : ImageButton
    lateinit var btn4 : ImageButton
    lateinit var btn5 : ImageButton
    lateinit var btn6 : ImageButton
    lateinit var btn7 : ImageButton
    lateinit var btn8 : ImageButton
    lateinit var btn9 : ImageButton
    private lateinit var buttons: Array<ImageButton>
    private lateinit var gridLayout: GridLayout




    private var joueurTour : Boolean = true

    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_tic_tac_toc)


        txt_resutlat = findViewById(R.id.txt_resultat)
        var extras = intent.extras

        var nom = extras?.getString("nom")

        txt_resutlat.text = nom



        buttons = arrayOf(
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9),

            )

        for (boutton in buttons) {
            boutton.setOnClickListener(this)


        }







    }








    override fun onClick(v: View?) {
        if (v is ImageButton) {
            if (joueurTour ==true) {
                v.setImageResource(androidx.appcompat.R.drawable.btn_radio_off_mtrl)
                joueurTour= false
                v.isEnabled = false
            } else if(joueurTour==false) {
                v.setImageResource(androidx.constraintlayout.widget.R.drawable.abc_btn_default_mtrl_shape)
                joueurTour=true
                v.isEnabled = false
            }
        }
    }



}