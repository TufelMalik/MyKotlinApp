package com.example.mykotlinapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mykotlinapp.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    var qty = 1

    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.order_dialog)
        var pn : TextView = dialog.findViewById(R.id.txtProNameDialog)
        var qty1: TextView = dialog.findViewById(R.id.txtQtyDialog)
        var btn : Button = dialog.findViewById(R.id.btnDone)

        btn.setOnClickListener {
            dialog.dismiss()
        }
        try {
            binding.txtProductName.setText(intent.getStringExtra("name"))
            binding.imgProduct.setImageResource(intent.getIntExtra("img",0))
            val price = intent.getStringExtra("price")
            val des = intent.getIntExtra("des",0)
            binding.txtPrice.setText(price)
            binding.txtDescription.setText(des)
            var a = intent.getStringExtra("name")
            actionBar!!.setTitle(a)
        }catch (e : Exception){
            Toast.makeText(this@FirstActivity,"Something went wrong !",Toast.LENGTH_SHORT).show()

            }
        val proName = intent .getStringExtra("name")

        binding.btnBuy.setOnClickListener {
            pn .text= proName
            qty1 .text= qty.toString()
            dialog.show()
            Toast.makeText(this@FirstActivity,"Your "+proName+("")+" order with "+ qty+ " hase been placed successfully....",Toast.LENGTH_SHORT).show()
        }
        binding.txtQty.text = "1"
        binding.btnPlus.setOnClickListener {
            qty +=1
            binding.txtQty.text =  qty.toString()
            checkQty()
        }

        binding.btnMinus.setOnClickListener {
            binding.txtQty.text = "0"
            qty -=1
            binding.txtQty.text =  qty.toString()
            checkQty()

        }




        }


    fun checkQty(){
        if (qty<1){
            qty=1
            binding.txtQty.setText("1")
        }



    }
}
