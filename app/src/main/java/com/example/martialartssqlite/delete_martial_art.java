package com.example.martialartssqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.martialartssqlite.model.DBHandler;
import com.example.martialartssqlite.model.MartialArt;

import java.util.ArrayList;

public class delete_martial_art extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private DBHandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_martial_art);

        dbhandler = new DBHandler(delete_martial_art.this);
        updateTheUserInterface();
    }

    private void updateTheUserInterface(){
        ArrayList<MartialArt> allMartialArt = dbhandler.returnAllmartialArtObjects();
        RelativeLayout relativeLayout = new RelativeLayout(delete_martial_art.this);
        ScrollView scrollView = new ScrollView(delete_martial_art.this);
        RadioGroup radioGroup = new RadioGroup(delete_martial_art.this);

        for (MartialArt martialArt: allMartialArt) {
            RadioButton currentRadioButton = new RadioButton(delete_martial_art.this);
            currentRadioButton.setId(martialArt.getMartialArtId());
            currentRadioButton.setText(martialArt.toString());
            radioGroup.addView(currentRadioButton);
        }
        radioGroup.setOnCheckedChangeListener(delete_martial_art.this);
        Button btnBack = new Button(delete_martial_art.this);
        btnBack.setText("Go Back");
        btnBack.setOnClickListener(delete_martial_art.this);

        scrollView.addView(radioGroup);
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0,0,0,70);

        relativeLayout.addView(btnBack, buttonParams);
        ScrollView.LayoutParams scrollViewParams = new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.MATCH_PARENT);
        relativeLayout.addView(scrollView, scrollViewParams);

        setContentView(relativeLayout);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        dbhandler.deleteMartialArtObjectById(checkedId);
        Toast.makeText(delete_martial_art.this, "Martial Art Object is deleted", Toast.LENGTH_SHORT).show();
        updateTheUserInterface();
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}