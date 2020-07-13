package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
         final ArrayList<Word> words = new ArrayList<>();
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));
         words.add(new Word("phraseOne","phrase_lutti",R.raw.phrase_are_you_coming));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView =  findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
