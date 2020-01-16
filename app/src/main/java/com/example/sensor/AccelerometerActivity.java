package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AccelerometerActivity extends AppCompatActivity {
    private TextView tvaccelerometer;
    private SensorManager sensormanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        tvaccelerometer= findViewById(R.id.tvaccelerometer);
        sensormanager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                String xAxis = "x : " + values[0];
                String yAxis = "y :" + values[1];
                String zAxis = "z :" + values[2];

                tvaccelerometer.setText(xAxis + "" + yAxis + "" + zAxis);

            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {


            }
        };
        if (sensor!= null){
            sensormanager.registerListener(sensorEventListener, sensor,sensormanager.SENSOR_DELAY_NORMAL);
        }
        else {
            Toast.makeText(this, "No sensor found", Toast.LENGTH_SHORT).show();
        }
    }
}
