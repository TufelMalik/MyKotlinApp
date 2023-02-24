package com.example.mykotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlinapp.Classes.ListAdapter
import com.example.mykotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val img  = arrayOf<Int>(
        R.drawable.basket ,R.drawable.bucketmop1,R.drawable.bucketmop2,R.drawable.chpper1,R.drawable.dabbaset1,R.drawable.dabbaset2,R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,R.drawable.masala_dabba1,R.drawable.masala_rack_set,R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1 ,R.drawable.milton_dumbells,R.drawable.milton_duplex_spa,R.drawable.milton_insulated_bottle,
        R.drawable.tissue,R.drawable.toilet_roll,
        R.drawable.basket ,R.drawable.bucketmop1,R.drawable.bucketmop2,R.drawable.chpper1,R.drawable.dabbaset1,R.drawable.dabbaset2,R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,R.drawable.masala_dabba1,R.drawable.masala_rack_set,R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1 ,R.drawable.milton_dumbells,R.drawable.milton_duplex_spa,R.drawable.milton_insulated_bottle,
        R.drawable.tissue,R.drawable.toilet_roll,
        R.drawable.basket ,R.drawable.bucketmop1,R.drawable.bucketmop2,R.drawable.chpper1,R.drawable.dabbaset1,R.drawable.dabbaset2,R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,R.drawable.masala_dabba1,R.drawable.masala_rack_set,R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1 ,R.drawable.milton_dumbells,R.drawable.milton_duplex_spa,R.drawable.milton_insulated_bottle,
        R.drawable.tissue,R.drawable.toilet_roll,
        R.drawable.basket ,R.drawable.bucketmop1,R.drawable.bucketmop2,R.drawable.chpper1,R.drawable.dabbaset1,R.drawable.dabbaset2,R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,R.drawable.masala_dabba1,R.drawable.masala_rack_set,R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1 ,R.drawable.milton_dumbells,R.drawable.milton_duplex_spa,R.drawable.milton_insulated_bottle,
        R.drawable.tissue,R.drawable.toilet_roll,
        R.drawable.basket ,R.drawable.bucketmop1,R.drawable.bucketmop2,R.drawable.chpper1,R.drawable.dabbaset1,R.drawable.dabbaset2,R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,R.drawable.masala_dabba1,R.drawable.masala_rack_set,R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1 ,R.drawable.milton_dumbells,R.drawable.milton_duplex_spa,R.drawable.milton_insulated_bottle,
        R.drawable.tissue,R.drawable.toilet_roll,
        R.drawable.basket ,R.drawable.bucketmop1,R.drawable.bucketmop2,R.drawable.chpper1,R.drawable.dabbaset1,R.drawable.dabbaset2,R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,R.drawable.masala_dabba1,R.drawable.masala_rack_set,R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1 ,R.drawable.milton_dumbells,R.drawable.milton_duplex_spa,R.drawable.milton_insulated_bottle,
        R.drawable.tissue,R.drawable.toilet_roll

        )
    private val price = arrayOf<String>(
        "₹ 250","₹ 750","₹ 650","₹ 250","₹ 300","₹ 150","₹ 180","₹ 550","₹ 280","₹ 450","₹ 300","₹ 750","₹ 40","₹ 40","₹ 580","₹ 100","₹ 40",
        "₹ 250","₹ 750","₹ 650","₹ 250","₹ 300","₹ 150","₹ 180","₹ 550","₹ 280","₹ 450","₹ 300","₹ 750","₹ 40","₹ 40","₹ 580","₹ 100","₹ 40",
        "₹ 250","₹ 750","₹ 650","₹ 250","₹ 300","₹ 150","₹ 180","₹ 550","₹ 280","₹ 450","₹ 300","₹ 750","₹ 40","₹ 40","₹ 580","₹ 100","₹ 40",
        "₹ 250","₹ 750","₹ 650","₹ 250","₹ 300","₹ 150","₹ 180","₹ 550","₹ 280","₹ 450","₹ 300","₹ 750","₹ 40","₹ 40","₹ 580","₹ 100","₹ 40",
        "₹ 250","₹ 750","₹ 650","₹ 250","₹ 300","₹ 150","₹ 180","₹ 550","₹ 280","₹ 450","₹ 300","₹ 750","₹ 40","₹ 40","₹ 580","₹ 100","₹ 40",
        "₹ 250","₹ 750","₹ 650","₹ 250","₹ 300","₹ 150","₹ 180","₹ 550","₹ 280","₹ 450","₹ 300","₹ 750","₹ 40","₹ 40","₹ 580","₹ 100","₹ 40"

    )
    private val nm1 = arrayOf<String>(
        "BASKET","SMART BUCKET MOP","BUCKET MOP", "PUSH CHOPPER","3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET","INSULATED WATER BOTTLE","MASALA DABBA",
        "ROYAL MASALA RACK SET","MASALA RACK","MILTON BATHROOM SET","MILTON DUMBELLS",
        "MILTON DUPLEX","MILTON WATER BOTTLE", "TSSIUE PAPER","TOILET ROLL",
        "BASKET","SMART BUCKET MOP","BUCKET MOP", "PUSH CHOPPER","3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET","INSULATED WATER BOTTLE","MASALA DABBA",
        "ROYAL MASALA RACK SET","MASALA RACK","MILTON BATHROOM SET","MILTON DUMBELLS",
        "MILTON DUPLEX","MILTON WATER BOTTLE", "TSSIUE PAPER","TOILET ROLL",
        "BASKET","SMART BUCKET MOP","BUCKET MOP", "PUSH CHOPPER","3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET","INSULATED WATER BOTTLE","MASALA DABBA",
        "ROYAL MASALA RACK SET","MASALA RACK","MILTON BATHROOM SET","MILTON DUMBELLS",
        "MILTON DUPLEX","MILTON WATER BOTTLE", "TSSIUE PAPER","TOILET ROLL",
        "BASKET","SMART BUCKET MOP","BUCKET MOP", "PUSH CHOPPER","3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET","INSULATED WATER BOTTLE","MASALA DABBA",
        "ROYAL MASALA RACK SET","MASALA RACK","MILTON BATHROOM SET","MILTON DUMBELLS",
        "MILTON DUPLEX","MILTON WATER BOTTLE", "TSSIUE PAPER","TOILET ROLL",
        "BASKET","SMART BUCKET MOP","BUCKET MOP", "PUSH CHOPPER","3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET","INSULATED WATER BOTTLE","MASALA DABBA",
        "ROYAL MASALA RACK SET","MASALA RACK","MILTON BATHROOM SET","MILTON DUMBELLS",
        "MILTON DUPLEX","MILTON WATER BOTTLE", "TSSIUE PAPER","TOILET ROLL",
        "BASKET","SMART BUCKET MOP","BUCKET MOP", "PUSH CHOPPER","3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET","INSULATED WATER BOTTLE","MASALA DABBA",
        "ROYAL MASALA RACK SET","MASALA RACK","MILTON BATHROOM SET","MILTON DUMBELLS",
        "MILTON DUPLEX","MILTON WATER BOTTLE", "TSSIUE PAPER","TOILET ROLL"
    )
    private val des = arrayOf<Int>( R.string.BasketDes, R.string.SmartBuckeMopDes, R.string.BUCKET_MOP_Des, R.string.PUSH_CHOPPER_Des, R.string.ThreeDABBASET_Des,
        R.string.SmartBuckeMopDes, R.string.BIGDABBASET_Des, R.string.INSULATEDWATERBOTTLE_Des, R.string.MASALDABBA_Des,
        R.string.ROYALMASALARACKSET_Des, R.string.MASALARACK_Des, R.string.MILTONBATHROOMSET_Des, R.string.MILTONDUMBELLS_Des,
        R.string.MILTONDUPLEX_Des, R.string.MILTONWATERBOTTLE_Des, R.string.TSSIUEPAPER_Des, R.string.TOILETPAPER_Des,
        R.string.BasketDes, R.string.SmartBuckeMopDes, R.string.BUCKET_MOP_Des, R.string.PUSH_CHOPPER_Des, R.string.ThreeDABBASET_Des,
        R.string.SmartBuckeMopDes, R.string.BIGDABBASET_Des, R.string.INSULATEDWATERBOTTLE_Des, R.string.MASALDABBA_Des,
        R.string.ROYALMASALARACKSET_Des, R.string.MASALARACK_Des, R.string.MILTONBATHROOMSET_Des, R.string.MILTONDUMBELLS_Des,
        R.string.MILTONDUPLEX_Des, R.string.MILTONWATERBOTTLE_Des, R.string.TSSIUEPAPER_Des, R.string.TOILETPAPER_Des,
        R.string.BasketDes, R.string.SmartBuckeMopDes, R.string.BUCKET_MOP_Des, R.string.PUSH_CHOPPER_Des, R.string.ThreeDABBASET_Des,
        R.string.SmartBuckeMopDes, R.string.BIGDABBASET_Des, R.string.INSULATEDWATERBOTTLE_Des, R.string.MASALDABBA_Des,
        R.string.ROYALMASALARACKSET_Des, R.string.MASALARACK_Des, R.string.MILTONBATHROOMSET_Des, R.string.MILTONDUMBELLS_Des,
        R.string.MILTONDUPLEX_Des, R.string.MILTONWATERBOTTLE_Des, R.string.TSSIUEPAPER_Des, R.string.TOILETPAPER_Des,
        R.string.BasketDes, R.string.SmartBuckeMopDes, R.string.BUCKET_MOP_Des, R.string.PUSH_CHOPPER_Des, R.string.ThreeDABBASET_Des,
        R.string.SmartBuckeMopDes, R.string.BIGDABBASET_Des, R.string.INSULATEDWATERBOTTLE_Des, R.string.MASALDABBA_Des,
        R.string.ROYALMASALARACKSET_Des, R.string.MASALARACK_Des, R.string.MILTONBATHROOMSET_Des, R.string.MILTONDUMBELLS_Des,
        R.string.MILTONDUPLEX_Des, R.string.MILTONWATERBOTTLE_Des, R.string.TSSIUEPAPER_Des, R.string.TOILETPAPER_Des,
        R.string.BasketDes, R.string.SmartBuckeMopDes, R.string.BUCKET_MOP_Des, R.string.PUSH_CHOPPER_Des, R.string.ThreeDABBASET_Des,
        R.string.SmartBuckeMopDes, R.string.BIGDABBASET_Des, R.string.INSULATEDWATERBOTTLE_Des, R.string.MASALDABBA_Des,
        R.string.ROYALMASALARACKSET_Des, R.string.MASALARACK_Des, R.string.MILTONBATHROOMSET_Des, R.string.MILTONDUMBELLS_Des,
        R.string.MILTONDUPLEX_Des, R.string.MILTONWATERBOTTLE_Des, R.string.TSSIUEPAPER_Des, R.string.TOILETPAPER_Des,
        R.string.BasketDes, R.string.SmartBuckeMopDes, R.string.BUCKET_MOP_Des, R.string.PUSH_CHOPPER_Des, R.string.ThreeDABBASET_Des,
        R.string.SmartBuckeMopDes, R.string.BIGDABBASET_Des, R.string.INSULATEDWATERBOTTLE_Des, R.string.MASALDABBA_Des,
        R.string.ROYALMASALARACKSET_Des, R.string.MASALARACK_Des, R.string.MILTONBATHROOMSET_Des, R.string.MILTONDUMBELLS_Des,
        R.string.MILTONDUPLEX_Des, R.string.MILTONWATERBOTTLE_Des, R.string.TSSIUEPAPER_Des, R.string.TOILETPAPER_Des
    )

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar!!.setTitle("Plastic Center")

        val listAdapter = ListAdapter(this@MainActivity,nm1,img,price,des)
        binding.listView.adapter = listAdapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity,FirstActivity::class.java)
                intent.putExtra("img",img[position])
                intent .putExtra("name",nm1[position])
                intent.putExtra("price",price[position])
                intent.putExtra("des",des[position])
                startActivity(intent)
        }
    }
}