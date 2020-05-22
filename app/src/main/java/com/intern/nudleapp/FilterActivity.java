package com.intern.nudleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {
    private Chip chipTrending,chipNewArrivals,chipBestSelling;
    private Chip chipLtoH,chipHtoL;
    private Button btnApply;
    private ArrayList<String> selectedChipData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        chipTrending= findViewById(R.id.chipTrending);
        chipNewArrivals= findViewById(R.id.chipNewArrival);
        chipBestSelling= findViewById(R.id.chipBestSelling);

        chipLtoH=findViewById(R.id.chipLtoH);
        chipHtoL=findViewById(R.id.chipHtoL);

        selectedChipData=new ArrayList<>();
        CompoundButton.OnCheckedChangeListener checkedChangeListener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    selectedChipData.add(buttonView.getText().toString());
                }
                else {
                    selectedChipData.remove(buttonView.getText().toString());
                }
            }
        };
        chipTrending.setOnCheckedChangeListener(checkedChangeListener);
        chipNewArrivals.setOnCheckedChangeListener(checkedChangeListener);
        chipBestSelling.setOnCheckedChangeListener(checkedChangeListener);
        chipLtoH.setOnCheckedChangeListener(checkedChangeListener);
        chipHtoL.setOnCheckedChangeListener(checkedChangeListener);

        btnApply=findViewById(R.id.btnApply);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent=new Intent();
                resultIntent.putExtra("data",selectedChipData.toString());
                setResult(101,resultIntent);
                finish();
            }
        });
    }
}
