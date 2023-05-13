package com.example.cardview_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper

    lateinit var lltampil: LinearLayout
    lateinit var tampil: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        userDBHelper = DBHelper(this)
        tampil = findViewById(R.id.tampil_semua)
        lltampil = findViewById(R.id.ll_tampil)
        var tampilkan = userDBHelper.fullData()
//        lltampil.removeAllViews()
        tampilkan.forEach {
            tampil.text = tampil.text.toString() + " " + it.email.toString() + " - "  + it.pass.toString() + " - "  +
                    it.username.toString() + " - "  + it.fullname.toString() + "\n"
//            lltampil.addView(tampil)
        }

    }

}