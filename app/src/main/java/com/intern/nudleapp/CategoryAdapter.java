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
public class CategoryAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;



    public CategoryAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new Item("women",       R.drawable.cat1));
        mItems.add(new Item("Men",  R.drawable.cat2));
        mItems.add(new Item("shoes", R.drawable.cat6));
        mItems.add(new Item("electronics",      R.drawable.cat5));
        mItems.add(new Item("kids",     R.drawable.cat3));
        mItems.add(new Item("traditional",      R.drawable.cat4));
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

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private static class Item {
        public final String name;
        public final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}
