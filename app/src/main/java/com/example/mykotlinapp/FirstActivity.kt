package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mykotlinapp.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar

        try {
            binding.txtProductName.setText(intent.getStringExtra("name"))
            binding.imgProduct.setImageResource(intent.getIntExtra("img",0))
            val price = intent.getStringExtra("price")
            val des = intent.getIntExtra("des",0)
            binding.txtPrice.setText(price)
            binding.txtDescription.setText(des)
            val a = intent.getStringExtra("name")
            actionBar!!.setTitle(a)
            actionBar.setIcon(intent.getIntExtra("img",0))
        }catch (e : Exception){
            Toast.makeText(this@FirstActivity,"Something went wrong !",Toast.LENGTH_SHORT).show()
        }
    }
}
