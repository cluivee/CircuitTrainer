package com.cliveke.workouttimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void workoutActivity(View view) {
            Intent mainIntent = new Intent(MainActivity.this, WorkoutTimerActivity.class);
            startActivity(mainIntent);
    }

    public void suggestedWorkoutsClick(View view) {
        Intent suggestedIntent = new Intent(MainActivity.this, SuggestedWorkoutActivity.class);
        startActivity(suggestedIntent);
    }

    public void aboutClick(View view) {
        Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(aboutIntent);
    }

}
