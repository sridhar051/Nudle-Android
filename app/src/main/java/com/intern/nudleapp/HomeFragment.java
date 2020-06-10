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
    List<Product> traditionallist;

    private int[] mimages = new int[]{
            R.drawable.offer, R.drawable.c16, R.drawable.c14
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        productList = new ArrayList<>();
        traditionallist=new ArrayList<>();


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

        traditionallist.add(
                new Product(
                        1,
                        "50% OFF",
                        "sale",
                        4.3,
                        60000,
                        R.drawable.traditional1));

        traditionallist.add(
                new Product(
                        1,
                        "SHOP NOW",
                        "sale",
                        4.3,
                        60000,
                        R.drawable.traditional2));

        traditionallist.add(
                new Product(
                        1,
                        "25% OFF",
                        "sale",
                        4.3,
                        60000,
                        R.drawable.traditional3));

        traditionallist.add(
                new Product(
                        1,
                        "SHOP NOW",
                        "sale",
                        4.3,
                        60000,
                        R.drawable.traditional4));

        traditionallist.add(
                new Product(
                        1,
                        "80% OFF",
                        "sale",
                        4.3,
                        60000,
                        R.drawable.traditional5));




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
        ProductAdapter adapter1 = new ProductAdapter(getContext(), traditionallist, (ProductAdapter.OnProductListener) getContext());
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        recyclerView1.setAdapter(adapter1);


        return view;

    }

}