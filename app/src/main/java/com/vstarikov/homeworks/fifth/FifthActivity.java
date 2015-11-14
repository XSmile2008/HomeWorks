package com.vstarikov.homeworks.fifth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.vstarikov.homeworks.R;

/**
 * Created by vladstarikov on 05.11.15.
 */
public class FifthActivity extends AppCompatActivity implements View.OnClickListener{

    Animation animationFadeIn;
    Animation animationFadeOut;
    Animation animationBounce;
    Animation animationRotate;
    Animation animationSlideUp;
    Animation animationSlideDown;
    Animation animationCombo;

    TextView animatedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        animatedTextView = (TextView) findViewById(R.id.animatedTextView);

        animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        animationCombo = AnimationUtils.loadAnimation(this, R.anim.combo);

        findViewById(R.id.buttonAnimation1).setOnClickListener(this);
        findViewById(R.id.buttonAnimation2).setOnClickListener(this);
        findViewById(R.id.buttonAnimation3).setOnClickListener(this);
        findViewById(R.id.buttonAnimation4).setOnClickListener(this);
        findViewById(R.id.buttonAnimation5).setOnClickListener(this);
        findViewById(R.id.buttonAnimation6).setOnClickListener(this);
        findViewById(R.id.buttonAnimation7).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.buttonAnimation1:
                animatedTextView.startAnimation(animationFadeIn);
                break;
            case R.id.buttonAnimation2:
                animatedTextView.startAnimation(animationFadeOut);
                break;
            case R.id.buttonAnimation3:
                animatedTextView.startAnimation(animationBounce);
                break;
            case R.id.buttonAnimation4:
                animatedTextView.startAnimation(animationRotate);
                break;
            case R.id.buttonAnimation5:
                animatedTextView.startAnimation(animationSlideUp);
                break;
            case R.id.buttonAnimation6:
                animatedTextView.startAnimation(animationSlideDown);
                break;
            case R.id.buttonAnimation7:
                animatedTextView.startAnimation(animationCombo);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
