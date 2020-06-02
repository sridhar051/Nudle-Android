package com.intern.nudleapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        productList = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        productList.add(
                new Product(
                        1,
                        "women shopping",
                        "sale",
                        4.3,
                        60000,
                        R.drawable.womenfashion));

        productList.add(
                new Product(
                        1,
                        "men shopping",
                        "girls",
                        4.3,
                        60000,
                        R.drawable.menfashion));
        productList.add(
                new Product(
                        1,
                        "kids shopping",
                        "boys",
                        4.3,
                        60000,
                        R.drawable.kidsfashion));
        productList.add(
                new Product(
                        1,
                        "jewellery shopping",
                        "shoes",
                        4.3,
                        60000,
                        R.drawable.jewellery));

        productList.add(
                new Product(
                        1,
                        "electronic items",
                        "electronics",
                        4.3,
                        60000,
                        R.drawable.shop2));




        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(getContext(), productList, (ProductAdapter.OnProductListener) getContext());

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);




        return view;

    }
}