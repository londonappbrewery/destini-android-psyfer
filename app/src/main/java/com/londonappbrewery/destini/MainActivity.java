package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView Questions;
    Button Answer1;
    Button Answer2;
    int mStoryIndex;
    int mButtonStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonStatus=2;

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        Questions = findViewById(R.id.storyTextView);
        Answer1 = findViewById(R.id.buttonTop);
        Answer2 = findViewById(R.id.buttonBottom);

        if(savedInstanceState != null){
            mStoryIndex=savedInstanceState.getInt("StoryIndex");
        }else{
            mStoryIndex=0;
        }
        updateScreen(mStoryIndex,mButtonStatus);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScreen(mStoryIndex,1);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        Answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScreen(mStoryIndex,0);
            }

        });
    }

    private void updateScreen(int Index, int bstatus) {
        if (bstatus == 1) {
            if (mStoryIndex == 0 || mStoryIndex == 2) {
                Questions.setText(R.string.T3_Story);
                Answer1.setText(R.string.T3_Ans1);
                Answer2.setText(R.string.T3_Ans2);
                mStoryIndex = 3;
            } else if (mStoryIndex == 3) {
                Questions.setText(R.string.T6_End);
                Answer1.setVisibility(View.GONE);
                Answer2.setVisibility(View.GONE);
            }
        } else if (bstatus == 0) {
            if (mStoryIndex == 0) {
                Questions.setText(R.string.T2_Story);
                Answer1.setText(R.string.T2_Ans1);
                Answer2.setText(R.string.T2_Ans2);
                mStoryIndex = 2;
            } else if (mStoryIndex == 2) {
                Questions.setText(R.string.T4_End);
                Answer1.setVisibility(View.GONE);
                Answer2.setVisibility(View.GONE);
                mStoryIndex = 4;
            } else if (mStoryIndex == 3) {
                Questions.setText(R.string.T5_End);
                Answer1.setVisibility(View.GONE);
                Answer2.setVisibility(View.GONE);
            }


        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndex", mStoryIndex);
    }
}
