package com.midterm.trandat2;// MainActivity.java
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.midterm.trandat2.R;

public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button prevButton;
    private Button submitButton;
    private TextView questionTextView;

    private String[] questions = {"Canberra is the capital of Australia.", "The Pacific Ocean is larger than the Atlantic Ocean."};
    private boolean[] answers = {true, true};
    private int currentIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        submitButton = findViewById(R.id.submit_button);
        questionTextView = findViewById(R.id.question_text_view);

        questionTextView.setText(questions[currentIndex]);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                trueButton.setBackgroundColor(Color.GREEN);
                falseButton.setBackgroundColor(Color.RED);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                trueButton.setBackgroundColor(Color.RED);
                falseButton.setBackgroundColor(Color.GREEN);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % questions.length;
                questionTextView.setText(questions[currentIndex]);
                resetButtonColors();  // Reset the button colors
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex - 1 + questions.length) % questions.length;
                questionTextView.setText(questions[currentIndex]);
                resetButtonColors();  // Reset the button colors
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("questions", questions);
                intent.putExtra("answers", answers);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });

    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = answers[currentIndex];

        if (userAnswer == correctAnswer) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetButtonColors() {
        // Reset the button colors to the default
        trueButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_purple));
        falseButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_purple));
    }
}
