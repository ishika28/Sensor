package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private TextView tvSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSensor=findViewById(R.id.tvSensor);

        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList =sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i =0; i< sensorList.size(); i++){
            String sensor="";
            sensor += sensorList.get(i).getName() + "\n";
            tvSensor.append(sensor);
        }
    }
}
