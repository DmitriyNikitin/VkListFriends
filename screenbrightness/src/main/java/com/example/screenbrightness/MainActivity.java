package com.example.screenbrightness;

import android.Manifest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String screenBrightness;
    String screenBrightness2;
    TextView cardFlipButton;
    final String MAX_SCREEN_BRIGHTNESS = "255";
    final int PERMISSION_REQUEST_CODE = 10;
    boolean hideAlertDialog = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_SETTINGS);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
            new AlertDialog.Builder(this).
                    setTitle("Внимание!").
                    setMessage("Для улучшения считывания штрих-кода необходимо увеличить яркость экрана. Для этого может потребоваться изменить настройки телефона").
                    setPositiveButton("Настройки", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent appSettingsIntent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                                    Uri.parse("package:" + getPackageName()));
                            startActivityForResult(appSettingsIntent, PERMISSION_REQUEST_CODE);
                        }
                    }).
                    setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).
                    show();
            }else{
            Toast.makeText(this, "Диалог скрыт", Toast.LENGTH_LONG).show();
        }


        cardFlipButton = (TextView) findViewById(R.id.cardFlipButton);
        cardFlipButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                            screenBrightness = android.provider.Settings.System.getString(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
                            android.provider.Settings.System.putString(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, MAX_SCREEN_BRIGHTNESS);
                        screenBrightness2 = android.provider.Settings.System.getString(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);

                        Toast.makeText(MainActivity.this, screenBrightness2, Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:

                            android.provider.Settings.System.putString(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screenBrightness);

                        break;
                    case MotionEvent.ACTION_CANCEL:

                            android.provider.Settings.System.putString(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screenBrightness);
                        screenBrightness2 = android.provider.Settings.System.getString(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
                        Toast.makeText(MainActivity.this, screenBrightness2, Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });


    }

}








