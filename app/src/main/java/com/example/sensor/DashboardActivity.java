package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
   private Button btnshowall, btnaccelerometer, btngrroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnshowall=findViewById(R.id.showall);
        btnaccelerometer=findViewById(R.id.accelerometer);
        btngrroscope=findViewById(R.id.gyroscope);

        btnshowall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DashboardActivity.this,MainActivity.class );
                startActivity(intent);
            }
        });

        btnaccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,AccelerometerActivity.class);
                startActivity(intent);
            }
        });

        btngrroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,GyroscopeActivity.class);
                startActivity(intent);
            }
        });
    }
}
