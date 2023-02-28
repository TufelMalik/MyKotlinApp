package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinapp.Classes.RecyclerAdapter
import com.example.mykotlinapp.Classes.RecyclerDataClass
import com.example.mykotlinapp.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var newArrayList: ArrayList<RecyclerDataClass>

    val img = arrayOf<Int>(
        R.drawable.basket,
        R.drawable.bucketmop1,
        R.drawable.bucketmop2,
        R.drawable.chpper1,
        R.drawable.dabbaset1,
        R.drawable.dabbaset2,
        R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,
        R.drawable.masala_dabba1,
        R.drawable.masala_rack_set,
        R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1,
        R.drawable.milton_dumbells,
        R.drawable.milton_duplex_spa,
        R.drawable.milton_insulated_bottle,
        R.drawable.tissue,
        R.drawable.toilet_roll,
        R.drawable.basket,
        R.drawable.bucketmop1,
        R.drawable.bucketmop2,
        R.drawable.chpper1,
        R.drawable.dabbaset1,
        R.drawable.dabbaset2,
        R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,
        R.drawable.masala_dabba1,
        R.drawable.masala_rack_set,
        R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1,
        R.drawable.milton_dumbells,
        R.drawable.milton_duplex_spa,
        R.drawable.milton_insulated_bottle,
        R.drawable.tissue,
        R.drawable.toilet_roll,
        R.drawable.basket,
        R.drawable.bucketmop1,
        R.drawable.bucketmop2,
        R.drawable.chpper1,
        R.drawable.dabbaset1,
        R.drawable.dabbaset2,
        R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,
        R.drawable.masala_dabba1,
        R.drawable.masala_rack_set,
        R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1,
        R.drawable.milton_dumbells,
        R.drawable.milton_duplex_spa,
        R.drawable.milton_insulated_bottle,
        R.drawable.tissue,
        R.drawable.toilet_roll,
        R.drawable.basket,
        R.drawable.bucketmop1,
        R.drawable.bucketmop2,
        R.drawable.chpper1,
        R.drawable.dabbaset1,
        R.drawable.dabbaset2,
        R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,
        R.drawable.masala_dabba1,
        R.drawable.masala_rack_set,
        R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1,
        R.drawable.milton_dumbells,
        R.drawable.milton_duplex_spa,
        R.drawable.milton_insulated_bottle,
        R.drawable.tissue,
        R.drawable.toilet_roll,
        R.drawable.basket,
        R.drawable.bucketmop1,
        R.drawable.bucketmop2,
        R.drawable.chpper1,
        R.drawable.dabbaset1,
        R.drawable.dabbaset2,
        R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,
        R.drawable.masala_dabba1,
        R.drawable.masala_rack_set,
        R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1,
        R.drawable.milton_dumbells,
        R.drawable.milton_duplex_spa,
        R.drawable.milton_insulated_bottle,
        R.drawable.tissue,
        R.drawable.toilet_roll,
        R.drawable.basket,
        R.drawable.bucketmop1,
        R.drawable.bucketmop2,
        R.drawable.chpper1,
        R.drawable.dabbaset1,
        R.drawable.dabbaset2,
        R.drawable.dabbaset3,
        R.drawable.insulated_water_bottle,
        R.drawable.masala_dabba1,
        R.drawable.masala_rack_set,
        R.drawable.masala_rack_set2,
        R.drawable.milton_bath_set1,
        R.drawable.milton_dumbells,
        R.drawable.milton_duplex_spa,
        R.drawable.milton_insulated_bottle,
        R.drawable.tissue,
        R.drawable.toilet_roll

    )
    val nm1 = arrayOf<String>(
        "BASKET", "SMART BUCKET MOP", "BUCKET MOP", "PUSH CHOPPER", "3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET", "INSULATED WATER BOTTLE", "MASALA DABBA",
        "ROYAL MASALA RACK SET", "MASALA RACK", "MILTON BATHROOM SET", "MILTON DUMBELLS",
        "MILTON DUPLEX", "MILTON WATER BOTTLE", "TSSIUE PAPER", "TOILET ROLL",
        "BASKET", "SMART BUCKET MOP", "BUCKET MOP", "PUSH CHOPPER", "3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET", "INSULATED WATER BOTTLE", "MASALA DABBA",
        "ROYAL MASALA RACK SET", "MASALA RACK", "MILTON BATHROOM SET", "MILTON DUMBELLS",
        "MILTON DUPLEX", "MILTON WATER BOTTLE", "TSSIUE PAPER", "TOILET ROLL",
        "BASKET", "SMART BUCKET MOP", "BUCKET MOP", "PUSH CHOPPER", "3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET", "INSULATED WATER BOTTLE", "MASALA DABBA",
        "ROYAL MASALA RACK SET", "MASALA RACK", "MILTON BATHROOM SET", "MILTON DUMBELLS",
        "MILTON DUPLEX", "MILTON WATER BOTTLE", "TSSIUE PAPER", "TOILET ROLL",
        "BASKET", "SMART BUCKET MOP", "BUCKET MOP", "PUSH CHOPPER", "3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET", "INSULATED WATER BOTTLE", "MASALA DABBA",
        "ROYAL MASALA RACK SET", "MASALA RACK", "MILTON BATHROOM SET", "MILTON DUMBELLS",
        "MILTON DUPLEX", "MILTON WATER BOTTLE", "TSSIUE PAPER", "TOILET ROLL",
        "BASKET", "SMART BUCKET MOP", "BUCKET MOP", "PUSH CHOPPER", "3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET", "INSULATED WATER BOTTLE", "MASALA DABBA",
        "ROYAL MASALA RACK SET", "MASALA RACK", "MILTON BATHROOM SET", "MILTON DUMBELLS",
        "MILTON DUPLEX", "MILTON WATER BOTTLE", "TSSIUE PAPER", "TOILET ROLL",
        "BASKET", "SMART BUCKET MOP", "BUCKET MOP", "PUSH CHOPPER", "3 DABBA SET",
        "SMALL DABBA SET", "BIG DABBA SET", "INSULATED WATER BOTTLE", "MASALA DABBA",
        "ROYAL MASALA RACK SET", "MASALA RACK", "MILTON BATHROOM SET", "MILTON DUMBELLS",
        "MILTON DUPLEX", "MILTON WATER BOTTLE", "TSSIUE PAPER", "TOILET ROLL"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = ArrayList<RecyclerDataClass>()
        var adapterRes : RecyclerAdapter? = null

        list.add(RecyclerDataClass("fdv", R.drawable.bucketmop2))
        list.add(RecyclerDataClass("fdv", R.drawable.chpper1))
        list.add(RecyclerDataClass("fdv", R.drawable.bg1))
        list.add(RecyclerDataClass("fdv", R.drawable.basket))
        list.add(RecyclerDataClass("fdv", R.drawable.bucketmop2))
        list.add(RecyclerDataClass("fdv", R.drawable.bucketmop2))
        list.add(RecyclerDataClass("fdv", R.drawable.bucketmop2))
        list.add(RecyclerDataClass("fdv", R.drawable.bucketmop2))

        adapterRes = RecyclerAdapter(list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapterRes



    }
}