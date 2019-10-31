package com.example.task1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerTheQuestionActivity extends AppCompatActivity {

    static final String ANSWER_KEY = "answer";
    static final String EXIT_KEY = "exit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_the_question);

        final Button buttonAnswer = (Button)findViewById(R.id.button);
        final TextView question = (TextView)findViewById(R.id.receiveText);

        String textOfQuestion = getIntent().getStringExtra(MainActivity.QUESTION_KEY);
        question.setText(textOfQuestion);

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputAnswer = (EditText)findViewById(R.id.inputText);
                Intent returnIntent = new Intent();
                returnIntent.putExtra(ANSWER_KEY, inputAnswer.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    @Override
    public void finishAndRemoveTask(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra(EXIT_KEY, EXIT_KEY);
        setResult(Activity.RESULT_OK, returnIntent);
        super.finishAndRemoveTask();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.exit:
                ExitDialog exitDialog = new ExitDialog();
                exitDialog.show(this.getSupportFragmentManager(), "dialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
