package edu.upc.eseiaat.pma.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private int id_answers[]={
        R.id.answer1,R.id.answer2,R.id.answer3,R.id.answer4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView text_question = (TextView) findViewById(R.id.text_question);
        text_question.setText(R.string.question_content);

        String[] answers= getResources().getStringArray(R.array.answers);

        for(int i=0;i<id_answers.length;i++){
            RadioButton rb= (RadioButton) findViewById(id_answers[i]);
            rb.setText(answers[i]);
        }

        final int correct_answer= getResources().getInteger(R.integer.correct_answer);

        final RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);

        Button btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = group.getCheckedRadioButtonId();
                int respuesta = -1;
                for(int i=0;i<id_answers.length;i++){
                    if(id_answers[i]== id){
                        respuesta = i;
                    }
                }
                if(respuesta==correct_answer){
                    Toast.makeText(QuizActivity.this, R.string.correct_ans, Toast.LENGTH_SHORT).show();
                }
                else if(respuesta==-1){
                    Toast.makeText(QuizActivity.this, R.string.no_ans, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this, R.string.incorrect_ans, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
