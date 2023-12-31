// YourScore.java
package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class YourScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_score);

        TextView scoreTextView = findViewById(R.id.Your_score);
        Intent intent = getIntent();

        if (intent != null) {
            int score = intent.getIntExtra("key", 0);
            scoreTextView.setText(String.valueOf(score));

            // Set content description dynamically
            String contentDescription = "Your current score is " + score;
            scoreTextView.setContentDescription(contentDescription);
        }
    }
}
