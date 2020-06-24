package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtQuestion;
    private Button btnTrue;
    private Button btnWrong;
    private int mQuestionIndex;
    private int mQuizQuestion;
    private ProgressBar mProgressBar;
    private TextView mQuizStatsTextView;
    private int mUserScore;

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
    final int USER_PROGRESS = (int) Math.ceil(100.0 / questionCollection.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtQuestion = findViewById(R.id.txtQuestion);

        QuizModel q1 = questionCollection[mQuestionIndex];

        mQuizQuestion = q1.getQuestion();

        mTxtQuestion.setText(mQuizQuestion);

        mProgressBar = findViewById(R.id.quizPB);

        mQuizStatsTextView = findViewById(R.id.txtQuizStats);

        btnTrue = findViewById(R.id.btnTrue);

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateUsersAnswer(true);
                changeQuestionOnButtonClick();


            }
        });

         btnWrong = findViewById(R.id.btnWrong);

        btnWrong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                evaluateUsersAnswer(false);
                changeQuestionOnButtonClick();



            }
        });


    }

    private void changeQuestionOnButtonClick(){
        // 5 % 10 = 5 - 1 % 4 = 1

        // 0 = 1 % 10 = 1
        // 1 = 2 % 10 = 2
        // 9 = 9 + 1 = 10 -  10 % 10 = 0
        mQuestionIndex = (mQuestionIndex + 1) % 10; // 1 = 1 + 1 => 2
        mQuizQuestion = questionCollection[mQuestionIndex].getQuestion();
        mTxtQuestion.setText(mQuizQuestion);
        mProgressBar.incrementProgressBy(USER_PROGRESS);
        mQuizStatsTextView.setText(mUserScore + "");



    }

    private void evaluateUsersAnswer(boolean userGuess){
        boolean currentQuestionAnswer = questionCollection[mQuestionIndex].isAnswer();

        if(currentQuestionAnswer == userGuess){
            Toast.makeText(getApplicationContext(), R.string.correct_toast_message, Toast.LENGTH_SHORT).show();

            mUserScore = mUserScore + 1 ;

        }else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_text, Toast.LENGTH_SHORT ).show();
        }

    }

}