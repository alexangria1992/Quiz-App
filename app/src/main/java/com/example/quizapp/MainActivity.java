package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtQuestion;
    private Button btnTrue;
    private Button btnWrong;
    private int mQuestionIndex;
    private QuizModel[] questionCollection = new QuizModel[]{
            new QuizModel(R.string.q1, true),
            new QuizModel(R.string.q2, false),
            new QuizModel(R.string.q3, true),
            new QuizModel(R.string.q4, false),
            new QuizModel(R.string.q5, true),
            new QuizModel(R.string.q6, false),
            new QuizModel(R.string.q7, true),
            new QuizModel(R.string.q8, false),
            new QuizModel(R.string.q9, true),
            new QuizModel(R.string.q10, false),

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtQuestion = findViewById(R.id.txtQuestion);

        QuizModel q1 = questionCollection[mQuestionIndex];

        mTxtQuestion.setText(q1.getQuestion());
         btnTrue = findViewById(R.id.btnTrue);

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

         btnWrong = findViewById(R.id.btnWrong);

        btnWrong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "btn Wrong is tapped now!", Toast.LENGTH_SHORT).show();

            }
        });


    }

}