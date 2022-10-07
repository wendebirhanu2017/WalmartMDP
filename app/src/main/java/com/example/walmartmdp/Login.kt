package com.example.walmartmdp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var txtForgot: TextView
    private lateinit var btnSignIn: Button
    private lateinit var txtCreate: TextView
    private var user = ArrayList<User>(listOf(
        User("wende", "kebe", "wendmagegn.b@gmail.com", "pss"),
        User("taye", "wube", "taye@gmail.com", "pss"),
        User("mike", "mer", "mike@gmail.com", "pss"),
        User("roma", "haji", "roma@gmail.com", "pss"),
        User("doyo", "awe", "doyo@gmail.com","pss")))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = emailEdit;
        edtPassword = passwordEdit
        txtForgot = forgotTxt
        btnSignIn = signInBtn
        txtCreate = createTxt

        txtCreate.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        btnSignIn.setOnClickListener {
            val email = edtEmail.text.toString()
            val pass = edtPassword.text.toString()


            val thisUser: User? = user.firstOrNull() { u: User ->
                u.userName.equals(email)
            }

            if (thisUser != null) {
                if(thisUser.password.equals(pass)){
                    val intent = Intent(this, SignUp::class.java)
                    startActivity(intent)
                }
                else Toast.makeText(this, "Invalid Password ", Toast.LENGTH_LONG).show()

            }
            else Toast.makeText(this, "Invalid Username ", Toast.LENGTH_LONG).show()

        }
    }
}