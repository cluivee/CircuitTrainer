package com.cliveke.workouttimer;


import android.os.CountDownTimer;

public abstract class Counter extends CountDownTimer
{
    private int counterId;

    public Counter(int counterId /*counter id start with 0*/,long millisInFuture, long countDownInterval)
    {
        super(millisInFuture, countDownInterval);
        this.counterId = counterId;
    }


    public abstract void onTick(long millisUntilFinished);

    public void onFinish()
    {
//        playSound(sound_id_1);
//        runMyMethod(user_input_1);
        counterId++;
    }


}
