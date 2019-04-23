package com.example.interfaceonlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Interface.ButtonInterface;
import com.example.adapter.FoodAdapter;
import com.example.model.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ButtonInterface {
    ListView lvFood;
    FoodAdapter foodAdapter;
    ArrayList<Food> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        fakeData();
    }

    private void addEvents() {
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void fakeData() {
        for(int i=0;i<100;i++){
            foods.add(new Food("Cơm gà",25000));
            foods.add(new Food("Cơm cá",15000));
            foods.add(new Food("Cơm heo",25000));
            foods.add(new Food("Cơm mực",25000));
            foods.add(new Food("Cơm tôm",25000));
        }
    }

    private void addControls() {
        lvFood=findViewById(R.id.lvFood);
        foods= new ArrayList<Food>();
        foods.add(new Food("Cơm gà",25000));
        foods.add(new Food("Cơm cá",15000));
        foods.add(new Food("Cơm heo",25000));
        foods.add(new Food("Cơm mực",25000));
        foods.add(new Food("Cơm tôm",25000));
        foodAdapter= new FoodAdapter(MainActivity.this,R.layout.item,foods);
        foodAdapter.isClicked(this);
        lvFood.setAdapter(foodAdapter);
    }

    @Override
    public void checkedOnClick(int position) {
        Food food=foods.get(position);
        Toast.makeText(MainActivity.this,"Chọn "+food.getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteOnclick(int position) {
        Food food=foods.get(position);
        Toast.makeText(MainActivity.this,"Bỏ chọn "+food.getName(),Toast.LENGTH_SHORT).show();
    }
}
