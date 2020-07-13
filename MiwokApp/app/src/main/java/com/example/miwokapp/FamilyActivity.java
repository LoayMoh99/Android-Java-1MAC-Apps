package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("baba","lutti",R.drawable.family_father,R.raw.family_father));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView =  findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
