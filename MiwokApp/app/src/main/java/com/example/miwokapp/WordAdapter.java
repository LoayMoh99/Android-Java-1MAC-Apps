package com.example.miwokapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorId;
    public WordAdapter(Context context, ArrayList<Word> objects ,int colorId) {
        super(context, 0, objects);
        mColorId=colorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = listItemView.findViewById(R.id.englishNum);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getmEnglishWord());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView =  listItemView.findViewById(R.id.miwokNum);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getmMiwokWord());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView =  listItemView.findViewById(R.id.image_view);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if(currentWord.getmImageId()!=-1) {
            iconView.setImageResource(currentWord.getmImageId());
        }
        else{
            iconView.setVisibility(View.GONE);
        }

        LinearLayout textVerticalLL = listItemView.findViewById(R.id.text_vertical_layout_view);
        int color= ContextCompat.getColor(getContext(),this.mColorId);
        textVerticalLL.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
