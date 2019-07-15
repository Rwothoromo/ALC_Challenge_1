package com.example.alc_challenge_1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_profile.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
        }

        btn_about.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }
    }
}