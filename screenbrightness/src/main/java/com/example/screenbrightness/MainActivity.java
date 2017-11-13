package com.example.screenbrightness;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String screenBrightness;
    TextView cardFlipButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  screenBrightness = Settings.System.getString(getApplicationContext().getContentResolver(),Settings.System.SCREEN_BRIGHTNESS);
        cardFlipButton = (TextView)findViewById(R.id.cardFlipButton);
        cardFlipButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        screenBrightness = Settings.System.getString(getApplicationContext().getContentResolver(),Settings.System.SCREEN_BRIGHTNESS);
                        Settings.System.putInt(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
                        break;
                    case MotionEvent.ACTION_UP:
                            Settings.System.putString(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screenBrightness);
                            break;
                    case MotionEvent.ACTION_CANCEL:
                        Settings.System.putString(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screenBrightness);

                }
                return true;
            }
        });
    }
}
