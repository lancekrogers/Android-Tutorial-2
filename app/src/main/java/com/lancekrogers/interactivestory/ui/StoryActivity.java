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


public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();

    private ImageView mImageView;

    private TextView mTextView;

    private Button mChoice1;

    private Button mChoice2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));


        if (name == null) {
            name = "Friend";
        }
        Log.d(TAG, name);


        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);
    }

    private void loadPage() {
        Page page = mStory.getPage(0);

        Drawable drawable = ContextCompat.getDrawable(null, page.getImageId());
        mImageView.setImageDrawable(drawable);

        mTextView.setText(page.getText());

        mChoice1.setText(page.getChoice1().getText());
        mChoice2.setText(page.getChoice2().getText());
    }

}
