package com.game.otherworld.functions

import android.app.Activity
import android.widget.ImageButton
import com.game.otherworld.R
import com.game.otherworld.models.Casilla
import com.game.otherworld.models.Cell

//Crear una llista de caselles, enllaçarles amb les vistes i fer que al fer clic al botó pertinent
//faci "toggle" entre mostrar monstre en cel·la o cel·la en blanc
class BoardGame() {
    val tablero = ArrayList<Cell>()
    val size = 4

    fun crearTablero(BoardActivity : Activity): ArrayList<Cell> {

        for (i in 1..16){
            val resID: Int = BoardActivity.getResources().getIdentifier(
                "casilla$i",
                "id", BoardActivity.getPackageName()
            )
            val imageButton : ImageButton = BoardActivity.findViewById(resID)
            val casilla_ = Casilla()
            val cell = Cell(casilla_, imageButton)
            tablero.add(cell)
        }
        return tablero
    }

    fun toggleCasilla(board: ArrayList<Cell>) {

        for (i in 0..board.size-1){
            println("------------------------------------------------")
            val imgBtn = board.get(i).imageButton
            val cell = board.get(i).casilla

            imgBtn.setOnClickListener {
            if (cell.vacia){
                cell.vacia = false
                imgBtn.setImageResource(R.drawable.monster)
            } else{
                cell.vacia = true
                imgBtn.setImageResource(R.color.white)

                }
            }

        }

    }



}