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
    RecyclerView recyclerView1;
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

        recyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerview1);

        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        productList.add(
                new Product(
                        1,
                        "SHOP NOW",
                        "boys",
                        4.3,
                        60000,
                        R.drawable.h5));

        productList.add(
                new Product(
                        1,
                        "SHOP NOW",
                        "girls",
                        4.3,
                        60000,
                        R.drawable.h2));

        productList.add(
                new Product(
                        1,
                        "SHOP NOW",
                        "electronics",
                        4.3,
                        60000,
                        R.drawable.h3));
        productList.add(
                new Product(
                        1,
                        "SHOP NOW",
                        "sale",
                        4.3,
                        60000,
                        R.drawable.h4));


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
        recyclerView1.setAdapter(adapter);


        return view;

    }

}