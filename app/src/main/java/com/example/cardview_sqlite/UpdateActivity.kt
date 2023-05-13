package com.example.cardview_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputemail: EditText
    lateinit var inputpass: EditText
    lateinit var inputusername: EditText
    lateinit var inputfullname: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        inputemail = findViewById(R.id.input_emailu)
        inputpass = findViewById(R.id.input_passwordu)
        inputusername = findViewById(R.id.input_usernameu)
        inputfullname = findViewById(R.id.input_namau)
        userDBHelper = DBHelper(this)
        val bundle = intent.extras
        if (bundle!=null){
            inputemail.setText(bundle.getString("emailk"))
            inputusername.setText(bundle.getString("usernamek"))
            inputpass.setText(bundle.getString("passk"))
            inputfullname.setText(bundle.getString("fullnamek"))

        }
    }
    fun updateData(v: View){
        var emailin = inputemail.text.toString()
        var passin = inputpass.text.toString()
        var usernamein = inputusername.text.toString()
        var fullnamein = inputfullname.text.toString()
        userDBHelper.updateData(emailin, passin, usernamein, fullnamein)
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
    fun cancelData(v: View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
}