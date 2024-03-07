package com.example.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*

import java.util.*

class Tic_Tac_Toc : AppCompatActivity(), OnClickListener {

    lateinit var txt_resutlat : TextView
    lateinit var txt_tour : TextView
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

    private lateinit var btn_recommencer : Button


    private var joueurTour : Boolean = true

    var Player1 = mutableListOf<Int>()
    var Player2 = mutableListOf<Int>()

    var ActivePlayer = 1
    var setPlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tic_tac_toc)

        btn_recommencer = findViewById(R.id.btn_recommencer)
        txt_resutlat = findViewById(R.id.txt_resultat)
        txt_tour = findViewById(R.id.txt_tour)
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

        btn_recommencer.setOnClickListener() {
            recommencerPartie()
        }

        for (boutton in buttons) {
            boutton.setOnClickListener(this)
        }




    }


    fun recommencerPartie() {
        Player1.clear()
        Player2.clear()

       for (bo in buttons) {
            bo.setImageResource(R.drawable.ic_launcher_background)
            bo.isEnabled = true
        }


    }





    override fun onClick(v: View?) {
        var cellId = 0
        if (v is ImageButton) {
            when (v?.id) {
                R.id.btn1 -> cellId = 0
                R.id.btn2 -> cellId = 1
                R.id.btn3 -> cellId = 2

                R.id.btn4 -> cellId = 3
                R.id.btn5 -> cellId = 4
                R.id.btn6 -> cellId = 5

                R.id.btn7 -> cellId = 6
                R.id.btn8 -> cellId = 7
                R.id.btn9 -> cellId = 8

                R.id.btn_recommencer -> {
                    recommencerPartie()
                }


            }
            if (joueurTour == true) {
                v.setImageResource(R.drawable.x_png_35402)
                joueurTour = false
                txt_tour.setText("Tour des 0")
                Player1.add(cellId)
                v.isEnabled = false
                vérifierVictoire()

                println("Joueur 1" + " " + Player1.toString())

            } else if (joueurTour == false) {


                 adversaire()
                txt_tour.setText("Tour des X")

                    //Player2.add(cellId)
                println("Joueur 2" + " " + Player2.toString())
                joueurTour = true
                v.isEnabled = true
                vérifierVictoire()


            }
        }

        }




    fun adversaire() {



        val potentialWinningMoves = mutableListOf<List<Int>>(
            listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
            listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
            listOf(0, 4, 8), listOf(2, 4, 6) // Diagonals
        )


        for (move in potentialWinningMoves) {
            if (Player2.containsAll(move.subList(0, 2))) {
                val winIndex = move.subtract(Player2).first()
                Player2.add(winIndex)
                buttons[winIndex].setImageResource(R.drawable.scribble_circle_8)
                return
            }
        }


        for (move in potentialWinningMoves) {
            if (Player1.containsAll(move.subList(0, 2))) {
                val blockIndex = move.subtract(Player1).first()
                if (!Player2.contains(blockIndex)) {
                    Player2.add(blockIndex)
                    buttons[blockIndex].setImageResource(R.drawable.scribble_circle_8)
                    return
                }
            }
        }


        var randomIndex: Int
        var cellId: ImageButton
        do {
            randomIndex = Random().nextInt(buttons.size)
            cellId = buttons[randomIndex]
        } while (Player1.contains(randomIndex) || Player2.contains(randomIndex))

        Player2.add(randomIndex)
        cellId.setImageResource(R.drawable.scribble_circle_8)


    }

    fun vérifierVictoire()
    {
        var winner = -1

        //rang1
        if (Player1.contains(0) && Player1.contains(1) && Player1.contains(2))
        {
            winner = 1
        }
        if (Player2.contains(0) && Player2.contains(1) && Player2.contains(2))
        {
            winner = 2
        }

        //rang2
        if (Player1.contains(3) && Player1.contains(4) && Player1.contains(5))
        {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(4) && Player2.contains(5))
        {
            winner = 2
        }

        //rang3
        if (Player1.contains(6) && Player1.contains(7) && Player1.contains(8))
        {
            winner = 1
        }
        if (Player2.contains(6) && Player2.contains(7) && Player2.contains(8))
        {
            winner = 2
        }

        //col1
        if (Player1.contains(0) && Player1.contains(3) && Player1.contains(6))
        {
            winner = 1
        }
        if (Player2.contains(0) && Player2.contains(3) && Player2.contains(6))
        {
            winner = 2
        }

        //col2
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7))
        {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(3) && Player2.contains(7))
        {
            winner = 2
        }

        //col3
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8))
        {
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8))
        {
            winner = 2
        }

        //Croiz
        if (Player1.contains(0) && Player1.contains(4) && Player1.contains(8))
        {
            winner = 1
        }
        if (Player2.contains(0) && Player2.contains(4) && Player2.contains(8))
        {
            winner = 2
        }

        //Croix
        if (Player1.contains(2) && Player1.contains(4) && Player1.contains(6))
        {
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(4) && Player2.contains(6))
        {
            winner = 2
        }

        if (winner != -1)
        {


            if (winner == 1)
            {
                if(setPlayer == 1) {
                    Toast.makeText(this, "Joeur 1 a gagné", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this, "Joueur 2 A Gagné!!", Toast.LENGTH_SHORT).show()
                    println("Joueur 2 a gagné")

                }
                else
                {
                    Toast.makeText(this, "Égalité", Toast.LENGTH_SHORT).show()
                    println("Égalité")

                }
            }
        }else if (winner == -1 && Player1.size + Player2.size == 9) {

        Toast.makeText(this, "Égalité", Toast.LENGTH_SHORT).show()
        println("Égalité")
        return
    }
    }



}