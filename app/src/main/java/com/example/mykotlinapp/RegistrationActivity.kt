package com.example.mykotlinapp

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mykotlinapp.Classes.Users
import com.example.mykotlinapp.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class RegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding

    private var email : String? = null
    private var pass : String? = null
    private var name : String? = null
    lateinit var imgUri : Uri
    var database = FirebaseDatabase.getInstance()
    var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        var progress = ProgressDialog(this)
        progress.setMessage("We are creating your account.\nPleas Wait...")

        binding.selectImgBtn.setOnClickListener {
            var intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            startActivityForResult(intent, 1)
        }
        binding.txtGotLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.regBtn.setOnClickListener {
            email = binding.etRegEmail.text.toString()
            pass = binding.etRegPass.text.toString()
            name = binding.etRegName.text.toString()
            if (!name.equals("") && !email.equals("") && !pass.equals("")) {
                progress.show()
                auth.createUserWithEmailAndPassword(
                    binding.etRegEmail.text.toString(),
                    binding.etRegPass.text.toString())
                    .addOnCompleteListener {task->
                        if (task.isSuccessful) {
                            email = binding.etRegEmail.text.toString()
                            pass = binding.etRegPass.text.toString()
                            name = binding.etRegName.text.toString()
                            var userId = auth.uid.toString()
                            var storage = FirebaseStorage.getInstance().reference.child("Users/$userId")
                            storage.putFile(imgUri).addOnSuccessListener {
                                storage.downloadUrl.addOnCompleteListener {
                                    var user = Users(name.toString(),email.toString(),pass.toString(), it.toString())
                                    database.getReference("Users").child(userId).setValue(user)
                                    progress.dismiss()
                                    startActivity(
                                        Intent(
                                            this@RegistrationActivity,
                                            MainActivity::class.java
                                        )
                                    )
                                    Toast.makeText(
                                        this@RegistrationActivity,
                                        "Registration Successfully...",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }else{
                            progress.dismiss()
                            Toast.makeText(
                                this@RegistrationActivity,
                                "Somthing Went Wrong !\npleas try again later... ",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                progress.dismiss()
                Toast.makeText(
                    this@RegistrationActivity,
                    "Pleas Enter full craiteare !",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null){
            if(data.data != null){
                imgUri = data.data!!
                binding.userImage.setImageURI(imgUri)
            }
        }
    }
}

