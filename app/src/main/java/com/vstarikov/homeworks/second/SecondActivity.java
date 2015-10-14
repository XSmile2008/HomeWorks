package com.vstarikov.homeworks.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vstarikov.homeworks.R;

/**
 * Created by vladstarikov on 14.10.15.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final EditText editTextN = (EditText) findViewById(R.id.editTextN);
        final TextView textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);

        Button buttonFibonacci = (Button) findViewById(R.id.buttonFibonacci);
        buttonFibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewAnswer.setText(String.valueOf(fibonachi(Integer.parseInt(editTextN.getText().toString()))));
            }
        });

        Button buttonFactorial = (Button) findViewById(R.id.buttonFactorial);
        buttonFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewAnswer.setText(String.valueOf(factorial(Integer.parseInt(editTextN.getText().toString()))));
            }
        });
    }

    public static int fibonachi(int n) {
        int f_2 = 1;
        int f_1 = 1;
        int f = 1;
        for (int i = 2; i < n; i++) {
            f = f_1 + f_2;
            f_2 = f_1;
            f_1 = f;
        }
        return f;
    }

    public static int factorial(int n) {
        int f = 1;
        if (n == 0) return 0;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }
}
