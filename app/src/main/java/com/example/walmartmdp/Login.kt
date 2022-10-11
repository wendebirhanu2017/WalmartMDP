package com.example.walmartmdp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {

    private var user = ArrayList<User>(listOf(
        User("wende", "kebe", "wendmagegn.b@gmail.com", "pss"),
        User("taye", "wube", "taye@gmail.com", "pss"),
        User("mike", "mer", "mike@gmail.com", "pss"),
        User("roma", "haji", "roma@gmail.com", "pss"),
        User("doyo", "awe", "doyo@gmail.com","pss")))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                val first = result.data?.extras?.get("firstName").toString()
                val last = result.data?.extras?.get("lastName").toString()
                val em = result.data?.extras?.get("email").toString()
                val pass = result.data?.extras?.get("password").toString()

                val userNew = User(first,last,em,pass)
                user.add(userNew)

            }
        }


        createTxt.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            resultLauncher.launch(intent)
        }



        signInBtn.setOnClickListener {
            val email = emailEdit.text.toString()
            val pass = passwordEdit.text.toString()


            val thisUser: User? = user.firstOrNull() { u -> u.userName==email }

            if (thisUser != null) {
                if(thisUser.password==pass){
                    val intent = Intent(this, Shopping::class.java)
                    intent.putExtra("username", thisUser.userName)
                    startActivity(intent)
                }
                else Toast.makeText(this, "Invalid Password ", Toast.LENGTH_LONG).show()

            }
            else Toast.makeText(this, "Invalid Username ", Toast.LENGTH_LONG).show()

        }
    }


}
