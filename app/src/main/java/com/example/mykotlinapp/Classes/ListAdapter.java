package com.example.mykotlinapp.Classes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mykotlinapp.R;

public class ListAdapter extends ArrayAdapter<String> {
    public  final Activity activity;
    public final String []  name ;
    public final Integer[] imgs;
    public final String[] price;
    public final Integer[] des;


    public ListAdapter(Activity activity, String[] name,Integer[]  imgs ,String[] price,Integer[] des) {
        super(activity, R.layout.cstmlistview,name);
        this.activity = activity;
        this.name = name;
        this.imgs = imgs;
        this.price = price;
        this.des = des;
    }

    public View getView(int i ,View view , ViewGroup viewGroup){
        View v1 = activity.getLayoutInflater().inflate(R.layout.cstmlistview,null,false);
        ImageView img = v1.findViewById(R.id.imgCustom);
        TextView pName = v1.findViewById(R.id.txtProductNameCustom);
        TextView pPrice = v1.findViewById(R.id.txtProductPriceCustom);
        TextView shortDescription = v1.findViewById(R.id.txtShortDes);

        try {
           shortDescription.setText(des[i]);
            pName.setText(name[i]);
            img.setImageResource(imgs[i]);
            pPrice.setText(price[i]);

        }catch (Exception e){
            Toast.makeText(activity, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
        return v1;


    }
}
