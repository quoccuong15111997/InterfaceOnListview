package com.example.interfaceonlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
    public static ArrayList<Food> dsChon = new ArrayList<>();
    Button btnOrder;


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
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrder();
            }
        });
    }

    private void openOrder() {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        for (Food food : dsChon) {
        }
        startActivity(intent);
    }

    private void fakeData() {
        foods.add(new Food("Cơm gà", 25000, R.drawable.banana));
        foods.add(new Food("Cơm cá", 15000, R.drawable.mix));
        foods.add(new Food("Cơm heo", 25000, R.drawable.orange));
        foods.add(new Food("Cơm mực", 25000, R.drawable.banana));
        foods.add(new Food("Cơm tôm", 25000, R.drawable.mix));

        foods.add(new Food("Sting", 15000, R.drawable.banana));
        foods.add(new Food("Redbull", 15000, R.drawable.mix));
        foods.add(new Food("O Độ", 15000, R.drawable.orange));
        foods.add(new Food("C2", 10000, R.drawable.banana));
        foods.add(new Food("Mắm tôm", 25000, R.drawable.mix));

    }

    private void addControls() {
        lvFood = findViewById(R.id.lvFood);
        foods = new ArrayList<Food>();
        foodAdapter = new FoodAdapter(MainActivity.this, R.layout.item, foods);
        foodAdapter.isClicked(this);
        lvFood.setAdapter(foodAdapter);
        btnOrder = findViewById(R.id.btnOrder);
    }

    @Override
    public void checkedOnClick(int position) {
        Food food = foods.get(position);
        Toast.makeText(MainActivity.this,"Chọn "+food.getName(), Toast.LENGTH_SHORT).show();
        dsChon.add(food);
    }

    @Override
    public void deleteOnclick(int position) {
        Food food = foods.get(position);
        Toast.makeText(MainActivity.this,"Bỏ chọn "+food.getName(),Toast.LENGTH_SHORT).show();
        dsChon.remove(food);
    }
}
