package com.example.decaclassroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*

class VerificationActivity : AppCompatActivity() {
    lateinit var option: Spinner
    lateinit var button: Button
    lateinit var error1: TextView
    lateinit var error2: TextView
    lateinit var edit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        option = findViewById<Spinner>(R.id.spinner)
        button=findViewById(R.id.button)
        error1=findViewById(R.id.textView3)
        error2=findViewById(R.id.textView4)
        edit=findViewById(R.id.editText1)

        val stacks = arrayOf("Choose Stack", "Nodejs", "C#", "Android", "Python")

        option.adapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stacks)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if(stacks.get(position)!="Choose Stack"){
                    error1.visibility= View.GONE
                    option.setBackgroundResource(R.drawable.input_drawable)
                }
                button.setOnClickListener{ view ->

                    if(stacks.get(position)=="Choose Stack"){
                        error1.visibility= View.VISIBLE
                        option.setBackgroundResource(R.drawable.error_drawable)
                    }else{

                        error1.visibility= View.GONE
                    }

                    if(edit.text.isEmpty()){
                        error2.visibility= View.VISIBLE
                        edit.setBackgroundResource(R.drawable.error_drawable)
                    }else{
                        error2.visibility = View.GONE
                    }
                }

                edit.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s : Editable?){}
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        error2.visibility = View.GONE
                        edit.setBackgroundResource(R.drawable.input_drawable)

                    }
                })
            }
        }
    }
}
