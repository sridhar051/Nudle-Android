package com.intern.nudleapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intern.nudleapp.userAccount.CartAdapter;
import com.intern.nudleapp.userAccount.CartItemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCartFragment extends Fragment {

    public MyCartFragment() {
        // Required empty public constructor
    }
private RecyclerView cartitemsrecyclerview ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_cart, container, false);
        cartitemsrecyclerview=view.findViewById(R.id.cartitems_recycler_view);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getContext());
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        cartitemsrecyclerview.setLayoutManager(layoutmanager);


        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.googlepixel3a,"Pixel 3a",2,"Rs.49999/-","Rs.59999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.googlepixel3a,"Pixel 3a",0,"Rs.49999/-","Rs.59999/-",1,1,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.googlepixel3a,"Pixel 3a",2,"Rs.49999/-","Rs.59999/-",1,2,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3) items","Rs.1699999/-","Free","Rs.1699999/-","Rs.5999/-"));


        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartitemsrecyclerview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        return view;
    }
}
