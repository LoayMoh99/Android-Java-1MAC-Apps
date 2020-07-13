package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("red","lutti",R.drawable.color_red,R.raw.color_red));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView =  findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
