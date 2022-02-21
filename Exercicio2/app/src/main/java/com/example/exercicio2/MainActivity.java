package com.example.exercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public EditText res;

    public void Send(View view)
    {
        res = findViewById(R.id.textid);

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("data", res.getText().toString());
        startActivity(i);
    }
}