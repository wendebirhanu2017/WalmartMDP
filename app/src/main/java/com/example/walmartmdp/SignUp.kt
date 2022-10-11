package com.example.walmartmdp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shopping.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlin.math.sign

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpBtn.setOnClickListener {
            var user = User("","","","")
           var data = Intent()
            data.putExtra("firstName", "${firstNameEdit.text}")
            data.putExtra("lastName", "${lastNameEdit.text}")
            data.putExtra("email", "${emailEdit.text}")
            data.putExtra("password", "${passwordEdit.text}")

            setResult(RESULT_OK, data)
            finish()
        }
    }

}