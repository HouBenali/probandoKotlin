package com.game.otherworld

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.game.otherworld.functions.Functions

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        Functions().setFullScreen(this)

        val button : Button = findViewById(R.id.button)
        val fondo : ConstraintLayout = findViewById(R.id.fondoStart)
        button.setOnClickListener{
            if (Functions().fileExists("user.txt", baseContext)) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
            }

        fondo.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                Functions().setFullScreen(this)
            }, 1000)

        }
        }

    }

}