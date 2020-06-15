package com.intern.nudleapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BrandAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;

    public BrandAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new Item("upto 50% off",       R.drawable.virat,R.drawable.wrong));
        mItems.add(new Item("upto 60% off",  R.drawable.road,R.drawable.roadster));
        mItems.add(new Item("upto 70% off", R.drawable.selena,R.drawable.puma));
    }


    public int getCount() {
        return mItems.size();
    }


    public Item getItem(int i) {
        return mItems.get(i);
    }


    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }


    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;
        ImageView picture1;

        if (v == null) {
            v = mInflater.inflate(R.layout.brandgrid_list, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
            v.setTag(R.id.picture1,v.findViewById(R.id.picture1));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);
        picture1 = (ImageView) v.getTag(R.id.picture1);
        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        picture1.setImageResource(item.drawableId1);
        name.setText(item.name);

        return v;
    }

    private static class Item {
        public final String name;
        public final int drawableId;
        public final int drawableId1;

        Item(String name, int drawableId,int drawableId1) {
            this.name = name;
            this.drawableId = drawableId;
            this.drawableId1=drawableId1;
        }
    }
}
