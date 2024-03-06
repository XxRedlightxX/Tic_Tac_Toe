package com.example.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
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

    var Player1 = mutableListOf<Int>()
    var Player2 = mutableListOf<Int>()

    var ActivePlayer = 1
    var setPlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        var cellId = 0
        if (v is ImageButton) {
            when(v?.id)
            {
                R.id.btn1 -> cellId = 1
                R.id.btn2 -> cellId = 2
                R.id.btn3 -> cellId = 3

                R.id.btn4 -> cellId = 4
                R.id.btn5 -> cellId = 5
                R.id.btn6 -> cellId = 6

                R.id.btn7 -> cellId = 7
                R.id.btn8 -> cellId = 8
                R.id.btn9 -> cellId = 9
            }
            if (joueurTour ==true) {
                v.setImageResource(androidx.appcompat.R.drawable.btn_radio_off_mtrl)
                joueurTour= false
                Player1.add(cellId)
                v.isEnabled = false
                CheckWinner()

                println("Joueur 1"+" "+Player1.toString())

            } else if(joueurTour==false) {
                v.setImageResource(androidx.constraintlayout.widget.R.drawable.abc_btn_default_mtrl_shape)
                joueurTour=true
                Player2.add(cellId)
                println("Joueur 2"+" "+Player2.toString())
                v.isEnabled = false
                CheckWinner()
            }
        }
    }

    fun CheckWinner()
    {
        var winner = -1

        //row1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3))
        {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3))
        {
            winner = 2
        }

        //row2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6))
        {
            winner = 1
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6))
        {
            winner = 2
        }

        //row3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9))
        {
            winner = 1
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9))
        {
            winner = 2
        }

        //col1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7))
        {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7))
        {
            winner = 2
        }

        //col2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8))
        {
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8))
        {
            winner = 2
        }

        //col3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9))
        {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9))
        {
            winner = 2
        }

        //cross1
        if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9))
        {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9))
        {
            winner = 2
        }

        //cross2
        if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7))
        {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7))
        {
            winner = 2
        }

        if (winner != -1)
        {
            if (winner == 1)
            {
                if(setPlayer == 1) {
                    Toast.makeText(this, "Player 1 Wins!!", Toast.LENGTH_SHORT).show()
                    println("Joeur 1 a gagné")
                }
                else
                {
                    Toast.makeText(this, "You Won!!", Toast.LENGTH_SHORT).show()

                }
            }
            else
            {
                if (setPlayer == 1) {
                    Toast.makeText(this, "Player 2 Wins!!", Toast.LENGTH_SHORT).show()
                    println("Joeur 2 a gagné")

                }
                else
                {
                    Toast.makeText(this, "CPU Wins!!", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }



}