package com.example.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static  final int REQUEST_ANSWER=10;
    static final String QUESTION_KEY = "question";

    private EditText askQuestion;
    private Button buttonQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askQuestion = (EditText)findViewById(R.id.askQuestion);
        buttonQuestion = (Button)findViewById(R.id.buttonQuestion);

        buttonQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AnswerTheQuestionActivity.class);
                intent.putExtra(QUESTION_KEY, askQuestion.getText().toString());
                startActivityForResult(intent, REQUEST_ANSWER);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_ANSWER) {
            if (resultCode == RESULT_OK) {
                String textOfAnswer = data.getStringExtra("answer");
                TextView answer = (TextView)findViewById(R.id.answer);
                answer.setText(textOfAnswer);
            }
        }
    }


}
