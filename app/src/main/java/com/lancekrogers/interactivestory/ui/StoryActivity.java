package com.lancekrogers.interactivestory.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lancekrogers.interactivestory.R;
import com.lancekrogers.interactivestory.model.Page;
import com.lancekrogers.interactivestory.model.Story;

import java.util.Random;


public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();

    private ImageView mImageView;

    private TextView mTextView;

    private Button mChoice1;

    private Button mChoice2;

    private String mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));


        if (mName == null) {
            mName = "Friend";
        }
        Log.d(TAG, mName);


        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);
        loadPage();
    }

    private void loadPage() {
        Random randInt = new Random();
        Page page = mStory.getPage(randInt.nextInt(6));
        int imageId = page.getImageId();
        Drawable drawable = ContextCompat.getDrawable(this, imageId);
        mImageView.setImageDrawable(drawable);
        // Add the users name to the story
        String pageText = page.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        mChoice1.setText(page.getChoice1().getText());
        mChoice2.setText(page.getChoice2().getText());
    }

}
