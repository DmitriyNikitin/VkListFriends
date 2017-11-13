package com.example.auth18;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView signUpProfileBirthdayEditText;
    Calendar date = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       signUpProfileBirthdayEditText = (TextView)findViewById(R.id.signUpProfileBirthdayEditText);

        signUpProfileBirthdayEditText.setClickable(true);
        signUpProfileBirthdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year, month, dayOfMonth;
                final Calendar realTime;
                final Calendar maxDayBirthday;
                long maxDayBirthdayMili;
                realTime = Calendar.getInstance();
                maxDayBirthday = Calendar.getInstance();

                year = realTime.get(Calendar.YEAR) - 18;
                maxDayBirthday.set(Calendar.YEAR, realTime.get(Calendar.YEAR) - 18);
                maxDayBirthdayMili = maxDayBirthday.getTime().getTime();
                month = realTime.get(Calendar.MONTH);
                dayOfMonth = realTime.get(Calendar.DAY_OF_MONTH);

                final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        date = Calendar.getInstance();
                        date.set(year, month, dayOfMonth);
                        if (date.compareTo(maxDayBirthday) == -1) {
                            String dateText = new SimpleDateFormat("yyyy / MM / dd").format(MainActivity.this.date.getTime());
                            signUpProfileBirthdayEditText.setText(dateText);

                        }
                    }
                }, year, month, dayOfMonth);
   /*           datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(!date.after(maxDayBirthday))
                        {

                        }
                    }
                });
            */

                datePickerDialog.getDatePicker().setMaxDate(maxDayBirthdayMili);
                datePickerDialog.show();

                }


        });
    }
}
