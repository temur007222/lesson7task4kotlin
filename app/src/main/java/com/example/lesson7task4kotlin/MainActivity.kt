package com.example.lesson7task4kotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById<View>(R.id.text_input_email) as EditText
        password = findViewById<View>(R.id.text_input_password) as EditText
        loginButton = findViewById<View>(R.id.input_button) as Button
        textView = findViewById<View>(R.id.textView) as TextView

        email.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            textView.text = email.text.toString()
            false
        })

        loginButton.isEnabled

        val textWatcher:TextWatcher = object :TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val emailInput = email.text.toString()
                val passwordText = password.text.toString()
                loginButton.isEnabled = !emailInput.contentEquals("") && !passwordText.contentEquals("")
            }
        }
        email.addTextChangedListener(textWatcher)
        password.addTextChangedListener(textWatcher)
    }
}