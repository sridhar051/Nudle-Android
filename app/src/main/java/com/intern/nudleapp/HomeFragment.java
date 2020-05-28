package com.intern.nudleapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment{

    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;

    private int[] mimages = new int[]{
            R.drawable.sale1, R.drawable.sale2, R.drawable.sale3
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        productList = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        productList.add(
                new Product(
                        1,
                        "boys shopping",
                        "boys",
                        4.3,
                        60000,
                        R.drawable.shop1));

        productList.add(
                new Product(
                        1,
                        "girls shopping",
                        "girls",
                        4.3,
                        60000,
                        R.drawable.shop2));


        productList.add(
                new Product(
                        1,
                        "electronic items",
                        "electronics",
                        4.3,
                        60000,
                        R.drawable.sale2));


        CarouselView carouselView = view.findViewById(R.id.carousel);
        carouselView.setPageCount(mimages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mimages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {

            }
        });

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(getContext(), productList, (ProductAdapter.OnProductListener) getContext());

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);




        return view;

    }

}