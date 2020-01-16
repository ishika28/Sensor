package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GyroscopeActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private EditText etgyro, etsub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        etgyro=findViewById(R.id.etgyro);
        etsub=findViewById(R.id.etsub);
        sensorGyro();

    }
    private void sensorGyro(){

        sensorManager= (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SensorEventListener gyroListener= new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[1] <0){
                    etgyro.setVisibility(View.VISIBLE);
                    etgyro.setText("Left");
                    etsub.setVisibility(View.GONE);
                }
                else {
                    etsub.setVisibility(View.VISIBLE);
                    etsub.setText("Right");
                    etgyro.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        if (sensor!= null){
            sensorManager.registerListener(gyroListener, sensor, sensorManager.SENSOR_DELAY_NORMAL);


        }
        else {
            Toast.makeText(this, "No Sensor found", Toast.LENGTH_SHORT).show();
        }

    }
}
