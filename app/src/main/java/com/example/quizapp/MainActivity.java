package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTrue = findViewById(R.id.btnTrue);
        View.OnClickListener myClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnTrue) {
                    Toast myToastObject = Toast.makeText(getApplicationContext(), "btn True is tapped now!", Toast.LENGTH_LONG);
                    myToastObject.show();
                }
            }
        };
        btnTrue.setOnClickListener(myClickListener);

        Button btnWrong = findViewById(R.id.btnWrong);

        btnWrong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "btn Wrong is tapped now!", Toast.LENGTH_SHORT).show();

            }
        });
    }

}