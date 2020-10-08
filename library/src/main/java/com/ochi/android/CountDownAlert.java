package com.ochi.android;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class CountDownAlert extends Dialog {

    private int i = 0;
    private Runnable completion;
    private TextView countTv;

    public CountDownAlert(Context context) {
        super(context, R.style.count_dialog);
        i = 3;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_dialog);
        countTv = findViewById(R.id.count_tv);
    }

    public CountDownAlert setInitialNumber(int number) {
        i = number;
        return this;
    }

    public CountDownAlert setCompletion(Runnable runnable) {
        completion = runnable;
        return this;
    }

    public void show() {
        new CountDownTimer(1000 * i, 1000) {
            public void onTick(long millisUntilFinished) {
                if (i != 0) {
                    countTv.setText(String.valueOf(i));
                    --i;
                }
            }

            public void onFinish() {
                dismiss();
                if (completion != null) completion.run();
            }
        }.start();
        super.show();
    }
}
