package com.example.task1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerTheQuestionActivity extends AppCompatActivity {

    static final String ANSWER_KEY = "answer";

    private TextView question;
    private Button buttonAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_the_question);


        buttonAnswer = (Button)findViewById(R.id.buttonAnswer);

        question = (TextView)findViewById(R.id.question);
        String textOfQuestion = getIntent().getStringExtra(MainActivity.QUESTION_KEY);
        question.setText(textOfQuestion);

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputAnswer = (EditText)findViewById(R.id.inputAnswer);
                Intent returnIntent = new Intent();
                returnIntent.putExtra(ANSWER_KEY, inputAnswer.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
