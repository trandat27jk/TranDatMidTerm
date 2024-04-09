package com.midterm.trandat2;// ScoreActivity.java
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTextView = findViewById(R.id.score_text_view);

        // Get the score from the intent
        int score = getIntent().getIntExtra("score", 0);

        // Display the score
        scoreTextView.setText("Score: " + score);
    }
}
