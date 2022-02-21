package com.example.parte2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor light;
    private Sensor gyro;

    TextView lightValue;
    TextView gyroValue;
    TextView gyro1Value;
    TextView gyro2Value;
    TextView gyro3Value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = findViewById(R.id.light);
        gyroValue = findViewById(R.id.gyro);
        gyro1Value = findViewById(R.id.gyro1);
        gyro2Value = findViewById(R.id.gyro2);
        gyro3Value = findViewById(R.id.gyro3);


        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);

        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if(light != null)
        {
            sensorManager.registerListener(MainActivity.this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightValue.setText("Light sensor not supported");
        }

        if (gyro != null)
        {
            sensorManager.registerListener(MainActivity.this, gyro,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            gyroValue.setText("Gyroscope sensor not supported");
        }

        Button getGPSBtn = findViewById(R.id.getGPSBtn);
        ActivityCompat.requestPermissions(MainActivity.this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!=null)
                {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: "+ lat + "\n" + "LONG: " +
                            longi, Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText("Light Intensity: " + event.values[0]);
        }
        if(sensor.getType() == Sensor.TYPE_GYROSCOPE)
        {
            gyroValue.setText("Gyroscope Values: " + event.values[0] + " " + event.values[1] + " " + event.values[2]);
        }
    }

}