package com.example.projecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = findViewById(R.id.result_sum);

        et1 = (EditText) findViewById(R.id.txt_number1); // ID from component
        Toast.makeText(this, "Value: " + et1.getText().toString(), Toast.LENGTH_SHORT).show();

        et2 = (EditText) findViewById(R.id.txt_number2); // ID from component
        Toast.makeText(this, "Value: " + et2.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void sum(View view){

        int result = Integer.parseInt(et1.getText().toString().trim()) + Integer.parseInt(et2.getText().toString().trim());
        r.setText(String.valueOf(result));


    }
}