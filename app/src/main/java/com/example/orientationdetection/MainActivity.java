package com.example.orientationdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView acce1,acce2, acce3;
    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acce1 = findViewById(R.id.acce1);
        acce2 = findViewById(R.id.acce2);
        acce3 = findViewById(R.id.acce3);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity.this,sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged (SensorEvent sensorEvent){
        float value0, value1,value2;
        value0 = sensorEvent.values[0];
        value1 = sensorEvent.values[1];
        value2 = sensorEvent.values[2];

        acce1.setText("X-Axis" + value0);
        acce2.setText("Y-Axis" + value1);
        acce3.setText("Z-Axis" + value2);

        if (value0 > 0){
            Toast.makeText(this,"Device orientation turned landscape left",Toast.LENGTH_SHORT).show();
        } else if (value0 < 0) {
            Toast.makeText(this,"Device Orientation turned landscape right",Toast.LENGTH_SHORT).show();
        } else if (value0 == 0) {
            Toast.makeText(this,"Device Orientation is potrait",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Implement this method as needed for your application
    }
}