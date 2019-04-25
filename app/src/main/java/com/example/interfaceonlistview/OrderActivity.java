package com.example.interfaceonlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.model.Food;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ListView lvFood;
    ArrayAdapter<String> adapterFood;
    TextView txtTong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        int price=0;
        txtTong=findViewById(R.id.txtTong);
        lvFood=findViewById(R.id.lvFood);
        adapterFood= new ArrayAdapter<String>(OrderActivity.this,android.R.layout.simple_list_item_1);
        lvFood.setAdapter(adapterFood);
        for(Food food : MainActivity.dsChon){
            price+=food.getPrice();
            adapterFood.add(food.getName());
            adapterFood.notifyDataSetChanged();
        }
        txtTong.setText(price+"");
    }

}
