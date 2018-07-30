package com.bignerdranch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton, mFalseButton, mNextButton, mPrevButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };
    private int mCurrIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mTrueButton = (Button)findViewById(R.id.button_true);
        mFalseButton = (Button)findViewById(R.id.button_false);
        mNextButton = (Button)findViewById(R.id.button_next);
        mPrevButton = (Button)findViewById(R.id.button_prev);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {checkAnswer(true);}
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {checkAnswer(false);}
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrIdx = (mCurrIdx ==  mQuestionBank.length - 1) ? 0 : mCurrIdx + 1;
                updateQuestion();
            }
        });
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrIdx = (mCurrIdx == 0) ?  mQuestionBank.length - 1 : mCurrIdx - 1;
                updateQuestion();
            }
        });
        updateQuestion();
    }
    private void updateQuestion(){mQuestionTextView.setText(mQuestionBank[mCurrIdx].getTextResId());}
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrIdx].isAnswerTrue();
        int msgResId = (userPressedTrue == answerIsTrue) ? R.string.correct_toast : R.string.incorrect_toast;
        Toast.makeText(this, msgResId, Toast.LENGTH_LONG).show();
    }
}
