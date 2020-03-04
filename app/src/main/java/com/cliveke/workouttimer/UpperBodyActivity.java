package com.cliveke.workouttimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.TimerTask;

public class UpperBodyActivity extends AppCompatActivity {

    TextView timerTextView;
    int progressInt = 0;
    int timerId;
    Button controllerButton;

    Button addButton;
    Button removeButton;

    int counterIsActive = 0; // 0 = initial, 1 = active, 2 = paused, 3 = finished

    ProgressBar mProgressBar;
    EditText editText;
    ScrollView scrollView;

    int totalNumberExercises = 10;

    float volumeFloat = (float) (Math.log(50 - 25) / Math.log(50));

    CountDownTimer countDownTimer;
    int currentTime2;
    Chronometer chronometer;
    long timeWhenStopped = 0;

    // total Time isn't used yet
    int totalTime;
    int mPauseTimeRemaining;
    int timeAtStart = 1;

    EditText timeMinsEditText;
    EditText timeSecsEditText;

    EditText timeMinsEditText3;
    EditText timeSecsEditText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_body);

        controllerButton = (Button) findViewById(R.id.startButton2);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        addButton= (Button) findViewById(R.id.addButton);
        removeButton= (Button) findViewById(R.id.removeButton);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setTypeface(ResourcesCompat.getFont(this, R.font.baloo_bhai));

        // Setting InputFilters

        timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET1);
        timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET1);

        timeMinsEditText.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText2 = (EditText) findViewById(R.id.restMinsEditText);
        EditText timeSecsEditText2 = (EditText) findViewById(R.id.restSecsEditText);

        timeMinsEditText2.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText2.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        timeMinsEditText3 = (EditText) findViewById(R.id.greenMinsEditText);
        timeSecsEditText3 = (EditText) findViewById(R.id.greenSecsEditText);

        timeMinsEditText3.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText3.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText4 = (EditText) findViewById(R.id.restMinsET2);
        EditText timeSecsEditText4 = (EditText) findViewById(R.id.restSecsET2);

        timeMinsEditText4.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText4.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText5 = (EditText) findViewById(R.id.blueMinsEditText);
        EditText timeSecsEditText5 = (EditText) findViewById(R.id.blueSecsEditText);

        timeMinsEditText5.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText5.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        ///
        EditText timeMinsEditText6 = (EditText) findViewById(R.id.restMinsET3);
        EditText timeSecsEditText6 = (EditText) findViewById(R.id.restSecsET3);

        timeMinsEditText6.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText6.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText7 = (EditText) findViewById(R.id.exerciseMinsET4);
        EditText timeSecsEditText7 = (EditText) findViewById(R.id.exerciseSecsET4);

        timeMinsEditText7.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText7.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText8 = (EditText) findViewById(R.id.restMinsET4);
        EditText timeSecsEditText8 = (EditText) findViewById(R.id.restSecsET4);

        timeMinsEditText8.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText8.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText9 = (EditText) findViewById(R.id.exerciseMinsET5);
        EditText timeSecsEditText9 = (EditText) findViewById(R.id.exerciseSecsET5);

        timeMinsEditText9.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText9.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText10 = (EditText) findViewById(R.id.restMinsET5);
        EditText timeSecsEditText10 = (EditText) findViewById(R.id.restSecsET5);

        timeMinsEditText10.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText10.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText11 = (EditText) findViewById(R.id.exerciseMinsET6);
        EditText timeSecsEditText11 = (EditText) findViewById(R.id.exerciseSecsET6);

        timeMinsEditText11.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText11.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText12 = (EditText) findViewById(R.id.restMinsET6);
        EditText timeSecsEditText12 = (EditText) findViewById(R.id.restSecsET6);

        timeMinsEditText12.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText12.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText13 = (EditText) findViewById(R.id.exerciseMinsET7);
        EditText timeSecsEditText13 = (EditText) findViewById(R.id.exerciseSecsET7);

        timeMinsEditText13.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText13.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText14 = (EditText) findViewById(R.id.restMinsET7);
        EditText timeSecsEditText14 = (EditText) findViewById(R.id.restSecsET7);

        timeMinsEditText14.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText14.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText15 = (EditText) findViewById(R.id.exerciseMinsET8);
        EditText timeSecsEditText15 = (EditText) findViewById(R.id.exerciseSecsET8);

        timeMinsEditText15.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText15.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText16 = (EditText) findViewById(R.id.restMinsET8);
        EditText timeSecsEditText16 = (EditText) findViewById(R.id.restSecsET8);

        timeMinsEditText16.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText16.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText17 = (EditText) findViewById(R.id.exerciseMinsET9);
        EditText timeSecsEditText17 = (EditText) findViewById(R.id.exerciseSecsET9);

        timeMinsEditText17.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText17.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText18 = (EditText) findViewById(R.id.restMinsET9);
        EditText timeSecsEditText18 = (EditText) findViewById(R.id.restSecsET9);

        timeMinsEditText18.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText18.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText19 = (EditText) findViewById(R.id.exerciseMinsET10);
        EditText timeSecsEditText19 = (EditText) findViewById(R.id.exerciseSecsET10);

        timeMinsEditText19.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText19.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

        EditText timeMinsEditText20 = (EditText) findViewById(R.id.restMinsET10);
        EditText timeSecsEditText20 = (EditText) findViewById(R.id.restSecsET10);

        timeMinsEditText20.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
        timeSecsEditText20.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

    }

    //Code for onClick of Start Button
    public void timerButtonOnClick(View view) {

        Log.i("CounterIsActive", String.valueOf(counterIsActive));

        switch (counterIsActive) {
            case 0:
                timerId = 1;
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET1);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET1);
                if (TextUtils.isEmpty(timeSecsEditText.getText()) && TextUtils.isEmpty(timeMinsEditText.getText())) {
                    return;
                }
                addButton.setClickable(false);
                removeButton.setClickable(false);
                counterIsActive = 1;

                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();

                startTimer(1);

                break;
            case 1:
                // Counter is currently running so run this code. Current text should be "Pause" and this will pause the time

                Log.i("pausedTimerId", String.valueOf(timerId));
                mPauseTimeRemaining = currentTime2;
                countDownTimer.cancel();
                controllerButton.setText("Resume");
                addButton.setClickable(true);
                removeButton.setClickable(true);
                counterIsActive = 2;
                timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
                chronometer.stop();

                break;
            case 2:
                // Counter is paused so run this code. Current Text should be "Resume"

                currentTime2 = mPauseTimeRemaining;
                addButton.setClickable(false);
                removeButton.setClickable(false);
                countDownTimerMethod(mProgressBar, editText);
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();

                counterIsActive = 1;

                break;
            case 3:
                // Counter is finished so run this code to start the timer again
                countDownTimer.cancel();
                addButton.setClickable(true);
                removeButton.setClickable(true);
                controllerButton.setText("Start");
                counterIsActive = 0;

                break;
        }
    }

    public void addButtonClick(View view) {
        if (totalNumberExercises < 20) {
            totalNumberExercises++;
        }
        Log.i("totalNoExercises", String.valueOf(totalNumberExercises));
        RelativeLayout relativeLayout;
        switch (totalNumberExercises) {
            case 1:
                break;
            case 2:
                relativeLayout = findViewById(R.id.RL2);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 3:
                relativeLayout = findViewById(R.id.RL3);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 4:
                relativeLayout = findViewById(R.id.RL4);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 5:
                relativeLayout = findViewById(R.id.RL5);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 6:
                relativeLayout = findViewById(R.id.RL6);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 7:
                relativeLayout = findViewById(R.id.RL7);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 8:
                relativeLayout = findViewById(R.id.RL8);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 9:
                relativeLayout = findViewById(R.id.RL9);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 10:
                relativeLayout = findViewById(R.id.RL10);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 11:
                relativeLayout = findViewById(R.id.RL11);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 12:
                relativeLayout = findViewById(R.id.RL12);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 13:
                relativeLayout = findViewById(R.id.RL13);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 14:
                relativeLayout = findViewById(R.id.RL14);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 15:
                relativeLayout = findViewById(R.id.RL15);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 16:
                relativeLayout = findViewById(R.id.RL16);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 17:
                relativeLayout = findViewById(R.id.RL17);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 18:
                relativeLayout = findViewById(R.id.RL18);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 19:
                relativeLayout = findViewById(R.id.RL19);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case 20:
                relativeLayout = findViewById(R.id.RL20);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void removeButtonClick(View view) {
        RelativeLayout relativeLayout;
        switch (totalNumberExercises) {
            case 1:
                break;
            case 2:
                relativeLayout = findViewById(R.id.RL2);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 3:
                relativeLayout = findViewById(R.id.RL3);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 4:
                relativeLayout = findViewById(R.id.RL4);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 5:
                relativeLayout = findViewById(R.id.RL5);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 6:
                relativeLayout = findViewById(R.id.RL6);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 7:
                relativeLayout = findViewById(R.id.RL7);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 8:
                relativeLayout = findViewById(R.id.RL8);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 9:
                relativeLayout = findViewById(R.id.RL9);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 10:
                relativeLayout = findViewById(R.id.RL10);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 11:
                relativeLayout = findViewById(R.id.RL11);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 12:
                relativeLayout = findViewById(R.id.RL12);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 13:
                relativeLayout = findViewById(R.id.RL13);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 14:
                relativeLayout = findViewById(R.id.RL14);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 15:
                relativeLayout = findViewById(R.id.RL15);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 16:
                relativeLayout = findViewById(R.id.RL16);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 17:
                relativeLayout = findViewById(R.id.RL17);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 18:
                relativeLayout = findViewById(R.id.RL18);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 19:
                relativeLayout = findViewById(R.id.RL19);
                relativeLayout.setVisibility(View.GONE);
                break;
            case 20:
                relativeLayout = findViewById(R.id.RL20);
                relativeLayout.setVisibility(View.GONE);
                break;
        }
        if (totalNumberExercises > 1) {
            totalNumberExercises--;
        }
        Log.i("totalNoExercises", String.valueOf(totalNumberExercises));
    }

    // General countDownTimerMethod
    public void countDownTimerMethod(final ProgressBar theProgressBar, final EditText editText) {

        if (TextUtils.isEmpty(timeSecsEditText.getText()) && TextUtils.isEmpty(timeMinsEditText.getText())) {
            MediaPlayer mplayer5 = MediaPlayer.create(getApplicationContext(), R.raw.finishloud);
            mplayer5.setVolume(1, 1);
            mplayer5.start();
            timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
            chronometer.stop();
            Log.i("case2", "2");
            return;
        } else if ((timerId & 1) != 0) {
            //odd timerId
            MediaPlayer mplayer3 = MediaPlayer.create(getApplicationContext(), R.raw.startloud);
            mplayer3.start();
            Log.i("case3", "3");

        } else if ((timerId & 1) == 0) {
            //even timerId
            MediaPlayer mplayer4 = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
            mplayer4.start();
            Log.i("case4", "4");
        }

        countDownTimer = new CountDownTimer(currentTime2 * 1000 + 5, 50) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished / 1000);

                Log.i("progress", String.valueOf(progressInt));
                theProgressBar.setProgress(progressInt * 5 / timeAtStart);
                scrollToView(scrollView, theProgressBar);
                progressInt++;
            }

            @Override
            public void onFinish() {
                countDownTimer.cancel();
                controllerButton.setText("Reset");
                counterIsActive = 3;

                theProgressBar.setProgress(100);
                editText.setTextSize(18);

                addButton.setClickable(true);
                removeButton.setClickable(true);

                Log.i("timerId", String.valueOf(timerId));

                if (timerId == totalNumberExercises) {
                    MediaPlayer mplayer2 = MediaPlayer.create(getApplicationContext(), R.raw.finishloud);
                    mplayer2.setVolume(1, 1);
                    mplayer2.start();
                    timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
                    chronometer.stop();
                    Log.i("case1", "1");
                    return;
                }

                timerId++;
                startTimer(timerId);
            }
        }.start();

    }

    public void gettingTimeValuesFromEditText(EditText editTextMins, EditText editTextSecs) {

        if (TextUtils.isEmpty(editTextSecs.getText()) && TextUtils.isEmpty(editTextMins.getText())) {
            progressInt = 100;
            return;
        }
        counterIsActive = 1;
        controllerButton.setText("Pause");

        if (!TextUtils.isEmpty(editTextMins.getText()) && !TextUtils.isEmpty(editTextSecs.getText())) {
            int timeMinutes = Integer.parseInt(editTextMins.getText().toString());
            int timeSeconds = Integer.parseInt(editTextSecs.getText().toString());
            currentTime2 = timeSeconds + timeMinutes * 60;
            Log.i("timefull", String.valueOf(currentTime2));
        } else if (!TextUtils.isEmpty(editTextSecs.getText())) {
            int timeSeconds = Integer.parseInt(editTextSecs.getText().toString());
            currentTime2 = timeSeconds;
            Log.i("timesecs", String.valueOf(currentTime2));
        } else if (!TextUtils.isEmpty(editTextMins.getText())) {
            int timeMinutes = Integer.parseInt(editTextMins.getText().toString());
            currentTime2 = timeMinutes * 60;
            Log.i("timemins", String.valueOf(currentTime2));
        }

        if (currentTime2 > 0) {
            timeAtStart = currentTime2;
        }

    }

    private void startTimer(int paramTimerId) {

        switch (paramTimerId) {
            case 1:
                // this is starting the first red timer

                timerTextView = (TextView) findViewById(R.id.exerciseTimeTV1);
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET1);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET1);

                timeMinsEditText.setFilters(new InputFilter[]{new InputFilterMinMax(0, 99)});
                timeSecsEditText.setFilters(new InputFilter[]{new InputFilterMinMax(0, 59)});

                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB1);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET1);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;

            case 2:
                // this is starting the first rest grey timer

                timerTextView = (TextView) findViewById(R.id.restTimeTextView);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsEditText);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsEditText);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB1);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET1);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 3:

                // this is starting the 2nd green exercise timer

                timerTextView = (TextView) findViewById(R.id.greenTimeTextView);
                timeMinsEditText = (EditText) findViewById(R.id.greenMinsEditText);
                timeSecsEditText = (EditText) findViewById(R.id.greenSecsEditText);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB2);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET2);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;

            case 4:
                // this is starting the 2nd rest grey timer

                timerTextView = (TextView) findViewById(R.id.restTV2);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET2);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET2);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB2);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET2);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 5:
                // this is starting the 3rd blue exercise timer

                timerTextView = (TextView) findViewById(R.id.blueTimeTextView);
                timeMinsEditText = (EditText) findViewById(R.id.blueMinsEditText);
                timeSecsEditText = (EditText) findViewById(R.id.blueSecsEditText);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB3);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET3);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;

            case 6:
                // this is starting the 3rd rest grey timer

                timerTextView = (TextView) findViewById(R.id.restTV3);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET3);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET3);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB3);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET3);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;

            case 7:
                // start exercise 4 timer

                timerTextView = (TextView) findViewById(R.id.exerciseTimeTV4);
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET4);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET4);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB4);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET4);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;

            case 8:
                // start rest 4 timer
                timerTextView = (TextView) findViewById(R.id.restTV4);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET4);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET4);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB4);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET4);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);
                break;

            case 9:
                // start exercise 5 timer
                timerTextView = (TextView) findViewById(R.id.exerciseTimeTV5);
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET5);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET5);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB5);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET5);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;

            case 10:
                // start rest 5 timer
                timerTextView = (TextView) findViewById(R.id.restTV4);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET4);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET4);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB4);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET4);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;

            case 11:
                timerTextView = (TextView) findViewById(R.id.exerciseTimeTV6);
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET6);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET6);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB6);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET6);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 12:
                // start rest 6 timer
                timerTextView = (TextView) findViewById(R.id.restTV6);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET6);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET6);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB6);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET6);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 13:
                timerTextView = (TextView) findViewById(R.id.exerciseTimeTV7);
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET7);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET7);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB7);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET7);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 14:
                // start rest 7 timer
                timerTextView = (TextView) findViewById(R.id.restTV7);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET7);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET7);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB7);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET7);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 15:
                timerTextView = (TextView) findViewById(R.id.exerciseTimeTV8);
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET8);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET8);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB8);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET8);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 16:
                // start rest 8 timer
                timerTextView = (TextView) findViewById(R.id.restTV8);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET8);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET8);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB8);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET8);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 17:
                timerTextView = (TextView) findViewById(R.id.exerciseTimeTV9);
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET9);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET9);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB9);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET9);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 18:
                // start rest 9 timer
                timerTextView = (TextView) findViewById(R.id.restTV9);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET9);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET9);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB9);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET9);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 19:
                timerTextView = (TextView) findViewById(R.id.exerciseTimeTV10);
                timeMinsEditText = (EditText) findViewById(R.id.exerciseMinsET10);
                timeSecsEditText = (EditText) findViewById(R.id.exerciseSecsET10);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.exercisePB10);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.exerciseET10);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("EXERCISE");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
            case 20:
                // start rest 10 timer
                timerTextView = (TextView) findViewById(R.id.restTV10);
                timeMinsEditText = (EditText) findViewById(R.id.restMinsET10);
                timeSecsEditText = (EditText) findViewById(R.id.restSecsET10);
                progressInt = 0;

                gettingTimeValuesFromEditText(timeMinsEditText, timeSecsEditText);

                mProgressBar = (ProgressBar) findViewById(R.id.restPB10);
                mProgressBar.setProgress(progressInt);
                editText = (EditText) findViewById(R.id.restET10);
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setText("REST");
                }
                editText.setTextSize(32);

                countDownTimerMethod(mProgressBar, editText);

                break;
        }

    }


    public void updateTimer(int secondsleft) {

        currentTime2 = secondsleft;

        int minutes = (int) secondsleft / 60;
        int seconds = secondsleft - minutes * 60;

        String secondString = Integer.toString(seconds);

        if (seconds <= 9) {
            secondString = "0" + secondString;
        }

        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);


    }

    public void resetTimer2(View view) {

        if (counterIsActive == 1 || counterIsActive == 2 || counterIsActive == 3) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            mProgressBar.setProgress(100);
            countDownTimer.cancel();
            currentTime2 = 0;
            updateTimer(currentTime2);

            controllerButton.setText("Restart");
            addButton.setClickable(true);
            removeButton.setClickable(true);
            counterIsActive = 0;
            timerId = 1;

            if (!TextUtils.isEmpty(timeMinsEditText.getText()) && !TextUtils.isEmpty(timeSecsEditText.getText())) {
                int timeMinutes = Integer.parseInt(timeMinsEditText.getText().toString());
                int timeSeconds = Integer.parseInt(timeSecsEditText.getText().toString());
                currentTime2 = timeSeconds + timeMinutes * 60;
            } else if (!TextUtils.isEmpty(timeSecsEditText.getText())) {
                int timeSeconds = Integer.parseInt(timeSecsEditText.getText().toString());
                currentTime2 = timeSeconds;
            } else if (!TextUtils.isEmpty(timeMinsEditText.getText())) {
                int timeMinutes = Integer.parseInt(timeMinsEditText.getText().toString());
                currentTime2 = timeMinutes * 60;
            }

        }

    }

    /**
     * Used to scroll to the given view.
     *
     * @param scrollViewParent Parent ScrollView
     * @param view             View to which we need to scroll.
     */
    private void scrollToView(final ScrollView scrollViewParent, final View view) {
        // Get deepChild Offset
        Point childOffset = new Point();
        getDeepChildOffset(scrollViewParent, view.getParent(), view, childOffset);
        // Scroll to child.
        scrollViewParent.smoothScrollTo(0, childOffset.y);
    }

    /**
     * Used to get deep child offset.
     * <p/>
     * 1. We need to scroll to child in scrollview, but the child may not the direct child to scrollview.
     * 2. So to get correct child position to scroll, we need to iterate through all of its parent views till the main parent.
     *
     * @param mainParent        Main Top parent.
     * @param parent            Parent.
     * @param child             Child.
     * @param accumulatedOffset Accumulated Offset.
     */
    private void getDeepChildOffset(final ViewGroup mainParent, final ViewParent parent, final View child, final Point accumulatedOffset) {
        ViewGroup parentGroup = (ViewGroup) parent;
        accumulatedOffset.x += child.getLeft();
        accumulatedOffset.y += child.getTop();
        if (parentGroup.equals(mainParent)) {
            return;
        }
        getDeepChildOffset(mainParent, parentGroup.getParent(), parentGroup, accumulatedOffset);
    }


}
