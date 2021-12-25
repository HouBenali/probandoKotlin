package com.game.otherworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.game.otherworld.functions.Functions


class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        Functions().setFullScreen(this)

        //val text : text
        val button : ImageButton = findViewById(R.id.imageBtn)

        button.setOnClickListener{
            val intent = Intent(this, NicknameActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

   /* override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) Functions().setFullScreen(this)
    }*/
}