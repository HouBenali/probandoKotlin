package com.game.otherworld


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.game.otherworld.functions.Functions
import com.game.otherworld.functions.FileManager

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Functions().setFullScreen(this)
        //val filename = "user.txt"

        val db = FileManager(this)
        val user = db.readObject()

        val configButton: ImageButton = findViewById(R.id.configButton)
        val monstersButton: ImageButton = findViewById(R.id.monsterButton)
        val bagButton: ImageButton = findViewById(R.id.chestButton)
        val playButton: ImageButton = findViewById(R.id.playButton)
        val guild: ImageButton = findViewById(R.id.guildButton)
        val shop: ImageButton = findViewById(R.id.shopButton)
        val book: ImageButton = findViewById(R.id.encyclopediaButton)

        val fondo : ConstraintLayout = findViewById(R.id.fondo)

        val nick: TextView = findViewById(R.id.nick)
        nick.setText(user.nick).toString()

        fondo.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                Functions().setFullScreen(this)
            }, 1000)

        }

        configButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("userData", user)
            startActivity(intent)
            finish()
        }

        playButton.setOnClickListener {
            val intent = Intent(this, BoardActivity::class.java)
            startActivity(intent)
            finish()
        }

        bagButton.setOnClickListener {
            val intent = Intent(this, Activity404::class.java)
            startActivity(intent)
            finish()
        }

        monstersButton.setOnClickListener {
            val intent = Intent(this, Activity404::class.java)
            startActivity(intent)
            finish()
        }

        guild.setOnClickListener {
            val intent = Intent(this, Activity404::class.java)
            startActivity(intent)
            finish()
        }

        shop.setOnClickListener {
            val intent = Intent(this, Activity404::class.java)
            startActivity(intent)
            finish()
        }

        book.setOnClickListener {
            val intent = Intent(this, Activity404::class.java)
            startActivity(intent)
            finish()
        }


    }


}