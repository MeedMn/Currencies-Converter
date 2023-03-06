package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
public class MainActivity extends AppCompatActivity{
    private EditText currency1,currency2;
    private Button convert1;
    private Spinner spinner1,spinner2;
    private final String[] currencies = new String[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencies[0]="USD";
        currencies[1]="Euro";
        currencies[2]="MAD";
        ArrayAdapter<String> spinnerData = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, currencies);
        currency1 = findViewById(R.id.currecy1);
        currency2 = findViewById(R.id.currecy2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner1.setAdapter(spinnerData);
        spinner2.setAdapter(spinnerData);
        convert1 = findViewById(R.id.button2);
        convert1.setOnClickListener(view->{
            double v = getChange(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),Double.parseDouble(String.valueOf(currency1.getText())));
            currency2.setText(String.valueOf(v));
        });
    }
    private double getChange(String currency1,String currency2,double inserted){
        switch (currency1){
            case "USD":
                if(currency2.equals("USD")){return inserted;}
                else if (currency2.equals("Euro")){return inserted*0.94;}
                else{return inserted*10;}
            case "Euro":
                if(currency2.equals("USD")){return inserted/0.94;}
                else if (currency2.equals("Euro")){return inserted;}
                else{return inserted*11;}
            case "MAD":
                if(currency2.equals("USD")){return inserted/10;}
                else if (currency2.equals("Euro")){return inserted/11;}
                else {return inserted;}
            default:
                return 0;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}