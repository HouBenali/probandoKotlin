package com.game.otherworld

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.game.otherworld.functions.Functions
import com.game.otherworld.functions.FileManager
import com.game.otherworld.models.Monster
import com.game.otherworld.models.User


class NicknameActivity : AppCompatActivity() {

    var buttonConfirm: Button? = null
    var nickEdit: EditText? = null
    val user = User()
    val hero = Monster()
    var nick = ""
    val file = "user.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname)

        //Full Screen
        Functions().setFullScreen(this)

        buttonConfirm = findViewById<View>(R.id.button1) as Button
        buttonConfirm?.setBackgroundColor(Color.parseColor("#C0E5FD"))

        nickEdit = findViewById<View>(R.id.usernameInput) as EditText
        nickEdit!!.addTextChangedListener(loginTextWatcher)

        buttonConfirm!!.setOnClickListener {

            nick = nickEdit!!.text.toString()

            if (nick.length in 4..14){
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(EXTRA_MESSAGE, nick)
                startActivity(intent)
                user.setNick(nick)
                user.monsters = listOf(hero)
                //val userData:String = user.toString()
                //val fileName = "user.txt"
                val db = FileManager(this)
                db.writeObject(user)

            }else{
                print("Must have between 4 and 15 characters")
            }

        }
    }

    private val loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput: String = nickEdit?.text.toString().trim()
            buttonConfirm?.setEnabled(usernameInput.length in 4..14)

            if (usernameInput.length in 4..14){
                buttonConfirm?.setBackgroundColor(Color.parseColor("#0099FF"))
            } else {
                buttonConfirm?.setBackgroundColor(Color.parseColor("#C0E5FD"))
            }

        }
        override fun afterTextChanged(s: Editable) {}
    }

}
