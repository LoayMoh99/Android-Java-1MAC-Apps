package com.example.miwokapp;

public class Word {
    private String mEnglishWord;
    private String mMiwokWord;
    private int mImageId=-1;
    private int mAudioId;

    public Word(String englishWord ,String miwokWord,int audioId){
        mEnglishWord=englishWord;
        mMiwokWord=miwokWord;
        mAudioId=audioId;
    }

    public Word(String englishWord ,String miwokWord,int imageId,int audioId){
        mEnglishWord=englishWord;
        mMiwokWord=miwokWord;
        mImageId=imageId;
        mAudioId=audioId;
    }

    public String getmEnglishWord(){
        return mEnglishWord;
    }

    public String getmMiwokWord(){
        return mMiwokWord;
    }

    public int getmImageId(){
        return mImageId;
    }

    public int getmAudionId(){
        return mAudioId;
    }
}
