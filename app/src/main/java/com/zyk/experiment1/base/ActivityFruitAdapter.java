package com.zyk.experiment1.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.zyk.experiment1.R;
import com.zyk.experiment1.domain.Fruit;

import java.util.List;

public class ActivityFruitAdapter extends ArrayAdapter<Fruit> {
    private int newResourceId;

    public ActivityFruitAdapter(Context context, int resourceId, List<Fruit> fruitList) {
        super(context, resourceId, fruitList);
        newResourceId = resourceId;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(newResourceId, parent, false);

        TextView prodName = view.findViewById(R.id.fruit_name);
        ImageView prodImage = view.findViewById(R.id.fruit_image);
        TextView prodInfo = view.findViewById(R.id.fruit_Info);

        prodName.setText(fruit.getName());
        prodImage.setImageResource(fruit.getImageId());
        prodInfo.setText(fruit.getInfo());

        return view;
    }
}
