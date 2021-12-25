package com.game.otherworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.game.otherworld.functions.Functions
import com.game.otherworld.functions.FileManager
import com.game.otherworld.models.User

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Functions().setFullScreen(this)

        val savebutton : Button = findViewById(R.id.saveBtn)
        savebutton.setOnClickListener {
            val user = intent.getSerializableExtra("userData") as User
            val intent = Intent(this, HomeActivity ::class.java)
            startActivity(intent)

            val db = FileManager(this)
            db.writeObject(user)

        }

        val loadbutton : Button = findViewById(R.id.loadBtn)
        loadbutton.setOnClickListener {
            val intent = Intent(this, HomeActivity ::class.java)
            startActivity(intent)
            val db = FileManager(this)
            val user = db.readObject()
            println(user)
        }


        val backbutton : Button = findViewById(R.id.backBtn)
        backbutton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

}