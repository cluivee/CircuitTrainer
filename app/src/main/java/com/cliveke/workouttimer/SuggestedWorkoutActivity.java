package com.cliveke.workouttimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuggestedWorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_workout);
    }

    public void upperBodyClick(View view) {
        Intent upperIntent = new Intent(SuggestedWorkoutActivity.this, UpperBodyActivity.class);
        startActivity(upperIntent);
    }

    public void lowerBodyClick(View view) {
        Intent lowerIntent = new Intent(SuggestedWorkoutActivity.this, LowerBodyActivity.class);
        startActivity(lowerIntent);
    }
}
