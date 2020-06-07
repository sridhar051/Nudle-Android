package com.intern.nudleapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomgoodsAdapter extends RecyclerView.Adapter<CustomgoodsAdapter.ProductViewHolder>{
    private Context mCtx;

    private CustomgoodsAdapter.OnProductListener onProductListener;

    //we are storing all the products in a list
    private List<Product> productList;

    //getting the context and product list with constructor
    public CustomgoodsAdapter(Context mCtx, List<Product> productList, CustomgoodsAdapter.OnProductListener onProductListener) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.onProductListener = onProductListener;
    }

    @Override
    public CustomgoodsAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.customgoods_listitem, null);
        return new CustomgoodsAdapter.ProductViewHolder(view, onProductListener);
    }

    @Override
    public void onBindViewHolder(CustomgoodsAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Product product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCtx.startActivity(new Intent(mCtx,ProductDetailsActivity.class));
            }
        });

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        LinearLayout item;
        ImageView imageView;
        CustomgoodsAdapter.OnProductListener onProductListener;

        public ProductViewHolder(View itemView, CustomgoodsAdapter.OnProductListener onProductListener) {
            super(itemView);
            this.onProductListener = onProductListener;
            textViewTitle = itemView.findViewById(R.id.product_name);
            textViewShortDesc = itemView.findViewById(R.id.ShortDesc);
            textViewRating = itemView.findViewById(R.id.rating);
            textViewPrice = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.photo);
            item=itemView.findViewById(R.id.linear_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onProductListener.onProductClick();
        }
    }

    public interface OnProductListener{
        void onProductClick();
    }
}
