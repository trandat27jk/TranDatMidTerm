package com.midterm.trandat2;// QuizContract.java
import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract() {}

    public static class QuestionTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_ANSWER = "answer";
    }
}
