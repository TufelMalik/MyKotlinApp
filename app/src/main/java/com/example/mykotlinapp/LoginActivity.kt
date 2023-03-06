package com.example.mykotlinapp

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.mykotlinapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseDatabase

//https://github.com/TeamBca21/ChatHub.git      ChatHub GitLink....

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        database =FirebaseDatabase.getInstance()

        var progress = ProgressDialog(this)
        progress.setMessage("Login Pleas Wait...")

        // NAVIGATION ACTIVITY DIALOG
        var dialogNav = Dialog(this)
        dialogNav.setContentView(R.layout.naviagation_dialog)
        binding.txtGotoReg.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

                binding.txtNavigation.setOnClickListener {
                    var btnProfile : Button = dialogNav.findViewById(R.id.btnProfile)
                    btnProfile.setOnClickListener {
                        dialogNav.dismiss()
                        var intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                        startActivity(intent)
                    }
                    var btnRecycler : Button = dialogNav.findViewById(R.id.btnRecy)
                    btnRecycler.setOnClickListener {
                        dialogNav.dismiss()
                        var intent = Intent(this@LoginActivity, RecyclerViewActivity::class.java)
                        startActivity(intent)
                }
                    dialogNav.show()
            }
        binding.btnLogin.setOnClickListener {
            var email = binding.etEmail.text.toString()
            var pass = binding.etPass.text.toString()

            if (!email.equals("") && !pass.equals("")) {
                progress.show()
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener { task->
                    if(task.isSuccessful){

                        Toast.makeText(this@LoginActivity,"Login Successfully...",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@LoginActivity,"You don't have any account \npleas SinUp first.",Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this@LoginActivity,"Login faild.\nPleas try agian later...",Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Pleas Enter Email or Password !",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
