package com.bignerdranch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton, mFalseButton;
    private ImageButton mNextButton, mPrevButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };
    private int mCurrIdx = 0;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INX = "index";

    @Override
    protected void onSaveInstanceState(Bundle savedInstaceState){
        super.onSaveInstanceState(savedInstaceState);
        Log.d("summer", "onSaveInstaceState");
        savedInstaceState.putInt(KEY_INX, mCurrIdx);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("summer", "onStart() called");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("summer", "onResume() called");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("summer", "onPause() called");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("summer", "onStop() called");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("summer", "onDestroy() called");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("summer", "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);
        if(savedInstanceState != null) mCurrIdx =  savedInstanceState.getInt(KEY_INX, 0);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mTrueButton = (Button)findViewById(R.id.button_true);
        mFalseButton = (Button)findViewById(R.id.button_false);

        mNextButton = (ImageButton)findViewById(R.id.button_next);

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
        updateQuestion();
    }
    private void updateQuestion(){mQuestionTextView.setText(mQuestionBank[mCurrIdx].getTextResId());}
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrIdx].isAnswerTrue();
        int msgResId = (userPressedTrue == answerIsTrue) ? R.string.correct_toast : R.string.incorrect_toast;
        Toast.makeText(this, msgResId, Toast.LENGTH_LONG).show();
    }
}
