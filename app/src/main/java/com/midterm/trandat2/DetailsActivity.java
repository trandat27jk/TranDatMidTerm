package com.midterm.trandat2;// DetailsActivity.java
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    private TextView scoreTextView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        scoreTextView = findViewById(R.id.score_text_view);
        listView = findViewById(R.id.list_view);

        // Get the questions, answers, and score from the intent
        String[] questions = getIntent().getStringArrayExtra("questions");
        boolean[] answers = getIntent().getBooleanArrayExtra("answers");
        int score = getIntent().getIntExtra("score", 0);

        // Display the score
        scoreTextView.setText("Score: " + score);

        // Prepare the list of questions and answers
        String[] items = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            items[i] = questions[i] + "\nAnswer: " + (answers[i] ? "True" : "False");
        }

        // Display the questions and answers
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }
}
