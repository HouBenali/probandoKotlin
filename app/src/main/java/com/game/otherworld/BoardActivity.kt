package com.game.otherworld

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.game.otherworld.functions.Functions
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.game.otherworld.functions.BoardGame
import com.game.otherworld.functions.Coordenadas

class BoardActivity : AppCompatActivity() {

    var FirstPlayerTurn: Boolean? = null
    var numberOfMoves = 0
    var listOfCoordinates: ArrayList<Coordenadas> = ArrayList()
    var AnythingSelected = false
    var lastPos: Coordenadas? = null
    var clickedPosition: Coordenadas = Coordenadas(0, 0)
    var youLost: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        Functions().setFullScreen(this)
        val configButton1 : ImageButton = findViewById(R.id.configButton1)
        val board = BoardGame().crearTablero(this)
        BoardGame().toggleCasilla(board)

        val fondo : ConstraintLayout = findViewById(R.id.fondo1)

        fondo.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                Functions().setFullScreen(this)
            }, 1000)
        }

        configButton1.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}