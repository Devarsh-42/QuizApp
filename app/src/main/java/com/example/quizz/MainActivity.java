package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizz.databinding.ActivityMainBinding;
import com.example.quizz.model.Questions;

public class MainActivity extends AppCompatActivity {
    private int CurrQuesIdx = 0;
    int score = 0;
    private ActivityMainBinding binding;
    private Questions[] NextQuestion = new Questions[]{
            new Questions(R.string.question_amendments,false),
            new Questions(R.string.question_declaration,true),
            new Questions(R.string.question_constitution,true),
            new Questions(R.string.question_government,false),
            new Questions(R.string.question_religion,true),
            new Questions(R.string.question_government_feds,false),
            new Questions(R.string.question_independence_rights,true),
            new Questions(R.string.question_government_senators,false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        binding.textView.setText(NextQuestion[CurrQuesIdx].getAnswerID());
        binding.nextButton.setOnClickListener(view -> {
            CurrQuesIdx = (CurrQuesIdx + 1) % NextQuestion.length;//CurrQuesIdx++
            binding.showAnswer.setVisibility(View.INVISIBLE);
            updateQuestion();
        });

            binding.backButton.setOnClickListener(view -> {
                if(CurrQuesIdx > 0){
                    CurrQuesIdx = (CurrQuesIdx - 1) % NextQuestion.length;//CurrQuesIdx++
                    binding.showAnswer.setVisibility(View.INVISIBLE);
                    updateQuestion();
            }
        });
        binding.trueButton.setOnClickListener(view -> {
            if(checkAnswer(true)){
                binding.showAnswer.setTextColor(getResources().getColor(R.color.green));
                score++;
                binding.showAnswer.setVisibility(View.VISIBLE);
            }else{
                score--;
                binding.showAnswer.setTextColor(getResources().getColor(R.color.red));
                binding.showAnswer.setVisibility(View.VISIBLE);
            }
        });
        binding.falseButton.setOnClickListener(view -> {
            if(checkAnswer(false)){
                binding.showAnswer.setTextColor(getResources().getColor(R.color.green));
                score++;
                binding.showAnswer.setVisibility(View.VISIBLE);
            }else{
                score--;
                binding.showAnswer.setTextColor(getResources().getColor(R.color.red));
                binding.showAnswer.setVisibility(View.VISIBLE);
            }
        });
        binding.Score.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, YourScore.class);
            intent.putExtra("key",score);
            startActivity(intent);
        });
    }

    public boolean checkAnswer(boolean userChoice){
        boolean correctAnswer = NextQuestion[CurrQuesIdx].getAnswerTrue();
        int messageID;

        if(correctAnswer == userChoice){
            messageID = R.string.correct_answer;
            binding.showAnswer.setText(messageID);
            Toast.makeText(this,"Great Job!",Toast.LENGTH_SHORT).show();
            return true;

        }else{
            messageID = R.string.wrong_answer;
            binding.showAnswer.setText(messageID);
            Toast.makeText(this,"Incorrect, Try Again!",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    private void updateQuestion() {
        //Pulling sn object form our array
        binding.textView.setText(NextQuestion[CurrQuesIdx].getAnswerID());
    }
}