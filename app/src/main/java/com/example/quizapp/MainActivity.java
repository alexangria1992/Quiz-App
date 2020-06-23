package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTrue = findViewById(R.id.btnTrue);
        View.OnClickListener myClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btnTrue){
                    Log.i("MyApp", "btn true is tapped now!");
                }
            }
        };
        btnTrue.setOnClickListener(myClickListener);

        Button btnWrong = findViewById(R.id.btnWrong);

        btnWrong.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.i("MyApp", "btn Wrong is tapped now");
            }
        });


    }
}