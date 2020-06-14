package com.intern.nudleapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Customgoods_Fragment extends Fragment {
    RecyclerView recyclerView;
    List<Product> productList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cust_goods, container, false);

        productList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recyclerview_customgoods);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        productList.add(
                new Product(
                        1,
                        "Teen blue T-shirt",
                        "Mega - sale",
                        4.1,
                        500,
                        R.drawable.tshirt));

        productList.add(
                new Product(
                        2,
                        "Classy Mobile Case Genric",
                        "iPhone 6/7/8",
                        4.5,
                        350,
                        R.drawable.backcase));
        productList.add(
                new Product(
                        1,
                        "Teen blue shirt",
                        "Savage Sale",
                        4.0,
                        600,
                        R.drawable.tshirt1));
        productList.add(
                new Product(
                        1,
                        "Black Round tees(Reebok)",
                        "Early sale",
                        4.3,
                        350,
                        R.drawable.tshirt2));
        productList.add(
                new Product(
                        1,
                        "Stylish Mobile case",
                        "Poco F1",
                        4.8,
                        400,
                        R.drawable.mobilecase1png));



        //creating recyclerview adapter
        CustomgoodsAdapter adapter = new CustomgoodsAdapter(getContext(), productList, (CustomgoodsAdapter.OnProductListener) getContext());

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return view;

    }
}