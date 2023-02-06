package com.example.mykotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mykotlinapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    val email : String = "mtufel21@gmail.com"
    val passwrod : String = "8090100"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            if (!binding.etEmail.text.toString().equals(" ") && !binding.etPass.text.toString().equals(" ")){
                if(binding.etEmail.text.toString().equals(email) && binding.etPass.text.toString().equals(passwrod)){
                    val intent = Intent(this@LoginActivity,MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@LoginActivity,"Invalid Email or Password !",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@LoginActivity,"Pleas Enter Email or Password !",Toast.LENGTH_SHORT).show()
                
            }

        }


    }
}