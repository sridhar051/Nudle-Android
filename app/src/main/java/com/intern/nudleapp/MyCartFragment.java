package com.intern.nudleapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
//    private RecyclerView totalrecycler;
    private Toolbar toolbar;
    private Button continueBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_cart, container, false);
        cartitemsrecyclerview=view.findViewById(R.id.cartitems_recycler);
        continueBtn = view.findViewById(R.id.cart_continue_button);
//        LinearLayoutManager layoutmanager = new LinearLayoutManager(getContext());
//        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);

//        totalrecycler = (RecyclerView)view.findViewById(R.id.total_cart_recycler);

//        totalrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        cartitemsrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(R.drawable.googlepixel3a,"Pixel 3a",2,"Rs.49999/-","Rs.59999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(R.drawable.googlepixel3a,"Pixel 3a",0,"Rs.49999/-","Rs.59999/-",1,1,0));
        cartItemModelList.add(new CartItemModel(R.drawable.googlepixel3a,"Pixel 3a",2,"Rs.49999/-","Rs.59999/-",1,2,0));



        List<TotalModel> totalModelList = new ArrayList<>();
        totalModelList.add(new TotalModel("Rs.1699999/-","Free","Rs.1699999/-","Rs.5999/-"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartitemsrecyclerview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        View tot = (View)view.findViewById(R.id.total_cart);
        TextView tot_item_price = (TextView) tot.findViewById(R.id.total_items_price);
        TextView tot_del = (TextView)tot.findViewById(R.id.delivery_charge);
        TextView tot_total_amount = (TextView)tot.findViewById(R.id.total_amount);
        TextView tot_saved = (TextView)tot.findViewById(R.id.saved_amount);

        tot_item_price.setText(totalModelList.get(0).getTotalItemPrice());
        tot_del.setText(totalModelList.get(0).getDeliveryprice());
        tot_total_amount.setText(totalModelList.get(0).getTotalamount());
        String str = "You have saved RS:"+totalModelList.get(0).getSavedamount();
        tot_saved.setText(str);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deliveryIntent = new Intent(getContext(), DeliveryActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });
        return view;



    }
}
