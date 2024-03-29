package com.example.decaclassroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_verification.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Listen for text changes in the edit text
        Email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s : Editable?){}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                error_message2.visibility = View.GONE
                error_message.visibility = View.GONE
                Email.setBackgroundResource(R.drawable.input_drawable)
            }
        })

        //form validation
        Email.setText("")
        val emailPattern = ("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").toRegex()

        buttonReg.setOnClickListener {
            var email = Email.text.toString()

            if(email.isEmpty()){
                error_message2.visibility = View.VISIBLE
                Email.setBackgroundResource(R.drawable.error_drawable)
            }else if(email.trim().matches(emailPattern)){
                error_message2.visibility = View.GONE
                error_message.visibility = View.GONE
                val intent = Intent(this, VerificationActivity::class.java)

                startActivity(intent)

            }else{
                Email.setBackgroundResource(R.drawable.error_drawable)
                error_message2.visibility = View.GONE
                error_message.visibility = View.VISIBLE
            }
        }

        profile_image1.setOnClickListener{ view ->

            val intent = Intent(this, GetStartedActivity::class.java)

            startActivity(intent)

        }

    }
}
