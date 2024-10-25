package com.example.w7_lab;

import com.example.w7_lab.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main2Activity extends AppCompatActivity {
    private EditText set_drink;
    private RadioGroup rg1, rg2;
    private Button btn_send;

    private String sugar = "sugar";
    private String ice_opt = "no ice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rg1 = findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener((radioGroup, i) -> {
            if ( i == R.id.radioButton1){
                sugar = "no sugar";
            }else if ( i == R.id.radioButton2){
                sugar = "less sugar";
            }else if ( i == R.id.radioButton3){
                sugar = "half sugar";
            }else if ( i == R.id.radioButton4){
                sugar = "regular sugar";
            }
        });

        rg1 = findViewById(R.id.radioGroup2);
        rg1.setOnCheckedChangeListener((radioGroup, i) -> {
            if ( i == R.id.radioButton5){
                sugar = "no ice";
            }else if ( i == R.id.radioButton6){
                sugar = "less ice";
            }else if ( i == R.id.radioButton7){
                sugar = "half ice";
            }else if ( i == R.id.radioButton8){
                sugar = "regular ice";
            }
        });

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(view -> {
            set_drink = findViewById(R.id.ed_drink);
            String drink = set_drink.getText().toString();
            Intent i = new Intent();
            Bundle b = new Bundle();
            b.putString("drink", drink);
            b.putString("sugar", sugar);
            b.putString("ice", ice_opt);
            i.putExtras(b);
            setResult(Activity.RESULT_OK, i);
            finish();
        });
    }
}