package com.example.decaclassroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_get_started.*

class GetStartedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)


        signup_button.setOnClickListener{view ->

            val intent = Intent(this, RegisterActivity::class.java)

            startActivity(intent)

        }
    }
}
