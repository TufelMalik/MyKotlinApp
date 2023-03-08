package com.example.mykotlinapp

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mykotlinapp.Classes.Users
import com.example.mykotlinapp.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User
import com.google.firebase.storage.FirebaseStorage
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    lateinit var database: FirebaseDatabase
    lateinit var storage: FirebaseStorage
    lateinit var auth : FirebaseAuth
    private lateinit var imgUri: Uri
    private lateinit var dialog: AlertDialog.Builder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = binding.etName.text.toString()
        val address = binding.etAddress.text.toString()
        val cource = binding.etCource.text.toString()

        dialog = AlertDialog.Builder(this@ProfileActivity)
            .setMessage("Uploading Image...")


        //  Inisialization of Firebase Insatances...
        database = FirebaseDatabase.getInstance()
        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()


        binding.btnImageSelect.setOnClickListener {
            selectImageFun()
        }
        binding.btnSave.setOnClickListener {
             uploadImageFun()
        }

    }

    private fun uploadImageFun() {

        val name = binding.etName.text.toString()
        val address = binding.etAddress.text.toString()
        val cource = binding.etCource.text.toString()
        if(name.equals("")&& address.equals("") && cource.equals("")) {
            Toast.makeText(this@ProfileActivity, "Pleas Fill All Detials First", Toast.LENGTH_SHORT)
                .show()
        }else {
            //dialog.show()
            val reference = storage.reference.child("ProfileImage").child(Date().time.toString())
            reference.putFile(imgUri).addOnCompleteListener {
                if(it.isSuccessful){
                    reference.downloadUrl.addOnSuccessListener { task->
                        uploadAllInfo(task.toString())
                        }

                }
            }
        }
    }

    private fun uploadAllInfo(imgUrl: String) {
        val user = Users(binding.etName.text.toString(),binding.etAddress.text.toString(),binding.etCource.text.toString(), imgUrl)
        database.getReference("Users")
            .child(user.name)
            .setValue(user).addOnSuccessListener {
                Toast.makeText(this@ProfileActivity,"Uploaded Successfully...",Toast.LENGTH_SHORT).show()
            }
        binding.btnDelete.setOnClickListener {
            database.getReference("Users").child(user.name).removeValue()
        }
    }


    private fun selectImageFun() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            if (data.data != null) {
                imgUri = data.data!!
                binding.userImage.setImageURI(imgUri)
            }
        }
    }
}




