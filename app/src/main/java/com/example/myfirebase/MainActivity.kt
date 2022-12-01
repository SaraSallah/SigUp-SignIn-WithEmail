package com.example.myfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        //Sign_in Intent
        btn_SignIn.setOnClickListener{
            val intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }
        //Sign_UP intent
        btn_Signup.setOnClickListener{
            val intent =Intent(this,SignUp::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){ // when we signed already
            val intent = Intent(this ,Home::class.java)
            startActivity(intent)
        }

    }
}