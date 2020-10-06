package com.example.library;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class CountDownAlert extends Dialog {

    private int i = 0;

    public CountDownAlert(Context context) {
        this(context, 3);
    }

    public CountDownAlert(Context context, int initialNumber) {
        super(context, R.style.count_dialog);
        i = initialNumber;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_dialog);
        final TextView tv = findViewById(R.id.count_tv);

        new CountDownTimer(1000 * i, 1000) {
            public void onTick(long millisUntilFinished) {
                if (i != 0) {
                    tv.setText(String.valueOf(i));
                    --i;
                }
            }

            public void onFinish() {
                dismiss();
            }
        }.start();

    }
}
