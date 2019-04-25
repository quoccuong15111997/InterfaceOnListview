package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Interface.ButtonInterface;
import com.example.interfaceonlistview.MainActivity;
import com.example.interfaceonlistview.R;
import com.example.model.Food;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {
    Activity mContext;
    List<Food> objects;
    int resource;
    private  ButtonInterface buttonInterface;
    public void isClicked(ButtonInterface buttonInterface){
        this.buttonInterface=buttonInterface;
    }
    public FoodAdapter(Context context, int resource,  List<Food> objects) {
        super(context, resource, objects);
        this.mContext= (Activity) context;
        this.resource=resource;
        this.objects=objects;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;
        LayoutInflater layoutInflater=this.mContext.getLayoutInflater();


        if(convertView==null){
            convertView=layoutInflater.inflate(this.resource,null);
            viewHolder= new ViewHolder();
            viewHolder.txtName=convertView.findViewById(R.id.txtName);
            viewHolder.txtPrice=convertView.findViewById(R.id.txtPrice);
            viewHolder.imgCheck=convertView.findViewById(R.id.imgCheck);
            viewHolder.imgDelete=convertView.findViewById(R.id.imgDelete);
            viewHolder.imgHinh=convertView.findViewById(R.id.imhHinh);
            viewHolder.position=position;

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Food food=objects.get(position);
        viewHolder.txtName.setText(food.getName());
        viewHolder.txtPrice.setText(food.getPrice()+"");
        viewHolder.imgHinh.setImageResource(food.getImage());

        viewHolder.imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonInterface.checkedOnClick(position);
                viewHolder.imgCheck.setImageResource(R.drawable.check_50px);
            }
        });
        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonInterface.deleteOnclick(position);
                viewHolder.imgCheck.setImageResource(R.drawable.ok_50px);
            }
        });

        return convertView;
    }
    public static class ViewHolder{
        TextView txtName;
        TextView txtPrice;
        ImageView imgCheck;
        ImageView imgDelete;
        ImageView imgHinh;
        int position;
    }
}
